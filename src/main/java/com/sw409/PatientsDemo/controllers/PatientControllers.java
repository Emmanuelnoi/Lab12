package com.sw409.PatientsDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sw409.PatientsDemo.models.Patient;
import com.sw409.PatientsDemo.services.PatientsServices;

@RestController
public class PatientControllers {
	
	@Autowired
	PatientsServices patService;
	
	//Create
	@PostMapping ("api/v1/patients")
	public Patient createsPatient (@RequestBody Patient patient)
	{
		return patService.createsPatient(patient);
	}
	
	//Read
	@GetMapping ("api/v1/patients")
	public List<Patient> findAllPatients()
	{
		return patService.findAllPatients();
	}
	
	//Read GET patient names that have illness sent in the url
	@GetMapping ("api/v1/patients/{illness}")
	public List<String> getPatientByIllness(@PathVariable String illness) 
	{
		return patService.getPatientByIllness(illness);
	}
	
	//Update
	@PutMapping ("api/v1/patients/{patientid}")
	public void updatesPatient(@PathVariable("patientid")Integer id, @RequestBody Patient patient)
	{
		patService.updatesPatient(id, patient);
	}
	
	//Delete
	@DeleteMapping ("api/v1/patients/{id}")
	public void deletePatient (@PathVariable Integer id)
	{
		patService.deletePatient(id);
	}

}
