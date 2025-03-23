package org.example.dto;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.helpers.JsonHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeIdentityInfoTest {

    private JsonHelper jsonHelper = new JsonHelper();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void test_employee_serialization() throws IOException {
        List<EmployeeIdentityInfo> employeeList = jsonHelper.createDbEntriesWithIdentityInfo();

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

        var response = assertThrows(JsonMappingException.class, () -> objectMapper.readValue(jsonString, EmployeeIdentityInfo.class));

        assertTrue(response.getMessage().contains("Already had POJO for id"));
    }
}