package com.sujan.task.controller;

import com.sujan.task.dto.SucessDto;
import com.sujan.task.model.Employee;
import com.sujan.task.repo.EmployeeRepo;
import com.sujan.task.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>> getEmployees(@RequestParam(name = "offset", required = true) int offset,
                                                       @RequestParam(name = "limit", required = true) int limit,
                                                       @RequestParam(name = "orderBy", required = true) int orderby) {

        return new ResponseEntity<>(employeeService.getEmployees(offset, limit, orderby), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> getEmployees(@RequestBody Employee employee) {

        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }


    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<SucessDto> deleteEmployee(@PathVariable("id") int id) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }


}
