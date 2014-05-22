/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Store request and response for passing between classes.
 * @author worman
 */
public class TransactionType {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String redirectionPath;
    
    public void setRequest(HttpServletRequest v_request) {
        request = v_request;
    }
    
    public void setReponse(HttpServletResponse v_response) {
        response = v_response;
    }
    
    public void setRedirectionPath(String v_redirectionPath) {
        redirectionPath = v_redirectionPath;
    }
    
    public HttpServletRequest getRequest() {
        return request;
    }
    
    public HttpServletResponse getResponse() {
        return response;
    }
    
    public String getRedirectionPath() {
        return redirectionPath;
    }
}
