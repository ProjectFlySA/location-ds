package com.projectfly.ds.location.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "LocationId")
    private UUID id;

    @Column(name = "CountryName")
    private String CountryName;

    @Column(name = "Name")
    private String name;

    @Column(name = "Alpha3Code")
    private String alpha3Code;

    public UUID getId() {
        return id;
    }

    /*
    public void setId(UUID id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }
}
