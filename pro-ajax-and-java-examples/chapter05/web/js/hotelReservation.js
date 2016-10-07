
function hasEntry(id) {
    return $F(id).length > 0;
}

function isFormReadyForValidation() {
    var ready = false;
    
    if(hasEntry("arrivalDate") 
    && hasEntry("departDate") 
    && $F("smokingPref").length > 0) {
        
        ready = true;
    }
    
    return ready;
}

function validateForm() {
    var isReady = isFormReadyForValidation();
    
    if(isReady) {
        sendFormForValidation();
    }
}

function sendFormForValidation() {
    var queryString = Form.serialize("reservationForm");
    queryString = queryString + "&ts=" + new Date().getTime();
    var url = "validateReservation.do";
    
    new Ajax.Request(url, { 
        asynchronous: true, 
        method: "get", 
        parameters: queryString, 
        onComplete: function(request) { 
            handleResponse(request.responseText); 
        }
    });
}

function handleResponse(text) {
    $("errors").innerHTML = text;
}

