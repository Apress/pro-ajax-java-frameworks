<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 

<html>
    <f:view>
        <head>
            <title>How Components are Named</title>
            <script type="text/javascript">
                function showValue() {
                  var value = document.getElementById("form:name").value;
                  alert("The value is: " + value); 
                }
            </script>

        </head>
        <body>
        <h:form id="form">
            <h1>Please Enter Your Name</h1>
            Name: <h:inputText value="#{user.name}" id="name" onblur="showValue()"/>
            <p>
            <h:commandButton value="Say Hello" action="hello"/>
        </h:form>
        </body>
    </f:view>
</html>
