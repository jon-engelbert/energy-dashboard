/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Engel-less
 */
    
@Stateless
@LocalBean
public class Authorization {

//  --------------------------------------------
//  authorize by menu
//  --------------------------------------------
    
    @PermitAll
    public void AuthorizeHome() {
        return;
    }
    
    @RolesAllowed({"ADMIN","SUPER"})
    public void AuthorizeAdmin() {
        return;
    }
    
    @RolesAllowed({"SUPER"})
    //@RolesDenied({"approval","auditor"})
    public void AuthorizeSuper() {
        return;
    }
    
}
