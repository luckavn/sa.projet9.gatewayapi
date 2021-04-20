package com.axa.softwareacademy.apigateway.controller;

import com.axa.softwareacademy.apigateway.client.RiskClient;
import com.axa.softwareacademy.apigateway.enums.RiskType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk")
@RequiredArgsConstructor
@CrossOrigin
public class RiskController {

    private final RiskClient riskClient;

    /**
     * This endpoint is aimed to calculate a risk of a patient
     * @param id is the unique id number of the patient
     * @return a risk
     */
    @GetMapping("patientId")
    public RiskType calculateRiskWithPatientId(@RequestParam String id) {
        return riskClient.calculateRiskWithPatientId(id);
    }

    /**
     * This endpoint is aimed to calculate a risk of a patient
     * @param familyName is the value of last name of a patient
     * @return a risk
     */
    @GetMapping("patientFamilyName")
    public RiskType calculatePatientRiskWithFamilyName(@RequestParam String familyName) {
        return riskClient.calculateRiskWithFamilyName(familyName);
    }
}
