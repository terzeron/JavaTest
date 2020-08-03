package com.terzeron.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Phone {
    String number;
    String phoneId;
    Employee employee;
}
