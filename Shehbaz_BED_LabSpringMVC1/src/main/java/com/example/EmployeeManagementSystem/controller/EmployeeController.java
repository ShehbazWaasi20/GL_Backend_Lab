package com.example.EmployeeManagementSystem.controller;


import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepo;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employees")
    private String listOfEmployees(Model model) {
       model.addAttribute("employees",employeeService.getAllEmployees());
       return  "employees";
    }

    @GetMapping("/employee/new")
    private String createEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "create_employee";
    }


    @PostMapping("/employees")
    private String saveEmployeeForm(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }


    @GetMapping("/employee/edit/{id}")
    private String editEmployeeForm(@PathVariable int id, Model model){
        model.addAttribute("employee",employeeService.getEmployeeById(id));
        return "edit_employee";
    }




    @PostMapping("/employee/{id}")
    private String updateEmployee(@PathVariable int id,@ModelAttribute("employee") Employee employee, Model model){
    employeeService.updateEmployeeById(id,employee);
        return "redirect:/employees";
    }


    @GetMapping("/employee/{id}")
    private String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
