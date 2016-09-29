<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BinaryTree Calculator - Genom upload</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <form:form action="/index" id="backToIndex">
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li>
                    <a onclick="document.getElementById('backToIndex').submit()">
                        <input type="hidden" name="index">
                        Back to Index
                    </a>
                </li>
            </ul>
        </form:form>
    </div>
</nav>
<form:form action="/upload" enctype="multipart/form-data">
    <div class="row">
        <div class="col s12">
            <div class="file-field input-field">
                <div class="btn">
                    <span>Upload a genom</span>
                    <input type="file" name="genomfile" size="35" accept=".txt">
                </div>
                <div class="file-path-wrapper">
                    <input class="file-path validate" type="text">
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col s12 center-align">
            <button type="submit" name="up" class="btn waves-effect waves-light">Upload</button>
        </div>
    </div>
</form:form>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
</body>
</html>