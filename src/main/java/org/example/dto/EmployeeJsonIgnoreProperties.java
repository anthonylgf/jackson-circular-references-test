package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeJsonIgnoreProperties {

    private Integer id;

    private String name;

    private String street;

    @JsonIgnoreProperties({"underlings"})
    private EmployeeJsonIgnoreProperties manager;

    private List<EmployeeJsonIgnoreProperties> underlings = List.of();

}
