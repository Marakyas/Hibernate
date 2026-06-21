package util;

import entity.*;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;

public class DataSeeder {

    public static void seedData() {
        System.out.println("\n[DataSeeder] Наполнение базы данных тестовыми данными...");

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(3);
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();

            Zones vipZone = new Zones("VIP");
            em.persist(vipZone);

            Zones fanZone = new Zones("standard");
            em.persist(fanZone);

            Sponsors sponsorA = new Sponsors("Альфа-Банк");
            em.persist(sponsorA);

            Activities activities = new Activities("Попойка", start, end);
            em.persist(activities);

            TicketType vipType = new TicketType("VIP", start, end);
            em.persist(vipType);

            Client client1 = new Client("Иван", "Иванов", "IvanPivas@gmail.com");
            em.persist(client1);

            Ticket ticket1 = new Ticket(client1, vipType);
            em.persist(ticket1);

            em.flush();

            SponsorsInZonesId sponsorsInZonesId = new SponsorsInZonesId(
                    vipZone.getIdZone(),
                    sponsorA.getIdSponsor(),
                    activities.getActivityId()
            );
            SponsorsInZones sz1 = new SponsorsInZones(sponsorsInZonesId, vipZone, sponsorA, activities);
            em.persist(sz1);

            TicketToZoneId ticketToZoneId = new TicketToZoneId(
                    vipZone.getIdZone(),
                    vipType.getType_id()
            );
            TicketToZone tz1 = new TicketToZone(ticketToZoneId, vipZone, vipType);
            em.persist(tz1);

            em.getTransaction().commit();
            System.out.println("[DataSeeder] База данных успешно заполнена!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Ошибка при заполнении базы: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
