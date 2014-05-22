/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Client;
import entity.Schedule;
import entity.Sites;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ClientFacade;
import session.ScheduleFacade;
import session.ScheduleManager;
import session.SitesFacade;
import session.SitesManager;
import session.WeatherstationFacade;

/**
 *
 * @author jon
 */
@Stateless
@LocalBean
public class ControllerSite {

    @EJB
    private ClientFacade clientFacade;
    @EJB
    private SitesFacade sitesFacade;
    @EJB
    private SitesManager siteManager;
    @EJB
    private ScheduleFacade scheduleFacade;
    @EJB
    private ScheduleManager scheduleManager;
    @EJB
    private WeatherstationFacade wsFacade;

    public TransactionType DoAddSite(HttpServletRequest request, HttpServletResponse response, int clientID) {
//        Schedule schedule = null;
    try {
        String name = request.getParameter("bname");
        String address1 = request.getParameter("bstreet");
        String address2 = request.getParameter("bstreet2");
        String city = request.getParameter("bcity");
        String state = request.getParameter("bstate");
        String zipcode = request.getParameter("bzip");
        int nPeople = Integer.parseInt(request.getParameter("bnumocc"));
        String sSqft = request.getParameter("bsqft");
        int nSqFt = Integer.parseInt(sSqft);

//        schedule = scheduleFacade.find(Integer.parseInt(request.getParameter("schedule")));
        int scheduleID = Integer.parseInt(request.getParameter("schedule"));
        int wsID = Integer.parseInt(request.getParameter("ws"));
//        String strWholeBuilding = request.getParameter("isWB");
        Boolean isWholeBuilding = true;
//        if (strWholeBuilding != null) {
//            isWholeBuilding = (strWholeBuilding.equalsIgnoreCase("on"));
//        }
        String strOverride = request.getParameter("isOR");
        Boolean isOverride = false;
        if (strOverride != null) {
            isOverride = (strOverride.equalsIgnoreCase("on"));
        }
        int LightPowerOccupied = Integer.parseInt(request.getParameter("LPOCC"));
        int LightPowerUnoccupied = Integer.parseInt(request.getParameter("LPUOCC"));
        int PercentMax = Integer.parseInt(request.getParameter("PML"));
        int PercentMaxOrig = Integer.parseInt(request.getParameter("PMLO"));
//        String strOnWhenDark = request.getParameter("isOWD");
        Boolean isOnWhenDark = false;
//        if (strOnWhenDark != null) {
//            isOnWhenDark = (strOnWhenDark.equalsIgnoreCase("on"));
//        }
        int OrigCoolingPointOccupied = Integer.parseInt(request.getParameter("OCPOCC"));
        int OrigCoolingPointUnoccupied = Integer.parseInt(request.getParameter("OCPUOCC"));
        int CoolingPointOccupied = Integer.parseInt(request.getParameter("CPOCC"));
        int CoolingPointUnoccupied = Integer.parseInt(request.getParameter("CPUOCC"));
        int OrigHeatPointOccupied = Integer.parseInt(request.getParameter("OHPOCC"));
        int OrigHeatPointUnoccupied = Integer.parseInt(request.getParameter("OHPUOCC"));
        int HeatPointOccupied = Integer.parseInt(request.getParameter("HPOCC"));
        int HeatPointUnoccupied = Integer.parseInt(request.getParameter("HPUOCC"));
        int HeatSen = 0;    // Integer.parseInt(request.getParameter("HES"));
        int CoolSen = 0;    // Integer.parseInt(request.getParameter("CES"));
        int OldBTUpHDD = Integer.parseInt(request.getParameter("OBTUpHDD"));
        int OldOtherBTU = Integer.parseInt(request.getParameter("OBTU"));
        int NewBTUpHDD = Integer.parseInt(request.getParameter("NBTUpHDD"));
        int NewOtherBTU = Integer.parseInt(request.getParameter("NBTU"));
        int HDDtoDate = 0;  //  Integer.parseInt(request.getParameter("HDDTD"));
        int OldKWHpCDD = Integer.parseInt(request.getParameter("OKWHpCDD"));
        int OldOtherKWH = Integer.parseInt(request.getParameter("OOKWH"));
        int NewKWHpCDD = Integer.parseInt(request.getParameter("NKWHpCDD"));
        int NewOtherKWH = Integer.parseInt(request.getParameter("NOKWH"));
        int CDDtoDate = 0;  // Integer.parseInt(request.getParameter("NCDDTD"));
        int BaseHeatEnergyAnnual = 0;   // Integer.parseInt(request.getParameter("BHEA"));
        int BaseCoolingEnergyAnnual = 0;    // Integer.parseInt(request.getParameter("BCEA"));
//        String DDDate = request.getParameter("DDDATE");
//        int energyAdded = energyManager.addEnergy(client, schedule, site, zone, enduse, isWholeBuilding, isOverride, LightPowerOccupied, LightPowerUnoccupied, PercentMax, PercentMaxOrig, isOnWhenDark, OrigCoolingPointOccupied, OrigCoolingPointUnoccupied, CoolingPointOccupied, CoolingPointUnoccupied, OrigHeatPointOccupied, OrigHeatPointUnoccupied, HeatPointOccupied, HeatPointUnoccupied, CoolSen, HeatSen, OldBTUpHDD, OldKWHpCDD, OldOtherBTU, OldOtherKWH, CDDtoDate, CDDtoDate, NewBTUpHDD, NewOtherBTU, NewKWHpCDD, NewOtherKWH, BaseCoolingEnergyAnnual, BaseHeatEnergyAnnual, DDDate);


        String siteAdded = siteManager.addSite(name, address1, address2, city, state, zipcode, nPeople, nSqFt, clientID,
                        scheduleID, wsID, isWholeBuilding, isOverride, LightPowerOccupied, LightPowerUnoccupied, PercentMax, PercentMaxOrig, isOnWhenDark, OrigCoolingPointOccupied, OrigCoolingPointUnoccupied, CoolingPointOccupied, CoolingPointUnoccupied, OrigHeatPointOccupied, OrigHeatPointUnoccupied, HeatPointOccupied, HeatPointUnoccupied, CoolSen, HeatSen, OldBTUpHDD, OldKWHpCDD, OldOtherBTU, OldOtherKWH, CDDtoDate, HDDtoDate, NewBTUpHDD, NewOtherBTU, NewKWHpCDD, NewOtherKWH);
        if (siteAdded.equals("false")) {
            request.setAttribute("result", "<font color='red'>Add building failed.  Please try again.</font>");
        } else {
            request.setAttribute("result", "<font color='green'>Building " + siteAdded + " added successfully.</font>");
        }
        List scheduleList = new ArrayList();
        scheduleList = scheduleFacade.findAll();
        request.setAttribute("scheduleList", scheduleList);
    } catch (Exception e) {
        //Can't parse date
    }

        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_building.jsp");
        return transType;
    }

