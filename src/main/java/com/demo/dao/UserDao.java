package com.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.USER;


@Repository
public interface UserDao extends JpaRepository<USER, Integer>{
//	List<USER> findAll();
	USER findUserById(int id);
	long count();
//	List<USER> findUsersByVehicle(VEHICLE vehicle);
}


