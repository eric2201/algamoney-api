package com.example.algamoney.api.service.impl;

import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.model.ReleasesEntity;
import com.example.algamoney.api.repository.ReleasesRepository;
import com.example.algamoney.api.service.ReleasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleasesServiceImpl implements ReleasesService {

    @Autowired
    private ReleasesRepository releasesRepository;

    @Override
    public void createReleases(ReleasesEntity releasesEntity) {
        releasesRepository.save(releasesEntity);
    }

    @Override
    public void updateReleases(ReleasesEntity releasesEntity) {

    }

    @Override
    public void deleteReleases(Long id) {
        releasesRepository.delete(id);
    }

    @Override
    public List<ReleasesEntity> listByPeople(PeopleEntity peopleEntity) {
        return null;
    }

    @Override
    public List<ReleasesEntity> listByCategory(CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public List<ReleasesEntity> listAllReleases() {

        return null;
    }

    @Override
    public List<ReleasesEntity> findByCategoryPeople(CategoryEntity categoryEntity, PeopleEntity peopleEntity) {

        return null;
    }

    private void hasConflict(ReleasesEntity launchEntity) {

        CategoryEntity category = launchEntity.getCategoryEntity();

        launchEntity.getCategoryEntity();
        launchEntity.getPeopleEntity();
    }
}
