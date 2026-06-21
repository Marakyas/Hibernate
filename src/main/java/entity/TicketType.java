package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer type_id;

    @Column(name = "access_level", nullable = false, length = 50)
    private String accessLevel;

    @Column(name = "access_start_time", nullable = false)
    private LocalDateTime accessStartTime = LocalDateTime.now();

    @Column(name = "access_end_time", nullable = false)
    private LocalDateTime accessEndTime = LocalDateTime.now();

    protected TicketType() {}

    public TicketType(String accessLevel, LocalDateTime accessStartTime, LocalDateTime accessEndTime){
        this.accessLevel = accessLevel;
        this.accessStartTime = accessStartTime;
        this.accessEndTime = accessEndTime;
    }

    public Integer getType_id() {return type_id;}
    public void setType_id(Integer type_id) {this.type_id = type_id;}

    public String getAccessLevel() {return accessLevel;}
    public void setAccessLevel(String accessLevel) {this.accessLevel = accessLevel;}

    public LocalDateTime getAccessStartTime() {return accessStartTime;}
    public void setAccessStartTime(LocalDateTime accessStartTime) {this.accessStartTime = accessStartTime;}

    public LocalDateTime getAccessEndTime() {return accessEndTime;}
    public void setAccessEndTime(LocalDateTime accessEndTime) {this.accessEndTime = accessEndTime;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketType that = (TicketType) o;
        return Objects.equals(type_id, that.type_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type_id);
    }

    @Override
    public String toString() { return String.format("Ticket_type{id=%d, '%s', %s, %s}", type_id, accessLevel, accessStartTime, accessEndTime); }
}
