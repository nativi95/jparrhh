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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nativi
 */
@Entity
@Table(name = "emp_bil_bill", catalog = "employees", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findByBillBillNo", query = "SELECT b FROM Bill b WHERE b.billBillNo = :billBillNo"),
    @NamedQuery(name = "Bill.findByBilValue", query = "SELECT b FROM Bill b WHERE b.bilValue = :bilValue"),
    @NamedQuery(name = "Bill.findByBilDescription", query = "SELECT b FROM Bill b WHERE b.bilDescription = :bilDescription"),
    @NamedQuery(name = "Bill.findByAusercreate", query = "SELECT b FROM Bill b WHERE b.ausercreate = :ausercreate"),
    @NamedQuery(name = "Bill.findByAdatecreate", query = "SELECT b FROM Bill b WHERE b.adatecreate = :adatecreate"),
    @NamedQuery(name = "Bill.findByAuserchange", query = "SELECT b FROM Bill b WHERE b.auserchange = :auserchange"),
    @NamedQuery(name = "Bill.findByAdatechange", query = "SELECT b FROM Bill b WHERE b.adatechange = :adatechange")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_bill_no")
    private Integer billBillNo;
    @Basic(optional = false)
    @Column(name = "bil_value")
    private float bilValue;
    @Basic(optional = false)
    @Column(name = "bil_description")
    private String bilDescription;
    @Basic(optional = false)
    @Column(name = "A_user_create")
    private String ausercreate;
    @Basic(optional = false)
    @Column(name = "A_date_create")
    @Temporal(TemporalType.DATE)
    private Date adatecreate;
    @Basic(optional = false)
    @Column(name = "A_user_change")
    private String auserchange;
    @Basic(optional = false)
    @Column(name = "A_date_change")
    @Temporal(TemporalType.DATE)
    private Date adatechange;
    @JoinColumn(name = "bil_payroll_no", referencedColumnName = "pay_payroll_no")
    @ManyToOne(optional = false)
    private Payroll bilPayrollNo;

    public Bill() {
    }

    public Bill(Integer billBillNo) {
        this.billBillNo = billBillNo;
    }

    public Bill(Integer billBillNo, float bilValue, String bilDescription, String ausercreate, Date adatecreate, String auserchange, Date adatechange) {
        this.billBillNo = billBillNo;
        this.bilValue = bilValue;
        this.bilDescription = bilDescription;
        this.ausercreate = ausercreate;
        this.adatecreate = adatecreate;
        this.auserchange = auserchange;
        this.adatechange = adatechange;
    }

    public Integer getBillBillNo() {
        return billBillNo;
    }

    public void setBillBillNo(Integer billBillNo) {
        this.billBillNo = billBillNo;
    }

    public float getBilValue() {
        return bilValue;
    }

    public void setBilValue(float bilValue) {
        this.bilValue = bilValue;
    }

    public String getBilDescription() {
        return bilDescription;
    }

    public void setBilDescription(String bilDescription) {
        this.bilDescription = bilDescription;
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

    public Payroll getBilPayrollNo() {
        return bilPayrollNo;
    }

    public void setBilPayrollNo(Payroll bilPayrollNo) {
        this.bilPayrollNo = bilPayrollNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billBillNo != null ? billBillNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.billBillNo == null && other.billBillNo != null) || (this.billBillNo != null && !this.billBillNo.equals(other.billBillNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bill[ billBillNo=" + billBillNo + " ]";
    }
    
}
