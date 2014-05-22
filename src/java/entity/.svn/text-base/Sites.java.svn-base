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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Engel-less
 */
@Entity
@Table(name = "sites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sites.findAll", query = "SELECT s FROM Sites s"),
    @NamedQuery(name = "Sites.findById", query = "SELECT s FROM Sites s WHERE s.id = :id"),
    @NamedQuery(name = "Sites.findByName", query = "SELECT s FROM Sites s WHERE s.name = :name"),
    @NamedQuery(name = "Sites.findByAddress1", query = "SELECT s FROM Sites s WHERE s.address1 = :address1"),
    @NamedQuery(name = "Sites.findByNPeople", query = "SELECT s FROM Sites s WHERE s.nPeople = :nPeople"),
    @NamedQuery(name = "Sites.findBySquarefeet", query = "SELECT s FROM Sites s WHERE s.squarefeet = :squarefeet"),
    @NamedQuery(name = "Sites.findByAddress2", query = "SELECT s FROM Sites s WHERE s.address2 = :address2"),
    @NamedQuery(name = "Sites.findByCity", query = "SELECT s FROM Sites s WHERE s.city = :city"),
    @NamedQuery(name = "Sites.findByState", query = "SELECT s FROM Sites s WHERE s.state = :state"),
    @NamedQuery(name = "Sites.findByZipcode", query = "SELECT s FROM Sites s WHERE s.zipcode = :zipcode"),
    @NamedQuery(name = "Sites.findByClientidClient", query = "SELECT s FROM Sites s WHERE s.clientidClient = :clientidClient"),
    @NamedQuery(name = "Sites.findByStartDate", query = "SELECT s FROM Sites s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "Sites.findByWeatherStationid", query = "SELECT s FROM Sites s WHERE s.weatherStationid = :weatherStationid"),
    @NamedQuery(name = "Sites.findByLightPowerBaseOcc", query = "SELECT s FROM Sites s WHERE s.lightPowerBaseOcc = :lightPowerBaseOcc"),
    @NamedQuery(name = "Sites.findByLightPowerBaseUnOcc", query = "SELECT s FROM Sites s WHERE s.lightPowerBaseUnOcc = :lightPowerBaseUnOcc"),
    @NamedQuery(name = "Sites.findByPercentMaxLightSetting", query = "SELECT s FROM Sites s WHERE s.percentMaxLightSetting = :percentMaxLightSetting"),
    @NamedQuery(name = "Sites.findByPercentMaxLightOriginal", query = "SELECT s FROM Sites s WHERE s.percentMaxLightOriginal = :percentMaxLightOriginal"),
    @NamedQuery(name = "Sites.findByIsOnWhenDark", query = "SELECT s FROM Sites s WHERE s.isOnWhenDark = :isOnWhenDark"),
    @NamedQuery(name = "Sites.findByIsWholeBuilding", query = "SELECT s FROM Sites s WHERE s.isWholeBuilding = :isWholeBuilding"),
    @NamedQuery(name = "Sites.findByOrigSetpointCoolOcc", query = "SELECT s FROM Sites s WHERE s.origSetpointCoolOcc = :origSetpointCoolOcc"),
    @NamedQuery(name = "Sites.findByOrigSetpointCoolUnocc", query = "SELECT s FROM Sites s WHERE s.origSetpointCoolUnocc = :origSetpointCoolUnocc"),
    @NamedQuery(name = "Sites.findByOrigSetpointHeatOcc", query = "SELECT s FROM Sites s WHERE s.origSetpointHeatOcc = :origSetpointHeatOcc"),
    @NamedQuery(name = "Sites.findByOrigSetpointHeatUnocc", query = "SELECT s FROM Sites s WHERE s.origSetpointHeatUnocc = :origSetpointHeatUnocc"),
    @NamedQuery(name = "Sites.findBySetpointCoolOcc", query = "SELECT s FROM Sites s WHERE s.setpointCoolOcc = :setpointCoolOcc"),
    @NamedQuery(name = "Sites.findBySetpointHeatOcc", query = "SELECT s FROM Sites s WHERE s.setpointHeatOcc = :setpointHeatOcc"),
    @NamedQuery(name = "Sites.findByHeatEnergySens", query = "SELECT s FROM Sites s WHERE s.heatEnergySens = :heatEnergySens"),
    @NamedQuery(name = "Sites.findByCoolEnergySens", query = "SELECT s FROM Sites s WHERE s.coolEnergySens = :coolEnergySens"),
    @NamedQuery(name = "Sites.findByScheduleIdschedule", query = "SELECT s FROM Sites s WHERE s.scheduleIdschedule = :scheduleIdschedule"),
    @NamedQuery(name = "Sites.findBySetpointHeatUnocc", query = "SELECT s FROM Sites s WHERE s.setpointHeatUnocc = :setpointHeatUnocc"),
    @NamedQuery(name = "Sites.findBySetpointCoolUnocc", query = "SELECT s FROM Sites s WHERE s.setpointCoolUnocc = :setpointCoolUnocc"),
    @NamedQuery(name = "Sites.findByOldBTUperHDD", query = "SELECT s FROM Sites s WHERE s.oldBTUperHDD = :oldBTUperHDD"),
    @NamedQuery(name = "Sites.findByOldKWHperCDD", query = "SELECT s FROM Sites s WHERE s.oldKWHperCDD = :oldKWHperCDD"),
    @NamedQuery(name = "Sites.findByIsOverride", query = "SELECT s FROM Sites s WHERE s.isOverride = :isOverride"),
    @NamedQuery(name = "Sites.findByOldOtherBTU", query = "SELECT s FROM Sites s WHERE s.oldOtherBTU = :oldOtherBTU"),
    @NamedQuery(name = "Sites.findByOldOtherKwh", query = "SELECT s FROM Sites s WHERE s.oldOtherKwh = :oldOtherKwh"),
    @NamedQuery(name = "Sites.findByNewBTUperHDD", query = "SELECT s FROM Sites s WHERE s.newBTUperHDD = :newBTUperHDD"),
    @NamedQuery(name = "Sites.findByNewKwhperCDD", query = "SELECT s FROM Sites s WHERE s.newKwhperCDD = :newKwhperCDD"),
    @NamedQuery(name = "Sites.findByNewOtherBTU", query = "SELECT s FROM Sites s WHERE s.newOtherBTU = :newOtherBTU"),
    @NamedQuery(name = "Sites.findByNewOtherKwh", query = "SELECT s FROM Sites s WHERE s.newOtherKwh = :newOtherKwh")})
