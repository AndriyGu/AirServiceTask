package com.test.AirService.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *ID, flight status, Air company id, airplane id, departure country, destination country,
 * distance, estimated flight time, ended at, delay started at, created at
 */


@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;


    @ManyToOne
    @JoinColumn(name = "airCompanyId")
    @JsonIgnore
    private AirCompany airCompany;

    @OneToOne (optional=true, fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="airplaneId")
    private Airplane airplane;

    //maybe create tables Country
    //and use @ManyToOne
    private String departureCountry;
    private String destinationCountry;

    private double distance;

    //minutes
    private int estimatedFlightTime; //https://www.leveluplunch.com/java/examples/add-milliseconds-to-date/
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;
    private LocalDateTime startedAt;


    public Flight() {
    }

    public Flight(FlightStatus flightStatus, AirCompany airCompany, Airplane airplane, String departureCountry, String destinationCountry, double distance, int estimatedFlightTime, LocalDateTime endedAt, LocalDateTime delayStartedAt, LocalDateTime createdAt, LocalDateTime startedAt) {
        this.flightStatus = flightStatus;
        this.airCompany = airCompany;
        this.airplane = airplane;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.endedAt = endedAt;
        this.delayStartedAt = delayStartedAt;
        this.createdAt = createdAt;
        this.startedAt = startedAt;
    }

    public int getId() {
        return id;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(int estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(LocalDateTime delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }
}
