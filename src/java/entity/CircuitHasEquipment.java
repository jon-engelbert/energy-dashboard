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
@Table(name = "circuit_has_equipment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CircuitHasEquipment.findAll", query = "SELECT c FROM CircuitHasEquipment c"),
    @NamedQuery(name = "CircuitHasEquipment.findByCircuitidCircuit", query = "SELECT c FROM CircuitHasEquipment c WHERE c.circuitHasEquipmentPK.circuitidCircuit = :circuitidCircuit"),
    @NamedQuery(name = "CircuitHasEquipment.findByEquipmentidEquipment", query = "SELECT c FROM CircuitHasEquipment c WHERE c.circuitHasEquipmentPK.equipmentidEquipment = :equipmentidEquipment"),
    @NamedQuery(name = "CircuitHasEquipment.findByPercent", query = "SELECT c FROM CircuitHasEquipment c WHERE c.percent = :percent")})
public class CircuitHasEquipment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CircuitHasEquipmentPK circuitHasEquipmentPK;
    @Column(name = "percent")
    private Integer percent;

    public CircuitHasEquipment() {
    }

    public CircuitHasEquipment(CircuitHasEquipmentPK circuitHasEquipmentPK) {
        this.circuitHasEquipmentPK = circuitHasEquipmentPK;
    }

    public CircuitHasEquipment(int circuitidCircuit, int equipmentidEquipment) {
        this.circuitHasEquipmentPK = new CircuitHasEquipmentPK(circuitidCircuit, equipmentidEquipment);
    }

    public CircuitHasEquipmentPK getCircuitHasEquipmentPK() {
        return circuitHasEquipmentPK;
    }

    public void setCircuitHasEquipmentPK(CircuitHasEquipmentPK circuitHasEquipmentPK) {
        this.circuitHasEquipmentPK = circuitHasEquipmentPK;
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
        hash += (circuitHasEquipmentPK != null ? circuitHasEquipmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CircuitHasEquipment)) {
            return false;
        }
        CircuitHasEquipment other = (CircuitHasEquipment) object;
        if ((this.circuitHasEquipmentPK == null && other.circuitHasEquipmentPK != null) || (this.circuitHasEquipmentPK != null && !this.circuitHasEquipmentPK.equals(other.circuitHasEquipmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CircuitHasEquipment[ circuitHasEquipmentPK=" + circuitHasEquipmentPK + " ]";
    }
    
}
