package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Perfomances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfomance")
    private Integer idPerfomance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grp", nullable = false)
    private Groups grpId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(
            {
             @JoinColumn(name = "id_scn", referencedColumnName = "scene_id", nullable = false),
             @JoinColumn(name = "id_zn", referencedColumnName = "scene_zone_id", nullable = false)
            })
    private Scene scene;

    @Column(name = "start_perfomance", nullable = false)
    private LocalDateTime startPerformance = LocalDateTime.now();

    @Column(name = "end_perfomance", nullable = false)
    private LocalDateTime endPerformance = LocalDateTime.now();

    protected Perfomances(){}

    public Perfomances(Groups grpId, Scene scene, LocalDateTime startPerformance, LocalDateTime endPerformance) {
        this.grpId = grpId;
        this.scene = scene;
        this.startPerformance = startPerformance;
        this.endPerformance = endPerformance;
    }

    public Integer getIdPerfomance() {return idPerfomance;}
    public void setIdPerfomance(Integer idPerfomance) {this.idPerfomance = idPerfomance;}

    public Groups getGrpId() {return grpId;}
    public void setGrpId(Groups grpId) {this.grpId = grpId;}

    public Scene getScene() {return scene;}
    public void setScene(Scene scene) {this.scene = scene;}

    public LocalDateTime getStartPerformance() {return startPerformance;}
    public void setStartPerformance(LocalDateTime startPerformance) {this.startPerformance = startPerformance;}

    public LocalDateTime getEndPerformance() {return endPerformance;}
    public void setEndPerformance(LocalDateTime endPerformance) {this.endPerformance = endPerformance;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Perfomances that = (Perfomances) o;
        return Objects.equals(idPerfomance, that.idPerfomance);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPerfomance);
    }

    @Override
    public String toString() {
        return String.format("Performances{id=%d, groupId=%d, sceneKey=%s, start=%s, end=%s}",
                idPerfomance,
                grpId != null ? grpId.getGroupId() : null,
                scene != null ? scene.getSceneId() : null,
                startPerformance,
                endPerformance);
    }
}
