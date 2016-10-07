package com.proajax.chapt5.validation.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorActionForm;

public class ReservationForm extends ValidatorActionForm {
    private String arrivalDate;
    private String departDate;
    private String smokingPref;
    private String requests;
    private String name;
    private String telephone;
    private DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
    
    public String getArrivalDate() {
        return arrivalDate;
    }
    
    public Date getArrivalDateAsDate() {
        try {
            return parser.parse(arrivalDate);
        }
        catch(ParseException e) {
            return null;
        }
    }
    
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public Date getDepartDateAsDate() {
        try {
            return parser.parse(departDate);
        }
        catch(ParseException e) {
            return null;
        }
    }

    public String getDepartDate() {
        return departDate;
    }
    
    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }
    
    public String getSmokingPref() {
        return smokingPref;
    }
    
    public void setSmokingPref(String smokingPref) {
        this.smokingPref = smokingPref;
    }
    
    public boolean isSmokingRequest() {
        return smokingPref.equalsIgnoreCase("smoking");
    }
    
    public String getRequests() {
        return requests;
    }
    
    public void setRequests(String requests) {
        this.requests = requests;
    }
    
    public ActionErrors validate(ActionMapping mapping
            , HttpServletRequest request) {
        ActionErrors errors;
        
        errors = super.validate(mapping, request);
        
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date arrival = parser.parse(arrivalDate);
            Date departure = parser.parse(departDate);
            
            if(departure.before(arrival)) {
                errors.add(ActionErrors.GLOBAL_MESSAGE
                        , new ActionMessage("errors.departure.before.arrival"
                        , true));
            }
        }
        catch (Exception e) {
            // Do nothing -- date format validation is handled in 
            // validation.xml.
        }
        
        return errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
}
