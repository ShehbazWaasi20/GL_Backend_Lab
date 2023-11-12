package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    EmployeeRepo employeeRepo;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public Employee updateEmployeeById(int id ,Employee employee) {

        Employee employee1 =getEmployeeById(id);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        return saveEmployee(employee1);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepo.deleteById(id);

    }
}
