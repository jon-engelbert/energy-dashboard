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
@Table(name = "multicircuitmeter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multicircuitmeter.findAll", query = "SELECT m FROM Multicircuitmeter m"),
    @NamedQuery(name = "Multicircuitmeter.findByIdmultiCircuitMeter", query = "SELECT m FROM Multicircuitmeter m WHERE m.idmultiCircuitMeter = :idmultiCircuitMeter"),
    @NamedQuery(name = "Multicircuitmeter.findByMACaddress", query = "SELECT m FROM Multicircuitmeter m WHERE m.mACaddress = :mACaddress"),
    @NamedQuery(name = "Multicircuitmeter.findBySitesId", query = "SELECT m FROM Multicircuitmeter m WHERE m.sitesId = :sitesId")})
public class Multicircuitmeter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idmultiCircuitMeter")
    private Integer idmultiCircuitMeter;
    @Size(max = 45)
    @Column(name = "MACaddress")
    private String mACaddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sites_id")
    private int sitesId;

    public Multicircuitmeter() {
    }

    public Multicircuitmeter(Integer idmultiCircuitMeter) {
        this.idmultiCircuitMeter = idmultiCircuitMeter;
    }

    public Multicircuitmeter(Integer idmultiCircuitMeter, int sitesId) {
        this.idmultiCircuitMeter = idmultiCircuitMeter;
        this.sitesId = sitesId;
    }

    public Integer getIdmultiCircuitMeter() {
        return idmultiCircuitMeter;
    }

    public void setIdmultiCircuitMeter(Integer idmultiCircuitMeter) {
        this.idmultiCircuitMeter = idmultiCircuitMeter;
    }

    public String getMACaddress() {
        return mACaddress;
    }

    public void setMACaddress(String mACaddress) {
        this.mACaddress = mACaddress;
    }

    public int getSitesId() {
        return sitesId;
    }

    public void setSitesId(int sitesId) {
        this.sitesId = sitesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmultiCircuitMeter != null ? idmultiCircuitMeter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multicircuitmeter)) {
            return false;
        }
        Multicircuitmeter other = (Multicircuitmeter) object;
        if ((this.idmultiCircuitMeter == null && other.idmultiCircuitMeter != null) || (this.idmultiCircuitMeter != null && !this.idmultiCircuitMeter.equals(other.idmultiCircuitMeter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Multicircuitmeter[ idmultiCircuitMeter=" + idmultiCircuitMeter + " ]";
    }
    
}
