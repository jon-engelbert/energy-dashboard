/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Engel-less
 */
@Embeddable
public class CircuitHasZonesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Circuit_idCircuit")
    private int circuitidCircuit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zones_idzones")
    private int zonesIdzones;

    public CircuitHasZonesPK() {
    }

    public CircuitHasZonesPK(int circuitidCircuit, int zonesIdzones) {
        this.circuitidCircuit = circuitidCircuit;
        this.zonesIdzones = zonesIdzones;
    }

    public int getCircuitidCircuit() {
        return circuitidCircuit;
    }

    public void setCircuitidCircuit(int circuitidCircuit) {
        this.circuitidCircuit = circuitidCircuit;
    }

    public int getZonesIdzones() {
        return zonesIdzones;
    }

    public void setZonesIdzones(int zonesIdzones) {
        this.zonesIdzones = zonesIdzones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) circuitidCircuit;
        hash += (int) zonesIdzones;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CircuitHasZonesPK)) {
            return false;
        }
        CircuitHasZonesPK other = (CircuitHasZonesPK) object;
        if (this.circuitidCircuit != other.circuitidCircuit) {
            return false;
        }
        if (this.zonesIdzones != other.zonesIdzones) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CircuitHasZonesPK[ circuitidCircuit=" + circuitidCircuit + ", zonesIdzones=" + zonesIdzones + " ]";
    }
    
}
