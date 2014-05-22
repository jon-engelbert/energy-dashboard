/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bills;
import entity.Meters;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BillManager;
import session.BillsFacade;
import session.MetersFacade;

/**
 *
 * @author jon
 */
@Stateless
@LocalBean
public class ControllerBill {

    @EJB
    private BillManager billManager;
    @EJB
    private BillsFacade billsFacade;
    @EJB
    private MetersFacade metersFacade;

//    public TransactionType DoAddBill(HttpServletRequest request, HttpServletResponse response, int clientID) {
//        Meters gMeter;
//        String buildingStr = null;
//        Date billStart = null;
//        Date billEnd = null;
//        Date billDate = null;
//        float amount = 0;
//        Integer readStart = null;
//        Integer readEnd = null;
//        float demand = 0;
//        float peakDemand = 0;
//        float powerFactor = 0;
//        float kva = 0;
//        float loadFactor = 0;
//        BigDecimal cost = null;
//        BigDecimal costDemand = null;
//        BigDecimal costUsage = null;
//        BigDecimal costDistDemand = null;
//        BigDecimal costDistUsage = null;
//        BigDecimal surchargeAsPercent = null;
//        BigDecimal taxAmount = null;
//        Integer usageThreshold = null;
//        BigDecimal costAboveThreshold = null;
//        Integer offPeakEnergy = null;
//        BigDecimal offPeakDiscount = null;
//        String fuelType = "electric";
//        DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
//        int meterId;
//
//        String strBillDate = request.getParameter("billDate");
//        String meterIdStr = request.getParameter("meterNumber");
//        String strBillStart = request.getParameter("billStart");
//        String strBillEnd = request.getParameter("billEnd");
//        String strAmount = request.getParameter("amount");
//        String strCost = request.getParameter("cost");
//        fuelType = request.getParameter("resource");
//        try {
//            billDate = (Date) formatter.parse(strBillDate);
//            billStart = (Date) formatter.parse(strBillStart);
//            billEnd = (Date) formatter.parse(strBillEnd);
//        } catch (Exception e) {
//            //Can't parse date
//        }
//        if ((strAmount != null) && !strAmount.isEmpty())
//            amount = Float.valueOf(strAmount).floatValue();
//        if ((strCost != null) && !strCost.isEmpty())
//            cost = new BigDecimal(strCost);
//        Integer buildingId = -1;
//        Integer pdfId = -1;
//        int retValue = -1;
//        if ((meterIdStr != null) && !meterIdStr.isEmpty() && (meterIdStr != "null")) {
//            //                pdf = PDFmanager.storePdf(filename, contentType, fileSize, bytes);
//            meterId = Integer.parseInt(meterIdStr);
//            gMeter = metersFacade.find(meterId);
//            try {
//            retValue = billManager.addBill(gMeter, billStart, billEnd, readStart, readEnd, amount,
//                    cost, demand, peakDemand, powerFactor, kva, loadFactor, costDemand, costUsage, costDistDemand,
//                    costDistUsage, surchargeAsPercent, taxAmount, usageThreshold, costAboveThreshold, offPeakEnergy, offPeakDiscount);
//                
//            } catch (Exception e) {
//                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, "Attempted Add PC Bill");
//            }
//
//        }
////        List sitesList = new ArrayList();
////        sitesList = sitesManager.findSitesByClientId(clientID);
////        request.setAttribute("sitesList", sitesList);
//        TransactionType transType = new TransactionType();
//        transType.setReponse(response);
//        transType.setRequest(request);
//        transType.setRedirectionPath("/WEB-INF/view/pcentry.jsp");
//        return transType;
//    }
//

    public TransactionType DoGetBills(HttpServletRequest request, HttpServletResponse response) {

        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_building.jsp");
        return transType;
    }

    public TransactionType DoRemoveBill(HttpServletRequest request, HttpServletResponse response, int clientID) {
        String intStr = request.getParameter("billid");
        String meterTypeStr = request.getParameter("meterType");
        String meterNumStr = request.getParameter("meterNum");
        if ((intStr != null) && (intStr != "null")) {
            int billID = Integer.parseInt(intStr);
            boolean removed = billManager.removeBill(billID);
            if (removed) {
                request.setAttribute("result", "<font color='green'>" + meterTypeStr + " Bill successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>" + meterTypeStr + " Bill remove failed.  Please try again.</font>");
            }
        }
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/bills.jsp");
        return transType;
    }

    public TransactionType DoEditBill(HttpServletRequest request, HttpServletResponse response) {
        Bills currBill;
        String idStr = request.getParameter("billid");
        Integer billId = Integer.parseInt(idStr);
        String meterTypeStr = request.getParameter("meterType");
        String meterNumStr = request.getParameter("meterNum");
        currBill = billsFacade.find(billId);
        request.setAttribute("bill", currBill);
        request.setAttribute("meterType", meterTypeStr);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/bill_edit_elec.jsp");
//        if (meterTypeStr.equals("Electric")) {
//            transType.setRedirectionPath("/WEB-INF/view/bill_edit_elec.jsp");
//        } 
//        else if (meterTypeStr.equals("Natual Gas")) {
//            transType.setRedirectionPath("/WEB-INF/view/bill_edit_natgas.jsp");
//        } else if (meterTypeStr.equals("Propane")) {
//           transType.setRedirectionPath("/WEB-INF/view/bill_edit_prop.jsp");
//        } else if (meterTypeStr.equals("Waste")) {
//            transType.setRedirectionPath("/WEB-INF/view/bill_edit_waste.jsp");
//        } else if (meterTypeStr.equals("Water")) {
//            transType.setRedirectionPath("/WEB-INF/view/bill_edit_water.jsp");
//        } 
        return transType;
    }

    public TransactionType DoEditBillUpdate(HttpServletRequest request, HttpServletResponse response, int clientID) {
        String idStr = request.getParameter("billid");
        Integer billid = Integer.parseInt(idStr);
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");
            Date billStart = (Date) formatter.parse(request.getParameter("billStart"));
            Date billEnd = (Date) formatter.parse(request.getParameter("billEnd"));
            Date billDate = (Date) formatter.parse(request.getParameter("billDate"));
            float amount = Float.valueOf(request.getParameter("amount"));
            BigDecimal cost =  new BigDecimal(request.getParameter("cost"));
            Integer meterId = -1;
            boolean billUpdate = billManager.updateBill(billid, billDate, billStart, billEnd, meterId, meterId, amount, cost, amount, amount, amount, amount, amount, cost, cost, cost, cost, cost, cost, meterId, cost, meterId, cost);
            if (billUpdate) {
                request.setAttribute("result", "<font color='green'>Bill updated successfully.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Update bill failed.  Please try again.</font>");
            }  
        } catch (Exception e) {
            Logger.getLogger(ControllerBill.class.getName()).log(Level.SEVERE, "Failed parsing bill update: " + idStr, e);
        }
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/bills.jsp");
        return transType;
    }
}
