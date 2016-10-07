<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 

<html>
    <f:view>
        <head>
            <title>Hello World!</title>
        </head>
        <body>
        <h:form>
            <h1>Please Enter Your Name</h1>
            Name: <h:inputText value="#{user.name}"/>
            <p>
            <h:commandButton value="Say Hello" action="hello"/>
        </h:form>
        </body>
    </f:view>
</html>
