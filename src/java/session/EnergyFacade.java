/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Energy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jon Engelbert
 */
// JON:  THE ENERGY CLASS IS OBSOLETE.  IT HAS BEEN MERGED INTO THE BUILDING/SITE CLASS
@Stateless
public class EnergyFacade extends AbstractFacade<Energy> {
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EnergyFacade() {
        super(Energy.class);
    }
    
}
