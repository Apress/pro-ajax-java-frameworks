package proajax.chap8;
import java.io.IOException;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
/*
 * UIFormComplete.java
 *
 * Created on April 12, 2006, 6:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author nate
 */
public class UIFormComplete extends UIInput {
    private String onChangeFunction;
    private String inputOneId;
    private String inputTwoId;
    
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
    
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        encodeFirstInput(writer);
        encodeSecondInput(writer);
    }
    
    private void encodeFirstInput(ResponseWriter writer) throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("type", "text", null);
        writer.writeAttribute("name", getInputOneId(), null);
        writer.writeAttribute("id", getInputOneId(), null);
        writer.writeAttribute("onchange", getOnChangeFunction(), null);
        
        Object val = getValue();
        if (val != null) {
            writer.writeAttribute("value", val, "value");
        }
        
        Integer size = (Integer) getAttributes().get("size");
        if (size != null) {
            writer.writeAttribute("size", size, "size");
        }
        
        writer.endElement("input");
    }
    
    private void encodeSecondInput(ResponseWriter writer)  throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("type", "text", null);
        writer.writeAttribute("name", getInputTwoId(), null);
        writer.writeAttribute("id", getInputTwoId(), null);
        
        Object val = getValue();
        if (val != null) {
            writer.writeAttribute("value", val, "value");
        }
        
        Integer size = (Integer) getAttributes().get("size");
        if (size != null) {
            writer.writeAttribute("size", size, "size");
        }
        
        writer.endElement("input");
    }
}
