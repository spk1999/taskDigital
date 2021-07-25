package com.sujan.task.service;

import com.sujan.task.dto.SucessDto;
import com.sujan.task.model.Employee;
import com.sujan.task.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Page<Employee> getEmployees(int offset, int limit, int orderby) {
        Pageable pageable;
        if (orderby == 2) {
            pageable = PageRequest.of(offset, limit, Sort.by("name").descending());
        } else {
            pageable = PageRequest.of(offset, limit, Sort.by("name").ascending());
        }
        return employeeRepo.findAll(pageable);

    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }


    public SucessDto deleteEmployee(int id) {
        employeeRepo.delete(new Employee(id));
        return new SucessDto(true);
    }
}
