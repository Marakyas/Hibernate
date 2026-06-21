package repository;

import entity.BuyTicket;
import util.HibernateUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class BuyTicketRepository extends GenericRepository<BuyTicket, Integer> {

    public BuyTicketRepository() {
        super(BuyTicket.class);
    }

    public List<BuyTicket> findByPaymentMethod(String method) {
        try (EntityManager em = HibernateUtil.createEntityManager()) {
            return em.createQuery(
                            "SELECT b FROM BuyTicket b " +
                                    "JOIN FETCH b.tcktId " +
                                    "WHERE b.paymentMethod = :method", BuyTicket.class)
                    .setParameter("method", method)
                    .getResultList();
        }
    }
}

