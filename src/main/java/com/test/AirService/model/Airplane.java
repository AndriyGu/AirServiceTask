package com.test.AirService.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *ID, name, factory serial number, air company id, number of flights, flight distance,
 * fuel capacity, type, created at
 */

@Entity
@Table(name = "airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String factorySerialNumber;

    @ManyToOne
    @JoinColumn(name = "airCompanyId")
    @JsonIgnore
    private AirCompany airCompany;

    private int numberOfFlights;
    private double flightDistance;
    private double fuelCapacity;
    private String type;
    private LocalDate createdAt;

    @OneToOne (optional=true, mappedBy="airplane")
    @JsonIgnore
    private Flight flight;

    public Airplane() {
    }

    public Airplane(String name, String factorySerialNumber, AirCompany airCompany, int numberOfFlights, double flightDistance, double fuelCapacity, String type, LocalDate createdAt, Flight flight) {
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.airCompany = airCompany;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
        this.flight = flight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public double getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(double flightDistance) {
        this.flightDistance = flightDistance;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
