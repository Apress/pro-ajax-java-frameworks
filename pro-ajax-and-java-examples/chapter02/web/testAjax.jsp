<%@page contentType="text/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Ajax</title>
        <script type="text/javascript">
            var xmlHttp;

            function createXMLHttpRequest() {
                if (window.ActiveXObject) {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } 
                else if (window.XMLHttpRequest) {
                    xmlHttp = new XMLHttpRequest();
                }
            }

            function getSecretMessage() {
                createXMLHttpRequest();
                xmlHttp.onreadystatechange = handleStateChange;
                xmlHttp.open("GET", "ajaxResponse.jsp", true);
                xmlHttp.send(null);
            }

            function handleStateChange() {
                if(xmlHttp.readyState == 4) {
                    if(xmlHttp.status == 200) {
                        document.getElementById("secretMessage").innerHTML = 
                                            xmlHttp.responseText;
                    }
                }
            }

        </script>
    </head>
    <body>

        <h1>Test Ajax with Selenium</h1>

        <input type="button" id="button" name="button" 
        value="Click me to get secret message from server"
        onclick="getSecretMessage();"/>
                    
        <br/><br/>
        <div id="secretMessage">
                        
        </div>
    </body>
</html>
