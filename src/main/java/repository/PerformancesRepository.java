package repository;

import entity.Perfomances;
import util.HibernateUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class PerformancesRepository extends GenericRepository<Perfomances, Integer> {

    public PerformancesRepository() {
        super(Perfomances.class);
    }

    public List<Perfomances> findByDateTimeBetween(LocalDateTime from, LocalDateTime to) {
        try (EntityManager em = HibernateUtil.createEntityManager()) {
            return em.createQuery(
                            "SELECT p FROM Perfomances p " +
                                    "JOIN FETCH p.group " +
                                    "JOIN FETCH p.scene " +
                                    "WHERE p.startPerformance BETWEEN :from AND :to " +
                                    "ORDER BY p.startPerformance", Perfomances.class)
                    .setParameter("from", from)
                    .setParameter("to", to)
                    .getResultList();
        }
    }

    public List<Perfomances> findByGroupIdWithDetails(int groupId) {
        try (EntityManager em = HibernateUtil.createEntityManager()) {
            return em.createQuery(
                            "SELECT p FROM Perfomances p " +
                                    "JOIN FETCH p.group " +
                                    "JOIN FETCH p.scene " +
                                    "WHERE p.group.groupId = :groupId " +
                                    "ORDER BY p.startPerformance", Perfomances.class)
                    .setParameter("groupId", groupId)
                    .getResultList();
        }
    }
}
