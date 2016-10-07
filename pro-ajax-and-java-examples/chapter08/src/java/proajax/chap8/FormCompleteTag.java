/*
 * FormCompleteTag.java
 *
 * Created on April 12, 2006, 6:56 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package proajax.chap8;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

/**
 *
 * @author nate
 */
public class FormCompleteTag extends UIComponentTag {
    private String onChangeFunction = "getValue()";
    private String inputOneId = "form:payTo";
    private String inputTwoId = "form:amount";
    
    public String getComponentType() {
        return "proajax.chap8.FormComplete";
    }
    
    public String getRendererType() {
        return null;
    }
    
    public String getOnChangeFunction() {
        return onChangeFunction;
    }
    
    public String getInputOneId() {
        return inputOneId;
    }
    
    public String getInputTwoId() {
        return inputTwoId;
    }
    
    public void setOnChangeFunction(String onChangeFunction) {
        this.onChangeFunction = onChangeFunction;
    }
    
    public void setInputOneId(String inputOneId) {
        this.inputOneId = inputOneId;
    }
    
    public void setInputTwoId(String inputTwoId) {
        this.inputTwoId = inputTwoId;
    }
    
    protected void setProperties(UIComponent component) {
        super.setProperties(component);
        UIFormComplete formComplete = (UIFormComplete)component;
        
        if(onChangeFunction != null) {
            if(isValueReference(onChangeFunction)) {
                ValueBinding vb = FacesContext.getCurrentInstance()
                .getApplication().createValueBinding(onChangeFunction);
                formComplete.setValueBinding("onChangeFunction", vb);
            } else {
                formComplete.setOnChangeFunction(onChangeFunction);
            }
        }
        if(inputOneId != null) {
            if(isValueReference(inputOneId)) {
                ValueBinding vb = FacesContext.getCurrentInstance()
                .getApplication().createValueBinding(inputOneId);
                formComplete.setValueBinding("inputOneId", vb);
            } else {
                formComplete.setInputOneId(inputOneId);
            }
        }
        if(inputTwoId != null) {
            if(isValueReference(inputOneId)) {
                ValueBinding vb = FacesContext.getCurrentInstance()
                .getApplication().createValueBinding(inputTwoId);
                formComplete.setValueBinding("inputTwoId", vb);
            } else {
                formComplete.setInputTwoId(inputTwoId);
            }
        }
    }
    
    public void release() {
        super.release();
    }    
}
