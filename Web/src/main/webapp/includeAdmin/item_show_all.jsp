<%--@elvariable id="sensorsList" type="java.util.ArrayList"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <title><fmt:message key="title.show.all.user.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<%@ include file="../include/navbar.jsp" %>
<%@ include file="../include/home.jsp" %>


<div class="container-fluid">
    <div class="col-md-6 col-md-offset-1">
        <table class="table table-condensed table-bordered">
            <tr>
                <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.id"/></td>
                <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.title"/></td>
                <%--<td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.model"/></td>--%>
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
                <%-- <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.averagedSI"/></td> --%>
            </tr>
            <c:forEach items="${itemsList}" varStatus="сounter">
                <tr>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].id}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].name}</td>
                  <%--  <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].model}</td>--%>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].thickness}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].density}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si63}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si125}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si250}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si500}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si1000}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si2000}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si4000}</td>
                    <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si8000}</td>
                   <%-- <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].averagedSI}</td> --%>

                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="jsp/admin_page.jsp" class="btn btn-default"><fmt:message key="continue"/></a>
    </div>
</div>
<br/>
<br/>
<br/>
<%@ include file="../include/footer.jsp" %>
</body>
</html>



