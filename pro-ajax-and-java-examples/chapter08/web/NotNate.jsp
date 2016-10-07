<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 

<html>
    <f:view>
        <head>
            <title>You're Not Nate</title>
        </head>
        <body>

        <h1>Dynamic Navigation</h1>
        Wow, you're not Nate - you are <h:outputText value="#{user.name}"/>!!

        </body>
    </f:view>
</html>
