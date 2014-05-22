/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Endusecategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thien
 */
@Stateless
@LocalBean
public class EndusecategoryManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

    public Endusecategory findEndusercategoryBySiteId(Integer siteId) {
        Endusecategory endusecategory = null;
        Query query = em.createQuery("SELECT e FROM Zones e WHERE e.idEndUseCategory = ?1");
        query.setParameter(1, siteId);
        
        endusecategory = (Endusecategory) query.getSingleResult();
        
        return endusecategory;
    }
}
