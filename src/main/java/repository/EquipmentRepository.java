package repository;

import entity.Equipment;

public class EquipmentRepository extends GenericRepository<Equipment, Integer> {
    public EquipmentRepository() {
        super(Equipment.class);
    }
}
