package com.example.algamoney.api.service.dto;

import com.example.algamoney.api.model.AddressEmbeddable;

public class PeopleDTO {

    Long id;

    private String name;

    private boolean active;


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
    public String toString() {
        return "PeopleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", address=" + address +
                '}';
    }
}
