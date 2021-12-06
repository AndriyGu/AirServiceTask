package com.test.AirService.service;

import com.test.AirService.model.AirCompany;
import com.test.AirService.model.Airplane;
import com.test.AirService.model.DTO.requestDTO.FlightAddDTO;
import com.test.AirService.model.DTO.requestDTO.FlightStatusChangeDTO;
import com.test.AirService.model.DTO.responseDTO.FlightDTO;
import com.test.AirService.model.Flight;
import com.test.AirService.model.FlightStatus;
import com.test.AirService.repository.AirCompanyRepository;
import com.test.AirService.repository.AirplaneRepository;
import com.test.AirService.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class FlightService {

    @Autowired
    AirCompanyRepository airCompanyRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    AirplaneRepository airplaneRepository;

    //find all Air Company Flights by status (use company name for identification of Air Company)
    public ResponseEntity<Page<FlightDTO>> findFlightsByStatusAndCompany(FlightStatus status, String companyName, int currentPage, int pageSize) {


        AirCompany airCompany = airCompanyRepository.findByName(companyName).get();
        if (airCompany == null) {
            return new ResponseEntity<Page<FlightDTO>>(HttpStatus.NOT_FOUND);
        }
            List<Flight> flightList = flightRepository.findAllFlightByStatusAndCompanyId(status, airCompany.getId());
            if (flightList.isEmpty()) {
                return new ResponseEntity<Page<FlightDTO>>(HttpStatus.NOT_FOUND);
            }
                List<FlightDTO> flightDTOList = makeFlightDTOList(flightList);

                Page<FlightDTO> res = findPaginated(flightDTOList, PageRequest.of(currentPage - 1, pageSize));
                return new ResponseEntity<Page<FlightDTO>>(res, HttpStatus.OK);
    }

    //find all Flights in ACTIVE status and started more than 24 hours ago.
    public ResponseEntity<Page<FlightDTO>> findAllACTIVEFlights(int currentPage, int pageSize) {

            LocalDateTime localDate =LocalDateTime.now().minusDays(1);
            List<Flight> flightList = flightRepository.findAllActiveFlightOld(FlightStatus.ACTIVE, localDate);

            if (flightList.isEmpty()){
                return new ResponseEntity<Page<FlightDTO>>(HttpStatus.NOT_FOUND);
            }
                List<FlightDTO> flightDTOList = makeFlightDTOList(flightList);
                Page<FlightDTO> res = findPaginated(flightDTOList, PageRequest.of(currentPage - 1, pageSize));

                return new ResponseEntity<Page<FlightDTO>>(res, HttpStatus.OK);
    }

    //add new Flight (set status to PENDING)
    public ResponseEntity<String> addNewFlight(FlightAddDTO request){
        Optional<AirCompany> airCompanyOp = airCompanyRepository.findByName(request.getAirCompanyName());
        Optional<Airplane> airplaneOp = airplaneRepository.findByName(request.getAirplaneName());
        AirCompany airCompany = airCompanyOp.get();
        Airplane airplane = airplaneOp.get();

        if(airCompanyOp.isEmpty() || airplaneOp.isEmpty()){
            return new ResponseEntity<String>("Airplane or AirCompany are not found.", HttpStatus.NOT_FOUND);
        }
        else{
            if(airplane.getAirCompany()==null){
                return new ResponseEntity<String>("Airplane does not belong to AirCompany", HttpStatus.BAD_REQUEST);
            }
            //Check
            if(airCompany.getId()!=airplane.getAirCompany().getId()){
                return new ResponseEntity<String>("Airplane belong to another AirCompany", HttpStatus.BAD_REQUEST);
            }
            else{
                Flight flight = new Flight();
                flight.setAirCompany(airCompany);
                flight.setAirplane(airplane);
                flight.setFlightStatus(FlightStatus.PENDING);
                flight.setDepartureCountry(request.getDepartureCountry());
                flight.setDestinationCountry(request.getDestinationCountry());
                flight.setCreatedAt(request.getCreatedAt());

                flightRepository.save(flight);
                return new ResponseEntity<String>("New flight added", HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<String> changeFlightStatus(FlightStatusChangeDTO request){
        // if status to change is DELAYED – set delay started at
        // if status to change is ACTIVE – set started at
        // if status to change is COMPLETED set ended at

        Flight flight = flightRepository.findFlightById(request.getFlightId());
        if(flight==null){
            return new ResponseEntity<String>("Flight is not found.", HttpStatus.NOT_FOUND);
        }

        switch (request.getFlightStatus()) {
            case  DELAYED :
                flight.setFlightStatus(FlightStatus.DELAYED);
                flight.setDelayStartedAt(LocalDateTime.now());
                break;
            case ACTIVE:
                flight.setFlightStatus(FlightStatus.ACTIVE);
                flight.setStartedAt(LocalDateTime.now());
                break;
            case COMPLETED:
                flight.setFlightStatus(FlightStatus.COMPLETED);
                flight.setEndedAt(LocalDateTime.now());
                break;
        }

        flightRepository.save(flight);
        return new ResponseEntity<String>("Flight updated", HttpStatus.OK);
    }

    public ResponseEntity<Page<FlightDTO>> findCompletedFlights(int currentPage, int pageSize){
        List<Flight> flightList = flightRepository.findAllCompleted(FlightStatus.COMPLETED.toString());
        if (flightList.isEmpty()){
            return new ResponseEntity<Page<FlightDTO>>(HttpStatus.NOT_FOUND);}

        List<FlightDTO> flightDTOList = makeFlightDTOList(flightList);
        Page<FlightDTO> res = findPaginated(flightDTOList, PageRequest.of(currentPage - 1, pageSize));

        return new ResponseEntity<Page<FlightDTO>>(res, HttpStatus.OK);
    }

    private Page<FlightDTO> findPaginated(List<FlightDTO> flightDTOS, Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<FlightDTO> list;

        if (flightDTOS.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, flightDTOS.size());
            list = flightDTOS.subList(startItem, toIndex);
        }
        Page<FlightDTO> bookPage
                = new PageImpl<FlightDTO>(list, PageRequest.of(currentPage, pageSize), flightDTOS.size());

        return bookPage;
    }

    //Make flightDTO from fligh
    private List<FlightDTO> makeFlightDTOList(List<Flight> flightList){
        List<FlightDTO> flightDTOList = new ArrayList<FlightDTO>();
        for (Flight temp : flightList) {
            FlightDTO fDTO = new FlightDTO();
            fDTO.setId(temp.getId());
            fDTO.setFlightStatus(temp.getFlightStatus());
            fDTO.setAirCompany(temp.getAirCompany().getName());
            fDTO.setCreatedAt(temp.getCreatedAt());

            flightDTOList.add(fDTO);
        }
        return flightDTOList;
    }


}
