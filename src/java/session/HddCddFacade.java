/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.HddCdd;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jon Engelbert
 */
@Stateless
public class HddCddFacade extends AbstractFacade<HddCdd> {
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public HddCddFacade() {
        super(HddCdd.class);
    }
    
}
