<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<logic:messagesPresent>
    <ul>
        <html:messages id="error">
            <li style="color:red;">
                <bean:write name="error"/>
            </li>
        </html:messages>
    </ul>
</logic:messagesPresent>

