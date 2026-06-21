package entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sponsors_in_zones", schema = "public")
public class SponsorsInZones {

    @EmbeddedId
    private SponsorsInZonesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", insertable = false, updatable = false)
    private Zones zone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sponsor_id", insertable = false, updatable = false)
    private Sponsors sponsor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id", insertable = false, updatable = false)
    private Activities activity;

    protected SponsorsInZones() {}

    public SponsorsInZones(SponsorsInZonesId id, Zones zone, Sponsors sponsor, Activities activity) {
        this.id = id;
        this.zone = zone;
        this.sponsor = sponsor;
        this.activity = activity;
    }

    public SponsorsInZonesId getId() { return id; }
    public void setId(SponsorsInZonesId id) { this.id = id; }

    public Zones getZone() { return zone; }
    public void setZone(Zones zone) { this.zone = zone; }

    public Sponsors getSponsor() { return sponsor; }
    public void setSponsor(Sponsors sponsor) { this.sponsor = sponsor; }

    public Activities getActivity() { return activity; }
    public void setActivity(Activities activity) { this.activity = activity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SponsorsInZones that = (SponsorsInZones) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("SponsorsInZones{id=%s}", id);
    }
}

