<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:xhtml/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
                            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
                            
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Hotel Reservation System</title>
        <script type="text/javascript" src="js/hotelReservation.js"></script>
        <script type="text/javascript" src="js/prototype-1.4.0.js"></script>
    </head>
    <body>

    <h1>Hotel Reservation System</h1>
    <h3>* Required fields</h3>
    
    <div id="errors">
        <html:errors/>
    </div>
            
    <html:form action="saveReservation.do" method="post" 
        styleId="reservationForm">
        
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <label>* Arrival Date:</label>
                    </td>
                    <td>
                        <html:text property="arrivalDate" 
                            styleId="arrivalDate" onblur="validateForm();"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>* Departure Date:</label>
                    </td>
                    <td>
                        <html:text property="departDate" 
                            styleId="departDate" onblur="validateForm();"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>* Smoking Preference:</label>
                    </td>
                    <td>
                        <html:select property="smokingPref" 
                            styleId="smokingPref" onblur="validateForm();">
                            
                            <html:option value="">Select One</html:option>
                            <html:option value="Smoking">Smoking</html:option>
                            <html:option value="Non Smoking">
                                Non Smoking
                            </html:option>
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Special Requests:</label>
                    </td>
                    <td>
                        <html:textarea property="requests" 
                            styleId="requests" rows="6" cols="50" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>* Name:</label>
                    </td>
                    <td>
                        <html:text property="name" 
                                                               styleId="name" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>* Telephone:</label>
                    </td>
                    <td>
                        <html:text property="telephone" 
                                                        styleId="telephone" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </html:form>
    
    </body>
</html>
