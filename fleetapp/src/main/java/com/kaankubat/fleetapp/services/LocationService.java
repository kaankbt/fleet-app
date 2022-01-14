package com.kaankubat.fleetapp.services;

import com.kaankubat.fleetapp.models.Location;
import com.kaankubat.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	public List<Location> findAll() {
		return (List<Location>) locationRepository.findAll();
	}

	public Optional<Location> findById(Integer id) {
		return locationRepository.findById(id);
	}
	
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	public void deleteById(Integer id) {
		locationRepository.deleteById(id);
	}

	public List<Location> findByDescriptionContaining(String description) {
		return null;
	}	
}
