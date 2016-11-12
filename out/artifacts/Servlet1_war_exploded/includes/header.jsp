<%@ page import="domains.user.User" %><%
    User user = (User) session.getAttribute("user");
    if(user==null){
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
%>
<div id="templatemo_menu">

    <ul>
        <li><a href="questionHome?page=questionHome" class="current">Home</a></li>
        <li><a href="userList?page=userList">User</a></li>
        <li><a href="questionList?page=questionList"> Question </a> </li>
        <li><a href="randomQuestion?page=questionAmountPage"> Play Quiz </a></li>

        <li><a href="logout?page=logout" >Logout</a></li>
    </ul>

</div> <!-- end of templatemo_menu -->