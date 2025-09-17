package mysql.emp_crud_sql.controller;

import mysql.emp_crud_sql.entity.Employee;
import mysql.emp_crud_sql.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(updatedEmployee.getName());
            emp.setPhone(updatedEmployee.getPhone());
            emp.setEmail(updatedEmployee.getEmail());
            employeeRepository.save(emp);
            return "Updated successfully";
        }).orElse("Employee not found");
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Deleted successfully";
        } else {
            return "Employee not found";
        }
    }
}
