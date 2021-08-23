package com.projectfly.ds.location.rest;

import com.projectfly.ds.location.entity.Location;
import com.projectfly.ds.location.model.LocationRequest;
import com.projectfly.ds.location.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping("/locations")
    public Collection<Location> getEmployees() {
        return service.getLocations();
    }

    @PostMapping("/locations")
    public Location addEmployee(@RequestBody LocationRequest request) {
        return service.saveLocation(request);
    }
}
