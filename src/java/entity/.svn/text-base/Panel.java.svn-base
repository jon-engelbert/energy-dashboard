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
@Table(name = "panel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Panel.findAll", query = "SELECT p FROM Panel p"),
    @NamedQuery(name = "Panel.findByIdPanel", query = "SELECT p FROM Panel p WHERE p.idPanel = :idPanel"),
    @NamedQuery(name = "Panel.findByName", query = "SELECT p FROM Panel p WHERE p.name = :name"),
    @NamedQuery(name = "Panel.findBySitesId", query = "SELECT p FROM Panel p WHERE p.sitesId = :sitesId"),
    @NamedQuery(name = "Panel.findByParentCircuitid", query = "SELECT p FROM Panel p WHERE p.parentCircuitid = :parentCircuitid"),
    @NamedQuery(name = "Panel.findByParentidPanel", query = "SELECT p FROM Panel p WHERE p.parentidPanel = :parentidPanel")})
public class Panel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idPanel")
    private Integer idPanel;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sites_id")
    private int sitesId;
    @Column(name = "parentCircuit_id")
    private Integer parentCircuitid;
    @Column(name = "parent_idPanel")
    private Integer parentidPanel;

    public Panel() {
    }

    public Panel(Integer idPanel) {
        this.idPanel = idPanel;
    }

    public Panel(Integer idPanel, int sitesId) {
        this.idPanel = idPanel;
        this.sitesId = sitesId;
    }

    public Integer getIdPanel() {
        return idPanel;
    }

    public void setIdPanel(Integer idPanel) {
        this.idPanel = idPanel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSitesId() {
        return sitesId;
    }

    public void setSitesId(int sitesId) {
        this.sitesId = sitesId;
    }

    public Integer getParentCircuitid() {
        return parentCircuitid;
    }

    public void setParentCircuitid(Integer parentCircuitid) {
        this.parentCircuitid = parentCircuitid;
    }

    public Integer getParentidPanel() {
        return parentidPanel;
    }

    public void setParentidPanel(Integer parentidPanel) {
        this.parentidPanel = parentidPanel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPanel != null ? idPanel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Panel)) {
            return false;
        }
        Panel other = (Panel) object;
        if ((this.idPanel == null && other.idPanel != null) || (this.idPanel != null && !this.idPanel.equals(other.idPanel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Panel[ idPanel=" + idPanel + " ]";
    }
    
}
