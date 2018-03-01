package com.example.algamoney.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "relationship")
public class Relationship {
    private Long code;
    private String description;
    @Column(name="validate_date")
    private LocalDate validateDate;
    @Column(name="pay_date")
    private LocalDate payDate;
    private BigDecimal valor;
    private String observation;
    private LaunchType launchType;

}
