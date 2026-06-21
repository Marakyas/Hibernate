package repository;

import entity.SponsorsInZones;
import entity.SponsorsInZonesId;
import util.HibernateUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class SponsorsInZonesRepository extends GenericRepository<SponsorsInZones, SponsorsInZonesId> {

    public SponsorsInZonesRepository() {
        super(SponsorsInZones.class);
    }

    public List<SponsorsInZones> findByZoneIdWithDetails(int zoneId) {
        try (EntityManager em = HibernateUtil.createEntityManager()) {
            return em.createQuery(
                            "SELECT sz FROM SponsorsInZones sz " +
                                    "JOIN FETCH sz.zone " +      // Подгружаем объект зоны
                                    "LEFT JOIN FETCH sz.sponsor " + // Используем LEFT, так как спонсор может быть null
                                    "JOIN FETCH sz.activity " +  // Подгружаем объект активности
                                    "WHERE sz.id.zoneId = :zoneId", SponsorsInZones.class)
                    .setParameter("zoneId", zoneId)
                    .getResultList();
        }
    }
}
