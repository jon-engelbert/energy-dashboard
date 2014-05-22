/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Meters;
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
public class MetersFacade extends AbstractFacade<Meters> {
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MetersFacade() {
        super(Meters.class);
    }
    
    public List<Meters> findByResourceType(String meterType) {
        List metersList = new ArrayList();
        metersList = em.createNamedQuery("Meters.findByFuelType").setParameter("fuelType", meterType).getResultList();
        return metersList;
    }
    
}
