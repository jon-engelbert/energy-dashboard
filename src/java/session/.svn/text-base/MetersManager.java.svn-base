/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
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
public class MetersManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private SitesManager sitesManager;
    @EJB
    private MetersFacade meterFacade;

    public int addMeter(String resource, int siteID, String meterNo, String accountNum, String providerName) {
        Meters meter = new Meters();
        meter.setFuelType(resource);
        meter.setProviderName(providerName);
        meter.setTextID(meterNo);
        meter.setAccountNum(accountNum);
//        Sites site = sitesManager.findSiteByName(siteName);
        meter.setSitesId(siteID);
        meter.setVendorID("vID");
        try {
            em.persist(meter);
            em.flush();
        } catch (Exception e) {
            context.setRollbackOnly();
            System.out.println(e.toString());
            System.out.println(meter.getAccountNum());
            System.out.println(meter.getFuelType());
            System.out.println(meter.getProviderName());
            System.out.println(meter.getSitesId());
            System.out.println(meter.getTextID());
            Logger.getLogger(MetersManager.class.getName()).log(Level.SEVERE, "Attempted Add Meter", e);
            return -1;
        }
        return meter.getId();
    }
    
    public List findMetersBySiteId(Integer siteID) {
        List metersList = new ArrayList();
        Query query = null;      
        try {
            query = em.createQuery("SELECT m FROM Meters m WHERE m.sitesId = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1,siteID);
        metersList = query.getResultList();

        return metersList;
    }
    
    
     public boolean updateMeter(Integer meterID, String resource, int siteID, String meterNo, String accountNum, String providerName) {
        try {
            Meters meter = (Meters) em.find(Meters.class, meterID);
            meter.setAccountNum(accountNum);
            meter.setFuelType(resource);
            meter.setProviderName(providerName);
            meter.setTextID(meterNo);
            meter.setSitesId(siteID);
            em.merge(meter);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    public boolean removeMeter(Integer meterID) {
        try {
            Meters meter = em.find(Meters.class, meterID);
            em.remove(meter);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Meters findMeterById(Integer meterID) {
        Meters meter;
        meter = (Meters) em.find(Meters.class, meterID);
        return meter;
    }
    public List findMeterBySiteId(Integer siteID) {
        List metersList = new ArrayList();
        Query query = null;      
        try {
            query = em.createQuery("SELECT m FROM Meters m WHERE m.sitesId = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, siteID);
        
        metersList = query.getResultList();
        return metersList;
    }
    
    public List findMeterByClientId(Integer clientID) {
        List metersList = new ArrayList();
        List siteMetersList = new ArrayList();
        List sitesList = sitesManager.findSitesByClientId(clientID);       
        Iterator<Sites> iter = sitesList.iterator();
        Sites currSite = null;
        Meters currMeter = null;

        while (iter.hasNext() == true) {
            currSite = iter.next();
            
            siteMetersList = findMetersBySiteId(currSite.getId());
            Iterator<Meters> iterMeters = siteMetersList.iterator();

            while (iterMeters.hasNext() == true) {
                currMeter = iterMeters.next();
                metersList.add(currMeter);
            }
        }
        
        return metersList;
    }
}
