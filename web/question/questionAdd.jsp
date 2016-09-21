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

    <title>Add Question</title>
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
        <div id="test">
            <input id="ans" type="radio" name="correct" value="1"> Answer1
        </div>
        <div id="templatemo_content_wrapper">


            <div id="templatemo_content">

                <div class="content_section">

                    <h2>Add Question</h2>
                </div>

                <c:if test="${question!=null}">
                    <div id="loginDiv">
                        <form method="post" action="questionEdit" name="editForm">
                            <input type="hidden" name="page" value="editQuestion">
                            <table>
                                <input type="hidden" name="id" value="${question.id}">
                                <tr>
                                    <td>Title</td>
                                    <td><input type="text" name="title" value="${question.title}"></td>
                                </tr>

                                <tr>
                                    <td>Category</td>
                                    <td><input type="text" name="category" value="${question.category}"></td>
                                </tr>


                                <tr>
                                    <td>Answer1</td>
                                    <td><input type="text" name="answer1" value="${question.answer1}"></td>
                                </tr>


                                <tr>
                                    <td>Answer2</td>
                                    <td><input type="text" name="answer2" value="${question.answer2}"></td>
                                </tr>


                                <tr>
                                    <td>Answer3</td>
                                    <td><input type="text" name="answer3" value="${question.answer3}"></td>
                                </tr>


                                <tr>
                                    <td>Answer4</td>
                                    <td><input type="text" name="answer4" value="${question.answer4}"></td>
                                </tr>


                                <tr>
                                    <td>Correct</td>
                                    <td>
                                        <input id="answer1" type="radio" name="correct" value="1"> Answer1
                                        <input id="answer2" type="radio" name="correct" value="2"> Answer2
                                        <input id="answer3" type="radio" name="correct" value="3"> Answer3
                                        <input id="answer4" type="radio" name="correct" value="4"> Answer4
                                    <td>
                                </tr>


                                <tr>
                                    <td colspan="2" align="right"><input type="Submit" value="Edit Question"></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </c:if>

                <c:if test="${question==null}">
                    <div id="loginDiv">
                        <form method="post" action="questionAdd">
                            <input type="hidden" name="page" value="questionAdd">
                            <table>
                                <tr>
                                    <td>Title</td>
                                    <td><input type="text" name="title"></td>
                                </tr>

                                <tr>
                                    <td>Category</td>
                                    <td><input type="text" name="category"></td>
                                </tr>


                                <tr>
                                    <td>Answer1</td>
                                    <td><input type="text" name="answer1"></td>
                                </tr>


                                <tr>
                                    <td>Answer2</td>
                                    <td><input type="text" name="answer2"></td>
                                </tr>


                                <tr>
                                    <td>Answer3</td>
                                    <td><input type="text" name="answer3"></td>
                                </tr>


                                <tr>
                                    <td>Answer4</td>
                                    <td><input type="text" name="answer4"></td>
                                </tr>


                                <tr>
                                    <td>Correct</td>
                                    <td><input type="radio" name="correct" value="1" checked> Answer1
                                        <input type="radio" name="correct" value="2"> Answer2
                                        <input type="radio" name="correct" value="3"> Answer3
                                        <input type="radio" name="correct" value="4"> Answer4
                                    <td>
                                </tr>


                                <tr>
                                    <td colspan="2" align="right"><input type="Submit" value="Add Question"></td>
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
<c:if test="${correctIndex!=null}">
    <script type="text/javascript">
        var corr =${correctIndex};
        if (corr == 1) {
            document.getElementById("answer1").checked = true;
        }
        else if (corr == 2) {
            document.getElementById("answer2").checked = true;
        }
        else if (corr == 3) {
            document.getElementById("answer3").checked = true;
        }
        else if (corr == 4) {
            document.getElementById("answer4").checked = true;
        }
    </script>
</c:if>

</body>
</html>
