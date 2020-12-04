package com.sw409.PatientsDemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw409.PatientsDemo.Repositories.PatientRepository;
import com.sw409.PatientsDemo.models.Patient;
@Service
public class PatientsServices {

	List<Patient> patientList = new ArrayList<>();
	@Autowired
	PatientRepository patientRepository;
	// create
	public Patient createsPatient(Patient patient) {
		//patientList.add(patient);
		return patientRepository.save(patient);
	}

	// Read
	public List<Patient> findAllPatients() {
		return (List<Patient>) patientRepository.findAll();

	}

	// getting name of all patients by illness
	public List<String> getPatientByIllness(String illness) {
		List<String> patientName = new ArrayList<>();
		for (int i = 0; i < patientList.size(); i++) {
			if (illness.equalsIgnoreCase(patientList.get(i).getIllness())) {
				patientName.add(patientList.get(i).getName());

			}
		}
		return patientName ;
	}

	// update
	public void updatesPatient(Integer id, Patient p) {
		Patient oldpatient = patientRepository.findById(id).get();
		oldpatient.setName(p.getName());
		oldpatient.setGender(p.getGender());
		oldpatient.setIllness(p.getIllness());
		
		patientRepository.save(p);
		
		
	}

	// Delete
	public void deletePatient(Integer id) {
		List<Patient> found = new ArrayList<>();
		for (Patient delPatient : patientList) {
			if (delPatient.getId().equals(id)) {
				found.add(delPatient);
			}
		}
		patientRepository.deleteById(id);
	}
}
