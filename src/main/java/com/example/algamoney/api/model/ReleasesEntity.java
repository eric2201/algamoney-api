package com.example.algamoney.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "releases")
public class ReleasesEntity {
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
    private ReleasesType releasesType;
    //Uma categoria pode estar em vários relacionamentos // muitos relacionamentos podem conter uma categoria
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;
    //Uma pessoa pode estar em vários relacionamentos // muitos relaciomanentos pode conter uma pessoa
    @ManyToOne
    @JoinColumn(name = "id_people")
    private PeopleEntity peopleEntity;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleasesEntity that = (ReleasesEntity) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(description, that.description) &&
                Objects.equals(validateDate, that.validateDate) &&
                Objects.equals(payDate, that.payDate) &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(observation, that.observation) &&
                releasesType == that.releasesType &&
                Objects.equals(categoryEntity, that.categoryEntity) &&
                Objects.equals(peopleEntity, that.peopleEntity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, description, validateDate, payDate, valor, observation, releasesType, categoryEntity, peopleEntity);
    }

    @Override
    public String toString() {
        return "ReleasesEntity{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", validateDate=" + validateDate +
                ", payDate=" + payDate +
                ", valor=" + valor +
                ", observation='" + observation + '\'' +
                ", releasesType=" + releasesType +
                ", categoryEntity=" + categoryEntity +
                ", peopleEntity=" + peopleEntity +
                '}';
    }
}
