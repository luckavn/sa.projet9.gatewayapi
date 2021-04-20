package com.axa.softwareacademy.apigateway.client;

import com.axa.softwareacademy.apigateway.configuration.ClientConfiguration;
import com.axa.softwareacademy.apigateway.model.Patient;
import com.axa.softwareacademy.apigateway.request.PatientSaveRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        value = "patientClient",
        url = "${patient.api.url}",
        configuration = ClientConfiguration.class
)
public interface PatientClient {

    @GetMapping("/patients/given-name")
    Patient findPatientByGivenName(@RequestParam String givenName);

    @GetMapping("/patients/family-name")
    Patient findPatientByFamilyName(@RequestParam String familyName);

    @GetMapping("/patients/id")
    Patient findPatientById(@RequestParam Integer id);

    @GetMapping("/patients")
    List<Patient> patientList();

    @PostMapping("/patients")
    void savePatient(@RequestBody PatientSaveRequest patientSaveRequest);

    @PutMapping("/patients")
    void updatePatient(@RequestBody PatientSaveRequest patientSaveRequest, @RequestParam Integer id);

    @DeleteMapping("/patients")
    void deletePatient(@RequestParam Integer id);

}
