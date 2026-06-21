package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SponsorsInZonesId implements Serializable {

    @Column(name = "zone_id")
    private Integer zoneId;

    @Column(name = "sponsor_id")
    private Integer sponsorId; // Может быть null, Hibernate это поймет

    @Column(name = "activity_id")
    private Integer activityId;

    protected SponsorsInZonesId() {}

    public SponsorsInZonesId(Integer zoneId, Integer sponsorId, Integer activityId) {
        this.zoneId = zoneId;
        this.sponsorId = sponsorId;
        this.activityId = activityId;
    }

    public Integer getZoneId() { return zoneId; }
    public void setZoneId(Integer zoneId) { this.zoneId = zoneId; }

    public Integer getSponsorId() { return sponsorId; }
    public void setSponsorId(Integer sponsorId) { this.sponsorId = sponsorId; }

    public Integer getActivityId() { return activityId; }
    public void setActivityId(Integer activityId) { this.activityId = activityId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SponsorsInZonesId that = (SponsorsInZonesId) o;
        return Objects.equals(zoneId, that.zoneId) &&
                Objects.equals(sponsorId, that.sponsorId) &&
                Objects.equals(activityId, that.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zoneId, sponsorId, activityId);
    }

    @Override
    public String toString() {
        return String.format("SponsorsInZonesId{zone=%d, sponsor=%d, activity=%d}", zoneId, sponsorId, activityId);
    }
}
