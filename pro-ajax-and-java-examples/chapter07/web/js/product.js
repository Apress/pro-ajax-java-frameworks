
function findProductsByDepartment() {
    document.getElementById("status").value = "Searching...";
    var department = document.getElementById("selectDepartment").value;
    ProductService.findProductsByDepartment(department, handleFindProducts);
}

function handleFindProducts(searchResult) {
    var result = TrimPath.processDOMTemplate("searchResultsTemplate"
                                                            , searchResult);
    document.getElementById("products").innerHTML = result;
    document.getElementById("status").value = "Search Complete.";
}

function updatePrice(productId, price) {
    if(!isValidDollarAmount(price)) {
        alert("Not a valid dollar amount.");
        return;
    }

    document.getElementById("status").value = "Updating...";
    ProductService.updateProductPrice(productId, price, handleUpdatePrice);
}

function handleUpdatePrice(result) {
    if(result.successful) {
        document.getElementById("status").value = "Update Successful.";
    }
    else {
        var errorMessage = "Updated failed. Error message: ";
        var errorMessge = errorMessage + result.errorMessage;
        document.getElementById("status").value = errorMessage;
    }
}

function isValidDollarAmount(amount) {
    var isValid = 
    RegExp(/^\$?\d+(\.\d{2})?$/)
    .test(String(amount).replace(/^\s+|\s+$/g, ""));
    return isValid;
}