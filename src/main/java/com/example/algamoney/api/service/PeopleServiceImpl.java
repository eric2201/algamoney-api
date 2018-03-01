package com.example.algamoney.api.service;

import com.example.algamoney.api.Exception.UserException;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.repository.PeopleRepository;
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
        log.info("Category create success ", peopleEntity.getName());
        isNotNull(peopleEntity.getName());
        peopleRepository.save(peopleEntity);
    }

    @Override
    public void isNotNull(String name) {
        log.info("PeopleEntity is={} message=conflict", name);
        if (name.equals("null")) {
            throw new UserException(String.format("The field name cannot be null"));
        }
    }

    @Override
    public void updatePeople(PeopleEntity peopleEntity, int code) {
        isNotNull(peopleEntity.getName());
        PeopleEntity people = peopleRepository.findByCode(code);
        people.setAddress(peopleEntity.getAddress());
        people.setName(peopleEntity.getName());
        //people.setActive(peopleEntity.isActive());
        peopleRepository.save(people);
    }

    @Override
    public void deletePeople(int code) {
        PeopleEntity peopleEntity = peopleRepository.findByCode(code);
        peopleRepository.delete(peopleEntity);
    }

    public PeopleEntity findByCode(int code){
        return peopleRepository.findByCode(code);
    }

    @Override
    public List<PeopleEntity> findAllPeople() {
        log.info("List of person");
        return peopleRepository.findAll();

    }


}
