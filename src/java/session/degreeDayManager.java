/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Weatherstation;
import entity.HddCdd;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thien
 */
@Stateless
@LocalBean
public class degreeDayManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

//    public WeatherStation findWeatherStationId(String stationId) {
////        Hdd hdd = new Hdd();
////        hdd = (Hdd) em.createNamedQuery("Hdd.findByWeatherStationId").setParameter("weatherStationId", stationId).getSingleResult();
////        return hdd;
////    }
////
////    public Cdd findCddByWeatherStationId(String stationId) {
////        Cdd cdd = new Cdd();
////        cdd = (Cdd) em.createNamedQuery("Cdd.findByWeatherStationId").setParameter("weatherStationId", stationId).getSingleResult();
////        return cdd;
////    }
//
}
