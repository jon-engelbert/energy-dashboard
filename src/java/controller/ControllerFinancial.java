/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Client;
import entity.Financial;
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

@Stateless
@LocalBean
public class ControllerFinancial {
    @EJB
    private ClientFacade clientFacade;
    @EJB
    private ClientManager clientManager;
    @EJB
    private FinancialFacade financialFacade;
    @EJB
    private FinancialManager financialManager;

    public TransactionType DoSetupFinancial(HttpServletRequest request, HttpServletResponse response) {
        TransactionType transType = new TransactionType();
        request.setAttribute("clientList", clientFacade.findAll());
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_financial.jsp");
        return transType;
    }

    public TransactionType DoAddFinancial(HttpServletRequest request, HttpServletResponse response) {
        Client client = null;
        Date sd = null;
        Date scd = null;
        int fe = Integer.parseInt(request.getParameter("fe"));
        int ae = Integer.parseInt(request.getParameter("ae"));
        int aes = Integer.parseInt(request.getParameter("aes"));
        int ags = Integer.parseInt(request.getParameter("ags"));
        Float ppk = Float.parseFloat(request.getParameter("ppk"));
        Float ppb = Float.parseFloat(request.getParameter("ppb"));
        int stde = Integer.parseInt(request.getParameter("stde"));
        int stdg = Integer.parseInt(request.getParameter("stdg"));
        try {
            client = clientFacade.find(Integer.parseInt(request.getParameter("clientID")));
        } catch (Exception e) {
            //Can't get a client id...
        }
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
            scd = (Date) formatter.parse(request.getParameter("scd"));
            sd = (Date) formatter.parse(request.getParameter("sd"));
        } catch (Exception e) {
            //Can't parse date
        }
        boolean financialAdded = financialManager.addFinancial(client, fe, ae, sd, aes, ags, ppk, ppb, stde, stdg, scd);
        if (financialAdded == false) {
            request.setAttribute("result", "<font color='red'>Add Financial failed. Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>Financial added successfully.</font>");
        }
        request.setAttribute("clientList", clientFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_financial.jsp");
        return transType;
    }

    public TransactionType DoRemoveFinancial(HttpServletRequest request, HttpServletResponse response) {
        String intStr = request.getParameter("financialid");
        if ((intStr != null) && (intStr != "null")) {
            int financialID = Integer.parseInt(intStr);
            boolean removed = financialManager.removeFinancial(financialID);
            if (removed) {
                request.setAttribute("result", "<font color='green'>Financial successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Financial remove failed.  Please try again.</font>");
            }
        }
        request.setAttribute("financialList", financialFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_financial.jsp");
        return transType;
    }

    public TransactionType DoEditFinancialUpdate(HttpServletRequest request, HttpServletResponse response) {
        Client client = null;
        Date sd = null;
        Date scd = null;
        int fe = Integer.parseInt(request.getParameter("fe"));
        int ae = Integer.parseInt(request.getParameter("ae"));
        int aes = Integer.parseInt(request.getParameter("aes"));
        int ags = Integer.parseInt(request.getParameter("ags"));
        Float ppk = Float.parseFloat(request.getParameter("ppk"));
        Float ppb = Float.parseFloat(request.getParameter("ppb"));
        int stde = Integer.parseInt(request.getParameter("stde"));
        int stdg = Integer.parseInt(request.getParameter("stdg"));
        try {
            client = clientFacade.find(Integer.parseInt(request.getParameter("clientID")));
        } catch (Exception e) {
            //Can't get a client id...
        }
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
            scd = (Date) formatter.parse(request.getParameter("scd"));
            sd = (Date) formatter.parse(request.getParameter("sd"));
        } catch (Exception e) {
            //Can't parse date
        }
        int financialID = Integer.parseInt(request.getParameter("financialID"));
        
        boolean financialAdded = financialManager.updateFinancial(financialID, client, fe, ae, sd, aes, ags, ppk, ppb, stde, stdg, scd);
        if (financialAdded) {
            request.setAttribute("result", "<font color='green'>Financial information updated successfully.</font>");
        } else {
            request.setAttribute("result", "<font color='red'>Update financial record failed.  Please try again.</font>");
        }
        request.setAttribute("clientList", clientFacade.findAll());
        request.setAttribute("financialList", financialFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_financial.jsp");
        return transType;
    }

    public TransactionType DoEditFinancial(HttpServletRequest request, HttpServletResponse response) {
        boolean showForm = false;
        String intStr = request.getParameter("financialid");
        if ((intStr != null) && (intStr != "null")) {
            int financialID = Integer.parseInt(intStr);
            Financial financial = null;
            financial = financialManager.findFinancialById(financialID);
            if (financial != null) {
                showForm = true;
                request.setAttribute("financialinfo", financial);
            } else {
                request.setAttribute("result", "<font color='red'>Financial edit failed. Please try again.</font>");
            }
        }
        request.setAttribute("financialList", financialFacade.findAll());
        request.setAttribute("clientList", clientFacade.findAll());        
        request.setAttribute("showform", showForm);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_financial.jsp");
        return transType;
    }
}
