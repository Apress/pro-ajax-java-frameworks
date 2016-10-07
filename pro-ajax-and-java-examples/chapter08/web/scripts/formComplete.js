var xmlHttp;
function getValue() {
  var value = document.getElementById("form:payTo").value;
  alert("The value is: " + value);
  var url = "foo.ajax";
  startRequest(url, value);
}

function createXMLHttpRequest() {
  if (window.ActiveXObject) {
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  else if (window.XMLHttpRequest) {
    xmlHttp = new XMLHttpRequest();
  }
}

function startRequest(url, value) { 
  createXMLHttpRequest(); 
  xmlHttp.onreadystatechange = processValue; 
  xmlHttp.open("POST", url, true);
  xmlHttp.setRequestHeader("Content-Type", 
                           "application/x-www-form-urlencoded"); 
  xmlHttp.send("ajax=true&payTo=" + value); 
}

function processValue() {
  if(xmlHttp.readyState == 4) {
    alert("complete");
    if(xmlHttp.status == 200) {
      var xmlDoc = xmlHttp.responseXML;
      var node = xmlDoc.getElementsByTagName("amount")[0];
      var amount = node.childNodes[0].nodeValue;
      alert("value: " + amount);
      var element = document.getElementById("form:amount");
      element.value = amount;
    }
  }
}                
