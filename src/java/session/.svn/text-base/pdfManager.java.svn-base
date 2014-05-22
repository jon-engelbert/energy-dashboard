/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Bills;
import entity.Meters;
import entity.Pdf;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jon Engelbert
 */
@Stateless
//@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class pdfManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")

    private EntityManager em;
    @Resource
    private SessionContext context;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Pdf storePdf(String filename, String contentType, long fileSize, byte[] bytes) {

        Pdf pdf = null;
        try {
            pdf = new Pdf();
        } catch (Exception e) {
            return null;
        }
        // find meter...
            pdf.setContent(bytes);
            pdf.setFilename(filename);
            pdf.setFilesize(fileSize);
            pdf.setFiletype(contentType);

        try {
            em.persist(pdf);
            em.flush();
        } catch (Exception e) {
            context.setRollbackOnly();
            return null;
        }
        try {
//            int id = pdf.getId();
            return pdf;
        } catch (Exception e) {
            context.setRollbackOnly();
            return null;
        }
    }
}
