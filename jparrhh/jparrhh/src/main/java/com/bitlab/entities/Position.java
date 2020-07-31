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
 *
 * @author nativi
 */
@Entity
@Table(name = "emp_pos_position", catalog = "employees", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p"),
    @NamedQuery(name = "Position.findByPosPositionNo", query = "SELECT p FROM Position p WHERE p.posPositionNo = :posPositionNo"),
    @NamedQuery(name = "Position.findByPosPosition", query = "SELECT p FROM Position p WHERE p.posPosition = :posPosition"),
    @NamedQuery(name = "Position.findByAusercreate", query = "SELECT p FROM Position p WHERE p.ausercreate = :ausercreate"),
    @NamedQuery(name = "Position.findByAdatecreate", query = "SELECT p FROM Position p WHERE p.adatecreate = :adatecreate"),
    @NamedQuery(name = "Position.findByAuserchange", query = "SELECT p FROM Position p WHERE p.auserchange = :auserchange"),
    @NamedQuery(name = "Position.findByAdatechange", query = "SELECT p FROM Position p WHERE p.adatechange = :adatechange")})
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pos_position_no")
    private Integer posPositionNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pos_position")
    private String posPosition;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empPositionNo")
    private List<Employee> employeeList;

    public Position() {
    }

    public Position(Integer posPositionNo) {
        this.posPositionNo = posPositionNo;
    }

    public Position(Integer posPositionNo, String posPosition, String ausercreate, Date adatecreate, String auserchange, Date adatechange) {
        this.posPositionNo = posPositionNo;
        this.posPosition = posPosition;
        this.ausercreate = ausercreate;
        this.adatecreate = adatecreate;
        this.auserchange = auserchange;
        this.adatechange = adatechange;
    }

    public Integer getPosPositionNo() {
        return posPositionNo;
    }

    public void setPosPositionNo(Integer posPositionNo) {
        this.posPositionNo = posPositionNo;
    }

    public String getPosPosition() {
        return posPosition;
    }

    public void setPosPosition(String posPosition) {
        this.posPosition = posPosition;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posPositionNo != null ? posPositionNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.posPositionNo == null && other.posPositionNo != null) || (this.posPositionNo != null && !this.posPositionNo.equals(other.posPositionNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.Position[ posPositionNo=" + posPositionNo + " ]";
    }
    
}
