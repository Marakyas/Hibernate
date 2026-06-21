package entity;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    protected Client() {}

    public Client(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Integer getId() {return  id;}
    public void setId(Integer id) {this.id = id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String toString() { return String.format("Client{id=%d, '%s', '%s', '%s'}", id, name, surname, email); }
}



