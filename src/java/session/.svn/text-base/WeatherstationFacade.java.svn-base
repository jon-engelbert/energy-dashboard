/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Weatherstation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jon Engelbert
 */
@Stateless
public class WeatherstationFacade extends AbstractFacade<Weatherstation> {
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WeatherstationFacade() {
        super(Weatherstation.class);
    }
    
}
