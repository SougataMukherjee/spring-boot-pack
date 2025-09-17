package mysql.emp_crud_sql.repository;

import mysql.emp_crud_sql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
