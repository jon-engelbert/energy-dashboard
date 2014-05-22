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
@Table(name = "zones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zones.findAll", query = "SELECT z FROM Zones z"),
    @NamedQuery(name = "Zones.findByIdzones", query = "SELECT z FROM Zones z WHERE z.idzones = :idzones"),
    @NamedQuery(name = "Zones.findByName", query = "SELECT z FROM Zones z WHERE z.name = :name"),
    @NamedQuery(name = "Zones.findBySitesId", query = "SELECT z FROM Zones z WHERE z.sitesId = :sitesId"),
    @NamedQuery(name = "Zones.findByNPeople", query = "SELECT z FROM Zones z WHERE z.nPeople = :nPeople"),
    @NamedQuery(name = "Zones.findBySquareFeet", query = "SELECT z FROM Zones z WHERE z.squareFeet = :squareFeet"),
    @NamedQuery(name = "Zones.findByParentIdzones", query = "SELECT z FROM Zones z WHERE z.parentIdzones = :parentIdzones")})
public class Zones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idzones")
    private Integer idzones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sites_id")
    private int sitesId;
    @Column(name = "nPeople")
    private Integer nPeople;
    @Column(name = "squareFeet")
    private Integer squareFeet;
    @Column(name = "parent_idzones")
    private Integer parentIdzones;

    public Zones() {
    }

    public Zones(Integer idzones) {
        this.idzones = idzones;
    }

    public Zones(Integer idzones, String name, int sitesId) {
        this.idzones = idzones;
        this.name = name;
        this.sitesId = sitesId;
    }

    public Integer getIdzones() {
        return idzones;
    }

    public void setIdzones(Integer idzones) {
        this.idzones = idzones;
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

    public Integer getNPeople() {
        return nPeople;
    }

    public void setNPeople(Integer nPeople) {
        this.nPeople = nPeople;
    }

    public Integer getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(Integer squareFeet) {
        this.squareFeet = squareFeet;
    }

    public Integer getParentIdzones() {
        return parentIdzones;
    }

    public void setParentIdzones(Integer parentIdzones) {
        this.parentIdzones = parentIdzones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idzones != null ? idzones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zones)) {
            return false;
        }
        Zones other = (Zones) object;
        if ((this.idzones == null && other.idzones != null) || (this.idzones != null && !this.idzones.equals(other.idzones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Zones[ idzones=" + idzones + " ]";
    }
    
}
