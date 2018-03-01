package com.example.algamoney.api.service;

import com.example.algamoney.api.model.PeopleEntity;

import java.util.List;

public interface PeopleService {

    void savePeople(PeopleEntity peopleEntity);

    void updatePeople(PeopleEntity peopleEntity, int code);

    void deletePeople(int code);

    void isNotNull(String name);

    PeopleEntity findByCode(int code);

    List<PeopleEntity> findAllPeople();

}
