package com.test.AirService.model.DTO.requestDTO;

import com.test.AirService.model.FlightStatus;

public class FlightStatusChangeDTO {
    private  int flightId;
    private FlightStatus flightStatus;

    public FlightStatusChangeDTO() {
    }

    public FlightStatusChangeDTO(int flightId, FlightStatus flightStatus) {
        this.flightId = flightId;
        this.flightStatus = flightStatus;
    }

    public int getFlightId() {
        return flightId;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
}
