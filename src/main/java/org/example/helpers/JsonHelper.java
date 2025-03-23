package org.example.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.example.dto.Employee;
import org.example.dto.EmployeeIdentityInfo;
import org.example.dto.EmployeeJsonIgnoreProperties;
import org.example.models.EmployeeDB;

import java.io.*;
import java.util.List;

import static java.util.stream.Collectors.joining;

@NoArgsConstructor()
public final class JsonHelper {

    private final ObjectMapper mapper = new ObjectMapper();

    public List<Employee> createDbEntries() throws IOException {
        var entitiesStream = getClass().getClassLoader().getResourceAsStream("entities.json");

        List<EmployeeDB> listEmployeeEntities;
        try (var streamReader = new BufferedReader(new InputStreamReader(entitiesStream))) {
            var jsonString = streamReader.lines().collect(joining("\n"));

            listEmployeeEntities = mapper.readerForListOf(EmployeeDB.class).readValue(jsonString);

        }

        return Mapper.mapToEmployee(listEmployeeEntities);
    }

    public List<EmployeeIdentityInfo> createDbEntriesWithIdentityInfo() throws IOException {
        var entitiesStream = getClass().getClassLoader().getResourceAsStream("entities.json");

        List<EmployeeDB> listEmployeeEntities;
        try (var streamReader = new BufferedReader(new InputStreamReader(entitiesStream))) {
            var jsonString = streamReader.lines().collect(joining("\n"));

            listEmployeeEntities = mapper.readerForListOf(EmployeeDB.class).readValue(jsonString);

        }

        return Mapper.mapToEmployeeWithIdentityInfo(listEmployeeEntities);
    }

    public List<EmployeeJsonIgnoreProperties> createDbEntriesWithJsonIgnoreProperties() throws IOException {
        var entitiesStream = getClass().getClassLoader().getResourceAsStream("entities.json");

        List<EmployeeDB> listEmployeeEntities;
        try (var streamReader = new BufferedReader(new InputStreamReader(entitiesStream))) {
            var jsonString = streamReader.lines().collect(joining("\n"));

            listEmployeeEntities = mapper.readerForListOf(EmployeeDB.class).readValue(jsonString);

        }

        return Mapper.mapToEmployeeWithJsonIgnoreProperties(listEmployeeEntities);
    }

}
