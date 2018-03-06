package com.example.algamoney.api.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "launch")
public class LaunchEntity {
    @Id
    @GeneratedValue
    private Long code;
    private String description;
    @Column(name = "validate_date")
    private LocalDate validateDate;
    @Column(name = "pay_date")
    private LocalDate payDate;
    private BigDecimal valor;
    private String observation;
    //enum
    @Enumerated(EnumType.STRING)
    private LaunchType launchType;
    //Uma categoria pode estar em vários relacionamentos // muitos relacionamentos podem conter uma categoria
    @ManyToOne
    @JoinColumn(name = "code_category")
    private CategoryEntity category;
    //Uma pessoa pode estar em vários relacionamentos // muitos relaciomanentos pode conter uma pessoa
    @ManyToOne
    @JoinColumn(name = "code_people")
    private PeopleEntity people;

}
