package controller.question;

import domains.question.Question;
import domains.user.User;
import services.question.QuestionService;
import services.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by bips on 9/19/16.
 */
@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd;
        String page = request.getParameter("page");
        if (page == null) {
            page = "DDD";
        }
        if (!page.equalsIgnoreCase("login")) {
            System.out.println("We are here");
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            System.out.println(user);
            if (user == null) {
                System.out.println("user is null");
                response.sendRedirect("index.jsp");
                return;

            }

        }

        if (page.equalsIgnoreCase("questionList")) {

            List<Question> wholeQuestion = new QuestionService().getQuestionList();
            String ok = request.getParameter("ok");
            System.out.println("this is ok " + ok);
            if (ok != null) {
                request.setAttribute("ok", ok);
            }
            request.setAttribute("questionList", wholeQuestion);

            rd = request.getRequestDispatcher("/question/questionList.jsp");
            rd.forward(request, response);
        } else if (page.equalsIgnoreCase("questionHome")) {
            List<Question> wholeQuestion = new QuestionService().getQuestionList();
            request.setAttribute("questionList", wholeQuestion);

            rd = request.getRequestDispatcher("/question/questionHome.jsp");
            rd.forward(request, response);
        } else if (page.equalsIgnoreCase("addQuestionPage")) {
            rd = request.getRequestDispatcher("/question/questionAdd.jsp");
            rd.forward(request, response);
        } else if (page.equalsIgnoreCase("playQuiz")) {

            int id = Integer.valueOf(request.getParameter("id"));
            String userAnswer = request.getParameter("answer");
            String correctAnswer = new QuestionService().getSingleQuestion(id).getCorrect();
            PrintWriter out = response.getWriter();
            int ok;

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("correct answer");
                ok = 1;

            } else {
                System.out.println("incorrect asnwer");
                ok = 0;

            }
            System.out.println("ok value here is " + ok);
            request.setAttribute("ok", ok);
            request.setAttribute("id", id);
            rd = request.getRequestDispatcher("viewQuestion?page=viewQuestion");
//            rd=request.getRequestDispatcher("questionList?page=questionList");

            rd.forward(request, response);

        } else if (page.equalsIgnoreCase("viewQuestion")) {
            int id = Integer.valueOf(request.getParameter("id"));
            Question singleQuestion = new QuestionService().getSingleQuestion(id);
            request.setAttribute("singleQuestion", singleQuestion);
            rd = request.getRequestDispatcher("/question/viewQuestion.jsp");
            rd.forward(request, response);
        } else if (page.equalsIgnoreCase("questionDelete")) {
            int id = Integer.valueOf(request.getParameter("id"));
            int result = new QuestionService().deleteQuestion(id);
            if (result == 1) {
                System.out.println("Question deleted successfully");
            } else if (result == 0) {
                System.out.println("Question not deleted successfully");
            }

            rd = request.getRequestDispatcher("questionList?page=questionList");
            rd.forward(request, response);
        } else if (page.equalsIgnoreCase("editQuestionPage")) {
            int id = Integer.valueOf(request.getParameter("id"));
            Question question = new QuestionService().getSingleQuestion(id);

            String correctAnswer = question.getCorrect();
            int correctIndex = 0;
            if (correctAnswer.equals(question.getAnswer1())) {
                correctIndex = 1;
            } else if (correctAnswer.equals(question.getAnswer2())) {
                correctIndex = 2;
            }
            if (correctAnswer.equals(question.getAnswer3())) {
                correctIndex = 3;
            }
            if (correctAnswer.equals(question.getAnswer4())) {
                correctIndex = 4;
            }
            request.setAttribute("correctIndex", correctIndex);


            request.setAttribute("question", question);
            rd = request.getRequestDispatcher("/question/questionAdd.jsp");
            rd.forward(request, response);

        } else if (page.equalsIgnoreCase("editQuestion")) {
            int id = Integer.valueOf(request.getParameter("id"));//request.getParameter("id");
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String answer1 = request.getParameter("answer1");
            String answer2 = request.getParameter("answer2");
            String answer3 = request.getParameter("answer3");
            String answer4 = request.getParameter("answer4");
            String correct = request.getParameter("correct");
            if (title.equals("") || category.equals("") || answer1.equals("") || answer2.equals("") || answer3.equals("") ||
                    answer4.equals("") || correct.equals("")) {
                rd = request.getRequestDispatcher("questionList?page=questionList");
                rd.forward(request, response);
                return;
            }
            System.out.println("this is new title " + title);

            switch (correct) {
                case "1":
                    correct = answer1;
                    break;
                case "2":
                    correct = answer2;
                    break;
                case "3":
                    correct = answer3;
                    break;
                case "4":
                    correct = answer4;
                    break;
            }
            System.out.println(answer1 + " " + answer2 + " " + answer3 + " " + answer4);
            System.out.println("this is correct " + correct);
            int result = new QuestionService().editQuestion(id, title, category, answer1, answer2, answer3, answer4, correct);
            if (result == 1) {
                System.out.println("Question is edited successfully");
            } else if (result == 0) {
                System.out.println("Question is not edited ");
            }

            rd = request.getRequestDispatcher("questionList?page=questionList");
            rd.forward(request, response);
        } else if (page.equalsIgnoreCase("questionAdd")) {
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String answer1 = request.getParameter("answer1");
            String answer2 = request.getParameter("answer2");
            String answer3 = request.getParameter("answer3");
            String answer4 = request.getParameter("answer4");
            String correct = request.getParameter("correct");
            if (title.equals("") || category.equals("") || answer1.equals("") || answer2.equals("") || answer3.equals("") ||
                    answer4.equals("") || correct.equals("")) {
                rd = request.getRequestDispatcher("questionList?page=questionList");
                rd.forward(request, response);
                return;
            }
            switch (correct) {
                case "1":
                    correct = answer1;
                    break;
                case "2":
                    correct = answer2;
                    break;
                case "3":
                    correct = answer3;
                    break;
                case "4":
                    correct = answer4;
                    break;
            }

            int result = new QuestionService().addQuestion(title, category, answer1, answer2, answer3, answer4, correct);
            if (result == 1) {
                System.out.println("question added successfully");
            } else if (result == 0) {
                System.out.println("question added unsuccessfully");
            }

            rd = request.getRequestDispatcher("questionList?page=questionList");
            rd.forward(request, response);


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
