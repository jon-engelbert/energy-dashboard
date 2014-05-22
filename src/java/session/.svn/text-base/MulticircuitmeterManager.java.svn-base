/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Multicircuitmeter;
import java.util.ArrayList;
import java.util.List;
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
public class MulticircuitmeterManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;


    public List findMulticircuitmetersBySiteId(Integer siteId) {
        List multicircuitmeterList = new ArrayList();
        Query query = em.createQuery("SELECT m FROM Multicircuitmeter m WHERE m.sitesId = ?1");
        query.setParameter(1, siteId);
        
        multicircuitmeterList = query.getResultList();
        return multicircuitmeterList;
    }

//    public Multicircuitmeter findMulticircuitmeterBySiteId(Integer Id) {
//        Multicircuitmeter multicircuitmeter = null;
//        Query query = em.createQuery("SELECT m FROM Multicircuitmeter m WHERE m.sitesId.id = ?1");
//        query.setParameter(1, siteId);
//        
//        multicircuitmeter = query.getSingleResult();
//        return multicircuitmeter;
//    }

}
