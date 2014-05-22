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
@Table(name = "circuit_has_endusecategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CircuitHasEndusecategory.findAll", query = "SELECT c FROM CircuitHasEndusecategory c"),
    @NamedQuery(name = "CircuitHasEndusecategory.findByCircuitidCircuit", query = "SELECT c FROM CircuitHasEndusecategory c WHERE c.circuitHasEndusecategoryPK.circuitidCircuit = :circuitidCircuit"),
    @NamedQuery(name = "CircuitHasEndusecategory.findByEndUseCategoryidEndUseCategory", query = "SELECT c FROM CircuitHasEndusecategory c WHERE c.circuitHasEndusecategoryPK.endUseCategoryidEndUseCategory = :endUseCategoryidEndUseCategory"),
    @NamedQuery(name = "CircuitHasEndusecategory.findByPercent", query = "SELECT c FROM CircuitHasEndusecategory c WHERE c.percent = :percent")})
public class CircuitHasEndusecategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CircuitHasEndusecategoryPK circuitHasEndusecategoryPK;
    @Column(name = "percent")
    private Integer percent;

    public CircuitHasEndusecategory() {
    }

    public CircuitHasEndusecategory(CircuitHasEndusecategoryPK circuitHasEndusecategoryPK) {
        this.circuitHasEndusecategoryPK = circuitHasEndusecategoryPK;
    }

    public CircuitHasEndusecategory(int circuitidCircuit, int endUseCategoryidEndUseCategory) {
        this.circuitHasEndusecategoryPK = new CircuitHasEndusecategoryPK(circuitidCircuit, endUseCategoryidEndUseCategory);
    }

    public CircuitHasEndusecategoryPK getCircuitHasEndusecategoryPK() {
        return circuitHasEndusecategoryPK;
    }

    public void setCircuitHasEndusecategoryPK(CircuitHasEndusecategoryPK circuitHasEndusecategoryPK) {
        this.circuitHasEndusecategoryPK = circuitHasEndusecategoryPK;
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
        hash += (circuitHasEndusecategoryPK != null ? circuitHasEndusecategoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CircuitHasEndusecategory)) {
            return false;
        }
        CircuitHasEndusecategory other = (CircuitHasEndusecategory) object;
        if ((this.circuitHasEndusecategoryPK == null && other.circuitHasEndusecategoryPK != null) || (this.circuitHasEndusecategoryPK != null && !this.circuitHasEndusecategoryPK.equals(other.circuitHasEndusecategoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CircuitHasEndusecategory[ circuitHasEndusecategoryPK=" + circuitHasEndusecategoryPK + " ]";
    }
    
}
