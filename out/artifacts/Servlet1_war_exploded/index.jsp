<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 8/17/16
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>

  <div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">

      <div id="templatemo_header">
        This is Header
      </div> <!-- end of templatemo_header -->

      <div id="templatemo_menu">

        <ul>
          <li><a href="#" >Login</a></li>
        </ul>

      </div> <!-- end of templatemo_menu -->

      <div id="templatemo_content_wrapper">


        <div id="templatemo_content">

          <div class="content_section">

            <h2>Login Form:</h2>
          </div>


          <div id="loginDiv">
            <form method="post" action="login">
              <input type="hidden" name="page" value="login">
              <table>
                <tr>
                  <td>User Name:</td><td><input type="text" name="username"></td>
                </tr>

                <tr>
                  <td>Password:</td><td><input type="password" name="password"><td>
                </tr>

                <tr>
                  <td colspan="2" align="right"><input type="Submit" value="Login"></td>
                </tr>
              </table>
            </form>
          </div>





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
