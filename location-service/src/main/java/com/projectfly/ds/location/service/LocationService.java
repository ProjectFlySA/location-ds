package com.projectfly.ds.location.service;

import com.projectfly.ds.location.entity.Location;
import com.projectfly.ds.location.mapper.RequestMapper;
import com.projectfly.ds.location.model.LocationRequest;
import com.projectfly.ds.location.repo.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    private static final Logger LOG = LoggerFactory.getLogger(LocationService.class);

    private final LocationRepository repository;
    private final RequestMapper requestMapper;

    @Autowired
    public LocationService(LocationRepository repository,
                           RequestMapper requestMapper) {
        this.repository = repository;
        this.requestMapper = requestMapper;

        for (LocationRequest request : requestList()) {
            Location location = requestMapper.map(request);
            Location result = repository.save(location);
            LOG.info("result -> {}", result);
        }
    }

    private List<LocationRequest> requestList() {

        ArrayList<LocationRequest> locationRequestArrayList = new ArrayList<>();

        LocationRequest request1 = new LocationRequest();
        request1.setCountryName("South Africa");
        request1.setName("Cape Town, South Africa");
        request1.setAlpha3Code("CPT");

        locationRequestArrayList.add(request1);

        LocationRequest request2 = new LocationRequest();
        request2.setCountryName("South Africa");
        request2.setName("Johannesburg, South Africa");
        request2.setAlpha3Code("JNB");

        locationRequestArrayList.add(request2);

        LocationRequest request3 = new LocationRequest();
        request3.setCountryName("South Africa");
        request3.setName("Lanseria, South Africa");
        request3.setAlpha3Code("HLA");

        locationRequestArrayList.add(request3);

        LocationRequest request4 = new LocationRequest();
        request4.setCountryName("South Africa");
        request4.setName("Durban, South Africa");
        request4.setAlpha3Code("DUR");

        locationRequestArrayList.add(request4);

        LocationRequest request5 = new LocationRequest();
        request5.setCountryName("South Africa");
        request5.setName("Port Elizabeth, South Africa");
        request5.setAlpha3Code("PLZ");

        locationRequestArrayList.add(request5);

        LocationRequest request6 = new LocationRequest();
        request6.setCountryName("South Africa");
        request6.setName("Mpumalanga, South Africa");
        request6.setAlpha3Code("MQP");

        locationRequestArrayList.add(request6);

        return locationRequestArrayList;
    }

    public List<Location> getLocations() {
        return repository.findAll();
    }

    public Location saveLocation(LocationRequest request) {
        Location location = requestMapper.map(request);
        return repository.save(location);
    }
}
