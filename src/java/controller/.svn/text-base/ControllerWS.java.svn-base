/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Weatherstation;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.WeatherstationFacade;
import session.weatherManager;

/**
 *
 * @author Engel-less
 */
@Stateless
@LocalBean
public class ControllerWS {

    @EJB
    private WeatherstationFacade wsFacade;
    @EJB
    private weatherManager wsManager;

    public TransactionType DoSetupWS(HttpServletRequest request, HttpServletResponse response) {
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setupWS.jsp");
        return transType;
    }

    public TransactionType DoAddWS(HttpServletRequest request, HttpServletResponse response) {
        String wsName = request.getParameter("wsName");
        int tBase =  Integer.parseInt(request.getParameter("tBase"));
        int HDDannual =  Integer.parseInt(request.getParameter("HDDannual"));
        int CDDannual =  Integer.parseInt(request.getParameter("CDDannual"));
        float HDDsens =  Integer.parseInt(request.getParameter("HDDsens"));
        float CDDsens =  Integer.parseInt(request.getParameter("CDDsens"));
        float HDDsens2 =  Float.parseFloat(request.getParameter("HDDsens2"));
        float CDDsens2 =  Float.parseFloat(request.getParameter("CDDsens2"));
        int wsAdded = wsManager.addWS(wsName, tBase, HDDannual, HDDsens, HDDsens2, CDDannual, CDDsens, CDDsens2);
        if (wsAdded <= 0) {
            request.setAttribute("result", "<font color='red'>Add WS failed.  Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>WS added successfully.</font>");
        }
        
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setupWS.jsp");
        return transType;
    }

    public TransactionType DoRemoveWS(HttpServletRequest request, HttpServletResponse response) {
        Integer wsID = Integer.parseInt(request.getParameter("wsid"));
        if (wsID != null) {
            boolean removed = wsManager.removeWS(wsID);
            if (removed) {
                request.setAttribute("result", "<font color='green'>Weather Station successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Weather Station remove failed.  Please try again.</font>");
            }
        }
        request.setAttribute("wsList", wsFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_ws.jsp");
        return transType;
    }

    public TransactionType DoEditWSUpdate(HttpServletRequest request, HttpServletResponse response) {
        int wsID = -1;
        String intStr = request.getParameter("weatherstationid");
        if ((intStr != null) && (intStr != "null")) 
            wsID = Integer.parseInt(intStr);
        
        String wsName = request.getParameter("wsName");
        int tBase =  Integer.parseInt(request.getParameter("tBase") );
        int HDDannual =  Integer.parseInt(request.getParameter("HDDannual"));
        int CDDannual =  Integer.parseInt(request.getParameter("CDDannual"));
        float HDDsens =  Float.parseFloat(request.getParameter("HDDsens"));
        float CDDsens =  Float.parseFloat(request.getParameter("CDDsens"));
        float HDDsens2 =  Float.parseFloat(request.getParameter("HDDsens2"));
        float CDDsens2 =  Float.parseFloat(request.getParameter("CDDsens2"));
        boolean wsUpdate = wsManager.updateWS(wsID, wsName, tBase, HDDannual, HDDsens, HDDsens2, CDDannual, CDDsens, CDDsens2);
        if (wsUpdate) {
            request.setAttribute("result", "<font color='green'>weather station updated successfully.</font>");
        } else {
            request.setAttribute("result", "<font color='red'>Update weather station failed.  Please try again.</font>");
        }
        request.setAttribute("wsList", wsFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_ws.jsp");
        return transType;
    }

    public TransactionType DoEditWS(HttpServletRequest request, HttpServletResponse response) {
        boolean showForm = false;
        String intStr = request.getParameter("wsid");
        if ((intStr != null) && (intStr != "null")) {
            int wsID = Integer.parseInt(intStr);
            Weatherstation ws = null;
            ws = wsManager.findWeatherstationById(wsID);
            if (ws != null) {
                showForm = true;
                request.setAttribute("wsinfo", ws);
            } else {
                request.setAttribute("result", "<font color='red'>weather station edit failed. Please try again.</font>");
            }
        }
        request.setAttribute("wsList", wsFacade.findAll());
        request.setAttribute("showform", showForm);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_ws.jsp");
        return transType;
    }
}
