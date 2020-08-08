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
@Table(name = "emp_rol_rol", catalog = "employees", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByRolRolNo", query = "SELECT r FROM Rol r WHERE r.rolRolNo = :rolRolNo"),
    @NamedQuery(name = "Rol.findByRolRol", query = "SELECT r FROM Rol r WHERE r.rolRol = :rolRol"),
    @NamedQuery(name = "Rol.findByAusercreate", query = "SELECT r FROM Rol r WHERE r.ausercreate = :ausercreate"),
    @NamedQuery(name = "Rol.findByAdatecreate", query = "SELECT r FROM Rol r WHERE r.adatecreate = :adatecreate"),
    @NamedQuery(name = "Rol.findByAuserchange", query = "SELECT r FROM Rol r WHERE r.auserchange = :auserchange"),
    @NamedQuery(name = "Rol.findByAdatechange", query = "SELECT r FROM Rol r WHERE r.adatechange = :adatechange")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_rol_no")
    private Integer rolRolNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rol_rol")
    private String rolRol;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrRolNo")
    private List<User> userList;

    public Rol() {
    }

    public Rol(Integer rolRolNo) {
        this.rolRolNo = rolRolNo;
    }

    public Rol(Integer rolRolNo, String rolRol, String ausercreate, Date adatecreate, String auserchange, Date adatechange) {
        this.rolRolNo = rolRolNo;
        this.rolRol = rolRol;
        this.ausercreate = ausercreate;
        this.adatecreate = adatecreate;
        this.auserchange = auserchange;
        this.adatechange = adatechange;
    }

    public Integer getRolRolNo() {
        return rolRolNo;
    }

    public void setRolRolNo(Integer rolRolNo) {
        this.rolRolNo = rolRolNo;
    }

    public String getRolRol() {
        return rolRol;
    }

    public void setRolRol(String rolRol) {
        this.rolRol = rolRol;
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
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolRolNo != null ? rolRolNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolRolNo == null && other.rolRolNo != null) || (this.rolRolNo != null && !this.rolRolNo.equals(other.rolRolNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.Rol[ rolRolNo=" + rolRolNo + " ]";
    }
    
}
