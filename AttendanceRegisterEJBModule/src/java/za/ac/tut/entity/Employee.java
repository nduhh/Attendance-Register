/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nntem
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String department;
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<TimeIn> timeIns;
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)    
    private List<TimeOut> timeOuts;   

    public Employee() {
    }

    public Employee(Long id, String name, String surname, String department, List<TimeIn> timeIns, List<TimeOut> timeOuts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.timeIns = timeIns;
        this.timeOuts = timeOuts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<TimeIn> getTimeIns() {
        return timeIns;
    }

    public void setTimeIns(List<TimeIn> timeIns) {
        this.timeIns = timeIns;
    }

    public List<TimeOut> getTimeOuts() {
        return timeOuts;
    }

    public void setTimeOuts(List<TimeOut> timeOuts) {
        this.timeOuts = timeOuts;
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entity.Employee[ id=" + id + " ]";
    }
    
}
