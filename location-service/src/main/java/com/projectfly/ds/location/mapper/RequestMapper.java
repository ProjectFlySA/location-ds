package com.projectfly.ds.location.mapper;

import com.projectfly.ds.location.entity.Location;
import com.projectfly.ds.location.model.LocationRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper {

    public Location map(LocationRequest request) {
        Location location = new Location();

        location.setName(request.getName());
        location.setCountryName(request.getCountryName());
        location.setAlpha3Code(request.getAlpha3Code());

        return location;
    }
}
