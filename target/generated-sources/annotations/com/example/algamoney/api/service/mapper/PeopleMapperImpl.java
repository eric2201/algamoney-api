package com.example.algamoney.api.service.mapper;

import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.service.dto.PeopleDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-01T11:40:33-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class PeopleMapperImpl implements PeopleMapper {

    @Override
    public PeopleDTO toDTO(PeopleEntity peopleEntity) {
        if ( peopleEntity == null ) {
            return null;
        }

        PeopleDTO peopleDTO = new PeopleDTO();

        peopleDTO.setId( peopleEntity.getId() );
        peopleDTO.setName( peopleEntity.getName() );
        peopleDTO.setActive( peopleEntity.isActive() );
        peopleDTO.setAddress( peopleEntity.getAddress() );

        return peopleDTO;
    }

    @Override
    public PeopleEntity toEntity(PeopleDTO peopleDTO) {
        if ( peopleDTO == null ) {
            return null;
        }

        PeopleEntity peopleEntity = new PeopleEntity();

        peopleEntity.setId( peopleDTO.getId() );
        peopleEntity.setName( peopleDTO.getName() );
        peopleEntity.setActive( peopleDTO.isActive() );
        peopleEntity.setAddress( peopleDTO.getAddress() );

        return peopleEntity;
    }
}
