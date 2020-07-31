/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nativi
 */
@Entity
@Table(name = "emp_emp_employee", catalog = "employees", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmpEmpNo", query = "SELECT e FROM Employee e WHERE e.empEmpNo = :empEmpNo"),
    @NamedQuery(name = "Employee.findByEmpBirthDate", query = "SELECT e FROM Employee e WHERE e.empBirthDate = :empBirthDate"),
    @NamedQuery(name = "Employee.findByEmpFirstName", query = "SELECT e FROM Employee e WHERE e.empFirstName = :empFirstName"),
    @NamedQuery(name = "Employee.findByEmpLastName", query = "SELECT e FROM Employee e WHERE e.empLastName = :empLastName"),
    @NamedQuery(name = "Employee.findByEmpGender", query = "SELECT e FROM Employee e WHERE e.empGender = :empGender"),
    @NamedQuery(name = "Employee.findByEmpHireDate", query = "SELECT e FROM Employee e WHERE e.empHireDate = :empHireDate"),
    @NamedQuery(name = "Employee.findByEmpEmail", query = "SELECT e FROM Employee e WHERE e.empEmail = :empEmail"),
    @NamedQuery(name = "Employee.findByAusercreate", query = "SELECT e FROM Employee e WHERE e.ausercreate = :ausercreate"),
    @NamedQuery(name = "Employee.findByAdatecreate", query = "SELECT e FROM Employee e WHERE e.adatecreate = :adatecreate"),
    @NamedQuery(name = "Employee.findByAuserchange", query = "SELECT e FROM Employee e WHERE e.auserchange = :auserchange"),
    @NamedQuery(name = "Employee.findByAdatechange", query = "SELECT e FROM Employee e WHERE e.adatechange = :adatechange")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_emp_no")
    private Integer empEmpNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_birth_date")
    @Temporal(TemporalType.DATE)
    private Date empBirthDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "emp_first_name")
    private String empFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "emp_last_name")
    private String empLastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_gender")
    private Character empGender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_hire_date")
    @Temporal(TemporalType.DATE)
    private Date empHireDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "emp_email")
    private String empEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "A_user_create")
    private String ausercreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A_date_create")
    @Temporal(TemporalType.DATE)
    private Date adatecreate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "A_user_change")
    private String auserchange;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A_date_change")
    @Temporal(TemporalType.DATE)
    private Date adatechange;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payEmpNo")
    private List<Payroll> payrollList;
    @JoinColumn(name = "emp_position_no", referencedColumnName = "pos_position_no")
    @ManyToOne(optional = false)
    private Position empPositionNo;
    @JoinColumn(name = "emp_dept_no", referencedColumnName = "dep_dept_no")
    @ManyToOne(optional = false)
    private Department empDeptNo;

    public Employee() {
    }

    public Employee(Integer empEmpNo) {
        this.empEmpNo = empEmpNo;
    }

    public Employee(Integer empEmpNo, Date empBirthDate, String empFirstName, String empLastName, Character empGender, Date empHireDate, String empEmail, String ausercreate, Date adatecreate, String auserchange, Date adatechange) {
        this.empEmpNo = empEmpNo;
        this.empBirthDate = empBirthDate;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empGender = empGender;
        this.empHireDate = empHireDate;
        this.empEmail = empEmail;
        this.ausercreate = ausercreate;
        this.adatecreate = adatecreate;
        this.auserchange = auserchange;
        this.adatechange = adatechange;
    }

    public Integer getEmpEmpNo() {
        return empEmpNo;
    }

    public void setEmpEmpNo(Integer empEmpNo) {
        this.empEmpNo = empEmpNo;
    }

    public Date getEmpBirthDate() {
        return empBirthDate;
    }

    public void setEmpBirthDate(Date empBirthDate) {
        this.empBirthDate = empBirthDate;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public Character getEmpGender() {
        return empGender;
    }

    public void setEmpGender(Character empGender) {
        this.empGender = empGender;
    }

    public Date getEmpHireDate() {
        return empHireDate;
    }

    public void setEmpHireDate(Date empHireDate) {
        this.empHireDate = empHireDate;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getAusercreate() {
        return ausercreate;
    }

    public void setAusercreate(String ausercreate) {
        this.ausercreate = ausercreate;
    }

    public Date getAdatecreate() {
        return adatecreate;
    }

    public void setAdatecreate(Date adatecreate) {
        this.adatecreate = adatecreate;
    }

    public String getAuserchange() {
        return auserchange;
    }

    public void setAuserchange(String auserchange) {
        this.auserchange = auserchange;
    }

    public Date getAdatechange() {
        return adatechange;
    }

    public void setAdatechange(Date adatechange) {
        this.adatechange = adatechange;
    }

    @XmlTransient
    public List<Payroll> getPayrollList() {
        return payrollList;
    }

    public void setPayrollList(List<Payroll> payrollList) {
        this.payrollList = payrollList;
    }

    public Position getEmpPositionNo() {
        return empPositionNo;
    }

    public void setEmpPositionNo(Position empPositionNo) {
        this.empPositionNo = empPositionNo;
    }

    public Department getEmpDeptNo() {
        return empDeptNo;
    }

    public void setEmpDeptNo(Department empDeptNo) {
        this.empDeptNo = empDeptNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empEmpNo != null ? empEmpNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.empEmpNo == null && other.empEmpNo != null) || (this.empEmpNo != null && !this.empEmpNo.equals(other.empEmpNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.Employee[ empEmpNo=" + empEmpNo + " ]";
    }
    
}
