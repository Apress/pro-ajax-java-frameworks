<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <title>Inventory Control System</title>
        <script type="text/javascript" 
        src="/chapter07/dwr/interface/ProductService.js"></script>
        <script type="text/javascript" src="/chapter07/dwr/engine.js"></script>
        <script type="text/javascript" 
        src="/chapter07/js/product.js"></script>
        <script type="text/javascript" 
        src="/chapter07/js/template.js"></script>

        
    </head>

    <body>
        <div id="wrapper">
            <h1>Inventory Control System</h1>

            Search by department:
            <select id="selectDepartment">
                <option value="home">Home Furnishings</option>
                <option value="clothing">Clothing</option>
                <option value="sporting">Sporting Goods</option>
                <option value="grocery">Grocery</option>
            </select>
                
            <button onclick="findProductsByDepartment();">Search</button>

            <br /><br />
            <div id="products">
                
            </div>
        </div>
        
        <br /><br /><br />
        Status:<input type="text" id="status" 
        readonly="readonly" style="width:90%;"/>
        
        <div id="jstTemplates" style="display:none;">
            <textarea id="searchResultsTemplate">
                <jsp:include page="searchResultsTemplate.jst"/>
            </textarea>
        </div>
    </body>

</html>