package com.test.AirService.repository;

import com.test.AirService.model.Flight;
import com.test.AirService.model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("select f FROM Flight f WHERE f.id = ?1")
    Flight findFlightById(int integer);

    @Query("select f FROM Flight f WHERE f.flightStatus = ?1 AND f.airCompany.id = ?2")
    List<Flight> findAllFlightByStatusAndCompanyId(FlightStatus flightStatus, int integer);

    @Query("select f FROM Flight f WHERE f.flightStatus = ?1 AND f.startedAt < ?2")
    List<Flight> findAllActiveFlightOld(FlightStatus flightStatus, LocalDateTime startedDate);

    //Endpoint to find all Flights in COMPLETED status and difference between
    //started and ended time is bigger than estimated flight time.
    @Query(value = "select * FROM flight WHERE flight_status = :status AND (TIME_TO_SEC(TIMEDIFF(ended_at, started_at))/3600)>estimated_flight_time", nativeQuery = true)
    List<Flight> findAllCompleted(@Param("status") String line);

}
