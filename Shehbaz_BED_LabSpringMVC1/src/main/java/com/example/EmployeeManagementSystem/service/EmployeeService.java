package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();


    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    Employee updateEmployeeById(int id,Employee employee);

    void deleteEmployeeById(Integer id);



}
