package org.example.helpers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dto.Employee;
import org.example.dto.EmployeeIdentityInfo;
import org.example.dto.EmployeeJsonIgnoreProperties;
import org.example.models.EmployeeDB;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Mapper {

    public static List<Employee> mapToEmployee(List<EmployeeDB> employeeDBS) {
        var employeeIdMap = new HashMap<Integer, Employee>();

        // create the employee list first
        for (EmployeeDB employeeDB : employeeDBS) {
            var employee = new Employee();
            employee.setId(employeeDB.getId());
            employee.setName(employeeDB.getName());
            employee.setStreet(employeeDB.getStreet());
            employeeIdMap.put(employee.getId(), employee);
        }

        // fill manager id and underlying list
        for (EmployeeDB employeeDB : employeeDBS) {
            var employee = employeeIdMap.get(employeeDB.getId());
            var manager = employeeIdMap.get(employeeDB.getManagerId());
            employee.setManager(manager);

            var underlings = employeeDBS.stream()
                    .filter(e -> employee.getId().equals(e.getManagerId()))
                    .map(e -> employeeIdMap.get(e.getId()))
                    .toList();

            employee.setUnderlings(underlings);
        }

        return List.copyOf(employeeIdMap.values());
    }

    public static List<EmployeeIdentityInfo> mapToEmployeeWithIdentityInfo(List<EmployeeDB> employeeDBS) {
        var employeeIdMap = new HashMap<Integer, EmployeeIdentityInfo>();

        // create the employee list first
        for (EmployeeDB employeeDB : employeeDBS) {
            var employee = new EmployeeIdentityInfo();
            employee.setId(employeeDB.getId());
            employee.setName(employeeDB.getName());
            employee.setStreet(employeeDB.getStreet());
            employeeIdMap.put(employee.getId(), employee);
        }

        // fill manager id and underlying list
        for (EmployeeDB employeeDB : employeeDBS) {
            var employee = employeeIdMap.get(employeeDB.getId());
            var manager = employeeIdMap.get(employeeDB.getManagerId());
            employee.setManager(manager);

            var underlings = employeeDBS.stream()
                    .filter(e -> employee.getId().equals(e.getManagerId()))
                    .map(e -> employeeIdMap.get(e.getId()))
                    .toList();

            employee.setUnderlings(underlings);
        }

        return List.copyOf(employeeIdMap.values());
    }

    public static List<EmployeeJsonIgnoreProperties> mapToEmployeeWithJsonIgnoreProperties(List<EmployeeDB> employeeDBS) {
        var employeeIdMap = new HashMap<Integer, EmployeeJsonIgnoreProperties>();

        // create the employee list first
        for (EmployeeDB employeeDB : employeeDBS) {
            var employee = new EmployeeJsonIgnoreProperties();
            employee.setId(employeeDB.getId());
            employee.setName(employeeDB.getName());
            employee.setStreet(employeeDB.getStreet());
            employeeIdMap.put(employee.getId(), employee);
        }

        // fill manager id and underlying list
        for (EmployeeDB employeeDB : employeeDBS) {
            var employee = employeeIdMap.get(employeeDB.getId());
            var manager = employeeIdMap.get(employeeDB.getManagerId());
            employee.setManager(manager);

            var underlings = employeeDBS.stream()
                    .filter(e -> employee.getId().equals(e.getManagerId()))
                    .map(e -> employeeIdMap.get(e.getId()))
                    .toList();

            employee.setUnderlings(underlings);
        }

        return List.copyOf(employeeIdMap.values());
    }

}