public class Sites implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "address1")
    private String address1;
    @Column(name = "nPeople")
    private Integer nPeople;
    @Column(name = "squarefeet")
    private Integer squarefeet;
    @Size(max = 45)
    @Column(name = "address2")
    private String address2;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 45)
    @Column(name = "zipcode")
    private String zipcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Client_idClient")
    private int clientidClient;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "WeatherStationid")
    private Integer weatherStationid;
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

    public Sites() {
    }

    public Sites(Integer id) {
        this.id = id;
    }

    public Sites(Integer id, String name, int clientidClient, int scheduleIdschedule) {
        this.id = id;
        this.name = name;
        this.clientidClient = clientidClient;
        this.scheduleIdschedule = scheduleIdschedule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public Integer getNPeople() {
        return nPeople;
    }

    public void setNPeople(Integer nPeople) {
        this.nPeople = nPeople;
    }

    public Integer getSquarefeet() {
        return squarefeet;
    }

    public void setSquarefeet(Integer squarefeet) {
        this.squarefeet = squarefeet;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getClientidClient() {
        return clientidClient;
    }

    public void setClientidClient(int clientidClient) {
        this.clientidClient = clientidClient;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getWeatherStationid() {
        return weatherStationid;
    }

    public void setWeatherStationid(Integer weatherStationid) {
        this.weatherStationid = weatherStationid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sites)) {
            return false;
        }
        Sites other = (Sites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sites[ id=" + id + " ]";
    }
    
}
