package repository;

import entity.Groups;

public class GroupsRepository extends GenericRepository<Groups, Integer> {
    public GroupsRepository() {
        super(Groups.class);
    }
}
