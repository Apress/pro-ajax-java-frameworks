/*
 * AjaxPhaseListener.java
 *
 * Created on April 8, 2006, 2:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package proajax.chap8;

import javax.faces.event.PhaseListener;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.context.FacesContext;
import javax.faces.component.UIViewRoot;
import javax.faces.component.UIInput;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class AjaxPhaseListener implements PhaseListener {
    private static final String
            ERROR_MESSAGE = "Invalid Pay To Name.";

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;    }

    public void beforePhase(PhaseEvent phaseEvent) {
    }

    public void afterPhase(PhaseEvent phaseEvent) {
        FacesContext   context = FacesContext.getCurrentInstance();
        Map requestParams = context.getExternalContext()
                              .getRequestParameterMap();
        String ajaxParam = (String)requestParams.get("ajax");

        if("true".equals(ajaxParam)) {
            UIViewRoot viewRoot = context.getViewRoot();
            UIInput   payTo = (UIInput)viewRoot.findComponent("form:payTo");
            int children = viewRoot.getChildCount();
            boolean valid = true;

            if(payTo != null) {
                HttpServletResponse response =
                        (HttpServletResponse)context.getExternalContext()
                                               .getResponse();
                Validator[] validators = payTo.getValidators();
                String value = (String)requestParams.get("payTo");

                PrintWriter writer = null;
                try {
                    writer = response.getWriter();
                }
                catch (java.io.IOException ex) {
                    ex.printStackTrace();
                }

                // fire all validators and catch exceptions
                for (int i = 0; i < validators.length; i++) {
                    Validator validator = validators[i];
                    try {
                        validator.validate(context, payTo, value);
                    }
                    catch (ValidatorException ve) {
                        writer.write(ERROR_MESSAGE);
                        valid = false;
                        break;
                    }
                }
                if(valid) {
                    writer.write(getResponseForValue(value));
                }
            }
            context.responseComplete();
        }
    }

    private String getResponseForValue(String value) {
        String response = "";
        if("Foo".equals(value)) {
            response = "<value><amount>40.92</amount><value>";
        }
        return response;
    }
}
