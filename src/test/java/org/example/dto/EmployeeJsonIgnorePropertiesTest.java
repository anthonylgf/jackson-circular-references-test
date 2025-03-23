package org.example.dto;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.helpers.JsonHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EmployeeJsonIgnorePropertiesTest {

    private JsonHelper jsonHelper = new JsonHelper();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void test_employee_serialization() throws IOException {
        List<EmployeeJsonIgnoreProperties> employeeList = jsonHelper.createDbEntriesWithJsonIgnoreProperties();

        var response = assertDoesNotThrow(() -> objectMapper.writeValueAsString(employeeList));

        assertNotNull(response);

        System.out.println(response);
    }

    @Test
    void test_employee_deserialization() throws IOException {
        var jsonString = """
                {
                  "id": 2,
                  "name": "Linda R. White",
                  "street": "Square Passage",
                  "manager": {
                    "id": 1,
                    "name": "Noel J. Young",
                    "street": "Estate Avenue"
                  },
                  "underlings": [
                    {
                      "id": 3,
                      "name": "Kenneth Y. McClure",
                      "street": "Bell Route",
                      "manager": {
                        "id": 2,
                        "name": "Linda R. White",
                        "street": "Square Passage"
                      }
                    }
                  ]
                }
                """;

        var response = objectMapper.readValue(jsonString, EmployeeJsonIgnoreProperties.class);

        assertNotNull(response);
    }
}