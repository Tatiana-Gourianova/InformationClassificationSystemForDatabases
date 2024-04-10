<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="navbar navbar-default navbar-static-top" style="background: #20B2AA">
    <div class="container-fluid">
        <ul class="nav navbar-nav">

            <%--user--%>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="/controller?action=show_admin_page"><fmt:message
                        key="nav.user"/>
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/controller?action=show_all_users"><fmt:message key="nav.user.show.all"/></a></li>
                    <li><a href="/controller?action=show_user_change_role_page"><fmt:message key="nav.user.change"/></a>
                    </li>
                    <li class="divider"></li>

                    <%--
                                        <li><a href="//controller?action=show_user_change_role_page"><fmt:message key="nav.user.change"/></a></li>
                                        <li class="divider"></li>--%>

                    <li><a href="#"><fmt:message key="search.form.user"/></a>

                        <form action="/controller" method="post" class="form-horizontal">
                            <input type="hidden" name="action" value="find_user">
                            <div class="form-group">
                                <label for="user" class="col-sm-offset-1 col-sm-2 control-label"><fmt:message
                                        key="search.form.user.id"/></label>
                                <div class="col-sm-8">
                                    <input type="text" id="user" name="userId" class="form-control"
                                           placeholder="<fmt:message key="search.form.user.id.placeholder"/>"
                                           maxlength="3" required pattern="[0-9]{1,3}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button type="submit" class="btn btn-primary"><fmt:message
                                            key="search.form.submit"/></button>
                                </div>
                            </div>
                        </form>
                    </li>
                    <li class="divider"></li>
                    <li><a href="/controller?action=show_user_change_role_page"><fmt:message
                            key="search.form.user"/></a>

                    <%--    <form action="/controller" method="post" class="form-horizontal">
                            <input type="hidden" name="action" value="find_user">

                            <div class="form-group">

                                <div class="col-sm-12">
                                    <select class="form-control" id="userForm" name="userId">
                                        <c:forEach items="${usersList}" var="user">
                                            <option value="${user.id}"><fmt:message key="update.user.id"/> ${user.id},
                                                <fmt:message key="update.user.role"/> ${user.roleId}, <fmt:message
                                                        key="update.user.first.name"/> ${user.firstName}, <fmt:message
                                                        key="update.user.login"/> ${user.login}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="col-sm-offset-3 col-sm-8">
                                        <button type="submit" class="btn btn-primary"><fmt:message
                                                key="search.form.submit"/></button>
                                    </div>

                                </div>
                            </div>

                        </form>--%>
                    </li>
                </ul>
            </li>

            <%--role--%>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message
                        key="nav.role"/>
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/controller?action=show_all_roles"><fmt:message key="nav.role.show.all"/></a>
                    <li><a href="../includeAdmin/role_add.jsp"><fmt:message key="nav.role.add"/></a></li>
                    <li><a href="../includeAdmin/role_delete.jsp"><fmt:message key="nav.role.delete"/></a></li>
                </ul>
            </li>
              <%--  <nav class="navbar navbar-default navbar-static-top" style="background: #20B2AA">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">

                            <%--walls--%>
                <%--    <li class="dropdown">
                           <a class="dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message
                                   key="nav.heavy-weight wall"/>
                   <span class="caret"></span> </a>
        <ul class="dropdown-menu">
            <form action="/controller" method="post" class="form-horizontal">
                <input type="hidden" name="action" value="show_add_item_page">

                <div class="form-group">

                    <div class="col-sm-12">
                        <select class="form-control" id="constructionForm" name="constructionId">
                            <c:forEach items="${constructionsList}" var="construction">
                                <option value="${construction.id}"><fmt:message key="update.user.id"/> ${construction.id},
                                    <fmt:message key="update.user.role"/> ${construction.id}, <fmt:message
                                            key="update.user.first.name"/> ${construction.title},

                                </option>
                            </c:forEach>
                        </select>
                        <div class="col-sm-offset-3 col-sm-8">
                            <button type="submit" class="btn btn-primary"><fmt:message
                                    key="search.form.submit"/></button>
                        </div>

                    </div>
                </div>

            </form>
            <li>   <label for="item" class="col-sm-3 control-label"><fmt:message key="delete.item.form"/></label>
                        <div class="col-sm-9">
                            <select class="form-control" id="item" name="itemId">
                                <c:forEach items="${consructionsList}" var="item">
                                    <option value="${consructions.id}">${consructions.id}</option>
                                </c:forEach>
                            </select>
                        </div>

                    <form action="/controller" method="post">
                        <button type="submit" class="btn btn-link" id="add" name="action" value="show_add_item_page" >
                            +
                        </button>
                        <input type="text" id="heavy-weight-wall" value="Heavy-weight wall" >
                        <button type="submit" class="btn btn-link" id="delete" name="action" value="show_delete_item_page" >
                            -
                        </button>
                    </form>
            </li>
        </ul>
    </li>
