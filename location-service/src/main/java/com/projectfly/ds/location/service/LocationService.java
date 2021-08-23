package com.projectfly.ds.location.service;

import com.projectfly.ds.location.entity.Location;
import com.projectfly.ds.location.mapper.RequestMapper;
import com.projectfly.ds.location.model.LocationRequest;
import com.projectfly.ds.location.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository repository;
    private final RequestMapper requestMapper;

    @Autowired
    public LocationService(LocationRepository repository,
                           RequestMapper requestMapper) {
        this.repository = repository;
        this.requestMapper = requestMapper;
    }

    public List<Location> getLocations() {
        return repository.findAll();
    }

    /*public Collection<Location> findAll() {
        Collection<Location> locations = repository.findAll();
        return locations;
    }*/

    /*public Location save(Location location) {
        return repository.save(location);
    }*/

    public Location saveLocation(LocationRequest request) {
        Location location = requestMapper.map(request);
        return repository.save(location);
    }
}
