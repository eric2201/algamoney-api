package com.example.algamoney.api.service.mapper;

import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.service.dto.CategoryDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-01T11:40:33-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toDTO(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( categoryEntity.getId() );
        categoryDTO.setName( categoryEntity.getName() );

        return categoryDTO;
    }

    @Override
    public CategoryEntity toEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryDTO.getId() );
        categoryEntity.setName( categoryDTO.getName() );

        return categoryEntity;
    }
}
