
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
                            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
                            
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Hotel Reservation Confirmed</title>
    </head>
    <body>

        <h1>
            Congratulations! Your reservation is confirmed.
        </h1>
        <ul>
            <li>Arrival Date: ${reservationForm.arrivalDate}</li>
            <li>Departure Date: ${reservationForm.departDate}</li>
            <li>Smoking Preference: ${reservationForm.smokingPref}</li>
            <li>Special Requests: ${reservationForm.requests}</li>
            <li>Name: ${reservationForm.name}</li>
            <li>Telephone: ${reservationForm.telephone}</li>
        </ul>

    </body>
</html>
