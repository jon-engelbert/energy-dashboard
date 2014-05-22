/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Engel-less
 */
@Entity
@Table(name = "PCBills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PCBills.findAll", query = "SELECT p FROM PCBills p"),
    @NamedQuery(name = "PCBills.findById", query = "SELECT p FROM PCBills p WHERE p.id = :id"),
    @NamedQuery(name = "PCBills.findByDateStart", query = "SELECT p FROM PCBills p WHERE p.dateStart = :dateStart"),
    @NamedQuery(name = "PCBills.findByDateEnd", query = "SELECT p FROM PCBills p WHERE p.dateEnd = :dateEnd"),
    @NamedQuery(name = "PCBills.findByAmount", query = "SELECT p FROM PCBills p WHERE p.amount = :amount"),
    @NamedQuery(name = "PCBills.findByCost", query = "SELECT p FROM PCBills p WHERE p.cost = :cost"),
    @NamedQuery(name = "PCBills.findByPdfId", query = "SELECT p FROM PCBills p WHERE p.pdfId = :pdfId"),
    @NamedQuery(name = "PCBills.findBySitesId", query = "SELECT p FROM PCBills p WHERE p.sitesId = :sitesId"),
    @NamedQuery(name = "PCBills.findByIsBasedOnOriginalModel", query = "SELECT p FROM PCBills p WHERE p.isBasedOnOriginalModel = :isBasedOnOriginalModel"),
    @NamedQuery(name = "PCBills.findByFuelType", query = "SELECT p FROM PCBills p WHERE p.fuelType = :fuelType")})
public class PCBills implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "dateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "amount")
    private float amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    //@NotNull
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "pdf_id")
    private Integer pdfId;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "sites_id")
    private int sitesId;
    @Column(name = "IsBasedOnOriginalModel")
    private Boolean isBasedOnOriginalModel;
    @Size(max = 20)
    @Column(name = "fuel_type")
    private String fuelType;

    public PCBills() {
    }

    public PCBills(Integer id) {
        this.id = id;
    }

    public PCBills(Integer id, float amount, BigDecimal cost, int sitesId) {
        this.id = id;
        this.amount = amount;
        this.cost = cost;
        this.sitesId = sitesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getPdfId() {
        return pdfId;
    }

    public void setPdfId(Integer pdfId) {
        this.pdfId = pdfId;
    }

    public int getSitesId() {
        return sitesId;
    }

    public void setSitesId(int sitesId) {
        this.sitesId = sitesId;
    }

    public Boolean getIsBasedOnOriginalModel() {
        return isBasedOnOriginalModel;
    }

    public void setIsBasedOnOriginalModel(Boolean isBasedOnOriginalModel) {
        this.isBasedOnOriginalModel = isBasedOnOriginalModel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


    public String getDateStartStr() {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String s = formatter.format(dateStart);
        return s;
    }

    
   
    public String getDateEndStr() {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String s = formatter.format(dateEnd);
        return s;
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
        if (!(object instanceof PCBills)) {
            return false;
        }
        PCBills other = (PCBills) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PCBills[ id=" + id + " ]";
    }
    
}
