package com.proajax.chapt5.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NameService {
    private List names;
    
    private NameService(List listOfNames) {
        this.names = listOfNames;
    }
    
    public static NameService getInstance(List listOfNames) {
        return new NameService(listOfNames);
    }
    
    public List findNames(String prefix) {
        String prefixUpperCase = prefix.toUpperCase();
        List matches = new ArrayList();
        Iterator iter = names.iterator();
        while(iter.hasNext()) {
            String name = (String) iter.next();
            String nameUpperCase = name.toUpperCase();
            if(nameUpperCase.startsWith(prefixUpperCase)){        
                boolean result = matches.add(name);
            }
        }
        return matches;
    }
}
