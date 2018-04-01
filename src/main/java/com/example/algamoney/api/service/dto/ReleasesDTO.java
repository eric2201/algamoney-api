package com.example.algamoney.api.service.dto;

import com.example.algamoney.api.model.ReleasesType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReleasesDTO {

    private Long id;
    private String description;
    private LocalDate validateDate;
    private LocalDate payDate;
    private BigDecimal valor;
    private String observation;
    private ReleasesType releasesType;
    private Long categoryId;
    private Long peopleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(LocalDate validateDate) {
        this.validateDate = validateDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ReleasesType getReleasesType() {
        return releasesType;
    }

    public void setReleasesType(ReleasesType releasesType) {
        this.releasesType = releasesType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }


    @Override
    public String toString() {
        return "ReleasesDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", validateDate=" + validateDate +
                ", payDate=" + payDate +
                ", valor=" + valor +
                ", observation='" + observation + '\'' +
                ", releasesType=" + releasesType +
                ", categoryId=" + categoryId +
                ", peopleId=" + peopleId +
                '}';
    }
}
