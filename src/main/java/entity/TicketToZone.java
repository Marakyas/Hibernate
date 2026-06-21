package entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket_to_zone", schema = "public")
public class TicketToZone {

    @EmbeddedId
    private TicketToZoneId id; // Наш составной ключ

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", insertable = false, updatable = false)
    private Zones zone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private TicketType ticketType;

    protected TicketToZone() {}

    public TicketToZone(TicketToZoneId id, Zones zone, TicketType ticketType) {
        this.id = id;
        this.zone = zone;
        this.ticketType = ticketType;
    }

    public TicketToZoneId getId() { return id; }
    public void setId(TicketToZoneId id) { this.id = id; }

    public Zones getZone() { return zone; }
    public void setZone(Zones zone) { this.zone = zone; }

    public TicketType getTicketType() { return ticketType; }
    public void setTicketType(TicketType ticketType) { this.ticketType = ticketType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketToZone that = (TicketToZone) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("TicketToZone{id=%s}", id);
    }
}
