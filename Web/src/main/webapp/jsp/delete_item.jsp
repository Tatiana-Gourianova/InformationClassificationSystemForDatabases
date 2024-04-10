<%--@elvariable id="item" type="Item"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <title><fmt:message key="title.delete.item.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="../include/navbar.jsp" %>
<div class="container-fluid">
    <div class="col-md-6 col-md-offset-6">

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


        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <form action="/controller" method="post" class="form-horizontal">
                        <input type="hidden" name="action" value="delete_item">
                        <div class="form-group">
                            <label for="type" class="col-sm-3 control-label"><fmt:message key="delete.item"/></label>

                            <div class="col-sm-8">
                                <input type="text" id="type" name="roleId" class="form-control"
                                       placeholder="<fmt:message key="search.form.delete.id.placeholder"/>"
                                       maxlength="3" required pattern="[0-9]{1,3}">
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <br/>
                                    <button type="submit" class="btn btn-primary"><fmt:message
                                            key="delete.item"/></button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>


            <a href="../index.jsp" class="btn btn-default"><fmt:message key="continue"/></a>
        </div>
        <%@ include file="../include/footer.jsp" %>
</body>
</html>




