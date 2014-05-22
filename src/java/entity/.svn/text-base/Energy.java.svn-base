/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "energy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Energy.findAll", query = "SELECT e FROM Energy e"),
    @NamedQuery(name = "Energy.findByIdEnergy", query = "SELECT e FROM Energy e WHERE e.idEnergy = :idEnergy"),
    @NamedQuery(name = "Energy.findByLightPowerBaseOcc", query = "SELECT e FROM Energy e WHERE e.lightPowerBaseOcc = :lightPowerBaseOcc"),
    @NamedQuery(name = "Energy.findByLightPowerBaseUnOcc", query = "SELECT e FROM Energy e WHERE e.lightPowerBaseUnOcc = :lightPowerBaseUnOcc"),
    @NamedQuery(name = "Energy.findByPercentMaxLightSetting", query = "SELECT e FROM Energy e WHERE e.percentMaxLightSetting = :percentMaxLightSetting"),
    @NamedQuery(name = "Energy.findByPercentMaxLightOriginal", query = "SELECT e FROM Energy e WHERE e.percentMaxLightOriginal = :percentMaxLightOriginal"),
    @NamedQuery(name = "Energy.findByIsOnWhenDark", query = "SELECT e FROM Energy e WHERE e.isOnWhenDark = :isOnWhenDark"),
    @NamedQuery(name = "Energy.findByIsWholeBuilding", query = "SELECT e FROM Energy e WHERE e.isWholeBuilding = :isWholeBuilding"),
    @NamedQuery(name = "Energy.findByOrigSetpointCoolOcc", query = "SELECT e FROM Energy e WHERE e.origSetpointCoolOcc = :origSetpointCoolOcc"),
    @NamedQuery(name = "Energy.findByOrigSetpointCoolUnocc", query = "SELECT e FROM Energy e WHERE e.origSetpointCoolUnocc = :origSetpointCoolUnocc"),
    @NamedQuery(name = "Energy.findByOrigSetpointHeatOcc", query = "SELECT e FROM Energy e WHERE e.origSetpointHeatOcc = :origSetpointHeatOcc"),
    @NamedQuery(name = "Energy.findByOrigSetpointHeatUnocc", query = "SELECT e FROM Energy e WHERE e.origSetpointHeatUnocc = :origSetpointHeatUnocc"),
    @NamedQuery(name = "Energy.findBySetpointCoolOcc", query = "SELECT e FROM Energy e WHERE e.setpointCoolOcc = :setpointCoolOcc"),
    @NamedQuery(name = "Energy.findBySetpointHeatOcc", query = "SELECT e FROM Energy e WHERE e.setpointHeatOcc = :setpointHeatOcc"),
    @NamedQuery(name = "Energy.findBySitesId", query = "SELECT e FROM Energy e WHERE e.sitesId = :sitesId"),
    @NamedQuery(name = "Energy.findByZonesIdzones", query = "SELECT e FROM Energy e WHERE e.zonesIdzones = :zonesIdzones"),
    @NamedQuery(name = "Energy.findByEndusecategoryidEndUseCategory", query = "SELECT e FROM Energy e WHERE e.endusecategoryidEndUseCategory = :endusecategoryidEndUseCategory"),
    @NamedQuery(name = "Energy.findByHeatEnergySens", query = "SELECT e FROM Energy e WHERE e.heatEnergySens = :heatEnergySens"),
    @NamedQuery(name = "Energy.findByCoolEnergySens", query = "SELECT e FROM Energy e WHERE e.coolEnergySens = :coolEnergySens"),
    @NamedQuery(name = "Energy.findByScheduleIdschedule", query = "SELECT e FROM Energy e WHERE e.scheduleIdschedule = :scheduleIdschedule"),
    @NamedQuery(name = "Energy.findBySetpointHeatUnocc", query = "SELECT e FROM Energy e WHERE e.setpointHeatUnocc = :setpointHeatUnocc"),
    @NamedQuery(name = "Energy.findBySetpointCoolUnocc", query = "SELECT e FROM Energy e WHERE e.setpointCoolUnocc = :setpointCoolUnocc"),
    @NamedQuery(name = "Energy.findByOldBTUperHDD", query = "SELECT e FROM Energy e WHERE e.oldBTUperHDD = :oldBTUperHDD"),
    @NamedQuery(name = "Energy.findByOldKWHperCDD", query = "SELECT e FROM Energy e WHERE e.oldKWHperCDD = :oldKWHperCDD"),
    @NamedQuery(name = "Energy.findByIsOverride", query = "SELECT e FROM Energy e WHERE e.isOverride = :isOverride"),
    @NamedQuery(name = "Energy.findByClientidClient", query = "SELECT e FROM Energy e WHERE e.clientidClient = :clientidClient"),
    @NamedQuery(name = "Energy.findByOldOtherBTU", query = "SELECT e FROM Energy e WHERE e.oldOtherBTU = :oldOtherBTU"),
    @NamedQuery(name = "Energy.findByOldOtherKwh", query = "SELECT e FROM Energy e WHERE e.oldOtherKwh = :oldOtherKwh"),
    @NamedQuery(name = "Energy.findByNewBTUperHDD", query = "SELECT e FROM Energy e WHERE e.newBTUperHDD = :newBTUperHDD"),
    @NamedQuery(name = "Energy.findByNewKwhperCDD", query = "SELECT e FROM Energy e WHERE e.newKwhperCDD = :newKwhperCDD"),
    @NamedQuery(name = "Energy.findByNewOtherBTU", query = "SELECT e FROM Energy e WHERE e.newOtherBTU = :newOtherBTU"),
    @NamedQuery(name = "Energy.findByNewOtherKwh", query = "SELECT e FROM Energy e WHERE e.newOtherKwh = :newOtherKwh"),
    @NamedQuery(name = "Energy.findByCDDtoDate", query = "SELECT e FROM Energy e WHERE e.cDDtoDate = :cDDtoDate"),
    @NamedQuery(name = "Energy.findByHDDtoDate", query = "SELECT e FROM Energy e WHERE e.hDDtoDate = :hDDtoDate"),
    @NamedQuery(name = "Energy.findByDateForDegreeDays", query = "SELECT e FROM Energy e WHERE e.dateForDegreeDays = :dateForDegreeDays"),
    @NamedQuery(name = "Energy.findByBaseHeatEnergyAnnual", query = "SELECT e FROM Energy e WHERE e.baseHeatEnergyAnnual = :baseHeatEnergyAnnual"),
    @NamedQuery(name = "Energy.findByBaseCoolEnergyAnnual", query = "SELECT e FROM Energy e WHERE e.baseCoolEnergyAnnual = :baseCoolEnergyAnnual")})
