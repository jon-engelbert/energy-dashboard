/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Meters;
import entity.PCBills;
import entity.Sites;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
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
public class PCBillsManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private MetersManager metersManager;
    @EJB
    private PCBillsFacade billsFacade;
    @EJB
    private SitesManager sitesManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int addBill(Sites sites, Date billDate, Date billStart, Date billEnd, String fuelType, float amount,
            BigDecimal cost) {
        try {
            int retValue = addBilltoDb(sites, billStart, billEnd, fuelType, amount,
                    cost);

            return retValue;
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }
    }

    public boolean updateBill(Integer billID, Sites sites, Date billStart, Date billEnd, String fuelType, float amount,
            BigDecimal cost) {
        try {
            boolean retValue = updateBilltoDb(billID, sites, billStart, billEnd, fuelType, amount,
                    cost);

            return retValue;
        } catch (Exception e) {
            context.setRollbackOnly();
            Logger.getLogger(BillManager.class.getName()).log(Level.SEVERE, "Attempted Bill Edit", e);
            return false;
        }
    }

    public boolean updateBilltoDb(Integer billID, Sites sites, Date billStart, Date billEnd, String fuelType, float amount,
            BigDecimal cost) {

        try {
            PCBills bill = (PCBills) em.find(PCBills.class, billID);
            DateFormat formatter;
            Date billStartDate = null;
            Date billEndDate = null;
            float fAmount = Float.valueOf(amount).floatValue();
            formatter = new SimpleDateFormat("yyyy-mm-dd");
            try {
                billStartDate = billStart;
                System.out.println("Date parsed = " + formatter.format(billStartDate));
                billEndDate = billEnd;
                System.out.println("Date parsed = " + formatter.format(billEndDate));

            } catch (Exception e) {
                System.out.println(e.toString());
            }
            // find meter...
            bill.setCost(cost);
            formatter = new SimpleDateFormat("MM");
//            String fiscMonth = formatter.format(billDate);
            formatter = new SimpleDateFormat("yyyy");
//            String fiscYear = formatter.format(billDate);
//            bill.setFiscalMonth(Integer.parseInt(fiscMonth));
//            bill.setFiscalYear(Integer.parseInt(fiscYear));
            bill.setDateStart(billStartDate);
            bill.setDateEnd(billEndDate);
            bill.setAmount(fAmount);
            bill.setFuelType(fuelType);
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

    public int addBilltoDb(Sites sites, Date billStart, Date billEnd, String fuelType, float amount,
            BigDecimal cost) {

        try {
            DateFormat formatter;
            Date billStartDate = null;
            Date billEndDate = null;
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
            PCBills bill = new PCBills();
            // find meter...
            bill.setAmount(amount);
            bill.setCost(cost);

            //formatter = new SimpleDateFormat("MM");
            //String fiscMonth = formatter.format(billDate);
            //formatter = new SimpleDateFormat("yyyy");
            //String fiscYear = formatter.format(billDate);
            bill.setDateStart(billStartDate);
            bill.setDateEnd(billEndDate);
            bill.setAmount(fAmount);
            bill.setSitesId(sites.getId());
            bill.setFuelType(fuelType);

            em.persist(bill);
            em.flush();
            return bill.getId();
        } catch (Exception e) {
            context.setRollbackOnly();
            System.out.println(e.toString());
            Logger.getLogger(PCBillsManager.class.getName()).log(Level.SEVERE, "Attempted Add PCBill", e);
            return 0;
        }
    }

//    public List findBillsByClientId(Integer clientID) {
//        List billsList = new ArrayList();
//        Query query = null;      
//        try {
//            query = em.createQuery("SELECT b FROM PCBills b WHERE b.clientidClient = ?1");
//        } catch (Exception e) {
//            query = null;
//        }
//        query.setParameter(1, clientID);
//        
//        billsList = query.getResultList();
//        return billsList;
//    }

    public List findPCbillsBySiteId(Integer sitesID) {
        List billsList = new ArrayList();
        Query query = null;
        try { // "SELECT p FROM PCBills p WHERE p.sitesId = :sitesId"
            query = em.createQuery("SELECT b FROM PCBills b WHERE b.sitesId = ?1 ORDER BY b.dateStart ASC");

        } catch (Exception e) {
            query = null;
        }
        query.setParameter(1, sitesID);
        billsList = query.getResultList();

        return billsList;
    }
    
    public List sumBillsByClientIdFast(Integer clientId, Date startDate) 
    {
        List<Integer> list = new ArrayList<Integer>();
        Float sum = 0.0f;
        Query query = null;
        float savedKWH = 0.0f, savedBTU = 0.0f, savedDollars = 0.0f;

        List billsList = new ArrayList();
        List sitesList = new ArrayList();
        List metersList = new ArrayList();

        Sites currSite = new Sites();
        PCBills currBill = new PCBills();
        String filterStringSite;
        String filterStringAll = "SELECT b FROM PCBills b WHERE ";

        sitesList = sitesManager.findSitesByClientId(clientId);

        Iterator<Sites> iter = sitesList.iterator();

   StringBuilder sb = new StringBuilder();
   // Send all output to the Appendable object sb
   Formatter formatter = new Formatter(sb);
        Boolean bIsFirstIter = true;
        while (iter.hasNext() == true) {
            currSite = iter.next();
   // Explicit argument indices may be used to re-order output.
            if (bIsFirstIter)
                formatter.format("(b.sitesId = %d", currSite.getId());
            else
                formatter.format(" OR b.sitesId = %d", currSite.getId());
            bIsFirstIter = false;
        }
        if (!bIsFirstIter) {
            filterStringAll += sb;
            filterStringAll += ")";
            try { // "SELECT p FROM PCBills p WHERE p.sitesId = :sitesId"
                query = em.createQuery(filterStringAll);    //"SELECT b FROM PCBills b WHERE b.sitesId = ?1 ORDER BY b.dateStart ASC");

            } catch (Exception e) {
                query = null;
            }
            billsList = query.getResultList();
            Iterator<PCBills> iterBills = billsList.iterator();

            while (iterBills.hasNext() == true) {
                currBill = iterBills.next();
                Date billStartDate = currBill.getDateStart();
                Date billEndDate = currBill.getDateEnd();
                if (!billStartDate.before(startDate)) {   // && (currBill.getDateEnd().before(endDate))) {
                    savedDollars += currBill.getCost().floatValue();
                    String fuelType = currBill.getFuelType();
                    fuelType.toLowerCase();
                    if (fuelType.contains("electric"))
                        savedKWH += currBill.getAmount();
                    if (fuelType.contains("gas"))
                        savedBTU += currBill.getAmount();
                }

            }
        }

        list.add(Math.round(savedKWH));
        list.add(Math.round(savedBTU));
        list.add(Math.round(savedDollars));
        return list;
    }
    
    public Float sumBillDollarsByClientId(Integer clientId, Date startDate, Date endDate) {
        Float sum = 0.0f;
        Query query = null;

        List billsList = new ArrayList();
        List sitesList = new ArrayList();
        List metersList = new ArrayList();

        Sites currSite = new Sites();
        PCBills currBill = new PCBills();

        sitesList = sitesManager.findSitesByClientId(clientId);

        Iterator<Sites> iter = sitesList.iterator();

        while (iter.hasNext() == true) {
            currSite = iter.next();
            billsList = findPCbillsBySiteId(currSite.getId());
            Iterator<PCBills> iterBills = billsList.iterator();

            while (iterBills.hasNext() == true) {
                currBill = iterBills.next();
                if ((currBill.getDateStart().after(startDate)) && (currBill.getDateEnd().after(endDate)))
                    sum += currBill.getCost().floatValue();
                
            }
        }
        return sum;
    }

    public Float sumBillKWHByClientId(Integer clientId, Date startDate, Date endDate, String billType) {
        Float sum = 0.0f;
        Query query = null;

        List billsList = new ArrayList();
        List sitesList = new ArrayList();
        List metersList = new ArrayList();

        Sites currSite = new Sites();
        PCBills currBill = new PCBills();

        sitesList = sitesManager.findSitesByClientId(clientId);

        Iterator<Sites> iter = sitesList.iterator();

        while (iter.hasNext() == true) {
            currSite = iter.next();
            billsList = findPCbillsBySiteId(currSite.getId());
            Iterator<PCBills> iterBills = billsList.iterator();

            while (iterBills.hasNext() == true) {
                currBill = iterBills.next();
                String fuelType = currBill.getFuelType();
                fuelType.toLowerCase();
                if (fuelType.contains("electric"))
                    sum += currBill.getCost().floatValue();                
            }
        }
        return sum;
    }

    public Float sumBillAmountByClientId(Integer clientId, Date startDate, Date endDate, String FuelType) {
        Float sum = 0.0f;
        Query query = null;

        List billsList = new ArrayList();
        List sitesList = new ArrayList();
        List metersList = new ArrayList();

        Sites currSite = new Sites();
        PCBills currBill = new PCBills();

        sitesList = sitesManager.findSitesByClientId(clientId);

        Iterator<Sites> iter = sitesList.iterator();

        while (iter.hasNext() == true) {
            currSite = iter.next();
            billsList = findPCbillsBySiteId(currSite.getId());
            Iterator<PCBills> iterBills = billsList.iterator();

            while (iterBills.hasNext() == true) {
                currBill = iterBills.next();
                String fuelType = currBill.getFuelType();
                fuelType.toLowerCase();
                if (fuelType.contains(FuelType))
                    sum += currBill.getCost().floatValue();                
            }
        }
        return sum;
    }


    public boolean removeBill(Integer billID) {
        try {
            PCBills bill = em.find(PCBills.class, billID);
            em.remove(bill);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}