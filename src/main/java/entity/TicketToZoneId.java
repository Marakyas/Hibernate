package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TicketToZoneId implements Serializable {

    @Column(name = "zone_id")
    private Integer zoneId;

    @Column(name = "type_id")
    private Integer typeId;

    protected TicketToZoneId() {}

    public TicketToZoneId(Integer zoneId, Integer typeId) {
        this.zoneId = zoneId;
        this.typeId = typeId;
    }

    public Integer getZoneId() { return zoneId; }
    public void setZoneId(Integer zoneId) { this.zoneId = zoneId; }

    public Integer getTypeId() { return typeId; }
    public void setTypeId(Integer typeId) { this.typeId = typeId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketToZoneId that = (TicketToZoneId) o;
        return Objects.equals(zoneId, that.zoneId) && Objects.equals(typeId, that.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zoneId, typeId);
    }

    @Override
    public String toString() {
        return String.format("TicketToZoneId{zoneId=%d, typeId=%d}", zoneId, typeId);
    }
}
