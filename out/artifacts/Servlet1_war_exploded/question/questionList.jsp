<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 9/6/16
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>List of Questions</title>
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${ok!=null}">
    <script type="text/javascript">
        alert(ok);
    </script>
</c:if>
<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">

        <div id="templatemo_header">
            This is Header
        </div> <!-- end of templatemo_header -->

        <jsp:include page="../includes/header.jsp"></jsp:include>

        <div id="templatemo_content_wrapper">

            <div id="templatemo_sidebar_wrapper">

                <div id="templatemo_sidebar_top"></div>
                <div id="templatemo_sidebar">

                    <h2>Our Services</h2>

                    <ul class="categories_list">
                        <li><a href="#">Test1</a></li>
                        <li><a href="#">Test2</a></li>
                    </ul>

                    <div class="cleaner_h30"></div>

                </div>
                <div id="templatemo_sidebar_bottom"></div>

            </div>



            <div id="templatemo_content">

                <div class="content_section">

                    <h2>Question List</h2>
                </div>
            <h2><a href="/addQuestionPage?page=addQuestionPage">Add New Question</a></h2>
                <table cellpadding="10">
                    <tr>
                        <th>Id</th>
                        <th>Question</th>

                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${questionList}" var="question">
                        <tr>
                            <td>${question.id}</td>
                            <td><a href="viewQuestion?page=viewQuestion&id=${question.id}"> ${question.title} </a></td>

                            <td><a href="questionEditPage?page=editQuestionPage&id=${question.id}"><img src="../images/edit.jpg" height="30px" width="40px" alt="Edit"></a></td>
                            <td><a href="deleteQuestion?page=questionDelete&id=${question.id}"><img src="../images/delete.jpg" height="30px" width="40px" alt="Delete"></a></td>
                        </tr>

                    </c:forEach>
                </table>

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
