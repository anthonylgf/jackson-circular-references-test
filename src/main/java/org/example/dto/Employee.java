package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Employee {

    private Integer id;

    private String name;

    private String street;

    private Employee manager;

    private List<Employee> underlings = List.of();
}
