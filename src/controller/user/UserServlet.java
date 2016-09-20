package controller.user;

import domains.user.User;
import org.omg.CORBA.Request;
import services.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by bips on 8/17/16.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String page = request.getParameter("page");
        //checkSession(request,response,page);
        if(page==null){
            page="DDD";
        }
        if(!page.equalsIgnoreCase("login")){
            System.out.println("We are here");
            HttpSession session=request.getSession(false);
            User user= (User) session.getAttribute("user");
            System.out.println(user);
            if(user==null){
                System.out.println("user is null");
                response.sendRedirect("index.jsp");
                return;

            }

        }



        if (page.equalsIgnoreCase("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new UserService().getUser(username, password);
            if (user != null) {
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);
                request.setAttribute("message", "Login success");
                request.getRequestDispatcher("questionHome?page=questionHome").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

        if(page.equalsIgnoreCase("logout")){
            HttpSession session= request.getSession(false);
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

             if (page.equalsIgnoreCase("home")){
                request.getRequestDispatcher("/user/questionHome.jsp").forward(request,response);
            }

         if (page.equalsIgnoreCase("userList")) {
            List<User> wholeList = new UserService().getUserList();
            System.out.println("inside here -----------");
            System.out.println(wholeList);
            request.setAttribute("userList", wholeList);
            request.getRequestDispatcher("user/userList.jsp").forward(request, response);
        }

         if (page.equalsIgnoreCase("userDelete")) {
            String id = request.getParameter("id");
            System.out.println(Integer.valueOf(id));
            int result = new UserService().deleteUser(Integer.valueOf(id));
            if (result==1){
                request.setAttribute("userList", new UserService().getUserList());
                request.getRequestDispatcher("/user/userList.jsp").forward(request, response);
            }
            else if (result ==0){
                request.setAttribute("userList", new UserService().getUserList());
                request.getRequestDispatcher("/user/userList.jsp").forward(request, response);

            }


        }



         if(page.equalsIgnoreCase("userAdd")){

            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String role=request.getParameter("role");
            System.out.println(username + "  " + password);
            int result= new UserService().addUser(username,password,role);
            if (result==1){
                System.out.println("User successfully added----------");
            }
            else{
                System.out.println("User not added successfully-------");
            }

            request.getRequestDispatcher("/userList?page=userList").forward(request,response);
        }

         if(page.equalsIgnoreCase("addUserPage")){
            request.getRequestDispatcher("/user/userAdd.jsp").forward(request,response);
        }

         if(page.equalsIgnoreCase("userEdit")){

            int id=Integer.valueOf(request.getParameter("id"));
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String role=request.getParameter("role");
            System.out.println("hero " + id + username + password);
            int result=new UserService().editUser(username,password,id,role);
            if (result==1){
                System.out.println("User successfully edited");
            }
            else{
                System.out.println("User not successfully edited");
            }

            request.getRequestDispatcher("/userList?page=userList").forward(request,response);
        }


         if (page.equalsIgnoreCase("editUserPage")){

            int id= Integer.valueOf(request.getParameter("id"));
            User user= new UserService().getSingleUser(id);
            if(user!=null){
                request.setAttribute("singleUser",user);
                request.getRequestDispatcher("user/userAdd.jsp").forward(request,response);
            }

        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }


    private void checkSession(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException{
        if(page==null){
            page="DDD";
        }
        if(!page.equalsIgnoreCase("login")){
            System.out.println("We are here");
            HttpSession session=request.getSession(false);
            User user= (User) session.getAttribute("user");
            System.out.println(user);
            if(user==null){
                System.out.println("user is null");
                response.sendRedirect("index.jsp");
                return;

            }

        }

    }
}
