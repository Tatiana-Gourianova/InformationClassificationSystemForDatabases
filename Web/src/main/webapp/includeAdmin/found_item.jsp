<%--@elvariable id="itemsList" type="java.util.ArrayList"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <script type="text/javascript" src="../js/validator.js"></script>
    <title><fmt:message key="title.found.item.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../include/navbar.jsp" %>

<div class="container-fluid">
<div class="row">
    <div class="col-md-4">
        <div class="col-md-10 col-md-offset-1">
            <table class="table table-condensed table-bordered">
                <tr class="active">
                    <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.model"/></td>
                    <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.title"/></td>
                    <%--TODO поменять формат на десятичный--%>
                    <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.thickness"/></td>
                    <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.density"/></td>
              <%--TODO отображается id констракта, добавить список constructs, чтобы отобразить название
                <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.type"/></td>
              --%>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si63"/></td>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si125"/></td>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si250"/></td>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si500"/></td>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si1000"/></td>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si2000"/></td>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si4000"/></td>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si8000"/></td> </tr>

                <c:forEach items="${itemsList}" varStatus="сounter" end="3">
                    <tr class="active">

                        <td align="center"
                            style="vertical-align: middle; border-color: #8381eb">${itemsList[сounter.count-1].name}</td>
                        <td align="center"
                            style="vertical-align: middle; border-color: #8381eb">${itemsList[сounter.count-1].model}</td>
                        <td align="center"
                            style="vertical-align: middle; border-color: #8381eb">${itemsList[сounter.count-1].thickness}</td>

                        <td align="center"
                            style="vertical-align: middle; border-color: #8381eb">${itemsList[сounter.count-1].density}</td>
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si63}</td>
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si125}</td>
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si250}</td>
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si500}</td>
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si1000}</td>
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si2000}</td>
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si4000}</td>
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si8000}</td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
    &nbsp;
</div>
<a href="/controller?action=show_all_user_items_changing" class="btn btn-default"><fmt:message key="continue"/></a>


</body>
</html>


