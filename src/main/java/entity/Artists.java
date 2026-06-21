package entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Artists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artistId;

    @Column(nullable = false, length = 50)
    private String artistName;

    @Column(nullable = false, length = 50)
    private String artistSurname;

    protected Artists() {}

    public Artists(String artistName, String artistSurname){
        this.artistName = artistName;
        this.artistSurname = artistSurname;
    }

    public Integer getArtistId() {return artistId;}
    public void setArtistId(Integer artistId) {this.artistId = artistId;}

    public String getArtistName() {return artistName;}
    public void setArtistName(String artistName) {this.artistName = artistName;}

    public String getArtistSurname() {return artistSurname;}
    public void setArtistSurname(String artistSurname) {this.artistSurname = artistSurname;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Artists artists = (Artists) o;
        return Objects.equals(artistId, artists.artistId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(artistId);
    }

    @Override
    public String toString() { return String.format("Artists{id=%d, '%s', '%s'}", artistId, artistName, artistSurname); }

    @ManyToMany(mappedBy = "artists")
    private Set<Groups> groups = new java.util.HashSet<>();

    public Set<Groups> getGroups() {return groups;}
    public void setGroups(Set<Groups> groups) {this.groups = groups;}
}
