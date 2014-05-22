/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Client;
import javax.annotation.Resource;
import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jon Engelbert
 */
@Stateless
//@LocalBean
public class ClientManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private UserManager userManager;
    @EJB
    private SitesManager siteManager;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    Integer gClientID;
    public Integer getClientID() 
    {
        return gClientID;
    };
    
    public Boolean addClient(String name, int percentMaxLightSetting, int percentMaxLightOriginal, 
                            int origSetpointCoolOcc, int origSetpointCoolUnocc, 
                            int origSetpointHeatOcc, int origSetpointHeatUnocc,
                            int setpointCoolOcc, int setpointCoolUnocc, int setpointHeatOcc,
                            int setpointHeatUnocc) {
        try {
            Client client = addClienttoDb(name, percentMaxLightSetting, percentMaxLightOriginal, 
                                            origSetpointCoolOcc, origSetpointCoolUnocc, 
                                            origSetpointHeatOcc, origSetpointHeatUnocc,
                                            setpointCoolOcc, setpointCoolUnocc, setpointHeatOcc,
                                            setpointHeatUnocc);

            return true;
        } catch (Exception e) {
            context.setRollbackOnly();
            return false;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Client addClienttoDb(String name, int percentMaxLightSetting, 
                                int percentMaxLightOriginal, int origSetpointCoolOcc, 
                                int origSetpointCoolUnocc, int origSetpointHeatOcc, 
                                int origSetpointHeatUnocc, int setpointCoolOcc,
                                int setpointCoolUnocc, int setpointHeatOcc,
                                int setpointHeatUnocc) {
        Client client = new Client();
        
//        client.setId(1);
        client.setName(name);
        client.setPercentMaxLightSetting(percentMaxLightSetting);
        client.setPercentMaxLightOriginal(percentMaxLightOriginal);
        client.setOrigSetpointCoolOcc(origSetpointCoolOcc);
        client.setOrigSetpointCoolUnocc(origSetpointCoolUnocc);
        client.setOrigSetpointHeatOcc(origSetpointHeatOcc);
        client.setOrigSetpointHeatUnocc(origSetpointHeatUnocc);
        client.setSetpointCoolOcc(setpointCoolOcc);
        client.setSetpointCoolUnocc(setpointCoolUnocc);
        client.setSetpointHeatOcc(setpointHeatOcc);
        client.setSetpointHeatUnocc(setpointHeatUnocc);        
        em.persist(client);
        em.flush();
        
        return client;
    }
    
    public boolean updateClientPartial(Integer clientID, int percentMaxLightSetting, 
                                int setpointHeatOcc, int setpointHeatUnocc, 
                                int setpointCoolOcc, int setpointCoolUnocc) {
        try {
            Client client = (Client) em.find(Client.class, clientID);
            client.setPercentMaxLightSetting(percentMaxLightSetting);
            client.setSetpointCoolOcc(setpointCoolOcc);
            client.setSetpointCoolUnocc(setpointCoolUnocc);
            client.setSetpointHeatOcc(setpointHeatOcc);
            client.setSetpointHeatUnocc(setpointHeatUnocc);               
            em.merge(client);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateClient(Integer clientID, String name, int percentMaxLightSetting, 
                                int percentMaxLightOriginal, int origSetpointCoolOcc, 
                                int origSetpointCoolUnocc, int origSetpointHeatOcc, 
                                int origSetpointHeatUnocc, int setpointCoolOcc,
                                int setpointCoolUnocc, int setpointHeatOcc,
                                int setpointHeatUnocc) {
        try {
            Client client = (Client) em.find(Client.class, clientID);
            client.setName(name);
            client.setPercentMaxLightSetting(percentMaxLightSetting);
            client.setPercentMaxLightOriginal(percentMaxLightOriginal);
            client.setOrigSetpointCoolOcc(origSetpointCoolOcc);
            client.setOrigSetpointCoolUnocc(origSetpointCoolUnocc);
            client.setOrigSetpointHeatOcc(origSetpointHeatOcc);
            client.setOrigSetpointHeatUnocc(origSetpointHeatUnocc);
            client.setSetpointCoolOcc(setpointCoolOcc);
            client.setSetpointCoolUnocc(setpointCoolUnocc);
            client.setSetpointHeatOcc(setpointHeatOcc);
            client.setSetpointHeatUnocc(setpointHeatUnocc);               

            em.merge(client);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    public boolean removeClient(Integer clientID) {
        List userList = new ArrayList();
        userList = userManager.findUsersByClientId(clientID);
        if (!userList.isEmpty())
            return false;
        List siteList = new ArrayList();
        siteList = siteManager.findSitesByClientId(clientID);
        if (!siteList.isEmpty())
            return false;
        try {
            Client client = em.find(Client.class, clientID);
            em.remove(client);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Client findClientById(Integer clientID) {
        Client client;
//        client = (Clients) em.createNamedQuery("Clients.findById").setParameter("id", id).getSingleResult();
        client = (Client) em.find(Client.class, clientID);
        return client;
    }    
    public Client findClientByName(String strClient) {
        Client client;
//        client = (Clients) em.createNamedQuery("Clients.findById").setParameter("id", id).getSingleResult();

        Query query = null;      
        try {
            query = em.createQuery("SELECT c FROM Client c WHERE c.name = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, strClient);
        
        client = (Client)query.getSingleResult();
        return client;
    }
    
}
