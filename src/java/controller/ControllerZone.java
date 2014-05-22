/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Client;
import entity.Sites;
import entity.Zones;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.*;

/**
 *
 * @author jon
 */
@Stateless
@LocalBean
public class ControllerZone {

    @EJB
    private ClientFacade clientFacade;
    @EJB
    private ZoneManager zoneManager;
    @EJB
    private SitesFacade sitesFacade;
    @EJB
    private ZonesFacade zonesFacade;
    @EJB
    private SitesManager siteManager;

    public TransactionType DoSetupZone(HttpServletRequest request, HttpServletResponse response) {
        List sitesList = new ArrayList();
        Sites currSite;
        sitesList = sitesFacade.findAll();
        request.setAttribute("sitesList", sitesList);

        List zonesList = new ArrayList();
        Zones currZone;
        zonesList = zonesFacade.findAll();
        request.setAttribute("zonesList", zonesList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_zone.jsp");
        return transType;
    }

    public TransactionType DoRemoveZone(HttpServletRequest request, HttpServletResponse response) {
        String intStr = request.getParameter("zoneid");
        if (intStr != null) {
            int zoneID = Integer.parseInt(intStr);
            boolean removed = zoneManager.removeZone(zoneID);
            if (removed) {
                request.setAttribute("result", "<font color='green'>Zone successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Zone remove failed.  Please try again.</font>");
            }
        }
        request.setAttribute("zones", zonesFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_zone.jsp");
        return transType;
    }

    public TransactionType DoAddZone(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("zname");
        String strBuilding = request.getParameter("zbuilding");
        String strParentZone = request.getParameter("zparent");
        int idBuilding = -1;
        int parentZoneID = -1;
        String sqft = request.getParameter("zsqft");
        int nSqFt = Integer.parseInt(sqft);
        String pop = request.getParameter("zpop");
        int nPop = Integer.parseInt(pop);
        Sites building = null;
        if (strBuilding != null) {
            idBuilding = Integer.parseInt(strBuilding);
            building = siteManager.findSiteById(idBuilding);
        }
        Zones parentZone = null;
        if ((strParentZone != null) && (!strParentZone.isEmpty())) {
            parentZoneID = Integer.parseInt(strParentZone);
            parentZone = zoneManager.findZoneById(parentZoneID);
        }

//            if (!parentZone.equals(null))
        String zoneAdded = zoneManager.addZone(name, nPop, nSqFt, building, parentZone);
        if (zoneAdded.equals("false")) {
            request.setAttribute("result", "<font color='red'>Add Zone failed.  Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>Zone " + zoneAdded + " added successfully.</font>");
        }
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_zone.jsp");
        return transType;
    }

    public TransactionType DoEditZone(HttpServletRequest request, HttpServletResponse response) {
        boolean showForm = false;
        String intStr = request.getParameter("zoneid");
        if (intStr != null) {
            int zoneID = Integer.parseInt(intStr);
            Zones zone = null;
            List siteList = new ArrayList();
            List zoneList = new ArrayList();
            siteList = sitesFacade.findAll();
            zoneList = zonesFacade.findAll();
            zone = zoneManager.findZoneById(zoneID);
            if (zone != null) {
                showForm = true;
                request.setAttribute("zoneinfo", zone);
                request.setAttribute("zoneList", zoneList);
                request.setAttribute("siteList", siteList);
            } else {
                request.setAttribute("result", "<font color='red'>Zone edit failed. Please try again.</font>");
            }
        }
        request.setAttribute("zones", zonesFacade.findAll());
        request.setAttribute("showform", showForm);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_zone.jsp");
        return transType;
    }

    public TransactionType DoEditZoneUpdate(HttpServletRequest request, HttpServletResponse response, int clientID) {
        int id = Integer.parseInt(request.getParameter("zid"));
        String name = request.getParameter("zname");
        int parentSiteID = Integer.parseInt(request.getParameter("zbuilding"));
        String parentZoneID = request.getParameter("zparent");
        int nPeople = Integer.parseInt(request.getParameter("zpop"));
        String sSqft = request.getParameter("zsqft");
        int nSqFt = Integer.parseInt(sSqft);
        Client client = null;
        try {
            client = clientFacade.find(clientID);
        } catch (Exception e) {
        }
        Sites parentSite = null;
        Zones parentZone = null;
        try {
            parentSite = sitesFacade.find(parentSiteID);
            parentZone = zonesFacade.find(Integer.parseInt(parentZoneID));
        } catch (Exception e) {
            //Do nothing
            parentZone = null;
        }
        //Integer zoneID, String name, int nPeople, int sqFt, Sites parentSite, Zones parentZone)
        boolean zoneUpdated = zoneManager.updateZone(id, name, nPeople, nSqFt, parentSite, parentZone);
        if (zoneUpdated) {
            request.setAttribute("result", "<font color='green'>Zone " + name + " updated sucessfully.</font>");
        } else {
            request.setAttribute("result", "<font color='red'>Zone update failed. Please try again.</font>");
        }
        request.setAttribute("zones", zonesFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_zone.jsp");
        return transType;
    }
}
