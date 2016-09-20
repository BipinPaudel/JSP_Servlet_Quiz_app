<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 9/7/16
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <title>Title</title>
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div id="templatemo_wrapper_outter">

<div id="templatemo_wrapper_inner">

<div id="templatemo_header">
    This is Header
</div>
<!-- end of templatemo_header -->

    <jsp:include page="../includes/header.jsp"></jsp:include>
<!-- end of templatemo_menu -->

<div id="templatemo_content_wrapper">


<div id="templatemo_content">

<div class="content_section">

    <h2>Add User</h2>
</div>

<c:if test="${singleUser!=null}">
    <div id="loginDiv">
        <form method="post" action="userEdit">
            <input type="hidden" name="page" value="userEdit"/>
            <table>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="username" value="${singleUser.username}"></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" value="${singleUser.password}">
                    <td>
                </tr>
                <tr>
                    <td>Role: </td> <td> <select name="role">
                    <option value="ROLE_ADMIN">Admin</option>
                    <option value="ROLE_USER"> USER </option>
                </select> </td>
                </tr>
                        <input type="hidden" name="id" value="${singleUser.id}">
                <tr>

                    <td colspan="2" align="right"><input type="submit" value="Edit User"></td>
                </tr>
            </table>
        </form>
    </div>
</c:if>

<c:if test="${singleUser==null}">
    <div id="loginDiv">
        <form method="post" action="userAdd">
            <input type="hidden" name="page" value="userAdd">
                <table>
                    <tr>
                        <td>User Name:</td><td><input type="text" name="username"></td>
                    </tr>

                    <tr>
                        <td>Password:</td><td><input type="password" name="password"><td>
                    </tr>

                    <tr>
                        <%--<td>Role:</td><td><input type="password" name="password"><td>--%>
                        <td>Role: </td> <td> <select name="role">
                            <option value="ROLE_ADMIN">Admin</option>
                            <option value="ROLE_USER"> USER </option>
                        </select> </td>
                    </tr>

                    <tr>
                        <td colspan="2" align="right"><input type="Submit" value="Add User"></td>
                    </tr>
                </table>
        </form>
    </div>
</c:if>

    </div>

    <div class="cleaner"></div>

    </div> <!-- end of templatemo_content_wrapper -->

    <div id="templatemo_footer">

    This is Footer
    </div><!-- end of footer -->

    </div> <!-- end of templatemo_wrapper_inner -->

    </div> <!-- end of templatemo_wrapper_outter -->


    </body>
    </html>
