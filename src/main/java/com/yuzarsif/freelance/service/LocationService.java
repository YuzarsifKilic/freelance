package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.exceptioin.LocationNotFoundException;
import com.yuzarsif.freelance.model.Location;
import com.yuzarsif.freelance.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    protected Location findLocationById(Long id) {
        Location location = repository.findById(id)
                .orElseThrow(
                        () -> new LocationNotFoundException("Location didnt find by id : " + id));

        return location;
    }
}
