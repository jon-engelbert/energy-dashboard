/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import org.apache.commons.io.IOUtils;
import session.*;
//import sun.misc.IOUtils;

/**
 *
 * @author thien
 */
@WebServlet(name = "ControllerServlet",
loadOnStartup = 1,
urlPatterns = {
    "/add_building",
    "/add_bill",
    "/add_circuit",
    "/add_client",
    "/add_energy",
    "/add_financial",
    "/add_meter",
    "/add_panel",
    "/add_pcbill",
    "/add_schedule",
    "/add_user",
    "/add_new_user",
    "/add_zone",
    "/add_ws",
    "/admin",
    "/alerts",
    "/bill_edit",
    "/bill_viewImg",
    "/bills",
    "/dashboard",
    "/dashboard_recalc",
    "/dashboard_recalcByBuilding",
    "/edit_zone",
    "/edit_zone_remove",
    "/edit_zone_update",
    "/edit_client",
    "/edit_client_remove",
    "/edit_client_update",
    "/edit_financial",
    "/edit_financial_update",
    "/edit_financial_remove",
    "/edit_bills",
    "/edit_bill",
    "/edit_bill_remove",
    "/edit_bill_update",    
    "/edit_meter",
    "/edit_meter_update",
    "/edit_meter_remove",
    "/edit_pcbills",
    "/edit_pcbill",
    "/edit_pcbill_remove",
    "/edit_pcbill_update",
    "/edit_building",
    "/edit_building_update",
    "/edit_building_remove",
    "/edit_energy",
    "/edit_energy_update",
    "/edit_energy_remove",
    "/edit_schedule",
    "/edit_schedule_update",
    "/edit_schedule_remove",
    "/edit_user",
    "/edit_user_remove",
    "/edit_user_update",
    "/edit_ws",
    "/edit_ws_update",
    "/edit_ws_remove",
    "/entry",
    "/getBills",
    "/getBuildingSetPoints",
    "/getMeterInfo",
    "/getSiteList",
    "/getPCBills",
    "/getPCBillsInfo",
    "/getMeters",
    "/graphs_addseries",
    "/graphs_addserieselectric",
    "/graphs_addseriesgas",
    "/graphs_addseriesbyyear",
    "/graphs_monthlyEnergyCosts",
    "/graphs_addseriesbymonth",    
    "/graphs_addseriesbymonthyear",    
    "/hvac",
    "/lighting",
    "/parseweather",
    "/reports",
    "/scenario",
    "/sendPolicy",
    "/sendPolicyBuilding",
    "/setup_building",
    "/setup_energy",
    "/setup_circuits",
    "/setup_client",
    "/setup_entry",
    "/setup_equip",
    "/setup_financial",
    "/setup_limits",
    "/setup_meter",
    "/setup_multibranch",
    "/setup_panel",
    "/setup_pcentry",
    "/setup_schedule",
    "/setup_tenants",
    "/setup_user",
    "/setup_new_user",
    "/setup_ws",
    "/setup_zone",
    "/storeBill",
    "/tenant",
    "/test",
    "/updateCircuitBySite",
    "/sign_off"
})
public class ControllerServlet extends HttpServlet {

    @EJB
    private ClientFacade clientFacade;
    @EJB
    private PanelFacade panelFacade;
    @EJB
    private ZonesFacade zonesFacade;
    @EJB
    private SitesFacade sitesFacade;
    @EJB
    private SitesManager sitesManager;
    @EJB
    private MetersFacade metersFacade;
    @EJB
    private UserManager userManager;
    @EJB
    private SitesManager siteManager;
    @EJB
    private ZoneManager zoneManager;
    @EJB
    private PdfFacade pdfFacade;
    @EJB
    private UsersFacade usersFacade;
    @EJB
    private BillsFacade billsFacade;
    @EJB
    private BillManager billManager;
    @EJB
    private pdfManager PDFmanager;
    @EJB
    private graphingManager graphingManager;
    @EJB
    private MailManager mailManager;
    @EJB
    private PanelManager panelManager;
    @EJB
    private MulticircuitmeterFacade multicircuitmeterFacade;
    @EJB
    private EquipmentFacade equipmentFacade;
    @EJB
    private EndusecategoryFacade endusecategoryFacade;
    @EJB
    private EndusecategoryManager endusecategoryManager;
    @EJB
    private CircuitManager circuitManager;
    @EJB
    private MulticircuitmeterManager multicircuitmeterManager;
    @EJB
    private EnergyFacade energyFacade;
    @EJB
    private EnergyManager energyManager;
    @EJB
    private FinancialManager financialManager;
    @EJB
    private ScheduleManager scheduleManager;
    @EJB
    private weatherManager weatherManager;
    @EJB
    private degreeDayManager degreeDayManager;
    @EJB
    private MetersManager metersManager;
    @EJB
    private PCBillsManager pcBillManager;
    @EJB
    private PCBillsFacade pcBillsFacade;
    @EJB
    private FinancialFacade financialFacade;
    @EJB
    private ScheduleFacade scheduleFacade;
    @EJB
    private ControllerUser userController;
    @EJB
    private ControllerSchedule scheduleController;
    @EJB
    private ControllerSite siteController;
    @EJB
    private ControllerZone zoneController;
    @EJB
    private ControllerEnergy energyController;
    @EJB
    private ControllerBill billController;
    @EJB
    private ControllerPCBill pcBillController;    
    @EJB
    private ControllerMeter meterController;
    @EJB
    private ControllerClient clientController;
    @EJB
    private ControllerFinancial financeController;
    @EJB
    private ControllerWS weatherController;
    @EJB
    private ClientManager clientManager;
    
    private String userPath;
    private Meters gMeter;
    public Pdf gPdf;
    private Sites gSite;
    private Zones gZone;
    public int gClientId = -1;
    public int gCurrentUserId = -1;
    private Users gCurrentUser;
    private Client gClient;
    public final int gMsPerDay = 1000 * 60 * 60 * 24;
    public final int gHrsPerYr = 365 * 24;
    public final int gMsPerHr = 1000 * 60 * 60;
    public final int gBaseDiffOcc = 15;
    public final int gBaseDiffUnocc = 5;

    @Override
    public void init() throws ServletException {

//        List meterList = new ArrayList();
//        Meters currMeter;
//        meterList = metersFacade.findAll();
        List resourceList = new ArrayList();

//        Iterator<Meters> iter = meterList.iterator();
//        while (iter.hasNext() == true) {
//            currMeter = iter.next();
//            if (!resourceList.contains(currMeter.getFuelType())) {
//                resourceList.add(currMeter.getFuelType());
//            }
//        }
        resourceList.add("Electric");
        resourceList.add("Natural Gas");
        getServletContext().setAttribute("resources", resourceList);
    }

    void Setup_panel_add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List sitesList = new ArrayList();
        Sites currSite;
        sitesList = sitesFacade.findAll();
        request.setAttribute("sitesList", sitesList);

        List panelList = new ArrayList();
        Panel currPanel;
        panelList = panelFacade.findAll();
        request.setAttribute("panelList", panelList);
    }

    public Integer GetEnergyChangeAfterIncrementLighting(Integer percentOccLight, Sites building, Schedule schedule) {
        Integer powerLightOccMax = building.getLightPowerBaseOcc();
        Integer basePercentOccLight = building.getPercentMaxLightSetting();
        float LightPowerOccDiff = ((float) ((float)(percentOccLight - basePercentOccLight) * powerLightOccMax) / 100.0f);
        // ** JON ** comment-- approximately 52 weeks/year, multiply by number of occupied hours/week.
        Integer LightEnergyOccDiff = (Integer) Math.round((float) (LightPowerOccDiff
                         * (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours()
                         + schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) * 52.17));
        return LightEnergyOccDiff;
    }

//  where does the getOldBTUperHDD and getNewBTUperHDD come from?  If the simulation gives us the heating energy (BTU) for the year for the building, 
//    and if we can calculate the HDD for the year (e.g. use www.degreedays.net, then we get a ratio of BTU/HDD.  Same for cooling (kWH / CDD).
    public Integer GetEnergyChangeAfterIncrementHeatingOcc(Integer newHeatOccTemp, Sites building, Schedule schedule, Weatherstation station) {
        float percentOccHeat = (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours()
                + schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) / (float) 168.0;
        // HDDocc is the heating degree days with base temperature of the occupied setpoint-15, multiplied by the percent of the time the setpoint is at the occupied level. 
        // ** JON ** fix... this was previously set to calculate the difference between the original building model and the new building model. 
        // ** JON ** fix... now, it uses the new model for each "old" and "new" value, and the difference is purely in the setting.\
        // ** JON ** -- PROBLEM: This algorithm assumes that the HDD are distributed evenly between occupied and unoccupied hours, but in reality, it is cooler outside during unoccupied hours.
        // ** JON ** -- PROBLEM: Ideally, we'd be able to calculate HDD for just occupied hours here.  That could be an improvement in a later iteration.
        Integer HDDoccOld = Math.round((float) weatherManager.GetHDD(building.getSetpointHeatOcc() - gBaseDiffOcc, station) * percentOccHeat);
        Integer HDDoccNew = Math.round((float) weatherManager.GetHDD(newHeatOccTemp - gBaseDiffOcc, station) * percentOccHeat);
//        Integer baseHDDunocc = GetHDD(energy.getSetpointHeatUnocc(), building, hdd);
//        the annual heat is equal to (btu/hdd) * hdd in a year. GetHDD gives the HDD in a year already.
        Integer AnnualHeatEnergyOldOcc = building.getNewBTUperHDD() * HDDoccOld;
        Integer AnnualHeatEnergyNewOcc = building.getNewBTUperHDD() * HDDoccNew;

        return AnnualHeatEnergyNewOcc - AnnualHeatEnergyOldOcc;
    }

    public Integer GetEnergyChangeAfterIncrementCoolingOcc(Integer newCoolOccTemp, Sites building, Schedule schedule, Weatherstation station) {
        float percentOccCool = (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours()
                + schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) / (float) 168.0;
        // ** JON ** fix... this was previously set to calculate the difference between the original building model and the new building model. 
        // ** JON ** fix... now, it uses the new model for each "old" and "new" value, and the difference is purely in the setting.
        // ** JON ** -- PROBLEM: This algorithm assumes that the CDD are distributed evenly between occupied and unoccupied hours, but in reality, it is hotter outside during occupied hours.
        // ** JON ** -- PROBLEM: Ideally, we'd be able to calculate CDD for just occupied hours here.  That could be an improvement in a later iteration.
        Integer CDDoccOld = Math.round((float) weatherManager.GetCDD(building.getSetpointCoolOcc() - gBaseDiffOcc, station) * percentOccCool);
        Integer CDDoccNew = Math.round((float) weatherManager.GetCDD(newCoolOccTemp - gBaseDiffOcc, station) * percentOccCool);
        Integer AnnualCoolEnergyOldOcc = building.getNewKwhperCDD() * CDDoccOld;
        Integer AnnualCoolEnergyNewOcc = building.getNewKwhperCDD() * CDDoccNew;
        return AnnualCoolEnergyNewOcc - AnnualCoolEnergyOldOcc;
    }

    public Integer GetEnergyChangeAfterIncrementCoolingUnocc(Integer newCoolUnoccTemp, Sites building, Schedule schedule, Weatherstation station) {
        float percentOccCool = (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours()
                + schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) / (float) 168.0;
        float percentUnoccCool = (float) 1.0 - percentOccCool;
        // ** JON ** fix... this was previously set to calculate the difference between the original building model and the new building model. 
        // ** JON ** fix... now, it uses the new model for each "old" and "new" value, and the difference is purely in the setting.
        // ** JON ** -- PROBLEM: This algorithm assumes that the CDD are distributed evenly between occupied and unoccupied hours, but in reality, it is hotter outside during occupied hours.
        // ** JON ** -- PROBLEM: Ideally, we'd be able to calculate CDD for just unoccupied hours here.  That could be an improvement in a later iteration.
        Integer CDDUnoccOld = Math.round((float) weatherManager.GetCDD(building.getSetpointCoolUnocc() - gBaseDiffUnocc, station) * percentUnoccCool);
        Integer CDDUnoccNew = Math.round((float) weatherManager.GetCDD(newCoolUnoccTemp - gBaseDiffUnocc, station) * percentUnoccCool);
        Integer AnnualCoolEnergyOldUnocc = building.getNewKwhperCDD() * CDDUnoccOld;
        Integer AnnualCoolEnergyNewUnocc = building.getNewKwhperCDD() * CDDUnoccNew;
        return AnnualCoolEnergyNewUnocc - AnnualCoolEnergyOldUnocc;
    }

    public Integer GetEnergyChangeAfterIncrementHeatingUnocc(Integer newHeatUnoccTemp, Sites building, Schedule schedule, Weatherstation station) {
        float percentOccHeat = (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours()
                + schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) / (float) 168.0;
        float percentUnoccHeat = (float) 1.0 - percentOccHeat;
        // ** JON ** fix... this was previously set to calculate the difference between the original building model and the new building model. 
        // ** JON ** fix... now, it uses the new model for each "old" and "new" value, and the difference is purely in the setting.
        // ** JON ** -- PROBLEM: This algorithm assumes that the HDD are distributed evenly between occupied and unoccupied hours, but in reality, it is cooler outside during unoccupied hours.
        // ** JON ** -- PROBLEM: Ideally, we'd be able to calculate HDD for just unoccupied hours here.  That could be an improvement in a later iteration.
        Integer HDDUnoccOld = Math.round((float) weatherManager.GetHDD(building.getSetpointHeatUnocc() - gBaseDiffUnocc, station) * percentUnoccHeat);
        Integer HDDUnoccNew = Math.round((float) weatherManager.GetHDD(newHeatUnoccTemp - gBaseDiffUnocc, station) * percentUnoccHeat);
        Integer AnnualHeatEnergyOldUnocc = building.getNewBTUperHDD() * HDDUnoccOld;
        Integer AnnualHeatEnergyNewUnocc = building.getNewBTUperHDD() * HDDUnoccNew;
        return AnnualHeatEnergyNewUnocc - AnnualHeatEnergyOldUnocc;
    }

    private void SetPolicy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Users user;
        Integer LightVal = 0, CoolVal = 0, HeatVal = 0, CoolUOVal = 0, HeatUOVal = 0;
        String LightStr = request.getParameter("light-input");
        String HeatStr = request.getParameter("heat-input");
        String CoolStr = request.getParameter("cool-input");
        String HeatUOStr = request.getParameter("heatUO-input");
        String CoolUOStr = request.getParameter("coolUO-input");
        
        if ((LightStr != null) && (LightStr != "null")) {
            LightVal = Integer.parseInt(LightStr);
        }
        if ((HeatStr != null) && (HeatStr != "null")) {
            HeatVal = Integer.parseInt(HeatStr);
        }
        if ((CoolStr != null) && (CoolStr != "null")) {
            CoolVal = Integer.parseInt(CoolStr);
        }
        if ((HeatUOStr != null) && (HeatUOStr != "null")) {
            HeatUOVal = Integer.parseInt(HeatUOStr);
        }
        if ((CoolUOStr != null) && (CoolUOStr != "null")) {
            CoolUOVal = Integer.parseInt(CoolUOStr);
        }
        //Energy energy = null;
//        Schedule schedule = null;
        List sitesList = new ArrayList();
        Sites site = null;
        sitesList = sitesManager.findSitesByClientId(gClientId);

        Iterator<Sites> iter = sitesList.iterator();
        while (iter.hasNext() == true) {
            site = iter.next();
//            energy = energyManager.findSiteEnergyBySiteId(site.getId());
//            weatherStation = site.getWeatherStationid();
//            schedule = energy.getScheduleIdschedule();
            if (site != null && !site.getIsOverride()) {
                sitesManager.UpdatePartialEnergytoDb(site.getId(), site.getIsOverride(), CoolVal, CoolUOVal, HeatVal, HeatUOVal, LightVal);
            }
        }
        //Client client = clientFacade.find(gClientId);
        //client.setPercentMaxLightSetting(LightVal);
        //client.setSetpointCoolOcc(CoolVal);
        //client.setSetpointCoolUnocc(CoolUOVal);
        //client.setSetpointHeatUnocc(HeatUOVal);
        //client.setSetpointHeatOcc(HeatVal);
        clientManager.updateClientPartial(gClientId, LightVal, HeatVal, HeatUOVal, CoolVal, CoolUOVal);
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String outLine = new String();

        // http://stackoverflow.com/questions/46663/how-do-you-send-email-from-a-java-app-using-gmail
        String host = "smtp.gmail.com";
        String from = "open.world.energy.web.tools.ad@gmail.com";
        String pass = "openworld";
        String subject = "Policy change";
