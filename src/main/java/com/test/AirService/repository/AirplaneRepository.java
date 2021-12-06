package com.test.AirService.repository;

import com.test.AirService.model.Airplane;
import com.test.AirService.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

    @Query("select a FROM Airplane a WHERE a.id = ?1")
    Optional<Airplane> findById(int integer);

    @Query("select a FROM Airplane a WHERE a.name = ?1")
    Optional<Airplane> findByName(String name);
}
