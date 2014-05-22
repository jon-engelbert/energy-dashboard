/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Bills;
import entity.Meters;
import entity.Sites;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jon Engelbert
 */
@Stateless
//@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BillManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private MetersManager metersManager;
    @EJB
    private BillsFacade billsFacade;
    @EJB
    private SitesManager sitesManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int addBill(Meters meter, Date billStart, Date billEnd, Integer readStart, Integer readEnd, float amount,
            BigDecimal cost, float demand, float peakDemand, float powerFactor, float kva, float loadFactor, BigDecimal costDemand, BigDecimal costUsage, BigDecimal costDistDemand,
            BigDecimal costDistUsage, BigDecimal surchargeAsPercent, BigDecimal taxAmount, Integer usageThreshold, BigDecimal costAboveThreshold, Integer offPeakEnergy, BigDecimal offPeakDiscount) {
        try {
            int retValue = addBilltoDb(meter, billStart, billStart, billEnd, readStart, readEnd, amount,
                    cost, demand, peakDemand, powerFactor, kva, loadFactor, costDemand, costUsage, costDistDemand,
                    costDistUsage, surchargeAsPercent, taxAmount, usageThreshold, costAboveThreshold, offPeakEnergy, offPeakDiscount);

            return retValue;
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }
    }

    public boolean updateBill(Integer billID, Date billDate, Date billStart, Date billEnd, Integer readStart, Integer readEnd, float amount,
            BigDecimal cost, float demand, float peakDemand, float powerFactor, float kva, float loadFactor, BigDecimal costDemand, BigDecimal costUsage, BigDecimal costDistDemand,
            BigDecimal costDistUsage, BigDecimal surchargeAsPercent, BigDecimal taxAmount, Integer usageThreshold, BigDecimal costAboveThreshold, Integer offPeakEnergy, BigDecimal offPeakDiscount) {
        try {
            boolean retValue = updateBilltoDb(billID, billDate, billStart, billEnd, readStart, readEnd, amount,
                    cost, demand, peakDemand, powerFactor, kva, loadFactor, costDemand, costUsage, costDistDemand,
                    costDistUsage, surchargeAsPercent, taxAmount, usageThreshold, costAboveThreshold, offPeakEnergy, offPeakDiscount);

            return retValue;
        } catch (Exception e) {
            context.setRollbackOnly();
            Logger.getLogger(BillManager.class.getName()).log(Level.SEVERE, "Attempted Bill Edit", e);
            return false;
        }
    }

    public boolean updateBilltoDb(Integer billID, Date billDate, Date billStart, Date billEnd, Integer readStart, Integer readEnd, float amount,
            BigDecimal cost, float demand, float peakDemand, float powerFactor, float kva, float loadFactor, BigDecimal costDemand, BigDecimal costUsage, BigDecimal costDistDemand,
            BigDecimal costDistUsage, BigDecimal surchargeAsPercent, BigDecimal taxAmount, Integer usageThreshold, BigDecimal costAboveThreshold, Integer offPeakEnergy, BigDecimal offPeakDiscount) {

        try {
            Bills bill = (Bills) em.find(Bills.class, billID);
            DateFormat formatter;
            Date billStartDate = null;
            Date billEndDate = null;
            float fAmount = Float.valueOf(amount).floatValue();
            formatter = new SimpleDateFormat("yyyy-mm-dd");
            try {
                billStartDate = billStart;
                //System.out.println("Date parsed = " + formatter.format(billStartDate));
                billEndDate = billEnd;
                System.out.println("Date parsed = " + formatter.format(billEndDate));

            } catch (Exception e) {
                System.out.println(e.toString());
            }
            // find meter...
            bill.setCost(cost);
            formatter = new SimpleDateFormat("MM");
            String fiscMonth = formatter.format(billDate);
            formatter = new SimpleDateFormat("yyyy");
            String fiscYear = formatter.format(billDate);
            bill.setFiscalMonth(Integer.parseInt(fiscMonth));
            bill.setFiscalYear(Integer.parseInt(fiscYear));
            bill.setDateStart(billStartDate);
            bill.setDateEnd(billEndDate);
            bill.setAmount(fAmount);
            bill.setIsBasedOnOriginalModel(false);
            em.merge(bill);
            em.flush();
            return true;
        } catch (Exception e) {
            context.setRollbackOnly();
            System.out.println(e.toString());
            Logger.getLogger(BillManager.class.getName()).log(Level.SEVERE, "Attempted Bill Edit On Entity", e);
            return false;
        }
    }

    public int addBilltoDb(Meters meter, Date billDate, Date billStart, Date billEnd, Integer readStart, Integer readEnd, float amount,
            BigDecimal cost, float demand, float peakDemand, float powerFactor, float kva, float loadFactor, BigDecimal costDemand, BigDecimal costUsage, BigDecimal costDistDemand,
            BigDecimal costDistUsage, BigDecimal surchargeAsPercent, BigDecimal taxAmount, Integer usageThreshold, BigDecimal costAboveThreshold, Integer offPeakEnergy, BigDecimal offPeakDiscount) {

        try {
            DateFormat formatter;
            Date billStartDate = null;
            Date billEndDate = null;
            java.lang.Integer iStart = readStart;
            java.lang.Integer iEnd = readEnd;
            float fAmount = Float.valueOf(amount).floatValue();
            formatter = new SimpleDateFormat("yyyy-mm-dd");
            try {

                billStartDate = billStart;
                //System.out.println("Date parsed = " + formatter.format(billStartDate));
                billEndDate = billEnd;
                //System.out.println("Date parsed = " + formatter.format(billEndDate));

            } catch (Exception e) {
                fAmount = fAmount;
                System.out.println(e.toString());
            }
            Bills bill = new Bills();
            // find meter...
            bill.setAmount(amount);
            bill.setCost(cost);

            formatter = new SimpleDateFormat("MM");
            String fiscMonth = formatter.format(billDate);
            formatter = new SimpleDateFormat("yyyy");
            String fiscYear = formatter.format(billDate);
            bill.setFiscalMonth(Integer.parseInt(fiscMonth));
            bill.setFiscalYear(Integer.parseInt(fiscYear));
            bill.setInternalID("0");
            bill.setReadEnd(0);
            bill.setReadStart(0);
            bill.setDateStart(billStartDate);
            bill.setDateEnd(billEndDate);
            bill.setReadStart(iStart);
            bill.setReadEnd(iEnd);
            bill.setAmount(fAmount);
            bill.setMetersId(meter.getId());
            bill.setIsBasedOnOriginalModel(false);

            em.persist(bill);
            em.flush();
            return 1;   // bill.getId();
        } catch (Exception e) {
            context.setRollbackOnly();
            System.out.println(e.toString());
            Logger.getLogger(BillManager.class.getName()).log(Level.SEVERE, "Attempted Add Bill", e);
            return 0;
        }
    }

