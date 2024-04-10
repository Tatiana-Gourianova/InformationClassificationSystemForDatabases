<%--@elvariable id="constructionsList" type="java.util.ArrayList"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <script type="text/javascript" src="../js/validator.js"></script>
    <title><fmt:message key="title.edit.construction.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../include/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <form action="/controller" method="post" class="form-horizontal">
                <input type="hidden" name="action" value="change_construction">
                <div class="form-group">
                    <label for="construction" class="col-sm-3 control-label"><fmt:message
                            key="update.type.form.construction"/></label>
                    <div class="col-sm-9">
                        <select class="form-control" id="construction" name="constructionId">
                            <c:forEach items="${constructionsList}" var="construction">
                                <option value="${construction.id}"> ${construction.id}, ${construction.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                     <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary"><fmt:message key="update.construction.submit"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../include/footer_admin.jsp" %>
</body>
</html>


