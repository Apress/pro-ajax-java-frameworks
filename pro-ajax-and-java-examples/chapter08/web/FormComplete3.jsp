<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 
<%@taglib uri="FormComplete" prefix="fc"%> 

<html>
    <f:view>
        <head>
            <title>JSF Ajaxian Form Complete</title>
            <script src="scripts/formComplete.js" type="text/javascript"></script>
        </head>
        <body>
            <h1>Not Really Bill Pay</h1>
            <h:form id="form">
                <fc:formComplete inputOneId="form:payTo" inputTwoId="form:amount" 
                onChangeFunction="getValue()"/>
            </h:form>
        </body>
    </f:view>
</html>