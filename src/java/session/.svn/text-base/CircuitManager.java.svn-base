/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entity.*;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Jon Engelbert
 */
@Stateless
@LocalBean
public class CircuitManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Circuit findCircuitById(Integer circuitID) {
        Circuit circuit;
//        circuit = (Circuits) em.createNamedQuery("Circuits.findById").setParameter("id", id).getSingleResult();
        circuit = (Circuit) em.find(Circuit.class, circuitID);
        return circuit;
    }    
    public Circuit findCircuitByName(String strCircuit) {
        Circuit circuit;
//        circuit = (Circuits) em.createNamedQuery("Circuits.findById").setParameter("id", id).getSingleResult();
        circuit = (Circuit) em.find(Circuit.class, strCircuit);
        return circuit;
    }        
    
    public String addCircuit(String strName, boolean isPanelInput, Integer phaseNo, Panel panel, Multicircuitmeter multicircuitmeter, Integer meterNo, Zones zone, Endusecategory enduse) {
        try {
            Circuit circuit = addCircuittoDb(strName, isPanelInput, phaseNo, panel, multicircuitmeter, meterNo, zone, enduse);
            return circuit.getName();
        } catch (Exception e) {
            context.setRollbackOnly();
            return "false";
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Circuit addCircuittoDb(String strName, boolean isPanelInput, Integer phaseNo, Panel panel, Multicircuitmeter multicircuitmeter, Integer meterNo, Zones zone, Endusecategory enduse) {
        Circuit circuit = new Circuit();
        
//        panel.setId(1);
        circuit.setName(strName);
        circuit.setIsInput(isPanelInput);
        circuit.setPhase(phaseNo);
        circuit.setPanelidPanel(panel.getIdPanel());
        circuit.setMultiCircuitMeteridmultiCircuitMeter(multicircuitmeter.getIdmultiCircuitMeter());
        circuit.setMeterBranchNo(meterNo);
        circuit.setZonesIdzones(zone.getIdzones());
        circuit.setEndusecategoryidEndUseCategory(enduse.getIdEndUseCategory());

        em.persist(circuit);
        em.flush();
        
        return circuit;
    }
    
}
