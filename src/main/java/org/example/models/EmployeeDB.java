package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDB {

    private Integer id;

    private String name;

    private String street;

    @JsonProperty("manager_id")
    private Integer managerId;
}
