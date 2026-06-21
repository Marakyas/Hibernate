package services;

import util.HibernateUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class BusinessQueryService {

    public void RevenueByTicketType() {
        System.out.println("\n[Запрос 1] Распределение билетов по уровням доступа:");
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = """
                SELECT t.tpId.accessLevel, COUNT(t)
                FROM Ticket t
                GROUP BY t.tpId.accessLevel
                """;
            List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();
            for (Object[] row : results) {
                System.out.printf(" - Уровень доступа: %s | Продано: %d шт.%n", row[0], row[1]);
            }
        } catch (Exception e) {
            System.err.println("Ошибка в Запросе 1: " + e.getMessage());
        } finally { em.close(); }
    }

    public void TopClients() {
        System.out.println("\n[Запрос 2] Список зарегистрированных покупателей:");
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = """
                SELECT t.clntId.name, t.clntId.surname, COUNT(t)
                FROM Ticket t
                GROUP BY t.clntId.name, t.clntId.surname
                """;
            List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();
            for (Object[] row : results) {
                System.out.printf(" - Клиент: %s %s | Билетов в системе: %d%n", row[0], row[1], row[2]);
            }
        } catch (Exception e) {
            System.err.println("Ошибка в Запросе 2: " + e.getMessage());
        } finally { em.close(); }
    }

    public void ClientsWithoutTickets() {
        System.out.println("\n[Запрос 3] Список клиентов без покупок:");
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = """
                SELECT c.name, c.surname 
                FROM Client c 
                WHERE c.id NOT IN (SELECT t.clntId.id FROM Ticket t)
                """;
            List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();
            if (results.isEmpty()) {
                System.out.println(" - Все клиенты в базе имеют как минимум один билет.");
            } else {
                for (Object[] row : results) {
                    System.out.printf(" - Покупатель без билета: %s %s%n", row[0], row[1]);
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка в Запросе 3: " + e.getMessage());
        } finally { em.close(); }
    }

    public void ZonePopularity() {
        System.out.println("\n[Запрос 4] Доступность типов билетов по зонам фестиваля:");
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = """
                SELECT tz.zone.zoneType, COUNT(tz)
                FROM TicketToZone tz
                GROUP BY tz.zone.zoneType
                """;
            List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();
            for (Object[] row : results) {
                System.out.printf(" - Зона: %s | Доступно видов билетов: %d%n", row[0], row[1]);
            }
        } catch (Exception e) {
            System.err.println("Ошибка в Запросе 4: " + e.getMessage());
        } finally { em.close(); }
    }

    public void SponsorInvestmentsByZone() {
        System.out.println("\n[Запрос 5] Распределение спонсоров по зонам:");
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = """
                SELECT sz.zone.zoneType, sz.sponsor.sponsorName
                FROM SponsorsInZones sz
                """;
            List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();
            for (Object[] row : results) {
                System.out.printf(" - Зона проведения: %s | Спонсор зоны: %s%n", row[0], row[1]);
            }
        } catch (Exception e) {
            System.err.println("Ошибка в Запросе 5: " + e.getMessage());
        } finally { em.close(); }
    }
}
