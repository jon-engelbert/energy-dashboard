/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Engel-less
 */
@Entity
@Table(name = "circuit_has_zones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CircuitHasZones.findAll", query = "SELECT c FROM CircuitHasZones c"),
    @NamedQuery(name = "CircuitHasZones.findByCircuitidCircuit", query = "SELECT c FROM CircuitHasZones c WHERE c.circuitHasZonesPK.circuitidCircuit = :circuitidCircuit"),
    @NamedQuery(name = "CircuitHasZones.findByZonesIdzones", query = "SELECT c FROM CircuitHasZones c WHERE c.circuitHasZonesPK.zonesIdzones = :zonesIdzones"),
    @NamedQuery(name = "CircuitHasZones.findByPercent", query = "SELECT c FROM CircuitHasZones c WHERE c.percent = :percent")})
public class CircuitHasZones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CircuitHasZonesPK circuitHasZonesPK;
    @Column(name = "percent")
    private Integer percent;

    public CircuitHasZones() {
    }

    public CircuitHasZones(CircuitHasZonesPK circuitHasZonesPK) {
        this.circuitHasZonesPK = circuitHasZonesPK;
    }

    public CircuitHasZones(int circuitidCircuit, int zonesIdzones) {
        this.circuitHasZonesPK = new CircuitHasZonesPK(circuitidCircuit, zonesIdzones);
    }

    public CircuitHasZonesPK getCircuitHasZonesPK() {
        return circuitHasZonesPK;
    }

    public void setCircuitHasZonesPK(CircuitHasZonesPK circuitHasZonesPK) {
        this.circuitHasZonesPK = circuitHasZonesPK;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (circuitHasZonesPK != null ? circuitHasZonesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CircuitHasZones)) {
            return false;
        }
        CircuitHasZones other = (CircuitHasZones) object;
        if ((this.circuitHasZonesPK == null && other.circuitHasZonesPK != null) || (this.circuitHasZonesPK != null && !this.circuitHasZonesPK.equals(other.circuitHasZonesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CircuitHasZones[ circuitHasZonesPK=" + circuitHasZonesPK + " ]";
    }
    
}
