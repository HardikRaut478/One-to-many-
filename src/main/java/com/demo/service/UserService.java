package com.demo.service;

import java.util.List;

import com.demo.model.USER;

public interface UserService{
	List<USER> findAll();
	USER findById(Integer id);
	USER save(USER u);
	long count();
	void deleteById(Integer id);
//	List<USER> findUsersByVehicle(VEHICLE vehicle);
}
