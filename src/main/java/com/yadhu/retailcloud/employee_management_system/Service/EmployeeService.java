package com.yadhu.retailcloud.employee_management_system.Service;

import com.yadhu.retailcloud.employee_management_system.model.Department;
import com.yadhu.retailcloud.employee_management_system.model.Employee;
import com.yadhu.retailcloud.employee_management_system.repository.DepartmentRepository;
import com.yadhu.retailcloud.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updated) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        updated.setId(id);
        return employeeRepository.save(updated);
    }

    public Employee moveEmployeeToDepartment(Long empId, Long deptId) {
        Employee emp = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        emp.setDepartment(dept);
        return employeeRepository.save(emp);
    }

    public Page<Employee> getAllEmployees(int page) {
        return employeeRepository.findAll(PageRequest.of(page, 20));
    }

    public List<Object[]> lookupNameAndId(boolean lookup) {
        return lookup ? employeeRepository.findAll()
                .stream().map(e -> new Object[]{e.getId(), e.getName()}).toList() : List.of();
    }
}