
function calculateSum() {
    /* Retrieve the user's input from the text boxes */
    var inputOne = document.getElementById("addOne").value;
    var inputTwo = document.getElementById("addTwo").value;

    /* Log the user's input */
    Logger.info("first input: " + inputOne 
                                        + "\nsecond input: " + inputTwo);

    /* Attempt to convert the user's input values to integers */
    var firstNumber = parseInt(inputOne);
    var secondNumber = parseInt(inputTwo);

    /* Log an error if either of the values is not an integer */
    if(isNaN(firstNumber)) {
        Logger.error("firstNumber is not a number: " + inputOne);
        clearResult();
        return;
    }

    if(isNaN(secondNumber)) {
        Logger.error("secondNumber is not a number: " + inputTwo);
        clearResult();
        return;
    }

    /* Calculate the sum and display on the page */
    var sum = firstNumber + secondNumber;
    document.getElementById("result").value = sum;
}

function clearResult() {
    document.getElementById("result").value = "";
}