</ul>
</div>
   <%--Item--%>
                       <li class="dropdown">
                          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message
                                  key="nav.item"/>
                              <span class="caret"></span></a>
                          <ul class="dropdown-menu">
                              <li><a href="/controller?action=show_all_items"><fmt:message key="nav.item.show.all"/></a>

                              <li><a href="/controller?action=show_delete_item_page"><fmt:message key="nav.item.delete"/></a>
                              </li>

                              <li><a href="/controller?action=show_add_item_page"><fmt:message key="nav.item.add"/></a></li>
                              <li class="divider"></li>
                              <li><a href="#"><fmt:message key="search.form.user"/></a>

                                  <form action="/controller" method="post" class="form-horizontal">
                                      <input type="hidden" name="action" value="edit_item">
                                      <div class="form-group">
                                          <label for="user" class="col-sm-offset-1 col-sm-2 control-label"><fmt:message
                                                  key="search.form.item.id"/></label>
                                          <div class="col-sm-8">
                                              <input type="text" id="item" name="itemId" class="form-control"
                                                     placeholder="<fmt:message key="search.form.item.id.placeholder"/>"
                                                     maxlength="3" required pattern="[0-9]{1,3}">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <div class="col-sm-offset-3 col-sm-8">
                                              <button type="submit" class="btn btn-primary"><fmt:message
                                                      key="search.form.submit"/></button>
                                          </div>
                                      </div>
                                  </form>
                              </li>
                              <li class="divider"></li>
                              <li><a href="#"><fmt:message key="search.form.item"/></a>
                                  <form action="/controller" method="post" class="form-horizontal">
                                      <input type="hidden" name="action" value="edit_item">
                                      <div class="form-group">
                                          <label for="itemForm" class="col-sm-offset-1 col-sm-2 control-label"><fmt:message
                                                  key="nav.item.change"/></label>
                                          <div class="col-sm-8">
                                              <select class="form-control" id="itemForm" name="itemId">
                                                  <c:forEach items="${itemsList}" var="item">
                                                      <option value="${item.id}"><fmt:message
                                                              key="update.item.id"/> ${item.id},
                                                          <fmt:message key="update.item.title"/> ${item.name}, <fmt:message
                                                                  key="update.item.model"/> ${item.model}

                                                      </option>
                                                  </c:forEach>
                                              </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <div class="col-sm-offset-3 col-sm-8">
                                              <button type="submit" class="btn btn-primary"><fmt:message
                                                      key="search.form.change"/></button>
                                          </div>
                                      </div>
                                  </form>
                              </li>
                          </ul>
                      </li>

                <%--construction--%>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message
                            key="nav.type"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/controller?action=show_all_constructions"><fmt:message key="nav.type.show.all"/></a>
                        </li>
                        <li><a href="../includeAdmin/construction_add.jsp"><fmt:message key="nav.type.add"/></a></li>
                        <li><a href="../includeAdmin/construction_delete.jsp"><fmt:message key="nav.type.delete"/></a></li>

                    </ul>
                </li>
                <td colspan="3">

                      <%--type--%>
        <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message
                        key="nav.type"/>
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/controller?action=show_all_constructs"><fmt:message key="nav.type.show.all"/></a>
                    </li>
                    <li><a href="../includeAdmin/construct_add.jsp"><fmt:message key="nav.type.add"/></a></li>
                    <li><a href="../includeAdmin/construct_delete.jsp"><fmt:message key="nav.type.delete"/></a></li>
                    <%--    <li><a href="/controller?action=get_type_data"><fmt:message key="nav.type.edit"/></a>
                        </li> --%>

                                </ul>
                            </li>
                            <td colspan="3">
                                <%--material--%>
                     <li class="dropdown">
                         <a class="dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message key="nav.sensor_unit"/>
                             <span class="caret"></span></a>
                         <ul class="dropdown-menu">
                             <li><a href="/controller?action=show_all_materials"><fmt:message
                                     key="nav.sensor_unit.show.all"/></a>
                             </li>
                             <li><a href="../includeAdmin/material_delete.jsp"><fmt:message key="nav.unit.delete"/></a></li>
                             <li><a href="../includeAdmin/material_add.jsp"><fmt:message key="nav.sensor_unit.add"/></a>
                             </li>
                         </ul>
                     </li>
                 </ul>

                 <%--exit/admin's page--%>

            <c:if test="${not empty user and user.roleId == 6}">
            <form action="/controller" class="navbar-form navbar-right">
                <fmt:message key="nav.welcome"/><ctg:info user="${user}"/>
                <input type="hidden" name="action" value="logout">
                <button type="submit" class="btn btn-default"><fmt:message key="nav.signout"/></button>
            </form>
            <form action="/controller" method="post" class="navbar-form navbar-right">
                <input type="hidden" name="action" value="show_admin_page">
                <button type="submit" class="btn btn-default"><fmt:message key="nav.admin"/></button>
            </form>
            </c:if>
    </div>
</nav>


