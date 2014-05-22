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
public class CircuitHasEndusecategoryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Circuit_idCircuit")
    private int circuitidCircuit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndUseCategory_idEndUseCategory")
    private int endUseCategoryidEndUseCategory;

    public CircuitHasEndusecategoryPK() {
    }

    public CircuitHasEndusecategoryPK(int circuitidCircuit, int endUseCategoryidEndUseCategory) {
        this.circuitidCircuit = circuitidCircuit;
        this.endUseCategoryidEndUseCategory = endUseCategoryidEndUseCategory;
    }

    public int getCircuitidCircuit() {
        return circuitidCircuit;
    }

    public void setCircuitidCircuit(int circuitidCircuit) {
        this.circuitidCircuit = circuitidCircuit;
    }

    public int getEndUseCategoryidEndUseCategory() {
        return endUseCategoryidEndUseCategory;
    }

    public void setEndUseCategoryidEndUseCategory(int endUseCategoryidEndUseCategory) {
        this.endUseCategoryidEndUseCategory = endUseCategoryidEndUseCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) circuitidCircuit;
        hash += (int) endUseCategoryidEndUseCategory;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CircuitHasEndusecategoryPK)) {
            return false;
        }
        CircuitHasEndusecategoryPK other = (CircuitHasEndusecategoryPK) object;
        if (this.circuitidCircuit != other.circuitidCircuit) {
            return false;
        }
        if (this.endUseCategoryidEndUseCategory != other.endUseCategoryidEndUseCategory) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CircuitHasEndusecategoryPK[ circuitidCircuit=" + circuitidCircuit + ", endUseCategoryidEndUseCategory=" + endUseCategoryidEndUseCategory + " ]";
    }
    
}
