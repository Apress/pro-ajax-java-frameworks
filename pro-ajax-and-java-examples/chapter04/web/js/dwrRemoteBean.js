
function getServerDateTime() {
    RemoteBean.getServerDate(handleGetServerDateTime);
}

function handleGetServerDateTime(dateTime) {
    //dateTime is the string returned by RemoteBean.getServerDate()
    DWRUtil.setValue("serverDateTime", dateTime);
}


function getSumOfCharactersInString() {
    DWRUtil.useLoadingMessage();
    var textInput = $("textInput").value;
    RemoteBean.calculateCharacterSum(textInput, handleGetSumOfCharactersInString);
}

function handleGetSumOfCharactersInString(sumOfCharacters) {
    DWRUtil.setValue("characterSumResponse", sumOfCharacters);
}

function getLuckyNumber() {
    var name = $("nameInput").value;
    var password = $("passwordInput").value;

    var callbackFunction = function(luckyNumber) {
        handleGetLuckyNumber(luckyNumber, name, password);
    };

    RemoteBean.getLuckyNumber(name, password, callbackFunction);
}

function handleGetLuckyNumber(luckyNumber, name, password) {
    var message = "Name \"" + name + "\" and password \""
        + password + "\" produce a lucky number of " + luckyNumber;

    DWRUtil.setValue("luckyNumberResponse", message);
}

function getPerson() {
    RemoteBean.getPerson(handleGetPerson);
}

function handleGetPerson(person) {
    DWRUtil.setValue("firstName", person.firstName);
    DWRUtil.setValue("lastName", person.lastName);
    DWRUtil.setValue("age", person.age);

    removeChildren($("addressesTbody"));

    var row = null;
    var address = null;
    var button = null;
    for(var i = 0; i < person.addresses.length; i++) {
        address = person.addresses[i];
        row = document.createElement("tr");
        row.appendChild(createCellWithText(
            address.addressLine1, "addr1-" + address.id));
        row.appendChild(createCellWithText(
            address.addressLine2, "addr2-" + address.id));
        row.appendChild(createCellWithText(address.city, "city-" + address.id));
        row.appendChild(createCellWithText(address.state, "state-" + address.id));
        row.appendChild(createCellWithText(address.zip, "zip-" + address.id));

        row.appendChild(createSaveButtonCell(address.id));

        $("addressesTbody").appendChild(row);
    }
}

function createCellWithText(text, id) {
    var cell = document.createElement("td");
    var input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("id", id);
    input.value = text;

    cell.appendChild(input);
    return cell;
}

function createSaveButtonCell(id) {
    var button = document.createElement("button");
    button.onclick = function() { saveAddress(id); };
    button.appendChild(document.createTextNode("Save"));

    var cell = document.createElement("td");
    cell.appendChild(button);

    return cell;
}

function removeChildren(node) {
    while(node.childNodes.length > 0) {
        node.removeChild(node.childNodes[0]);
    }
}

function saveAddress(id) {
    var address = new Object();
    address["id"] = id;
    address["addressLine1"] = $("addr1-" + id).value;
    address["addressLine2"] = $("addr2-" + id).value;
    address["city"] = $("city-" + id).value;
    address["state"] = $("state-" + id).value;
    address["zip"] = $("zip-" + id).value;

    alert(DWRUtil.toDescriptiveString(address, 1));

    RemoteBean.saveAddress(address, handleSaveAddress);
}

function handleSaveAddress(status) {
    alert("Save Status: " + status);
}


function getPersonUsingJst() {
    RemoteBean.getPerson(handleSaveAddressUsingJst);
}

function handleSaveAddressUsingJst(person) {
    var result = TrimPath.processDOMTemplate("personTemplate", person);
    $("jstOutput").innerHTML = result;
}

function saveAddressFromJstTable(id) {
    var address = new Object();
    address["id"] = id;
    address["addressLine1"] = $("addr1-jst-" + id).value;
    address["addressLine2"] = $("addr2-jst-" + id).value;
    address["city"] = $("city-jst-" + id).value;
    address["state"] = $("state-jst-" + id).value;
    address["zip"] = $("zip-jst-" + id).value;

    alert(DWRUtil.toDescriptiveString(address, 1));

    RemoteBean.saveAddress(address, handleSaveAddress);
}
