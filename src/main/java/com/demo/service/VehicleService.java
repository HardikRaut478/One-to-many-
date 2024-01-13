 package com.demo.service;

import java.util.List;

import com.demo.model.USER;
import com.demo.model.VEHICLE;

public interface VehicleService {
	List<VEHICLE> findAll();
	List<VEHICLE> findByUserId(Integer id);
	VEHICLE save(VEHICLE c);
	public List<VEHICLE> findVehiclesByUser(USER user);
	VEHICLE findById(Integer id);
	void deleteById(Integer id);
}
