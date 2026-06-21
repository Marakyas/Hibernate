package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class BuyTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Integer idTransaction;

    @Column(name = "transaction_time", nullable = false)
    private LocalDateTime transactionTime = LocalDateTime.now();

    @Column(nullable = false, length = 50)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "tckt_id", nullable = false)
    private Ticket tcktId;

    protected BuyTicket(){}

    public BuyTicket(LocalDateTime transactionTime, String paymentMethod, Ticket tcktId){
        this.transactionTime = transactionTime;
        this.paymentMethod = paymentMethod;
        this.tcktId = tcktId;
    }

    public Integer getIdTransaction() {return idTransaction;}
    public void setIdTransaction(Integer idTransaction) {this.idTransaction = idTransaction;}

    public LocalDateTime getTransactionTime() {return transactionTime;}
    public void setTransactionTime(LocalDateTime transactionTime) {this.transactionTime = transactionTime;}

    public String getPaymentMethod() {return paymentMethod;}
    public void setPaymentMethod(String paymentMethod) {this.paymentMethod = paymentMethod;}

    public Ticket getTcktId() {return tcktId;}
    public void setTcktId(Ticket tcktId) {this.tcktId = tcktId;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BuyTicket buyTicket = (BuyTicket) o;
        return Objects.equals(idTransaction, buyTicket.idTransaction);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idTransaction);
    }

    @Override
    public String toString() {
        return String.format("BuyTicket{id=%d, transactionTime=%s, paymentMethod='%s', ticketId = %d}",
                idTransaction,
                transactionTime,
                paymentMethod,
                tcktId != null ? tcktId.getIdTicket() : null
                );
    }
}
