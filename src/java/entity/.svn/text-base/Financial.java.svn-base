/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Engel-less
 */
@Entity
@Table(name = "financial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financial.findAll", query = "SELECT f FROM Financial f"),
    @NamedQuery(name = "Financial.findByIdtable1", query = "SELECT f FROM Financial f WHERE f.idtable1 = :idtable1"),
    @NamedQuery(name = "Financial.findByFixedExpense", query = "SELECT f FROM Financial f WHERE f.fixedExpense = :fixedExpense"),
    @NamedQuery(name = "Financial.findByAnnualExpense", query = "SELECT f FROM Financial f WHERE f.annualExpense = :annualExpense"),
    @NamedQuery(name = "Financial.findByStartDate", query = "SELECT f FROM Financial f WHERE f.startDate = :startDate"),
    @NamedQuery(name = "Financial.findByAnnualElectricSavings", query = "SELECT f FROM Financial f WHERE f.annualElectricSavings = :annualElectricSavings"),
    @NamedQuery(name = "Financial.findByAnnualGasSavings", query = "SELECT f FROM Financial f WHERE f.annualGasSavings = :annualGasSavings"),
    @NamedQuery(name = "Financial.findByPricePerKWh", query = "SELECT f FROM Financial f WHERE f.pricePerKWh = :pricePerKWh"),
    @NamedQuery(name = "Financial.findByPricePerBTU", query = "SELECT f FROM Financial f WHERE f.pricePerBTU = :pricePerBTU"),
    @NamedQuery(name = "Financial.findByClientidClient", query = "SELECT f FROM Financial f WHERE f.clientidClient = :clientidClient"),
    @NamedQuery(name = "Financial.findBySavingsToDateElectric", query = "SELECT f FROM Financial f WHERE f.savingsToDateElectric = :savingsToDateElectric"),
    @NamedQuery(name = "Financial.findBySavingsToDateGas", query = "SELECT f FROM Financial f WHERE f.savingsToDateGas = :savingsToDateGas"),
    @NamedQuery(name = "Financial.findBySavingsCalcDate", query = "SELECT f FROM Financial f WHERE f.savingsCalcDate = :savingsCalcDate")})
public class Financial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "idtable1")
    private Integer idtable1;
    @Column(name = "fixedExpense")
    private Integer fixedExpense;
    @Column(name = "annualExpense")
    private Integer annualExpense;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "annualElectricSavings")
    private Integer annualElectricSavings;
    @Column(name = "annualGasSavings")
    private Integer annualGasSavings;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pricePerKWh")
    private Float pricePerKWh;
    @Column(name = "pricePerBTU")
    private Float pricePerBTU;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "client_idClient")
    private int clientidClient;
    @Column(name = "savingsToDateElectric")
    private Integer savingsToDateElectric;
    @Column(name = "savingsToDateGas")
    private Integer savingsToDateGas;
    @Column(name = "savingsCalcDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date savingsCalcDate;

    public Financial() {
    }

    public Financial(Integer idtable1) {
        this.idtable1 = idtable1;
    }

    public Financial(Integer idtable1, int clientidClient) {
        this.idtable1 = idtable1;
        this.clientidClient = clientidClient;
    }

    public Integer getIdtable1() {
        return idtable1;
    }

    public void setIdtable1(Integer idtable1) {
        this.idtable1 = idtable1;
    }

    public Integer getFixedExpense() {
        return fixedExpense;
    }

    public void setFixedExpense(Integer fixedExpense) {
        this.fixedExpense = fixedExpense;
    }

    public Integer getAnnualExpense() {
        return annualExpense;
    }

    public void setAnnualExpense(Integer annualExpense) {
        this.annualExpense = annualExpense;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getAnnualElectricSavings() {
        return annualElectricSavings;
    }

    public void setAnnualElectricSavings(Integer annualElectricSavings) {
        this.annualElectricSavings = annualElectricSavings;
    }

    public Integer getAnnualGasSavings() {
        return annualGasSavings;
    }

    public void setAnnualGasSavings(Integer annualGasSavings) {
        this.annualGasSavings = annualGasSavings;
    }

    public Float getPricePerKWh() {
        return pricePerKWh;
    }

    public void setPricePerKWh(Float pricePerKWh) {
        this.pricePerKWh = pricePerKWh;
    }

    public Float getPricePerBTU() {
        return pricePerBTU;
    }

    public void setPricePerBTU(Float pricePerBTU) {
        this.pricePerBTU = pricePerBTU;
    }

    public int getClientidClient() {
        return clientidClient;
    }

    public void setClientidClient(int clientidClient) {
        this.clientidClient = clientidClient;
    }

    public Integer getSavingsToDateElectric() {
        return savingsToDateElectric;
    }

    public void setSavingsToDateElectric(Integer savingsToDateElectric) {
        this.savingsToDateElectric = savingsToDateElectric;
    }

    public Integer getSavingsToDateGas() {
        return savingsToDateGas;
    }

    public void setSavingsToDateGas(Integer savingsToDateGas) {
        this.savingsToDateGas = savingsToDateGas;
    }

    public Date getSavingsCalcDate() {
        return savingsCalcDate;
    }

    public void setSavingsCalcDate(Date savingsCalcDate) {
        this.savingsCalcDate = savingsCalcDate;
    }

    public String getStartDateStr() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = myFormat.format(startDate) ;
        return dateStr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtable1 != null ? idtable1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Financial)) {
            return false;
        }
        Financial other = (Financial) object;
        if ((this.idtable1 == null && other.idtable1 != null) || (this.idtable1 != null && !this.idtable1.equals(other.idtable1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Financial[ idtable1=" + idtable1 + " ]";
    }
    
}
