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
@Table(name = "bills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bills.findAll", query = "SELECT b FROM Bills b"),
    @NamedQuery(name = "Bills.findById", query = "SELECT b FROM Bills b WHERE b.id = :id"),
    @NamedQuery(name = "Bills.findByFiscalYear", query = "SELECT b FROM Bills b WHERE b.fiscalYear = :fiscalYear"),
    @NamedQuery(name = "Bills.findByFiscalMonth", query = "SELECT b FROM Bills b WHERE b.fiscalMonth = :fiscalMonth"),
    @NamedQuery(name = "Bills.findByDateStart", query = "SELECT b FROM Bills b WHERE b.dateStart = :dateStart"),
    @NamedQuery(name = "Bills.findByDateEnd", query = "SELECT b FROM Bills b WHERE b.dateEnd = :dateEnd"),
    @NamedQuery(name = "Bills.findByReadStart", query = "SELECT b FROM Bills b WHERE b.readStart = :readStart"),
    @NamedQuery(name = "Bills.findByReadEnd", query = "SELECT b FROM Bills b WHERE b.readEnd = :readEnd"),
    @NamedQuery(name = "Bills.findByAmount", query = "SELECT b FROM Bills b WHERE b.amount = :amount"),
    @NamedQuery(name = "Bills.findByCost", query = "SELECT b FROM Bills b WHERE b.cost = :cost"),
    @NamedQuery(name = "Bills.findByInternalID", query = "SELECT b FROM Bills b WHERE b.internalID = :internalID"),
    @NamedQuery(name = "Bills.findByPdfId", query = "SELECT b FROM Bills b WHERE b.pdfId = :pdfId"),
    @NamedQuery(name = "Bills.findByMetersId", query = "SELECT b FROM Bills b WHERE b.metersId = :metersId"),
    @NamedQuery(name = "Bills.findByMultiplier", query = "SELECT b FROM Bills b WHERE b.multiplier = :multiplier"),
    @NamedQuery(name = "Bills.findByDemand", query = "SELECT b FROM Bills b WHERE b.demand = :demand"),
    @NamedQuery(name = "Bills.findByPeakDemand", query = "SELECT b FROM Bills b WHERE b.peakDemand = :peakDemand"),
    @NamedQuery(name = "Bills.findByPowerFactor", query = "SELECT b FROM Bills b WHERE b.powerFactor = :powerFactor"),
    @NamedQuery(name = "Bills.findByKva", query = "SELECT b FROM Bills b WHERE b.kva = :kva"),
    @NamedQuery(name = "Bills.findByLoadFactor", query = "SELECT b FROM Bills b WHERE b.loadFactor = :loadFactor"),
    @NamedQuery(name = "Bills.findByCostDemand", query = "SELECT b FROM Bills b WHERE b.costDemand = :costDemand"),
    @NamedQuery(name = "Bills.findByCostUsage", query = "SELECT b FROM Bills b WHERE b.costUsage = :costUsage"),
    @NamedQuery(name = "Bills.findByCostDistDemand", query = "SELECT b FROM Bills b WHERE b.costDistDemand = :costDistDemand"),
    @NamedQuery(name = "Bills.findByCostDistUsage", query = "SELECT b FROM Bills b WHERE b.costDistUsage = :costDistUsage"),
    @NamedQuery(name = "Bills.findBySurchargeAsPercent", query = "SELECT b FROM Bills b WHERE b.surchargeAsPercent = :surchargeAsPercent"),
    @NamedQuery(name = "Bills.findByTaxAmount", query = "SELECT b FROM Bills b WHERE b.taxAmount = :taxAmount"),
    @NamedQuery(name = "Bills.findBySurchargeFixed", query = "SELECT b FROM Bills b WHERE b.surchargeFixed = :surchargeFixed"),
    @NamedQuery(name = "Bills.findByUsageThreshold", query = "SELECT b FROM Bills b WHERE b.usageThreshold = :usageThreshold"),
    @NamedQuery(name = "Bills.findByCostAboveThreshold", query = "SELECT b FROM Bills b WHERE b.costAboveThreshold = :costAboveThreshold"),
    @NamedQuery(name = "Bills.findByOffPeakEnergy", query = "SELECT b FROM Bills b WHERE b.offPeakEnergy = :offPeakEnergy"),
    @NamedQuery(name = "Bills.findByOffPeakDiscount", query = "SELECT b FROM Bills b WHERE b.offPeakDiscount = :offPeakDiscount"),
    @NamedQuery(name = "Bills.findByIsBasedOnOriginalModel", query = "SELECT b FROM Bills b WHERE b.isBasedOnOriginalModel = :isBasedOnOriginalModel")})
