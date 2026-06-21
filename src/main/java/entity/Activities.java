package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;

    @Column(name = "desription", nullable = false, columnDefinition = "TEXT")
    private String description = "no description";

    @Column(name = "activity_start_time", nullable = false)
    private LocalDateTime activityStartTime = LocalDateTime.now();

    @Column(name = "activity_end_time", nullable = false)
    private LocalDateTime activityEndTime = LocalDateTime.now();

    protected Activities() {}

    public Activities(String description, LocalDateTime activityStartTime, LocalDateTime activityEndTime){
        this.description = description;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
    }

    public Integer getActivityId() {return activityId;}
    public void setActivityId(Integer activityId) {this.activityId = activityId;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public LocalDateTime getActivityStartTime() {return activityStartTime;}
    public void setActivityStartTime(LocalDateTime activityStartTime) {this.activityStartTime = activityStartTime;}

    public LocalDateTime getActivityEndTime() {return activityEndTime;}
    public void setActivityEndTime(LocalDateTime activityEndTime) {this.activityEndTime = activityEndTime;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Activities that = (Activities) o;
        return Objects.equals(activityId, that.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(activityId);
    }

    @Override
    public String toString() { return String.format("Activities{id=%d, '%s', %s, %s}", activityId, description, activityStartTime, activityEndTime); }
}
