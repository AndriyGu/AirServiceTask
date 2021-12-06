package com.test.AirService.model.DTO.requestDTO;

import java.time.LocalDateTime;

public class FlightAddDTO {

    private String airCompanyName;
    private String airplaneName;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private int estimatedFlightTime;
    private LocalDateTime createdAt;

    public FlightAddDTO() {
    }

    public FlightAddDTO(String airCompanyName, String airplaneName, String departureCountry, String destinationCountry, double distance, int estimatedFlightTime, LocalDateTime createdAt) {
        this.airCompanyName = airCompanyName;
        this.airplaneName = airplaneName;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.createdAt = createdAt;
    }

    public String getAirCompanyName() {
        return airCompanyName;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public double getDistance() {
        return distance;
    }

    public int getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
