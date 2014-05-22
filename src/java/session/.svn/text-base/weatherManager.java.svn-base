/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Financial;
import entity.Sites;
import entity.Weatherstation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author thien
 */
@Stateless
@LocalBean
public class weatherManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private SitesManager sitesManager;

//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int addWS(String name, int baseTemp, int HDDannual, float hddSens, float hddSens2, int CDDannual, float cddSens, float cddSens2) {
        try {
            Weatherstation ws = addWStoDb(name, baseTemp, HDDannual, hddSens, hddSens2, CDDannual, cddSens, cddSens2);

            return 1;
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Weatherstation addWStoDb(String name, int baseTemp, int HDDannual, float hddSens, float hddSens2, int CDDannual, float cddSens, float cddSens2) {
        Weatherstation ws = new Weatherstation();

//        zone.setId(1);
        ws.setName(name);
        ws.setBaseTemp(baseTemp);
        ws.setCDDannual(CDDannual);
        ws.setCDDsens(cddSens);
        ws.setCDDsens2(cddSens2);
        ws.setHDDannual(HDDannual);
        ws.setHDDsens(hddSens);
        ws.setHDDsens2(hddSens2);

        em.persist(ws);
        em.flush();

        return ws;
    }

    public boolean updateWS(Integer wsID, String name, int baseTemp, int HDDannual, float hddSens, float hddSens2, int CDDannual, float cddSens, float cddSens2) {
        try {
            Weatherstation ws = (Weatherstation) em.find(Weatherstation.class, wsID);
            ws.setName(name);
            ws.setBaseTemp(baseTemp);
            ws.setCDDannual(CDDannual);
            ws.setCDDsens(cddSens);
            ws.setCDDsens2(cddSens2);
            ws.setHDDannual(HDDannual);
            ws.setHDDsens(hddSens);
            ws.setHDDsens2(hddSens2);
            em.merge(ws);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeWS(Integer wsID) {
        List sitesList = new ArrayList();
        sitesList = sitesManager.findSitesByWSId(wsID);
        if (!sitesList.isEmpty())
            return false;
        try {
            Weatherstation ws = em.find(Weatherstation.class, wsID);
            em.remove(ws);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public String parseWeather(String startDate, String endDate, String airportCode) throws IOException {
//        String retStr = "false";
//        Financial financial = null;
//        String URLstr = "http://localhost/weatherScraping/weather_conditions_oe.php?startDate=" + startDate + "&endDate=" + endDate + "&airportCode=" + airportCode;
//        URL oracle = new URL(URLstr);
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(
//                oracle.openStream()));
//        
//        String inputLine;
//        String tempStr = null;
//        Integer index = 0;
//        while ((inputLine = in.readLine()) != null) {
//            tempStr = inputLine;
//            index ++;
//            retStr = "true";
//        }
//        
//        in.close();
//        
//        return retStr;
//    }
    
// NOTES FOR XANDER.
// Jon: I think that it will be best, in the long run, to scrape and store individual days from WUnderground, rather than date ranges.  
// Scrape should occur if "today's" date is greater than the most recent recorded date for HDD/CDD, and this can be triggered when visiting the dashboard.
//  WIth daily data, we can run queries to get the total hdd/cdd from any arbitrary start date to any arbitrary end-date, e.g. for utility bills.
// Also, with a multi-circuit monitor collecting real-time data, we will be able to do daily fault detection so we'll need daily HDD/CDD data.
// Currently, the scrape is for a range of dates. 
// We haven't yet determined if WUnderground goes from the beginning of the start date to the beginning of the end date, or something else.

    
    public String[] getHddCddfromAirportCode(Integer heatBaseTemp, Integer coolBaseTemp, Date startDate, Date endDate, Weatherstation station) throws IOException {
        String airportCode = station.getName();
        Integer newCDD = 0;
        Integer newHDD = 0;
        Integer origBaseTemp = 65;
        Integer i;
        double sens2, sens;

        if (endDate == null) {
            endDate = new Date();
        }
        
        Calendar calStartPeriod = Calendar.getInstance();
        calStartPeriod.setTime(startDate);

        Calendar calEndPeriod = Calendar.getInstance();
        calEndPeriod.setTime(startDate); // this is just for the do-while calculation loop

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endDate);

        int days = (int) ((calEnd.getTime().getTime() - calStartPeriod.getTime().getTime()) / (1000 * 60 * 60 * 24));
        
        String retStr[] = new String[2];
        String URLstr = null;
        int hddSum = 0;
        int cddSum = 0;
        int daysToIncrement = 0;
        int daysRemaining = days;
        
        while (daysRemaining > 0) {
            calStartPeriod.add(Calendar.DATE, daysToIncrement);
            if (daysRemaining < 365) {
                daysToIncrement = daysRemaining;
            } else {
                daysToIncrement = 365;
            }
            calEndPeriod.add(Calendar.DATE, (daysToIncrement-1));
            daysRemaining -= 365;

            URLstr = "http://classic.wunderground.com/history/airport/" + airportCode;
            URLstr += "/" + calStartPeriod.get(Calendar.YEAR) + "/" + (calStartPeriod.get(Calendar.MONTH) + 1) + "/" + calStartPeriod.get(Calendar.DATE);
            URLstr += "/CustomHistory.html?dayend=" + calEndPeriod.get(Calendar.DATE) + "&monthend=" + (calEndPeriod.get(Calendar.MONTH ) + 1) + "&yearend=" + calEndPeriod.get(Calendar.YEAR) + "&req_city=NA&req_state=NA&req_statename=NA";
            Document doc = (Document) Jsoup.connect(URLstr).get();


            Elements elementList = doc.select("span:matchesOwn(Heating|Cooling");

            for (Element element : elementList) {
                if (element.parent().parent().child(0).text().contains("Heating")) {
                    hddSum += Integer.parseInt(element.parent().parent().child(4).text());
                }
                if (element.parent().parent().child(0).text().contains("Cooling")) {
                    cddSum += Integer.parseInt(element.parent().parent().child(4).text());
                }
            }
        }
        newCDD = AdjustCDD(cddSum, coolBaseTemp, station);
        newHDD = AdjustHDD(hddSum, heatBaseTemp, station);

        retStr[0] = "HDD:" + newHDD;
        retStr[1] = "CDD:" + newCDD;
        return retStr;
    }

    public Integer getCddFromAirportCode(Integer newBaseTemp, Date startDate, Date endDate, Weatherstation station) throws IOException {
        String airportCode = station.getName();
        Integer newCDD = 0;
        Integer origBaseTemp = station.getBaseTemp();  // 60 or 65 for weatherUnderground ??
        Integer i;
        double sens2, sens;

        if (endDate == null) {
            endDate = new Date();
        }
        
        Calendar calStartPeriod = Calendar.getInstance();
        calStartPeriod.setTime(startDate);

        Calendar calEndPeriod = Calendar.getInstance();
        calEndPeriod.setTime(startDate); // this is just for the do-while calculation loop

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endDate);

        int days = (int) ((calEnd.getTime().getTime() - calStartPeriod.getTime().getTime()) / (1000 * 60 * 60 * 24));
        
        String URLstr = null;
        int cddSum = 0;
        int daysToIncrement = 0;
        int daysRemaining = days;
        
        while (daysRemaining > 0) {
            calStartPeriod.add(Calendar.DATE, daysToIncrement);
            if (daysRemaining < 365) {
                daysToIncrement = daysRemaining;
            } else {
                daysToIncrement = 365;
            }
            calEndPeriod.add(Calendar.DATE, (daysToIncrement-1));
            daysRemaining -= 365;

            URLstr = "http://classic.wunderground.com/history/airport/" + airportCode;
            URLstr += "/" + calStartPeriod.get(Calendar.YEAR) + "/" + (calStartPeriod.get(Calendar.MONTH) + 1) + "/" + calStartPeriod.get(Calendar.DATE);
            URLstr += "/CustomHistory.html?dayend=" + calEndPeriod.get(Calendar.DATE) + "&monthend=" + (calEndPeriod.get(Calendar.MONTH ) + 1) + "&yearend=" + calEndPeriod.get(Calendar.YEAR) + "&req_city=NA&req_state=NA&req_statename=NA";
            Document doc = (Document) Jsoup.connect(URLstr).get();


            Elements elementList = doc.select("span:matchesOwn(Cooling");

            for (Element element : elementList) {
                if (element.parent().parent().child(0).text().contains("Cooling")) {
                    cddSum += Integer.parseInt(element.parent().parent().child(4).text());
                }
            }
        }
        newCDD = AdjustCDD(cddSum, newBaseTemp, station);
        return newCDD;
    }

    public Integer AdjustCDD(Integer cddSum, Integer baseTemp, Weatherstation station) {
        double sens2, sens;
        int i;
        Integer newCDD = 0;
        Integer origBaseTemp = station.getBaseTemp();
//        Integer coolBaseTemp = baseTemp - 15; // set the baseTemperature outside of here.
        Integer newBaseTemp = baseTemp;
        if (newBaseTemp == origBaseTemp) {
            newCDD = cddSum;
        } else if (newBaseTemp < origBaseTemp) {
            newCDD = cddSum;
            sens2 = 0;
            sens = station.getCDDsens();
            newCDD = newCDD + (int) sens;
            for (i = origBaseTemp; i > newBaseTemp; i--) {
                newCDD = newCDD - (int) (sens);
                newCDD = newCDD + (int) (sens2);
                sens2 += station.getCDDsens2();
            }
        }
        else if (newBaseTemp > origBaseTemp) {
            newCDD = cddSum;
            sens2 = station.getCDDsens2();
            sens = station.getCDDsens();
            for (i = origBaseTemp; i < newBaseTemp; i++) {
                newCDD = newCDD + (int) (sens);
                newCDD = newCDD + (int) (sens2);
                sens2 += station.getCDDsens2();
            }
        }
        if (newCDD < 0) 
                newCDD = 0 ;

        return newCDD;
    }

    public Integer getHddFromAirportCode(Integer newBaseTemp, Date startDate, Date endDate, Weatherstation station) throws IOException {
        String airportCode = station.getName();
        Integer newHDD = 0;
        Integer origBaseTemp = station.getBaseTemp();  // 60 or 65 for weatherUnderground??
        Integer i;
        double sens2, sens;
        if (endDate == null) {
            endDate = new Date();
        }
        
        Calendar calStartPeriod = Calendar.getInstance();
        calStartPeriod.setTime(startDate);

        Calendar calEndPeriod = Calendar.getInstance();
        calEndPeriod.setTime(startDate); // this is just for the do-while calculation loop

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endDate);

        int days = (int) ((calEnd.getTime().getTime() - calStartPeriod.getTime().getTime()) / (1000 * 60 * 60 * 24));
        
        String URLstr = null;
        int hddSum = 0;
        int daysToIncrement = 0;
        int daysRemaining = days;
        
        while (daysRemaining > 0) {
            calStartPeriod.add(Calendar.DATE, daysToIncrement);
            if (daysRemaining < 365) {
                daysToIncrement = daysRemaining;
            } else {
                daysToIncrement = 365;
            }
            calEndPeriod.add(Calendar.DATE, (daysToIncrement-1));
            daysRemaining -= 365;

            URLstr = "http://classic.wunderground.com/history/airport/" + airportCode;
            URLstr += "/" + calStartPeriod.get(Calendar.YEAR) + "/" + (calStartPeriod.get(Calendar.MONTH) + 1) + "/" + calStartPeriod.get(Calendar.DATE);
            URLstr += "/CustomHistory.html?dayend=" + calEndPeriod.get(Calendar.DATE) + "&monthend=" + (calEndPeriod.get(Calendar.MONTH ) + 1) + "&yearend=" + calEndPeriod.get(Calendar.YEAR) + "&req_city=NA&req_state=NA&req_statename=NA";
            Document doc = (Document) Jsoup.connect(URLstr).get();


            Elements elementList = doc.select("span:matchesOwn(Heating");

            for (Element element : elementList) {
                if (element.parent().parent().child(0).text().contains("Heating")) {
                    hddSum += Integer.parseInt(element.parent().parent().child(4).text());
                }
            }
        }
        newHDD = AdjustHDD(hddSum, newBaseTemp, station);
        return newHDD;
    }
        
    public Integer AdjustHDD(Integer hddSum, Integer baseTemp, Weatherstation station) {
        double sens2, sens;
        int i;
        Integer newHDD = 0;
        Integer origBaseTemp = station.getBaseTemp();
        Integer newBaseTemp = baseTemp;
// adjust HDD for baseTemp
        if (newBaseTemp == origBaseTemp) {
            newHDD = hddSum;
        } else if (newBaseTemp < origBaseTemp) {
            newHDD = hddSum;
            sens2 = 0;
            sens = station.getHDDsens();
            for (i = origBaseTemp; i > newBaseTemp ; i--) {
                newHDD = newHDD - (int) (sens);
                newHDD = newHDD + (int) (sens2);
                sens2 += station.getHDDsens2();
            }
        }
        else if (newBaseTemp > origBaseTemp) {
            newHDD = hddSum;
            sens2 = station.getHDDsens2();
            sens = station.getHDDsens();
            for (i = origBaseTemp; i < newBaseTemp; i++) {
                newHDD = newHDD + (int) (sens);
                newHDD = newHDD + (int) (sens2);
                sens2 += station.getHDDsens2();
            }
        }
        if (newHDD < 0) 
                newHDD = 0 ;
        return newHDD;
    }

    // this returns the annual HDD for the weather station given a baseTemp
    public Integer GetHDD(Integer newBaseTemp,  Weatherstation station) {
        Integer newHDD = null;
        int i;
        double sens2, sens;
        Integer origBaseTemp = station.getBaseTemp();
//        Integer heatBaseTemp = baseTemp - 15;
        Integer heatBaseTemp = newBaseTemp;
        if (heatBaseTemp == origBaseTemp) {
            newHDD = station.getHDDannual();
        } else if (heatBaseTemp < origBaseTemp) {
            newHDD = station.getHDDannual();
            sens2 = 0;
            sens = station.getHDDsens();
            for (i = origBaseTemp; i > heatBaseTemp ; i--) {
                newHDD = newHDD - (int) (sens);
                newHDD = newHDD + (int) (sens2);
                sens2 += station.getHDDsens2();
            }
        }
        else if (heatBaseTemp > origBaseTemp) {
            newHDD = station.getHDDannual();
            sens2 = station.getHDDsens2();
            sens = station.getHDDsens();
            for (i = origBaseTemp; i < heatBaseTemp; i++) {
                newHDD = newHDD + (int) (sens);
                newHDD = newHDD + (int) (sens2);
                sens2 += station.getHDDsens2();
            }
        }
        if (newHDD < 0) 
                newHDD = 0 ;
        return newHDD;
    }
 
    // this returns the annual CDD for the weather station given a baseTemp
    public Integer GetCDD(Integer baseTemp, Weatherstation station) {
        Integer newCDD = null;
        int i;
        double sens2, sens;
        Integer origBaseTemp = station.getBaseTemp();
//        Integer coolBaseTemp = baseTemp - 15; // set the baseTemperature outside of here.
        Integer coolBaseTemp = baseTemp;
        if (coolBaseTemp == origBaseTemp) {
            newCDD = station.getCDDannual();
        } else if (coolBaseTemp < origBaseTemp) {
            newCDD = station.getCDDannual();
            sens2 = 0;
            sens = station.getCDDsens();
            newCDD = newCDD + (int) sens;
            for (i = origBaseTemp; i > coolBaseTemp; i--) {
                newCDD = newCDD - (int) (sens);
                newCDD = newCDD + (int) (sens2);
                sens2 += station.getCDDsens2();
            }
        }
        else if (coolBaseTemp > origBaseTemp) {
            newCDD = station.getCDDannual();
            sens2 = station.getCDDsens2();
            sens = station.getCDDsens();
            for (i = origBaseTemp; i < coolBaseTemp; i++) {
                newCDD = newCDD + (int) (sens);
                newCDD = newCDD + (int) (sens2);
                sens2 += station.getCDDsens2();
            }
        }
        if (newCDD < 0) 
                newCDD = 0 ;
        return newCDD;
    }

    public Weatherstation findWeatherstationById(Integer wsID) {
        Weatherstation ws;
//        zone = (Zones) em.createNamedQuery("Zones.findById").setParameter("id", id).getSingleResult();
        ws = (Weatherstation) em.find(Weatherstation.class, wsID);
        return ws;
    }    
}
