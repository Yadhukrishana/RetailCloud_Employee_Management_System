package com.yadhu.retailcloud.employee_management_system;

import com.yadhu.retailcloud.employee_management_system.model.Department;
import com.yadhu.retailcloud.employee_management_system.model.Employee;
import com.yadhu.retailcloud.employee_management_system.repository.DepartmentRepository;
import com.yadhu.retailcloud.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;


	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
		return args -> {
			List<Department> departments = new ArrayList<>();

			// Create and save 3 departments
			for (int i = 1; i <= 3; i++) {
				Department dept = new Department();
				dept.setName("Department " + i);
				dept.setCreationDate(LocalDate.now());
				departmentRepository.save(dept);
				departments.add(dept); // Save reference to assign to employees later
			}

			// Create and save 25 employees
			for (int i = 1; i <= 25; i++) {
				Employee emp = new Employee();
				emp.setName("Employee " + i);
				emp.setRole("Role " + i);
				emp.setAddress("Address " + i);
				emp.setSalary((double) (40000 + i)); // Just for variety
				emp.setYearlyBonusPercentage(5.0 + (i % 5));
				emp.setDateOfBirth(LocalDate.of(1990 + (i % 10), (i % 12) + 1, (i % 28) + 1));
				emp.setJoiningDate(LocalDate.now().minusDays(i));

				// Assign department in round-robin fashion
				Department assignedDept = departments.get((i - 1) % departments.size());
				emp.setDepartment(assignedDept);

				employeeRepository.save(emp);
			}
		};
	}
}


