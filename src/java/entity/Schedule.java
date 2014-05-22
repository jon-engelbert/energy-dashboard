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
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByIdschedule", query = "SELECT s FROM Schedule s WHERE s.idschedule = :idschedule"),
    @NamedQuery(name = "Schedule.findByClientidClient", query = "SELECT s FROM Schedule s WHERE s.clientidClient = :clientidClient"),
    @NamedQuery(name = "Schedule.findByMonHours", query = "SELECT s FROM Schedule s WHERE s.monHours = :monHours"),
    @NamedQuery(name = "Schedule.findByTuesHours", query = "SELECT s FROM Schedule s WHERE s.tuesHours = :tuesHours"),
    @NamedQuery(name = "Schedule.findByWedHours", query = "SELECT s FROM Schedule s WHERE s.wedHours = :wedHours"),
    @NamedQuery(name = "Schedule.findByThHours", query = "SELECT s FROM Schedule s WHERE s.thHours = :thHours"),
    @NamedQuery(name = "Schedule.findByFriHours", query = "SELECT s FROM Schedule s WHERE s.friHours = :friHours"),
    @NamedQuery(name = "Schedule.findBySatHours", query = "SELECT s FROM Schedule s WHERE s.satHours = :satHours"),
    @NamedQuery(name = "Schedule.findBySunHours", query = "SELECT s FROM Schedule s WHERE s.sunHours = :sunHours"),
    @NamedQuery(name = "Schedule.findByIsOnWhenDark", query = "SELECT s FROM Schedule s WHERE s.isOnWhenDark = :isOnWhenDark"),
    @NamedQuery(name = "Schedule.findByName", query = "SELECT s FROM Schedule s WHERE s.name = :name")})
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idschedule")
    private Integer idschedule;
    @Column(name = "Client_idClient")
    private Integer clientidClient;
    @Column(name = "MonHours")
    private Integer monHours;
    @Column(name = "TuesHours")
    private Integer tuesHours;
    @Column(name = "WedHours")
    private Integer wedHours;
    @Column(name = "ThHours")
    private Integer thHours;
    @Column(name = "FriHours")
    private Integer friHours;
    @Column(name = "SatHours")
    private Integer satHours;
    @Column(name = "SunHours")
    private Integer sunHours;
    @Column(name = "IsOnWhenDark")
    private Boolean isOnWhenDark;
    @Size(max = 45)
    @Column(name = "name")
    private String name;

    public Schedule() {
    }

    public Schedule(Integer idschedule) {
        this.idschedule = idschedule;
    }

    public Integer getIdschedule() {
        return idschedule;
    }

    public void setIdschedule(Integer idschedule) {
        this.idschedule = idschedule;
    }

    public Integer getClientidClient() {
        return clientidClient;
    }

    public void setClientidClient(Integer clientidClient) {
        this.clientidClient = clientidClient;
    }

    public Integer getMonHours() {
        return monHours;
    }

    public void setMonHours(Integer monHours) {
        this.monHours = monHours;
    }

    public Integer getTuesHours() {
        return tuesHours;
    }

    public void setTuesHours(Integer tuesHours) {
        this.tuesHours = tuesHours;
    }

    public Integer getWedHours() {
        return wedHours;
    }

    public void setWedHours(Integer wedHours) {
        this.wedHours = wedHours;
    }

    public Integer getThHours() {
        return thHours;
    }

    public void setThHours(Integer thHours) {
        this.thHours = thHours;
    }

    public Integer getFriHours() {
        return friHours;
    }

    public void setFriHours(Integer friHours) {
        this.friHours = friHours;
    }

    public Integer getSatHours() {
        return satHours;
    }

    public void setSatHours(Integer satHours) {
        this.satHours = satHours;
    }

    public Integer getSunHours() {
        return sunHours;
    }

    public void setSunHours(Integer sunHours) {
        this.sunHours = sunHours;
    }

    public Boolean getIsOnWhenDark() {
        return isOnWhenDark;
    }

    public void setIsOnWhenDark(Boolean isOnWhenDark) {
        this.isOnWhenDark = isOnWhenDark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idschedule != null ? idschedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.idschedule == null && other.idschedule != null) || (this.idschedule != null && !this.idschedule.equals(other.idschedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Schedule[ idschedule=" + idschedule + " ]";
    }
    
}
