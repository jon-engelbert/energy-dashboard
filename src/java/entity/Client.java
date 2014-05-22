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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name"),
    @NamedQuery(name = "Client.findByPercentMaxLightSetting", query = "SELECT c FROM Client c WHERE c.percentMaxLightSetting = :percentMaxLightSetting"),
    @NamedQuery(name = "Client.findByPercentMaxLightOriginal", query = "SELECT c FROM Client c WHERE c.percentMaxLightOriginal = :percentMaxLightOriginal"),
    @NamedQuery(name = "Client.findByOrigSetpointCoolOcc", query = "SELECT c FROM Client c WHERE c.origSetpointCoolOcc = :origSetpointCoolOcc"),
    @NamedQuery(name = "Client.findByOrigSetpointCoolUnocc", query = "SELECT c FROM Client c WHERE c.origSetpointCoolUnocc = :origSetpointCoolUnocc"),
    @NamedQuery(name = "Client.findByOrigSetpointHeatOcc", query = "SELECT c FROM Client c WHERE c.origSetpointHeatOcc = :origSetpointHeatOcc"),
    @NamedQuery(name = "Client.findByOrigSetpointHeatUnocc", query = "SELECT c FROM Client c WHERE c.origSetpointHeatUnocc = :origSetpointHeatUnocc"),
    @NamedQuery(name = "Client.findBySetpointCoolOcc", query = "SELECT c FROM Client c WHERE c.setpointCoolOcc = :setpointCoolOcc"),
    @NamedQuery(name = "Client.findBySetpointHeatOcc", query = "SELECT c FROM Client c WHERE c.setpointHeatOcc = :setpointHeatOcc"),
    @NamedQuery(name = "Client.findBySetpointHeatUnocc", query = "SELECT c FROM Client c WHERE c.setpointHeatUnocc = :setpointHeatUnocc"),
    @NamedQuery(name = "Client.findBySetpointCoolUnocc", query = "SELECT c FROM Client c WHERE c.setpointCoolUnocc = :setpointCoolUnocc")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "idClient")
    private Integer idClient;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Column(name = "PercentMaxLightSetting")
    private Integer percentMaxLightSetting;
    @Column(name = "PercentMaxLightOriginal")
    private Integer percentMaxLightOriginal;
    @Column(name = "origSetpointCoolOcc")
    private Integer origSetpointCoolOcc;
    @Column(name = "origSetpointCoolUnocc")
    private Integer origSetpointCoolUnocc;
    @Column(name = "origSetpointHeatOcc")
    private Integer origSetpointHeatOcc;
    @Column(name = "origSetpointHeatUnocc")
    private Integer origSetpointHeatUnocc;
    @Column(name = "setpointCoolOcc")
    private Integer setpointCoolOcc;
    @Column(name = "setpointHeatOcc")
    private Integer setpointHeatOcc;
    @Column(name = "setpointHeatUnocc")
    private Integer setpointHeatUnocc;
    @Column(name = "setpointCoolUnocc")
    private Integer setpointCoolUnocc;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPercentMaxLightSetting() {
        return percentMaxLightSetting;
    }

    public void setPercentMaxLightSetting(Integer percentMaxLightSetting) {
        this.percentMaxLightSetting = percentMaxLightSetting;
    }

    public Integer getPercentMaxLightOriginal() {
        return percentMaxLightOriginal;
    }

    public void setPercentMaxLightOriginal(Integer percentMaxLightOriginal) {
        this.percentMaxLightOriginal = percentMaxLightOriginal;
    }

    public Integer getOrigSetpointCoolOcc() {
        return origSetpointCoolOcc;
    }

    public void setOrigSetpointCoolOcc(Integer origSetpointCoolOcc) {
        this.origSetpointCoolOcc = origSetpointCoolOcc;
    }

    public Integer getOrigSetpointCoolUnocc() {
        return origSetpointCoolUnocc;
    }

    public void setOrigSetpointCoolUnocc(Integer origSetpointCoolUnocc) {
        this.origSetpointCoolUnocc = origSetpointCoolUnocc;
    }

    public Integer getOrigSetpointHeatOcc() {
        return origSetpointHeatOcc;
    }

    public void setOrigSetpointHeatOcc(Integer origSetpointHeatOcc) {
        this.origSetpointHeatOcc = origSetpointHeatOcc;
    }

    public Integer getOrigSetpointHeatUnocc() {
        return origSetpointHeatUnocc;
    }

    public void setOrigSetpointHeatUnocc(Integer origSetpointHeatUnocc) {
        this.origSetpointHeatUnocc = origSetpointHeatUnocc;
    }

    public Integer getSetpointCoolOcc() {
        return setpointCoolOcc;
    }

    public void setSetpointCoolOcc(Integer setpointCoolOcc) {
        this.setpointCoolOcc = setpointCoolOcc;
    }

    public Integer getSetpointHeatOcc() {
        return setpointHeatOcc;
    }

    public void setSetpointHeatOcc(Integer setpointHeatOcc) {
        this.setpointHeatOcc = setpointHeatOcc;
    }

    public Integer getSetpointHeatUnocc() {
        return setpointHeatUnocc;
    }

    public void setSetpointHeatUnocc(Integer setpointHeatUnocc) {
        this.setpointHeatUnocc = setpointHeatUnocc;
    }

    public Integer getSetpointCoolUnocc() {
        return setpointCoolUnocc;
    }

    public void setSetpointCoolUnocc(Integer setpointCoolUnocc) {
        this.setpointCoolUnocc = setpointCoolUnocc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Client[ idClient=" + idClient + " ]";
    }
    
}
