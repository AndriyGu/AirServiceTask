package com.test.AirService.controller;

import com.test.AirService.model.DTO.requestDTO.AirplaneAddDTO;
import com.test.AirService.model.DTO.requestDTO.AirplaneChangeCompanyDTO;
import com.test.AirService.repository.AirCompanyRepository;
import com.test.AirService.service.AirplaneService;
import com.test.AirService.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/airplane")
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;
    @Autowired
    FlightService flightService;
    @Autowired
    AirCompanyRepository airCompanyRepository;

    @Operation(summary = "move airplanes between companies")
    @PutMapping("/changeAirCompanyInAirplane")
    ResponseEntity<?> changeAirCompany(@RequestBody AirplaneChangeCompanyDTO dto) {
        return  airplaneService.changeAirCompany(dto.getAirCompanyName(), dto.getAirplaneId());
    }

    //Endpoint to add new Airplane (Could be assign to a company immediately or moved later).
    @Operation(summary = "add new Airplane")
    @PostMapping("/addNewAirplane")
    public ResponseEntity<String> login(@RequestBody AirplaneAddDTO request){
        return  airplaneService.addNewAirplane(request);
    }
}
