package entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    @Column(nullable = false, length = 255)
    private String groupName;

    @Column(name = "music_style",nullable = false, length = 255)
    private String musicStyle = "not stated";

    protected Groups() {}

    public Groups(String groupName, String musicStyle){
        this.groupName = groupName;
        this.musicStyle = musicStyle;
    }

    public Integer getGroupId() {return groupId;}
    public void setGroupId(Integer groupId) {this.groupId = groupId;}

    public String getGroupName() {return groupName;}
    public void setGroupName(String groupName) {this.groupName = groupName;}

    public String getMusicStyle() {return musicStyle;}
    public void setMusicStyle(String musicStyle) {this.musicStyle = musicStyle;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Groups group = (Groups) o;
        return Objects.equals(groupId, group.groupId) && Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName);
    }

    @Override
    public String toString() { return String.format("Groups{id=%d, '%s', '%s'}", groupId, groupName, musicStyle); }

    @ManyToMany
    @JoinTable(
            name = "artists_in_groups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artists> artists = new java.util.HashSet<>();

    public Set<Artists> getArtists() {return artists;}
    public void setArtists(Set<Artists> artists) {this.artists = artists;}
}
