/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "v_user_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VUserRole.findAll", query = "SELECT v FROM VUserRole v"),
    @NamedQuery(name = "VUserRole.findByUserName", query = "SELECT v FROM VUserRole v WHERE v.userName = :userName"),
    @NamedQuery(name = "VUserRole.findByUserPassword", query = "SELECT v FROM VUserRole v WHERE v.userPassword = :userPassword"),
    @NamedQuery(name = "VUserRole.findByRoleName", query = "SELECT v FROM VUserRole v WHERE v.roleName = :roleName"),
    @NamedQuery(name = "VUserRole.findByUserID", query = "SELECT v FROM VUserRole v WHERE v.userID = :userID")})
public class VUserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user_name")
    private String userName;
    @Size(max = 45)
    @Column(name = "user_password")
    private String userPassword;
    @Size(max = 45)
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "userID")
    private Integer userID;

    public VUserRole() {
    }

    public VUserRole(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VUserRole)) {
            return false;
        }
        VUserRole other = (VUserRole) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VUserRole[ userName=" + userName + " ]";
    }
    
}
