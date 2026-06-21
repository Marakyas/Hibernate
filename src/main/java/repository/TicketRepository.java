package repository;

import entity.Ticket;
import util.HibernateUtil;
import jakarta.persistence.EntityManager;
import java.util.Optional;

public class TicketRepository extends GenericRepository<Ticket, Integer> {

    public TicketRepository() {
        super(Ticket.class);
    }

    public Optional<Ticket> findByIdWithDetails(int id) {
        try (EntityManager em = HibernateUtil.createEntityManager()) {
            return em.createQuery(
                            "SELECT t FROM Ticket t " +
                                    "JOIN FETCH t.clntId " +
                                    "JOIN FETCH t.tpId " +
                                    "WHERE t.idTicket = :id", Ticket.class)
                    .setParameter("id", id)
                    .getResultStream()
                    .findFirst();
        }
    }
}
