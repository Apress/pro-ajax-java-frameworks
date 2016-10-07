package com.proajax.chapt7.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvancedHelloWorldService implements HelloWorldService {
    public static final String DATE_FORMAT = 
            "hh:mm 'o''clock' a, zzzz ' on ' EEEEE, MMMMM d, yyyy";
    
    public String getCurrentDateString() {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(new Date());
    }

    public List<String> getUnorderedList() {
        List<String> strings = new ArrayList();
        
        for(int i = 0; i < 10; i++) {
            strings.add("The square of " + i + " is: " + (i * i));
        }
        return strings;
    }
    
}
