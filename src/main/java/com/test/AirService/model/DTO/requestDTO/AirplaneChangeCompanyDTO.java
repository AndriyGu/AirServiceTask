package com.test.AirService.model.DTO.requestDTO;

public class AirplaneChangeCompanyDTO {
    private  int airplaneId;
    private String airCompanyName;

    public AirplaneChangeCompanyDTO() {
    }

    public AirplaneChangeCompanyDTO(int id, String airCompanyName) {
        this.airplaneId = id;
        this.airCompanyName = airCompanyName;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public String getAirCompanyName() {
        return airCompanyName;
    }
}
