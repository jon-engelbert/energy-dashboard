/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.VUserRole;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Engel-less
 */
@Stateless
public class VUserRoleFacade extends AbstractFacade<VUserRole> {
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public VUserRoleFacade() {
        super(VUserRole.class);
    }
    
    public VUserRole findUserRoleByUserId(Integer userID) {
        VUserRole userRole = null;
        Query query = null;      
        try {
            query = em.createQuery("SELECT u FROM VUserRole u WHERE u.userID = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, userID);
        
        userRole = (VUserRole) query.getSingleResult();
        return userRole;
    }
}
