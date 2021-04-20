package com.axa.softwareacademy.apigateway.client;

import com.axa.softwareacademy.apigateway.configuration.ClientConfiguration;
import com.axa.softwareacademy.apigateway.enums.RiskType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "riskClient",
        url = "${risk.api.url}",
        configuration = ClientConfiguration.class
)
public interface RiskClient {

    @GetMapping("/risk/patientId")
    RiskType calculateRiskWithPatientId(@RequestParam String id);

    @GetMapping("/risk/patientFamilyName")
    RiskType calculateRiskWithFamilyName(@RequestParam String familyName);
}
