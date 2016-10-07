package com.proajax.chapt5.validation.ui;

import com.proajax.chapt5.exception.ReservationNotAvailableException;
import com.proajax.chapt5.service.ReservationService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class SaveReservationAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm
            , HttpServletRequest request
            , HttpServletResponse response) throws Exception {
        
        ActionForward retValue;
        ReservationForm form = (ReservationForm) actionForm;
        
        
        ReservationService service = new ReservationService();
        try {
            service.saveReservation(form.getArrivalDateAsDate()
            , form.getDepartDateAsDate(), form.isSmokingRequest()
            , form.getRequests(), form.getName(), form.getTelephone());
        }
        catch(ReservationNotAvailableException e) {
            ActionMessages errors = this.getErrors(request);
            errors.add(ActionMessages.GLOBAL_MESSAGE
                    , new ActionMessage("errors.reservation.not.available"
                    , true));
            saveErrors(request, errors);
            
            return mapping.findForward("fail");
        }
        
        return mapping.findForward("success");
    }
    
}
