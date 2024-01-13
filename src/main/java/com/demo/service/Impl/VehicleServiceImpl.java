package com.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDao;
import com.demo.dao.VehicleDao;
import com.demo.model.USER;
import com.demo.model.VEHICLE;
import com.demo.service.VehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleDao vd;
	
	@Autowired
	private UserDao ud;
	
	//list of vehicle
	@Override
	public List<VEHICLE> findAll() {
		return vd.findAll();
	}

	//save vehicle
	@Override
	public VEHICLE save(VEHICLE v) {
		return vd.save(v);
	}

	//find list vehicle by user id
	@Override
	public List<VEHICLE> findByUserId(Integer id) {
		USER user = ud.findById(id).orElse(null);
		if(user!=null)
			return vd.findByUser(user);
		return null;
	}

	//find list of vehicle by user
	@Override
	public List<VEHICLE> findVehiclesByUser(USER user) {
		return vd.findByUser(user);
	}

	//
	@Override
	public VEHICLE findById(Integer id) {
		return vd.findById(id).orElse(null);
	}
	
	//delete by id
	@Override
	public void deleteById(Integer id) {
		VEHICLE vehicle = findById(id);
		vd.delete(vehicle);
	}

}
