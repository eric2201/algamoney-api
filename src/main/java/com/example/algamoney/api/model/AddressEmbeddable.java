package com.example.algamoney.api.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Embeddable
public class AddressEmbeddable {

    private String number;
    private String street;
    private String city;
    private String state;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEmbeddable that = (AddressEmbeddable) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, street, city, state);
    }

    @Override
    public String toString() {
        return "AddressEmbeddable{" +
                "number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
