function AjaxRequest(_1){
var _2=this;
var _3=createXMLHttpRequest();
var _4="";
var _5=_1;
var _6="GET";
var _7=null;
var _8=null;
var _9=false;
var _a=true;
var _b=null;
this.getXMLHttpRequestObject=function(){
return _3;
};
this.setPreRequest=function(_c){
_7=_c;
};
this.setPostRequest=function(_d){
_8=_d;
};
this.setUsePOST=function(){
_6="POST";
};
this.setUseGET=function(){
_6="GET";
};
this.setEchoDebugInfo=function(){
_9=true;
};
this.isEchoDebugInfo=function(){
return _9;
};
this.setQueryString=function(qs){
_4=qs;
};
this.getQueryString=function(){
return _4;
};
this.setAsync=function(_f){
_a=_f;
};
this.setErrorHandler=function(_10){
_b=_10;
};
this.addFormElements=function(_11){
var _12=document.getElementById(_11).elements;
var _13=toQueryString(_12);
accumulateQueryString(_13);
};
function accumulateQueryString(_14){
if(_4==""){
_4=_14;
}else{
_4=_4+"&"+_14;
}
}
this.addNamedFormElementsByFormID=function(){
var _15="";
var _16=null;
for(var i=1;i<arguments.length;i++){
_15=arguments[i];
_16=document.getElementsByName(_15);
var _18=new Array();
for(j=0;j<_16.length;j++){
if(_16[j].form&&_16[j].form.getAttribute("id")==arguments[0]){
_18.push(_16[j]);
}
}
if(_18.length>0){
elementValues=toQueryString(_18);
accumulateQueryString(elementValues);
}
}
};
this.addNamedFormElements=function(){
var _19="";
var _1a=null;
for(var i=0;i<arguments.length;i++){
_19=arguments[i];
_1a=document.getElementsByName(_19);
elementValues=toQueryString(_1a);
accumulateQueryString(elementValues);
}
};
this.addFormElementsById=function(){
var id="";
var _1d=null;
var _1e=new Array();
for(var h=0;h<arguments.length;h++){
_1d=document.getElementById(arguments[h]);
if(_1d!=null){
_1e[h]=_1d;
}
}
elementValues=toQueryString(_1e);
accumulateQueryString(elementValues);
};
this.sendRequest=function(){
if(_7){
_7(_2);
}
var obj=this;
_3.onreadystatechange=function(){
handleStateChange(_2);
};
if(_5.indexOf("?")>0){
_5=_5+"&ts="+new Date().getTime();
}else{
_5=_5+"?ts="+new Date().getTime();
}
if(_6=="GET"){
if(_4.length>0){
_5=_5+"&"+_4;
}
_3.open(_6,_5,true);
_3.send(null);
}else{
if(_3.overrideMimeType){
_3.setRequestHeader("Connection","close");
}
_3.open(_6,_5,true);
_3.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
_3.send(_4);
}
if(!_a){
handleStateChange(_2);
}
if(_2.isEchoDebugInfo()){
echoRequestParams();
}
};
handleStateChange=function(_21){
if(_21.getXMLHttpRequestObject().readyState!=4){
return;
}
if(_21.getXMLHttpRequestObject().status==200){
var _22=_21.isEchoDebugInfo();
if(_22){
echoResponse(_21);
}
var _23=_21.getXMLHttpRequestObject().responseXML.documentElement.childNodes;
var _24=null;
var _25="";
for(var i=0;i<_23.length;i++){
if(_23[i].nodeType!=1||!isTaconiteTag(_23[i])){
continue;
}
_25=_23[i].getAttribute("parseInBrowser");
if(_25=="true"){
_24=new XhtmlToDOMParser(_23[i]);
_24.startParsing();
var js=_24.getJavaScript();
if(_22){
echoParsedJavaScript(js);
}
eval(_24.getJavaScript());
}else{
eval(_23[i].firstChild.nodeValue);
}
}
if(_8){
_8(_21);
}
}else{
if(_b){
_b(_2);
}
}
};
function isTaconiteTag(_28){
return _28.tagName.substring(0,9)=="taconite-";
}
function toQueryString(_29){
var _2a=null;
var qs="";
var _2c="";
var _2d="";
for(var i=0;i<_29.length;i++){
_2d="";
_2a=_29[i];
_2c=_2a.getAttribute("name");
if(!_2c){
_2c=_2a.getAttribute("id");
}
if(_2a.tagName.toLowerCase()=="input"){
if(_2a.type.toLowerCase()=="radio"||_2a.type.toLowerCase()=="checkbox"){
if(_2a.checked){
_2d=_2c+"="+_2a.value;
}
}
if(_2a.type.toLowerCase()=="text"||_2a.type.toLowerCase()=="hidden"){
_2d=_2c+"="+encodeURIComponent(_2a.value);
}
}else{
if(_2a.tagName.toLowerCase()=="select"){
_2d=getSelectedOptions(_2a);
}else{
if(_2a.tagName.toLowerCase()=="textarea"){
_2d=_2c+"="+encodeURIComponent(_2a.value);
}
}
}
if(_2d!=""){
if(qs==""){
qs=_2d;
}else{
qs=qs+"&"+_2d;
}
}
}
return qs;
}
function getSelectedOptions(_2f){
var _30=_2f.options;
var _31=null;
var qs="";
var _33="";
for(var x=0;x<_30.length;x++){
_33="";
_31=_30[x];
if(_31.selected){
_33=_2f.name+"="+_31.value;
}
if(_33!=""){
if(qs==""){
qs=_33;
}else{
qs=qs+"&"+_33;
}
}
}
return qs;
}
function echoResponse(_35){
var _36=document.getElementById("debugResponse");
if(_36==null){
_36=createDebugTextArea("Server Response:","debugResponse");
}
var _37=_35.getXMLHttpRequestObject().status+" "+_35.getXMLHttpRequestObject().statusText+"\n\n\n";
_36.value=_37+_35.getXMLHttpRequestObject().responseText;
}
function echoParsedJavaScript(js){
var _39=document.getElementById("debugParsedJavaScript");
if(_39==null){
var _39=createDebugTextArea("Parsed JavaScript (by JavaScript Parser):","debugParsedJavaScript");
}
_39.value=js;
}
function createDebugTextArea(_3a,id){
echoTextArea=document.createElement("textarea");
echoTextArea.setAttribute("id",id);
echoTextArea.setAttribute("rows","15");
echoTextArea.setAttribute("style","width:100%");
echoTextArea.style.cssText="width:100%";
document.getElementsByTagName("body")[0].appendChild(document.createTextNode(_3a));
document.getElementsByTagName("body")[0].appendChild(echoTextArea);
return echoTextArea;
}
function echoRequestParams(){
var _3c=document.getElementById("qsTextBox");
if(_3c==null){
_3c=createDebugTextBox("Query String:","qsTextBox");
}
_3c.value=_4;
var _3d=document.getElementById("urlTextBox");
if(_3d==null){
_3d=createDebugTextBox("URL (Includes query string if GET request):","urlTextBox");
}
_3d.value=_5;
}
function createDebugTextBox(_3e,id){
textBox=document.createElement("input");
textBox.setAttribute("type","text");
textBox.setAttribute("id",id);
textBox.setAttribute("style","width:100%");
textBox.style.cssText="width:100%";
document.getElementsByTagName("body")[0].appendChild(document.createTextNode(_3e));
document.getElementsByTagName("body")[0].appendChild(textBox);
return textBox;
}
}
function createXMLHttpRequest(){
var req=false;
if(window.XMLHttpRequest){
req=new XMLHttpRequest();
}else{
if(window.ActiveXObject){
try{
req=new ActiveXObject("Msxml2.XMLHTTP");
}
catch(e){
try{
req=new ActiveXObject("Microsoft.XMLHTTP");
}
catch(e){
req=false;
}
}
}
}
return req;
}

