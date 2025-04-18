package com.yadhu.retailcloud.employee_management_system.Service;

import com.yadhu.retailcloud.employee_management_system.model.Department;
import com.yadhu.retailcloud.employee_management_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department dept) {
        return departmentRepository.save(dept);
    }

    public Department updateDepartment(Long id, Department updated) {
        updated.setId(id);
        return departmentRepository.save(updated);
    }

    public void deleteDepartment(Long id) {
        Department dept = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        if (!dept.getEmployees().isEmpty()) {
            throw new RuntimeException("Cannot delete department with employees.");
        }
        departmentRepository.delete(dept);
    }

    public Page<Department> getAllDepartments(int page, String expand) {
        Page<Department> departments = departmentRepository.findAll(PageRequest.of(page, 20));
        if ("employee".equalsIgnoreCase(expand)) {
            departments.forEach(d -> d.getEmployees().size());
        }
        return departments;
    }
}