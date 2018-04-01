package com.example.algamoney.api.service.mapper;

import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(CategoryEntity categoryEntity);

    CategoryEntity toEntity(CategoryDTO categoryDTO);
}
