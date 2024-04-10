<%--@elvariable id="constructsList" type="java.util.ArrayList"--%>
<%--@elvariable id="materialsList" type="java.util.ArrayList"--%>
<%--@elvariable id="itemOne" type="Item"--%>
<%--@elvariable id="wrongRangeData" type="java.lang.String"--%>
<%--@elvariable id="item" type="Item"--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <script type="text/javascript" src="../js/validator.js"></script>
    <title><fmt:message key="title.add.item.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../include/navbar.jsp" %>


<form action="/controller" method="post" class="form-horizontal">
    <input type="hidden" name="action" value="update_item">


    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <form action="/controller" method="post" class="form-horizontal">
                    <input type="hidden" name="action" value="add_item">

                    <div class="form-group">
                        <label for="title" class="col-sm-3 control-label"><fmt:message key="add.item.form.title"/></label>
                        <div class="col-sm-9">
                            <input type="text" id="title" name="title" class="form-control"
                                   placeholder="<fmt:message key="add.item.form.title.placeholder"/>"
                                   maxlength="10" required pattern="[a-zA-Z0-9._*]{1,30}">
                            <b style="color: darkgray; font-size: 10px"><fmt:message key="validation.item.title"/></b>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="thicknessForm" class="col-sm-3 control-label"><fmt:message
                                key="add.item.form.thickness"/></label>

                        <div class="col-sm-9">
                            <input type="number" step="0.01" id="thicknessForm" name="thickness" class="form-control"
                                   placeholder="<fmt:message key="add.item.form.thickness.placeholder"/>"
                                   maxlength="10" required pattern="[a-zA-Z0-9._*]{1,30}">
                            <b style="color: darkgray; font-size: 10px"><fmt:message key="validation.item.thickness"/></b>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="densityForm" class="col-sm-3 control-label"><fmt:message
                                key="add.item.form.density"/></label>

                        <div class="col-sm-9">
                            <input type="number" step="0.001" id="densityForm" name="density" class="form-control"
                                   placeholder="<fmt:message key="add.item.form.density.placeholder"/>"
                                   maxlength="10" required pattern="[a-zA-Z0-9._*]{1,30}">
                            <b style="color: darkgray; font-size: 10px"><fmt:message key="validation.density"/></b>
                        </div>
                    </div>


                    <table class="table table-condensed table-bordered">


                        <td>
                            <div class="form-group">
                                <label for="si63Form" class="col-sm-2 control-label"><fmt:message
                                        key="register.form.si63"/></label>
                                <div class="col-sm-push-10">
                                    <input type="number" step="1" id="si63Form" name="si63" class="form-control"
                                           placeholder="<fmt:message key="register.form.si63.placeholder"/>"
                                           onKeyup="checkData('si63')" maxlength="5" required pattern="[0-100]{1,100}">
                                    <b id="si65" style="color: red; font-size: 10px"><fmt:message
                                            key="validation.si63"/></b>
                                </div>
                            </div>
                        </td>


                        <td>
                            <div class="form-group">
                                <label for="si125Form" class="col-sm-2 control-label"><fmt:message
                                        key="register.form.si125"/></label>
                                <div class="col-sm-push-10">
                                    <input type="number" step="1" id="si125Form" name="si125" class="form-control"
                                           placeholder="<fmt:message key="register.form.si125.placeholder"/>"
                                           onKeyup="checkData('si125`')" maxlength="5" required pattern="[0-100]{1,100}">
                                    <b id="si125" style="color: red; font-size: 10px"><fmt:message
                                            key="validation.si125"/></b>
                                </div>
                            </div>
                        </td>


                        <td>
                            <div class="form-group">
                                <label for="si250Form" class="col-sm-2 control-label"><fmt:message
                                        key="register.form.si250"/></label>
                                <div class="col-sm-push-10">
                                    <input type="number" step="1" id="si250Form" name="si250" class="form-control"
                                           placeholder="<fmt:message key="register.form.si250.placeholder"/>"
                                           onKeyup="checkData('si250')" maxlength="5" required pattern="[0-100]{1,100}">
                                    <b id="si250" style="color: red; font-size: 10px"><fmt:message
                                            key="validation.si250"/></b>
                                </div>
                            </div>
                        </td>

                        <td>
                            <div class="form-group">
                                <label for="si500Form" class="col-sm-2 control-label"><fmt:message
                                        key="register.form.si500"/></label>
                                <div class="col-sm-push-10">
                                    <input type="number" step="1" id="si500Form" name="si500" class="form-control"
                                           placeholder="<fmt:message key="register.form.si500.placeholder"/>"
                                           onKeyup="checkData('si500')" maxlength="5" required pattern="[0-100]{1,100}">
                                    <b id="si500" style="color: red; font-size: 10px"><fmt:message
                                            key="validation.si500"/></b>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <label for="si1000Form" class="col-sm-2 control-label"><fmt:message
                                        key="register.form.si1000"/></label>
                                <div class="col-sm-push-10">
                                    <input type="number" step="1" id="si1000Form" name="si1000" class="form-control"
                                           placeholder="<fmt:message key="register.form.si1000.placeholder"/>"
                                           onKeyup="checkData('si1000')" maxlength="5" required pattern="[0-100]{1,100}">
                                    <b id="si1000" style="color: red; font-size: 10px"><fmt:message
                                            key="validation.si1000"/></b>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <label for="si2000Form" class="col-sm-2 control-label"><fmt:message
                                        key="register.form.si2000"/></label>
                                <div class="col-sm-push-10">
                                    <input type="number" step="1" id="si2000Form" name="si2000" class="form-control"
                                           placeholder="<fmt:message key="register.form.si2000.placeholder"/>"
                                           onKeyup="checkData('si2000')" maxlength="5" required pattern="[0-100]{1,100}">
                                    <b id="si2000" style="color: red; font-size: 10px"><fmt:message
                                            key="validation.si2000"/></b>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <label for="si4000Form" class="col-sm-2 control-label"><fmt:message
                                        key="register.form.si4000"/></label>
                                <div class="col-sm-push-10">
                                    <input type="number" step="1" id="si4000Form" name="si4000" class="form-control"
                                           placeholder="<fmt:message key="register.form.si4000.placeholder"/>"
                                           onKeyup="checkData('si4000')" maxlength="5" required pattern="[0-100]{1,100}">
                                    <b id="si4000" style="color: red; font-size: 10px"><fmt:message
                                            key="validation.si4000"/></b>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <label for="si8000Form" class="col-sm-2 control-label"><fmt:message
                                        key="register.form.si8000"/></label>
                                <div class="col-sm-push-10">
                                    <input type="number" step="1" id="si8000Form" name="si8000" class="form-control"
                                           placeholder="<fmt:message key="register.form.si8000.placeholder"/>"
                                           onKeyup="checkData('si8000')" maxlength="5" required pattern="[0-100]{1,100}">
                                    <b id="si8000" style="color: red; font-size: 10px"><fmt:message
                                            key="validation.si8000"/></b>
                                </div>
                            </div>
                        </td>

                    </table>

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-primary"><fmt:message key="add.item.form.submit"/></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</form>



<%--
<c:if test="${not empty wrongRangeData}">
    <div class="text-center">
        <p class="text-danger">
                <ctg:validate input="${wrongRangeData}"/>
                <fmt:message key="validation.range.message"/>
    </div>
</c:if>--%>
<div class="container-fluid">
    <div class="col-md-6 col-md-offset-6">

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

                <%--     <td align="center" style="border-color: #dae5ff"><fmt:message key="table.item.description"/></td> --%>
            </tr>

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
            </tr>
        </table>
    </div>
    </div>

<h2><c:out value="${message}"/></h2>
<a href="/controller?action=show_admin_page" class="btn btn-default"><fmt:message key="continue"/></a>
<br/>
<br/>

</body>
</html>


