package com.example.algamoney.api.service;

import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.model.LaunchEntity;

import java.util.List;

public interface LaunchService {

    void createRelationship (LaunchEntity launchEntity);

    void updateRelationship (LaunchEntity launchEntity, int code);

    void deleteRelationship (LaunchEntity launchEntity);

    List<LaunchEntity> listByPeople (PeopleEntity peopleEntity);

    List<LaunchEntity> listByCategory(CategoryEntity categoryEntity);

    List<LaunchEntity> listAllLaunch();

    List<LaunchEntity> findByCategoryPeople(CategoryEntity categoryEntity, PeopleEntity peopleEntity);

}
