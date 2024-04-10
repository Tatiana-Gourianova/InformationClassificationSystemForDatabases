<%--@elvariable id="constructionsList" type="java.util.ArrayList"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <title><fmt:message key="title.show.all.type.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="../include/navbar.jsp" %>
<div class="container-fluid">
    <div class="col-md-6 col-md-offset-6">
        <table class="table table-condensed table-bordered">
            <tr>
                <td align="center" style="border-color: #dae5ff"><fmt:message key="table.construction.id"/></td>
                <td align="center" style="border-color: #dae5ff"><fmt:message key="table.construction.title"/></td>
            </tr>
            <c:forEach items="${constructionsList}" varStatus="сounter">
                <tr>
                    <td align="center" style="border-color: #dae5ff">${constructionsList[сounter.count-1].id}</td>
                    <td align="center" style="border-color: #dae5ff">${constructionsList[сounter.count-1].title}</td>


                </tr>
            </c:forEach>
        </table>
        <a href="/jsp/admin_page.jsp" class="btn btn-default"><fmt:message key="continue"/></a>
    </div>
</div>
<br/>
<br/>
<%@ include file="../include/footer_admin.jsp" %>
</body>
</html>



