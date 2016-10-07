<%@ include file="/jsp/include/imports.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Chapter 7: Spring Hello World</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h3>Date string: ${domain.dateString}</h3>
        <ul>
            <c:forEach var="str" items="${domain.strings}">
                <li>${str}</li>
            </c:forEach>
        </ul>
    </body>
</html>
