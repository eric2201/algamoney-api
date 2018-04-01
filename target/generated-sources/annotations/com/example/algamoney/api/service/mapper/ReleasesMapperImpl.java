package com.example.algamoney.api.service.mapper;

import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.model.ReleasesEntity;
import com.example.algamoney.api.service.dto.ReleasesDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-01T11:40:33-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class ReleasesMapperImpl implements ReleasesMapper {

    @Override
    public ReleasesDTO toDTO(ReleasesEntity releasesEntity) {
        if ( releasesEntity == null ) {
            return null;
        }

        ReleasesDTO releasesDTO = new ReleasesDTO();

        Long id = releasesEntityPeopleEntityId( releasesEntity );
        if ( id != null ) {
            releasesDTO.setPeopleId( id );
        }
        Long id1 = releasesEntityCategoryEntityId( releasesEntity );
        if ( id1 != null ) {
            releasesDTO.setCategoryId( id1 );
        }
        releasesDTO.setDescription( releasesEntity.getDescription() );
        releasesDTO.setValidateDate( releasesEntity.getValidateDate() );
        releasesDTO.setPayDate( releasesEntity.getPayDate() );
        releasesDTO.setValor( releasesEntity.getValor() );
        releasesDTO.setObservation( releasesEntity.getObservation() );
        releasesDTO.setReleasesType( releasesEntity.getReleasesType() );

        return releasesDTO;
    }

    @Override
    public ReleasesEntity toEntity(ReleasesDTO releasesDTO) {
        if ( releasesDTO == null ) {
            return null;
        }

        ReleasesEntity releasesEntity = new ReleasesEntity();

        releasesEntity.setCategoryEntity( releasesDTOToCategoryEntity( releasesDTO ) );
        releasesEntity.setPeopleEntity( releasesDTOToPeopleEntity( releasesDTO ) );
        releasesEntity.setDescription( releasesDTO.getDescription() );
        releasesEntity.setValidateDate( releasesDTO.getValidateDate() );
        releasesEntity.setPayDate( releasesDTO.getPayDate() );
        releasesEntity.setValor( releasesDTO.getValor() );
        releasesEntity.setObservation( releasesDTO.getObservation() );
        releasesEntity.setReleasesType( releasesDTO.getReleasesType() );

        return releasesEntity;
    }

    private Long releasesEntityPeopleEntityId(ReleasesEntity releasesEntity) {
        if ( releasesEntity == null ) {
            return null;
        }
        PeopleEntity peopleEntity = releasesEntity.getPeopleEntity();
        if ( peopleEntity == null ) {
            return null;
        }
        Long id = peopleEntity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long releasesEntityCategoryEntityId(ReleasesEntity releasesEntity) {
        if ( releasesEntity == null ) {
            return null;
        }
        CategoryEntity categoryEntity = releasesEntity.getCategoryEntity();
        if ( categoryEntity == null ) {
            return null;
        }
        Long id = categoryEntity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected CategoryEntity releasesDTOToCategoryEntity(ReleasesDTO releasesDTO) {
        if ( releasesDTO == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( releasesDTO.getCategoryId() );

        return categoryEntity;
    }

    protected PeopleEntity releasesDTOToPeopleEntity(ReleasesDTO releasesDTO) {
        if ( releasesDTO == null ) {
            return null;
        }

        PeopleEntity peopleEntity = new PeopleEntity();

        peopleEntity.setId( releasesDTO.getPeopleId() );

        return peopleEntity;
    }
}
