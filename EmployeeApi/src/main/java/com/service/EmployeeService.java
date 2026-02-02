package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Employee;
import com.repository.EmployeeRepository;
import com.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        log.info("Creating employee: " + employee.getName());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {

        if (employeeRepository.findById(id).isPresent()) {
            log.info("Fetching employee with id: " + id);
            return employeeRepository.findById(id).get();
        } else {
            log.error("Employee not found with id: " + id);
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {

		if (employeeRepository.existsById(id)) {
            log.info("Deleting employee with id: " + id);

			employeeRepository.deleteById(id);
		} else {
            log.error("Delete failed. Employee not found: " + id);
			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}
    }
}
