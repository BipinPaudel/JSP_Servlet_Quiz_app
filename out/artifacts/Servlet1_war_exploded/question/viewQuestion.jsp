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
    <title>Title</title>
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">

</head>
<body>

<c:if test="${ok!=null}">
    <script type="text/javascript">
        var num=${ok};
        if ( num== 1){
            alert("Correct answer");
        }
        else if(num ==0){
            alert("Incorrect answer");
        }
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
                </div>
                <h1>${singleQuestion.title}</h1> <br>

                <ul>
                    <li><h3><a href="playQuiz?page=playQuiz&id=${singleQuestion.id}&answer=${singleQuestion.answer1}"> ${singleQuestion.answer1}</a></h3></li>
                    <li><h3><a href="playQuiz?page=playQuiz&id=${singleQuestion.id}&answer=${singleQuestion.answer2}"> ${singleQuestion.answer2}</a></h3></li>
                    <li><h3><a href="playQuiz?page=playQuiz&id=${singleQuestion.id}&answer=${singleQuestion.answer3}"> ${singleQuestion.answer3}</a></h3></li>
                    <li><h3><a href="playQuiz?page=playQuiz&id=${singleQuestion.id}&answer=${singleQuestion.answer4}"> ${singleQuestion.answer4}</a></h3></li>
                </ul>

                <h2> Category :  ${singleQuestion.category}</h2>


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
