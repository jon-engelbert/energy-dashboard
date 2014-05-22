/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Client;
import entity.Financial;
import entity.Users;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ClientFacade;
import session.ClientManager;
import session.FinancialFacade;
import session.FinancialManager;
import session.UserManager;

/**
 *
 * @author worman
 */
@Stateless
@LocalBean
public class ControllerClient {
    @EJB
    private ClientFacade clientFacade;
    @EJB
    private ClientManager clientManager;
    @EJB
    private FinancialFacade financialFacade;
    @EJB
    private FinancialManager financialManager;
    @EJB
    private UserManager userManager;

    public TransactionType DoSetupClient(HttpServletRequest request, HttpServletResponse response, Boolean isUserAdmin) {
        TransactionType transType = new TransactionType();
        String userName = request.getRemoteUser();
        Users user = userManager.findUserByName(userName);
        boolean isSuper = user.getIsSuperUser();
        //boolean isAdmin2 = request.isUserInRole("admin");
        request.setAttribute("userIsSuper",  user.getIsSuperUser());
        request.setAttribute("userIsAdmin",  user.getIsAdmin() || user.getIsSuperUser());
//request.setAttribute("userIsAdmin",  isUserAdmin );
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_client.jsp");
        return transType;
    }

    public TransactionType DoAddClient(HttpServletRequest request, HttpServletResponse response) {
        Client client = null;
        String name = request.getParameter("name");
        String temp;
        int pmls = Integer.parseInt(request.getParameter("pmls"));
        int pmlo = Integer.parseInt(request.getParameter("pmlo"));
        int osco = Integer.parseInt(request.getParameter("osco"));
        int osho = Integer.parseInt(request.getParameter("osho"));
        temp = request.getParameter("oshu");
        int oshu = Integer.parseInt(temp);
        temp = request.getParameter("oscu");
        int oscu = Integer.parseInt(temp);
        temp = request.getParameter("pcu");
        int pcu = Integer.parseInt(temp);
        temp = request.getParameter("phu");
        int phu = Integer.parseInt(temp);
        temp = request.getParameter("pco");
        int pco = Integer.parseInt(temp);
        temp = request.getParameter("pho");
        int pho = Integer.parseInt(temp);
            
        boolean clientAdded = clientManager.addClient(name, pmls, pmlo, osco, oscu, osho, oshu, pco, pcu, pho, phu);
        if (clientAdded == false) {
            request.setAttribute("result", "<font color='red'>Add Client failed. Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>Client added successfully.</font>");
            Date sd = null;
            Date scd = null;
            int aes = 0, ags = 0, stde = 0, stdg = 0;
            int fe = Integer.parseInt(request.getParameter("fe"));
            int ae = Integer.parseInt(request.getParameter("ae"));
//            int aes = Integer.parseInt(request.getParameter("aes"));
//            int ags = Integer.parseInt(request.getParameter("ags"));
            Float ppk = Float.parseFloat(request.getParameter("ppk"));
            Float ppb = Float.parseFloat(request.getParameter("ppb"));
//            int stde = Integer.parseInt(request.getParameter("stde"));
//            int stdg = Integer.parseInt(request.getParameter("stdg"));
            try {
                client = clientManager.findClientByName(name);
            } catch (Exception e) {
                //Can't get a client id...
            }
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
//                scd = (Date) formatter.parse(request.getParameter("scd"));
                sd = (Date) formatter.parse(request.getParameter("startDate"));
            } catch (Exception e) {
                //Can't parse date
            }
            boolean financialAdded = financialManager.addFinancial(client, fe, ae, sd, aes, ags, ppk, ppb, stde, stdg, sd);
            if (financialAdded == false) {
                request.setAttribute("result", "<font color='red'>Add Financial failed. Please try again.</font>");
            } else {
                request.setAttribute("result", "<font color='green'>Financial added successfully.</font>");
            }
        }
        String userName = request.getRemoteUser();
        Users user = userManager.findUserByName(userName);
        request.setAttribute("userIsSuper",  user.getIsSuperUser());
        request.setAttribute("userIsAdmin",  user.getIsAdmin() || user.getIsSuperUser());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_client.jsp");
        return transType;
    }

    public TransactionType DoRemoveClient(HttpServletRequest request, HttpServletResponse response) {
        // also remove financial!
        String userName = request.getRemoteUser();
        Users user = userManager.findUserByName(userName);
        boolean isSuper = user.getIsSuperUser();
        //boolean isAdmin2 = request.isUserInRole("admin");
        if (isSuper) {
            String intStr = request.getParameter("clientid");
            if ((intStr != null) && (intStr != "null")) {
                int clientID = Integer.parseInt(intStr);
                boolean removed = clientManager.removeClient(clientID);
                if (removed) {
                    intStr = request.getParameter("financialid");
                    if ((intStr != null) && (intStr != "null")) {
                        int financialID = Integer.parseInt(intStr);
                        removed = financialManager.removeFinancial(financialID);
                        if (removed) {
    //                        request.setAttribute("result", "<font color='green'>Financial successfully removed.</font>");
                            request.setAttribute("result", "<font color='green'>Client successfully removed.</font>");
                        } else {
                            request.setAttribute("result", "<font color='red'>Client financial record remove failed.  Please try again.</font>");
                        }
                    }
                    request.setAttribute("financialList", financialFacade.findAll());
                } else {
                    request.setAttribute("result", "<font color='red'>Client remove failed.  There may be users or sites that refer to this enterprise.</font>");
                }
            }
        }
        List clientList = new ArrayList();
        if (user.getIsSuperUser())
            clientList = clientFacade.findAll();
        request.setAttribute("clientList", clientList);
        request.setAttribute("userIsSuper",  user.getIsSuperUser());
        request.setAttribute("userIsAdmin",  user.getIsAdmin() || user.getIsSuperUser());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_client.jsp");
        return transType;
    }

    public TransactionType DoEditClientUpdate(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getRemoteUser();
        Users user = userManager.findUserByName(userName);
        boolean isSuper = user.getIsSuperUser();
        Client client = null;
        Financial financial = null;
        int clientID = 0;
        String name = request.getParameter("name");
        int pmls = Integer.parseInt(request.getParameter("pmls"));
        int pmlo = Integer.parseInt(request.getParameter("pmlo"));
        int osco = Integer.parseInt(request.getParameter("osco"));
        int osho = Integer.parseInt(request.getParameter("osho"));
        int oshu = Integer.parseInt(request.getParameter("oshu"));
        int oscu = Integer.parseInt(request.getParameter("oscu"));
        int pcu = Integer.parseInt(request.getParameter("pcu"));
        int phu = Integer.parseInt(request.getParameter("phu"));
        int pco = Integer.parseInt(request.getParameter("pco"));
        int pho = Integer.parseInt(request.getParameter("pho"));
        clientID = Integer.parseInt(request.getParameter("id"));
        boolean clientEdited = clientManager.updateClient(clientID, name, pmls, pmlo, osco, oscu, osho, oshu, pco, pcu, pho, phu);
        if (clientEdited) {
            request.setAttribute("result", "<font color='green'>Client information updated successfully.</font>");
//            DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
            Date sd = null;
            Date scd = null;
            int aes = 0, ags = 0, stde = 0, stdg = 0;
            int fe = Integer.parseInt(request.getParameter("fe"));
            int ae = Integer.parseInt(request.getParameter("ae"));
//            aes = Integer.parseInt(request.getParameter("aes"));
//            ags = Integer.parseInt(request.getParameter("ags"));
            Float ppk = Float.parseFloat(request.getParameter("ppk"));
            Float ppb = Float.parseFloat(request.getParameter("ppb"));
            
//            stde = Integer.parseInt(request.getParameter("stde"));
//            stdg = Integer.parseInt(request.getParameter("stdg"));
            try {
                client = clientFacade.find(clientID);
            } catch (Exception e) {
                //Can't get a client id...
            }
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
//                scd = (Date) formatter.parse(request.getParameter("scd"));
                sd = (Date) formatter.parse(request.getParameter("startDate"));
            } catch (Exception e) {
                //Can't parse date
            }
            financial = financialManager.findFinancialByClientId(clientID);
            int financialID = financial.getIdtable1();

            boolean financialEdited = financialManager.updateFinancial(financialID, client, fe, ae, sd, aes, ags, ppk, ppb, stde, stdg, sd);
            if (financialEdited) {
                request.setAttribute("result", "<font color='green'>Financial information updated successfully.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Update financial record failed.  Please try again.</font>");
            }
            request.setAttribute("financialList", financialFacade.findAll());
        } else {
            request.setAttribute("result", "<font color='red'>Update Client failed.  Please try again.</font>");
            
        }
        List clientList = new ArrayList();
        if (user.getIsSuperUser())
            clientList = clientFacade.findAll();
        else if (client != null)
            clientList.add(client);
        request.setAttribute("clientList", clientList);
        request.setAttribute("userIsSuper",  user.getIsSuperUser());
        request.setAttribute("userIsAdmin",  user.getIsAdmin() || user.getIsSuperUser());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_client.jsp");
        return transType;
    }

    public TransactionType DoEditClient(HttpServletRequest request, HttpServletResponse response) {
        boolean showForm = false;
        String userName = request.getRemoteUser();
        Users user = userManager.findUserByName(userName);
        boolean isSuper = user.getIsSuperUser();
        String intStr = request.getParameter("clientid");
        if ((intStr != null) && (intStr != "null")) {
            int clientID = Integer.parseInt(intStr);
            Client client = null;
            client = clientManager.findClientById(clientID);
            if (client != null) {
                showForm = true;
                request.setAttribute("clientinfo", client);
                Financial financial =financialManager.findFinancialByClientId(client.getIdClient());
                if (financial != null) {
                    showForm = true;
                    request.setAttribute("financialinfo", financial);
                } else {
                    request.setAttribute("result", "<font color='red'>Client Financial edit failed. Please try again.</font>");
                }
            }
        }
        List clientList = new ArrayList();
        if (user.getIsSuperUser())
            clientList = clientFacade.findAll();
        request.setAttribute("clientList", clientList);
        
        request.setAttribute("financialList", financialFacade.findAll());
        request.setAttribute("showform", showForm);
        request.setAttribute("userIsSuper",  user.getIsSuperUser());
        request.setAttribute("userIsAdmin",  user.getIsAdmin() || user.getIsSuperUser());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_client.jsp");
        return transType;
    }
}
