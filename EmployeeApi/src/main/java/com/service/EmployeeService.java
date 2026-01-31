package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Employee;
import com.repository.EmployeeRepository;
import com.exception.EmployeeNotFoundException;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {

        if (employeeRepository.findById(id).isPresent()) {
            return employeeRepository.findById(id).get();
        } else {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {

		if (employeeRepository.existsById(id)) {
				employeeRepository.deleteById(id);
		} else {
				throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}
    }
}
