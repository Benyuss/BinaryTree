<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BinaryTree Calculator - Index</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
</head>
<body>
<div class="row" style="margin-top:16.2em;">
    <div class="col s4 center-align">
        <form:form action="/manual-input">
            <button class="btn waves-effect waves-light" name="custom">Upload tree by manual input</button>
        </form:form>
    </div>
    <div class="col s4 center-align">
        <form:form action="/upload">
            <button class="btn waves-effect waves-light" name="upload">Upload a genom</button>
        </form:form>
    </div>
    <div class="col s4 center-align">
        <form:form action="/choose-tree">
            <button class="btn waves-effect waves-light" name="draw">Process that uploaded tree</button>
        </form:form>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
</body>
</html>