<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<br/>
<br/>
<br/>
<nav class="navbar navbar-default navbar-fixed-bottom" style="background: #20B2AA">
    <div class="container-fluid">
        <form class="navbar-form navbar-right" action="/controller">
            <input type="hidden" name="action" value="show_admin_page">
            <%--  <form class="navbar-form navbar-right" action="/index">--%>

            <br/>
            <button type="submit" class="btn btn-default"><fmt:message key="nav.home"/></button>

        </form>
    </div>
</nav>
<br/>
<br/>
<br/>
<script src="../js/jquery-3.2.0.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

