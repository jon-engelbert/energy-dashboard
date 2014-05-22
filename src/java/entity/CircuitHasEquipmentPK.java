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
public class CircuitHasEquipmentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Circuit_idCircuit")
    private int circuitidCircuit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Equipment_idEquipment")
    private int equipmentidEquipment;

    public CircuitHasEquipmentPK() {
    }

    public CircuitHasEquipmentPK(int circuitidCircuit, int equipmentidEquipment) {
        this.circuitidCircuit = circuitidCircuit;
        this.equipmentidEquipment = equipmentidEquipment;
    }

    public int getCircuitidCircuit() {
        return circuitidCircuit;
    }

    public void setCircuitidCircuit(int circuitidCircuit) {
        this.circuitidCircuit = circuitidCircuit;
    }

    public int getEquipmentidEquipment() {
        return equipmentidEquipment;
    }

    public void setEquipmentidEquipment(int equipmentidEquipment) {
        this.equipmentidEquipment = equipmentidEquipment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) circuitidCircuit;
        hash += (int) equipmentidEquipment;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CircuitHasEquipmentPK)) {
            return false;
        }
        CircuitHasEquipmentPK other = (CircuitHasEquipmentPK) object;
        if (this.circuitidCircuit != other.circuitidCircuit) {
            return false;
        }
        if (this.equipmentidEquipment != other.equipmentidEquipment) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CircuitHasEquipmentPK[ circuitidCircuit=" + circuitidCircuit + ", equipmentidEquipment=" + equipmentidEquipment + " ]";
    }
    
}
