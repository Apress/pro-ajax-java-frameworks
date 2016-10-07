<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 

<html>
    <f:view>
        <head>
            <title>Converters and Validators</title>
        </head>
        <body>
            <h1>Not Really Bill Pay</h1>
            <h:form id="form">
                <h:panelGrid columns="3">
                    <h:outputText value="Pay to:"/> 
                    <h:inputText value="#{billpay.payTo}" id="payTo">
                        <f:validateLength maximum="25"/>
                        <f:validator validatorId="nameValidator"/>
                    </h:inputText>
                    <h:message for="payTo" style="color:red"/>
                    <h:outputText value="Amount:"/>
                    <h:inputText value="#{billpay.amount}" id="amount">
                        <f:convertNumber minFractionDigits="2"/>
                        <f:validateDoubleRange minimum="5" maximum="5000"/>
                    </h:inputText>
                    <h:message for="amount" style="color:red"/>
                    <h:outputText value="Date:"/> 
                    <h:inputText value="#{billpay.payDate}" id="payDate">
                        <f:convertDateTime pattern="MM/dd/yyyy"/>
                    </h:inputText>
                    <h:message for="payDate" style="color:red"/>
                </h:panelGrid>
                <h:commandButton value="Pay Bill" action="paybill"/>
            </h:form>
        </body>
    </f:view>
</html>