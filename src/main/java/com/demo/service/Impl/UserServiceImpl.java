package com.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDao;
import com.demo.model.USER;
import com.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao ud;
	
	//get all user
	@Override
	public List<USER> findAll() {
		return ud.findAll();
	}
	
	//find user by id
	@Override
	public USER findById(Integer id) {
		return ud.findById(id).orElse(null);
	}
	
	//save user 
	@Override
	public USER save(USER u) {
		return ud.save(u);
	}
	
	//count user
	@Override
	public long count() {
		return ud.count();
	}
	
	//delete user
	@Override
	public void deleteById(Integer id) {
		USER user = findById(id);
		ud.delete(user); 
	}
	
//	@Override
//	public List<USER> findUsersByVehicle(VEHICLE vehicle) {
//		
//		return ud.findUsersByVehicle(vehicle);
//	}

}





