<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BinaryTree Calculator - draw tree</title>
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

<div class="row">
    <div class="col s4">
        <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title">Binary tree</span>
                <p>${log}</p>
            </div>
        </div>
    </div>
    <div class="col s8" style="padding-top:2em;">
        <div class="chip">
            Bits:
            ${bits}
        </div>

        <div class="chip">
            Depth: ${depth}
        </div>

        <div class="chip">
            Avarage depth: ${avg}
        </div>

        <div class="chip">
            Variance: ${var}
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
</body>
</html>