<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 

<html>
    <f:view>
        <head>
            <title>Hello JSF</title>
        </head>
        <body>

        <h1>A Simple JSF Example</h1>
        Hello There <h:outputText value="#{user.name}"/>!!

        </body>
    </f:view>
</html>