//        List<String> to = new ArrayList<String>();
        String[] to = new String[1000];
        String strPolicy = "light value: " + LightStr + 
                "\r\n heat value: " + HeatStr +
                "\r\n heat unoccupied value: " + HeatUOStr +
                "\r\n cool value: " + CoolStr +
                "\r\n cool unoccupied value: " + CoolUOStr;
        try {
            // for each user who should receive the email, send it
//            usersList = em.createNamedQuery("Users.findByClientID").setParameter("clientID", gClientID).getResultList();
            List usersList = userManager.findUsersByClientId(gClientId);
            Iterator<Users> iterUser = usersList.iterator();
            int szToList = 0;
            while (iterUser.hasNext() == true) {
                user = iterUser.next();
                if (user.getIsEmailPolicy()) {
//                    to.add(currUser.getEmail());
                    to[szToList] = user.getEmail();
                    szToList++;
                }
            }
            if (szToList > 0) {
                Users currentUser = userManager.findUserById(gCurrentUserId);
                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", "true"); // added this line
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.user", from);
                props.put("mail.smtp.password", pass);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");


                Session session = Session.getDefaultInstance(props, null);
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
//                InternetAddress[] toAddress = new InternetAddress[to.size()];
                InternetAddress[] toAddress = new InternetAddress[to.length];
                // To get the array of addresses
                try {
                    for( int i=0; i < szToList; i++ ) { // changed from a while loop
    //                    toAddress[i] = new InternetAddress(to.get(i));
                        toAddress[i] = new InternetAddress(to[i]);
                    }
                } catch (Exception e) {
                    outLine = "error";
                }
                System.out.println(Message.RecipientType.TO);
                try {
                    for( int i=0; i < szToList; i++) { // changed from a while loop
                        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
                    }
                } catch (Exception e) {
                    outLine = "error";
                }
                message.setSubject(subject);
                message.setText(strPolicy);
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
//                for( int i=0; i < szToList; i++ )  // changed from a while loop
//                    mailManager.sendMessage(from, to[i], subject, message);
                outLine = "success";
            }
        } catch (MessagingException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            outLine = "error";
        }
        out.println(outLine);
        out.flush();
        out.close();
    }

    private void SetPolicyBuilding(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Users user;
        Sites site = null;
        Integer LightVal = 0, CoolVal = 0, HeatVal = 0, CoolUOVal = 0, HeatUOVal = 0, BuildingID = 0;
        boolean isOverride = false;
        String isOverrideStr = request.getParameter("isOverride");
        String LightStr = request.getParameter("light-b-input");
        String HeatStr = request.getParameter("heat-b-input");
        String CoolStr = request.getParameter("cool-b-input");
        String HeatUOStr = request.getParameter("heatUO-b-input");
        String CoolUOStr = request.getParameter("coolUO-b-input");
        String BuildingIdStr = request.getParameter("buildingId");
        
        if ((LightStr != null) && (LightStr != "null")) {
            LightVal = Integer.parseInt(LightStr);
        }
        if ((HeatStr != null) && (HeatStr != "null")) {
            HeatVal = Integer.parseInt(HeatStr);
        }
        if ((CoolStr != null) && (CoolStr != "null")) {
            CoolVal = Integer.parseInt(CoolStr);
        }
        if ((HeatUOStr != null) && (HeatUOStr != "null")) {
            HeatUOVal = Integer.parseInt(HeatUOStr);
        }
        if ((CoolUOStr != null) && (CoolUOStr != "null")) {
            CoolUOVal = Integer.parseInt(CoolUOStr);
        }
        String BuildingName = null;
        if ((BuildingIdStr != null) && (BuildingIdStr != "null")) {
            BuildingID = Integer.parseInt(BuildingIdStr);
            site = siteManager.findSiteById(BuildingID);
            BuildingName = site.getName();
        }
        if (isOverrideStr != null && isOverrideStr.equals("true")) {
            isOverride = true;
        }
//        Energy energy = null;
//        Schedule schedule = null;
        List sitesList = new ArrayList();
//        energy = energyManager.findSiteEnergyBySiteId(site.getId());
//            weatherStation = site.getWeatherStationid();
//            schedule = energy.getScheduleIdschedule();
        Client client = clientFacade.find(gClientId);
        if (!isOverride) {
            LightVal = client.getPercentMaxLightSetting();
            CoolVal = client.getSetpointCoolOcc();
            CoolUOVal = client.getSetpointCoolUnocc();
            HeatUOVal = client.getSetpointHeatUnocc();
            HeatVal = client.getSetpointHeatOcc();
        }
        if (site != null) {
            sitesManager.UpdatePartialEnergytoDb(site.getId(), isOverride, CoolVal, CoolUOVal, HeatVal, HeatUOVal, LightVal);
        }
        
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String outLine = new String();

        // http://stackoverflow.com/questions/46663/how-do-you-send-email-from-a-java-app-using-gmail
        String host = "smtp.gmail.com";
        String from = "open.world.energy.web.tools.ad@gmail.com";
        String pass = "openworld";
        String subject = "Building Specific Policy change";
//        List<String> to = new ArrayList<String>();
        String[] to = new String[1000];
        String strPolicy = "Building: " + BuildingName +
                "   \r\n light value: " + LightStr + 
                "   \r\n heat value: " + HeatStr +
                "   \r\n heat unoccupied value: " + HeatUOStr +
                "   \r\n cool value: " + CoolStr +
                "    \r\n cool unoccupied value: " + CoolUOStr;
        if (isOverride) 
            strPolicy += "   \r\n Override the Enterprise: True";
        else
            strPolicy += "   \r\n Override the Enterprise: False";

        try {
            // for each user who should receive the email, send it
//            usersList = em.createNamedQuery("Users.findByClientID").setParameter("clientID", gClientID).getResultList();
            List usersList = userManager.findUsersByClientId(gClientId);
            Iterator<Users> iterUser = usersList.iterator();
            int szToList = 0;
            while (iterUser.hasNext() == true) {
                user = iterUser.next();
                if (user.getIsEmailPolicy()) {
//                    to.add(currUser.getEmail());
                    to[szToList] = user.getEmail();
                    szToList++;
                }
            }
            if (szToList > 0) {
                Users currentUser = userManager.findUserById(gCurrentUserId);
                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", "true"); // added this line
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.user", from);
                props.put("mail.smtp.password", pass);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");


                Session session = Session.getDefaultInstance(props, null);
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
//                InternetAddress[] toAddress = new InternetAddress[to.size()];
                InternetAddress[] toAddress = new InternetAddress[to.length];
                // To get the array of addresses
                for( int i=0; i < szToList; i++ ) { // changed from a while loop
//                    toAddress[i] = new InternetAddress(to.get(i));
                    toAddress[i] = new InternetAddress(to[i]);
                }
                System.out.println(Message.RecipientType.TO);

                for( int i=0; i < szToList; i++) { // changed from a while loop
                    message.addRecipient(Message.RecipientType.TO, toAddress[i]);
                }
                message.setSubject(subject);
                message.setText(strPolicy);
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
//                for( int i=0; i < szToList; i++ )  // changed from a while loop
//                    mailManager.sendMessage(from, to[i], subject, message);
                outLine = "success";
            }
        } catch (MessagingException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            outLine = "error";
        }
        out.println(outLine);
        out.flush();
        out.close();
    }

    // this function is also called by the Scenario page for the enterprise-wide settings
    private void RecalculateDashboardPaybackScenario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        List<Integer> savingsList = new ArrayList<Integer>();
        Integer savedkWHAnnual = 0, savedBTUAnnual = 0, moneySavedAnnual = 0;
        Weatherstation weatherStation;
        Integer scheduleID = 0;
        Integer LightVal = 0, CoolVal = 0, HeatVal = 0, CoolUOVal = 0, HeatUOVal = 0;
        Integer savedKWH, savedBTU, savedDollars;
// get parameter settings from web page
        String LightStr = request.getParameter("light-input");
        String HeatStr = request.getParameter("heat-input");
        String CoolStr = request.getParameter("cool-input");
        String HeatUOStr = request.getParameter("heatUO-input");
        String CoolUOStr = request.getParameter("coolUO-input");
        if ((LightStr != null) && (LightStr != "null")) {
            LightVal = Integer.parseInt(LightStr);
        }
        if ((HeatStr != null) && (HeatStr != "null")) {
            HeatVal = Integer.parseInt(HeatStr);
        }
        if ((CoolStr != null) && (CoolStr != "null")) {
            CoolVal = Integer.parseInt(CoolStr);
        }
        if ((HeatUOStr != null) && (HeatUOStr != "null")) {
            HeatUOVal = Integer.parseInt(HeatUOStr);
        }
        if ((CoolUOStr != null) && (CoolUOStr != "null")) {
            CoolUOVal = Integer.parseInt(CoolUOStr);
        }


        Integer electricitySavings = 0;
        Integer gasSavings = 0;
        Integer predictedMoneySaved = 0;
          
        Schedule schedule = null;
        Client client = clientFacade.find(gClientId);

        savingsList = CalcAnnualSavingsByCddHddAdditional(client, LightVal, CoolVal, HeatVal, CoolUOVal, HeatUOVal);
        electricitySavings = savingsList.get(0);
        gasSavings = savingsList.get(1);
        predictedMoneySaved = savingsList.get(2);
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        String predictedMoneySavedStr = "$" + usFormat.format(predictedMoneySaved).toString();

        Financial finances = financialManager.findFinancialByClientId(gClientId);

        //Integer predictedMoneySaved = (int) (finances.getPricePerBTU() * (finances.getSavingsToDateGas() + gasSavings));
        //predictedMoneySaved += (int) (finances.getPricePerKWh() * (finances.getSavingsToDateElectric() + electricitySavings));
        // JON:  Just tally the 'additional' money saved
//        Integer predictedMoneySaved = (int) (finances.getPricePerBTU() * gasSavings);
//        predictedMoneySaved += (int) (finances.getPricePerKWh() * electricitySavings);

        //            usFormat = NumberFormat.getIntegerInstance(Locale.US);
        //            String gasSavingsStr = usFormat.format(gasSavings);
        //            String electricitySavingsStr = usFormat.format(electricitySavings);

        savingsList = CalcSavingsToNowFromBills(client);
        savedKWH = (Integer) savingsList.get(0);
        savedBTU = (Integer) savingsList.get(1);
        savedDollars = (Integer) savingsList.get(2);

        savingsList = CalcAnnualSavingsByCddHddBase(client);
        savedkWHAnnual = savingsList.get(0) + electricitySavings;
        savedBTUAnnual = savingsList.get(1) + gasSavings;
        moneySavedAnnual = savingsList.get(2) + predictedMoneySaved;
        Date paybackDate = calcPaybackDate(finances, savedKWH, savedBTU, savedDollars, savedkWHAnnual, savedBTUAnnual, moneySavedAnnual);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        String predictedEndDate = dateFormat.format(paybackDate);
        if (PaybackDateIsInfinite(finances, savedKWH, savedBTU, savedDollars, savedkWHAnnual, savedBTUAnnual, moneySavedAnnual)) {
            predictedEndDate = "Infinite";
        }
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        out.println("scenario_paybackdate:" + predictedEndDate + ";scenario_moneysaved:" + predictedMoneySavedStr + ";scenario_elecsaved:" + electricitySavings + ";scenario_gassaved:" + gasSavings + ";");

        out.flush();
        out.close();
    }

    private void RecalculatePaybackScenarioByBuilding(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        List<Integer> savingsList = new ArrayList<Integer>();
        Integer savedkWHAnnual = 0, savedBTUAnnual = 0, moneySavedAnnual = 0;
        Weatherstation weatherStation;
        Integer siteId = 0, LightVal = 0, CoolVal = 0, HeatVal = 0, CoolUOVal = 0, HeatUOVal = 0;
        Integer LightValb = 0, CoolValb = 0, HeatValb = 0, CoolUOValb = 0, HeatUOValb = 0;
        Integer savedKWH, savedBTU, savedDollars;
        Integer scheduleID = 0;
        boolean isOverride = false;
        String siteIdStr = request.getParameter("siteId");
        String LightStr = request.getParameter("light-inputb");
        String HeatStr = request.getParameter("heat-inputb");
        String CoolStr = request.getParameter("cool-inputb");
        String HeatUOStr = request.getParameter("heatUO-inputb");
        String CoolUOStr = request.getParameter("coolUO-inputb");
        String isOverrideStr = request.getParameter("IsOverride");
        if (isOverrideStr != null && isOverrideStr.equals("true")) {
            isOverride = true;
        }
        if ((LightStr != null) && (LightStr != "null")) {
            LightValb = Integer.parseInt(LightStr);
        }
        if ((HeatStr != null) && (HeatStr != "null")) {
            HeatValb = Integer.parseInt(HeatStr);
        }
        if ((CoolStr != null) && (CoolStr != "null")) {
            CoolValb = Integer.parseInt(CoolStr);
        }
        if ((HeatUOStr != null) && (HeatUOStr != "null")) {
            HeatUOValb = Integer.parseInt(HeatUOStr);
        }
        if ((CoolUOStr != null) && (CoolUOStr != "null")) {
            CoolUOValb = Integer.parseInt(CoolUOStr);
        }
        if ((siteIdStr != null) && (siteIdStr != "null")) {
            siteId = Integer.parseInt(siteIdStr);
        }

        Sites site = sitesFacade.find(siteId);

        Integer electricitySavings = 0;
        Integer gasSavings = 0;
        //Energy energy = null;
        Schedule schedule = null;
// ** JON ** - comment: First, modify the changed setting for the enterprise (client).
        Client client = clientFacade.find(gClientId);

// ** JON ** - comment: Then, modify the appropriate setting for each building (site), unless that site explicitly overrides the enterprise settings.
        //energy = energyManager.findSiteEnergyBySiteId(siteId);
        Integer weatherStationID = site.getWeatherStationid();
        weatherStation = weatherManager.findWeatherstationById(weatherStationID);
//        weatherStation = site.getWeatherStationid();
        scheduleID = site.getScheduleIdschedule();
        schedule = scheduleManager.findScheduleByID(scheduleID);
        //if (isOverride) {
            electricitySavings -= GetEnergyChangeAfterIncrementLighting(LightValb, site, schedule);
            electricitySavings -= GetEnergyChangeAfterIncrementCoolingOcc(CoolValb, site, schedule, weatherStation);
            electricitySavings -= GetEnergyChangeAfterIncrementCoolingUnocc(CoolUOValb, site, schedule, weatherStation);
            gasSavings -= GetEnergyChangeAfterIncrementHeatingOcc(HeatValb, site, schedule, weatherStation);
            gasSavings -= GetEnergyChangeAfterIncrementHeatingUnocc(HeatUOValb, site, schedule, weatherStation);
        //}
        // ** JON ** -- what if there is an override for a building.... should the program ask if the user wants to "override" the override and accept these new values?



        Financial finances = financialManager.findFinancialByClientId(gClientId);

        // JON:  Just tally the 'additional' money saved
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        Integer predictedMoneySaved = (int) (finances.getPricePerBTU() * gasSavings);
        predictedMoneySaved += (int) (finances.getPricePerKWh() * electricitySavings);
        String predictedMoneySavedStr = "$" + usFormat.format(predictedMoneySaved).toString();

        savingsList = CalcSavingsToNowFromBills(client);
        savedKWH = (Integer) savingsList.get(0);
        savedBTU = (Integer) savingsList.get(1);
        savedDollars = (Integer) savingsList.get(2);

        savingsList = CalcAnnualSavingsByCddHddBase(client);    // , LightVal, CoolVal, HeatVal, CoolUOVal, HeatUOVal
        savedkWHAnnual = savingsList.get(0) + electricitySavings;
        savedBTUAnnual = savingsList.get(1) + gasSavings;
        moneySavedAnnual = savingsList.get(2) + predictedMoneySaved;
        Date paybackDate = calcPaybackDate(finances, savedKWH, savedBTU, savedDollars, savedkWHAnnual, savedBTUAnnual, moneySavedAnnual);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        String predictedEndDate = dateFormat.format(paybackDate);
        if (PaybackDateIsInfinite(finances, savedKWH, savedBTU, savedDollars, savedkWHAnnual, savedBTUAnnual, moneySavedAnnual)) {
            predictedEndDate = "Infinite";
        }
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        out.println("scenario_paybackdate:" + predictedEndDate + ";scenario_moneysaved:" + predictedMoneySavedStr + ";scenario_elecsaved:" + electricitySavings + ";scenario_gassaved:" + gasSavings + ";");

        out.flush();
        out.close();
    }

    private List CalcSavingsToNowByCddHdd(Client client) {
        List<Integer> list = new ArrayList<Integer>();
        Sites currSite = new Sites();
        Integer electricitySavings = 0;
        Integer gasSavings = 0;
        String airportCode = null;
        String[] result = null;
        String hdd = new String();
        String cdd = new String();
        int cddToDate = 0;
        int hddToDate = 0;
        int oldBtuPerHdd = 0;
        int oldKwhPerCdd = 0;
        int oldOtherBtuPerYr = 0;
        int oldOtherKwhPerYr = 0;
        int newBtuPerHdd = 0;
        int newKwhPerCdd = 0;
        int newOtherBtuPerYr = 0;
        int newOtherKwhPerYr = 0;
        float occupiedFraction = 0f;
        int oldLightOccKwh = 0;
        int newLightOccKwh = 0;
        int origHddOcc = 0, newHddOcc = 0;
        int origCddOcc = 0, newCddOcc = 0;
        int origHddUnocc = 0, newHddUnocc = 0;
        int origCddUnocc = 0, newCddUnocc = 0;
        float kwhSaved = 0.0f;
        float btuSaved = 0.0f;
        float moneySaved = 0.0f;

        client = clientFacade.find(gClientId);

        Financial finances = financialManager.findFinancialByClientId(gClientId);
        float pricePerKwh = finances.getPricePerKWh();
        float pricePerBtu = finances.getPricePerBTU();
        Calendar calendar = Calendar.getInstance();
        Date endDate = new Date();
        Date startDate = finances.getSavingsCalcDate();
        float hoursElapsed = (endDate.getTime() - startDate.getTime()) / (gMsPerHr);
        float yearsElapsed = hoursElapsed / gHrsPerYr;

        // getting the $ saved
        Integer moneySavedToDate = 0;
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);

        // getting the payback date, BTU and Wh saved.
