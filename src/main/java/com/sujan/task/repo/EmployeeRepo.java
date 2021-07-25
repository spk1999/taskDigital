package com.sujan.task.repo;

import com.sujan.task.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {


}
