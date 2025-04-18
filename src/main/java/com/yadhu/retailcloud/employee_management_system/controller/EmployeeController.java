package com.yadhu.retailcloud.employee_management_system.controller;

import com.yadhu.retailcloud.employee_management_system.Service.EmployeeService;
import com.yadhu.retailcloud.employee_management_system.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updated) {
        return employeeService.updateEmployee(id, updated);
    }

    @PutMapping("/{empId}/department/{deptId}")
    public Employee moveEmployee(@PathVariable Long empId, @PathVariable Long deptId) {
        return employeeService.moveEmployeeToDepartment(empId, deptId);
    }

    @GetMapping
    public Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page) {
        return employeeService.getAllEmployees(page);
    }

    @GetMapping("/lookup")
    public List<Object[]> lookup(@RequestParam boolean lookup) {
        return employeeService.lookupNameAndId(lookup);
    }
}