    public TransactionType DoRemoveSite(HttpServletRequest request, HttpServletResponse response, int clientID) {

        String intStr = request.getParameter("buildingid");
        if ((intStr != null) && (intStr != "null")) {
            int siteID = Integer.parseInt(intStr);
            boolean removed = siteManager.removeSite(siteID);
            if (removed) {
                request.setAttribute("result", "<font color='green'>Building successfully removed.</font>");
            } else {
                request.setAttribute("result", "<font color='red'>Building remove failed.  There may be meters or performance contractor bills that refer to this site.</font>");
            }
        }

        request.setAttribute("buildings", siteManager.findSitesByClientId(clientID));
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_building.jsp");
        return transType;
    }

    public TransactionType DoEditSite(HttpServletRequest request, HttpServletResponse response, int clientID) {
        boolean showForm = false;
        String intStr = request.getParameter("buildingid");
        if ((intStr != null) && (intStr != "null")) {
            int buildingID = Integer.parseInt(intStr);
            Sites site = null;
            site = siteManager.findSiteById(buildingID);
            if (site != null) {
                showForm = true;
                request.setAttribute("buildinginfo", site);
            } else {
                request.setAttribute("result", "<font color='red'>Building edit failed. Please try again.</font>");
            }
        }
        request.setAttribute("buildings", siteManager.findSitesByClientId(clientID));
        request.setAttribute("showform", showForm);
        List scheduleList = new ArrayList();;
        scheduleList = scheduleFacade.findAll();
        request.setAttribute("scheduleList", scheduleList);
        List wsList = new ArrayList();;
        wsList = wsFacade.findAll();
        request.setAttribute("wsList", wsList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_building.jsp");
        return transType;
    }

    public TransactionType DoEditSiteUpdate(HttpServletRequest request, HttpServletResponse response, int clientID) {
        try {
            int id = Integer.parseInt(request.getParameter("bid"));
            String name = request.getParameter("bname");
            String address1 = request.getParameter("bstreet");
            String address2 = request.getParameter("bstreet2");
            String city = request.getParameter("bcity");
            String state = request.getParameter("bstate");
            String zipcode = request.getParameter("bzip");
            int nPeople = Integer.parseInt(request.getParameter("bnumocc"));
            String sSqft = request.getParameter("bsqft");
            int nSqFt = Integer.parseInt(sSqft);
    //        Schedule schedule = scheduleFacade.find(Integer.parseInt(request.getParameter("schedule")));
            int scheduleID = Integer.parseInt(request.getParameter("schedule"));
            int wsID = Integer.parseInt(request.getParameter("ws"));
    //        String strWholeBuilding = request.getParameter("isWB");
            Boolean isWholeBuilding = true;
    //        if (strWholeBuilding != null) {
    //            isWholeBuilding = (strWholeBuilding.equalsIgnoreCase("on"));
    //        }
    //        String strOverride = request.getParameter("isOR");
            Boolean isOverride = false;
    //        if (strOverride != null) {
    //            isOverride = (strOverride.equalsIgnoreCase("on"));
    //        }
            int LightPowerOccupied = Integer.parseInt(request.getParameter("LPOCC"));
            int LightPowerUnoccupied = Integer.parseInt(request.getParameter("LPUOCC"));
            int PercentMax = Integer.parseInt(request.getParameter("PML"));
            int PercentMaxOrig = Integer.parseInt(request.getParameter("PMLO"));
    //        String strOnWhenDark = request.getParameter("isOWD");
            Boolean isOnWhenDark = false;
    //        if (strOnWhenDark != null) {
    //            isOnWhenDark = (strOnWhenDark.equalsIgnoreCase("on"));
    //        }
            int OrigCoolingPointOccupied = Integer.parseInt(request.getParameter("OCPOCC"));
            int OrigCoolingPointUnoccupied = Integer.parseInt(request.getParameter("OCPUOCC"));
            int CoolingPointOccupied = Integer.parseInt(request.getParameter("CPOCC"));
            int CoolingPointUnoccupied = Integer.parseInt(request.getParameter("CPUOCC"));
            int OrigHeatPointOccupied = Integer.parseInt(request.getParameter("OHPOCC"));
            int OrigHeatPointUnoccupied = Integer.parseInt(request.getParameter("OHPUOCC"));
            int HeatPointOccupied = Integer.parseInt(request.getParameter("HPOCC"));
            int HeatPointUnoccupied = Integer.parseInt(request.getParameter("HPUOCC"));
            int HeatSen = 0;  // Integer.parseInt(request.getParameter("HES"));
            int CoolSen = 0;  // Integer.parseInt(request.getParameter("CES"));
            int OldBTUpHDD = Integer.parseInt(request.getParameter("OBTUpHDD"));
            int OldOtherBTU = Integer.parseInt(request.getParameter("OBTU"));
            int NewBTUpHDD = Integer.parseInt(request.getParameter("NBTUpHDD"));
            int NewOtherBTU = Integer.parseInt(request.getParameter("NBTU"));
            int HDDToDate = 0; //Integer.parseInt(request.getParameter("HDDTD"));
            int OldKWHpCDD = Integer.parseInt(request.getParameter("OKWHpCDD"));
            int OldOtherKWH = Integer.parseInt(request.getParameter("OOKWH"));
            int NewKWHpCDD = Integer.parseInt(request.getParameter("NKWHpCDD"));
            int NewOtherKWH = Integer.parseInt(request.getParameter("NOKWH"));
            int CDDtoDate = 0;  // Integer.parseInt(request.getParameter("NCDDTD"));
            int BaseHeatEnergyAnnual = 0;   //Integer.parseInt(request.getParameter("BHEA"));
            int BaseCoolingEnergyAnnual = 0;    // Integer.parseInt(request.getParameter("BCEA"));
            boolean siteUpdated = siteManager.updateSite(id, name, address1, address2, city, state, zipcode, nPeople, nSqFt, clientID,
                    scheduleID, wsID, isWholeBuilding, isOverride, LightPowerOccupied, LightPowerUnoccupied, PercentMax, PercentMaxOrig, isOnWhenDark, OrigCoolingPointOccupied, OrigCoolingPointUnoccupied, CoolingPointOccupied, CoolingPointUnoccupied, OrigHeatPointOccupied, OrigHeatPointUnoccupied, HeatPointOccupied, HeatPointUnoccupied, CoolSen, HeatSen, OldBTUpHDD, OldKWHpCDD, OldOtherBTU, OldOtherKWH, CDDtoDate, CDDtoDate, NewBTUpHDD, NewOtherBTU, NewKWHpCDD, NewOtherKWH);
            if (siteUpdated) {
                request.setAttribute("result", "<font color='red'>Building " + name + " updated sucessfully.</font>");
            } else {
                request.setAttribute("result", "<font color='green'>Building update failed. Please try again.</font>");
            }
        } catch (Exception e) {
            //Can't parse date
        }
        request.setAttribute("buildings", siteManager.findSitesByClientId(clientID));
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/edit_building.jsp");
        return transType;
    }
    public TransactionType DoSetupSite(HttpServletRequest request, HttpServletResponse response, int clientId) {
        List scheduleList = new ArrayList();
        scheduleList = scheduleManager.findSchedulesByClientId(clientId);
        request.setAttribute("scheduleList", scheduleList);
        List wsList = new ArrayList();;
        wsList = wsFacade.findAll();
        request.setAttribute("wsList", wsList);
        TransactionType transType = new TransactionType();
        transType.setReponse(response);
        transType.setRequest(request);
        transType.setRedirectionPath("/WEB-INF/view/setup_building.jsp");
        return transType;
    }
}