//        Date paybackDate = calcPaybackDate(finances, electricitySavings, gasSavings);
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        String paybackDateStr = dateFormat.format(paybackDate);

        List sitesList = sitesManager.findSitesByClientId(gClientId);
        Iterator<Sites> iterSites = sitesList.iterator();

        while (iterSites.hasNext() == true) {
            currSite = iterSites.next();
            startDate = currSite.getStartDate();
            Integer weatherStationID = currSite.getWeatherStationid();
            Weatherstation weatherstation = weatherManager.findWeatherstationById(weatherStationID);
//            Weatherstation weatherstation = currSite.getWeatherStationid();
            airportCode = weatherstation.getName();
//            Sites currEnergy = energyManager.findSiteEnergyBySiteId(currSite.getId());
            try {
                origHddOcc = weatherManager.getHddFromAirportCode(currSite.getOrigSetpointHeatOcc() - gBaseDiffOcc, startDate, endDate, weatherstation);
                newHddOcc = weatherManager.getHddFromAirportCode(currSite.getSetpointHeatOcc() - gBaseDiffOcc, startDate, endDate, weatherstation);
                origHddUnocc = weatherManager.getHddFromAirportCode(currSite.getOrigSetpointHeatUnocc() - gBaseDiffUnocc, startDate, endDate, weatherstation);
                newHddUnocc = weatherManager.getHddFromAirportCode(currSite.getSetpointHeatUnocc() - gBaseDiffUnocc, startDate, endDate, weatherstation);
                origCddOcc = weatherManager.getCddFromAirportCode(currSite.getOrigSetpointCoolOcc() - gBaseDiffOcc, startDate, endDate, weatherstation);
                newCddOcc = weatherManager.getCddFromAirportCode(currSite.getSetpointCoolOcc() - gBaseDiffOcc, startDate, endDate, weatherstation);
                origCddUnocc = weatherManager.getCddFromAirportCode(currSite.getOrigSetpointCoolUnocc() - gBaseDiffUnocc, startDate, endDate, weatherstation);
                newCddUnocc = weatherManager.getCddFromAirportCode(currSite.getSetpointCoolUnocc() - gBaseDiffUnocc, startDate, endDate, weatherstation);
                //result = weatherManager.getHddCddfromAirportCode(startDate, endDate, airportCode);
            } catch (IOException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            hdd = result[0].split(":")[1];
            cdd = result[1].split(":")[1];

            // at some point, hddToDate and cddToDate should be saved to the 'Energy' table for each site.
            Integer scheduleID = currSite.getScheduleIdschedule();
            Schedule schedule = scheduleManager.findScheduleByID(scheduleID);
            float percentOcc = (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours()
                    + schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) / (float) 168.0;
            float percentUnocc = 1.0f - percentOcc;

            oldBtuPerHdd = currSite.getOldBTUperHDD();
            oldKwhPerCdd = currSite.getOldKWHperCDD();
            oldOtherBtuPerYr = currSite.getOldOtherBTU();
            oldOtherKwhPerYr = currSite.getOldOtherKwh();
            newBtuPerHdd = currSite.getNewBTUperHDD();
            newKwhPerCdd = currSite.getNewKwhperCDD();
            newOtherBtuPerYr = currSite.getNewOtherBTU();
            newOtherKwhPerYr = currSite.getNewOtherKwh();
            oldLightOccKwh = (int) (currSite.getLightPowerBaseOcc() * currSite.getPercentMaxLightOriginal() * percentOcc * hoursElapsed);
            newLightOccKwh = (int) (currSite.getLightPowerBaseOcc() * currSite.getPercentMaxLightSetting() * percentOcc * hoursElapsed);
            Integer oldCoolOccKwh = Math.round(oldKwhPerCdd * origCddOcc * percentOcc);
            Integer newCoolOccKwh = Math.round(newKwhPerCdd * newCddOcc * percentOcc);
            Integer oldHeatOccBTU = Math.round(oldBtuPerHdd * origHddOcc * percentOcc);
            Integer newHeatOccBTU = Math.round(newBtuPerHdd * newHddOcc * percentOcc);
            Integer oldCoolUnoccKwh = Math.round(oldKwhPerCdd * origCddUnocc * percentUnocc);
            Integer newCoolUnoccKwh = Math.round(newKwhPerCdd * newCddUnocc * percentUnocc);
            Integer oldHeatUnoccBTU = Math.round(oldBtuPerHdd * origHddUnocc * percentUnocc);
            Integer newHeatUnoccBTU = Math.round(newBtuPerHdd * newHddUnocc * percentUnocc);

            kwhSaved += (oldCoolOccKwh - newCoolOccKwh) + (oldCoolUnoccKwh - newCoolUnoccKwh) + (oldOtherKwhPerYr - newOtherKwhPerYr) * yearsElapsed + (oldLightOccKwh - newLightOccKwh);
            btuSaved += (oldHeatOccBTU - newHeatOccBTU) + (oldHeatUnoccBTU - newHeatUnoccBTU) + (oldOtherBtuPerYr - newOtherBtuPerYr) * yearsElapsed;

            moneySaved += kwhSaved * pricePerKwh + btuSaved * pricePerBtu;

//            List metersList = metersManager.findMetersBySiteId(currSite.getId());
//            Iterator <Meters> iterMeters = metersList.iterator();
//            while (iterMeters.hasNext() == true) {
//                Meters currMeter = iterMeters.next();
//            }
        }

//        Date dateNow = new Date();
//        Date startDateFinancial = finances.getStartDate();
//        float diffDaysStartTilNow = (dateNow.getTime() - startDateFinancial.getTime()) / gMsPerDay;
//        Integer whSavedPerDay = ((int) kwhSaved * 1000)  / (int) diffDaysStartTilNow;
//        Integer btuSavedPerDay = (int) btuSaved / (int) diffDaysStartTilNow;
//        float diffDaysStartTilPredEnd = ( paybackDate.getTime() - startDateFinancial.getTime() ) / gMsPerDay;
//        Integer predSavedWh = (int) diffDaysStartTilPredEnd * whSavedPerDay;
//        Integer predSavedBTU = (int) diffDaysStartTilPredEnd * btuSavedPerDay;
//        Integer moneySavedPred = (int) (predSavedWh * finances.getPricePerKWh() + predSavedBTU * finances.getPricePerBTU());           
        list.add((int) kwhSaved);
        list.add((int) btuSaved);
        list.add((int) moneySaved);

        return list;
    }

    private List CalcPredictedSavingsByCddHdd(Client client, Date startDate, Date endDate, int oldKwh, int oldBTU) {
        List<Integer> list = new ArrayList<Integer>();
        Sites currSite = new Sites();
        Integer electricitySavings = 0;
        Integer gasSavings = 0;
        String airportCode = null;
        String[] result = null;
//        String hdd = new String();
//        String cdd = new String();
        int cddToDate = 0;
        int hddToDate = 0;
//        int oldBtuPerHdd = 0;
//        int oldKwhPerCdd = 0;
//        int oldOtherBtuPerYr = 0;
//        int oldOtherKwhPerYr = 0;
        int newBtuPerHdd = 0;
        int newKwhPerCdd = 0;
        int newOtherBtuPerYr = 0;
        int newOtherKwhPerYr = 0;
        float occupiedFraction = 0f;
//        int oldLightOccKwh = 0;
        int newLightOccKwh = 0;
//        int origHddOcc = 0;
        int newHddOcc = 0;
//        int origCddOcc = 0;
        int newCddOcc = 0;
//        int origHddUnocc = 0;
        int newHddUnocc = 0;
//        int origCddUnocc = 0
        int newCddUnocc = 0;
        int kwhDiff = 0;
        int btuDiff = 0;
        int moneyDiff = 0;

        client = clientFacade.find(gClientId);

        Financial finances = financialManager.findFinancialByClientId(gClientId);
        float pricePerKwh = finances.getPricePerKWh();
        float pricePerBtu = finances.getPricePerBTU();
        Calendar calendar = Calendar.getInstance();
        float hoursElapsed = (endDate.getTime() - startDate.getTime()) / (gMsPerHr);
        float yearsElapsed = hoursElapsed / gHrsPerYr;


        List sitesList = sitesManager.findSitesByClientId(gClientId);
        Iterator<Sites> iterSites = sitesList.iterator();

        while (iterSites.hasNext() == true) {
            currSite = iterSites.next();
            startDate = currSite.getStartDate();
            Integer weatherStationID = currSite.getWeatherStationid();
            Weatherstation weatherstation = weatherManager.findWeatherstationById(weatherStationID);
//            Weatherstation weatherstation = currSite.getWeatherStationid();
            airportCode = weatherstation.getName();
//            Energy currEnergy = energyManager.findSiteEnergyBySiteId(currSite.getId());
            try {
//                origHddOcc = weatherManager.getHddFromAirportCode(currSite.getOrigSetpointHeatOcc() - gBaseDiffOcc, startDate, endDate, weatherstation);
                newHddOcc = weatherManager.getHddFromAirportCode(currSite.getSetpointHeatOcc() - gBaseDiffOcc, startDate, endDate, weatherstation);
//                origHddUnocc = weatherManager.getHddFromAirportCode(currSite.getOrigSetpointHeatUnocc() - gBaseDiffUnocc, startDate, endDate, weatherstation);
                newHddUnocc = weatherManager.getHddFromAirportCode(currSite.getSetpointHeatUnocc() - gBaseDiffUnocc, startDate, endDate, weatherstation);
//                origCddOcc = weatherManager.getCddFromAirportCode(currSite.getOrigSetpointCoolOcc() - gBaseDiffOcc, startDate, endDate, weatherstation);
                newCddOcc = weatherManager.getCddFromAirportCode(currSite.getSetpointCoolOcc() - gBaseDiffOcc, startDate, endDate, weatherstation);
//                origCddUnocc = weatherManager.getCddFromAirportCode(currSite.getOrigSetpointCoolUnocc() - gBaseDiffUnocc, startDate, endDate, weatherstation);
                newCddUnocc = weatherManager.getCddFromAirportCode(currSite.getSetpointCoolUnocc() - gBaseDiffUnocc, startDate, endDate, weatherstation);
                //result = weatherManager.getHddCddfromAirportCode(startDate, endDate, airportCode);
            } catch (IOException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
//            hdd = result[0].split(":")[1];
//            cdd = result[1].split(":")[1];

            // at some point, hddToDate and cddToDate should be saved to the 'Energy' table for each site.
            Integer scheduleID = currSite.getScheduleIdschedule();
            Schedule schedule = scheduleManager.findScheduleByID(scheduleID);
            float percentOcc = (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours()
                    + schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) / (float) 168.0;
            float percentUnocc = 1.0f - percentOcc;

//            oldBtuPerHdd = currSite.getOldBTUperHDD();
//            oldKwhPerCdd = currSite.getOldKWHperCDD();
//            oldOtherBtuPerYr = currSite.getOldOtherBTU();
//            oldOtherKwhPerYr = currSite.getOldOtherKwh();
            newBtuPerHdd = currSite.getNewBTUperHDD();
            newKwhPerCdd = currSite.getNewKwhperCDD();
            newOtherBtuPerYr = currSite.getNewOtherBTU();
            newOtherKwhPerYr = currSite.getNewOtherKwh();
//            oldLightOccKwh = (int) (currSite.getLightPowerBaseOcc() * currSite.getPercentMaxLightOriginal() * occupiedFraction * hoursElapsed);
            newLightOccKwh = (int) (currSite.getLightPowerBaseOcc() * currSite.getPercentMaxLightSetting() * percentOcc * hoursElapsed) / 100;
//            Integer oldCoolOccKwh = Math.round(oldKwhPerCdd * origCddOcc * percentOcc);
            Integer newCoolOccKwh = Math.round(newKwhPerCdd * newCddOcc * percentOcc);
//            Integer oldHeatOccBTU = Math.round(oldBtuPerHdd * origHddOcc * percentOcc);
            Integer newHeatOccBTU = Math.round(newBtuPerHdd * newHddOcc * percentOcc);
//            Integer oldCoolUnoccKwh = Math.round(oldKwhPerCdd * origCddUnocc * percentUnocc);
            Integer newCoolUnoccKwh = Math.round(newKwhPerCdd * newCddUnocc * percentUnocc);
//            Integer oldHeatUnoccBTU = Math.round(oldBtuPerHdd * origHddUnocc * percentUnocc);
            Integer newHeatUnoccBTU = Math.round(newBtuPerHdd * newHddUnocc * percentUnocc);

            kwhDiff = oldKwh - (newCoolOccKwh + newCoolUnoccKwh + newLightOccKwh * 365 * 24 + Math.round(newOtherKwhPerYr * yearsElapsed));
            btuDiff = oldBTU - (newHeatOccBTU + newHeatUnoccBTU + Math.round(newOtherBtuPerYr * yearsElapsed));

            moneyDiff += kwhDiff * pricePerKwh + btuDiff * pricePerBtu;

//            List metersList = metersManager.findMetersBySiteId(currSite.getId());
//            Iterator <Meters> iterMeters = metersList.iterator();
//            while (iterMeters.hasNext() == true) {
//                Meters currMeter = iterMeters.next();
//            }
        }

//        Date dateNow = new Date();
//        Date startDateFinancial = finances.getStartDate();
//        float diffDaysStartTilNow = (dateNow.getTime() - startDateFinancial.getTime()) / gMsPerDay;
//        Integer whSavedPerDay = ((int) kwhSaved * 1000)  / (int) diffDaysStartTilNow;
//        Integer btuSavedPerDay = (int) btuSaved / (int) diffDaysStartTilNow;
//        float diffDaysStartTilPredEnd = ( paybackDate.getTime() - startDateFinancial.getTime() ) / gMsPerDay;
//        Integer predSavedWh = (int) diffDaysStartTilPredEnd * whSavedPerDay;
//        Integer predSavedBTU = (int) diffDaysStartTilPredEnd * btuSavedPerDay;
//        Integer moneySavedPred = (int) (predSavedWh * finances.getPricePerKWh() + predSavedBTU * finances.getPricePerBTU());           
        list.add((int) kwhDiff);
        list.add((int) btuDiff);
        list.add((int) moneyDiff);

        return list;
    }

    // ** JON ** - comment - SetupDashboardPage sets the initial slider values, 
    // and fills in the initial values for the savings to date and the payback end-date.
    private void SetupDashboardPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        List<Integer> savingsList = new ArrayList<Integer>();

        Weatherstation weatherStation;
        Integer scheduleID = 0;
//      Integer LightVal = 0, CoolVal = 0, HeatVal = 0, CoolUOVal = 0, HeatUOVal = 0;
        
        Integer savedkWH = 0;
        Integer savedBTU = 0;
        Integer savedDollars = 0;
        Integer savedkWHAnnual = 0, savedBTUAnnual = 0, moneySavedAnnual = 0;
        Sites currSite = new Sites();
        Client client = new Client();
        try {
            client = clientFacade.find(gClientId);
        } catch (Exception e) {
            client = null;
        }
//        LightVal = client.getPercentMaxLightSetting();
//        CoolVal = client.getSetpointCoolOcc();
//        HeatVal = client.getSetpointHeatOcc();
//        CoolUOVal = client.getSetpointCoolUnocc();
//        HeatUOVal = client.getSetpointHeatUnocc();

        Integer electricitySavings = 0;
        Integer gasSavings = 0;
//        Energy energy = null;
        Schedule schedule = null;
// ** JON ** - comment: First, modify the changed setting for the enterprise (client).
// ** JON ** - comment: Then, modify the appropriate setting for each building (site), unless that site explicitly overrides the enterprise settings.
        
        Financial finances = financialManager.findFinancialByClientId(client.getIdClient());
        Integer moneySavedToDate = 0;
        // ** JON ** - Issue: There should really be a finances field to store the DollarSavingsToDate-- this is for the savings outside of the real/fake bills savings.
//        moneySavedToDate = (int) (finances.getPricePerBTU() * finances.getSavingsToDateGas());
//        moneySavedToDate += (int) (finances.getPricePerKWh() * finances.getSavingsToDateElectric());

        savingsList = CalcSavingsToNowFromBills(client);
        savedkWH = (Integer) savingsList.get(0);
        savedBTU = (Integer) savingsList.get(1);
        savedDollars = (Integer) savingsList.get(2);
// ** JON **: Issue:  For the mostRecentCalcDate, get the end-date of the most recent bill        
// ... actually, it should be the end date of the most recent real/fake bill pair.
        //TODO: rewrite to loop through each building and each meter and return the "average" last date of the bills
        Date today = new Date();
        Date mostRecentCalcDate = today;    // CalcMostRecentBillEndDate(client);

//        moneySavedToDate = (int) (finances.getPricePerBTU() * savedBTU);
//        moneySavedToDate += (int) (finances.getPricePerKWh() * savedkWH);
        moneySavedToDate += (int) savedDollars;   // add the dollars saved from the bills to the dollars saved initially.
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        String moneySavedToDateStr = "$" + usFormat.format(moneySavedToDate).toString();

        //calculating the predicted savings
        // for this, use the new building model, the old building model, and the typical annual HDD/CDD values.
        try {
            savingsList = CalcAnnualSavingsByCddHddBase(client);
            savedkWHAnnual = savingsList.get(0);
            savedBTUAnnual = savingsList.get(1);
            moneySavedAnnual = savingsList.get(2);        
        } catch (Exception e) {
        }

        Date dateNow = new Date();
//        Date startDateFinancial = finances.getStartDate();
//        float diffDaysStartTilNow = (dateNow.getTime() - startDateFinancial.getTime()) / gMsPerDay;
//        Integer kwhSavedPerDay = (int) savedkWH / (int) diffDaysStartTilNow;
//        Integer btuSavedPerDay = (int) savedBTU / (int) diffDaysStartTilNow;
        Date paybackDate = calcPaybackDate(finances, savedkWH, savedBTU, savedDollars, savedkWHAnnual, savedBTUAnnual, moneySavedAnnual);
//        paybackDate = sdf.format(c.getTime());  // dt is now the new date
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String paybackDateStr = dateFormat.format(paybackDate);
        if (PaybackDateIsInfinite(finances, savedkWH, savedBTU, savedDollars, savedkWHAnnual, savedBTUAnnual, moneySavedAnnual)) {
            paybackDateStr = "Infinite";
        }

//        float diffDaysStartTilPredEnd = ( paybackDate.getTime() - startDateFinancial.getTime() ) / gMsPerDay;
//        Integer predSavedWh = (int) diffDaysStartTilPredEnd * kwhSavedPerDay;
//        Integer predSavedBTU = (int) diffDaysStartTilPredEnd * btuSavedPerDay;
//        Integer moneySavedPred = (int) (predSavedWh * finances.getPricePerKWh() + predSavedBTU * finances.getPricePerBTU());           

        // outputting to the JSP page
        usFormat = NumberFormat.getIntegerInstance(Locale.US);
        String savedWHStr = usFormat.format(savedkWH).toString();
        String savedBTUStr = usFormat.format(savedBTU).toString();
        String savedPredWHStr = "0";    // usFormat.format(predSavedWh).toString();
        String savedPredBTUStr = "0";   // usFormat.format(predSavedBTU).toString();
        String moneySavedPredStr = "0"; // usFormat.format(moneySavedPred).toString();

        List fuelList = new ArrayList();
//        fuelList = metersFacade.findAll();
        String[] feul = {"all", "All ($)"};
        fuelList.add(feul);
        String[] feul2 = {"electric", "Electric ($)"};
        fuelList.add(feul2);
        String[] feul3 = {"natgas", "Natural Gas ($)"};
        fuelList.add(feul3);
        request.setAttribute("fuelList", fuelList);
        
        request.setAttribute("setpoints", client);
        request.setAttribute("savedWhTD", savedWHStr);
        request.setAttribute("savedPredWh", savedPredWHStr);
        request.setAttribute("savedPredBTU", savedPredBTUStr);
        request.setAttribute("savedBtuTD", savedBTUStr);
        request.setAttribute("endDate", paybackDateStr);
        request.setAttribute("moneySavedTD", moneySavedToDateStr);
        request.setAttribute("moneySavedPred", moneySavedPredStr);
        userPath = "/WEB-INF/view/dashboard.jsp";
    }

    // ** JON ** - comment - SetupDashboardPage sets the initial slider values, 
    // and fills in the initial values for the savings to date and the payback end-date.
    private void SetupScenarioPage(HttpServletRequest request, HttpServletResponse response, Integer clientID)
            throws ServletException, IOException, ParseException {
        List<Integer> savingsList = new ArrayList<Integer>();

        Weatherstation weatherStation;
        Integer scheduleID = 0;
//      Integer LightVal = 0, CoolVal = 0, HeatVal = 0, CoolUOVal = 0, HeatUOVal = 0;
        
        Integer savedkWH = 0;
        Integer savedBTU = 0;
        Integer savedDollars = 0;
        Integer savedkWHAnnual = 0, savedBTUAnnual = 0, moneySavedAnnual = 0;
        Sites currSite = new Sites();
        List sitesList = sitesManager.findSitesByClientId(clientID);
        if (!sitesList.isEmpty())
            currSite = (Sites) sitesList.get(0);
        Client client = new Client();
        try {
            client = clientFacade.find(gClientId);
        } catch (Exception e) {
            client = null;
        }
//        LightVal = client.getPercentMaxLightSetting();
//        CoolVal = client.getSetpointCoolOcc();
//        HeatVal = client.getSetpointHeatOcc();
//        CoolUOVal = client.getSetpointCoolUnocc();
//        HeatUOVal = client.getSetpointHeatUnocc();

        Integer electricitySavings = 0;
        Integer gasSavings = 0;
//        Energy energy = null;
        Schedule schedule = null;
// ** JON ** - comment: First, modify the changed setting for the enterprise (client).
// ** JON ** - comment: Then, modify the appropriate setting for each building (site), unless that site explicitly overrides the enterprise settings.
        
        Financial finances = financialManager.findFinancialByClientId(clientID);
        Integer moneySavedToDate = 0;
        // ** JON ** - Issue: There should really be a finances field to store the DollarSavingsToDate-- this is for the savings outside of the real/fake bills savings.
//        moneySavedToDate = (int) (finances.getPricePerBTU() * finances.getSavingsToDateGas());
//        moneySavedToDate += (int) (finances.getPricePerKWh() * finances.getSavingsToDateElectric());

        savingsList = CalcSavingsToNowFromBills(client);
        savedkWH = (Integer) savingsList.get(0);
        savedBTU = (Integer) savingsList.get(1);
        savedDollars = (Integer) savingsList.get(2);
// ** JON **: Issue:  For the mostRecentCalcDate, get the end-date of the most recent bill        
// ... actually, it should be the end date of the most recent real/fake bill pair.
        //TODO: rewrite to loop through each building and each meter and return the "average" last date of the bills
        Date today = new Date();
        Date mostRecentCalcDate = today;    // CalcMostRecentBillEndDate(client);

//        moneySavedToDate = (int) (finances.getPricePerBTU() * savedBTU);
//        moneySavedToDate += (int) (finances.getPricePerKWh() * savedkWH);
        moneySavedToDate += (int) savedDollars;   // add the dollars saved from the bills to the dollars saved initially.
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        String moneySavedToDateStr = "$" + usFormat.format(moneySavedToDate).toString();

        //calculating the predicted savings
        // for this, use the new building model, the old building model, and the typical annual HDD/CDD values.
        try {
            savingsList = CalcAnnualSavingsByCddHddBase(client);
            savedkWHAnnual = savingsList.get(0);
            savedBTUAnnual = savingsList.get(1);
            moneySavedAnnual = savingsList.get(2);        
        } catch (Exception e) {
        }

        Date dateNow = new Date();
//        Date startDateFinancial = finances.getStartDate();
//        float diffDaysStartTilNow = (dateNow.getTime() - startDateFinancial.getTime()) / gMsPerDay;
//        Integer kwhSavedPerDay = (int) savedkWH / (int) diffDaysStartTilNow;
//        Integer btuSavedPerDay = (int) savedBTU / (int) diffDaysStartTilNow;
        Date paybackDate = calcPaybackDate(finances, savedkWH, savedBTU, savedDollars, savedkWHAnnual, savedBTUAnnual, moneySavedAnnual);
//        paybackDate = sdf.format(c.getTime());  // dt is now the new date
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String paybackDateStr = dateFormat.format(paybackDate);
        if (PaybackDateIsInfinite(finances, savedkWH, savedBTU, savedDollars, savedkWHAnnual, savedBTUAnnual, moneySavedAnnual)) {
            paybackDateStr = "Infinite";
        }

//        float diffDaysStartTilPredEnd = ( paybackDate.getTime() - startDateFinancial.getTime() ) / gMsPerDay;
//        Integer predSavedWh = (int) diffDaysStartTilPredEnd * kwhSavedPerDay;
//        Integer predSavedBTU = (int) diffDaysStartTilPredEnd * btuSavedPerDay;
//        Integer moneySavedPred = (int) (predSavedWh * finances.getPricePerKWh() + predSavedBTU * finances.getPricePerBTU());           

        // outputting to the JSP page
        usFormat = NumberFormat.getIntegerInstance(Locale.US);
        String savedWHStr = usFormat.format(savedkWH).toString();
        String savedBTUStr = usFormat.format(savedBTU).toString();
        String savedPredWHStr = "0";    // usFormat.format(predSavedWh).toString();
        String savedPredBTUStr = "0";   // usFormat.format(predSavedBTU).toString();
        String moneySavedPredStr = "0"; // usFormat.format(moneySavedPred).toString();

        List fuelList = new ArrayList();
//        fuelList = metersFacade.findAll();
        String[] feul = {"all", "All ($)"};
        fuelList.add(feul);
        String[] feul2 = {"electric", "Electric ($)"};
        fuelList.add(feul2);
        String[] feul3 = {"natgas", "Natural Gas ($)"};
        fuelList.add(feul3);
        request.setAttribute("fuelList", fuelList);
        
        request.setAttribute("setpoints_b", currSite);
        request.setAttribute("savedWhTD", savedWHStr);
        request.setAttribute("savedPredWh", savedPredWHStr);
        request.setAttribute("savedPredBTU", savedPredBTUStr);
        request.setAttribute("savedBtuTD", savedBTUStr);
        request.setAttribute("endDate", paybackDateStr);
        request.setAttribute("moneySavedTD", moneySavedToDateStr);
        request.setAttribute("moneySavedPred", moneySavedPredStr);
        userPath = "/WEB-INF/view/dashboard.jsp";
    }

    private Date CalcMostRecentBillEndDate(Client client) {
        Date endDateAvg = new Date();
        Date tempDate = new Date();
        long tempDateMS = 0;
        int count = 0;

        Sites currSite = new Sites();

        List sitesList = sitesManager.findSitesByClientId(client.getIdClient());
        Iterator<Sites> iterSites = sitesList.iterator();
        while (iterSites.hasNext() == true) {
            currSite = iterSites.next();

            List metersList = metersManager.findMetersBySiteId(currSite.getId());
            Iterator<Meters> iterMeters = metersList.iterator();
            while (iterMeters.hasNext() == true) {
                Meters currMeter = iterMeters.next();

                try {
                    tempDate = billManager.getLastBillDate(currMeter);
                    tempDateMS += tempDate.getTime();
                    count++;
                } catch (Exception e) {
                    String error = e.toString();
                }
            }
        }
        if (count != 0) {
            tempDateMS = tempDateMS / count;
        }
        endDateAvg = new Date(tempDateMS);
        return endDateAvg;
    }

    private Date CalcMostRecentBillEndDate(Sites site) {
        Date endDateAvg = new Date();
        Date tempDate = new Date();
        long tempDateMS = 0;
        int count = 0;

        List metersList = metersManager.findMetersBySiteId(site.getId());
        Iterator<Meters> iterMeters = metersList.iterator();
        while (iterMeters.hasNext() == true) {
            Meters currMeter = iterMeters.next();

            try {
                tempDate = billManager.getLastBillDate(currMeter);
                tempDateMS += tempDate.getTime();
                count++;
            } catch (Exception e) {
                String error = e.toString();
            }
        }
        tempDateMS = tempDateMS / count;
        endDateAvg = new Date(tempDateMS);
        return endDateAvg;
    }

    private List CalcSavingsToNowFromBills(Client client) {
        List<Integer> BillTotals = new ArrayList<Integer>();
        List<Integer> PCBillTotals = new ArrayList<Integer>();
        List<Integer> savedTotals = new ArrayList<Integer>();

        Sites currSite = new Sites();
        Financial finances = financialManager.findFinancialByClientId(client.getIdClient());
//        Integer electricitySavings = 0;
//        Integer gasSavings = 0;

        float sumFakeKWH = 0.0f, sumFakeBTU = 0.0f;       // this is the sum of the "amounts" which are kwh (or wh?) for electricity, btus (or ccf?) for natural gas.
        // **JON **-- Issue:  we need to standardize on units, and force the user to enter consistent units (or convert ourselves) for natural gas.
        float sumKWH = 0.0f, sumBTU = 0.0f;
        float sumFakeDollars = 0.0f, sumDollars = 0.0f;
        float savedDollars = 0.0f;
        float savedKWH = 0.0f;
        float savedBTU = 0.0f;
        Calendar calendar = Calendar.getInstance();
        Date endDateBills = new Date();
        Date startDateBills = finances.getStartDate();
        float hoursElapsed = (endDateBills.getTime() - startDateBills.getTime()) / (gMsPerHr);
        float yearsElapsed = hoursElapsed / gHrsPerYr;
        // ** JON **- the savings to date are specified for the savings from the contract start date up to the SavingsCalcDate.  So use the bills from dates after that date.

        PCBillTotals = pcBillManager.sumBillsByClientIdFast(gClientId, startDateBills);
        sumFakeKWH = PCBillTotals.get(0);
        sumFakeBTU = PCBillTotals.get(1);
        sumFakeDollars = PCBillTotals.get(2);
        
        BillTotals = billManager.sumBillsByClientIdFast(gClientId, startDateBills);
        sumKWH = BillTotals.get(0);
        sumBTU = BillTotals.get(1);
        sumDollars = BillTotals.get(2);

        savedDollars += (sumFakeDollars - sumDollars);
        savedKWH += sumFakeKWH - sumKWH;
        savedBTU += sumFakeBTU - sumBTU;

        savedTotals.add((int) savedKWH);
        savedTotals.add((int) savedBTU);
        savedTotals.add((int) savedDollars);

        return savedTotals;
    }
    // updating the database with the latest savings and dates
