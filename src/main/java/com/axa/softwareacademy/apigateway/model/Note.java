package com.axa.softwareacademy.apigateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Note {

    private String noteId;
    private String noteDetail;
    private String patientId;
}
