package com.test.AirService.model.DTO.responseDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.AirService.model.AirCompany;
import com.test.AirService.model.Airplane;
import com.test.AirService.model.FlightStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

public class FlightDTO {
    private int id;
    private FlightStatus flightStatus;
    private String airCompany;
    private Airplane airplane;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private int estimatedFlightTime; //https://www.leveluplunch.com/java/examples/add-milliseconds-to-date/
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;

    public FlightDTO() {
    }

    public FlightDTO(int id, FlightStatus flightStatus, String airCompany, Airplane airplane, String departureCountry, String destinationCountry, double distance, int estimatedFlightTime, LocalDateTime endedAt, LocalDateTime delayStartedAt, LocalDateTime createdAt) {
        this.id = id;
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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(String airCompany) {
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
}
