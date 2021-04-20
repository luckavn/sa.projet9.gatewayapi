package com.axa.softwareacademy.apigateway.controller;

import com.axa.softwareacademy.apigateway.client.PatientClient;
import com.axa.softwareacademy.apigateway.model.Patient;
import com.axa.softwareacademy.apigateway.request.PatientSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@CrossOrigin
public class PatientController {

    private final PatientClient patientClient;

    /**
     * This endpoint is aimed to find patient information
     * @param givenName is the first name of the patient
     * @return the patient
     */
    @GetMapping("given-name")
    public Patient getPatientByGivenName(@RequestParam String givenName) {
        return patientClient.findPatientByGivenName(givenName);
    }

    /**
     * This endpoint is aimed to find patient information
     * @param familyName is the last name of the patient
     * @return the patient
     */
    @GetMapping("family-name")
    public Patient getPatientByFamilyName(@RequestParam String familyName) {
        return patientClient.findPatientByFamilyName(familyName);
    }

    /**
     * This endpoint is aimed to find patient information
     * @param id is the unique id number of the patient
     * @return the patient
     */
    @GetMapping("id")
    public Patient getPatientById(@RequestParam Integer id) {
        return patientClient.findPatientById(id);
    }

    /**
     * This endpoint is aimed to find a list of patient information
     * @return a list of all patients
     */
    @GetMapping
    public List<Patient> patientList() {
        return patientClient.patientList();
    }

    /**
     * This endpoint is aimed to add a patient to database
     */
    @PostMapping
    public void addPatient(@RequestBody @Valid PatientSaveRequest patientSaveRequest) {
        patientClient.savePatient(patientSaveRequest);
    }

    /**
     * This endpoint is aimed to modify a patient present in database
     */
    @PutMapping
    public void modifyPatient(@RequestBody @Valid PatientSaveRequest patientSaveRequest, @RequestParam Integer id) {
        patientClient.updatePatient(patientSaveRequest, id);
    }

    /**
     * This endpoint is aimed to delete a patient present in database
     * @param id is the unique id number of the patient
     */
    @DeleteMapping
    public void deletePatient(@RequestParam Integer id) {
        patientClient.deletePatient(id);
    }

}
