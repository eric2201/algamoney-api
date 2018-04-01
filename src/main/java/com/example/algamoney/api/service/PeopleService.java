package com.example.algamoney.api.service;

import com.example.algamoney.api.model.PeopleEntity;

import java.util.List;

public interface PeopleService {

    void savePeople(PeopleEntity peopleEntity);

    void updatePeople(PeopleEntity peopleEntity, Long id);

    void deletePeople(Long id);

    void isNotNull(String name);

    PeopleEntity findByCode(Long id);

    List<PeopleEntity> findAllPeople();

}
