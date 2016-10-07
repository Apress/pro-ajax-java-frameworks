<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <title>Chapter 7 || Inventory Control Login</title>
    </head>

    <body onload="document.getElementById('j_username').focus();">
        <div id="wrapper">
            <h1>Inventory Control System</h1>
            <form name="security" id="security" 
                action="j_security_check" method="post">

                <h2>Inventory Control System Login</h2>

                <dl>
                    <dt><label for="j_username">User Name:</label></dt>
                    <dd>
                        <input type="text" name="j_username" id="j_username" 
                        value="" size="20" maxlength="20" />
                    </dd>

                    <dt><label for="j_password">Password:</label></dt>
                    <dd>
                        <input type="password" name="j_password" id="j_password" 
                        value="" size="20" maxlength="20" />
                    </dd>
                    <dd class="button">
                        <input type="submit" value="Login"/>
                    </dd>
                </dl>
            </form>
            
            <h3>Valid Logins (Password is always "password")</h3>
            <ul>
                <li>manager</li>
                <li>trainee</li>
            </ul>

        </div>
    </body>

</html>