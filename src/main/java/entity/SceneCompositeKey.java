package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SceneCompositeKey implements Serializable {

    @Column(name = "scene_zone_id", nullable = false)
    private Integer sceneZoneId;

    @Column(name = "scene_id", nullable = false)
    private Integer sceneId;

    protected SceneCompositeKey() {
    }

    public SceneCompositeKey(Integer sceneZoneId, Integer sceneId) {
        this.sceneZoneId = sceneZoneId;
        this.sceneId = sceneId;
    }

    public Integer getSceneZoneId() {
        return sceneZoneId;
    }

    public void setSceneZoneId(Integer sceneZoneId) {
        this.sceneZoneId = sceneZoneId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SceneCompositeKey that = (SceneCompositeKey) o;
        return Objects.equals(sceneZoneId, that.sceneZoneId) && Objects.equals(sceneId, that.sceneId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sceneZoneId, sceneId);
    }

    @Override
    public String toString() {
        return String.format("SceneCompositeKey{zoneId=%d, sceneId=%d}", sceneZoneId, sceneId);
    }
}
