package com.test.AirService.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Air company
 * ID, name, company type, founded at
 */

@Entity
@Table(name = "aircompany")
public class AirCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private String companyType;
    private LocalDateTime foundedAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "airCompany")
    private List<Airplane> airplanesList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "airCompany")
    private List<Flight> flightList;

    public AirCompany() {
    }

    public AirCompany(String name, String companyType, LocalDateTime foundedAt, List<Airplane> airplanesList, List<Flight> flightList) {
        this.name = name;
        this.companyType = companyType;
        this.foundedAt = foundedAt;
        this.airplanesList = airplanesList;
        this.flightList = flightList;
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

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public LocalDateTime getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(LocalDateTime foundedAt) {
        this.foundedAt = foundedAt;
    }

    public List<Airplane> getAirplanesList() {
        return airplanesList;
    }

    public void setAirplanesList(List<Airplane> airplanesList) {
        this.airplanesList = airplanesList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }
}
