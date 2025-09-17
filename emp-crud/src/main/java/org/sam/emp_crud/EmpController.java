package org.sam.emp_crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmpController {
    List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
        return "save successfully";
    }

    @PutMapping("{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(updatedEmployee.getName());
                emp.setPhone(updatedEmployee.getPhone());
                emp.setEmail(updatedEmployee.getEmail());
                return "Updated successfully";
            }
        }
        return "Employee not found";
    }

    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable int id) {
        boolean removed = employees.removeIf(emp -> emp.getId() == id);
        return removed ? "Deleted successfully" : "Employee not found";
    }

}
