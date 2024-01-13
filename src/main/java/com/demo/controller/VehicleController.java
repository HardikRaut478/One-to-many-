
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
@RequestMapping(value = "/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vs;
	
	@Autowired
	private UserService us;
	
	//get all vehicle
	@GetMapping()
	public List<VEHICLE> v1(){
		return vs.findAll();
	}
	
	//get vehicle by id
	@GetMapping(value = "/{id}")
	public VEHICLE c1(@PathVariable Integer id){
		return vs.findById(id);
	}
	
	//get vehicle no by user
	@GetMapping(value = "/foruser/{user_id}")
	public List<VEHICLE> v3(@PathVariable Integer user_id) {
		USER user = us.findById(user_id);
		return vs.findVehiclesByUser(user);
	}
	
	//post vehicle
	@PostMapping(value = "/{id}")
	public VEHICLE v2(@PathVariable Integer id, @RequestBody VEHICLE v) 
	{
		USER user = us.findById(id);
		v.setUser(user);
		return vs.save(v);
	}
	
	//update vehicle
	@PutMapping(value = "/{id}")
	public VEHICLE v4(@PathVariable Integer id, @RequestBody VEHICLE vNew) 
	{
		VEHICLE vOld = vs.findById(id);
		if(vOld==null) return null;
		vOld.setName(vNew.getName());
		vOld.setFeedback(vNew.getFeedback());
		return vs.save(vOld);
	}
	
	//delete vehicle
	@DeleteMapping("/{id}")
	public void v5(@PathVariable Integer id) {
		vs.deleteById(id);
	}
}
