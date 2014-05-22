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
@Table(name = "circuit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Circuit.findAll", query = "SELECT c FROM Circuit c"),
    @NamedQuery(name = "Circuit.findByIdCircuit", query = "SELECT c FROM Circuit c WHERE c.idCircuit = :idCircuit"),
    @NamedQuery(name = "Circuit.findByName", query = "SELECT c FROM Circuit c WHERE c.name = :name"),
    @NamedQuery(name = "Circuit.findByEndUseDescription", query = "SELECT c FROM Circuit c WHERE c.endUseDescription = :endUseDescription"),
    @NamedQuery(name = "Circuit.findByIsInput", query = "SELECT c FROM Circuit c WHERE c.isInput = :isInput"),
    @NamedQuery(name = "Circuit.findByPhase", query = "SELECT c FROM Circuit c WHERE c.phase = :phase"),
    @NamedQuery(name = "Circuit.findByPanelidPanel", query = "SELECT c FROM Circuit c WHERE c.panelidPanel = :panelidPanel"),
    @NamedQuery(name = "Circuit.findByMultiCircuitMeteridmultiCircuitMeter", query = "SELECT c FROM Circuit c WHERE c.multiCircuitMeteridmultiCircuitMeter = :multiCircuitMeteridmultiCircuitMeter"),
    @NamedQuery(name = "Circuit.findByMeterBranchNo", query = "SELECT c FROM Circuit c WHERE c.meterBranchNo = :meterBranchNo"),
    @NamedQuery(name = "Circuit.findByZonesIdzones", query = "SELECT c FROM Circuit c WHERE c.zonesIdzones = :zonesIdzones"),
    @NamedQuery(name = "Circuit.findByEndusecategoryidEndUseCategory", query = "SELECT c FROM Circuit c WHERE c.endusecategoryidEndUseCategory = :endusecategoryidEndUseCategory"),
    @NamedQuery(name = "Circuit.findByEquipmentidEquipment", query = "SELECT c FROM Circuit c WHERE c.equipmentidEquipment = :equipmentidEquipment"),
    @NamedQuery(name = "Circuit.findByIsMultipleZones", query = "SELECT c FROM Circuit c WHERE c.isMultipleZones = :isMultipleZones"),
    @NamedQuery(name = "Circuit.findByIsMultipleEndUses", query = "SELECT c FROM Circuit c WHERE c.isMultipleEndUses = :isMultipleEndUses"),
    @NamedQuery(name = "Circuit.findByIsMultipleEquipments", query = "SELECT c FROM Circuit c WHERE c.isMultipleEquipments = :isMultipleEquipments")})
public class Circuit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idCircuit")
    private Integer idCircuit;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "EndUseDescription")
    private String endUseDescription;
    @Column(name = "IsInput")
    private Boolean isInput;
    @Column(name = "Phase")
    private Integer phase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Panel_idPanel")
    private int panelidPanel;
    @Column(name = "multiCircuitMeter_idmultiCircuitMeter")
    private Integer multiCircuitMeteridmultiCircuitMeter;
    @Column(name = "meterBranchNo")
    private Integer meterBranchNo;
    @Column(name = "zones_idzones")
    private Integer zonesIdzones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endusecategory_idEndUseCategory")
    private int endusecategoryidEndUseCategory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "equipment_idEquipment")
    private int equipmentidEquipment;
    @Column(name = "isMultipleZones")
    private Boolean isMultipleZones;
    @Column(name = "isMultipleEndUses")
    private Boolean isMultipleEndUses;
    @Column(name = "isMultipleEquipments")
    private Boolean isMultipleEquipments;

    public Circuit() {
    }

    public Circuit(Integer idCircuit) {
        this.idCircuit = idCircuit;
    }

    public Circuit(Integer idCircuit, int panelidPanel, int endusecategoryidEndUseCategory, int equipmentidEquipment) {
        this.idCircuit = idCircuit;
        this.panelidPanel = panelidPanel;
        this.endusecategoryidEndUseCategory = endusecategoryidEndUseCategory;
        this.equipmentidEquipment = equipmentidEquipment;
    }

    public Integer getIdCircuit() {
        return idCircuit;
    }

    public void setIdCircuit(Integer idCircuit) {
        this.idCircuit = idCircuit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndUseDescription() {
        return endUseDescription;
    }

    public void setEndUseDescription(String endUseDescription) {
        this.endUseDescription = endUseDescription;
    }

    public Boolean getIsInput() {
        return isInput;
    }

    public void setIsInput(Boolean isInput) {
        this.isInput = isInput;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public int getPanelidPanel() {
        return panelidPanel;
    }

    public void setPanelidPanel(int panelidPanel) {
        this.panelidPanel = panelidPanel;
    }

    public Integer getMultiCircuitMeteridmultiCircuitMeter() {
        return multiCircuitMeteridmultiCircuitMeter;
    }

    public void setMultiCircuitMeteridmultiCircuitMeter(Integer multiCircuitMeteridmultiCircuitMeter) {
        this.multiCircuitMeteridmultiCircuitMeter = multiCircuitMeteridmultiCircuitMeter;
    }

    public Integer getMeterBranchNo() {
        return meterBranchNo;
    }

    public void setMeterBranchNo(Integer meterBranchNo) {
        this.meterBranchNo = meterBranchNo;
    }

    public Integer getZonesIdzones() {
        return zonesIdzones;
    }

    public void setZonesIdzones(Integer zonesIdzones) {
        this.zonesIdzones = zonesIdzones;
    }

    public int getEndusecategoryidEndUseCategory() {
        return endusecategoryidEndUseCategory;
    }

    public void setEndusecategoryidEndUseCategory(int endusecategoryidEndUseCategory) {
        this.endusecategoryidEndUseCategory = endusecategoryidEndUseCategory;
    }

    public int getEquipmentidEquipment() {
        return equipmentidEquipment;
    }

    public void setEquipmentidEquipment(int equipmentidEquipment) {
        this.equipmentidEquipment = equipmentidEquipment;
    }

    public Boolean getIsMultipleZones() {
        return isMultipleZones;
    }

    public void setIsMultipleZones(Boolean isMultipleZones) {
        this.isMultipleZones = isMultipleZones;
    }

    public Boolean getIsMultipleEndUses() {
        return isMultipleEndUses;
    }

    public void setIsMultipleEndUses(Boolean isMultipleEndUses) {
        this.isMultipleEndUses = isMultipleEndUses;
    }

    public Boolean getIsMultipleEquipments() {
        return isMultipleEquipments;
    }

    public void setIsMultipleEquipments(Boolean isMultipleEquipments) {
        this.isMultipleEquipments = isMultipleEquipments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCircuit != null ? idCircuit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Circuit)) {
            return false;
        }
        Circuit other = (Circuit) object;
        if ((this.idCircuit == null && other.idCircuit != null) || (this.idCircuit != null && !this.idCircuit.equals(other.idCircuit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Circuit[ idCircuit=" + idCircuit + " ]";
    }
    
}
