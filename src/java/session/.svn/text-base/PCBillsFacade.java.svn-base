/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.PCBills;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thien
 */
@Stateless
public class PCBillsFacade extends AbstractFacade<PCBills> {
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PCBillsFacade() {
        super(PCBills.class);
    }
    
    public List<PCBills> findBySiteID(String siteID) {
        List billsList = new ArrayList();
        billsList = em.createQuery("SELECT b from Bills b WHERE b.Sites_id = :siteID").setParameter("siteID",siteID).getResultList();
        return billsList;
    }
}
