<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 

<html>
    <f:view>
        <head>
            <title>JSF Ajaxian Form Complete</title>
            <script type="text/javascript">
                var xmlHttp;
                function getValue() {
                  var value = document.getElementById("form:payTo").value;
                  alert("The value is: " + value);
                  var url = "";
                  startRequest(url, value);
                }
                
                function createXMLHttpRequest() {
                  if (window.ActiveXObject) {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                  }
                  else if (window.XMLHttpRequest) {
                    xmlHttp = new XMLHttpRequest();
                  }
                }
                
                function startRequest(url, value) { 
                  createXMLHttpRequest(); 
                  xmlHttp.onreadystatechange = processValue; 
                  xmlHttp.open("POST", url, true);
                  xmlHttp.setRequestHeader("Content-Type", 
                                           "application/x-www-form-urlencoded"); 
                  xmlHttp.send("ajax=true&payTo=" + value); 
                }
                
                function processValue() {
                  if(xmlHttp.readyState == 4) {
                    alert("complete");
                    var xmlDoc = xmlHttp.responseXML;
                    var node = xmlDoc.getElementsByTagName("amount")[0];
                    var amount = node.childNodes[0].nodeValue;
                    alert("value: " + amount);
                    if(xmlHttp.status == 200) {
                      var element = document.getElementById("form:amount");
                      element.value = amount;
                    }
                  }
                }                
            </script>
        </head>
        <body>
            <h1>Not Really Bill Pay</h1>
            <h:form id="form">
                <h:panelGrid columns="3">
                    <h:outputText value="Pay to:"/> 
                    <h:inputText value="#{billpay.payTo}" id="payTo" onblur="getValue()">
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