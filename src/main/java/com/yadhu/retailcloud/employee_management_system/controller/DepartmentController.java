package com.yadhu.retailcloud.employee_management_system.controller;

import com.yadhu.retailcloud.employee_management_system.Service.DepartmentService;
import com.yadhu.retailcloud.employee_management_system.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department addDepartment(@RequestBody Department dept) {
        return departmentService.addDepartment(dept);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updated) {
        return departmentService.updateDepartment(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping
    public Page<Department> getAllDepartments(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(required = false) String expand) {
        return departmentService.getAllDepartments(page, expand);
    }
}
