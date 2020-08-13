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
@Table(name = "emp_pay_payroll", catalog = "employees", schema = "")
@XmlRootElement
//---------------------------------Named Queries------------------------------------------------------------------------------
@NamedQueries({
    @NamedQuery(name = "Payroll.findAll", query = "SELECT p FROM Payroll p"),
    @NamedQuery(name = "Payroll.findByPayPayrollNo", query = "SELECT p FROM Payroll p WHERE p.payPayrollNo = :payPayrollNo"),
    @NamedQuery(name = "Payroll.findByPayFromDate", query = "SELECT p FROM Payroll p WHERE p.payFromDate = :payFromDate"),
    @NamedQuery(name = "Payroll.findByPayToDate", query = "SELECT p FROM Payroll p WHERE p.payToDate = :payToDate"),
    @NamedQuery(name = "Payroll.findByAusercreate", query = "SELECT p FROM Payroll p WHERE p.ausercreate = :ausercreate"),
    @NamedQuery(name = "Payroll.findByAdatecreate", query = "SELECT p FROM Payroll p WHERE p.adatecreate = :adatecreate"),
    @NamedQuery(name = "Payroll.findByAuserchange", query = "SELECT p FROM Payroll p WHERE p.auserchange = :auserchange"),
    @NamedQuery(name = "Payroll.findByAdatechange", query = "SELECT p FROM Payroll p WHERE p.adatechange = :adatechange")})
public class Payroll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pay_payroll_no")
    private Integer payPayrollNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pay_from_date")
    @Temporal(TemporalType.DATE)
    private Date payFromDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pay_to_date")
    @Temporal(TemporalType.DATE)
    private Date payToDate;
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
    @JoinColumn(name = "pay_emp_no", referencedColumnName = "emp_emp_no")
    @ManyToOne(optional = false)
    private Employee payEmpNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bilPayrollNo")
    private List<Bill> billList;

    /**
     * Constructor vacio
     *
     */
    public Payroll() {
    }

    /**
     * Constructor con id primario
     *
     * @param integer
     */
    public Payroll(Integer payPayrollNo) {
        this.payPayrollNo = payPayrollNo;
    }

    /**
     * Contructor recibe todos los campos de Payroll
     *
     * @param Integer payPayrollNo Numero de Planilla
     * @param Date payFromDate Fecha Desde
     * @param Date payToDate Fecha Hasta
     *
     * @param String UserCreate usuario de auditoria crear
     * @param Date dateCreate fecha de creacion
     * @param String userChange usuario de auditoria actualizar
     * @param Date dateChange fecha de actualizacion
     *
     */
    public Payroll(Integer payPayrollNo, Date payFromDate, Date payToDate, String ausercreate, Date adatecreate, String auserchange, Date adatechange) {
        this.payPayrollNo = payPayrollNo;
        this.payFromDate = payFromDate;
        this.payToDate = payToDate;
        this.ausercreate = ausercreate;
        this.adatecreate = adatecreate;
        this.auserchange = auserchange;
        this.adatechange = adatechange;
    }

    //---------------------------------------Getters y Setters -----------------------------------------------------
    public Integer getPayPayrollNo() {
        return payPayrollNo;
    }

    public void setPayPayrollNo(Integer payPayrollNo) {
        this.payPayrollNo = payPayrollNo;
    }

    public Date getPayFromDate() {
        return payFromDate;
    }

    public void setPayFromDate(Date payFromDate) {
        this.payFromDate = payFromDate;
    }

    public Date getPayToDate() {
        return payToDate;
    }

    public void setPayToDate(Date payToDate) {
        this.payToDate = payToDate;
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

    public Employee getPayEmpNo() {
        return payEmpNo;
    }

    public void setPayEmpNo(Employee payEmpNo) {
        this.payEmpNo = payEmpNo;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    /**
     * Metodo Hashcode
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payPayrollNo != null ? payPayrollNo.hashCode() : 0);
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
        if (!(object instanceof Payroll)) {
            return false;
        }
        Payroll other = (Payroll) object;
        if ((this.payPayrollNo == null && other.payPayrollNo != null) || (this.payPayrollNo != null && !this.payPayrollNo.equals(other.payPayrollNo))) {
            return false;
        }
        return true;
    }
//---------------------------------------------ToString-----------------------------------------------------

    @Override
    public String toString() {
        return "com.bitlab.entities.Payroll[ payPayrollNo=" + payPayrollNo + " ]";
    }

}
