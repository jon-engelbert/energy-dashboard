/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// JON:  THE ENERGY CLASS IS OBSOLETE.  IT HAS BEEN MERGED INTO THE BUILDING/SITE CLASS
package controller;

import entity.*;
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
 * @author worman
 */
@Stateless
@LocalBean
public class ControllerEnergy {
// JON:  THE ENERGY CLASS IS OBSOLETE.  IT HAS BEEN MERGED INTO THE BUILDING/SITE CLASS
    @EJB
    private ClientFacade clientFacade;
    @EJB
    private SitesFacade sitesFacade;
    @EJB
    private ScheduleFacade scheduleFacade;
    @EJB
    private ZonesFacade zonesFacade;
    @EJB
    private EndusecategoryFacade endusecategoryFacade;
    @EJB
    private EnergyFacade energyFacade;
    @EJB
    private EnergyManager energyManager;

// JON:  THE ENERGY CLASS IS OBSOLETE.  IT HAS BEEN MERGED INTO THE BUILDING/SITE CLASS
    public TransactionType DoSetupEnergy(HttpServletRequest request, HttpServletResponse response) {
        List sitesList = new ArrayList();;
        List enduseList = new ArrayList();;
        List zoneList = new ArrayList();;
        List scheduleList = new ArrayList();;
        sitesList = sitesFacade.findAll();
        zoneList = zonesFacade.findAll();
        enduseList = endusecategoryFacade.findAll();
        scheduleList = scheduleFacade.findAll();
        request.setAttribute("scheduleList", scheduleList);
        request.setAttribute("sitesList", sitesList);
        request.setAttribute("enduseList", enduseList);
        request.setAttribute("zoneList", zoneList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_energy.jsp");
        return transType;
    }

    public TransactionType DoAddEnergy(HttpServletRequest request, HttpServletResponse response, int clientID) {
        Client client = null;
        Schedule schedule = null;
        Sites site = null;
        Zones zone = null;
        Endusecategory enduse = null;
        String name = request.getParameter("bname");
        try {
            client = clientFacade.find(clientID);
        } catch (Exception e) {
        }
        schedule = scheduleFacade.find(Integer.parseInt(request.getParameter("schedule")));
        site = sitesFacade.find(Integer.parseInt(request.getParameter("building")));
        zone = zonesFacade.find(Integer.parseInt(request.getParameter("zone")));
        enduse = endusecategoryFacade.find(Integer.parseInt(request.getParameter("enduse")));
        String strWholeBuilding = request.getParameter("isWB");
        Boolean isWholeBuilding = false;
        if (strWholeBuilding != null) {
            isWholeBuilding = (strWholeBuilding.equalsIgnoreCase("on"));
        }
        String strOverride = request.getParameter("isOR");
        Boolean isOverride = false;
        if (strOverride != null) {
            isOverride = (strOverride.equalsIgnoreCase("on"));
        }
        int LightPowerOccupied = Integer.parseInt(request.getParameter("LPOCC"));
        int LightPowerUnoccupied = Integer.parseInt(request.getParameter("LPUOCC"));
        int PercentMax = Integer.parseInt(request.getParameter("PML"));
        int PercentMaxOrig = Integer.parseInt(request.getParameter("PMLO"));
        String strOnWhenDark = request.getParameter("isOWD");
        Boolean isOnWhenDark = false;
        if (strOnWhenDark != null) {
            isOnWhenDark = (strOnWhenDark.equalsIgnoreCase("on"));
        }
        int OrigCoolingPointOccupied = Integer.parseInt(request.getParameter("OCPOCC"));
        int OrigCoolingPointUnoccupied = Integer.parseInt(request.getParameter("OCPUOCC"));
        int CoolingPointOccupied = Integer.parseInt(request.getParameter("CPOCC"));
        int CoolingPointUnoccupied = Integer.parseInt(request.getParameter("CPUOCC"));
        int OrigHeatPointOccupied = Integer.parseInt(request.getParameter("OHPOCC"));
        int OrigHeatPointUnoccupied = Integer.parseInt(request.getParameter("OHPUOCC"));
        int HeatPointOccupied = Integer.parseInt(request.getParameter("HPOCC"));
        int HeatPointUnoccupied = Integer.parseInt(request.getParameter("HPUOCC"));
        int HeatSen = Integer.parseInt(request.getParameter("HES"));
        int CoolSen = Integer.parseInt(request.getParameter("CES"));
        int OldBTUpHDD = Integer.parseInt(request.getParameter("OBTUpHDD"));
        int OldOtherBTU = Integer.parseInt(request.getParameter("OBTU"));
        int NewBTUpHDD = Integer.parseInt(request.getParameter("NBTUpHDD"));
        int NewOtherBTU = Integer.parseInt(request.getParameter("NBTU"));
        int HDDToDate = Integer.parseInt(request.getParameter("HDDTD"));
        int OldKWHpCDD = Integer.parseInt(request.getParameter("OKWHpCDD"));
        int OldOtherKWH = Integer.parseInt(request.getParameter("OOKWH"));
        int NewKWHpCDD = Integer.parseInt(request.getParameter("NKWHpCDD"));
        int NewOtherKWH = Integer.parseInt(request.getParameter("NOKWH"));
        int CDDtoDate = Integer.parseInt(request.getParameter("NCDDTD"));
        int BaseHeatEnergyAnnual = Integer.parseInt(request.getParameter("BHEA"));
        int BaseCoolingEnergyAnnual = Integer.parseInt(request.getParameter("BCEA"));
        String DDDate = request.getParameter("DDDATE");
        int energyAdded = energyManager.addEnergy(client, schedule, site, zone, enduse, isWholeBuilding, isOverride, LightPowerOccupied, LightPowerUnoccupied, PercentMax, PercentMaxOrig, isOnWhenDark, OrigCoolingPointOccupied, OrigCoolingPointUnoccupied, CoolingPointOccupied, CoolingPointUnoccupied, OrigHeatPointOccupied, OrigHeatPointUnoccupied, HeatPointOccupied, HeatPointUnoccupied, CoolSen, HeatSen, OldBTUpHDD, OldKWHpCDD, OldOtherBTU, OldOtherKWH, CDDtoDate, CDDtoDate, NewBTUpHDD, NewOtherBTU, NewKWHpCDD, NewOtherKWH, BaseCoolingEnergyAnnual, BaseHeatEnergyAnnual, DDDate);
        if (energyAdded == -1) {
            request.setAttribute("result", "<font color='red'>Add Energy failed.  Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>Energy information added successfully.</font>");
        }
        List sitesList = new ArrayList();
        List enduseList = new ArrayList();
        List zoneList = new ArrayList();
        List scheduleList = new ArrayList();
        sitesList = sitesFacade.findAll();
        zoneList = zonesFacade.findAll();
        enduseList = endusecategoryFacade.findAll();
        scheduleList = scheduleFacade.findAll();
        request.setAttribute("scheduleList", scheduleList);
        request.setAttribute("sitesList", sitesList);
        request.setAttribute("enduseList", enduseList);
        request.setAttribute("zoneList", zoneList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_energy.jsp");
        return transType;
    }

    public TransactionType DoRemoveEnergy(HttpServletRequest request, HttpServletResponse response) {
        String intStr = request.getParameter("energyid");
        if (intStr != null) {
            int energyID = Integer.parseInt(intStr);
            boolean removed = energyManager.removeEnergy(energyID);
            if (removed) {
                request.setAttribute("result", "<font color='green'>Energy successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Energy remove failed.  Please try again.</font>");
            }
        }
        request.setAttribute("energyList", energyFacade.findAll());
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_energy.jsp");
        return transType;
    }

    public TransactionType DoEditEnergyUpdate(HttpServletRequest request, HttpServletResponse response, int clientID) {
        Client client = null;
        Schedule schedule = null;
        Sites site = null;
        Zones zone = null;
        Endusecategory enduse = null;
        String name = request.getParameter("bname");
        try {
            client = clientFacade.find(clientID);
        } catch (Exception e) {
        }
        schedule = scheduleFacade.find(Integer.parseInt(request.getParameter("schedule")));
        site = sitesFacade.find(Integer.parseInt(request.getParameter("building")));
        zone = zonesFacade.find(Integer.parseInt(request.getParameter("zone")));
        enduse = endusecategoryFacade.find(Integer.parseInt(request.getParameter("enduse")));
        int energyID = Integer.parseInt(request.getParameter("energyID"));
        String strWholeBuilding = request.getParameter("isWB");
        Boolean isWholeBuilding = false;
        if (strWholeBuilding != null) {
            isWholeBuilding = (strWholeBuilding.equalsIgnoreCase("on"));
        }
        String strOverride = request.getParameter("isOR");
        Boolean isOverride = false;
        if (strOverride != null) {
            isOverride = (strOverride.equalsIgnoreCase("on"));
        }
        int LightPowerOccupied = Integer.parseInt(request.getParameter("LPOCC"));
        int LightPowerUnoccupied = Integer.parseInt(request.getParameter("LPUOCC"));
        int PercentMax = Integer.parseInt(request.getParameter("PML"));
        int PercentMaxOrig = Integer.parseInt(request.getParameter("PMLO"));
        String strOnWhenDark = request.getParameter("isOWD");
        Boolean isOnWhenDark = false;
        if (strOnWhenDark != null) {
            isOnWhenDark = (strOnWhenDark.equalsIgnoreCase("on"));
        }
        int OrigCoolingPointOccupied = Integer.parseInt(request.getParameter("OCPOCC"));
        int OrigCoolingPointUnoccupied = Integer.parseInt(request.getParameter("OCPUOCC"));
        int CoolingPointOccupied = Integer.parseInt(request.getParameter("CPOCC"));
        int CoolingPointUnoccupied = Integer.parseInt(request.getParameter("CPUOCC"));
        int OrigHeatPointOccupied = Integer.parseInt(request.getParameter("OHPOCC"));
        int OrigHeatPointUnoccupied = Integer.parseInt(request.getParameter("OHPUOCC"));
        int HeatPointOccupied = Integer.parseInt(request.getParameter("HPOCC"));
        int HeatPointUnoccupied = Integer.parseInt(request.getParameter("HPUOCC"));
        int HeatSen = Integer.parseInt(request.getParameter("HES"));
        int CoolSen = Integer.parseInt(request.getParameter("CES"));
        int OldBTUpHDD = Integer.parseInt(request.getParameter("OBTUpHDD"));
        int OldOtherBTU = Integer.parseInt(request.getParameter("OBTU"));
        int NewBTUpHDD = Integer.parseInt(request.getParameter("NBTUpHDD"));
        int NewOtherBTU = Integer.parseInt(request.getParameter("NBTU"));
        int HDDToDate = Integer.parseInt(request.getParameter("HDDTD"));
        int OldKWHpCDD = Integer.parseInt(request.getParameter("OKWHpCDD"));
        int OldOtherKWH = Integer.parseInt(request.getParameter("OOKWH"));
        int NewKWHpCDD = Integer.parseInt(request.getParameter("NKWHpCDD"));
        int NewOtherKWH = Integer.parseInt(request.getParameter("NOKWH"));
        int CDDtoDate = Integer.parseInt(request.getParameter("NCDDTD"));
        int BaseHeatEnergyAnnual = Integer.parseInt(request.getParameter("BHEA"));
        int BaseCoolingEnergyAnnual = Integer.parseInt(request.getParameter("BCEA"));
        String DDDate = request.getParameter("DDDATE");
        boolean energyAdded = energyManager.updateEnergy(energyID, client, schedule, site, zone, enduse, isWholeBuilding, isOverride, LightPowerOccupied, LightPowerUnoccupied, PercentMax, PercentMaxOrig, isOnWhenDark, OrigCoolingPointOccupied, OrigCoolingPointUnoccupied, CoolingPointOccupied, CoolingPointUnoccupied, OrigHeatPointOccupied, OrigHeatPointUnoccupied, HeatPointOccupied, HeatPointUnoccupied, CoolSen, HeatSen, OldBTUpHDD, OldKWHpCDD, OldOtherBTU, OldOtherKWH, CDDtoDate, CDDtoDate, NewBTUpHDD, NewOtherBTU, NewKWHpCDD, NewOtherKWH, BaseCoolingEnergyAnnual, BaseHeatEnergyAnnual, DDDate);
        if (energyAdded) {
            request.setAttribute("result", "<font color='green'>Energy information updated successfully.</font>");
        } else {
            request.setAttribute("result", "<font color='red'>Update Energy failed.  Please try again.</font>");
        }
        List sitesList = new ArrayList();
        List enduseList = new ArrayList();
        List zoneList = new ArrayList();
        List scheduleList = new ArrayList();
        List energyList = new ArrayList();
        sitesList = sitesFacade.findAll();
        zoneList = zonesFacade.findAll();
        enduseList = endusecategoryFacade.findAll();
        scheduleList = scheduleFacade.findAll();
        energyList = energyFacade.findAll();
        request.setAttribute("scheduleList", scheduleList);
        request.setAttribute("sitesList", sitesList);
        request.setAttribute("enduseList", enduseList);
        request.setAttribute("zoneList", zoneList);
        request.setAttribute("energyList", energyList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_energy.jsp");
        return transType;
    }

    public TransactionType DoEditEnergy(HttpServletRequest request, HttpServletResponse response) {
        boolean showForm = false;
        String intStr = request.getParameter("energyid");
        if (intStr != null) {
            int energyID = Integer.parseInt(intStr);
            Energy energy = null;
            List sitesList = new ArrayList();
            List enduseList = new ArrayList();
            List zoneList = new ArrayList();
            List scheduleList = new ArrayList();
            sitesList = sitesFacade.findAll();
            zoneList = zonesFacade.findAll();
            enduseList = endusecategoryFacade.findAll();
            scheduleList = scheduleFacade.findAll();
            energy = energyManager.findEnergyByEnergyId(energyID);
            if (energy != null) {
                showForm = true;
                request.setAttribute("energyinfo", energy);
                request.setAttribute("scheduleList", scheduleList);
                request.setAttribute("sitesList", sitesList);
                request.setAttribute("enduseList", enduseList);
                request.setAttribute("zoneList", zoneList);

            } else {
                request.setAttribute("result", "<font color='red'>Energy edit failed. Please try again.</font>");
            }
        }
        request.setAttribute("energyList", energyFacade.findAll());
        request.setAttribute("showform", showForm);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_energy.jsp");
        return transType;
    }
}
