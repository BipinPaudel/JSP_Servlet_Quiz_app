package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by bips on 8/17/16.
 */
public class DatabaseConnection {

    String url="jdbc:mysql://localhost:3306/demo";

    String username="root";
    String password="maiden";

    Connection connection = null;

    public DatabaseConnection(){
        try{
            try {

                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String query){
        PreparedStatement pstm=null;

        try {
            pstm=connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstm;
    }
}
