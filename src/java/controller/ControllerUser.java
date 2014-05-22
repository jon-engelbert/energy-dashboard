/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Client;
import entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ClientFacade;
import session.ClientManager;
import session.UserManager;
import session.UsersFacade;

/**
 *
 * @author jon
 */
@Stateless
@LocalBean
public class ControllerUser {

    @EJB
    private ClientFacade clientFacade;
    @EJB
    private ClientManager clientManager;
    @EJB
    private UserManager userManager;
    @EJB
    private UsersFacade usersFacade;

    public TransactionType DoAddUser(HttpServletRequest request, HttpServletResponse response) {
        String groupName = "user";
        String name = request.getParameter("user");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String strIsEmailAlert = request.getParameter("receiveEmailAlert");
        Boolean isEmailAlert = false;
        if (strIsEmailAlert != null) {
            isEmailAlert = (strIsEmailAlert.equalsIgnoreCase("on"));
        }
        String strIsEmailPolicy = request.getParameter("receiveEmailPolicy");
        Boolean isEmailPolicy = false;
        if (strIsEmailPolicy != null) {
            isEmailPolicy = (strIsEmailPolicy.equalsIgnoreCase("on"));
        }
        String strIsAdmin = request.getParameter("isAdmin");
        Boolean isAdmin = false;
        if (strIsAdmin != null) {
            isAdmin = (strIsAdmin.equalsIgnoreCase("on"));
            groupName = "admin";
        }
        String strIsSuperUser = request.getParameter("isSuperUser");
        Boolean isSuperUser = false;
        if (strIsSuperUser != null) {
            isSuperUser = (strIsSuperUser.equalsIgnoreCase("on"));
            groupName = "super";
        }
  
        String userName = request.getRemoteUser();
        Users currUser = userManager.findUserByName(userName);
        boolean isSuper = currUser.getIsSuperUser();
        String clientString = request.getParameter("client");
        int clientID = currUser.getClientidClient();
        if (isSuper)
            clientID = Integer.parseInt(clientString);

        String userAdded = userManager.addUser(name, password, email, isEmailAlert, isEmailPolicy, isAdmin, isSuperUser, groupName, clientID);
        if (userAdded.equals("false")) {
            request.setAttribute("result", "<font color='red'>Add user failed.  Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>User " + userAdded + " added successfully.</font>");
        }

        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_user.jsp");
        return transType;
    }

    public TransactionType DoAddNewUser(HttpServletRequest request, HttpServletResponse response) {
        //Used to handle users creating accounts
//        Client client = clientFacade.find(clientManager.getClientID());
        try {
            String groupName = "user";
        
            String name = request.getParameter("user");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String strIsEmailAlert = request.getParameter("receiveEmailAlert");
            Boolean isEmailAlert = false;
            if (strIsEmailAlert != null) {
                isEmailAlert = (strIsEmailAlert.equalsIgnoreCase("on"));
            }
            String strIsEmailPolicy = request.getParameter("receiveEmailPolicy");
            Boolean isEmailPolicy = false;
            if (strIsEmailPolicy != null) {
                isEmailPolicy = (strIsEmailPolicy.equalsIgnoreCase("on"));
            }
            String strIsAdmin = request.getParameter("isAdmin");
            Boolean isAdmin = false;
            if (strIsAdmin != null) {
                isAdmin = (strIsAdmin.equalsIgnoreCase("on"));
                groupName = "ADMIN";
            }

            String strIsSuperUser = request.getParameter("isSuperUser");
            Boolean isSuperUser = false;
            if (strIsSuperUser != null) {
                isSuperUser = (strIsSuperUser.equalsIgnoreCase("on"));
                groupName = "SUPER";
            }

            String userName = request.getRemoteUser();
            Users currUser = userManager.findUserByName(userName);
            String clientString = request.getParameter("client");
            int clientID = currUser.getClientidClient();
            if (!clientString.isEmpty())
                clientID = Integer.parseInt(clientString);

            String userAdded = userManager.addUser(name, password, email, isEmailAlert, isEmailPolicy, isAdmin, isSuperUser, groupName, clientID);    // Jon: for now, groupID is 0.
            if (userAdded.equals("false")) {
                request.setAttribute("result", "<font color='red'>Add user failed.  Please try again.</font>");
            } else {
                request.setAttribute("result", "<font color='green'>User " + userAdded + " added successfully.</font>");
            }
        } catch(Exception e) {
        
        }

        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_user.jsp");
        return transType;
    }
        
    public TransactionType DoRemoveUser(HttpServletRequest request, HttpServletResponse response, int clientID) {

        String intStr = request.getParameter("userid");
        if ((intStr != null) && (intStr != "null")) {
            int userID = Integer.parseInt(intStr);
            boolean removed = userManager.removeUser(userID);

            if (removed) {
                request.setAttribute("result", "<font color='green'>User successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>User remove failed. Please try again.</font>");
            }
        }

        String userName = request.getRemoteUser();
        Users currUser = userManager.findUserByName(userName);
        List userList = new ArrayList();
        if (currUser.getIsSuperUser())
            request.setAttribute("users", usersFacade.findAll());
        else if (currUser.getIsAdmin())
            request.setAttribute("users", userManager.findUsersByClientId(clientID));
        else {
            userList.add(currUser);
            request.setAttribute("users", userList);
        }            
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_user.jsp");
        return transType;
    }

