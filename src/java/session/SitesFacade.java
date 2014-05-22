/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Sites;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thien
 */
@Stateless
public class SitesFacade extends AbstractFacade<Sites> {
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SitesFacade() {
        super(Sites.class);
    }
    
}
