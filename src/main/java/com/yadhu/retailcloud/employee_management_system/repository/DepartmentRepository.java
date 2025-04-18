package com.yadhu.retailcloud.employee_management_system.repository;

<<<<<<< HEAD
public interface DepartmentRepository {
=======
import com.yadhu.retailcloud.employee_management_system.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>
{

>>>>>>> dc70465 (completed)
}
