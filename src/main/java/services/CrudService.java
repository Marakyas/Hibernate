package services;

import repository.*;
import entity.*;

import java.time.LocalDateTime;
import java.util.List;


public class CrudService {

    private final ClientRepository clientRepo = new ClientRepository();
    private final GroupsRepository groupsRepo = new GroupsRepository();
    private final PerformancesRepository performancesRepo = new PerformancesRepository();
    private final TicketRepository ticketRepo = new TicketRepository();
    private final BuyTicketRepository buyTicketRepo = new BuyTicketRepository();

    private final GenericRepository<Equipment, Integer> equipRepo = new GenericRepository<>(Equipment.class);
    private final GenericRepository<TicketType, Integer> typeRepo = new GenericRepository<>(TicketType.class);

    public void demoCreate() {
        printHeader("CREATE — Создание записей");

        Client client = clientRepo.save(new Client("Алексей", "Горшенев", "alex_rock@event.ru"));
        System.out.printf("Создан клиент: id=%d, %s %s%n", client.getId(), client.getName(), client.getSurname());

        Groups group = groupsRepo.save(new Groups("Кукрыниксы", "Рок"));
        System.out.printf("Создана группа: id=%d, '%s', стиль: %s%n", group.getGroupId(), group.getGroupName(), group.getMusicStyle());

        Equipment equip = equipRepo.save(new Equipment("Акустическая система JBL"));
        System.out.printf("Добавлено оборудование: id=%d, '%s'%n", equip.getIdEquipment(), equip.getEquipmentType());

        printDivider();
    }

    public void demoRead() {
        printHeader("READ — Чтение данных");

        System.out.println("Все клиенты фестиваля:");
        List<Client> clients = clientRepo.findAll();
        System.out.printf("%-5s %-15s %-15s %-25s%n", "ID", "Имя", "Фамилия", "Email");
        System.out.println("     " + "─".repeat(65));
        for (Client c : clients) {
            System.out.printf("     %-5d %-15s %-15s %-25s%n",
                    c.getId(), c.getName(), c.getSurname(), c.getEmail());
        }

        System.out.println("\nМузыкальные группы:");
        List<Groups> groups = groupsRepo.findAll();
        System.out.printf("%-5s %-25s %-20s%n", "ID", "Название группы", "Стиль музыки");
        System.out.println("     " + "─".repeat(55));
        for (Groups g : groups) {
            System.out.printf("     %-5d %-25s %-20s%n",
                    g.getGroupId(), g.getGroupName(), g.getMusicStyle());
        }

        System.out.println("\nПоиск клиента по id=1:");
        clientRepo.findById(1).ifPresentOrElse(
                c -> System.out.println("Найдено: " + c),
                () -> System.out.println("Клиент с id=1 не найден")
        );

        printDivider();
    }

    public void demoUpdate() {
        printHeader("UPDATE — Обновление данных");


        clientRepo.findById(1).ifPresent(c -> {
            String oldEmail = c.getEmail();
            c.setEmail("festival_updated@mail.ru");
            Client updated = clientRepo.update(c);
            System.out.printf("  Обновлён email у клиента id=1: '%s' → '%s'%n", oldEmail, updated.getEmail());

        });

        printDivider();
    }

    public void demoDelete() {
        printHeader("DELETE — Удаление данных");

        Client temp = clientRepo.save(new Client("Временный", "Пользователь", "delete_me@event.ru"));
        System.out.printf("Создан временный клиент: id=%d%n", temp.getId());

        boolean deleted = clientRepo.deleteById(temp.getId());
        System.out.printf(" Удалён клиент id=%d (успех=%b)%n", temp.getId(), deleted);

        boolean notFound = clientRepo.deleteById(99999);
        System.out.printf(" Удаление несуществующего id=99999 (успех=%b)%n", notFound);

        printDivider();
    }

    public void demoTransaction() {
        printHeader("TRANSACTION — Покупка билета");
        System.out.println("Регистрация транзакции покупки билета наличными...");

        try {
            Client client = clientRepo.findById(1).orElseGet(() ->
                    clientRepo.save(new Client("Тест", "Транзакции", "tx_test@mail.ru"))
            );

            TicketType type = typeRepo.findById(1).orElseGet(() ->
                    typeRepo.save(new TicketType("VIP", LocalDateTime.now(), LocalDateTime.now().plusDays(1)))
            );

            Ticket ticket = ticketRepo.save(new Ticket(client, type));
            System.out.printf("Шаг 1: Оформлен билет! id=%d%n", ticket.getIdTicket());

            BuyTicket purchase = buyTicketRepo.save(new BuyTicket(LocalDateTime.now(), "cash", ticket));
            System.out.printf("Шаг 2: Проведена транзакция покупки! id=%d, способ: %s%n",
                    purchase.getIdTransaction(), purchase.getPaymentMethod());

            System.out.println("\nПроверяем историю бухгалтерии через кастомный метод репозитория...");
            List<BuyTicket> cashTransactions = buyTicketRepo.findByPaymentMethod("cash");
            System.out.printf("В базе успешно найдено транзакций со способом 'cash': %d%n", cashTransactions.size());

            buyTicketRepo.deleteById(purchase.getIdTransaction());
            ticketRepo.deleteById(ticket.getIdTicket());
            System.out.println("\nВременные транзакции успешно удалены из СУБД.");

        } catch (Exception e) {
            System.out.printf("Ошибка транзакции: %s%n", e.getMessage());
            e.printStackTrace();
        }

        printDivider();
    }

    public void runAll() {
        demoRead();
        demoCreate();
        demoUpdate();
        demoDelete();
        demoTransaction();
    }

    public static void printHeader(String title) {
        System.out.println();
        System.out.println("╔" + "═".repeat(title.length() + 4) + "╗");
        System.out.println("║  " + title + "  ║");
        System.out.println("╚" + "═".repeat(title.length() + 4) + "╝");
    }

    public static void printDivider() {
        System.out.println("─".repeat(80));
    }
}

