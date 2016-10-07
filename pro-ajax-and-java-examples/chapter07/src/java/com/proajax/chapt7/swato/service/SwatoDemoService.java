package com.proajax.chapt7.swato.service;

import java.util.ArrayList;
import java.util.List;

public class SwatoDemoService {

    public List getList(String str) {
        System.out.println("\n\nstr: " + str);
        List list = new ArrayList();
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        
        return list;
    }
    /*
    public int addTwoNumbers(int first, int second) {
        int sum = first + second;
        return sum;
    }

     public int addTwoNumbers(int first, int second) {
        LoggingUtil.log("entering addTwoNumbers");
        int sum = first + second;
        LoggingUtil.log("exiting addTwoNumbers");
        return sum;
    }

    public int addTwoNumbers(int first, int second) {
        LoggingUtil.log("entering addTwoNumbers");
        PerformanceTimer.start("addTwoNumbers");
        int sum = first + second;
        PerformanceTimer.end("addTwoNumbers");
        LoggingUtil.log("exiting addTwoNumbers");
        return sum;
    }
    */
}
