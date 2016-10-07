/*
 * InlineEditBox.java
 *
 * Created on March 6, 2006, 8:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.proajax.chapt6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tapestry.html.BasePage;

/**
 *
 * @author nate
 */
public abstract class InlineEditBox extends BasePage {
    
    /** Logger */
    private static final Log log = LogFactory.getLog(InlineEditBox.class);
    
    public void processEdit(String newValue) {
        log.debug("processEdit(" + newValue + ")");
        if (newValue != null) {
            setEditedText("--" + newValue + "--");
        }
    }
    
    /** Gets the value */
    public abstract String getEditedText();
    /** Sets the value */
    public abstract void setEditedText(String value);
}
