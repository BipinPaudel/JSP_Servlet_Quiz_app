package services.question;

import domains.question.Question;
import utils.DatabaseConnection;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bips on 9/19/16.
 */
public class QuestionService {

    public List<Question> getQuestionList() {
        Question question = null;
        List<Question> questionList = new ArrayList<>();
        String query = "Select * from question";
        System.out.println("inside question service 1");
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setTitle(rs.getString("title"));
                question.setAnswer1(rs.getString("answer1"));
                question.setAnswer2(rs.getString("answer2"));
                question.setAnswer3(rs.getString("answer3"));
                question.setAnswer4(rs.getString("answer4"));
                question.setCorrect(rs.getString("correct"));
                question.setCategory(rs.getString("category"));
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }


    public int addQuestion(String title, String category, String answer1, String answer2, String answer3, String answer4,
                           String correct) {
        String query = "Insert into question (title,category,answer1,answer2,answer3,answer4,correct) values" +
                " (?, ?,?,?,?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setString(1, title);
            pstm.setString(2, category);
            pstm.setString(3, answer1);
            pstm.setString(4, answer2);
            pstm.setString(5, answer3);
            pstm.setString(6, answer4);
            pstm.setString(7, correct);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteQuestion(int id) {
        String query = "Delete from question where id =? ";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Question getSingleQuestion(int id) {
        Question question = null;

        String query = "Select * from question where id= ? ";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setTitle(rs.getString("title"));
                question.setCategory(rs.getString("category"));
                question.setAnswer1(rs.getString("answer1"));
                question.setAnswer2(rs.getString("answer2"));
                question.setAnswer3(rs.getString("answer3"));
                question.setAnswer4(rs.getString("answer4"));
                question.setCorrect(rs.getString("correct"));
                return question;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public Question getRandomQuestion(ArrayList<Integer> answeredList) {
        Question question = null;
        System.out.println(answeredList + "answeredlist");
        String inside = "";
        if (answeredList.size() > 0) {
            for (int i = 0; i < answeredList.size(); i++) {
                if (i == 0) {
                    inside += "" +"?";
                } else {
                    inside += "," + "?";
                }
            }
        }
        System.out.println("-----------------" + inside);
        String query = "Select * from question where id not in (" + inside + " ) order by rand() limit 1";
        System.out.println(query);

        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            int idx = 1;
            for (Integer a : answeredList) {
                if (answeredList.size() > 0) {
                    pstm.setInt(idx, a);
                    idx++;
                }
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setTitle(rs.getString("title"));
                question.setCategory(rs.getString("category"));
                question.setAnswer1(rs.getString("answer1"));
                question.setAnswer2(rs.getString("answer2"));
                question.setAnswer3(rs.getString("answer3"));
                question.setAnswer4(rs.getString("answer4"));
                question.setCorrect(rs.getString("correct"));
                return question;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public int editQuestion(int id, String title, String category, String answer1, String answer2, String answer3,
                            String answer4, String correct) {

        System.out.println("inside edit service " + id + " " + title + " " + answer1);
        String query = "Update question set title=? , answer1=?, answer2=?, answer3=?, answer4=?,correct=?,category=? where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, title);

            pstm.setString(2, answer1);
            pstm.setString(3, answer2);
            pstm.setString(4, answer3);
            pstm.setString(5, answer4);
            pstm.setString(6, correct);
            pstm.setString(7, category);
            pstm.setInt(8, id);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public ArrayList<Integer> getAnsweredQuestionId() {
        ArrayList<Integer> answeredQuestionIdList = null;
        String query = "Select question_id from group_answer";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            answeredQuestionIdList = new ArrayList<>();
            while (rs.next()) {
                answeredQuestionIdList.add(rs.getInt("question_id"));
            }
            return answeredQuestionIdList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answeredQuestionIdList;
    }

    public Integer getTotalQuestions() {
        Integer result = null;
        String query = "Select count(*) from group_answer";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
                System.out.println("-------------total quesiton" + result);
                return result;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Question getSingleQuestionForFirst(){
        Question question=null;
        String query="Select * from question order by rand() LIMIT 1";
        PreparedStatement pstm=new DatabaseConnection().getPreparedStatement(query);
        try{
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                question=new Question();
                question.setId(rs.getInt("id"));
                question.setTitle(rs.getString("title"));
                question.setCategory(rs.getString("category"));
                question.setAnswer1(rs.getString("answer1"));
                question.setAnswer2(rs.getString("answer2"));
                question.setAnswer3(rs.getString("answer3"));
                question.setAnswer4(rs.getString("answer4"));
                question.setCorrect(rs.getString("correct"));
                return question;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return question;
    }

    public int storeGroupAnswer(String answer,Integer question_id,Integer group_id){

        String query="Insert into group_answer set answer=?, question_id=? ,group_id=?";
        PreparedStatement pstm=new DatabaseConnection().getPreparedStatement(query);
        try{
            pstm.setString(1,answer);
            pstm.setInt(2,question_id);
            pstm.setInt(3,group_id);
            pstm.execute();
            return 1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }


}
