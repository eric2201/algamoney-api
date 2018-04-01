package com.example.algamoney.api.repository;

import com.example.algamoney.api.model.ReleasesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleasesRepository  extends JpaRepository<ReleasesEntity, Long>{
}
