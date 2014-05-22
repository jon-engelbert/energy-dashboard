/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
 * @author bender
 */
@Stateless
@LocalBean
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserManager {
    
    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private VUserRoleFacade userRoleFacade;

//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String addUserOld(String name, String password, String email, Boolean isEmailAlert, Boolean isEmailPolicy, Boolean isAdmin, Boolean isSuperUser, Integer groupID, int clientID) {
        try {
            String groupName = "user";
            if (isSuperUser)
                groupName = "superuser";
            if (isAdmin)
                groupName = "admin";
            Users user = addUsertoDb(name, password, email, isEmailAlert, isEmailPolicy, isAdmin, isSuperUser, groupName, clientID);

            return user.getUserName();
        } catch (Exception e) {
            context.setRollbackOnly();
            return "false";
        }
    }

    static String getMd5Digest(String pInput) {
        try {
            MessageDigest lDigest = MessageDigest.getInstance("MD5");
            lDigest.update(pInput.getBytes());
            BigInteger lHashInt = new BigInteger(1, lDigest.digest());
            return String.format("%1$032X", lHashInt);
        } catch (NoSuchAlgorithmException lException) {
            throw new RuntimeException(lException);
        }
    }

    public String addUser(String name, String password, String email,  Boolean isEmailAlert, Boolean isEmailPolicy, Boolean isAdmin, Boolean isSuperUser, String groupName, int clientID) {
        try {
            Users user = new Users();
            List usersList = new ArrayList();
            String result = new String();

            String passwordMD5 = getMd5Digest(password);
            
            usersList = em.createNamedQuery("Users.findByUserName").setParameter("userName", name).getResultList();
            if (usersList.isEmpty()) {
                user = addUsertoDb(name, password, email, isEmailAlert, isEmailPolicy, isAdmin, isSuperUser, groupName, clientID);
                result = "'" + user.getUserName() + "' added sucessfully";

                // Logging action
//                logsManager.RecordLog(Global.gUsername, "Added user '" + user.getUserName() + "'", user);
            } else {
                result = "Error: User already exists.";
            }

            return result;
        } catch (Exception e) {
            context.setRollbackOnly();
            return "Error: Failed to add user";
        }
    }

    public String addNewUser(String name, String password, String email, Boolean isEmailAlert, Boolean isEmailPolicy, Boolean isAdmin, Boolean isSuperUser, int clientID) {
        try {
            String groupName = "user";
            if (isSuperUser)
                groupName = "superuser";
            if (isAdmin)
                groupName = "admin";
            Users user = addUsertoDb(name, password, email, isEmailAlert, isEmailPolicy, isAdmin, isSuperUser, groupName, clientID);

            return user.getUserName();
        } catch (Exception e) {
            context.setRollbackOnly();
            return "false";
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Users addUsertoDb(String name, String password, String email, Boolean isEmailAlert, Boolean isEmailPolicy, Boolean isAdmin, Boolean isSuperUser, String groupName, int clientID) {
        Users user = new Users();       
//        user.setId(1);
        String passwordMD5 = getMd5Digest(password);
        user.setUserName(name);
        user.setUserPassword(passwordMD5);
        user.setEmail(email);
        user.setIsEmailAlert(isEmailAlert);
        user.setIsEmailPolicy(isEmailPolicy);
        user.setIsAdmin(isAdmin);
        user.setIsSuperUser(isSuperUser);
        user.setClientidClient(clientID);
//        user.setAuditTrail(" ");

        em.persist(user);
        em.flush();
        
        VUserRole userRole = new VUserRole();
        userRole.setUserName(name);
        userRole.setUserPassword(passwordMD5);
        userRole.setRoleName(groupName);
        userRole.setUserID(user.getId());
        em.persist(userRole);
        
        return user;
    }
    
    public boolean updateUser(Integer userID, String name, String password, String email, Boolean isEmailAlert, Boolean isEmailPolicy, Boolean isAdmin, Boolean isSuperUser, String groupName, int clientID) {
        try {
            Users  user = (Users) em.find(Users.class, userID);
            String passwordMD5 = getMd5Digest(password);
            user.setUserName(name);
            user.setUserPassword(passwordMD5);
            user.setEmail(email);
            user.setIsEmailAlert(isEmailAlert);
            user.setIsEmailPolicy(isEmailPolicy);
            user.setIsAdmin(isAdmin);
            user.setIsSuperUser(isSuperUser);
//            user.setGroupID(groupID);
            user.setClientidClient(clientID);
            em.merge(user);
            em.flush();
            
            VUserRole userRole = (VUserRole) userRoleFacade.findUserRoleByUserId(userID);
            userRole.setUserName(name);
            userRole.setUserPassword(passwordMD5);
            userRole.setRoleName(groupName);
            userRole.setUserID(userID);
            em.persist(userRole);
        
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    public boolean removeUser(Integer userID) {
        try {
            Users user = em.find(Users.class, userID);
            em.remove(user);
            em.flush();
            VUserRole userRole = (VUserRole) userRoleFacade.findUserRoleByUserId(userID);
            em.remove(userRole);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Users findUserById(Integer userID) {
        Users user;
//        user = (Users) em.createNamedQuery("Users.findById").setParameter("id", id).getSingleResult();
        user = (Users) em.find(Users.class, userID);
        return user;
    }

    public List findUsersByClientId(Integer clientID) {
        List userList = new ArrayList();
        Query query = null;      
        try {
            query = em.createQuery("SELECT u FROM Users u WHERE u.clientidClient = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, clientID);
        
        userList = query.getResultList();
        return userList;
    }
    public Users findUserByName(String userName) {
        Users user;
        Query query = null;      
        try {
            query = em.createQuery("SELECT u FROM Users u WHERE u.userName = ?1");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, userName);
        
        user = (Users)query.getSingleResult();
        return user;
    }
}