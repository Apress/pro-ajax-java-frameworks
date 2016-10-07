/*
 * CustomValidator.java
 *
 * Created on April 8, 2006, 10:19 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package proajax.chap8;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author nate
 */
public class CustomValidator implements Validator {
    
    /** Creates a new instance of CustomValidator */
    public CustomValidator() {
    }
    
    public void validate(FacesContext context, UIComponent component, Object value) {
        if(null==value) {
            return;
        }
        if (isInvalidName(value.toString())) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Summary Message", "Invalid Pay To Name!");
            throw new ValidatorException(message);
        }
    }
    
    boolean isInvalidName(String value) {
        boolean valid = false;
        if(value.indexOf("x") > -1) {
            valid = true;
        }
        return valid;
    }
}
