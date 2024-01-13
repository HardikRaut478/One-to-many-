package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.USER;
import com.demo.model.VEHICLE;
import com.demo.service.UserService;
import com.demo.service.VehicleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private VehicleService vs;
	
	@GetMapping()
	public List<USER> c1(){
		return us.findAll();
	}
	
	//get user by id
	@GetMapping(value = "/{id}")
	public USER c1(@PathVariable Integer id){
		return us.findById(id);
	}
	
	//get vehicle by user id
	@GetMapping(value = "/forvehicle/{vehicle_id}")
	public USER c6(@PathVariable Integer vehicle_id) {
		VEHICLE vehicle = vs.findById(vehicle_id);
		return vehicle.getUser();
	}

	//get numbers of user
	@GetMapping(value="/count")
	public long c3() {
		return us.count();
	}
	
	//post user
	@PostMapping()
	public USER c2(@RequestBody USER u) 
	{
		return us.save(u);
	}
	
	//update user by id 
	@PutMapping(value = "/{id}")
	public USER c4(@PathVariable Integer id, @RequestBody USER uNew) 
	{
		USER uOld = us.findById(id);
		if(uOld==null) return null;
		uOld.setName(uNew.getName());
		uOld.setPassword(uNew.getPassword());
		uOld.setRole(uNew.getRole());
		return us.save(uOld);
	}
	
	//delete user
	@DeleteMapping("/{id}")
	public void c5(@PathVariable Integer id) {
		us.deleteById(id);
	}
	
}
