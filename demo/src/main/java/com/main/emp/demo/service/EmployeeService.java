package com.main.emp.demo.service;

import com.main.emp.demo.exception.UserNotFoundException;
import com.main.emp.demo.model.Employee;
import com.main.emp.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
            employee.setEmployeeCode(UUID.randomUUID().toString() );
            return employeeRepo.save(employee);

    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();

    }

    public Employee update(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id)  {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User was not found!"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
