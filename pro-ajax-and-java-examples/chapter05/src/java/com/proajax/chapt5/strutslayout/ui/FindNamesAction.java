package com.proajax.chapt5.strutslayout.ui;

import fr.improve.struts.taglib.layout.suggest.SuggestAction;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class FindNamesAction extends SuggestAction {
    public Collection getSuggestionList(HttpServletRequest httpServletRequest, String string) {
        Collection names = new ArrayList();
        names.add("fred");
        names.add("joe");
        names.add("jim");
        
        return names;
    }
}
