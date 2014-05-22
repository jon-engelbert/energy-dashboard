/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Bills;
import entity.Meters;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author thien
 */
@Stateless
public class BillsFacade extends AbstractFacade<Bills> {
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public BillsFacade() {
        super(Bills.class);
    }
    
    public List<Bills> findByMeterID(String meterID) {
        List billsList = new ArrayList();
        billsList = em.createQuery("SELECT b from Bills b WHERE b.meters_id = :meterID").setParameter("meterID",meterID).getResultList();
        return billsList;
    }
    
    public List<Bills> findByMeterID2(String meterID) {
        List billsList = new ArrayList();
        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Bills> cq = cb.createQuery(Bills.class);
//        Metamodel m = em.getMetamodel();
//        EntityType<Bills> Bills_ = m.entity(Bills.class);
//        Root<Bills> bill = cq.from(Bills.class);
        CriteriaQuery<Bills> cq = cb.createQuery(Bills.class);
        Metamodel m = em.getMetamodel();
        EntityType<Bills> Bills_ = m.entity(Bills.class);

        Root<Bills> bill = cq.from(Bills.class);
//        Join<Bills, Meters> meter = bill.join(Bills_.meters_id);
        return billsList;
    }
    
}
