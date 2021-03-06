/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nativi
 */
@Entity
@Table(name = "emp_usr_user", catalog = "employees", schema = "")
@XmlRootElement
//---------------------------------Named Queries------------------------------------------------------------------------------
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUsrUserNo", query = "SELECT u FROM User u WHERE u.usrUserNo = :usrUserNo"),
    @NamedQuery(name = "User.findByUsrUser", query = "SELECT u FROM User u WHERE u.usrUser = :usrUser"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findByAusercreate", query = "SELECT u FROM User u WHERE u.ausercreate = :ausercreate"),
    @NamedQuery(name = "User.findByAdatecreate", query = "SELECT u FROM User u WHERE u.adatecreate = :adatecreate"),
    @NamedQuery(name = "User.findByAuserchange", query = "SELECT u FROM User u WHERE u.auserchange = :auserchange"),
    @NamedQuery(name = "User.findByAdatechange", query = "SELECT u FROM User u WHERE u.adatechange = :adatechange")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_user_no")
    private Integer usrUserNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usr_user")
    private String usrUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 130)
    @Column(name = "user_password")
    private String userPassword;
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
    @JoinColumn(name = "usr_rol_no", referencedColumnName = "rol_rol_no")
    @ManyToOne(optional = false)
    private Rol usrRolNo;

    /**
     * Constructor vacio
     *
     */
    public User() {
    }

    /**
     * Constructor con id primario
     *
     * @param integer
     */
    public User(Integer usrUserNo) {
        this.usrUserNo = usrUserNo;
    }

    /**
     * Contructor recibe todos los campos de User
     *
     * @param Integer usrUserNo Numero de Usuario
     * @param String usrUser Tipo de Usuario
     * @param String userPassword Contraseña del Usuario
     *
     * @param String UserCreate usuario de auditoria crear
     * @param Date dateCreate fecha de creacion
     * @param String userChange usuario de auditoria actualizar
     * @param Date dateChange fecha de actualizacion
     *
     */
    public User(Integer usrUserNo, String usrUser, String userPassword, String ausercreate, Date adatecreate, String auserchange, Date adatechange) {
        this.usrUserNo = usrUserNo;
        this.usrUser = usrUser;
        this.userPassword = userPassword;
        this.ausercreate = ausercreate;
        this.adatecreate = adatecreate;
        this.auserchange = auserchange;
        this.adatechange = adatechange;
    }

    //---------------------------------------Getters y Setters -----------------------------------------------------
    public Integer getUsrUserNo() {
        return usrUserNo;
    }

    public void setUsrUserNo(Integer usrUserNo) {
        this.usrUserNo = usrUserNo;
    }

    public String getUsrUser() {
        return usrUser;
    }

    public void setUsrUser(String usrUser) {
        this.usrUser = usrUser;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public Rol getUsrRolNo() {
        return usrRolNo;
    }

    public void setUsrRolNo(Rol usrRolNo) {
        this.usrRolNo = usrRolNo;
    }

    /**
     * Metodo Hashcode
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrUserNo != null ? usrUserNo.hashCode() : 0);
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.usrUserNo == null && other.usrUserNo != null) || (this.usrUserNo != null && !this.usrUserNo.equals(other.usrUserNo))) {
            return false;
        }
        return true;
    }
//---------------------------------------------ToString-----------------------------------------------------

    @Override
    public String toString() {
        return "User{" + "usrUserNo=" + usrUserNo + ", usrUser=" + usrUser + ", userPassword=" + userPassword + ", ausercreate=" + ausercreate + ", adatecreate=" + adatecreate + ", auserchange=" + auserchange + ", adatechange=" + adatechange + ", usrRolNo=" + usrRolNo + '}';
    }

}
