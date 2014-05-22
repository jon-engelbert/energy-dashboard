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
@Table(name = "meters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meters.findAll", query = "SELECT m FROM Meters m"),
    @NamedQuery(name = "Meters.findById", query = "SELECT m FROM Meters m WHERE m.id = :id"),
    @NamedQuery(name = "Meters.findByAccountNum", query = "SELECT m FROM Meters m WHERE m.accountNum = :accountNum"),
    @NamedQuery(name = "Meters.findByProviderName", query = "SELECT m FROM Meters m WHERE m.providerName = :providerName"),
    @NamedQuery(name = "Meters.findByFuelType", query = "SELECT m FROM Meters m WHERE m.fuelType = :fuelType"),
    @NamedQuery(name = "Meters.findByVendorID", query = "SELECT m FROM Meters m WHERE m.vendorID = :vendorID"),
    @NamedQuery(name = "Meters.findByTextID", query = "SELECT m FROM Meters m WHERE m.textID = :textID"),
    @NamedQuery(name = "Meters.findBySitesId", query = "SELECT m FROM Meters m WHERE m.sitesId = :sitesId")})
public class Meters implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "accountNum")
    private String accountNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "providerName")
    private String providerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fuelType")
    private String fuelType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vendorID")
    private String vendorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "textID")
    private String textID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sites_id")
    private int sitesId;

    public Meters() {
    }

    public Meters(Integer id) {
        this.id = id;
    }

    public Meters(Integer id, String accountNum, String providerName, String fuelType, String vendorID, String textID, int sitesId) {
        this.id = id;
        this.accountNum = accountNum;
        this.providerName = providerName;
        this.fuelType = fuelType;
        this.vendorID = vendorID;
        this.textID = textID;
        this.sitesId = sitesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getTextID() {
        return textID;
    }

    public void setTextID(String textID) {
        this.textID = textID;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meters)) {
            return false;
        }
        Meters other = (Meters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Meters[ id=" + id + " ]";
    }
    
}
