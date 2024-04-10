<%--@elvariable id="itemsList" type="java.util.ArrayList"--%>
<%--@elvariable id="item" type="Item"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <script type="text/javascript" src="../js/validator.js"></script>
    <title><fmt:message key="title.delete.item.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../include/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <form action="/controller" method="post" class="form-horizontal">
                <input type="hidden" name="action" value="delete_item">
                <table class="table table-condensed table-bordered">
                    <tr>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="table.number"/></td>
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
                    <tr>

                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.id}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.name}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.thickness}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.density}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si63}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si125}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si250}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si1000}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si2000}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si4000}</td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si8000}</td>
                    </tr>
                </table>
                <div class="form-group">
                    <label for="item" class="col-sm-3 control-label"><fmt:message key="delete.item.form"/></label>
                    <div class="col-sm-9">
                        <select class="form-control" id="item" name="itemId">
                            <c:forEach items="${itemsList}" var="item">
                                <option value="${item.id}">${item.id}, ${item.name},${item.thickness},${item.density},${item.si63},${item.si125},${item.si500},${item.si1000},${item.si2000},${item.si4000},${item.si8000}</option>
                            </c:forEach>
                             </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary"><fmt:message key="delete.item.submit"/></button>
                    </div>
                </div>
            </form>
            <tr>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.id}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.name}</td>
                <td align="center"
                    style="vertical-align: middle; border-color: #dae5ff">${item.thickness}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.density}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si63}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si125}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si500}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si1000}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si2000}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si4000}</td>
                <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.si8000}</td>
                <%-- <td align="center" style="vertical-align: middle; border-color: #dae5ff">${item.description}</td>--%>
            </tr>
        </div>
    </div>
</div>
<%@ include file="../include/footer.jsp" %>
</body>
</html>


