package com.example.algamoney.api.service;

import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.model.ReleasesEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReleasesService {

    void createReleases (ReleasesEntity releasesEntity);

    void updateReleases (ReleasesEntity releasesEntity);

    void deleteReleases (Long id);

    List<ReleasesEntity> listByPeople (PeopleEntity peopleEntity);

    List<ReleasesEntity> listByCategory(CategoryEntity categoryEntity);

    List<ReleasesEntity> listAllReleases();

    List<ReleasesEntity> findByCategoryPeople(CategoryEntity categoryEntity, PeopleEntity peopleEntity);

}
