package com.proajax.chapt5.validation.ui;

import com.proajax.chapt5.service.ReservationService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class ValidateReservationAction extends  Action {
  
    
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm
            , HttpServletRequest request, HttpServletResponse response) 
            throws Exception {

        ReservationForm form = (ReservationForm) actionForm;
        
        ReservationService service = new ReservationService();
        boolean isAvailable = 
                service.isReservationAvailable(form.getArrivalDateAsDate()
                    , form.getDepartDateAsDate()
                    , form.isSmokingRequest());
        
        ActionMessages errors = this.getErrors(request);
        if(!isAvailable) {
            errors.add(ActionMessages.GLOBAL_MESSAGE
                    , new ActionMessage("errors.reservation.not.available"
                    , true));
        }
        saveErrors(request, errors);
        
        ActionForward forward = null;
        if(errors.size() > 0) {
            forward = mapping.findForward("invalid");
        }
        else {
            forward = mapping.findForward("valid");
        }
        return forward;
    }
}
