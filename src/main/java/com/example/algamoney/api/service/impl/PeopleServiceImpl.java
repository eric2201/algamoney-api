package com.example.algamoney.api.service.impl;

import com.example.algamoney.api.Exception.UserException;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.repository.PeopleRepository;
import com.example.algamoney.api.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleRepository peopleRepository;

    @Override
    public void savePeople(PeopleEntity peopleEntity) {
        isNotNull(peopleEntity.getName());
        peopleRepository.save(peopleEntity);
    }

    @Override
    public void isNotNull(String name) {
        if (name.equals("null")) {
            throw new UserException(String.format("The field name cannot be null"));
        }
    }

    @Override
    public void updatePeople(PeopleEntity peopleEntity, Long id) {
        isNotNull(peopleEntity.getName());
        PeopleEntity people = peopleRepository.findById(id);
        people.setAddress(peopleEntity.getAddress());
        people.setName(peopleEntity.getName());
        //people.setActive(peopleEntity.isActive());
        peopleRepository.save(people);
    }

    @Override
    public void deletePeople(Long id) {
        PeopleEntity peopleEntity = peopleRepository.findById(id);
        peopleRepository.delete(peopleEntity);
    }

    public PeopleEntity findByCode(Long id){
        return peopleRepository.findById(id);
    }

    @Override
    public List<PeopleEntity> findAllPeople() {
        return peopleRepository.findAll();

    }


}
