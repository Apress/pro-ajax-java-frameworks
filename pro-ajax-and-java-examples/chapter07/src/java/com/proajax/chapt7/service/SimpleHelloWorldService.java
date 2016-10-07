package com.proajax.chapt7.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class SimpleHelloWorldService implements HelloWorldService {

    public List getStrings() {
        List strings = new ArrayList();
        for(int i = 0; i < 10; i++) {
            strings.add("The number I'm thinking of is: " + i);
        }
        return strings;
    }

    public String getCurrentDateString() {
        return new Date().toString();
    }

    public List<String> getUnorderedList() {
        List<String> strings = new ArrayList();
        for(int i = 0; i < 10; i++) {
            strings.add("The number I'm thinking of is: " + i);
        }
        return strings;
    }
}