public class Energy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idEnergy")
    private Integer idEnergy;
    @Column(name = "lightPowerBaseOcc")
    private Integer lightPowerBaseOcc;
    @Column(name = "lightPowerBaseUnOcc")
    private Integer lightPowerBaseUnOcc;
    @Column(name = "PercentMaxLightSetting")
    private Integer percentMaxLightSetting;
    @Column(name = "PercentMaxLightOriginal")
    private Integer percentMaxLightOriginal;
    @Column(name = "IsOnWhenDark")
    private Boolean isOnWhenDark;
    @Column(name = "IsWholeBuilding")
    private Boolean isWholeBuilding;
    @Column(name = "origSetpointCoolOcc")
    private Integer origSetpointCoolOcc;
    @Column(name = "origSetpointCoolUnocc")
    private Integer origSetpointCoolUnocc;
    @Column(name = "origSetpointHeatOcc")
    private Integer origSetpointHeatOcc;
    @Column(name = "origSetpointHeatUnocc")
    private Integer origSetpointHeatUnocc;
    @Column(name = "setpointCoolOcc")
    private Integer setpointCoolOcc;
    @Column(name = "setpointHeatOcc")
    private Integer setpointHeatOcc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sites_id")
    private int sitesId;
    @Column(name = "zones_idzones")
    private Integer zonesIdzones;
    @Column(name = "endusecategory_idEndUseCategory")
    private Integer endusecategoryidEndUseCategory;
    @Column(name = "HeatEnergySens")
    private Integer heatEnergySens;
    @Column(name = "CoolEnergySens")
    private Integer coolEnergySens;
    @Basic(optional = false)
    @NotNull
    @Column(name = "schedule_idschedule")
    private int scheduleIdschedule;
    @Column(name = "setpointHeatUnocc")
    private Integer setpointHeatUnocc;
    @Column(name = "setpointCoolUnocc")
    private Integer setpointCoolUnocc;
    @Column(name = "OldBTUperHDD")
    private Integer oldBTUperHDD;
    @Column(name = "OldKWHperCDD")
    private Integer oldKWHperCDD;
    @Column(name = "isOverride")
    private Boolean isOverride;
    @Basic(optional = false)
    @NotNull
    @Column(name = "client_idClient")
    private int clientidClient;
    @Column(name = "OldOtherBTU")
    private Integer oldOtherBTU;
    @Column(name = "OldOtherKwh")
    private Integer oldOtherKwh;
    @Column(name = "newBTUperHDD")
    private Integer newBTUperHDD;
    @Column(name = "newKwhperCDD")
    private Integer newKwhperCDD;
    @Column(name = "newOtherBTU")
    private Integer newOtherBTU;
    @Column(name = "newOtherKwh")
    private Integer newOtherKwh;
    @Column(name = "CDDtoDate")
    private Integer cDDtoDate;
    @Column(name = "HDDtoDate")
    private Integer hDDtoDate;
    @Column(name = "DateForDegreeDays")
    @Temporal(TemporalType.DATE)
    private Date dateForDegreeDays;
    @Column(name = "baseHeatEnergyAnnual")
    private Integer baseHeatEnergyAnnual;
    @Column(name = "baseCoolEnergyAnnual")
    private Integer baseCoolEnergyAnnual;

    public Energy() {
    }

    public Energy(Integer idEnergy) {
        this.idEnergy = idEnergy;
    }

    public Energy(Integer idEnergy, int sitesId, int scheduleIdschedule, int clientidClient) {
        this.idEnergy = idEnergy;
        this.sitesId = sitesId;
        this.scheduleIdschedule = scheduleIdschedule;
        this.clientidClient = clientidClient;
    }

    public Integer getIdEnergy() {
        return idEnergy;
    }

    public void setIdEnergy(Integer idEnergy) {
        this.idEnergy = idEnergy;
    }

    public Integer getLightPowerBaseOcc() {
        return lightPowerBaseOcc;
    }

    public void setLightPowerBaseOcc(Integer lightPowerBaseOcc) {
        this.lightPowerBaseOcc = lightPowerBaseOcc;
    }

    public Integer getLightPowerBaseUnOcc() {
        return lightPowerBaseUnOcc;
    }

    public void setLightPowerBaseUnOcc(Integer lightPowerBaseUnOcc) {
        this.lightPowerBaseUnOcc = lightPowerBaseUnOcc;
    }

    public Integer getPercentMaxLightSetting() {
        return percentMaxLightSetting;
    }

    public void setPercentMaxLightSetting(Integer percentMaxLightSetting) {
        this.percentMaxLightSetting = percentMaxLightSetting;
    }

    public Integer getPercentMaxLightOriginal() {
        return percentMaxLightOriginal;
    }

    public void setPercentMaxLightOriginal(Integer percentMaxLightOriginal) {
        this.percentMaxLightOriginal = percentMaxLightOriginal;
    }

    public Boolean getIsOnWhenDark() {
        return isOnWhenDark;
    }

    public void setIsOnWhenDark(Boolean isOnWhenDark) {
        this.isOnWhenDark = isOnWhenDark;
    }

    public Boolean getIsWholeBuilding() {
        return isWholeBuilding;
    }

    public void setIsWholeBuilding(Boolean isWholeBuilding) {
        this.isWholeBuilding = isWholeBuilding;
    }

    public Integer getOrigSetpointCoolOcc() {
        return origSetpointCoolOcc;
    }

    public void setOrigSetpointCoolOcc(Integer origSetpointCoolOcc) {
        this.origSetpointCoolOcc = origSetpointCoolOcc;
    }

    public Integer getOrigSetpointCoolUnocc() {
        return origSetpointCoolUnocc;
    }

    public void setOrigSetpointCoolUnocc(Integer origSetpointCoolUnocc) {
        this.origSetpointCoolUnocc = origSetpointCoolUnocc;
    }

    public Integer getOrigSetpointHeatOcc() {
        return origSetpointHeatOcc;
    }

    public void setOrigSetpointHeatOcc(Integer origSetpointHeatOcc) {
        this.origSetpointHeatOcc = origSetpointHeatOcc;
    }

    public Integer getOrigSetpointHeatUnocc() {
        return origSetpointHeatUnocc;
    }

    public void setOrigSetpointHeatUnocc(Integer origSetpointHeatUnocc) {
        this.origSetpointHeatUnocc = origSetpointHeatUnocc;
    }

    public Integer getSetpointCoolOcc() {
        return setpointCoolOcc;
    }

    public void setSetpointCoolOcc(Integer setpointCoolOcc) {
        this.setpointCoolOcc = setpointCoolOcc;
    }

    public Integer getSetpointHeatOcc() {
        return setpointHeatOcc;
    }

    public void setSetpointHeatOcc(Integer setpointHeatOcc) {
        this.setpointHeatOcc = setpointHeatOcc;
    }

    public int getSitesId() {
        return sitesId;
    }

    public void setSitesId(int sitesId) {
        this.sitesId = sitesId;
    }

    public Integer getZonesIdzones() {
        return zonesIdzones;
    }

    public void setZonesIdzones(Integer zonesIdzones) {
        this.zonesIdzones = zonesIdzones;
    }

    public Integer getEndusecategoryidEndUseCategory() {
        return endusecategoryidEndUseCategory;
    }

    public void setEndusecategoryidEndUseCategory(Integer endusecategoryidEndUseCategory) {
        this.endusecategoryidEndUseCategory = endusecategoryidEndUseCategory;
    }

    public Integer getHeatEnergySens() {
        return heatEnergySens;
    }

    public void setHeatEnergySens(Integer heatEnergySens) {
        this.heatEnergySens = heatEnergySens;
    }

    public Integer getCoolEnergySens() {
        return coolEnergySens;
    }

    public void setCoolEnergySens(Integer coolEnergySens) {
        this.coolEnergySens = coolEnergySens;
    }

    public int getScheduleIdschedule() {
        return scheduleIdschedule;
    }

    public void setScheduleIdschedule(int scheduleIdschedule) {
        this.scheduleIdschedule = scheduleIdschedule;
    }

    public Integer getSetpointHeatUnocc() {
        return setpointHeatUnocc;
    }

    public void setSetpointHeatUnocc(Integer setpointHeatUnocc) {
        this.setpointHeatUnocc = setpointHeatUnocc;
    }

    public Integer getSetpointCoolUnocc() {
        return setpointCoolUnocc;
    }

    public void setSetpointCoolUnocc(Integer setpointCoolUnocc) {
        this.setpointCoolUnocc = setpointCoolUnocc;
    }

    public Integer getOldBTUperHDD() {
        return oldBTUperHDD;
    }

    public void setOldBTUperHDD(Integer oldBTUperHDD) {
        this.oldBTUperHDD = oldBTUperHDD;
    }

    public Integer getOldKWHperCDD() {
        return oldKWHperCDD;
    }

    public void setOldKWHperCDD(Integer oldKWHperCDD) {
        this.oldKWHperCDD = oldKWHperCDD;
    }

    public Boolean getIsOverride() {
        return isOverride;
    }

    public void setIsOverride(Boolean isOverride) {
        this.isOverride = isOverride;
    }

    public int getClientidClient() {
        return clientidClient;
    }

    public void setClientidClient(int clientidClient) {
        this.clientidClient = clientidClient;
    }

    public Integer getOldOtherBTU() {
        return oldOtherBTU;
    }

    public void setOldOtherBTU(Integer oldOtherBTU) {
        this.oldOtherBTU = oldOtherBTU;
    }

    public Integer getOldOtherKwh() {
        return oldOtherKwh;
    }

    public void setOldOtherKwh(Integer oldOtherKwh) {
        this.oldOtherKwh = oldOtherKwh;
    }

    public Integer getNewBTUperHDD() {
        return newBTUperHDD;
    }

    public void setNewBTUperHDD(Integer newBTUperHDD) {
        this.newBTUperHDD = newBTUperHDD;
    }

    public Integer getNewKwhperCDD() {
        return newKwhperCDD;
    }

    public void setNewKwhperCDD(Integer newKwhperCDD) {
        this.newKwhperCDD = newKwhperCDD;
    }

    public Integer getNewOtherBTU() {
        return newOtherBTU;
    }

    public void setNewOtherBTU(Integer newOtherBTU) {
        this.newOtherBTU = newOtherBTU;
    }

    public Integer getNewOtherKwh() {
        return newOtherKwh;
    }

    public void setNewOtherKwh(Integer newOtherKwh) {
        this.newOtherKwh = newOtherKwh;
    }

    public Integer getCDDtoDate() {
        return cDDtoDate;
    }

    public void setCDDtoDate(Integer cDDtoDate) {
        this.cDDtoDate = cDDtoDate;
    }

    public Integer getHDDtoDate() {
        return hDDtoDate;
    }

    public void setHDDtoDate(Integer hDDtoDate) {
        this.hDDtoDate = hDDtoDate;
    }

    public Date getDateForDegreeDays() {
        return dateForDegreeDays;
    }

    public void setDateForDegreeDays(Date dateForDegreeDays) {
        this.dateForDegreeDays = dateForDegreeDays;
    }

    public Integer getBaseHeatEnergyAnnual() {
        return baseHeatEnergyAnnual;
    }

    public void setBaseHeatEnergyAnnual(Integer baseHeatEnergyAnnual) {
        this.baseHeatEnergyAnnual = baseHeatEnergyAnnual;
    }

    public Integer getBaseCoolEnergyAnnual() {
        return baseCoolEnergyAnnual;
    }

    public void setBaseCoolEnergyAnnual(Integer baseCoolEnergyAnnual) {
        this.baseCoolEnergyAnnual = baseCoolEnergyAnnual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnergy != null ? idEnergy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Energy)) {
            return false;
        }
        Energy other = (Energy) object;
        if ((this.idEnergy == null && other.idEnergy != null) || (this.idEnergy != null && !this.idEnergy.equals(other.idEnergy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Energy[ idEnergy=" + idEnergy + " ]";
    }
    
}
