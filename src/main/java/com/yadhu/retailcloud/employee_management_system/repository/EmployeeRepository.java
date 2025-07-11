package com.yadhu.retailcloud.employee_management_system.repository;

import com.yadhu.retailcloud.employee_management_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e.id, e.name FROM Employee e")
    List<Object[]> findIdAndName();
}