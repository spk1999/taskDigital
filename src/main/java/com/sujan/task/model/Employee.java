package com.sujan.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sujan.task.constants.Tables;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Tables.EMPLOYEETABLE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String phone;
    private int enabled;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Designation> designation;


    public Employee() {
    }

    public Employee(int id, String name, String address, String phone, int enabled, List<Designation> designation) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.enabled = enabled;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }


    public List<Designation> getDesignation() {
        return designation;
    }

    public void setDesignation(List<Designation> designation) {
        this.designation = designation;
    }

    public Employee(int id) {
        this.id = id;
    }
}
