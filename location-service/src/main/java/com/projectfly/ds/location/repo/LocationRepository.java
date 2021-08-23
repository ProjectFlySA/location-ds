package com.projectfly.ds.location.repo;

import com.projectfly.ds.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface LocationRepository extends JpaRepository<Location, UUID> {
}
