package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Sponsors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSponsor;

    @Column(nullable = false, length = 255)
    private String sponsorName;

    protected Sponsors(){}

    public Sponsors(String sponsorName){
        this.sponsorName = sponsorName;
    }

    public Integer getIdSponsor() {return idSponsor;}
    public void setIdSponsor(Integer idSponsor) {this.idSponsor = idSponsor;}

    public String getSponsorName() {return sponsorName;}
    public void setSponsorName(String sponsorName) {this.sponsorName = sponsorName;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sponsors sponsors = (Sponsors) o;
        return Objects.equals(idSponsor, sponsors.idSponsor) && Objects.equals(sponsorName, sponsors.sponsorName);
    }

    @Override
    public int hashCode() {return Objects.hash(idSponsor, sponsorName);}

    @Override
    public String toString() { return String.format("Sponsors{id=%d, '%s'}", idSponsor, sponsorName); }
}