//        financialManager.updateFinances(finances.getIdtable1(), savedWH, savedBTU, endDateBills);
    // ** JON** - Comment: I think it's easier to just recalculate these every time, i.e. don't try overwriting the values that the user has specified for the INITIAL savings.


    public Date calcPaybackDate(Financial finances, Integer savingsPreviousElectric, Integer savingsPreviousGas, Integer savingsPreviousDollars, Integer annualElectricSavings, Integer annualGasSavings, Integer dollarSavings) {
        Date elapsed;
        Integer expToDate, savingsToDate, expAnnual;
        Integer extraDays;
        //GregorianCalendar extraTime;
        Date paybackDate;
        Date dateNow = new Date();
        //Date paybackDate;
        Time testTime;
        float extraYearsFloat = 0.0f;
        float savingsAnnualFloat;
        expToDate = finances.getFixedExpense();
        savingsToDate = savingsPreviousDollars; //finances.getSavingsToDateElectric() + finances.getSavingsToDateGas();
        savingsAnnualFloat = (annualElectricSavings) * finances.getPricePerKWh() + (annualGasSavings) * finances.getPricePerBTU();
        expAnnual = finances.getAnnualExpense();
        if (savingsAnnualFloat != (float) expAnnual)
            extraYearsFloat = ((float) expToDate - (float) savingsToDate) / (savingsAnnualFloat - (float) expAnnual);
        extraDays = (int) (extraYearsFloat * 365.0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(dateNow); 
        c.add(Calendar.DATE, extraDays);  // number of days to add
        paybackDate = c.getTime();

        return paybackDate;
    }

    public Boolean PaybackDateIsInfinite(Financial finances, Integer savingsPreviousElectric, Integer savingsPreviousGas, Integer savingsPreviousDollars, Integer annualElectricSavings, Integer annualGasSavings, Integer dollarSavings) {
        Date elapsed;
        Integer expToDate, savingsToDate, expAnnual;
        Integer extraDays;
        //GregorianCalendar extraTime;
        Date paybackDate;
        //Date paybackDate;
        Time testTime;
        float extraYearsFloat;
        float savingsAnnualFloat;
        expToDate = finances.getFixedExpense();
        savingsToDate = finances.getSavingsToDateElectric() + finances.getSavingsToDateGas();
//        savingsPreviousElectric = finances.getSavingsToDateElectric();
//        savingsPreviousGas = finances.getSavingsToDateGas();
        savingsAnnualFloat = (annualElectricSavings) * finances.getPricePerKWh() + (annualGasSavings) * finances.getPricePerBTU();
        expAnnual = finances.getAnnualExpense();
        extraYearsFloat = ((float) expToDate - (float) savingsToDate) / (savingsAnnualFloat - (float) expAnnual);
        extraDays = (int) (extraYearsFloat * 365.0);

        return extraDays < 0;
    }


//Calculate the change in predicted typical annual savings, with weather for a typical year, for an enterprise.
//For each building/site, add up expected lighting savings, heating savings (occupied and unoccupied), and cooling savings ( occupied and unoccupied). 
//This calls weatherManager.GetHDD and weatherManager.GetCDD to calculate the annual HDD / CDD required to maintain the specified setpoints.
private List CalcAnnualSavingsByCddHddAdditional(Client client, int LightVal, int CoolVal, int HeatVal, int CoolUOVal, int HeatUOVal) {

        List<Integer> list = new ArrayList<Integer>();
        Sites currSite = new Sites();
        Integer electricitySavings = 0;
        Integer gasSavings = 0;
        String airportCode = null;
        String[] result = null;
        int origHddOccAnnual = 0;
        int origCddOccAnnual = 0;
        int newHddOccAnnual = 0;
        int newCddOccAnnual = 0;
        int origHddUnoccAnnual = 0;
        int origCddUnoccAnnual = 0;
        int newHddUnoccAnnual = 0;
        int newCddUnoccAnnual = 0;
//        int cddToDate = 0;
//        int hddToDate = 0;
        int oldBtuPerHdd = 0;
        int oldKwhPerCdd = 0;
        int oldOtherBtuAnnual = 0;
        int oldOtherKwhAnnual = 0;
        int newBtuPerHdd = 0;
        int newKwhPerCdd = 0;
        int newOtherBtuAnnual = 0;
        int newOtherKwhAnnual = 0;
        Integer savedkWHAnnual = 0;
        Integer savedBTUAnnual = 0;
        int moneySavedAnnual = 0;
        //float kwhSaved = 0.0f;
        //float btuSaved = 0.0f;
//        float moneySaved = 0.0f;
        int origLightVal = 0;
        Integer oldLightingKwh = 0;
        Integer newLightingKwh = 0;
    try {
        client = clientFacade.find(gClientId);

        Financial finances = financialManager.findFinancialByClientId(gClientId);
        float pricePerKwh = finances.getPricePerKWh();
        float pricePerBtu = finances.getPricePerBTU();



        List sitesList = sitesManager.findSitesByClientId(gClientId);
        Iterator<Sites> iterSites = sitesList.iterator();

        while (iterSites.hasNext() == true) {
            currSite = iterSites.next();
            Integer weatherStationID = currSite.getWeatherStationid();
            Weatherstation weatherstation = weatherManager.findWeatherstationById(weatherStationID);
//            Weatherstation weatherstation = currSite.getWeatherStationid();
            airportCode = weatherstation.getName();
            if (currSite != null) {
                if (!currSite.getIsOverride()) {
                    origHddOccAnnual = weatherManager.GetHDD(client.getSetpointHeatOcc() - gBaseDiffOcc, weatherstation);
                    newHddOccAnnual = weatherManager.GetHDD(HeatVal - gBaseDiffOcc, weatherstation);
                    origHddUnoccAnnual = weatherManager.GetHDD(client.getSetpointHeatUnocc() - gBaseDiffUnocc, weatherstation);
                    newHddUnoccAnnual = weatherManager.GetHDD(HeatUOVal - gBaseDiffUnocc, weatherstation);
                    origCddOccAnnual = weatherManager.GetCDD(client.getSetpointCoolOcc() - gBaseDiffOcc, weatherstation);
                    newCddOccAnnual = weatherManager.GetCDD(CoolVal - gBaseDiffOcc, weatherstation);
                    origCddUnoccAnnual = weatherManager.GetCDD(client.getSetpointCoolUnocc() - gBaseDiffUnocc, weatherstation);
                    newCddUnoccAnnual = weatherManager.GetCDD(CoolUOVal - gBaseDiffUnocc, weatherstation);
                    origLightVal = client.getPercentMaxLightSetting();
                } else {
                    origHddOccAnnual = newHddOccAnnual;
                    origHddUnoccAnnual = newHddUnoccAnnual;
                    origCddOccAnnual = newCddOccAnnual;
                    origCddUnoccAnnual = newCddUnoccAnnual;
                    origLightVal = LightVal;
                }
            }

            Integer scheduleID = 0;
            Schedule schedule = null;
            if (currSite != null) {
                scheduleID = currSite.getScheduleIdschedule();
                schedule = scheduleManager.findScheduleByID(scheduleID);
            }
            float  percentOcc = (float) 100.0;
            float  percentUnocc = (float) 0.0;
            if (schedule != null) {
                percentOcc = (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours() + 
                    schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) / (float)168.0;
                percentUnocc = 1.0f - percentOcc;
            }
            // at some point, it might make sense to store hddToDate and cddToDate to the 'Energy' table for each site.
            // Not sure when or where this should be done.
            Integer oldLightingKwhAnnual = 0;
            Integer newLightingKwhAnnual = 0;
            if (currSite != null) {
                oldBtuPerHdd = currSite.getOldBTUperHDD();
                oldKwhPerCdd = currSite.getOldKWHperCDD();
                oldOtherBtuAnnual = currSite.getOldOtherBTU();
                oldOtherKwhAnnual = currSite.getOldOtherKwh();
                newBtuPerHdd = currSite.getNewBTUperHDD();
                newKwhPerCdd = currSite.getNewKwhperCDD();
                newOtherBtuAnnual = currSite.getNewOtherBTU();
                newOtherKwhAnnual = currSite.getNewOtherKwh();
                oldLightingKwhAnnual = (int)(currSite.getLightPowerBaseOcc() * origLightVal * 365. * 24. * percentOcc/100.);
                newLightingKwhAnnual = (int)(currSite.getLightPowerBaseOcc() * LightVal * 365. * 24. * percentOcc/100.);
            }
            Integer oldCoolOccKwhAnnual = Math.round(newKwhPerCdd * origCddOccAnnual * percentOcc);
            Integer newCoolOccKwhAnnual = Math.round(newKwhPerCdd * newCddOccAnnual * percentOcc);
            Integer oldHeatOccBTUAnnual = Math.round(newBtuPerHdd * origHddOccAnnual * percentOcc);
            Integer newHeatOccBTUAnnual = Math.round(newBtuPerHdd * newHddOccAnnual * percentOcc);
            Integer oldCoolUnoccKwhAnnual = Math.round(newKwhPerCdd * origCddUnoccAnnual * percentUnocc);
            Integer newCoolUnoccKwhAnnual = Math.round(newKwhPerCdd * newCddUnoccAnnual * percentUnocc);
            Integer oldHeatUnoccBTUAnnual = Math.round(newBtuPerHdd * origHddUnoccAnnual * percentUnocc);
            Integer newHeatUnoccBTUAnnual = Math.round(newBtuPerHdd * newHddUnoccAnnual * percentUnocc);

            savedkWHAnnual += (oldCoolOccKwhAnnual - newCoolOccKwhAnnual) + (oldCoolUnoccKwhAnnual - newCoolUnoccKwhAnnual) + (oldLightingKwhAnnual - newLightingKwhAnnual);
            savedBTUAnnual += (oldHeatOccBTUAnnual - newHeatOccBTUAnnual) + (oldHeatUnoccBTUAnnual - newHeatUnoccBTUAnnual);
        }

        moneySavedAnnual = (int) (savedkWHAnnual * pricePerKwh + savedBTUAnnual * pricePerBtu);
        list.add(Math.round(savedkWHAnnual));
        list.add(Math.round(savedBTUAnnual));
        list.add(moneySavedAnnual);
    } catch (Exception e) {
        return null;
    }

        return list;
    }

//Calculate the predicted typical annual savings, with weather for a typical year, for an enterprise.
//For each building/site, add up expected lighting savings, heating savings (occupied and unoccupied), and cooling savings ( occupied and unoccupied). 
//This calls weatherManager.GetHDD and weatherManager.GetCDD to calculate the annual HDD / CDD required to maintain the specified setpoints.
    private List CalcAnnualSavingsByCddHddBase(Client client) {

        List<Integer> list = new ArrayList<Integer>();
        Sites currSite = new Sites();
        Integer electricitySavings = 0;
        Integer gasSavings = 0;
        String airportCode = null;
        String[] result = null;
        int origHddOccAnnual = 0;
        int origCddOccAnnual = 0;
        int newHddOccAnnual = 0;
        int newCddOccAnnual = 0;
        int origHddUnoccAnnual = 0;
        int origCddUnoccAnnual = 0;
        int newHddUnoccAnnual = 0;
        int newCddUnoccAnnual = 0;
//        int cddToDate = 0;
//        int hddToDate = 0;
        int oldBtuPerHdd = 0;
        int oldKwhPerCdd = 0;
        int oldOtherBtuAnnual = 0;
        int oldOtherKwhAnnual = 0;
        int newBtuPerHdd = 0;
        int newKwhPerCdd = 0;
        int newOtherBtuAnnual = 0;
        int newOtherKwhAnnual = 0;
        Integer savedkWHAnnual = 0;
        Integer savedBTUAnnual = 0;
        int moneySavedAnnual = 0;
        //float kwhSaved = 0.0f;
        //float btuSaved = 0.0f;
//        float moneySaved = 0.0f;
        int oldLightingKwh = 0;
        int newLightingKwh = 0;
        try {
            client = clientFacade.find(gClientId);

            Financial finances = financialManager.findFinancialByClientId(gClientId);
            float pricePerKwh = finances.getPricePerKWh();
            float pricePerBtu = finances.getPricePerBTU();

            List sitesList = sitesManager.findSitesByClientId(gClientId);
            Iterator<Sites> iterSites = sitesList.iterator();

            while (iterSites.hasNext() == true) {
                currSite = iterSites.next();
                Integer weatherStationID = currSite.getWeatherStationid();
                Weatherstation weatherstation = weatherManager.findWeatherstationById(weatherStationID);
                airportCode = weatherstation.getName();
                if (currSite != null) {
                    if (!currSite.getIsOverride()) {
                        origHddOccAnnual = weatherManager.GetHDD(client.getOrigSetpointHeatOcc() - gBaseDiffOcc, weatherstation);
                        newHddOccAnnual = weatherManager.GetHDD(client.getSetpointHeatOcc() - gBaseDiffOcc, weatherstation);
                        origHddUnoccAnnual = weatherManager.GetHDD(client.getOrigSetpointHeatUnocc() - gBaseDiffUnocc, weatherstation);
                        newHddUnoccAnnual = weatherManager.GetHDD(client.getSetpointHeatUnocc() - gBaseDiffUnocc, weatherstation);
                        origCddOccAnnual = weatherManager.GetCDD(client.getOrigSetpointCoolOcc() - gBaseDiffOcc, weatherstation);
                        newCddOccAnnual = weatherManager.GetCDD(client.getSetpointCoolOcc() - gBaseDiffOcc, weatherstation);
                        origCddUnoccAnnual = weatherManager.GetCDD(client.getOrigSetpointCoolUnocc() - gBaseDiffUnocc, weatherstation);
                        newCddUnoccAnnual = weatherManager.GetCDD(client.getSetpointCoolUnocc() - gBaseDiffUnocc, weatherstation);
                    } else {
                        origHddOccAnnual = weatherManager.GetHDD(currSite.getOrigSetpointHeatOcc() - gBaseDiffOcc, weatherstation);
                        newHddOccAnnual = weatherManager.GetHDD(currSite.getSetpointHeatOcc() - gBaseDiffOcc, weatherstation);
                        origHddUnoccAnnual = weatherManager.GetHDD(currSite.getOrigSetpointHeatUnocc() - gBaseDiffUnocc, weatherstation);
                        newHddUnoccAnnual = weatherManager.GetHDD(currSite.getSetpointHeatUnocc() - gBaseDiffUnocc, weatherstation);
                        origCddOccAnnual = weatherManager.GetCDD(currSite.getOrigSetpointCoolOcc() - gBaseDiffOcc, weatherstation);
                        newCddOccAnnual = weatherManager.GetCDD(currSite.getSetpointCoolOcc() - gBaseDiffOcc, weatherstation);
                        origCddUnoccAnnual = weatherManager.GetCDD(currSite.getOrigSetpointCoolUnocc() - gBaseDiffUnocc, weatherstation);
                        newCddUnoccAnnual = weatherManager.GetCDD(currSite.getSetpointCoolUnocc() - gBaseDiffUnocc, weatherstation);
                    }
                }

                Integer scheduleID = 0;
                Schedule schedule = null;
                if (currSite != null) {
                    scheduleID = currSite.getScheduleIdschedule();
                    schedule = scheduleManager.findScheduleByID(scheduleID);
                }
                float  percentOcc = (float) 100.0;
                float  percentUnocc = (float) 0.0;
                if (schedule != null) {
                    percentOcc = (schedule.getSunHours() + schedule.getMonHours() + schedule.getTuesHours() + schedule.getWedHours() + 
                        schedule.getThHours() + schedule.getFriHours() + schedule.getSatHours()) / (float)168.0;
                    percentUnocc = 1.0f - percentOcc;
                }
                // at some point, it might make sense to store hddToDate and cddToDate to the 'Energy' table for each site.
                // Not sure when or where this should be done.
                Integer oldLightingKwhAnnual = 0, newLightingKwhAnnual = 0;
                if (currSite != null) {
                    oldBtuPerHdd = currSite.getOldBTUperHDD();
                    oldKwhPerCdd = currSite.getOldKWHperCDD();
                    oldOtherBtuAnnual = currSite.getOldOtherBTU();
                    oldOtherKwhAnnual = currSite.getOldOtherKwh();
                    newBtuPerHdd = currSite.getNewBTUperHDD();
                    newKwhPerCdd = currSite.getNewKwhperCDD();
                    newOtherBtuAnnual = currSite.getNewOtherBTU();
                    newOtherKwhAnnual = currSite.getNewOtherKwh();
                    oldLightingKwhAnnual = Math.round(percentOcc * currSite.getLightPowerBaseOcc() * currSite.getPercentMaxLightOriginal() * 365 * 24)/100;  // this should really use the OrigLightPowerBaseOcc
                    newLightingKwhAnnual = Math.round(percentOcc * currSite.getLightPowerBaseOcc() * currSite.getPercentMaxLightSetting() * 365 * 24)/100;
                }
                Integer oldCoolOccKwhAnnual = Math.round(oldKwhPerCdd * origCddOccAnnual * percentOcc);
                Integer newCoolOccKwhAnnual = Math.round(newKwhPerCdd * newCddOccAnnual * percentOcc);
                Integer oldHeatOccBTUAnnual = Math.round(oldBtuPerHdd * origHddOccAnnual * percentOcc);
                Integer newHeatOccBTUAnnual = Math.round(newBtuPerHdd * newHddOccAnnual * percentOcc);
                Integer oldCoolUnoccKwhAnnual = Math.round(oldKwhPerCdd * origCddUnoccAnnual * percentUnocc);
                Integer newCoolUnoccKwhAnnual = Math.round(newKwhPerCdd * newCddUnoccAnnual * percentUnocc);
                Integer oldHeatUnoccBTUAnnual = Math.round(oldBtuPerHdd * origHddUnoccAnnual * percentUnocc);
                Integer newHeatUnoccBTUAnnual = Math.round(newBtuPerHdd * newHddUnoccAnnual * percentUnocc);

                savedkWHAnnual += (oldCoolOccKwhAnnual - newCoolOccKwhAnnual) + (oldCoolUnoccKwhAnnual - newCoolUnoccKwhAnnual) + (oldOtherKwhAnnual - newOtherKwhAnnual) + (oldLightingKwhAnnual - newLightingKwhAnnual);
                savedBTUAnnual += (oldHeatOccBTUAnnual - newHeatOccBTUAnnual) + (oldHeatUnoccBTUAnnual - newHeatUnoccBTUAnnual) + (oldOtherBtuAnnual - newOtherBtuAnnual);
            }

            moneySavedAnnual = (int) (savedkWHAnnual * pricePerKwh + savedBTUAnnual * pricePerBtu);
            list.add(Math.round(savedkWHAnnual));
            list.add(Math.round(savedBTUAnnual));
            list.add(moneySavedAnnual);
        } catch (Exception e) {
            return null;
        }

        return list;
    }

    private String[] getHddCddbyDate(Integer heatBaseTemp, Integer coolBaseTemp, Date startDate, Date endDate, Weatherstation ws) throws IOException {
        String result[] = null;
        Sites currSite = null;
        List sitesList = new ArrayList();

        sitesList = sitesManager.findSitesByClientId(gClientId);

        Iterator<Sites> iter = sitesList.iterator();

        while (iter.hasNext() == true) {
            currSite = iter.next();
//            airportCode = currSite.getWeatherStationid().getName();
            //result = weatherManager.parseWeather(startDate, endDate, airportCode);
            result = weatherManager.getHddCddfromAirportCode(heatBaseTemp, coolBaseTemp, startDate, endDate, ws);
        }

        return result;
//        String hdd = result[0].split(":")[1];
//        String cdd = result[1].split(":")[1];

    }

    private Integer getHddbyDate(Integer baseTemp, Date startDate, Date endDate, Weatherstation ws) throws IOException {
        Sites currSite = null;
        List sitesList = new ArrayList();
        Integer result = 0;
        sitesList = sitesManager.findSitesByClientId(gClientId);

        Iterator<Sites> iter = sitesList.iterator();

        while (iter.hasNext() == true) {
            currSite = iter.next();
            //Energy currEnergy = energyManager.findSiteEnergyBySiteId(currSite.getId());
//            airportCode = currSite.getWeatherStationid().getName();
            //result = weatherManager.parseWeather(startDate, endDate, airportCode);
            result += weatherManager.getHddFromAirportCode(baseTemp, startDate, endDate, ws);
        }

        return result;
//        String hdd = result[0].split(":")[1];
//        String cdd = result[1].split(":")[1];
    }

    private Integer getCddbyDate(Integer baseTemp, Date startDate, Date endDate, Weatherstation ws) throws IOException {
        Sites currSite = null;
        List sitesList = new ArrayList();
        Integer result = 0;
        sitesList = sitesManager.findSitesByClientId(gClientId);

        Iterator<Sites> iter = sitesList.iterator();

        while (iter.hasNext() == true) {
            currSite = iter.next();
//            airportCode = currSite.getWeatherStationid().getName();
            //result = weatherManager.parseWeather(startDate, endDate, airportCode);
            result += weatherManager.getCddFromAirportCode(baseTemp, startDate, endDate, ws);
        }

        return result;
//        String hdd = result[0].split(":")[1];
//        String cdd = result[1].split(":")[1];
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getRemoteUser();
        gCurrentUser = userManager.findUserByName(userName);
        gCurrentUserId = gCurrentUser.getId();
        gClientId = gCurrentUser.getClientidClient();
        gClient = clientManager.findClientById(gClientId);
        
        HttpSession session = request.getSession(true);
        boolean isAjax = false;
        Weatherstation weatherStation;
        userPath = request.getServletPath();
        TransactionType returnTran;
        if (userPath.equals("/reports")) {
            userPath = "/WEB-INF/view/report_overview.jsp";
        } else if (userPath.equals("/reports-use_over_time")) {
            /*
             * Initialize data              *
             * // --- Initial Data ---//
             *
             * //var data = [50, 175, 118, 145, 97, 99, 40]
             */
            userPath = "ha";
        } else if (userPath.equals("/test")) {
            Client client = new Client();
            client = clientFacade.find(gClientId);
            Date mostRecentCalcDate = CalcMostRecentBillEndDate(client);
            userPath = "/dashboard";
            
       } else if ((userPath.equals("/graphs_addseriesbyyear")) ||
               (userPath.equals("/graphs_addseriesbymonth")) || 
               (userPath.equals("/graphs_addseriesbymonthyear"))){
            String fuelType = request.getParameter("fuel");
            fuelType = fuelType.toLowerCase();
            //Integer year = Integer.parseInt(request.getParameter("year")); 
            String[] test = graphingManager.addSeriesForAllYears(gClientId, fuelType);
            //String test = graphingManager.addSeriesbyYear(id, year);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            Boolean isAlreadyInit = false;
            for (int i = 0; i < 8; i++) {
                if (test[i].length() > 17) { // more than just year and commas
                    if (isAlreadyInit)
                        out.append(';');
                    out.println(test[i]);
                    isAlreadyInit = true;
                }
            }
            out.flush();
            out.close();
            userPath = "/WEB-INF/view/report_overview.jsp";
            isAjax = true;
       } else if (userPath.equals("/graphs_addserieselectric")) {
            String id = request.getParameter("id");
            String[] test = graphingManager.addSeriesForAllYearsElectric(id);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            Boolean isAlreadyInit = false;
            for (int i = 0; i < 8; i++) {
                if (test[i].length() > 17) { // more than just year and commas
                    if (isAlreadyInit)
                        out.append(';');
                    out.println(test[i]);
                    isAlreadyInit = true;
                }
            }
            out.flush();
            out.close();
            userPath = "/WEB-INF/view/report_overview.jsp";
            isAjax = true;
       } else if (userPath.equals("/graphs_addseriesgas")) {
            String id = request.getParameter("id");
            String[] test = graphingManager.addSeriesForAllYearsGas(id);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            Boolean isAlreadyInit = false;
            for (int i = 0; i < 8; i++) {
                if (test[i].length() > 17) { // more than just year and commas
                    if (isAlreadyInit)
                        out.append(';');
                    out.println(test[i]);
                    isAlreadyInit = true;
                }
            }
            out.flush();
            out.close();
            userPath = "/WEB-INF/view/report_overview.jsp";
            isAjax = true;
        } else if (userPath.equals("/sign_off")) {
            request.getSession().invalidate(); // used to work properly
            response.sendRedirect("./"); // to welcome page
        } else if (userPath.equals("/graphs_addseriesbymonth")) {
            String id = request.getParameter("id");
            Integer month = Integer.parseInt(request.getParameter("month")); 
            Integer year = Integer.parseInt(request.getParameter("year")); 
            String test = graphingManager.addSeriesbyMonth(id, month, year);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(test);
            out.flush();
            out.close();
            userPath = "/WEB-INF/view/report_overview.jsp";
            isAjax = true;
        } else if (userPath.equals("/graphs_addseriesbymonthyear")) {
            String id = request.getParameter("id");
            Integer month = Integer.parseInt(request.getParameter("month")); 
            Integer year = Integer.parseInt(request.getParameter("year")); 
            String test = graphingManager.addSeriesbyMonthYear(id, month, year);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(test);
            out.flush();
            out.close();
            userPath = "/WEB-INF/view/report_overview.jsp";
            isAjax = true;            
        } else if (userPath.equals("/graphs_monthlyEnergyCosts")) {
            String test = graphingManager.monthlyEnergyCosts();
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(test);
            out.flush();
            out.close();
            userPath = "/WEB-INF/view/report_overview.jsp";
            isAjax = true;

        } else if (userPath.equals("/tenant")) {
            userPath = "/WEB-INF/view/report_tenant.jsp";
        } else if (userPath.equals("/setup_entry")) {
            userPath = "/WEB-INF/view/entry.jsp";
        } else if (userPath.equals("/edit_bills")) {
            userPath = "/WEB-INF/view/bills.jsp";
        } else if (userPath.equals("/setup_pcentry")) {
            returnTran = pcBillController.DoSetupBill(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/setup_client")) {
            if (gCurrentUser.getIsSuperUser()) { 
                returnTran = clientController.DoSetupClient(request, response, gCurrentUser.getIsSuperUser());
                request = returnTran.getRequest();
                response = returnTran.getResponse();
                userPath = returnTran.getRedirectionPath();
            }
            else {      // ] if (gCurrentUser.getIsAdmin()) { 
                request.setAttribute("showform", true);
                request.setAttribute("clientinfo", gClient);
                Financial financial =financialManager.findFinancialByClientId(gClientId);
                if (financial != null) {
                    //showForm = true;
                    request.setAttribute("financialinfo", financial);
                } else {
                    request.setAttribute("result", "<font color='red'>Client Financial edit failed. Please try again.</font>");
                }
                userPath = "/WEB-INF/view/edit_client.jsp";
            }
        } else if (userPath.equals("/setup_financial")) {
            returnTran = financeController.DoSetupFinancial(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/setup_building")) {
            returnTran = siteController.DoSetupSite(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = "/WEB-INF/view/setup_building.jsp";
        } else if (userPath.equals("/setup_schedule")) {
            userPath = "/WEB-INF/view/setup_schedule.jsp";
        } else if (userPath.equals("/setup_energy")) {
            returnTran = energyController.DoSetupEnergy(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/setup_meter")) {
            returnTran = meterController.DoSetupMeter(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/setup_ws")) {
            returnTran = weatherController.DoSetupWS(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/setup_zone")) {
            returnTran = zoneController.DoSetupZone(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/setup_circuits")) {
            String siteIdStr = request.getParameter("siteId");
            Integer siteId;
            if ((siteIdStr != null) && (siteIdStr != "null")) {
                siteId = Integer.parseInt(siteIdStr);
            } else {
                siteId = -1;
            }

            List sitesList = new ArrayList();
            List circuitMeterList = new ArrayList();
            List panelList = new ArrayList();
            List enduseList = new ArrayList();
            List zoneList = new ArrayList();

            sitesList = sitesFacade.findAll();
            if (siteId == -1) {
                if (sitesList.size() > 0) {
                    Sites site = (Sites) sitesList.get(0);
                    siteId = site.getId();
                }
            }
//                DoGetListsBySiteID(siteId, circuitMeterList, panelList, zoneList);
            circuitMeterList = multicircuitmeterManager.findMulticircuitmetersBySiteId(siteId);
            panelList = panelManager.findPanelsBySiteId(siteId);
            zoneList = zoneManager.findZonesBySiteId(siteId);
            enduseList = endusecategoryFacade.findAll();

            request.setAttribute("sitesList", sitesList);
            request.setAttribute("circuitMeterList", circuitMeterList);
            request.setAttribute("panelList", panelList);
            request.setAttribute("enduseList", enduseList);
            request.setAttribute("zoneList", zoneList);
            request.setAttribute("selected", siteId);
            userPath = "/WEB-INF/view/setup_circuits.jsp";

        } else if (userPath.equals("/updateCircuitBySite")) {
            String siteIdStr = request.getParameter("siteId");
            Integer siteId;
            if ((siteIdStr != null) && (siteIdStr != "null")) {
                siteId = Integer.parseInt(siteIdStr);
            } else {
                siteId = -1;
            }
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();

            String retStr = "";
            Multicircuitmeter currCircuitmeter;
            Panel currPanel;
            Zones currZone;
            List circuitMeterList = new ArrayList();
            List panelList = new ArrayList();
            List zoneList = new ArrayList();

            circuitMeterList = multicircuitmeterManager.findMulticircuitmetersBySiteId(siteId);
            panelList = panelManager.findPanelsBySiteId(siteId);
            zoneList = zoneManager.findZonesBySiteId(siteId);

            Iterator<Multicircuitmeter> iter = circuitMeterList.iterator();
            retStr += "cmmeter,";
            while (iter.hasNext() == true) {
                currCircuitmeter = iter.next();
                retStr += "<option value='" + currCircuitmeter.getIdmultiCircuitMeter() + "'>" + currCircuitmeter.getMACaddress() + "</option>";
            }
            retStr += ";";

            Iterator<Panel> paneliter = panelList.iterator();
            retStr += "cpanel,";
            while (paneliter.hasNext() == true) {
                currPanel = paneliter.next();
                retStr += "<option value='" + currPanel.getIdPanel() + "'>" + currPanel.getName() + "</option>";
            }
            retStr += ";";

            Iterator<Zones> zoneiter = zoneList.iterator();
            retStr += "czone,";
            while (zoneiter.hasNext() == true) {
                currZone = zoneiter.next();
                retStr += "<option value='" + currZone.getIdzones() + "'>" + currZone.getName() + "</option>";
            }

            out.println(retStr);
            out.flush();
            out.close();

            isAjax = true;
            userPath = "/WEB-INF/view/setup_circuits.jsp";

        } else if (userPath.equals("/setup_panel")) {
            Setup_panel_add(request, response);
            userPath = "/WEB-INF/view/setup_panel.jsp";
        } else if (userPath.equals("/bills")) {
            userPath = "/WEB-INF/view/bills.jsp";
        } else if (userPath.equals("/edit_pcbills")) {
            returnTran = pcBillController.DoEditBills(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/dashboard")) {
            try {
                SetupDashboardPage(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
//            try {
//                GetDashboardInfoByCddHdd(request, response);
//            } catch (ParseException ex) {
//                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } else if (userPath.equals("/setup_user")) {
            returnTran = userController.DoSetupUser(request, response, gClientId); // , currentUser.getIsSuperUser());
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            if (gCurrentUser.getIsSuperUser() || gCurrentUser.getIsAdmin()) 
                userPath = "/WEB-INF/view/setup_user.jsp";
            else
                userPath = "/WEB-INF/view/edit_user.jsp";
        } else if (userPath.equals("/setup_new_user")) {
            userPath = "/WEB-INF/view/setup_new_user.jsp";
        } else if (userPath.equals("/edit_user")) {
            returnTran = userController.DoEditUser(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;
        } else if (userPath.equals("/edit_user_remove")) {
            returnTran = userController.DoRemoveUser(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_client")) {
            returnTran = clientController.DoEditClient(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;
        } else if (userPath.equals("/edit_meter")) {
            returnTran = meterController.DoEditMeter(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;            
        } else if (userPath.equals("/edit_ws")) {
            returnTran = weatherController.DoEditWS(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;            
        } else if (userPath.equals("/edit_client_remove")) {
            returnTran = clientController.DoRemoveClient(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/edit_building_remove")) {
            returnTran = siteController.DoRemoveSite(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_financial_remove")) {
            returnTran = financeController.DoRemoveFinancial(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/edit_schedule_remove")) {
            returnTran = scheduleController.DoRemoveSchedule(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_zone_remove")) {
            returnTran = zoneController.DoRemoveZone(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
         } else if (userPath.equals("/edit_meter_remove")) {
            returnTran = meterController.DoRemoveMeter(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();           
         } else if (userPath.equals("/edit_bill_remove")) {
            returnTran = billController.DoRemoveBill(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();           
         } else if (userPath.equals("/edit_ws_remove")) {
            returnTran = weatherController.DoRemoveWS(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();           
        } else if (userPath.equals("/edit_pcbill_remove")) {
            returnTran = pcBillController.DoRemoveBill(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_energy_remove")) {
            returnTran = energyController.DoRemoveEnergy(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_energy")) {
            returnTran = energyController.DoEditEnergy(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;
        } else if (userPath.equals("/edit_financial")) {
            returnTran = financeController.DoEditFinancial(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;            
        } else if (userPath.equals("/edit_zone")) {
            returnTran = zoneController.DoEditZone(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;
        } else if (userPath.equals("/edit_schedule")) {
            returnTran = scheduleController.DoEditSchedule(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;
        } else if (userPath.equals("/edit_building")) {
            returnTran = siteController.DoEditSite(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;
        } else if (userPath.equals("/edit_bill")) {
            returnTran = billController.DoEditBill(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;            
        } else if (userPath.equals("/edit_pcbill")) {
            returnTran = pcBillController.DoEditBill(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
            isAjax = false;            
        }
        if (userPath.equals("/getMeterInfo")) {
            String meterIdStr = request.getParameter("meterNum");
            Integer meterId = Integer.parseInt(meterIdStr);
            gMeter = metersFacade.find(meterId);
//            gSite = sitesFacade.find(gMeter.getSitesId());
            int siteID = gMeter.getSitesId();
            gSite = siteManager.findSiteById(siteID);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Site Name: " + gSite.getName());
            out.println("Site Address: " + gSite.getAddress1());
            out.println("Account Number: " + gMeter.getAccountNum());
            out.println("Fuel Type: " + gMeter.getFuelType());
            out.println("Provider: " + gMeter.getProviderName());
            out.flush();
            out.close();
            userPath = "/WEB-INF/view/entry.jsp";
            isAjax = true;
        }

        if (userPath.equals("/getMeters")) {
            Sites currSite;
            List sitesList = new ArrayList();
            sitesList = sitesManager.findSitesByClientId(gClientId);
        
            Meters currMeter;
            List metersList = new ArrayList();
            String meterType = request.getParameter("meterType");
            //metersList = metersFacade.findByResourceType(meterType);

            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
// find sites belonging to client
            Iterator<Sites> siteIter = sitesList.iterator();
            while (siteIter.hasNext() == true) {
                currSite = siteIter.next();
                // find meters belonging to site
                metersList = metersManager.findMetersBySiteId(currSite.getId());
                Iterator<Meters> meterIter = metersList.iterator();
                while (meterIter.hasNext() == true) {
                    currMeter = meterIter.next();    
                    if (currMeter.getFuelType() == null ? meterType == null : currMeter.getFuelType().equals(meterType))
                        out.println("<option value='" + currMeter.getId() + "'>" + currMeter.getTextID() + "</option>");
                }
            }
            out.flush();
            out.close();
            userPath = "/WEB-INF/view/entry.jsp";
            isAjax = true;
        }
        if (userPath.equals("/getBills")) {
            List billsList = new ArrayList();
            Bills currBill;

            String meterTypeStr = request.getParameter("meterType");
            String meterIdStr = request.getParameter("meterNum");
            Integer meterId = Integer.parseInt(meterIdStr);
            // get sites belonging to client
//            sitesList = sitesManager.findSitesByClientId(gClientId);
//            Iterator<Sites> iter = sitesList.iterator();
//            while (sitesIter.hasNext() == true) {
                
                billsList = billManager.findBillsByMeterId(meterId);
                Iterator<Bills> iter = billsList.iterator();

                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();
                out.println("<table id='grid' summary='Bill History'>");
                out.println("<thead>");
                out.println("<tr><th scope='col'>Start Date</th><th scope='col'>End Date</th><th scope='col'>Amount</th><th scope='col'>Bill Total</th><th scope='col'>edit</th><th scope='col'>delete</th></tr>");
                out.println("</thead><tbody>");

                while (iter.hasNext() == true) {
                    currBill = iter.next();
//                    if (currBill.getMetersId() == meterId) {
                        out.println("<tr><td>" + currBill.getDateStart() + "</td>");
                        out.println("<td>" + currBill.getDateEnd() + "</td>");
                        out.println("<td>" + currBill.getAmount() + "</td>");
                        out.println("<td>" + currBill.getCost() + "</td>");
//                        out.println("<td>" + currBill.getInternalID() + "</td>");
//                        if (currBill.getPdfId() != null) {
//                            out.println("<td><a href='bill_viewImg?id=" + currBill.getPdfId() + "'>PDF</a></td>");
//                        } else {
//                            out.println("<td>&nbsp;</td>");
//                        }
                        out.println("<td><a href='edit_bill?meterNum=" + meterIdStr + "&meterType=" + meterTypeStr + "&billid=" + currBill.getId() + "'>edit</a></td>");
                        out.println("<td><a href='edit_bill_remove?meterNum=" + meterIdStr + "&meterType=" + meterTypeStr + "&billid=" + currBill.getId() + "'>delete</a></td></tr>");

//                    }
                }
//            }
            userPath = "/WEB-INF/view/bills.jsp";

            out.flush();
            out.close();
            isAjax = true;
        }
        if (userPath.equals("/getPCBillsInfo")) {
            String bldgStr = request.getParameter("building");
            Integer siteId = Integer.parseInt(bldgStr);
            //gMeter = metersFacade.find(meterId);
            gSite = siteManager.findSiteById(siteId);
            response.setContentType("text/plain");
            userPath = "/WEB-INF/view/pcentry.jsp";
            isAjax = true;
        }

        if (userPath.equals("/getPCBills")) {
            List billsList = new ArrayList();
            PCBills currBill;
            String siteIdStr = request.getParameter("siteID");
            Integer siteId = Integer.parseInt(siteIdStr);
            billsList = pcBillManager.findPCbillsBySiteId(siteId);
            Iterator<PCBills> iter = billsList.iterator();

            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("<table id='grid' summary='Bill History'>");
            out.println("<thead>");
            out.println("<tr><th scope='col'>Start Date</th><th scope='col'>End Date</th><th scope='col'>Amount</th><th scope='col'>Bill Total</th><th scope='col'>edit</th><th scope='col'>delete</th></tr>");
            out.println("</thead><tbody>");

            while (iter.hasNext() == true) {
                currBill = iter.next();
                if (currBill.getSitesId() == siteId) {
                    out.println("<tr><td>" + currBill.getDateStart() + "</td>");
                    out.println("<td>" + currBill.getDateEnd() + "</td>");
                    out.println("<td>" + currBill.getAmount() + "</td>");
                    out.println("<td>" + currBill.getCost() + "</td>");
                    out.println("<td><a href='edit_pcbill?sitesid=" + siteIdStr + "&billid=" + currBill.getId() + "'>edit</a></td>");
                    out.println("<td><a href='edit_pcbill_remove?sitesID=" + siteIdStr + "&billid=" + currBill.getId() + "'>delete</a></td></tr>");

                }
            }
            userPath = "/WEB-INF/view/bills.jsp";

            out.flush();
            out.close();
            isAjax = true;
        }
        if (userPath.equals("/bill_viewImg")) {
            String idStr = request.getParameter("id");
            Integer pdfId = Integer.parseInt(idStr);
            Pdf pdf = new Pdf();


            pdf = pdfFacade.find(pdfId);
            int DEFAULT_BUFFER_SIZE = (int) pdf.getFilesize();


            byte[] b = pdf.getContent();
            response.setContentType(pdf.getFiletype());
            response.setContentLength((int) pdf.getFilesize());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + pdf.getFilename() + "\"");
            response.setBufferSize(DEFAULT_BUFFER_SIZE);
            Blob blobfile = null;

            try {
                blobfile = new SerialBlob(b);
            } catch (SerialException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }


            InputStream is = null;

            try {
                is = blobfile.getBinaryStream();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            BufferedInputStream input = null;
            BufferedOutputStream output = null;


            try {
                // Open streams.
                input = new BufferedInputStream(is, DEFAULT_BUFFER_SIZE);
                output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);


                // Write file contents to response.
                byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
            } finally {
                // Gently close streams.
                output.close();
                input.close();
            }

            isAjax = true;
        }

        if (userPath.equals("/edit_bills")) {
            Bills currBill;
            String idStr = request.getParameter("id");
            Integer billId = Integer.parseInt(idStr);
            String typeStr = request.getParameter("type");

            currBill = billsFacade.find(billId);
            request.setAttribute("bill", currBill);

            if (typeStr.equals("Electric")) {
                userPath = "/WEB-INF/view/bill_edit_elec.jsp";
            }
//            if (typeStr.equals("Natual Gas")) {
//                userPath = "/WEB-INF/view/bill_edit_natgas.jsp";
//            }
//            if (typeStr.equals("Propane")) {
//                userPath = "/WEB-INF/view/bill_edit_prop.jsp";
//            }
//            if (typeStr.equals("Waste")) {
//                userPath = "/WEB-INF/view/bill_edit_waste.jsp";
//            }
//            if (typeStr.equals("Water")) {
//                userPath = "/WEB-INF/view/bill_edit_water.jsp";
//            }
            isAjax = false;
        }

        if (userPath.equals("/sendPolicy")) {
            try {
                SetPolicy(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            userPath = "/WEB-INF/view/dashboard.jsp";
        }

        if (userPath.equals("/sendPolicyBuilding")) {
            try {
                SetPolicyBuilding(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            userPath = "/WEB-INF/view/dashboard.jsp";
        }

        if (userPath.equals("/dashboard_recalc")) {
            try {
                RecalculateDashboardPaybackScenario(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            userPath = "/WEB-INF/view/dashboard.jsp";
            isAjax = true;

        }

        if (userPath.equals("/dashboard_recalcByBuilding")) {
            try {
                RecalculatePaybackScenarioByBuilding(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            userPath = "/WEB-INF/view/dashboard.jsp";
            isAjax = true;

        }

        if (userPath.equals("/scenario")) {
            try {
                SetupScenarioPage(request, response, gClientId);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            List sitesList = new ArrayList();
            // ClientId is hard coded for now.  in the future, we have to assign ClientId from the database.
            try {
                sitesList = sitesManager.findSitesByClientId(gClientId);
            } catch (Exception e) {
                userPath = "";
            }
            Sites site = new Sites();
            if (sitesList.size() > 0) 
                site = (Sites) sitesList.get(0);
                //Energy energy = new Energy();
                //try {
                //    energy = energyManager.findSiteEnergyBySiteId(site.getId());
                //} catch (Exception ex) {
                //    userPath = "";
                //}

            request.setAttribute("setpoints_b", site);
            request.setAttribute("sitesList", sitesList);
         

            userPath = "/WEB-INF/view/scenario.jsp";
            isAjax = false;
        }

        if (userPath.equals("/hvac")) {
            userPath = "/WEB-INF/view/hvac.jsp";
            isAjax = false;
        }

        if (userPath.equals("/alerts")) {
            userPath = "/WEB-INF/view/alerts.jsp";
            isAjax = false;
        }

        if (userPath.equals("/lighting")) {
            userPath = "/WEB-INF/view/lighting.jsp";
            isAjax = false;
        }

        if (userPath.equals("/parseweather")) {
            String[] result = null;
            Calendar startDateCal = Calendar.getInstance();
            startDateCal.set(2008, 6, 1);
            Calendar endDateCal = Calendar.getInstance();
            Date startDate = startDateCal.getTime();
            Date endDate = endDateCal.getTime();
            Client client = clientFacade.find(gClientId);
            List sitesList = new ArrayList();
            Sites site = null;
            sitesList = sitesManager.findSitesByClientId(gClientId);

            Iterator<Sites> iter = sitesList.iterator();
            if (iter.hasNext() == true) {
                site = iter.next();
                Integer weatherStationID = site.getWeatherStationid();
                Weatherstation ws = weatherManager.findWeatherstationById(weatherStationID);
//                Weatherstation ws = site.getWeatherStationid();
                result = weatherManager.getHddCddfromAirportCode(65, 65, startDate, endDate, ws);
            }
        }

        if (userPath.equals("/getBuildingSetPoints")) {
            String siteIdStr = request.getParameter("siteId");
            int siteId = 0;
            if ((siteIdStr != null) && (siteIdStr != "null")) {
                siteId = Integer.parseInt(siteIdStr);
            }
            Sites site = sitesManager.findSiteById(siteId);

            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            String outStr = new String();

            outStr = "light_b-input:" + site.getPercentMaxLightSetting() + ";";
            outStr += "heat_b-input:" + site.getSetpointHeatOcc() + ";";
            outStr += "cool_b-input:" + site.getSetpointCoolOcc() + ";";
            outStr += "heatUO_b-input:" + site.getSetpointHeatUnocc() + ";";
            outStr += "coolUO_b-input:" + site.getSetpointCoolUnocc() + ";";
            outStr += "coolUO_b-input:" + site.getSetpointCoolUnocc() + ";";
            outStr += "isOverride:" + site.getIsOverride() + ";";
//            if (site.getIsOverride()) {
//                outStr += "IsOverride:true;";
//                request.setAttribute("isOverride", "true");
//            } else {
//                outStr += "IsOverride:false;";
//                request.setAttribute("isOverride", "false");
//            }
            out.println(outStr);

//            userPath = "/WEB-INF/view/scenario.jsp";

            out.flush();
            out.close();
            isAjax = true;

        }

        // use RequestDispatcher to forward request internally
        String url = userPath;

        if (!isAjax) {
            try {
                request.getRequestDispatcher(url).forward(request, response);
            } catch (Exception ex) {
//                ex.printStackTrace();
            }
        }

    }

    private static String getFilename(Part part) throws MessagingException {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private static String getValue(Part part) throws IOException, MessagingException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
        StringBuilder value = new StringBuilder();
        char[] buffer = new char[1024];
        for (int length = 0; (length = reader.read(buffer)) > 0;) {
            value.append(buffer, 0, length);
        }
        return value.toString();
    }

    void DoAddPanel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("pname");
        String strBuilding = request.getParameter("pbuilding");
        String strParentPanel = request.getParameter("pparent");
        int idBuilding = -1;
        String strParentCircuitNum = request.getParameter("pparentPanelCircuitNum");
        int parentCircuitNum = -1;
        Circuit parentCircuit = null;
        if ((strParentCircuitNum != null) && (!strParentCircuitNum.isEmpty())) {
            parentCircuit = circuitManager.findCircuitByName(strParentCircuitNum);
        }
        Sites building = null;
        if ((strBuilding != null) && (!strBuilding.isEmpty())) {
            idBuilding = Integer.parseInt(strBuilding);
            building = siteManager.findSiteById(idBuilding);
        }
//            int parentPanelID = 0;
//            if (strParentPanel != null)
//                parentPanelID = Integer.parseInt(strParentPanel);
        Panel parentPanel = null;
        if (strParentPanel != null) {
            parentPanel = panelManager.findPanelByName(strParentPanel);
        }

//            if (!parentPanel.equals(null))
        String panelAdded = panelManager.addPanel(name, building, parentPanel, parentCircuit);
        if (panelAdded.equals("false")) {
            request.setAttribute("result", "<font color='red'>Add Panel failed.  Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>Panel " + panelAdded + " added successfully.</font>");
        }
        userPath = "/WEB-INF/view/setup_panel.jsp";
    }

    void DoAddCircuit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String strBuilding = request.getParameter("cbuilding");
        String strMulticirId = request.getParameter("cmmeter");
        String strMeterNo = request.getParameter("cmulticirmeternum");
        String strPhase = request.getParameter("cphase");
        String strPanel = request.getParameter("cpanel");
        String strIsPanelInput = request.getParameter("isinput");
        String strEndUseId = request.getParameter("cenduse");
        String strZoneId = request.getParameter("czone");
        String strName = request.getParameter("cmetername");
        int zoneId = -1;
        int enduseId = -1;
        int panelId = -1;
        int multicirId = -1;
        int meterNo = -1;
        int phaseNo = -1;

        boolean isPanelInput = false;
        if (strIsPanelInput != null) {
            if (strIsPanelInput.equals("true")) {
                isPanelInput = true;
            }
        }
        if ((strMeterNo != null) && (!strMeterNo.isEmpty())) {
            meterNo = Integer.parseInt(strMeterNo);
        }
        if ((strPhase != null) && (!strPhase.isEmpty())) {
            phaseNo = Integer.parseInt(strPhase);
        }

        Zones zone = null;
        if ((strZoneId != null) && (!strZoneId.isEmpty())) {
            zoneId = Integer.parseInt(strZoneId);
            zone = zoneManager.findZoneById(zoneId);
        }
        Endusecategory enduse = null;
        if ((strEndUseId != null) && (!strEndUseId.isEmpty())) {
            enduseId = Integer.parseInt(strEndUseId);
            enduse = endusecategoryFacade.find(enduseId);
        }
        Panel panel = null;
        if ((strEndUseId != null) && (!strEndUseId.isEmpty())) {
            panelId = Integer.parseInt(strPanel);
            panel = panelFacade.find(panelId);
        }
        Multicircuitmeter multicircuitmeter = null;
        if ((strEndUseId != null) && (!strEndUseId.isEmpty())) {
            multicirId = Integer.parseInt(strMulticirId);
            multicircuitmeter = multicircuitmeterFacade.find(multicirId);
        }

        String circuitAdded = circuitManager.addCircuit(strName, isPanelInput, phaseNo, panel, multicircuitmeter, meterNo, zone, enduse);
        if (circuitAdded.equals("false")) {
            request.setAttribute("result", "<font color='red'>Add Circuit failed.  Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>Panel " + circuitAdded + " added successfully.</font>");
        }
        userPath = "/WEB-INF/view/setup_circuits.jsp";
    }

    void DoAddBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String meterIdStr = null;
//        String pdfIdStr = null;
        Date billStart = null;
        Date billEnd = null;
        Date billDate = null;        
        Integer readStart = null;
        Integer readEnd = null;
        float amount = 0;
        float demand = 0;
        float peakDemand = 0;
        float powerFactor = 0;
        float kva = 0;
        float loadFactor = 0;
        BigDecimal cost = null;
        BigDecimal costDemand = null;
        BigDecimal costUsage = null;
        BigDecimal costDistDemand = null;
        BigDecimal costDistUsage = null;
        BigDecimal surchargeAsPercent = null;
        BigDecimal taxAmount = null;
        Integer usageThreshold = null;
        BigDecimal costAboveThreshold = null;
        Integer offPeakEnergy = null;
        BigDecimal offPeakDiscount = null;
        String tryname = null;
        String filename = null;
        long fileSize = 0;
        String contentType = null;
        InputStream fileContent;
        byte[] bytes = null;
        DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");

        for (Part part : request.getParts()) {
            try {
                tryname = getFilename(part);
            } catch (MessagingException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (tryname == null) {
                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                String fieldname = part.getName();
                String fieldvalue = null;
                try {
                    fieldvalue = getValue(part);
                } catch (MessagingException ex) {
                    Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                if ((fieldvalue != "null") && (fieldvalue != null)) {
                    if ("meterNumber".equals(fieldname)) {
                        meterIdStr = fieldvalue;
                    }
                    if ("billStart".equals(fieldname)) {
                        billStart = (Date) formatter.parse(fieldvalue);
                    }
                    if ("billEnd".equals(fieldname)) {
                        billEnd = (Date) formatter.parse(fieldvalue);
                    }
                    if ("billDate".equals(fieldname)) {
                        billDate = (Date) formatter.parse(fieldvalue);
                    }                
                    if ("readStart".equals(fieldname)) {
                        readStart = Integer.parseInt(fieldvalue);
                    }
                    if ("readEnd".equals(fieldname)) {
                        readEnd = Integer.parseInt(fieldvalue);
                    }
                    if ("amount".equals(fieldname)) {
                        amount = Float.valueOf(fieldvalue).floatValue();
                    }
                    if ("demand".equals(fieldname)) {
                        demand = Float.valueOf(fieldvalue).floatValue();
                    }
                    if ("peakDemand".equals(fieldname)) {
                        peakDemand = Float.valueOf(fieldvalue).floatValue();
                    }
                    if ("powerFactor".equals(fieldname)) {
                        powerFactor = Float.valueOf(fieldvalue).floatValue();
                    }
                    if ("kva".equals(fieldname)) {
                        kva = Float.valueOf(fieldvalue).floatValue();
                    }
                    if ("loadFactor".equals(fieldname)) {
                        loadFactor = Float.valueOf(fieldvalue).floatValue();
                    }
                    if ("cost".equals(fieldname)) {
                        cost = new BigDecimal(fieldvalue);
                    }
                    if ("costDemand".equals(fieldname)) {
                        costDemand = new BigDecimal(fieldvalue);
                    }
                    if ("costUsage".equals(fieldname)) {
                        costUsage = new BigDecimal(fieldvalue);
                    }
                    if ("costDistDemand".equals(fieldname)) {
                        costDistDemand = new BigDecimal(fieldvalue);
                    }
                    if ("costDistUsage".equals(fieldname)) {
                        costDistUsage = new BigDecimal(fieldvalue);
                    }
                    if ("surchargeAsPercent".equals(fieldname)) {
                        surchargeAsPercent = new BigDecimal(fieldvalue);
                    }
                    if ("taxAmount".equals(fieldname)) {
                        taxAmount = new BigDecimal(fieldvalue);
                    }
                    if ("usageThreshold".equals(fieldname)) {
                        usageThreshold = Integer.parseInt(fieldvalue);
                    }
                    if ("costAboveThreshold".equals(fieldname)) {
                        costAboveThreshold = new BigDecimal(fieldvalue);
                    }
                    if ("offPeakEnergy".equals(fieldname)) {
                        offPeakEnergy = Integer.parseInt(fieldvalue);
                    }
                    if ("offPeakDiscount".equals(fieldname)) {
                        offPeakDiscount = new BigDecimal(fieldvalue);
                    }
                }
                } catch (Exception ex) {
                }
            } else if (!tryname.isEmpty()) {
                // Process form file field (input type="file").
                filename = tryname.substring(tryname.lastIndexOf('/') + 1).substring(tryname.lastIndexOf('\\') + 1); // MSIE fix.
                fileContent = part.getInputStream();
                bytes = IOUtils.toByteArray(fileContent);

                //                    pdf.setName(filename);
                contentType = part.getContentType();
                fileSize = part.getSize();
                //                    pdf.setContent(bytes);
            }
        }

        // ...
        Integer meterId = -1;
        Integer pdfId = -1;
        int retValue = -1;
        if ((meterIdStr != null) && !meterIdStr.isEmpty() && (meterIdStr != "null")) {
            //                pdf = PDFmanager.storePdf(filename, contentType, fileSize, bytes);
            meterId = Integer.parseInt(meterIdStr);
            gMeter = metersFacade.find(meterId);
//(Meters meter, Date billStart, Date billEnd, Integer readStart, Integer readEnd, float amount,
//            BigDecimal cost, float demand, float peakDemand, float powerFactor, float kva, float loadFactor, BigDecimal costDemand, BigDecimal costUsage, BigDecimal costDistDemand,
//            BigDecimal costDistUsage, BigDecimal surchargeAsPercent, BigDecimal taxAmount, Integer usageThreshold, BigDecimal costAboveThreshold, Integer offPeakEnergy, BigDecimal offPeakDiscount)
            retValue = billManager.addBill(gMeter, billStart, billEnd, readStart, readEnd, amount,
                    cost, demand, peakDemand, powerFactor, kva, loadFactor, costDemand, costUsage, costDistDemand,
                    costDistUsage, surchargeAsPercent, taxAmount, usageThreshold, costAboveThreshold, offPeakEnergy, offPeakDiscount);
            if (retValue == 0)
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, "Attempted Add Bill");


        }


    }

   void DoAddPCBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String buildingStr = null;
        Date billStart = null;
        Date billEnd = null;
        Date billDate = null;
        float amount = 0;
        String fuelType = "electric";
        BigDecimal cost = null;
        String tryname = null;
        String filename = null;
        long fileSize = 0;
        String contentType = null;
        InputStream fileContent;
        byte[] bytes = null;
        DateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd");

        for (Part part : request.getParts()) {
            try {
                tryname = getFilename(part);
            } catch (MessagingException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (tryname == null) {
                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                String fieldname = part.getName();
                String fieldvalue = null;
                try {
                    fieldvalue = getValue(part);
                } catch (MessagingException ex) {
                    Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                if ("building".equals(fieldname)) {
                    buildingStr = fieldvalue;
                }
                if ("billStart".equals(fieldname)) {
                    billStart = (Date) formatter.parse(fieldvalue);
                }
                if ("billEnd".equals(fieldname)) {
                    billEnd = (Date) formatter.parse(fieldvalue);
                }
                if ("billDate".equals(fieldname)) {
                    billDate = (Date) formatter.parse(fieldvalue);
                }
                if ("amount".equals(fieldname)) {
                    amount = Float.valueOf(fieldvalue).floatValue();
                }
                if ("cost".equals(fieldname)) {
                    cost = new BigDecimal(fieldvalue);
                }
                if ("resource".equals(fieldname)) {
                    fuelType = fieldvalue;
                }
                } catch (Exception ex) {
                }
            } else if (!tryname.isEmpty()) {
                // Process form file field (input type="file").
                filename = tryname.substring(tryname.lastIndexOf('/') + 1).substring(tryname.lastIndexOf('\\') + 1); // MSIE fix.
                fileContent = part.getInputStream();
                bytes = IOUtils.toByteArray(fileContent);
                contentType = part.getContentType();
                fileSize = part.getSize();
            }
        }

        Integer buildingId = -1;
        Integer pdfId = -1;
        Sites sites = new Sites();
        int retValue = -1;
        if ((buildingStr != null) && !buildingStr.isEmpty() && (buildingStr != "null")) {
            //                pdf = PDFmanager.storePdf(filename, contentType, fileSize, bytes);
            buildingId = Integer.parseInt(buildingStr);
            sites = sitesFacade.find(buildingId);
            try {
                retValue = pcBillManager.addBill(sites, billDate, billStart, billEnd, fuelType, amount, cost);
                
            } catch (Exception e) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, "Attempted Add PC Bill");
            }

        }

    }

    
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        userPath = request.getServletPath();
        TransactionType returnTran;
        String userName = request.getRemoteUser();
        Users user = userManager.findUserByName(userName);
        gCurrentUserId = user.getId();
        gClientId = user.getClientidClient();
        

        if (userPath.equals("/add_bill")) {
//            returnTran = billController.DoAddBill(request, response, gClientId);
//            request = returnTran.getRequest();
//            response = returnTran.getResponse();
            try {
                DoAddBill(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            userPath = "/WEB-INF/view/entry.jsp";
        } else if (userPath.equals("/add_pcbill")) {
//            returnTran = pcBillController.DoAddBill(request, response, gClientId);
//            request = returnTran.getRequest();
//            response = returnTran.getResponse();
            try {
                DoAddPCBill(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            userPath = "/WEB-INF/view/pcentry.jsp";         
        } else if (userPath.equals("/admin")) {
            userPath = "/WEB-INF/view/dashboard.jsp";
        } else if (userPath.equals("/add_zone")) {
            returnTran = zoneController.DoAddZone(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/add_ws")) {
            returnTran = weatherController.DoAddWS(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/add_panel")) {
            DoAddPanel(request, response);
        } else if (userPath.equals("/add_schedule")) {
            returnTran = scheduleController.DoAddSchedule(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/add_energy")) {
            returnTran = energyController.DoAddEnergy(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/add_meter")) {
            returnTran = meterController.DoAddMeter(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/add_financial")) {
            returnTran = financeController.DoAddFinancial(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/add_building")) {
            returnTran = siteController.DoAddSite(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
       } else if (userPath.equals("/add_client")) {
            returnTran = clientController.DoAddClient(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/add_user")) {
            returnTran = userController.DoAddUser(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/add_new_user")) {
            returnTran = userController.DoAddNewUser(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();        
        } else if (userPath.equals("/edit_user_update")) {
            returnTran = userController.DoEditUserUpdate(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_meter_update")) {
            returnTran = meterController.DoEditMeterUpdate(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/edit_bill_update")) {
            returnTran = billController.DoEditBillUpdate(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/edit_ws_update")) {
            returnTran = weatherController.DoEditWSUpdate(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/edit_financial_update")) {
            returnTran = financeController.DoEditFinancialUpdate(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/edit_building_update")) {
            returnTran = siteController.DoEditSiteUpdate(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_zone_update")) {
            returnTran = zoneController.DoEditZoneUpdate(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_client_update")) {
            returnTran = clientController.DoEditClientUpdate(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/edit_schedule_update")) {
            returnTran = scheduleController.DoEditScheduleUpdate(request, response);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/edit_pcbill_update")) {
            returnTran = pcBillController.DoEditBillUpdate(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();            
        } else if (userPath.equals("/edit_energy_update")) {
            returnTran = energyController.DoEditEnergyUpdate(request, response, gClientId);
            request = returnTran.getRequest();
            response = returnTran.getResponse();
            userPath = returnTran.getRedirectionPath();
        } else if (userPath.equals("/add_circuit")) {
            DoAddCircuit(request, response);
        }

        // use RequestDispatcher to forward request internally
        try {
            request.getRequestDispatcher(userPath).forward(request, response);
        } catch (Exception ex) {
            //          ex.printStackTrace();
        }

    }
}