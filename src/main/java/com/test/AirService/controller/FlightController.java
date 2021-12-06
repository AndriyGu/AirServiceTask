package com.test.AirService.controller;

import com.test.AirService.model.DTO.requestDTO.AirplaneAddDTO;
import com.test.AirService.model.DTO.requestDTO.AirplaneChangeCompanyDTO;
import com.test.AirService.model.DTO.requestDTO.FlightAddDTO;
import com.test.AirService.model.DTO.requestDTO.FlightStatusChangeDTO;
import com.test.AirService.model.DTO.responseDTO.FlightDTO;
import com.test.AirService.model.FlightStatus;
import com.test.AirService.repository.AirCompanyRepository;
import com.test.AirService.service.AirCompanyService;
import com.test.AirService.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    FlightService flightService;
    @Autowired
    AirCompanyRepository airCompanyRepository;
    @Autowired
    AirCompanyService airCompanyService;


    @Operation(summary = "find all Air Company Flights by status (use company name for identification of Air Company)")
    @GetMapping("/findAllFlights/{status}/{companyName}/{currentPage}/{pageSize}")
    ResponseEntity<Page<FlightDTO>> findFlightsByStatusAndCompany(@PathVariable("status") FlightStatus status,
                                          @PathVariable("companyName") String companyName,
                                          @PathVariable("currentPage") int currentPage,
                                          @PathVariable("pageSize") int pageSize
    ) {
      return flightService.findFlightsByStatusAndCompany(status, companyName, currentPage, pageSize);
   }


    @Operation(summary = "Endpoint to find all Flights in ACTIVE status and started more than 24 hours ago.")
    @GetMapping("/findAllACTIVEFlights/{currentPage}/{pageSize}")
    ResponseEntity<Page<FlightDTO>> findAllActiveFlights(@PathVariable("currentPage") int currentPage,
                                                         @PathVariable("pageSize") int pageSize
    ) {
        return flightService.findAllACTIVEFlights(currentPage, pageSize);
    }

    @Operation(summary = "Endpoint to add new Flight (set status to PENDING)")
    @PostMapping("/addNewFlight")
    public ResponseEntity<String> login(@RequestBody FlightAddDTO request){
        return  flightService.addNewFlight(request);
    }

    // Endpoint to change Flight status:
    // if status to change is DELAYED – set delay started at
    // if status to change is ACTIVE – set started at
    // if status to change is COMPLETED set ended at
    @Operation(summary = "change Flight status")
    @PutMapping("/changeFlightStatus")
    ResponseEntity<?> changeFlightStatus(@RequestBody FlightStatusChangeDTO request) {
        return  flightService.changeFlightStatus(request);
    }

    //Endpoint to find all Flights in COMPLETED status and difference between
    //started and ended time is bigger than estimated flight time.
    @Operation(summary = "Endpoint to find all Flights in COMPLETED status.")
    @GetMapping("/findCompletedFlights/{currentPage}/{pageSize}")
    ResponseEntity<Page<FlightDTO>> findCompletedFlights(@PathVariable("currentPage") int currentPage,
                                                         @PathVariable("pageSize") int pageSize
    ) {
        return flightService.findCompletedFlights(currentPage, pageSize);
    }

}
