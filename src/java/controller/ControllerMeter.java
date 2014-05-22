/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Client;
import entity.Meters;
import entity.Sites;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ClientFacade;
import session.MetersFacade;
import session.MetersManager;
import session.SitesFacade;
import session.SitesManager;

/**
 *
 * @author jon
 */
@Stateless
@LocalBean
public class ControllerMeter {

    @EJB
    private ClientFacade clientFacade;
    @EJB
    private SitesFacade sitesFacade;
    @EJB
    private SitesManager sitesManager;
    @EJB
    private MetersFacade meterFacade;
    @EJB
    private MetersManager meterManager;

    public TransactionType DoSetupMeter(HttpServletRequest request, HttpServletResponse response, int clientID) {
        List sitesList = new ArrayList();
        sitesList = sitesManager.findSitesByClientId(clientID);
//        sitesList = sitesFacade.findAll();
        request.setAttribute("sitesList", sitesList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_meter.jsp");
        return transType;
    }

    public TransactionType DoAddMeter(HttpServletRequest request, HttpServletResponse response, int clientID) {
        Client client = null;
//        Sites site = null;
        try {
            client = clientFacade.find(clientID);
        } catch (Exception e) {
        }
        String siteString = request.getParameter("building");
        int siteID;
        if ((siteString != null) && !siteString.isEmpty()) {
            siteID = Integer.parseInt(request.getParameter("building"));
            String accountNum = request.getParameter("accountNum");
            String providerName = request.getParameter("providerName");
            String textID = request.getParameter("textID");
            String resource = request.getParameter("resource");
            int meterAdded = meterManager.addMeter(resource, siteID, textID, accountNum, providerName);
            if (meterAdded == -1) {
                request.setAttribute("result", "<font color='red'>Add Meter failed.  Please try again.</font>");
            } else {
                request.setAttribute("result", "<font color='green'>Meter added successfully.</font>");
            }
        }
        List sitesList = new ArrayList();
        sitesList = sitesManager.findSitesByClientId(clientID);
        request.setAttribute("sitesList", sitesList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_meter.jsp");
        return transType;
    }

    public TransactionType DoRemoveMeter(HttpServletRequest request, HttpServletResponse response, int clientID) {
        Integer meterID = Integer.parseInt(request.getParameter("meterid"));
        if (meterID != null) {
            boolean removed = meterManager.removeMeter(meterID);
            if (removed) {
                request.setAttribute("result", "<font color='green'>Meter successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Meter remove failed.  Please try again.</font>");
            }
        }
        request.setAttribute("meterList", meterManager.findMeterByClientId(clientID));
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_meter.jsp");
        return transType;
    }

    public TransactionType DoEditMeterUpdate(HttpServletRequest request, HttpServletResponse response, int clientID) {
        Client client = null;
        Sites site = null;
        try {
            client = clientFacade.find(clientID);
        } catch (Exception e) {
        }
        int siteID = Integer.parseInt(request.getParameter("building"));
        Integer meterID = Integer.parseInt(request.getParameter("meterid"));
        String accountNum = request.getParameter("accountNum");
        String providerName = request.getParameter("providerName");
        String textID = request.getParameter("textID");
        String resource = request.getParameter("resource");
        boolean meterUpdate = meterManager.updateMeter(meterID, resource, siteID, textID, accountNum, providerName);
        if (meterUpdate) {
            request.setAttribute("result", "<font color='green'>Meter updated successfully.</font>");
        } else {
            request.setAttribute("result", "<font color='red'>Update meter failed.  Please try again.</font>");
        }
        request.setAttribute("meterList", meterManager.findMeterByClientId(clientID));
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_meter.jsp");
        return transType;
    }

    public TransactionType DoEditMeter(HttpServletRequest request, HttpServletResponse response, int clientID) {
        boolean showForm = false;
        String intStr = request.getParameter("meterid");
        if ((intStr != null) && (intStr != "null")) {
            int meterID = Integer.parseInt(intStr);
            Meters meter = null;
            List sitesList = new ArrayList();
            sitesList = sitesManager.findSitesByClientId(clientID);
            meter = meterManager.findMeterById(meterID);
            if (meter != null) {
                showForm = true;
                request.setAttribute("sitesList", sitesList);
                request.setAttribute("meterinfo", meter);

            } else {
                request.setAttribute("result", "<font color='red'>Meter edit failed. Please try again.</font>");
            }
        }
        List metersList = meterManager.findMeterByClientId(clientID);        
        request.setAttribute("meterList", metersList);
        request.setAttribute("showform", showForm);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_meter.jsp");
        return transType;
    }
}
