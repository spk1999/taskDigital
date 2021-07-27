package com.sujan.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sujan.task.constants.Tables;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp lastModifiedDate;
    private String modifiedBy;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employees_id" ,referencedColumnName = "id")
    private List<Designation> designation;


    public Employee() {
    }

    public Employee(int id, String name, String address, String phone, int enabled, Timestamp createdDate, String createdBy, Timestamp lastModifiedDate, String modifiedBy, List<Designation> designation) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.enabled = enabled;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastModifiedDate = lastModifiedDate;
        this.modifiedBy = modifiedBy;
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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
