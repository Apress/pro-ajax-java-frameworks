<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <h1>Successful Login</h1>
    
    <%= request.getParameter("loginId")%> is successfully logged in.
    
    </body>
</html>
