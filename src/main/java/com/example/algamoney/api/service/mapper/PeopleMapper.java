package com.example.algamoney.api.service.mapper;

import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.service.dto.PeopleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    PeopleDTO toDTO(PeopleEntity peopleEntity);

    PeopleEntity toEntity(PeopleDTO peopleDTO);

}
