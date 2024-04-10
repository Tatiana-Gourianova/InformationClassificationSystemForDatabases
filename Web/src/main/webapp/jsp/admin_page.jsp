<%--@elvariable id="usersList" type="java.util.ArrayList"--%>
<%--@elvariable id="itemsList" type="java.util.ArrayList"--%>
<%--@elvariable id="consructsList" type="java.util.ArrayList"--%>
<%--@elvariable id="materialsList" type="java.util.ArrayList"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <script type="text/javascript" src="../js/validator.js"></script>
    <title><fmt:message key="title.admin.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../include/navbar_admin.jsp" %>

<%-- %%%%%%%%%%%%%%%%%%%%%%%% useres: uncommemnt when necessary-%%%%%%%%%%%%%%%%%%%%%%%%

<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-condensed table-bordered">
                    <tr class="active">
                        <td align="center" style="border-color: #8381eb"><fmt:message key="table.user.id"/></td>
                        <td align="center" style="border-color: #8381eb"><fmt:message key="table.user.first.name"/></td>
                        <td align="center" style="border-color: #8381eb"><fmt:message key="table.user.last.name"/></td>
                        <td align="center" style="border-color: #8381eb"><fmt:message key="table.user.login"/></td>
                         <td align="center" style="border-color: #8381eb"><fmt:message key="table.user.role"/></td>
                    </tr>
                    <c:forEach items="${usersList}" varStatus="сounter">
                        <tr class="active">
                            <td align="center" style="border-color: #8381eb">${usersList[сounter.count-1].id}</td>
                            <td align="center"
                                style="border-color: #8381eb">${usersList[сounter.count-1].firstName}</td>
                            <td align="center" style="border-color: #8381eb">${usersList[сounter.count-1].lastName}</td>
                            <td align="center" style="border-color: #8381eb">${usersList[сounter.count-1].login}</td>
                            <td align="center" style="border-color: #8381eb">${usersList[сounter.count-1].roleId}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-condensed table-bordered">
                    <tr class="active">

                        <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.title"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.thickness"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.density"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si63"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si125"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si250"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si500"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si1000"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si2000"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si4000"/></td>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.si8000"/></td>
                    </tr>
                    <c:forEach items="${itemsList}" varStatus="сounter" end = "5">
                        <tr class="active">

                            <td align="center"
                                style="vertical-align: middle; border-color: #8381eb">${itemsList[сounter.count-1].name}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].thickness}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].density}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si63}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si125}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si250}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si500}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si1000}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si2000}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si4000}</td>
                            <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si8000}</td>              </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div class="col-md-4">
            <div class="col-md-10 col-md-offset-0">
                <table class="table table-condensed table-bordered">

                    <tr class="active">

                        <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.type.id"/></td>
                        <td align="center" style="border-color: #8381eb"><fmt:message
                                key="table.item.type"/></td>

                    </tr>
                    <c:forEach items="${constructsList}" varStatus="сounter" >
                        <tr class="active">

                            <td align="center"
                                style="vertical-align: middle; border-color: #8381eb">${constructsList[сounter.count-1].id}</td>
                            <td align="center"
                                style="vertical-align: middle; border-color: #8381eb">${constructsList[сounter.count-1].type}</td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div class="col-md-4">
            <div class="col-md-10 col-md-offset-0">
                <table class="table table-condensed table-bordered">
                    <tr class="active">

                        <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.unit.id"/></td>
                        <td align="center" style="border-color: #8381eb"><fmt:message
                                key="table.item.unit"/></td>
                        <td align="center" style="border-color: #8381eb"><fmt:message
                                key="table.item.source"/></td>
                        <td align="center" style="border-color: #8381eb"><fmt:message
                                key="table.item.url"/></td>

                    </tr>
                    <c:forEach items="${materialsList}" varStatus="сounter" end="3">
                        <tr class="active">

                            <td align="center"
                                style="vertical-align: middle; border-color: #8381eb">${materialsList[сounter.count-1].id}</td>
                            <td align="center"
                                style="vertical-align: middle; border-color: #8381eb">${materialsList[сounter.count-1].unit}</td>
                            <td align="center"
                                style="vertical-align: middle; border-color: #8381eb">${materialsList[сounter.count-1].source}</td>
                            <td align="center"
                                style="vertical-align: middle; border-color: #8381eb">${materialsList[сounter.count-1].url}</td>
                        </tr>
                    </c:forEach>

            </div>
        </div>
    </div>
</div>

--%>
<%@ include file="../include/footer_admin.jsp" %>
</body>
</html>

