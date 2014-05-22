/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Client;
import entity.Energy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entity.Financial;
import entity.HddCdd;
import entity.Schedule;
import entity.Sites;
import entity.Weatherstation;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Math;
import javax.ejb.EJB;

/**
 *
 * @author Jon Engelbert
 */
@Stateless
@LocalBean
public class FinancialManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private weatherManager weatherManager;


    public Financial findFinancialByClientId(Integer clientId) {
        Financial financial = null;
        try {
            Query query = em.createQuery("SELECT f FROM Financial f WHERE f.clientidClient = ?1");
            query.setParameter(1, clientId);

            financial = (Financial) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
        return financial;
    }
    
//    public Integer GetHDD(Integer newHeatOccTemp, Weatherstation station) {
//        Integer newHDD = null;
//        int i;
//        double sens2, sens;
//        Integer origBaseTemp = station.getBaseTemp();
//        Integer heatBaseTemp = newHeatOccTemp - 15;
//        if (heatBaseTemp == origBaseTemp) {
//            newHDD = station.getHDDannual();
//        } else if (heatBaseTemp < origBaseTemp) {
//            newHDD = station.getHDDannual();
//            sens2 = 0;
//            sens = station.getHDDsens();
//            for (i = origBaseTemp; i > heatBaseTemp ; i--) {
//                newHDD = newHDD - (int) (sens);
//                newHDD = newHDD + (int) (sens2);
//                sens2 += station.getHDDsens2();
//            }
//        }
//        else if (heatBaseTemp > origBaseTemp) {
//            newHDD = station.getHDDannual();
//            sens2 = station.getHDDsens2();
//            sens = station.getHDDsens();
//            for (i = origBaseTemp; i < heatBaseTemp; i++) {
//                newHDD = newHDD + (int) (sens);
//                newHDD = newHDD + (int) (sens2);
//                sens2 += station.getHDDsens2();
//            }
//        }
//        if (newHDD < 0) 
//                newHDD = 0 ;
//        return newHDD;
//    }

//    public Integer GetCDD(Integer newCoolOccTemp, Weatherstation station) {
//        Integer newCDD = null;
//        int i;
//        double sens2, sens;
//        Integer origBaseTemp = station.getBaseTemp();
//        Integer coolBaseTemp = newCoolOccTemp - 15;
//        if (coolBaseTemp == origBaseTemp) {
//            newCDD = station.getCDDannual();
//        } else if (coolBaseTemp < origBaseTemp) {
//            newCDD = station.getCDDannual();
//            sens2 = 0;
//            sens = station.getCDDsens();
//            newCDD = newCDD + (int) sens;
//            for (i = origBaseTemp; i > coolBaseTemp; i--) {
//                newCDD = newCDD - (int) (sens);
//                newCDD = newCDD + (int) (sens2);
//                sens2 += station.getCDDsens2();
//            }
//        }
//        else if (coolBaseTemp > origBaseTemp) {
//            newCDD = station.getCDDannual();
//            sens2 = station.getCDDsens2();
//            sens = station.getCDDsens();
//            for (i = origBaseTemp; i < coolBaseTemp; i++) {
//                newCDD = newCDD + (int) (sens);
//                newCDD = newCDD + (int) (sens2);
//                sens2 += station.getCDDsens2();
//            }
//        }
//        if (newCDD < 0) 
//                newCDD = 0 ;
//        return newCDD;
//    }



    public Boolean addFinancial(Client client, int fixedExpense, int annualExpense, Date startDate, int annualElectricSavings, int annualGasSavings, float pricePerKWh, float pricePerBTU, int savingsToDateElectric, int savingsToDateGas, Date savingsCalcDate) {
        try {
            Financial financial = addFinancialtoDb(client,  fixedExpense,  annualExpense,  startDate,  annualElectricSavings,  annualGasSavings,  pricePerKWh,  pricePerBTU,  savingsToDateElectric,  savingsToDateGas,  startDate);
            return true;
        } catch (Exception e) {
            context.setRollbackOnly();
            return false;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Financial addFinancialtoDb(Client client, int fixedExpense, int annualExpense, Date startDate, int annualElectricSavings, int annualGasSavings, 
            float pricePerKWh, float pricePerBTU, int savingsToDateElectric, int savingsToDateGas, Date savingsCalcDate) {
        Financial financial = new Financial();
        
//        financial.setId(1);
        financial.setClientidClient(client.getIdClient());
        financial.setFixedExpense(fixedExpense);
        financial.setAnnualExpense(annualExpense);
        financial.setStartDate(startDate);
        financial.setAnnualElectricSavings(annualElectricSavings);
        financial.setAnnualGasSavings(annualGasSavings);
        financial.setPricePerKWh(pricePerKWh);
        financial.setPricePerBTU(pricePerBTU);
        financial.setSavingsToDateElectric(savingsToDateElectric);
        financial.setSavingsToDateGas(savingsToDateGas);
        financial.setSavingsCalcDate(savingsCalcDate);

        try {
        em.persist(financial);
        em.flush();
        } catch (Exception e) {
            return null;
        }
        
        return financial;
    }
    
    public boolean updateFinancial(Integer financialID, Client client, int fixedExpense, int annualExpense, Date startDate, int annualElectricSavings, int annualGasSavings, float pricePerKWh, float pricePerBTU, int savingsToDateElectric, int savingsToDateGas, Date savingsCalcDate) {
        try {
            Financial financial = (Financial) em.find(Financial.class, financialID);
        financial.setClientidClient(client.getIdClient());
        financial.setFixedExpense(fixedExpense);
        financial.setAnnualExpense(annualExpense);
        financial.setStartDate(startDate);
        financial.setAnnualElectricSavings(annualElectricSavings);
        financial.setAnnualGasSavings(annualGasSavings);
        financial.setPricePerKWh(pricePerKWh);
        financial.setPricePerBTU(pricePerBTU);
        financial.setSavingsToDateElectric(savingsToDateElectric);
        financial.setSavingsToDateGas(savingsToDateGas);
        financial.setSavingsCalcDate(savingsCalcDate);
            em.merge(financial);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    public boolean removeFinancial(Integer financialID) {
        try {
            Financial financial = em.find(Financial.class, financialID);
            em.remove(financial);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Financial findFinancialById(Integer financialID) {
        Financial financial;
//        financial = (Financials) em.createNamedQuery("Financials.findById").setParameter("id", id).getSingleResult();
        financial = (Financial) em.find(Financial.class, financialID);
        return financial;
    }    
//    public Financial findFinancialByName(String strFinancial) {
//        Financial financial;
//        financial = (Financial) em.find(Financial.class, strFinancial);
//        return financial;
//    }
    
    public boolean updateFinances(Integer financesId, Float savedWH, Float savedCCF, Date calculateDate) {
        try {
            Financial  finances = (Financial) em.find(Financial.class, financesId);
            Integer savedWHint = savedWH.intValue();
            Integer savedCCFint = savedCCF.intValue();
            finances.setSavingsToDateElectric(savedWHint);
            finances.setSavingsToDateGas(savedCCFint);
            finances.setSavingsCalcDate(calculateDate);
            em.merge(finances);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
