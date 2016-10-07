package com.proajax.chapt7.ui;

import com.proajax.chapt7.service.HelloWorldService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {
    private HelloWorldService service = null;
    
    public ModelAndView handleRequest(HttpServletRequest request
            , HttpServletResponse response) throws Exception {
    
        Map domain = new HashMap();
        domain.put("dateString", service.getCurrentDateString());
        domain.put("strings", service.getUnorderedList());
        
        return new ModelAndView("helloWorld", "domain", domain);
    }

    public void setService(HelloWorldService service) {
        this.service = service;
    }
}
