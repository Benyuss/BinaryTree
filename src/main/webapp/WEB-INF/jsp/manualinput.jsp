<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BinaryTree Calculator - Custom Tree </title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
</head>
<body>
<!--That was sad Becne!! Don't use a lot of br tags for positioning-->
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

<div class="row" style="margin-top:5em;">
    <form:form action="/manual-input" name="custom">
        <div class="input-field col s4 offset-s2">
            <form:input id="bits" type="text" path="bits"/>
            <label for="bits">Bits</label>
        </div>
        <div class="col s4">
            <button class="btn waves-effect waves-light" name="submit" style="margin-top:1.5em;">Calculate tree from
                that bitset
            </button>
        </div>
    </form:form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>

<script>
    $(function () {
        $("input[name='bits']").keypress(function (e) {
            if (e.keyCode == 48 || e.keyCode == 49) {
            } else {
                e.preventDefault();
            }
        });
    });
</script>
</body>
</html>