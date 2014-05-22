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
public class ZoneManager {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String addZone(String name, int nPeople, int sqFt, Sites parentSite, Zones parentZone) {
        try {
            Zones zone = addZonetoDb(name, nPeople, sqFt, parentSite, parentZone);

            return zone.getName();
        } catch (Exception e) {
            context.setRollbackOnly();
            return "false";
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Zones addZonetoDb(String name, int nPeople, int sqFt, Sites parentSite, Zones parentZone) {
        Zones zone = new Zones();
        
        zone.setName(name);     
        zone.setNPeople(nPeople);
        zone.setSquareFeet(sqFt);
        zone.setSitesId(parentSite.getId());
        if (parentZone != null) {
            zone.setParentIdzones(parentZone.getIdzones());
        }
        em.persist(zone);
        em.flush();
        
        return zone;
    }
    
    public boolean updateZone(Integer zoneID, String name, int nPeople, int sqFt, Sites parentSite, Zones parentZone) {
        try {
            Zones zone = (Zones) em.find(Zones.class, zoneID);
            zone.setName(name);
            zone.setNPeople(nPeople);
            zone.setSquareFeet(sqFt);
            zone.setParentIdzones(parentZone.getIdzones());
            zone.setSitesId(parentSite.getId());
            em.merge(zone);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    public boolean removeZone(Integer zoneID) {
        try {
            Zones zone = em.find(Zones.class, zoneID);
            em.remove(zone);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Zones findZoneById(Integer zoneID) {
        Zones zone;
//        zone = (Zones) em.createNamedQuery("Zones.findById").setParameter("id", id).getSingleResult();
        zone = (Zones) em.find(Zones.class, zoneID);
        return zone;
    }    
    public Zones findZoneByName(String strZone) {
        Zones zone;
//        zone = (Zones) em.createNamedQuery("Zones.findById").setParameter("id", id).getSingleResult();
        zone = (Zones) em.find(Zones.class, strZone);
        return zone;
    }
    
    public List findZonesBySiteId(Integer siteId) {
        List zonesList = new ArrayList();
        Query query = em.createQuery("SELECT z FROM Zones z WHERE z.sitesId.id = ?1");
        query.setParameter(1, siteId);
        
        zonesList = query.getResultList();
        
        return zonesList;
    }
}
