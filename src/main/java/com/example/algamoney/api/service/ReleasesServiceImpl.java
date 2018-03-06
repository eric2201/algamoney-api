package com.example.algamoney.api.service;

import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.model.LaunchEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaunchServiceImpl implements LaunchService {




    @Override
    public void createRelationship(LaunchEntity launchEntity) {
        hasConflict(launchEntity);
    }

    @Override
    public void updateRelationship(LaunchEntity launchEntity, int code) {

    }

    @Override
    public void deleteRelationship(LaunchEntity launchEntity) {

    }

    @Override
    public List<LaunchEntity> listByPeople(PeopleEntity peopleEntity) {
        return null;
    }

    @Override
    public List<LaunchEntity> listByCategory(CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public List<LaunchEntity> listAllLaunch() {
        Launch

        return null;
    }

    @Override
    public List<LaunchEntity> findByCategoryPeople(CategoryEntity categoryEntity, PeopleEntity peopleEntity) {

        return null;
    }

    private void hasConflict(LaunchEntity launchEntity) {

        CategoryEntity category = launchEntity.getCategory();

        launchEntity.getCategory();
        launchEntity.getPeople();
    }
}
