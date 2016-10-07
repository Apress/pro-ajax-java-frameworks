<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 

<html>
    <f:view>
        <head>
            <title>Dynamic Navigation</title>
        </head>
        <body>
        <h:form id="form">
            <h1>Please Enter Your Name</h1>
            Name: <h:inputText value="#{user.name}" id="name"/>
            <p>
            <h:commandButton value="Say Hello" action="#{user.isNate}"/>
        </h:form>
        </body>
    </f:view>
</html>