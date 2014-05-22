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
@Table(name = "hdd_cdd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HddCdd.findAll", query = "SELECT h FROM HddCdd h"),
    @NamedQuery(name = "HddCdd.findByIdHDD", query = "SELECT h FROM HddCdd h WHERE h.idHDD = :idHDD"),
    @NamedQuery(name = "HddCdd.findByStartDate", query = "SELECT h FROM HddCdd h WHERE h.startDate = :startDate"),
    @NamedQuery(name = "HddCdd.findByEndDate", query = "SELECT h FROM HddCdd h WHERE h.endDate = :endDate"),
    @NamedQuery(name = "HddCdd.findByHdd", query = "SELECT h FROM HddCdd h WHERE h.hdd = :hdd"),
    @NamedQuery(name = "HddCdd.findByCdd", query = "SELECT h FROM HddCdd h WHERE h.cdd = :cdd"),
    @NamedQuery(name = "HddCdd.findByBaseTemperature", query = "SELECT h FROM HddCdd h WHERE h.baseTemperature = :baseTemperature"),
    @NamedQuery(name = "HddCdd.findByWeatherStationidWeatherStation", query = "SELECT h FROM HddCdd h WHERE h.weatherStationidWeatherStation = :weatherStationidWeatherStation"),
    @NamedQuery(name = "HddCdd.findByTempAvg", query = "SELECT h FROM HddCdd h WHERE h.tempAvg = :tempAvg"),
    @NamedQuery(name = "HddCdd.findByTempHi", query = "SELECT h FROM HddCdd h WHERE h.tempHi = :tempHi"),
    @NamedQuery(name = "HddCdd.findByTempLo", query = "SELECT h FROM HddCdd h WHERE h.tempLo = :tempLo")})
public class HddCdd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idHDD")
    private Integer idHDD;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "HDD")
    private Integer hdd;
    @Column(name = "CDD")
    private Integer cdd;
    @Column(name = "baseTemperature")
    private Integer baseTemperature;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WeatherStation_idWeatherStation")
    private int weatherStationidWeatherStation;
    @Column(name = "tempAvg")
    private Integer tempAvg;
    @Column(name = "tempHi")
    private Integer tempHi;
    @Column(name = "tempLo")
    private Integer tempLo;

    public HddCdd() {
    }

    public HddCdd(Integer idHDD) {
        this.idHDD = idHDD;
    }

    public HddCdd(Integer idHDD, int weatherStationidWeatherStation) {
        this.idHDD = idHDD;
        this.weatherStationidWeatherStation = weatherStationidWeatherStation;
    }

    public Integer getIdHDD() {
        return idHDD;
    }

    public void setIdHDD(Integer idHDD) {
        this.idHDD = idHDD;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getHdd() {
        return hdd;
    }

    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }

    public Integer getCdd() {
        return cdd;
    }

    public void setCdd(Integer cdd) {
        this.cdd = cdd;
    }

    public Integer getBaseTemperature() {
        return baseTemperature;
    }

    public void setBaseTemperature(Integer baseTemperature) {
        this.baseTemperature = baseTemperature;
    }

    public int getWeatherStationidWeatherStation() {
        return weatherStationidWeatherStation;
    }

    public void setWeatherStationidWeatherStation(int weatherStationidWeatherStation) {
        this.weatherStationidWeatherStation = weatherStationidWeatherStation;
    }

    public Integer getTempAvg() {
        return tempAvg;
    }

    public void setTempAvg(Integer tempAvg) {
        this.tempAvg = tempAvg;
    }

    public Integer getTempHi() {
        return tempHi;
    }

    public void setTempHi(Integer tempHi) {
        this.tempHi = tempHi;
    }

    public Integer getTempLo() {
        return tempLo;
    }

    public void setTempLo(Integer tempLo) {
        this.tempLo = tempLo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHDD != null ? idHDD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HddCdd)) {
            return false;
        }
        HddCdd other = (HddCdd) object;
        if ((this.idHDD == null && other.idHDD != null) || (this.idHDD != null && !this.idHDD.equals(other.idHDD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HddCdd[ idHDD=" + idHDD + " ]";
    }
    
}
