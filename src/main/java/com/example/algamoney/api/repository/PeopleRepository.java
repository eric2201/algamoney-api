package com.example.algamoney.api.repository;

import com.example.algamoney.api.model.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {

    PeopleEntity findByCode(int code);
}
