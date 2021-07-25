package com.sujan.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sujan.task.constants.Tables;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Tables.DESIGNATIONTABLE)
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String designation;
    @ManyToOne
    private Employee employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @JsonIgnore
    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    public Designation(int id, String designation, Employee employees) {
        this.id = id;
        this.designation = designation;
        this.employees = employees;
    }

    public Designation() {
    }
}
