package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer idTicket;

    @ManyToOne
    @JoinColumn(name = "clnt_id", nullable = false)
    private Client clntId;

    @ManyToOne
    @JoinColumn(name = "tp_id", nullable = false)
    private TicketType tpId;

    protected Ticket(){}

    public Ticket(Client clntId, TicketType tpId){
        this.tpId = tpId;
        this.clntId = clntId;
    }

    public Integer getIdTicket() {return idTicket;}
    public void setIdTicket(Integer idTicket) {this.idTicket = idTicket;}

    public Client getClntId() {return clntId;}
    public void setClntId(Client clntId) {this.clntId = clntId;}

    public TicketType getTpId() {return tpId;}
    public void setTpId(TicketType tpId) {this.tpId = tpId;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(idTicket, ticket.idTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idTicket);
    }

    @Override
    public String toString() {
        return String.format("Ticket{id=%d, tp_id=%d, clnt_id=%d,}",
                idTicket,
                tpId != null ? tpId.getType_id() : null,
                clntId != null ? clntId.getId() : null
        );
    }
}
