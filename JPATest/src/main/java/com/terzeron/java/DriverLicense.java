package com.terzeron.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class DriverLicense {
    String licenseId;
    Employee employee;
}
