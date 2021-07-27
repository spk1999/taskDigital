package com.sujan.task.controller;

import com.sujan.task.dto.SucessDto;
import com.sujan.task.model.Employee;
import com.sujan.task.repo.EmployeeRepo;
import com.sujan.task.service.EmployeeServiceImpl;
import com.sujan.task.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api("Employee APis")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    @ApiOperation(value = "Employee List", notes = "This Api is used to get list of employees.")
    public ResponseEntity<Page<Employee>> getEmployees(@RequestParam(name = "offset", required = true) int offset,
                                                       @RequestParam(name = "limit", required = true) int limit,
                                                       @RequestParam(name = "orderBy", required = true) int orderby) {
        return new ResponseEntity<>(employeeService.getEmployees(offset, limit, orderby), HttpStatus.OK);
    }

    @PostMapping("/employee")
    @ApiOperation(value = "Employee Save", notes = "This Api is used to add Employees.")
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee,
                                                 Principal principal) {
        employee.setCreatedDate(DateUtil.getTimestamp());
        employee.setCreatedBy(principal.getName());
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }


    @PutMapping("/employee")
    @ApiOperation(value = "Employee update", notes = "This Api is used to update Employees.")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,Principal principal) {
        employee.setModifiedBy(principal.getName());
        employee.setLastModifiedDate(DateUtil.getTimestamp());
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    @ApiOperation(value = "Employee delete", notes = "This Api is used to delete Employees.")
    public ResponseEntity<SucessDto> deleteEmployee(@PathVariable("id") int id) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }


}
