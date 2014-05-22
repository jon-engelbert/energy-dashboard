/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Engel-less
 */
@Entity
@Table(name = "weatherstation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weatherstation.findAll", query = "SELECT w FROM Weatherstation w"),
    @NamedQuery(name = "Weatherstation.findByIdWeatherStation", query = "SELECT w FROM Weatherstation w WHERE w.idWeatherStation = :idWeatherStation"),
    @NamedQuery(name = "Weatherstation.findByName", query = "SELECT w FROM Weatherstation w WHERE w.name = :name"),
    @NamedQuery(name = "Weatherstation.findByHDDannual", query = "SELECT w FROM Weatherstation w WHERE w.hDDannual = :hDDannual"),
    @NamedQuery(name = "Weatherstation.findByCDDannual", query = "SELECT w FROM Weatherstation w WHERE w.cDDannual = :cDDannual"),
    @NamedQuery(name = "Weatherstation.findByHDDsens", query = "SELECT w FROM Weatherstation w WHERE w.hDDsens = :hDDsens"),
    @NamedQuery(name = "Weatherstation.findByHDDsens2", query = "SELECT w FROM Weatherstation w WHERE w.hDDsens2 = :hDDsens2"),
    @NamedQuery(name = "Weatherstation.findByCDDsens", query = "SELECT w FROM Weatherstation w WHERE w.cDDsens = :cDDsens"),
    @NamedQuery(name = "Weatherstation.findByCDDsens2", query = "SELECT w FROM Weatherstation w WHERE w.cDDsens2 = :cDDsens2"),
    @NamedQuery(name = "Weatherstation.findByBaseTemp", query = "SELECT w FROM Weatherstation w WHERE w.baseTemp = :baseTemp")})
public class Weatherstation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "idWeatherStation")
    private Integer idWeatherStation;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Column(name = "HDDannual")
    private Integer hDDannual;
    @Column(name = "CDDannual")
    private Integer cDDannual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HDDsens")
    private Float hDDsens;
    @Column(name = "HDDsens2")
    private Float hDDsens2;
    @Column(name = "CDDsens")
    private Float cDDsens;
    @Column(name = "CDDsens2")
    private Float cDDsens2;
    @Column(name = "baseTemp")
    private Integer baseTemp;

    public Weatherstation() {
    }

    public Weatherstation(Integer idWeatherStation) {
        this.idWeatherStation = idWeatherStation;
    }

    public Integer getIdWeatherStation() {
        return idWeatherStation;
    }

    public void setIdWeatherStation(Integer idWeatherStation) {
        this.idWeatherStation = idWeatherStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHDDannual() {
        return hDDannual;
    }

    public void setHDDannual(Integer hDDannual) {
        this.hDDannual = hDDannual;
    }

    public Integer getCDDannual() {
        return cDDannual;
    }

    public void setCDDannual(Integer cDDannual) {
        this.cDDannual = cDDannual;
    }

    public Float getHDDsens() {
        return hDDsens;
    }

    public void setHDDsens(Float hDDsens) {
        this.hDDsens = hDDsens;
    }

    public Float getHDDsens2() {
        return hDDsens2;
    }

    public void setHDDsens2(Float hDDsens2) {
        this.hDDsens2 = hDDsens2;
    }

    public Float getCDDsens() {
        return cDDsens;
    }

    public void setCDDsens(Float cDDsens) {
        this.cDDsens = cDDsens;
    }

    public Float getCDDsens2() {
        return cDDsens2;
    }

    public void setCDDsens2(Float cDDsens2) {
        this.cDDsens2 = cDDsens2;
    }

    public Integer getBaseTemp() {
        return baseTemp;
    }

    public void setBaseTemp(Integer baseTemp) {
        this.baseTemp = baseTemp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWeatherStation != null ? idWeatherStation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Weatherstation)) {
            return false;
        }
        Weatherstation other = (Weatherstation) object;
        if ((this.idWeatherStation == null && other.idWeatherStation != null) || (this.idWeatherStation != null && !this.idWeatherStation.equals(other.idWeatherStation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Weatherstation[ idWeatherStation=" + idWeatherStation + " ]";
    }
    
}
