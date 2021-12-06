package com.test.AirService.model.DTO.requestDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.AirService.model.AirCompany;

import javax.persistence.*;
import java.time.LocalDate;

public class AirplaneAddDTO {
    private String name;
    private String factorySerialNumber;
    private String airCompanyName;
    private int numberOfFlights;
    private double flightDistance;
    private double fuelCapacity;
    private String type;
    private LocalDate createdAt;

    public AirplaneAddDTO() {
    }

    public AirplaneAddDTO(String name, String factorySerialNumber, String airCompanyName, int numberOfFlights, double flightDistance, double fuelCapacity, String type, LocalDate createdAt) {

        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.airCompanyName = airCompanyName;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public String getAirCompanyName() {
        return airCompanyName;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public double getFlightDistance() {
        return flightDistance;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
