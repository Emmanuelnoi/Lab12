package com.sw409.PatientsDemo.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sw409.PatientsDemo.models.Patient;

public interface PatientRepository  extends CrudRepository<Patient, Integer>{


}
