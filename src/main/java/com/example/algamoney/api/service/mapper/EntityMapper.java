package com.example.algamoney.api.service.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EntityMapper <D, E> {

    E toEntity(D dto); //suggested method names. Feel free to change.
    D toDto(E entity);
    List<E> toEntity(List<D> dtoList);
    List <D> toDto(List<E> entityList);
}
