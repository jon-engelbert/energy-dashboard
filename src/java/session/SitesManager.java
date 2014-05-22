/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Client;
import entity.Sites;
import entity.Weatherstation;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Jon Engelbert
 */
@Stateless
@LocalBean
public class SitesManager {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private MetersManager meterManager;
    @EJB
    private PCBillsManager pcBillManager;

//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String addSite(String name, String address1, String address2, String city, String state, String zipcode, int nPeople, int sqFt, int clientID,    // Client client,
                                int scheduleID, int wsID,
                                 Boolean vIsWholeBuilding, Boolean vIsOverride,
                                 int vLightPowerOccupied, int vLightPowerUnoccupied,
                                 int vPercentMax, int vPercentMaxOrig, Boolean vIsOnWhenDark,
                                 int vOrigCoolingPointOccupied, int vOrigCoolingPointUnoccupied,
                                 int vCoolingPointOccupied, int vCoolingPointUnoccupied,
                                 int vOrigHeatPointOcc, int vOrigHeatPointUnocc,
                                 int vHeatPointOccupied, int vHeatPointUnoccupied,
                                 int vCoolSen, int vHeatSen, int vOldBTUpHDD, int vOldKWHpCDD,
                                 int vOldOtherBTU, int vOldOtherKWH, int vCDDtoDate,
                                 int vHDDtoDate, int vNewBTUpHDD, int vNewOtherBTU,
                                 int vNewKWHpCDD, int vNewOtherKWH) {
        try {
            Sites site = addSitetoDb(name, address1, address2, city, state, zipcode, 
                        nPeople, sqFt, clientID, scheduleID, wsID,
                        vIsWholeBuilding, vIsOverride,
                                 vLightPowerOccupied, vLightPowerUnoccupied,
                                 vPercentMax, vPercentMaxOrig, vIsOnWhenDark,
                                 vOrigCoolingPointOccupied, vOrigCoolingPointUnoccupied,
                                 vCoolingPointOccupied, vCoolingPointUnoccupied,
                                 vOrigHeatPointOcc, vOrigHeatPointUnocc,
                                 vHeatPointOccupied, vHeatPointUnoccupied,
                                 vCoolSen, vHeatSen, vOldBTUpHDD, vOldKWHpCDD,
                                 vOldOtherBTU, vOldOtherKWH, vCDDtoDate,
                                 vHDDtoDate, vNewBTUpHDD, vNewOtherBTU,
                                 vNewKWHpCDD, vNewOtherKWH);

            return site.getName();
        } catch (Exception e) {
            context.setRollbackOnly();
            return "false";
        }
    }

    public boolean UpdatePartialEnergytoDb(int sitesID, boolean IsOverride, int CoolVal, int CoolUOVal, 
            int HeatVal, int HeatUOVal, int LightVal)
    {
        try {
            Sites site = (Sites) em.find(Sites.class, sitesID);
            site.setIsOverride(IsOverride);
            site.setSetpointCoolOcc(CoolVal);
            site.setSetpointCoolUnocc(CoolUOVal);
            site.setSetpointHeatOcc(HeatVal);
            site.setSetpointHeatUnocc(HeatUOVal);
            site.setPercentMaxLightSetting(LightVal);
            em.merge(site);
            em.flush();
            return true;
        } catch (Exception e) {
            Logger log = Logger.getLogger(SitesManager.class.getName()); 
            log.severe(e.toString()); 
            return false;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Sites addSitetoDb(String name, String address1, String address2, String city, String state, String zipcode, int nPeople, int sqFt, int clientID,    // Client client, 
                                int scheduleID, int wsID,
                                Boolean vIsWholeBuilding, Boolean vIsOverride,
                                 int vLightPowerOccupied, int vLightPowerUnoccupied,
                                 int vPercentMax, int vPercentMaxOrig, Boolean vIsOnWhenDark,
                                 int vOrigCoolingPointOccupied, int vOrigCoolingPointUnoccupied,
                                 int vCoolingPointOccupied, int vCoolingPointUnoccupied,
                                 int vOrigHeatPointOcc, int vOrigHeatPointUnocc,
                                 int vHeatPointOccupied, int vHeatPointUnoccupied,
                                 int vCoolSen, int vHeatSen, int vOldBTUpHDD, int vOldKWHpCDD,
                                 int vOldOtherBTU, int vOldOtherKWH, int vCDDtoDate,
                                 int vHDDtoDate, int vNewBTUpHDD, int vNewOtherBTU,
                                 int vNewKWHpCDD, int vNewOtherKWH) {
        Sites site = new Sites();
        //Weatherstation weather = new Weatherstation();
        site.setId(1);
        site.setName(name);
        site.setAddress1(address1);
        site.setAddress2(address2);
        site.setCity(city);
        site.setState(state);
        site.setZipcode(zipcode);
        site.setNPeople(nPeople);
        site.setSquarefeet(sqFt);
        site.setClientidClient(clientID);   // client.getIdClient()
        site.setScheduleIdschedule(scheduleID);
        site.setWeatherStationid(wsID);
        site.setIsWholeBuilding(vIsWholeBuilding);
        site.setIsOverride(vIsOverride);
        site.setLightPowerBaseOcc(vLightPowerOccupied);
        site.setLightPowerBaseUnOcc(vLightPowerUnoccupied);
        site.setPercentMaxLightOriginal(vPercentMax);
        site.setPercentMaxLightSetting(vPercentMaxOrig);
        site.setIsOnWhenDark(vIsOnWhenDark);
        site.setOrigSetpointCoolOcc(vOrigCoolingPointOccupied);
        site.setOrigSetpointCoolUnocc(vOrigCoolingPointUnoccupied);
        site.setSetpointCoolOcc(vCoolingPointOccupied);
        site.setSetpointCoolUnocc(vCoolingPointUnoccupied);
        site.setOrigSetpointHeatOcc(vOrigHeatPointOcc);
        site.setOrigSetpointHeatUnocc(vOrigHeatPointUnocc);
        site.setSetpointHeatOcc(vHeatPointOccupied);
        site.setSetpointHeatUnocc(vHeatPointUnoccupied);
        site.setCoolEnergySens(vCoolSen);
        site.setHeatEnergySens(vHeatSen);
        site.setOldBTUperHDD(vOldBTUpHDD);
        site.setOldKWHperCDD(vOldKWHpCDD);
        site.setOldOtherBTU(vOldOtherBTU);
        site.setOldOtherKwh(vOldOtherKWH);
//        site.setCDDtoDate(vCDDtoDate);
//        site.setHDDtoDate(vHDDtoDate);
        site.setNewBTUperHDD(vNewBTUpHDD);
        site.setNewOtherBTU(vNewOtherBTU);
        site.setNewKwhperCDD(vNewKWHpCDD);
        site.setNewOtherKwh(vNewOtherKWH);
        //This should lookup to an actul id
        //site.setWeatherStationid(1);
        em.persist(site);
        em.flush();
        
        return site;
    }
    
    public boolean updateSite(Integer siteID, String name, String address1, String address2, String city, String state, String zipcode, int nPeople, int sqFt, int clientID,    // Client client,
                                 int scheduleID, int wsID,
                                 Boolean vIsWholeBuilding, Boolean vIsOverride, 
                                 int vLightPowerOccupied, int vLightPowerUnoccupied,
                                 int vPercentMax, int vPercentMaxOrig, Boolean vIsOnWhenDark,
                                 int vOrigCoolingPointOccupied, int vOrigCoolingPointUnoccupied,
                                 int vCoolingPointOccupied, int vCoolingPointUnoccupied,
                                 int vOrigHeatPointOcc, int vOrigHeatPointUnocc,
                                 int vHeatPointOccupied, int vHeatPointUnoccupied,
                                 int vCoolSen, int vHeatSen, int vOldBTUpHDD, int vOldKWHpCDD,
                                 int vOldOtherBTU, int vOldOtherKWH, int vCDDtoDate,
                                 int vHDDtoDate, int vNewBTUpHDD, int vNewOtherBTU,
                                 int vNewKWHpCDD, int vNewOtherKWH) {

        try {
            Sites site = (Sites) em.find(Sites.class, siteID);
            site.setName(name);
            site.setAddress1(address1);
            site.setAddress2(address2);
            site.setCity(city);
            site.setState(state);
            site.setZipcode(zipcode);
            site.setNPeople(nPeople);
            site.setSquarefeet(sqFt);
            site.setClientidClient(clientID);   // client.getIdClient()
            site.setScheduleIdschedule(scheduleID);
            site.setWeatherStationid(wsID);
            site.setIsWholeBuilding(vIsWholeBuilding);
            site.setIsOverride(vIsOverride);
            site.setLightPowerBaseOcc(vLightPowerOccupied);
            site.setLightPowerBaseUnOcc(vLightPowerUnoccupied);
            site.setPercentMaxLightOriginal(vPercentMax);
            site.setPercentMaxLightSetting(vPercentMaxOrig);
            site.setIsOnWhenDark(vIsOnWhenDark);
            site.setOrigSetpointCoolOcc(vOrigCoolingPointOccupied);
            site.setOrigSetpointCoolUnocc(vOrigCoolingPointUnoccupied);
            site.setSetpointCoolOcc(vCoolingPointOccupied);
            site.setSetpointCoolUnocc(vCoolingPointUnoccupied);
            site.setOrigSetpointHeatOcc(vOrigHeatPointOcc);
            site.setOrigSetpointHeatUnocc(vOrigHeatPointUnocc);
            site.setSetpointHeatOcc(vHeatPointOccupied);
            site.setSetpointHeatUnocc(vHeatPointUnoccupied);
            site.setCoolEnergySens(vCoolSen);
            site.setHeatEnergySens(vHeatSen);
            site.setOldBTUperHDD(vOldBTUpHDD);
            site.setOldKWHperCDD(vOldKWHpCDD);
            site.setOldOtherBTU(vOldOtherBTU);
            site.setOldOtherKwh(vOldOtherKWH);
    //        site.setCDDtoDate(vCDDtoDate);
    //        site.setHDDtoDate(vHDDtoDate);
            site.setNewBTUperHDD(vNewBTUpHDD);
            site.setNewOtherBTU(vNewOtherBTU);
            site.setNewKwhperCDD(vNewKWHpCDD);
            site.setNewOtherKwh(vNewOtherKWH);            
            em.merge(site);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    public boolean removeSite(Integer siteID) {
        List meterList = new ArrayList();
        meterList = meterManager.findMeterBySiteId(siteID);
        if (!meterList.isEmpty())
            return false;
        List pcBillList = new ArrayList();
        pcBillList = pcBillManager.findPCbillsBySiteId(siteID);
        if (!pcBillList.isEmpty())
            return false;
        try {
            Sites site = em.find(Sites.class, siteID);
            em.remove(site);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Sites findSiteById(Integer siteID) {
        Sites site;
//        site = (Sites) em.createNamedQuery("Sites.findById").setParameter("id", id).getSingleResult();
        site = (Sites) em.find(Sites.class, siteID);
        return site;
    }    

    public Sites findSiteByName(String strSite) {
        Sites site;
//        site = (Sites) em.createNamedQuery("Sites.findById").setParameter("id", id).getSingleResult();
        site = (Sites) em.find(Sites.class, strSite);
        return site;
    }    
    
    public List findSitesByClientId(Integer clientID) {
        List sitesList = new ArrayList();
        Query query = null;      
        try {
            query = em.createQuery("SELECT s FROM Sites s WHERE s.clientidClient = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, clientID);
        
        sitesList = query.getResultList();
        return sitesList;
    }
    public List findSitesByScheduleId(Integer scheduleID) {
        List sitesList = new ArrayList();
        Query query = null;      
        try {
            query = em.createQuery("SELECT s FROM Sites s WHERE s.scheduleIdschedule = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, scheduleID);
        
        sitesList = query.getResultList();
        return sitesList;
    }
    
    public List findSitesByWSId(Integer wsID) {
        List wsList = new ArrayList();
        Query query = null;      
        try {
            query = em.createQuery("SELECT s FROM Sites s WHERE s.weatherStationid = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, wsID);
        
        wsList = query.getResultList();
        return wsList;
    }

}
