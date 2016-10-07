package com.proajax.chapt5.strutslayout.ui;

import org.apache.struts.action.ActionForm;

public class AutocompleteForm extends ActionForm {
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