//    public List findBillsByClientId(Integer clientID) {
//        List billsList = new ArrayList();
//        Query query = null;      
//        try {
//            query = em.createQuery("SELECT b FROM Bills b WHERE b.clientidClient = ?1");
//        } catch (Exception e) {
//            query = null;
//        }
//        query.setParameter(1, clientID);
//        
//        billsList = query.getResultList();
//        return billsList;
//    }

    public List findBillsByMeterId(Integer meterID) {
        List billsList = new ArrayList();
        Query query = null;
        try {
            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1 ORDER BY b.dateStart ASC");

        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, meterID);
        billsList = query.getResultList();

        return billsList;
    }

    public List findBillsByMeterId(Integer meterID, Boolean IsBasedOnOriginalModel) {
        List billsList = new ArrayList();
        Query query = null;
        try {
            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = ?1 ORDER BY b.dateStart ASC");

        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, meterID);
        billsList = query.getResultList();

        return billsList;
    }

    public List findBillsByMeterId(Integer meterID, Date startDate, Date endDate, Boolean IsBasedOnOriginalModel) {
        List billsList = new ArrayList();
        Query query = null;
        int boolVal = 0;

        String queryStr = "SELECT b FROM Bills b WHERE b.metersId = ?1";
        if ((startDate != null) && (endDate != null)) {
            queryStr += " AND b.dateStart > ?2 AND b.dateStart < ?3";
        }
        if (IsBasedOnOriginalModel != null) {
            queryStr += " AND b.isBasedOnOriginalModel = ?4";
        }
        queryStr += " ORDER BY b.dateStart ASC";

        try {
            query = em.createQuery(queryStr);

        } catch (Exception e) {
            query = null;
        }

        query.setParameter(1, meterID);
        if ((startDate != null) && (endDate != null)) {
            query.setParameter(2, startDate);
            query.setParameter(3, endDate);
        }
        if (IsBasedOnOriginalModel != null) {
            boolVal = IsBasedOnOriginalModel ? 1 : 0;
            query.setParameter(4, IsBasedOnOriginalModel);
        }

        billsList = query.getResultList();

        return billsList;
    }

    public Float sumBillsByClientId(Integer cientId, Date startDate, Date endDate, String billType) {
        Float sum = 0.0f;
        Query query = null;

        List billsList = new ArrayList();
        List sitesList = new ArrayList();
        List metersList = new ArrayList();

        Sites currSite = new Sites();
        Meters currMeter = new Meters();
        Bills currBill = new Bills();

        sitesList = sitesManager.findSitesByClientId(cientId);

        Iterator<Sites> iter = sitesList.iterator();

        while (iter.hasNext() == true) {
            currSite = iter.next();
            metersList = metersManager.findMetersBySiteId(currSite.getId());
            Iterator<Meters> iterMeters = metersList.iterator();

            while (iterMeters.hasNext() == true) {
                currMeter = iterMeters.next();
                billsList = findBillsByMeterId(currMeter.getId(), startDate, endDate, true);
                Iterator<Bills> iterBills = billsList.iterator();

                while (iterBills.hasNext() == true) {
                    currBill = iterBills.next();

                }
            }

        }

        return sum;
    }

    public Float sumBillAmountsByMeterId(Integer meterId, Date startDate, Date endDate, Boolean IsBasedOnOriginalModel) {
        Float sum = 0.0f;

        List billsList = new ArrayList();
        List metersList = new ArrayList();
        Meters currMeter = new Meters();
        Bills currBill = new Bills();

//            if ((startDate == null) || (endDate == null) && IsBasedOnOriginalModel == null) {
        billsList = findBillsByMeterId(meterId, startDate, endDate, IsBasedOnOriginalModel);
//            } 

        Iterator<Bills> iterBills = billsList.iterator();

        while (iterBills.hasNext() == true) {
            currBill = iterBills.next();
            sum += currBill.getAmount();
        }

        return sum;
    }

    public List sumBillsByClientIdFast(Integer clientID, Date startDate) {
        List<Integer> list = new ArrayList<Integer>();
        float KWH = 0.0f, BTU = 0.0f, Dollars = 0.0f;

        List billsList = new ArrayList();
        List metersList = new ArrayList();
        Bills currBill = new Bills();
        List sitesList = sitesManager.findSitesByClientId(clientID);       
        Iterator<Sites> sitesIter = sitesList.iterator();
        Sites currSite = null;
        Meters currMeter = null;
        String filterStringSite;
        String filterStringMeters = "SELECT m FROM Meters m WHERE ";
        String filterStringBills = "SELECT b FROM Bills b WHERE ";
        Query query = null;
        Map<Integer, String> MeterToFuelMap = new HashMap<Integer, String>();

        StringBuilder sb = new StringBuilder();
   // Send all output to the Appendable object sb
        Formatter formatter = new Formatter(sb);
        Boolean bIsFirstIter = true;
        while (sitesIter.hasNext() == true) {
            currSite = sitesIter.next();
   // Explicit argument indices may be used to re-order output.
            if (bIsFirstIter)
                formatter.format("(m.sitesId = %d", currSite.getId());
            else
                formatter.format(" OR m.sitesId = %d", currSite.getId());
            bIsFirstIter = false;
        }
        if (!bIsFirstIter) {
            filterStringMeters += sb;
            filterStringMeters += ")";
            try { // "SELECT p FROM PCBills p WHERE p.sitesId = :sitesId"
                query = em.createQuery(filterStringMeters);    //"SELECT b FROM PCBills b WHERE b.sitesId = ?1 ORDER BY b.dateStart ASC");

            } catch (Exception e) {
                query = null;
            }

            metersList = query.getResultList();
            Iterator<Meters> meterIter = metersList.iterator();
            StringBuilder sb2 = new StringBuilder();
            Formatter formatter2 = new Formatter(sb2);
            bIsFirstIter = true;
            while (meterIter.hasNext() == true) {
                currMeter = meterIter.next();
                MeterToFuelMap.put(currMeter.getId(), currMeter.getFuelType());
                if (bIsFirstIter)
                    formatter2.format("(b.metersId = %d", currMeter.getId());
                else
                    formatter2.format(" OR b.metersId = %d", currMeter.getId());
                bIsFirstIter = false;
            }
            if (!bIsFirstIter) {
                filterStringBills += sb2;
                filterStringBills += ")";
                try { 
                    query = em.createQuery(filterStringBills);    
                } catch (Exception e) {
                    query = null;
                }
                billsList = query.getResultList();

                Iterator<Bills> iterBills = billsList.iterator();
                while (iterBills.hasNext()) {
                    currBill = iterBills.next();
                    Date billStartDate = currBill.getDateStart();
                    Date billEndDate = currBill.getDateEnd();
                    try {
                        if (!billStartDate.before(startDate)) { // && ((currBill.getIsBasedOnOriginalModel() == null) || !currBill.getIsBasedOnOriginalModel())) {  // && (currBill.getDateEnd().before(endDate))) {
                            Dollars += currBill.getCost().floatValue();
                            String fuelType = MeterToFuelMap.get(currBill.getMetersId());
                            fuelType = fuelType.toLowerCase();
                            if (fuelType.contains("electric"))
                                KWH += currBill.getAmount();
                            if (fuelType.contains("gas"))
                                BTU += currBill.getAmount();
                        }
                    } catch(Exception e) {
                        currBill = null;
                    }

                }
            }
        }

        list.add(Math.round(KWH));
        list.add(Math.round(BTU));
        list.add(Math.round(Dollars));
        return list;
    }

    public Integer sumBillDollarsByMeterId(Integer meterId, Date startDate, Date endDate, Boolean IsBasedOnOriginalModel) {
        Integer sum = 0;

        List billsList = new ArrayList();
        List metersList = new ArrayList();
        Meters currMeter = new Meters();
        Bills currBill = new Bills();

//            if ((startDate == null) || (endDate == null) && IsBasedOnOriginalModel == null) {
        billsList = findBillsByMeterId(meterId, startDate, endDate, IsBasedOnOriginalModel);
//            } 

        Iterator<Bills> iterBills = billsList.iterator();

        while (iterBills.hasNext() == true) {
            currBill = iterBills.next();
            sum += currBill.getCost().intValue();
        }

        return sum;
    }

    public boolean removeBill(Integer billID) {
        try {
            Bills bill = em.find(Bills.class, billID);
            em.remove(bill);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Date getLastBillDate(Meters meter) {
        Date endDateLast = new Date();
        Bills lastBill = new Bills();
        Query query;
        try {
            query = em.createQuery("SELECT b FROM Bills b WHERE b.metersId = :metersId ORDER BY b.dateEnd DESC");
        } catch (Exception e) {
            query = null;
        }
        query.setParameter("metersId", meter.getId());
        query.setMaxResults(1);
        try {
            lastBill = (Bills) query.getSingleResult();
            endDateLast = lastBill.getDateEnd();
        } catch (Exception e) {
            return null;
        }
        
        return endDateLast;
     }

   
}
