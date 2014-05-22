/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import controller.ControllerServlet;
import entity.Bills;
import entity.Meters;
import entity.Sites;
import session.MetersFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

/**
 *
 * @author thien
 */
@Stateless
@LocalBean
public class graphingManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @EJB
    private BillsFacade billsFacade;
    @EJB
    private MetersFacade meterFacade;
    @EJB
    private MetersManager metersManager;
    @EJB
    private SitesManager siteManager;

    public String addSeries(String mID) {

        Bills currBill = new Bills();
        String result = null;
        List billsList = new ArrayList();

        String ejbql = "SELECT bills FROM bills b WHERE b.metersId = ?1";
        Integer meterID = Integer.parseInt(mID);
        Query query = null;
        if (meterID != -1) {
            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1");
            query.setParameter(1, meterID);
        } else {
            query = em.createQuery("SELECT b FROM Bills b");
        }

//        query.setParameter(2, meterID);

        billsList = query.getResultList();

        Iterator<Bills> iter = billsList.iterator();

        result = "Meter: " + mID;
        Boolean named = false;
        while (iter.hasNext() == true) {
            result += ", ";
            currBill = iter.next();
            Float amount = currBill.getAmount();
            String amtStr = amount.toString();
            result += amtStr;
        }

        return result;
    }

    public String addSeriesbyYear(String mID, Integer v_year) {

        Bills currBill = new Bills();
        String result = null;
        List billsList = new ArrayList();
        Float[][] amountArray;
        amountArray = new Float[1][12];

        Arrays.fill(amountArray[0], 0.0f);

        String ejbql = "SELECT bills FROM bills b WHERE b.metersId = ?1";
        Integer meterID = Integer.parseInt(mID);
        Query query = null;
        if (meterID != -1) {
            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1 ORDER BY b.fiscalYear, b.fiscalMonth ASC");
            query.setParameter(1, meterID);
        } else {
            query = em.createQuery("SELECT b FROM Bills b ORDER BY b.fiscalYear, b.fiscalMonth ASC");

        }

        billsList = query.getResultList();

        Iterator<Bills> iter = billsList.iterator();

        while (iter.hasNext() == true) {
            currBill = iter.next();
            Float amount = currBill.getAmount();
            Integer year = currBill.getFiscalYear();
            Integer month = currBill.getFiscalMonth();
            Integer test = year.intValue() - v_year.intValue();
            if (test == 0) {
                amountArray[0][month - 1] = amount;
            }
        }

        result = v_year + ",";
        for (int mth = 0; mth < 12; mth++) {
            if (mth != 0) {
                result += ",";
            }
            result += Float.toString(amountArray[0][mth]);
        }
        //result += ";";


        return result;
    }

    public String addSeriesbyMonth(String mID, Integer v_month, Integer v_year) {
        Integer v_prev_month = v_month.intValue() - 1;
        if (v_prev_month == 0) {
            v_prev_month = 12;
        }

        Bills currBill = new Bills();
        String result = null;
        List billsList = new ArrayList();
        Float[][] amountArray;
        amountArray = new Float[1][12];
        Arrays.fill(amountArray[0], 0.0f);
        Query query = null;
        Integer meterID = Integer.parseInt(mID);
        if (meterID != -1) {
            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1 ORDER BY b.fiscalYear, b.fiscalMonth ASC");
            query.setParameter(1, meterID);
        } else {
            query = em.createQuery("SELECT b FROM Bills b ORDER BY b.fiscalYear, b.fiscalMonth ASC");
        }
        billsList = query.getResultList();
        Iterator<Bills> iter = billsList.iterator();
        while (iter.hasNext() == true) {
            currBill = iter.next();
            Float amount = currBill.getAmount();
            Integer year = currBill.getFiscalYear();
            Integer month = currBill.getFiscalMonth();
            if (year.intValue() == v_year.intValue()) {
                if ((month.intValue() == v_month.intValue()) || (month.intValue() == v_prev_month.intValue())) {
                    amountArray[0][month - 1] = amount;
                }
            }
        }

        result = v_year + ",";
        for (int mth = 0; mth < 12; mth++) {
            if (mth != 0) {
                result += ",";
            }
            result += Float.toString(amountArray[0][mth]);
        }
        //result += ";";


        return result;
    }

    public String addSeriesbyMonthYear(String mID, Integer v_month, Integer v_year) {
        Integer v_prev_year = v_year.intValue() - 1;
        Bills currBill = new Bills();
        String result = null;
        List billsList = new ArrayList();
        Float[][] amountArray;
        amountArray = new Float[2][12];
        Arrays.fill(amountArray[0], 0.0f);
        Arrays.fill(amountArray[1], 0.0f);

        Integer meterID = Integer.parseInt(mID);
        Query query = null;
        if (meterID != -1) {
         query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1 ORDER BY b.fiscalYear, b.fiscalMonth ASC");
         query.setParameter(1, meterID);
        } else {
         query = em.createQuery("SELECT b FROM Bills b ORDER BY b.fiscalYear, b.fiscalMonth ASC");
        }        
        billsList = query.getResultList();
        Iterator<Bills> iter = billsList.iterator();
        while (iter.hasNext() == true) {
            currBill = iter.next();
            Float amount = currBill.getAmount();
            Integer year = currBill.getFiscalYear();
            Integer month = currBill.getFiscalMonth();
            if (year.intValue() == v_prev_year.intValue()) {
                if (month.intValue() == v_month.intValue()) {
                    amountArray[0][month - 1] = amount;
                }
            }
            if (year.intValue() == v_year.intValue()) {
                if (month.intValue() == v_month.intValue()) {
                    amountArray[1][month - 1] = amount;
                }
            }
        }

        result = v_prev_year + ",";
        for (int mth = 0; mth < 12; mth++) {
            if (mth != 0) {
                result += ",";
            }
            result += Float.toString(amountArray[0][mth]);
        }
        result += ";" + v_year + ",";
        for (int mth = 0; mth < 12; mth++) {
            if (mth != 0) {
                result += ",";
            }
            result += Float.toString(amountArray[1][mth]);
        }

        return result;
    }

    public String monthlyEnergyCosts() {
        Bills currBill = new Bills();
        String result = "";
        List billsList = new ArrayList();
        List stringList = new ArrayList();
        String tempString = null;

        Query query = em.createQuery("SELECT b FROM Bills b WHERE b.fiscalYear = 2010 ORDER BY b.metersId, b.fiscalMonth ASC");

        billsList = query.getResultList();

        Iterator<Bills> iter = billsList.iterator();

        Integer meterID_prev = 0;
        Integer meterID = 0;
        String meterName;
        Meters meter = null;
        String amount = null;
        String year = null;
        String month = null;
        Boolean isInitial = true;
        Integer monthCount = 1;

        while (iter.hasNext() == true) {
            currBill = iter.next();
            meterID = currBill.getMetersId();
            meter = meterFacade.find(meterID);
            amount = Float.toString(currBill.getAmount());
            year = Integer.toString(currBill.getFiscalYear());
            month = Integer.toString(currBill.getFiscalMonth());

            if (meter != null && meterID != meterID_prev) {
                result += meter.getTextID() + "," + amount;
            } else {
                result += amount;
            }
            if (month.equals("12") && (iter.hasNext() == true)) {
                result += ";";

            } else if (iter.hasNext() == true) {
                result += ",";
            }
            meterID_prev = meterID;
        }

        return result;
    }

    public String[] addSeriesForAllYears(Integer clientID, String fuelType) {
        Meters meter = null;
        Sites site = null;
        Bills currBill = new Bills();
        String[] result = new String[10];
        List billsList = new ArrayList();
        Float[][] amountArray;
        amountArray = new Float[10][13];
        int initYear = 0, year = 0;
        int month;

        int i;
        for (i = 0; i < 10; i++) {
            Arrays.fill(amountArray[i], 0.0f);
        }

        String ejbql = "SELECT bills FROM bills b WHERE b.metersId = ?1";
//        Integer meterID = Integer.parseInt(mID);
        Query query = null;
//        if (meterID != -1) {
//            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1 ORDER BY b.dateEnd ASC");
//            query.setParameter(1, meterID);
//        } else {
            query = em.createQuery("SELECT b FROM Bills b ORDER BY b.dateEnd ASC");

//        }

        billsList = query.getResultList();

        Iterator<Bills> iter = billsList.iterator();

        while (iter.hasNext() == true) {
            currBill = iter.next();
            int meterID = currBill.getMetersId();
            meter = metersManager.findMeterById(meterID);
            if (meter!= null) {
                int siteID = meter.getSitesId();
                site = siteManager.findSiteById(siteID);
                String meterFuelType = meter.getFuelType();
                meterFuelType = meterFuelType.toLowerCase();
                if ((fuelType.contains("electric") && meterFuelType.contains("electric")) ||
                    (fuelType.contains("gas") && meterFuelType.contains("gas")) ||
                        (fuelType.contains("all"))) {
                    if ((site != null) && (site.getClientidClient() == clientID)) {
                        Date billDate = currBill.getDateEnd();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(billDate);
                        if (initYear == 0) {
                            initYear = calendar.get(java.util.Calendar.YEAR);
                            year = initYear;
                        } else
                            year = calendar.get(java.util.Calendar.YEAR);
                        month = calendar.get(java.util.Calendar.MONTH);
                        amountArray[year-initYear][month] = amountArray[year-initYear][month] + currBill.getCost().intValue();
                    }
                }
            }
        }
        Boolean isValidYear = true;
        for (year = initYear; year < initYear + 8; year++) {
            String strYear = new String();
            strYear = String.format("%d", year);
            for (int mth = 0; mth < 12; mth++) 
                if ((amountArray[year-initYear][mth] > 0.0))
                    isValidYear = true;
            if (isValidYear) {
                result[year-initYear] = year + ",";
                for (int mth = 0; mth < 12; mth++) {
                    if (mth != 0) {
                        result[year-initYear] += ",";
                    }
                    //if ((amountArray[year-initYear][mth] > 0.0) || (isValidYear)) {
                        result[year-initYear] += Float.toString(amountArray[year-initYear][mth]);
                    //}
                }
            }
            else
                result[year-initYear] = "";
            isValidYear = false;
        }
        //result += ";";
        return result;
    }

    public String[] addSeriesForAllYearsElectric(String mID) {

        Bills currBill = new Bills();
        String[] result = new String[10];
        List billsList = new ArrayList();
        Float[][] amountArray;
        amountArray = new Float[10][13];
        int initYear = 0, year = 0;
        int month;

        int i;
        for (i = 0; i < 10; i++) {
            Arrays.fill(amountArray[i], 0.0f);
        }

        String ejbql = "SELECT bills FROM bills b WHERE b.metersId = ?1";
        Integer meterID = Integer.parseInt(mID);
        Query query = null;
        if (meterID != -1) {
            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1 ORDER BY b.dateEnd ASC");
            query.setParameter(1, meterID);
        } else {
            query = em.createQuery("SELECT b FROM Bills b ORDER BY b.dateEnd ASC");

        }

        billsList = query.getResultList();

        Iterator<Bills> iter = billsList.iterator();

        while (iter.hasNext() == true) {
            currBill = iter.next();
            meterID = currBill.getMetersId();
            Meters meter = metersManager.findMeterById(meterID);
            if (meter.getFuelType().equalsIgnoreCase("electric")) {      
                Float amount = currBill.getAmount();
                Date billDate = currBill.getDateEnd();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(billDate);
                if (initYear == 0) {
                    initYear = calendar.get(java.util.Calendar.YEAR);
                    year = initYear;
                } else
                    year = calendar.get(java.util.Calendar.YEAR);
                month = calendar.get(java.util.Calendar.MONTH);
                amountArray[year-initYear][month] += amount;
            }
        }
        Boolean isValidYear = true;
        for (year = initYear; year < initYear + 8; year++) {
            String strYear = new String();
            strYear = String.format("%d", year);
            for (int mth = 0; mth < 12; mth++) 
                if ((amountArray[year-initYear][mth] > 0.0))
                    isValidYear = true;
            if (isValidYear) {
                result[year-initYear] = year + ",";
                for (int mth = 0; mth < 12; mth++) {
                    if (mth != 0) {
                        result[year-initYear] += ",";
                    }
                    //if ((amountArray[year-initYear][mth] > 0.0) || (isValidYear)) {
                        result[year-initYear] += Float.toString(amountArray[year-initYear][mth]);
                    //}
                }
            }
            else
                result[year-initYear] = "";
            isValidYear = false;
        }
        //result += ";";
        return result;
    }

    public String[] addSeriesForAllYearsGas(String mID) {

        Bills currBill = new Bills();
        String[] result = new String[10];
        List billsList = new ArrayList();
        Float[][] amountArray;
        amountArray = new Float[10][13];
        int initYear = 0, year = 0;
        int month;

        int i;
        for (i = 0; i < 10; i++) {
            Arrays.fill(amountArray[i], 0.0f);
        }

        String ejbql = "SELECT bills FROM bills b WHERE b.metersId = ?1";
        Integer meterID = Integer.parseInt(mID);
        Query query = null;
        if (meterID != -1) {
            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1 ORDER BY b.dateEnd ASC");
            query.setParameter(1, meterID);
        } else {
            query = em.createQuery("SELECT b FROM Bills b ORDER BY b.dateEnd ASC");

        }

        billsList = query.getResultList();

        Iterator<Bills> iter = billsList.iterator();

        while (iter.hasNext() == true) {
            currBill = iter.next();
            meterID = currBill.getMetersId();
            Meters meter = metersManager.findMeterById(meterID);
            if (meter.getFuelType().equalsIgnoreCase("electric")) {      
                Float amount = currBill.getAmount();
                Date billDate = currBill.getDateEnd();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(billDate);
                if (initYear == 0) {
                    initYear = calendar.get(java.util.Calendar.YEAR);
                    year = initYear;
                } else
                    year = calendar.get(java.util.Calendar.YEAR);
                month = calendar.get(java.util.Calendar.MONTH);
                amountArray[year-initYear][month] += amount;
            }
        }
        Boolean isValidYear = true;
        for (year = initYear; year < initYear + 8; year++) {
            String strYear = new String();
            strYear = String.format("%d", year);
            for (int mth = 0; mth < 12; mth++) 
                if ((amountArray[year-initYear][mth] > 0.0))
                    isValidYear = true;
            if (isValidYear) {
                result[year-initYear] = year + ",";
                for (int mth = 0; mth < 12; mth++) {
                    if (mth != 0) {
                        result[year-initYear] += ",";
                    }
                    //if ((amountArray[year-initYear][mth] > 0.0) || (isValidYear)) {
                        result[year-initYear] += Float.toString(amountArray[year-initYear][mth]);
                    //}
                }
            }
            else
                result[year-initYear] = "";
            isValidYear = false;
        }
        //result += ";";
        return result;
    }
}

