package com.test.AirService.service;

import com.test.AirService.model.AirCompany;
import com.test.AirService.model.Airplane;
import com.test.AirService.model.DTO.requestDTO.AirplaneAddDTO;
import com.test.AirService.repository.AirCompanyRepository;
import com.test.AirService.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;
    @Autowired
    AirCompanyRepository airCompanyRepository;

    public ResponseEntity<?> changeAirCompany(String airCompanyName, int flightId){

        Optional<AirCompany> airCompany = airCompanyRepository.findByName(airCompanyName);
        Optional<Airplane> airplane = airplaneRepository.findById(flightId);
        if(airplane.isEmpty()){
            return new ResponseEntity<String>("Airplane is not found.", HttpStatus.NOT_FOUND);
        }
        else{
            if(airCompany.isEmpty()){
                return new ResponseEntity<String>("Air company is not found.", HttpStatus.NOT_FOUND);
            }
            else{
                airplane.get().setAirCompany(airCompany.get());
                airplaneRepository.save(airplane.get());
            }
        }
        return new ResponseEntity<String>("Airplane was updated", HttpStatus.OK);
    }

    //add new Airplane
    public ResponseEntity<String> addNewAirplane(AirplaneAddDTO request){
        if(request.getAirCompanyName().isEmpty()){
            addAirplane(request, null);
            return new ResponseEntity<String>("Airplane added.", HttpStatus.OK);
        }
        else {
            Optional<AirCompany> airCompany = airCompanyRepository.findByName(request.getAirCompanyName());

            if(airCompany.isEmpty()){
                return new ResponseEntity<String>("Air company is not found.", HttpStatus.NOT_FOUND);
            }else{
                addAirplane(request, airCompany.get());
                return new ResponseEntity<String>("Airplane added.", HttpStatus.OK);
            }
        }
    }

    //use in  addNewAirplane(AirplaneAddDTO request) -> create one airplane (with\without null)
    private void addAirplane(AirplaneAddDTO request, AirCompany airCompany){
        Airplane airplane = new Airplane();

        airplane.setName(request.getName());
        airplane.setFactorySerialNumber(request.getFactorySerialNumber());
        airplane.setAirCompany(airCompany);
        airplane.setNumberOfFlights(request.getNumberOfFlights());
        airplane.setFlightDistance(request.getFlightDistance());
        airplane.setFuelCapacity(request.getFuelCapacity());
        airplane.setType(request.getType());
        airplane.setCreatedAt(request.getCreatedAt());
        airplane.setFlight(null);

        airplaneRepository.save(airplane);
    }
}
