package com.axa.softwareacademy.apigateway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Patient {
    private Integer id;
    private String familyName;
    private String givenName;
    private String address;
    private Date dob;
    private String sex;
    private String phone;


}