public class Bills implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "fiscalYear")
    private Integer fiscalYear;
    @Column(name = "fiscalMonth")
    private Integer fiscalMonth;
    @Column(name = "dateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "dateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Column(name = "readStart")
    private Integer readStart;
    @Column(name = "readEnd")
    private Integer readEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private BigDecimal cost;
    @Size(max = 45)
    @Column(name = "internalID")
    private String internalID;
    @Column(name = "pdf_id")
    private Integer pdfId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meters_id")
    private int metersId;
    @Column(name = "multiplier")
    private Float multiplier;
    @Column(name = "demand")
    private Float demand;
    @Column(name = "peakDemand")
    private Float peakDemand;
    @Column(name = "powerFactor")
    private Float powerFactor;
    @Column(name = "kva")
    private Float kva;
    @Column(name = "loadFactor")
    private Float loadFactor;
    @Column(name = "costDemand")
    private BigDecimal costDemand;
    @Column(name = "costUsage")
    private BigDecimal costUsage;
    @Column(name = "costDistDemand")
    private BigDecimal costDistDemand;
    @Column(name = "costDistUsage")
    private BigDecimal costDistUsage;
    @Column(name = "surchargeAsPercent")
    private BigDecimal surchargeAsPercent;
    @Column(name = "taxAmount")
    private BigDecimal taxAmount;
    @Column(name = "surchargeFixed")
    private BigDecimal surchargeFixed;
    @Column(name = "usageThreshold")
    private Integer usageThreshold;
    @Column(name = "CostAboveThreshold")
    private BigDecimal costAboveThreshold;
    @Column(name = "OffPeakEnergy")
    private Integer offPeakEnergy;
    @Column(name = "OffPeakDiscount")
    private BigDecimal offPeakDiscount;
    @Column(name = "IsBasedOnOriginalModel")
    private Boolean isBasedOnOriginalModel;

    public Bills() {
    }

    public Bills(Integer id) {
        this.id = id;
    }

    public Bills(Integer id, float amount, BigDecimal cost, int metersId) {
        this.id = id;
        this.amount = amount;
        this.cost = cost;
        this.metersId = metersId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Integer getFiscalMonth() {
        return fiscalMonth;
    }

    public void setFiscalMonth(Integer fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
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

    public Integer getReadStart() {
        return readStart;
    }

    public void setReadStart(Integer readStart) {
        this.readStart = readStart;
    }

    public Integer getReadEnd() {
        return readEnd;
    }

    public void setReadEnd(Integer readEnd) {
        this.readEnd = readEnd;
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

    public String getInternalID() {
        return internalID;
    }

    public void setInternalID(String internalID) {
        this.internalID = internalID;
    }

    public Integer getPdfId() {
        return pdfId;
    }

    public void setPdfId(Integer pdfId) {
        this.pdfId = pdfId;
    }

    public int getMetersId() {
        return metersId;
    }

    public void setMetersId(int metersId) {
        this.metersId = metersId;
    }

    public Float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Float multiplier) {
        this.multiplier = multiplier;
    }

    public Float getDemand() {
        return demand;
    }

    public void setDemand(Float demand) {
        this.demand = demand;
    }

    public Float getPeakDemand() {
        return peakDemand;
    }

    public void setPeakDemand(Float peakDemand) {
        this.peakDemand = peakDemand;
    }

    public Float getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(Float powerFactor) {
        this.powerFactor = powerFactor;
    }

    public Float getKva() {
        return kva;
    }

    public void setKva(Float kva) {
        this.kva = kva;
    }

    public Float getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(Float loadFactor) {
        this.loadFactor = loadFactor;
    }

    public BigDecimal getCostDemand() {
        return costDemand;
    }

    public void setCostDemand(BigDecimal costDemand) {
        this.costDemand = costDemand;
    }

    public BigDecimal getCostUsage() {
        return costUsage;
    }

    public void setCostUsage(BigDecimal costUsage) {
        this.costUsage = costUsage;
    }

    public BigDecimal getCostDistDemand() {
        return costDistDemand;
    }

    public void setCostDistDemand(BigDecimal costDistDemand) {
        this.costDistDemand = costDistDemand;
    }

    public BigDecimal getCostDistUsage() {
        return costDistUsage;
    }

    public void setCostDistUsage(BigDecimal costDistUsage) {
        this.costDistUsage = costDistUsage;
    }

    public BigDecimal getSurchargeAsPercent() {
        return surchargeAsPercent;
    }

    public void setSurchargeAsPercent(BigDecimal surchargeAsPercent) {
        this.surchargeAsPercent = surchargeAsPercent;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getSurchargeFixed() {
        return surchargeFixed;
    }

    public void setSurchargeFixed(BigDecimal surchargeFixed) {
        this.surchargeFixed = surchargeFixed;
    }

    public Integer getUsageThreshold() {
        return usageThreshold;
    }

    public void setUsageThreshold(Integer usageThreshold) {
        this.usageThreshold = usageThreshold;
    }

    public BigDecimal getCostAboveThreshold() {
        return costAboveThreshold;
    }

    public void setCostAboveThreshold(BigDecimal costAboveThreshold) {
        this.costAboveThreshold = costAboveThreshold;
    }

    public Integer getOffPeakEnergy() {
        return offPeakEnergy;
    }

    public void setOffPeakEnergy(Integer offPeakEnergy) {
        this.offPeakEnergy = offPeakEnergy;
    }

    public BigDecimal getOffPeakDiscount() {
        return offPeakDiscount;
    }

    public void setOffPeakDiscount(BigDecimal offPeakDiscount) {
        this.offPeakDiscount = offPeakDiscount;
    }

    public Boolean getIsBasedOnOriginalModel() {
        return isBasedOnOriginalModel;
    }

    public void setIsBasedOnOriginalModel(Boolean isBasedOnOriginalModel) {
        this.isBasedOnOriginalModel = isBasedOnOriginalModel;
    }

       
    public String getFiscalDateStr() {
        return fiscalYear + "-" + String.format("%02d", fiscalMonth) + "-01";
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
        if (!(object instanceof Bills)) {
            return false;
        }
        Bills other = (Bills) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bills[ id=" + id + " ]";
    }
    
}
