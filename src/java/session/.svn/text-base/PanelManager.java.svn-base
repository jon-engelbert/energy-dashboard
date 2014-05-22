/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.*;
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
 * @author Jon Engelbert
 */
@Stateless
@LocalBean
public class PanelManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String addPanel(String name, Sites parentSite, Panel parentPanel, Circuit parentCircuitID) {
        try {
            Panel panel = addPaneltoDb(name, parentSite, parentPanel, parentCircuitID);

            return panel.getName();
        } catch (Exception e) {
            context.setRollbackOnly();
            return "false";
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Panel addPaneltoDb(String name, Sites site, Panel parentPanel, Circuit parentCircuitID) {
        Panel panel = new Panel();
        
//        panel.setId(1);
        panel.setName(name);
        panel.setSitesId(site.getId());
        panel.setParentidPanel(parentPanel.getIdPanel());
        panel.setParentCircuitid(parentCircuitID.getIdCircuit());

        em.persist(panel);
        em.flush();
        
        return panel;
    }
    
    public boolean updatePanel(Integer panelID, String name, Sites site, int parentPanel, Circuit parentCircuitID) {
        try {
            Panel panel = (Panel) em.find(Panel.class, panelID);
            panel.setName(name);
            panel.setSitesId(site.getId());
            panel.setIdPanel(parentPanel);
            panel.setParentCircuitid(parentCircuitID.getIdCircuit());
            em.merge(panel);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    public boolean removePanel(Integer panelID) {
        try {
            Panel panel = em.find(Panel.class, panelID);
            em.remove(panel);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Panel findPanelById(Integer panelID) {
        Panel panel;
//        panel = (Panels) em.createNamedQuery("Panels.findById").setParameter("id", id).getSingleResult();
        panel = (Panel) em.find(Panel.class, panelID);
        return panel;
    }    
    public Panel findPanelByName(String strPanel) {
        Panel panel;
//        panel = (Panels) em.createNamedQuery("Panels.findById").setParameter("id", id).getSingleResult();
        panel = (Panel) em.find(Panel.class, strPanel);
        return panel;
    }

    public List findPanelsBySiteId(Integer siteId) {
        List panelList = new ArrayList();
        Query query = em.createQuery("SELECT p FROM Panel p WHERE p.sitesId.id = ?1");
        query.setParameter(1, siteId);
        
        panelList = query.getResultList();
        
        return panelList;
    }
}
