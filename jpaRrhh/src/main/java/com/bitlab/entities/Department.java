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
 * * @author nativi
 */
@Entity
@Table(name = "emp_dep_department", catalog = "employees", schema = "")
@XmlRootElement
//---------------------------------Named Queries------------------------------------------------------------------------------
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepDeptNo", query = "SELECT d FROM Department d WHERE d.depDeptNo = :depDeptNo"),
    @NamedQuery(name = "Department.findByDepDeptName", query = "SELECT d FROM Department d WHERE d.depDeptName = :depDeptName"),
    @NamedQuery(name = "Department.findByAusercreate", query = "SELECT d FROM Department d WHERE d.ausercreate = :ausercreate"),
    @NamedQuery(name = "Department.findByAdatecreate", query = "SELECT d FROM Department d WHERE d.adatecreate = :adatecreate"),
    @NamedQuery(name = "Department.findByAuserchange", query = "SELECT d FROM Department d WHERE d.auserchange = :auserchange"),
    @NamedQuery(name = "Department.findByAdatechange", query = "SELECT d FROM Department d WHERE d.adatechange = :adatechange")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dep_dept_no")
    private Integer depDeptNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "dep_dept_name")
    private String depDeptName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empDeptNo")
    private List<Employee> employeeList;

    /**
     * Constructor vacio
     *
     */
    
    public Department() {
    }

    /**
     * Constructor con id primario
     *
     * @param integer
     */
    public Department(Integer depDeptNo) {
        this.depDeptNo = depDeptNo;
    }

    /**
     * Contructor recibe todos los campos de Employee
     *
     * @param Integer depDeptNo Numero de Depto
     * @param String depDeptName Nombre de Depto
     *
     *
     * @param String UserCreate usuario de auditoria crear
     * @param Date dateCreate fecha de creacion
     * @param String userChange usuario de auditoria actualizar
     * @param Date dateChange fecha de actualizacion
     *
     */
    public Department(Integer depDeptNo, String depDeptName, String ausercreate, Date adatecreate, String auserchange, Date adatechange) {
        this.depDeptNo = depDeptNo;
        this.depDeptName = depDeptName;
        this.ausercreate = ausercreate;
        this.adatecreate = adatecreate;
        this.auserchange = auserchange;
        this.adatechange = adatechange;
    }

    //---------------------------------------Getters y Setters -----------------------------------------------------
    public Integer getDepDeptNo() {
        return depDeptNo;
    }

    public void setDepDeptNo(Integer depDeptNo) {
        this.depDeptNo = depDeptNo;
    }

    public String getDepDeptName() {
        return depDeptName;
    }

    public void setDepDeptName(String depDeptName) {
        this.depDeptName = depDeptName;
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
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    /**
     * Metodo Hashcode
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depDeptNo != null ? depDeptNo.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo Equals
     *
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.depDeptNo == null && other.depDeptNo != null) || (this.depDeptNo != null && !this.depDeptNo.equals(other.depDeptNo))) {
            return false;
        }
        return true;
    }
//---------------------------------------------ToString-----------------------------------------------------

    @Override
    public String toString() {
        return "Department{" + "depDeptNo=" + depDeptNo + ", depDeptName=" + depDeptName + ", ausercreate=" + ausercreate + ", adatecreate=" + adatecreate + ", auserchange=" + auserchange + ", adatechange=" + adatechange + ", employeeList=" + employeeList + '}';
    }

    

}
