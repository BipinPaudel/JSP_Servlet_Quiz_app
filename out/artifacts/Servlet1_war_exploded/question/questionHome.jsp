<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 8/17/16
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>Question Home</title>
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

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

                    <h2>Play Quiz</h2>
                </div>

                <%--Here goes content--%>
                <%--<form method="post" action="playQuiz">--%>
                <%--<input type="hidden" name="page" value="playQuiz">--%>
                <%--<table cellspacing="2" cellpadding="10" border="2">--%>
                <%--<thead>--%>
                <%--<th>Questions</th>--%>
                <%--<th>Select one</th>--%>
                <%--</thead>--%>

                <%--<tbody>--%>
                <%--<c:forEach items="${questionList}" var="question">--%>
                <%--<tr>--%>
                <%--<td rowspan="4">${question.title}</td>--%>
                <%--<td><input type="radio" name="answer" value="1"> ${question.answer1}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td><input type="radio" name="answer" value="2"> ${question.answer2}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td><input type="radio" name="answer" value="1"> ${question.answer3}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td><input type="radio" name="answer" value="1"> ${question.answer4}</td>--%>
                <%--</tr>--%>

                <%--</c:forEach>--%>
                <%--<tr>--%>
                <%--<td colspan="2" align="right"><input type="submit" value="Submit answer"></td>--%>
                <%--</tr>--%>
                <%--</tbody>--%>
                <%--</table>--%>

                <%--</form>--%>
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
