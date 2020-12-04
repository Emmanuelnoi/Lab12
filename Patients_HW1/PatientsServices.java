package com.sw409.PatientsDemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sw409.PatientsDemo.models.Patient;

public class PatientsServices {

	List<Patient> patientList = new ArrayList<>();

	// create
	public Patient createsPatient(Patient patient) {
		patientList.add(patient);
		return patient;
	}

	// Read
	public List<Patient> findAllPatients() {
		return patientList;

	}

	// getting name of all patients by illness
	public List<String> getPatientByIllness(String illness) {
		List<String> patientName = new ArrayList<>();
		for (int i = 0; i < patientList.size(); i++) {
			if (illness.equalsIgnoreCase(patientList.get(i).getIllness())) {
				patientName.add(patientList.get(i).getName());

			}
		}
		return patientName;
	}

	// update
	public void updatesPatient(Integer id, Patient p) {
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getId().equals(id)) {
				patientList.set(i, p);
			}

		}
	}

	// Delete
	public void deletePatient(Integer id) {
		List<Patient> found = new ArrayList<>();
		for (Patient delPatient : patientList) {
			if (delPatient.getId().equals(id)) {
				found.add(delPatient);
			}
		}
		patientList.removeAll(found);
	}
}
