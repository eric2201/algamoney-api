package com.example.algamoney.api.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @GeneratedValue
    @Column
    private int code;

    @Column
    @NotBlank
    private String name;
}
