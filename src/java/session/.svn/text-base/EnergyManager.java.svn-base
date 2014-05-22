/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// JON:  THE ENERGY CLASS IS OBSOLETE.  IT HAS BEEN MERGED INTO THE BUILDING/SITE CLASS
package session;

import entity.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
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
public class EnergyManager {
// JON:  THE ENERGY CLASS IS OBSOLETE.  IT HAS BEEN MERGED INTO THE BUILDING/SITE CLASS

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

    
        
// JON:  THE ENERGY CLASS IS OBSOLETE.  IT HAS BEEN MERGED INTO THE BUILDING/SITE CLASS
    public int addEnergy(Client vClient, Schedule vSchedule, Sites vSite, Zones vZones, Endusecategory vEnduse,
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
                                 int vNewKWHpCDD, int vNewOtherKWH, int vBaseCoolingEnergyAnnual,
                                 int vBaseHeatEnergyAnnual, String vDDDate) {
        try {
            Energy energy = addEnergytoDb(vClient, vSchedule, vSite,vZones, vEnduse,
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
                                 vNewKWHpCDD, vNewOtherKWH, vBaseCoolingEnergyAnnual,
                                 vBaseHeatEnergyAnnual, vDDDate);
            return energy.getIdEnergy();
        } catch (Exception e) {
            context.setRollbackOnly();
            return -1;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public boolean AddPartialEnergytoDb(int energyID, boolean IsOverride, int CoolVal, int CoolUOVal, 
            int HeatVal, int HeatUOVal, int LightVal)
    {
        try {
            Energy energy = (Energy) em.find(Energy.class, energyID);
            energy.setIsOverride(IsOverride);
            energy.setSetpointCoolOcc(CoolVal);
            energy.setSetpointCoolUnocc(CoolUOVal);
            energy.setSetpointHeatOcc(HeatVal);
            energy.setSetpointHeatUnocc(HeatUOVal);
            energy.setPercentMaxLightSetting(LightVal);
            em.merge(energy);
            em.flush();
            return true;
        } catch (Exception e) {
            Logger log = Logger.getLogger(EnergyManager.class.getName()); 
            log.severe(e.toString()); 
            return false;
        }
    }

    private Energy addEnergytoDb(Client vClient, Schedule schedule, Sites vSite, 
                                 Zones vZones, Endusecategory vEnduse,
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
                                 int vNewKWHpCDD, int vNewOtherKWH, int vBaseCoolingEnergyAnnual,
                                 int vBaseHeatEnergyAnnual, String vDDDate) {
        
        Energy energy = new Energy();
        energy.setClientidClient(vClient.getIdClient());
        energy.setScheduleIdschedule(schedule.getIdschedule());
        energy.setSitesId(vSite.getId());    
        energy.setZonesIdzones(vZones.getIdzones());
        energy.setIsWholeBuilding(vIsWholeBuilding);
        energy.setIsOverride(vIsOverride);
        energy.setLightPowerBaseOcc(vLightPowerOccupied);
        energy.setLightPowerBaseUnOcc(vLightPowerUnoccupied);
        energy.setPercentMaxLightOriginal(vPercentMax);
        energy.setPercentMaxLightSetting(vPercentMaxOrig);
        energy.setIsOnWhenDark(vIsOnWhenDark);
        energy.setOrigSetpointCoolOcc(vOrigCoolingPointOccupied);
        energy.setOrigSetpointCoolUnocc(vOrigCoolingPointUnoccupied);
        energy.setSetpointCoolOcc(vCoolingPointOccupied);
        energy.setSetpointCoolUnocc(vCoolingPointUnoccupied);
        energy.setOrigSetpointHeatOcc(vOrigHeatPointOcc);
        energy.setOrigSetpointHeatUnocc(vOrigHeatPointUnocc);
        energy.setSetpointHeatOcc(vHeatPointOccupied);
        energy.setSetpointHeatUnocc(vHeatPointUnoccupied);
        energy.setCoolEnergySens(vCoolSen);
        energy.setHeatEnergySens(vHeatSen);
        energy.setOldBTUperHDD(vOldBTUpHDD);
        energy.setOldKWHperCDD(vOldKWHpCDD);
        energy.setOldOtherBTU(vOldOtherBTU);
        energy.setOldOtherKwh(vOldOtherKWH);
        energy.setCDDtoDate(vCDDtoDate);
        energy.setHDDtoDate(vHDDtoDate);
        energy.setNewBTUperHDD(vNewBTUpHDD);
        energy.setNewOtherBTU(vNewOtherBTU);
        energy.setNewKwhperCDD(vNewKWHpCDD);
        energy.setNewOtherKwh(vNewOtherKWH);
        energy.setBaseCoolEnergyAnnual(vBaseCoolingEnergyAnnual);
        energy.setBaseHeatEnergyAnnual(vBaseHeatEnergyAnnual);
        try {
            energy.setDateForDegreeDays(java.text.DateFormat.getInstance().parse(vDDDate));
        } catch (Exception e) {
            
        }
        em.persist(energy);
        em.flush();
        
        return energy;
    }
    
    public boolean updateEnergy(int energyID, Client vClient, Schedule vSchedule,
                                 Sites vSite, Zones vZones, Endusecategory vEnduse,
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
                                 int vNewKWHpCDD, int vNewOtherKWH, int vBaseCoolingEnergyAnnual,
                                 int vBaseHeatEnergyAnnual, String vDDDate) {
        try {
            Energy energy = (Energy) em.find(Energy.class, energyID);
            energy.setClientidClient(vClient.getIdClient());
            energy.setScheduleIdschedule(vSchedule.getIdschedule());
            energy.setSitesId(vSite.getId());    
            energy.setZonesIdzones(vZones.getIdzones());
            energy.setIsWholeBuilding(vIsWholeBuilding);
            energy.setIsOverride(vIsOverride);
            energy.setLightPowerBaseOcc(vLightPowerOccupied);
            energy.setLightPowerBaseUnOcc(vLightPowerUnoccupied);
            energy.setPercentMaxLightOriginal(vPercentMax);
            energy.setPercentMaxLightSetting(vPercentMaxOrig);
            energy.setIsOnWhenDark(vIsOnWhenDark);
            energy.setOrigSetpointCoolOcc(vOrigCoolingPointOccupied);
            energy.setOrigSetpointCoolUnocc(vOrigCoolingPointUnoccupied);
            energy.setSetpointCoolOcc(vCoolingPointOccupied);
            energy.setSetpointCoolUnocc(vCoolingPointUnoccupied);
            energy.setOrigSetpointHeatOcc(vOrigHeatPointOcc);
            energy.setOrigSetpointHeatUnocc(vOrigHeatPointUnocc);
            energy.setSetpointHeatOcc(vHeatPointOccupied);
            energy.setSetpointHeatUnocc(vHeatPointUnoccupied);
            energy.setCoolEnergySens(vCoolSen);
            energy.setHeatEnergySens(vHeatSen);
            energy.setOldBTUperHDD(vOldBTUpHDD);
            energy.setOldKWHperCDD(vOldKWHpCDD);
            energy.setOldOtherBTU(vOldOtherBTU);
            energy.setOldOtherKwh(vOldOtherKWH);
            energy.setCDDtoDate(vCDDtoDate);
            energy.setHDDtoDate(vHDDtoDate);
            energy.setNewBTUperHDD(vNewBTUpHDD);
            energy.setNewOtherBTU(vNewOtherBTU);
            energy.setNewKwhperCDD(vNewKWHpCDD);
            energy.setNewOtherKwh(vNewOtherKWH);
            energy.setBaseCoolEnergyAnnual(vBaseCoolingEnergyAnnual);
            energy.setBaseHeatEnergyAnnual(vBaseHeatEnergyAnnual);
            em.merge(energy);
            em.flush();
            return true;
        } catch (Exception e) {
            Logger log = Logger.getLogger(EnergyManager.class.getName()); 
            log.severe(e.toString()); 
            return false;
        }
    }
  
    public boolean removeEnergy(Integer energyID) {
        try {
            Energy energy = em.find(Energy.class, energyID);
            em.remove(energy);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Energy findEnergyByClientId(Integer clientId) {
        Energy energy = null;
        Query query = null;      
        try {
            query = em.createQuery("SELECT e FROM Energy e WHERE e.clientidClient.idClient = ?1");
            query.setParameter(1, clientId);
            energy = (Energy) query.getSingleResult();
        } catch(Exception ex) {
           clientId++; 
        }
        
        return energy;
    }
    
      public Energy findEnergyByEnergyId(Integer energyId) {
        Energy energy = null;
        Query query = null;      
        try {
            query = em.createQuery("SELECT e FROM Energy e WHERE e.idEnergy = ?1");
            query.setParameter(1, energyId);
            energy = (Energy) query.getSingleResult();
        } catch(Exception ex) {
           energyId++; 
        }
        
        return energy;
    }  
    
    public Energy findSiteEnergyBySiteId(Integer siteId) {
        Energy energy = null;
        try {
            Query query = em.createQuery("SELECT e FROM Energy e WHERE e.sitesId = ?1");
//            Query query = em.createQuery("SELECT e FROM Energy e WHERE e.sitesId = ?1 AND e.IsWholeBuilding = ?2");
            query.setParameter(1, siteId);
//            query.setParameter(2, 1);
            energy = (Energy) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
        return energy;
    }
}
