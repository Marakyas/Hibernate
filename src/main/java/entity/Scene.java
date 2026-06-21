package entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Scene{

    @EmbeddedId
    private SceneCompositeKey sceneId;

    protected Scene() {}

    public Scene(SceneCompositeKey sceneId){
        this.sceneId =sceneId;
    }

    public SceneCompositeKey getSceneId() {return sceneId;}
    public void setSceneId(SceneCompositeKey sceneId) {this.sceneId = sceneId;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Scene scene = (Scene) o;
        return Objects.equals(sceneId, scene.sceneId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sceneId);
    }

    @Override
    public String toString() {
        return "Scene{" +
                "sceneId=" + sceneId +
                '}';
    }
}
