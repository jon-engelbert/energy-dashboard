/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Client;
import entity.Schedule;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ClientFacade;
import session.ScheduleFacade;
import session.ScheduleManager;

/**
 *
 * @author worman
 */
@Stateless
@LocalBean
public class ControllerSchedule {

    @EJB
    private ClientFacade clientFacade;
    @EJB
    private ScheduleManager scheduleManager;
    @EJB
    private ScheduleFacade scheduleFacade;

    public TransactionType DoAddSchedule(HttpServletRequest request, HttpServletResponse response, int clientID) {
        String schName;
        int schMon = 0, schTue = 0, schWed = 0, schTh = 0, schFri, schSat, schSun;
        Client client = new Client();
        try {
            schName = request.getParameter("sname");
            schMon = Integer.parseInt(request.getParameter("smon"));
            schTue = Integer.parseInt(request.getParameter("stues"));
            schWed = Integer.parseInt(request.getParameter("swed"));
            schTh = Integer.parseInt(request.getParameter("sth"));
            schFri = Integer.parseInt(request.getParameter("sfri"));
            schSat = Integer.parseInt(request.getParameter("ssat"));
            schSun = Integer.parseInt(request.getParameter("ssun"));
            client = clientFacade.find(clientID);
//        String strIsOnWhenDark = request.getParameter("sIsOnWhenDark");
//        Boolean isOnWhenDark = false;
//        if (strIsOnWhenDark != null) {
//            isOnWhenDark = (strIsOnWhenDark.equalsIgnoreCase("on"));
//        }
            String schedName = scheduleManager.addSchedule(schName, schMon, schTue, schWed, schTh, schFri, schSat, schSun, client);
            if (schedName == null) {
                request.setAttribute("result", "<font color='red'>Add schedule failed. Please try again.</font>");
            } else {
                request.setAttribute("result", "<font color='green'>Schedule added successfully.</font>");
            }
        } catch (Exception e) {
            Logger.getLogger(ControllerSchedule.class.getName()).log(Level.SEVERE, "Failed parsing Schedule update.", e);
        }
            

        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_schedule.jsp");
        return transType;
    }

    public TransactionType DoRemoveSchedule(HttpServletRequest request, HttpServletResponse response, int clientID) {
        String intStr = request.getParameter("scheduleid");
        if ((intStr != null) && (intStr != "null")) {
            int scheduleID = Integer.parseInt(intStr);
            boolean removed = scheduleManager.removeSchedule(scheduleID);
            if (removed) {
                request.setAttribute("result", "<font color='green'>Schedule successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Schedule remove failed.  Please try again.</font>");
            }
        }
        request.setAttribute("scheduleList", scheduleManager.findSchedulesByClientId(clientID));
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_schedule.jsp");
        return transType;
    }

    public TransactionType DoEditSchedule(HttpServletRequest request, HttpServletResponse response, int clientID) {
        boolean showForm = false;
        String intStr = request.getParameter("scheduleid");
        if ((intStr != null) && (intStr != "null")) {
            int scheduleID = Integer.parseInt(intStr);
            Schedule schedule = null;
            schedule = scheduleManager.findScheduleByID(scheduleID);
            if (schedule != null) {
                showForm = true;
                request.setAttribute("scheduleinfo", schedule);
            } else {
                request.setAttribute("result", "<font color='red'>Schedule edit failed. Please try again.</font>");

            }
        }
        //request.setAttribute("scheduleList", scheduleFacade.findAll());
        request.setAttribute("scheduleList", scheduleManager.findSchedulesByClientId(clientID));
        request.setAttribute("showform", showForm);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_schedule.jsp");
        return transType;
    }

    public TransactionType DoEditScheduleUpdate(HttpServletRequest request, HttpServletResponse response) {
        String name;
        int monHours = 0, tuesHours = 0, wedHours = 0, thHours = 0, friHours = 0, satHours = 0, sunHours = 0;
        Client client = new Client();
        try {
            int id = Integer.parseInt(request.getParameter("scheduleid"));
            name = request.getParameter("sname");
            monHours = Integer.parseInt(request.getParameter("smon"));
            tuesHours = Integer.parseInt(request.getParameter("stues"));
            wedHours = Integer.parseInt(request.getParameter("swed"));
            thHours = Integer.parseInt(request.getParameter("sth"));
            friHours = Integer.parseInt(request.getParameter("sfri"));
            satHours = Integer.parseInt(request.getParameter("ssat"));
            sunHours = Integer.parseInt(request.getParameter("ssun"));
//        String strIsOnWhenDark = request.getParameter("sIsOnWhenDark");
//        Boolean isOnWhenDark = false;
//        if (strIsOnWhenDark != null) {
//            isOnWhenDark = (strIsOnWhenDark.equalsIgnoreCase("on"));
//        }
            boolean scheduleUpdated = scheduleManager.updateSchedule(id, name, monHours, tuesHours, wedHours, thHours, friHours, satHours, sunHours);   // add later? , nVacationDaysPerYear);
            if (scheduleUpdated) {
                request.setAttribute("result", "<font color='green'>Schedule " + name + " updated sucessfully.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Schedule update failed. Please try again.</font>");
            }
        } catch (Exception e) {
            Logger.getLogger(ControllerSchedule.class.getName()).log(Level.SEVERE, "Failed parsing Schedule update", e);
        }
        request.setAttribute("scheduleList", scheduleFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_schedule.jsp");
        return transType;
    }
}
