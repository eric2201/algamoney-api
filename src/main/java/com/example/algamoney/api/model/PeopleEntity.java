package com.example.algamoney.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="people")
public class PeopleEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    private boolean active;


    @Embedded
    private AddressEmbeddable address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AddressEmbeddable getAddress() {
        return address;
    }

    public void setAddress(AddressEmbeddable address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleEntity that = (PeopleEntity) o;
        return active == that.active &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, active, address);
    }

    @Override
    public String toString() {
        return "PeopleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", address=" + address +
                '}';
    }
}
