package com.example.algamoney.api.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class AddressEmbeddable {

    private String number;
    private String street;
    private String city;
    private String state;
}
