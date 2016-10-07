<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

<%@page contentType="text/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>AjaxTags Examples</title>
        <script type="text/javascript" 
            src="js/ajaxtags/prototype-1.3.1.js"></script>
        <script type="text/javascript" 
            src="js/ajaxtags/ajaxtags-1.1.5.js"></script>
        <link rel="stylesheet" type="text/css" href="css/ajaxtags.css" />
    </head>
    <body>
        <h1>AjaxTags Autocomplete</h1>
        <form action="#">
            <p>
                <label for="firstName">Search for a Name: </label>
                <input id="firstName" name="firstName" type="text" size="30" />
            </p>
        </form>

        <ajax:autocomplete
        baseUrl="AutoCompleteServlet"
        source="firstName"
        target="firstName"
        parameters="search={firstName}"
        className="autocomplete"
        minimumCharacters="1" />
        
        <script type="text/javascript">
            var popup = document.getElementById("ajaxAutocompletePopup");
            popup.style.display = "none";
        </script>
        
    </body>
</html>
