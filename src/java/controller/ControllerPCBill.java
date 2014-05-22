/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Client;
import entity.PCBills;
import entity.Sites;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.PCBillsFacade;
import session.PCBillsManager;
import session.SitesFacade;
import session.SitesManager;

/**
 *
 * @author Jon Engelbert
 */
@Stateless
@LocalBean
public class ControllerPCBill {

    @EJB
    private PCBillsManager pcbillManager;
    @EJB
    private PCBillsFacade pcbillsFacade;
    @EJB
    private SitesFacade sitesFacade;
    @EJB
    private SitesManager sitesManager;
            
    public TransactionType DoSetupBill(HttpServletRequest request, HttpServletResponse response, int clientID) {
        List sitesList = new ArrayList();
        sitesList = sitesManager.findSitesByClientId(clientID);
        request.setAttribute("sitesList", sitesList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/pcentry.jsp");
        return transType;
    }
        
    public TransactionType DoRemoveBill(HttpServletRequest request, HttpServletResponse response, int clientID) {
        String intStr = request.getParameter("billid");
        String fuelTypeStr = request.getParameter("fuelType");
        if ((intStr != null) && (intStr != "null")) {
            int billID = Integer.parseInt(intStr);
            boolean removed = pcbillManager.removeBill(billID);
            if (removed) {
                request.setAttribute("result", "<font color='green'> PC Bill successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'> PC Bill remove failed.  Please try again.</font>");
            }
        }
        TransactionType transType = new TransactionType();
        List sitesList = new ArrayList();
        sitesList = sitesManager.findSitesByClientId(clientID);
        request.setAttribute("sitesList", sitesList);
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/pcbills.jsp");
        return transType;
    }

//    public TransactionType DoAddBill(HttpServletRequest request, HttpServletResponse response, int clientID)  {
//        String buildingStr = null;
//        Date billStart = null;
//        Date billEnd = null;
//        Date billDate = null;
//        float amount = 0;
//        String fuelType = "electric";
//        BigDecimal cost = null;
//        DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
//        Client client = null;
//        int siteID;
//
//        try {
//            buildingStr = request.getParameter("building");
//            String strBillStart = request.getParameter("billStart");
//            String strBillEnd = request.getParameter("billEnd");
//            String strAmount = request.getParameter("amount");
//            String strCost = request.getParameter("cost");
//            fuelType = request.getParameter("resource");
//            if ((buildingStr != null) && !buildingStr.isEmpty())
//                siteID = Integer.parseInt(buildingStr);
//                billStart = (Date) formatter.parse(strBillStart);
//                billEnd = (Date) formatter.parse(strBillEnd);
//            if ((strAmount != null) && !strAmount.isEmpty())
//                amount = Float.valueOf(strAmount).floatValue();
//            if ((strCost != null) && !strCost.isEmpty())
//                cost = new BigDecimal(strCost);
//        } catch (Exception e) {
//            Logger.getLogger(ControllerBill.class.getName()).log(Level.SEVERE, "Failed parsing bill.", e);
//        }
//        Integer buildingId = -1;
//        Integer pdfId = -1;
//        Sites sites = new Sites();
//        int retValue = -1;
//        if ((buildingStr != null) && !buildingStr.isEmpty() && (buildingStr != "null")) {
//            //                pdf = PDFmanager.storePdf(filename, contentType, fileSize, bytes);
//            buildingId = Integer.parseInt(buildingStr);
//            sites = sitesFacade.find(buildingId);
//            try {
//                retValue = pcbillManager.addBill(sites, billEnd, billStart, billEnd, fuelType, amount, cost);
//                
//            } catch (Exception e) {
//                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, "Attempted Add PC Bill");
//            }
//
//        }
//        List sitesList = new ArrayList();
//        sitesList = sitesManager.findSitesByClientId(clientID);
//        request.setAttribute("sitesList", sitesList);
//        TransactionType transType = new TransactionType();
//        transType.setReponse(response);
//        transType.setRequest(request);
//        transType.setRedirectionPath("/WEB-INF/view/pcentry.jsp");
//        return transType;
//    }

    public TransactionType DoEditBills(HttpServletRequest request, HttpServletResponse response, int clientID) {
        List sitesList = new ArrayList();
        sitesList = sitesFacade.findAll();
        sitesList = sitesManager.findSitesByClientId(clientID);
        request.setAttribute("sitesList", sitesList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/pcbills.jsp");
        return transType;
    }
    
    public TransactionType DoEditBill(HttpServletRequest request, HttpServletResponse response, int clientID) {
        PCBills currBill;
        String idStr = request.getParameter("billid");
        Integer billId = Integer.parseInt(idStr);
        currBill = pcbillsFacade.find(billId);
        request.setAttribute("bill", currBill);
        List sitesList = new ArrayList();
        sitesList = sitesManager.findSitesByClientId(clientID);
        request.setAttribute("sitesList", sitesList);
        request.setAttribute("billInfo", currBill);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/pcbill_edit.jsp");
        return transType;
    }

    public TransactionType DoEditBillUpdate(HttpServletRequest request, HttpServletResponse response, int clientID) {
        String idStr = request.getParameter("billid");
        Integer billid = Integer.parseInt(idStr);
        float amount = 0;
        BigDecimal cost = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
            Date billStart = (Date) formatter.parse(request.getParameter("billStart"));
            Date billEnd = (Date) formatter.parse(request.getParameter("billEnd"));
            //Date billDate = (Date) formatter.parse(request.getParameter("billDate"));
            String strAmount = request.getParameter("amount");
            String strCost = request.getParameter("cost");
            String fuelType = request.getParameter("resource");
            String siteIDstr = request.getParameter("building");
            Integer  siteId = Integer.parseInt(siteIDstr);
            Sites site = sitesFacade.find(siteId);
            if ((strAmount != null) && !strAmount.isEmpty())
                amount = Float.valueOf(strAmount).floatValue();
            if ((strCost != null) && !strCost.isEmpty())
                cost = new BigDecimal(strCost);

            Integer meterId = -1;
            boolean billUpdate = pcbillManager.updateBill(billid, site, billStart, billEnd, fuelType, amount, cost);
            if (billUpdate) {
                request.setAttribute("result", "<font color='green'>PC Bill updated successfully.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Update PC bill failed.  Please try again.</font>");
            }  
            List sitesList = new ArrayList();
            sitesList = sitesManager.findSitesByClientId(clientID);
            request.setAttribute("sitesList", sitesList);
        } catch (Exception e) {
            Logger.getLogger(ControllerPCBill.class.getName()).log(Level.SEVERE, "Failed parsing PC bill update: " + idStr, e);
        }
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/pcbills.jsp");
        return transType;
    }
}
