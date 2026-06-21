package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEquipment;

    @Column(nullable = false, length = 255)
    private String equipmentType;

    protected Equipment() {}

    public Equipment(String equipmentType){
        this.equipmentType = equipmentType;
    }

    public Integer getIdEquipment() {return IdEquipment;}
    public void setIdEquipment(Integer idEquipment) {IdEquipment = idEquipment;}

    public String getEquipmentType() {return equipmentType;}
    public void setEquipmentType(String equipmentType) {this.equipmentType = equipmentType;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(IdEquipment, equipment.IdEquipment);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(IdEquipment);
    }

    @Override
    public String toString() { return String.format("Equipment{id=%d, '%s'}", IdEquipment, equipmentType);}

}

