package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.LocationDto;
import com.yuzarsif.freelance.exceptioin.LocationNotFoundException;
import com.yuzarsif.freelance.model.Location;
import com.yuzarsif.freelance.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<LocationDto> findLocationByCountryOrCity(String location) {
        List<Location> byCountryContaining = repository.findByCountryContaining(location);

        if (byCountryContaining.isEmpty()) {
            List<Location> byCityContaining = repository.findByCityContaining(location);
            return byCityContaining.stream()
                    .map(LocationDto::convert)
                    .collect(Collectors.toList());
        } else {
            return byCountryContaining.stream()
                    .map(LocationDto::convert)
                    .collect(Collectors.toList());
        }
    }

    protected Location findLocationById(Long id) {
        Location location = repository.findById(id)
                .orElseThrow(
                        () -> new LocationNotFoundException("Location didnt find by id : " + id));

        return location;
    }
}
