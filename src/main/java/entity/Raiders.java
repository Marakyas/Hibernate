package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Raiders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raider_id")
    private Integer raiderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equip", nullable = false)
    private Equipment idEquip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group", nullable = false)
    private Groups idGroup;

    @Column(nullable = false, length = 255)
    private String basicNeeds;

    protected Raiders() {
    }

    ;

    public Raiders(Equipment idEquip, Groups idGroup, String basicNeeds) {
        this.idEquip = idEquip;
        this.idGroup = idGroup;
        this.basicNeeds = basicNeeds;
    }

    public Integer getRaiderId() {
        return raiderId;
    }

    public void setRaiderId(Integer raiderId) {
        raiderId = raiderId;
    }

    public Equipment getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Equipment idEquip) {
        this.idEquip = idEquip;
    }

    public Groups getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Groups idGroup) {
        this.idGroup = idGroup;
    }

    public String getBasicNeeds() {
        return basicNeeds;
    }

    public void setBasicNeeds(String basicNeeds) {
        this.basicNeeds = basicNeeds;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Raiders raiders = (Raiders) o;
        return Objects.equals(raiderId, raiders.raiderId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(raiderId);
    }

    @Override
    public String toString() {
        return String.format("Raiders{raiderId=%d, equipId=%d, groupId=%d, basicNeeds='%s'}",
                raiderId,
                idEquip != null ? idEquip.getIdEquipment() : null,
                idGroup != null ? idGroup.getGroupId() : null,
                basicNeeds);
    }
}



