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
@Table(name = "endusecategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endusecategory.findAll", query = "SELECT e FROM Endusecategory e"),
    @NamedQuery(name = "Endusecategory.findByIdEndUseCategory", query = "SELECT e FROM Endusecategory e WHERE e.idEndUseCategory = :idEndUseCategory"),
    @NamedQuery(name = "Endusecategory.findByName", query = "SELECT e FROM Endusecategory e WHERE e.name = :name"),
    @NamedQuery(name = "Endusecategory.findByParentCategory", query = "SELECT e FROM Endusecategory e WHERE e.parentCategory = :parentCategory")})
public class Endusecategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "idEndUseCategory")
    private Integer idEndUseCategory;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "parentCategory")
    private Integer parentCategory;

    public Endusecategory() {
    }

    public Endusecategory(Integer idEndUseCategory) {
        this.idEndUseCategory = idEndUseCategory;
    }

    public Integer getIdEndUseCategory() {
        return idEndUseCategory;
    }

    public void setIdEndUseCategory(Integer idEndUseCategory) {
        this.idEndUseCategory = idEndUseCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Integer parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndUseCategory != null ? idEndUseCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endusecategory)) {
            return false;
        }
        Endusecategory other = (Endusecategory) object;
        if ((this.idEndUseCategory == null && other.idEndUseCategory != null) || (this.idEndUseCategory != null && !this.idEndUseCategory.equals(other.idEndUseCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Endusecategory[ idEndUseCategory=" + idEndUseCategory + " ]";
    }
    
}
