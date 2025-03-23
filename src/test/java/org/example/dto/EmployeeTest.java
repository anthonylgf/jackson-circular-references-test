package org.example.dto;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.helpers.JsonHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private JsonHelper jsonHelper = new JsonHelper();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void test_employee_serialization() throws IOException {
        List<Employee> employeeList = jsonHelper.createDbEntries();

        var exception = assertThrows(JsonMappingException.class, () -> objectMapper.writeValueAsString(employeeList));

        assertTrue(exception.getMessage().contains("Document nesting depth"));
    }
}