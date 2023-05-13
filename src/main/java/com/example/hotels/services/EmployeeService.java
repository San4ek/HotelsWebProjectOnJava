package com.example.hotels.services;

import com.example.hotels.models.Employee;
import com.example.hotels.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void editEmployee(Long id, Employee employee) {
        employee.setId(id);
        employeeRepository.save(employee);
    }
}
