import services.BusinessQueryService;
import services.CrudService;
import util.DataSeeder;
import java.util.Scanner;

public class ConsoleInterface {
    private final CrudService crudService = new CrudService();
    private final BusinessQueryService analytics = new BusinessQueryService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Заполнение базы данных...");
                    DataSeeder.seedData();
                    break;
                case "2":
                    System.out.println("Запуск демонстрации CRUD...");
                    crudService.runAll();
                    break;
                case "3":
                    runAnalyticsMenu();
                    break;
                case "0":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1. Заполнить базу данных");
        System.out.println("2. Демонстрация CRUD");
        System.out.println("3. Аналитические запросы");
        System.out.println("0. Выход");
        System.out.print("Выберите пункт: ");
    }

    private void runAnalyticsMenu() {
        System.out.println("\n--- АНАЛИТИКА ---");
        System.out.println("1. Выручка по типам билетов");
        System.out.println("2. Топ клиентов");
        System.out.println("3. Клиенты без билетов");
        System.out.println("4. Популярность зон");
        System.out.println("5. Инвестиции спонсоров по зонам");
        System.out.print("Выберите запрос: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1": analytics.RevenueByTicketType(); break;
            case "2": analytics.TopClients(); break;
            case "3": analytics.ClientsWithoutTickets(); break;
            case "4": analytics.ZonePopularity(); break;
            case "5": analytics.SponsorInvestmentsByZone(); break;
            default: System.out.println("Неверный пункт.");
        }
    }
}