    public TransactionType DoEditUserUpdate(HttpServletRequest request, HttpServletResponse response, Integer clientID) {
        String name = request.getParameter("user");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String groupName = "user";
        //Integer groupID = Integer.parseInt(request.getParameter("isAdmin"));
        
        try {
            String strIsEmailAlert = request.getParameter("receiveEmailAlert");

            Boolean isEmailAlert = false;
            if (strIsEmailAlert != null) {
                isEmailAlert = (strIsEmailAlert.equalsIgnoreCase("on"));
            }
            String strIsEmailPolicy = request.getParameter("receiveEmailPolicy");
            Boolean isEmailPolicy = false;
            if (strIsEmailPolicy != null) {
                isEmailPolicy = (strIsEmailPolicy.equalsIgnoreCase("on"));
            }

            String strIsAdmin = request.getParameter("isAdmin");
            Boolean isAdmin = false;
            if (strIsAdmin != null) {
                isAdmin = (strIsAdmin.equalsIgnoreCase("on"));
                groupName = "ADMIN";
            }

            String strIsSuperUser = request.getParameter("isSuperUser");
            Boolean isSuperUser = false;
            if (strIsSuperUser != null) {
                isSuperUser = (strIsSuperUser.equalsIgnoreCase("on"));
                groupName = "SUPER";
            }

            int userID = Integer.parseInt(request.getParameter("userid"));  // jon-- not sure if this is right?
            //int idInt = Integer.parseInt(userID);
            //String userName = request.getRemoteUser();
            Users activeUser = userManager.findUserById(userID);
            String clientString = null;
            try {
                clientString = request.getParameter("client");
            } catch (Exception e) {               
            }
            if ((clientString != null) && !clientString.isEmpty())
                clientID = Integer.parseInt(clientString);
            boolean userUpdated = userManager.updateUser(userID, name, password, email, isEmailAlert, isEmailPolicy, isAdmin, isSuperUser, groupName, clientID);
            if (userUpdated) {
                request.setAttribute("result", "<font color='green'>User " + name + " updated successfully.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Edit user failed.  Please try again.</font>");
            }

            List userList = new ArrayList();
            String userName = request.getRemoteUser();
            Users currUser = userManager.findUserByName(userName);
            if (currUser.getIsSuperUser())
                request.setAttribute("users", usersFacade.findAll());
            else if (currUser.getIsAdmin())
                request.setAttribute("users", userManager.findUsersByClientId(clientID));
            else {
                userList.add(currUser);
                request.setAttribute("users", userList);
            }
            request.setAttribute("userIsSuper",  currUser.getIsSuperUser());
        request.setAttribute("userIsAdmin",  currUser.getIsAdmin() || currUser.getIsSuperUser());
        } catch (Exception e) {
        
        }
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_user.jsp");
        return transType;
    }

    public TransactionType DoEditUser(HttpServletRequest request, HttpServletResponse response, int clientID) {
        boolean showForm = false;
        List userList = new ArrayList();
        List clientList = new ArrayList();
        clientList = clientFacade.findAll();
        request.setAttribute("clientList", clientList);
        String userIntStr = request.getParameter("userid");
        
        String userName = request.getRemoteUser();
        Users currUser = userManager.findUserByName(userName);
        boolean isSuper = currUser.getIsSuperUser();
        Users user = null;
        if ((userIntStr != null) && (userIntStr != "null")) {
            int userID = Integer.parseInt(userIntStr);
            user = userManager.findUserById(userID);
        }

        if (user != null) {
            user.setUserPassword("");
            showForm = true;
            request.setAttribute("userinfo", user);
            request.setAttribute("userIsSuper",  isSuper);
            request.setAttribute("userIsAdmin",  currUser.getIsAdmin() || isSuper);
            int localClientID = user.getClientidClient();
            if (isSuper)
                request.setAttribute("client", localClientID);
        }
//      else 
//            request.setAttribute("result", "<font color='red'>User edit failed.  Please try again</font>");
        if (isSuper)
            request.setAttribute("users", usersFacade.findAll());
        else if (currUser.getIsAdmin())
            request.setAttribute("users", userManager.findUsersByClientId(clientID));
        else {
            userList.add(currUser);
            request.setAttribute("users", userList);
        }            

        //String clientString = request.getParameter("client");
        request.setAttribute("showform", showForm);

        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_user.jsp");
        return transType;
    }
    public TransactionType DoSetupUser(HttpServletRequest request, HttpServletResponse response, int clientID)
    {
        List clientList = new ArrayList();
        clientList = clientFacade.findAll();
        List userList = new ArrayList();
        request.setAttribute("clientList", clientList);
        String userName = request.getRemoteUser();
        Users currUser = userManager.findUserByName(userName);
        boolean isSuper = currUser.getIsSuperUser();
        if (isSuper)
            request.setAttribute("users", usersFacade.findAll());
        else if (currUser.getIsAdmin())
            request.setAttribute("users", userManager.findUsersByClientId(clientID));
        else {
            userList.add(currUser);
            request.setAttribute("users", userList);
        }
        //boolean isAdmin2 = request.isUserInRole("admin");
        request.setAttribute("userIsSuper",  currUser.getIsSuperUser());
        request.setAttribute("userIsAdmin",  currUser.getIsAdmin() || currUser.getIsSuperUser());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_user.jsp");
        return transType;
    }
}
