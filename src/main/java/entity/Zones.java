package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Zones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZone;

    @Column(nullable = false, length = 50)
    private String zoneType;

    protected Zones(){};

    public Zones(String zoneType){
        this.zoneType = zoneType;
    }

    public Integer getIdZone() {return idZone;}
    public void setIdZone(Integer idZone) {this.idZone = idZone;}

    public String getZoneType() {return zoneType;}
    public void setZoneType(String zoneType) {this.zoneType = zoneType;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Zones zones = (Zones) o;
        return Objects.equals(idZone, zones.idZone);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idZone);
    }

    @Override
    public String toString() { return String.format("Zones{id=%d, '%s'}", idZone, zoneType); }
}
