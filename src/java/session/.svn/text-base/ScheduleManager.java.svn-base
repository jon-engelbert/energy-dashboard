/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Client;
import entity.Schedule;
import entity.Sites;
import entity.Weatherstation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class ScheduleManager {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private SitesManager sitesManager;

//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String addSchedule (String name, 
                              Integer MonHours, Integer TuesHours,
                              Integer WedHours, Integer ThHours,
                              Integer FriHours, Integer SatHours,
                              Integer SunHours, Client client)
//            , Boolean isOnWhenDark) 
    {
        try {
            Schedule schedule = addScheduletoDb(name, MonHours, TuesHours, WedHours, ThHours, FriHours, SatHours, SunHours, client);
//, isOnWhenDark);

            return schedule.getName();
        } catch (Exception e) {
            context.setRollbackOnly();
            return "false";
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Schedule addScheduletoDb(String name, 
                              Integer MonHours, Integer TuesHours,
                              Integer WedHours, Integer ThHours,
                              Integer FriHours, Integer SatHours,
                              Integer SunHours, Client client)
//            , Boolean isOnWhenDark) 
    {
        Schedule schedule = new Schedule();
        try {
            schedule.setName(name);
            schedule.setMonHours(MonHours);
            schedule.setTuesHours(TuesHours);
            schedule.setWedHours(WedHours);
            schedule.setThHours(ThHours);
            schedule.setFriHours(FriHours);
            schedule.setSatHours(SatHours);
            schedule.setSunHours(SunHours);
            schedule.setClientidClient(client.getIdClient());
//            schedule.setIsOnWhenDark(isOnWhenDark);
        } catch (Exception e) {
            return null;
        }
        em.persist(schedule);
        em.flush();
        return schedule;
    }
    
    public boolean updateSchedule(Integer scheduleID, String name, 
                                  Integer MonHours, Integer TuesHours,
                                  Integer WedHours, Integer ThHours,
                                  Integer FriHours, Integer SatHours,
                                  Integer SunHours)
//            , Boolean isOnWhenDark)   // obsolete
    {
        try {
            Schedule schedule = (Schedule) em.find(Schedule.class, scheduleID);
            schedule.setName(name);
            schedule.setMonHours(MonHours);
            schedule.setTuesHours(TuesHours);
            schedule.setWedHours(WedHours);
            schedule.setThHours(ThHours);
            schedule.setFriHours(FriHours);
            schedule.setSatHours(SatHours);
            schedule.setSunHours(SunHours);
//            schedule.setIsOnWhenDark(isOnWhenDark);
            em.merge(schedule);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    public boolean removeSchedule(Integer scheduleID) {
        List sitesList = new ArrayList();
        sitesList = sitesManager.findSitesByScheduleId(scheduleID);
        if (!sitesList.isEmpty())
            return false;

        try {
            Schedule schedule = em.find(Schedule.class, scheduleID);
            em.remove(schedule);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Schedule findScheduleByID(Integer scheduleID) {
        Schedule schedule;
        schedule = (Schedule) em.find(Schedule.class, scheduleID);
        return schedule;
    }
    
    public List findSchedulesByClientId(Integer clientID) {
        List scheduleList = new ArrayList();
        Query query = null;      
        try {   // SELECT s FROM Schedule s WHERE s.clientidClient
            query = em.createQuery("SELECT s FROM Schedule s WHERE s.clientidClient = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, clientID);
        
        scheduleList = query.getResultList();
        return scheduleList;
    }

}
