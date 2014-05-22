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
@Table(name = "realtimedata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Realtimedata.findAll", query = "SELECT r FROM Realtimedata r"),
    @NamedQuery(name = "Realtimedata.findByIdrealTimeData", query = "SELECT r FROM Realtimedata r WHERE r.idrealTimeData = :idrealTimeData"),
    @NamedQuery(name = "Realtimedata.findByTruePower", query = "SELECT r FROM Realtimedata r WHERE r.truePower = :truePower"),
    @NamedQuery(name = "Realtimedata.findByApparentPower", query = "SELECT r FROM Realtimedata r WHERE r.apparentPower = :apparentPower"),
    @NamedQuery(name = "Realtimedata.findByTimestamp", query = "SELECT r FROM Realtimedata r WHERE r.timestamp = :timestamp"),
    @NamedQuery(name = "Realtimedata.findByEnergy", query = "SELECT r FROM Realtimedata r WHERE r.energy = :energy"),
    @NamedQuery(name = "Realtimedata.findByApparentEnergy", query = "SELECT r FROM Realtimedata r WHERE r.apparentEnergy = :apparentEnergy"),
    @NamedQuery(name = "Realtimedata.findByCircuitidCircuit", query = "SELECT r FROM Realtimedata r WHERE r.circuitidCircuit = :circuitidCircuit")})
public class Realtimedata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idrealTimeData")
    private Integer idrealTimeData;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "truePower")
    private Float truePower;
    @Column(name = "apparentPower")
    private Float apparentPower;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "Energy")
    private Float energy;
    @Column(name = "apparentEnergy")
    private Float apparentEnergy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Circuit_idCircuit")
    private int circuitidCircuit;

    public Realtimedata() {
    }

    public Realtimedata(Integer idrealTimeData) {
        this.idrealTimeData = idrealTimeData;
    }

    public Realtimedata(Integer idrealTimeData, int circuitidCircuit) {
        this.idrealTimeData = idrealTimeData;
        this.circuitidCircuit = circuitidCircuit;
    }

    public Integer getIdrealTimeData() {
        return idrealTimeData;
    }

    public void setIdrealTimeData(Integer idrealTimeData) {
        this.idrealTimeData = idrealTimeData;
    }

    public Float getTruePower() {
        return truePower;
    }

    public void setTruePower(Float truePower) {
        this.truePower = truePower;
    }

    public Float getApparentPower() {
        return apparentPower;
    }

    public void setApparentPower(Float apparentPower) {
        this.apparentPower = apparentPower;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Float getEnergy() {
        return energy;
    }

    public void setEnergy(Float energy) {
        this.energy = energy;
    }

    public Float getApparentEnergy() {
        return apparentEnergy;
    }

    public void setApparentEnergy(Float apparentEnergy) {
        this.apparentEnergy = apparentEnergy;
    }

    public int getCircuitidCircuit() {
        return circuitidCircuit;
    }

    public void setCircuitidCircuit(int circuitidCircuit) {
        this.circuitidCircuit = circuitidCircuit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrealTimeData != null ? idrealTimeData.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Realtimedata)) {
            return false;
        }
        Realtimedata other = (Realtimedata) object;
        if ((this.idrealTimeData == null && other.idrealTimeData != null) || (this.idrealTimeData != null && !this.idrealTimeData.equals(other.idrealTimeData))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Realtimedata[ idrealTimeData=" + idrealTimeData + " ]";
    }
    
}
