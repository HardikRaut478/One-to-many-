package com.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.USER;
import com.demo.model.VEHICLE;

@Repository
public interface VehicleDao extends JpaRepository<VEHICLE, Integer>{
//	List<VEHICLE> findAll();
//	VEHICLE save(VEHICLE c);
	List<VEHICLE> findByUser(USER user);
//	List<VEHICLE> findByUser_Id(Integer userId);
}
