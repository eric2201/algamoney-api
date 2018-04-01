package com.example.algamoney.api.service.mapper;

import com.example.algamoney.api.model.ReleasesEntity;
import com.example.algamoney.api.service.dto.ReleasesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, PeopleMapper.class})
public interface ReleasesMapper {
    @Mappings({
            @Mapping(target = "categoryId", source = "categoryEntity.id"),
            @Mapping(target = "peopleId", source = "peopleEntity.id")})
    ReleasesDTO toDTO(ReleasesEntity releasesEntity);

    @Mappings({
            @Mapping(target = "categoryEntity.id", source = "categoryId"),
            @Mapping(target = "peopleEntity.id", source = "peopleId")
    })
    ReleasesEntity toEntity(ReleasesDTO releasesDTO);
}
