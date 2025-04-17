package com.yadhu.retailcloud.employee_management_system.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.util.List;

public class Department {
//    a name, creation date,
// and department head

    private Long id;
    private String name;
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "department_head_id")
    private Department departmentHead;
    @OneToMany(mappedBy = "department")
    private List<Employee>employees;
}
