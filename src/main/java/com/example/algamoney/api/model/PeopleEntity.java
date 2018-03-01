package com.example.algamoney.api.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name="people")
public class PeopleEntity {

    @Id
    @GeneratedValue
    private int code;

    @Column
    @NotNull
    private String name;

    @Column
    private boolean active;


    @Embedded
    private AddressEmbeddable address;



}
