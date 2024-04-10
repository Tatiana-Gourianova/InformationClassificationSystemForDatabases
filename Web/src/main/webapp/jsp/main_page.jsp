<%--@elvariable id="user" type="User"--%>
<%--@elvariable id="itemsList" type="java.util.ArrayList"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <title><fmt:message key="title.main.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="../include/navbar.jsp" %>


<%--users role: 7 - user; 6 - administrator--%>
<%--roleI  7 display a list of sensors without the possibility to edit them--%>
<table>
    &nbsp;
</table>

<div class="container-fluid">
    <div class="col-sm-10">
        <c:if test="${empty user or (not empty user and user.roleId < 6)}">
            <lable class="col-sm-19 control-label"><b><fmt:message key="welcome.guest"/></b></lable>
        </c:if>
    </div>
</div>

<c:if test="${not empty user  and  (user.roleId == 6) or (user.roleId == 7)}">

    <div class="container-fluid">
        <div class="col-md-6 col-md-offset-6">
            <table class="table table-condensed table-bordered">
                <tr>
                    <c:if test="${not empty user  and  (user.roleId == 6)}">
                        <td align="center" style="border-color: #8381eb"><fmt:message key="blank"/></td>
                    </c:if>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.id"/></td>
                    <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.title"/></td>
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

                <%--   <td align="center" style="border-color: #8381eb"><fmt:message key="table.item.description"/></td>--%>


                    <c:if test="${not empty user  and  (user.roleId == 6)}">
                        <td align="center" style="border-color: #8381eb"><fmt:message key="blank"/></td>
                    </c:if>
                </tr>

                <c:forEach items="${itemsList}" varStatus="сounter" >
                    <tr>
                        <c:if test="${not empty user  and  (user.roleId == 6) and not empty itemsList}">
                            <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                                <form action="/controller" method="post">

                                 <%--   <input type="hidden" name="action" value="show_edit_item_page"  >--%>

                                    <input type="hidden" id="itemId" name="itemId" class="form-control"
                                           value=${itemsList[сounter.count-1].id}>
                                     <button type="submit" class="btn btn-link" id="edit" name="action" value="show_edit_item_page" >
                                        edit
                                    </button>
                                </form>
                            </td>
                        </c:if>
                       <td align="center"
                            style="vertical-align: middle; border-color: #8381eb">${itemsList[сounter.count-1].id}</td>
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
                        <td align="center" style="border-color: #dae5ff">${itemsList[сounter.count-1].si8000}</td>


                        <c:if test="${not empty user  and  (user.roleId == 6) and not empty itemsList}">
                            <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                                <form action="/controller" method="post">
                                    <input type="hidden" id="id" name="itemId" class="form-control"
                                           value=${itemsList[сounter.count-1].id}>
                                    <button type="submit" class="btn btn-link" id="delete" name="action" value="show_delete_item_page" >
                                        <img src="../images/delete.png">
                                    </button>
                                </form>
                            </td>
                        </c:if>

                    </tr>
                </c:forEach>
            </table>

            <nav aria-label="...">
                <ul class="pager">
                    <li class="previous${leftPageClass}"><a href="${leftPage}"><fmt:message key="page.previous"/></a>
                    </li>
                    <li class="next${rightPageClass}"><a href="${rightPage}"><fmt:message key="page.next"/></a></li>
                </ul>
            </nav>
        </div>
    </div>
</c:if>




     <c:if test="${not empty user  and  (user.roleId == 6)}">
 <div class="container-fluid">
     <div class="col-md-6 col-md-offset-6">
         <table class="table table-condensed table-bordered">
     <td align="center" style="vertical-align: middle; border-color: #dae5ff">

         <a href="jsp/admin_page.jsp"> <fmt:message key="nav.admin"/></a>
         <form action="/controller" method="post">
            <%-- <input type="hidden" name="action" value="goto_admin_page">--%>

             <button type="submit" class="btn btn-link"></button>
         </form>
     </td>
         </table>
     </div>
 </div>
             </c:if>



<%@ include file="../include/footer.jsp" %>
<%-- <jsp:include page="../include/footer.jsp"/>--%>
</body>
</html>



