package com.test.AirService.repository;

import com.test.AirService.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Integer> {

    @Override
    Optional<AirCompany> findById(Integer integer);


    @Query("SELECT a FROM AirCompany a WHERE a.name=?1")
    Optional<AirCompany> findByName(String name);
}
