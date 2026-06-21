package repository;

import entity.Client;

public class ClientRepository extends GenericRepository<Client, Integer> {
    public ClientRepository() {
        super(Client.class);
    }
}

