package com.proajax.chapt6;

import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.html.BasePage;

public abstract class Home extends BasePage {
    @Persist
    public abstract int getCounter();
    public abstract void setCounter(int counter);
    
    public void incrementCounter() {
        int counter = getCounter();
        counter++;
        setCounter(counter);
    }
    
    public void resetCounter() {
        setCounter(0);
    }
    
    public void addToCounter(int value) {
        int counter = getCounter();
        counter += value;
        setCounter(counter);
    }
}