package com.axa.softwareacademy.apigateway.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteSaveRequest {

    private String noteDetail;
    private String patientId;
}
