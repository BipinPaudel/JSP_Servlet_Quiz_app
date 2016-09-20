package services.user;

import domains.user.User;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bips on 8/17/16.
 */
public class UserService {

    public User getUser(String username, String password) {
        User user = null;
        String query = "Select * from user_info where username=? and password = ?";
        PreparedStatement pst = new DatabaseConnection().getPreparedStatement(query);
        try {
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getUserList() {
        User user = null;
        List<User> userList = new ArrayList<>();
        String query = "Select * from user_info";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public int deleteUser(int id){
        String query="delete from user_info where id=?";
        PreparedStatement pst = new DatabaseConnection().getPreparedStatement(query);
        try{
            pst.setInt(1,id);
            pst.execute();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int addUser(String username,String password,String role){
        String query="Insert into user_info (username,password,role) values (? , ?,?)";
        PreparedStatement pst=new DatabaseConnection().getPreparedStatement(query);
        try{
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setString(3,role);
            pst.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public User getSingleUser(int id){
        User user=null;
        String query="Select * from user_info where id =? ";
        PreparedStatement pst=new DatabaseConnection().getPreparedStatement(query);
        try{
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    public int editUser(String username,String password,int id,String role){
        String query="Update user_info set username=?, password=? , role= ? where id=?";
        PreparedStatement pst= new DatabaseConnection().getPreparedStatement(query);
        try{
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setString(3,role);
            pst.setInt(4,id);
            pst.execute();
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return 0;
    }



}
