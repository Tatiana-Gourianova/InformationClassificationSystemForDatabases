<%--@elvariable id="item" type="Item"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>
<html>
<head>
    <title><fmt:message key="title.add.item.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="../include/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <form action="/controller" method="post" class="form-horizontal">
                <input type="hidden" name="action" value="update_item">
                <table class="table table-condensed table-bordered">
                    <tr>
                        <td align="center" style="border-color: #dae5ff"><fmt:message key="blank"/></td>
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

                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                            <input type="hidden" id="itemId" name="itemId" class="form-control"
                                   value=
                            ${item.id}>
                        </td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff" >
                            <input type="textarea" id="itemName" name="title" class="form-control" style="width:400px"
                                   value=${item.name}>
                        </td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                            <input type="text" id="itemThickness" name="thickness" class="form-control"
                                   value=${item.thickness}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                        <input type="text" id="itemDensity" name="density" class="form-control"
                               value=${item.density}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                        <input type="text" id="itemSi63" name="si63" class="form-control"
                               value=${item.si63}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                        <input type="text" id="itemSi125" name="si125" class="form-control"
                               value=${item.si125}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                        <input type="text" id="itemSi250" name="si250" class="form-control"
                               value=${item.si250}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                            <input type="text" id="itemSi500" name="si500" class="form-control"
                                   value=${item.si500}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                        <input type="text" id="itemSi1000" name="si1000" class="form-control"
                               value=${item.si1000}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                        <input type="text" id="itemSi2000" name="si2000" class="form-control"
                               value=${item.si2000}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                        <input type="text" id="itemSi4000" name="si4000" class="form-control"
                               value=${item.si4000}></td>
                        <td align="center" style="vertical-align: middle; border-color: #dae5ff">
                        <input type="text" id="itemSi8000" name="si8000" class="form-control"
                               value=${item.si8000}></td>
                    </tr>
                </table>
            </form>

        <a href="../index.jsp" class="btn btn-default"><fmt:message key="continue"/></a>

    <%@ include file="../include/footer.jsp" %>
        </div>
    </div>
</div>

</body>
</html>




