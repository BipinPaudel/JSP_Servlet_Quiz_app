package services.group;

import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by bips on 11/12/16.
 */
public class GroupService {

    public ArrayList<Integer> getAllGroupId(){
        ArrayList<Integer> groupId=null;
        String query= "Select id from groups";
        PreparedStatement pstm=new DatabaseConnection().getPreparedStatement(query);

        try{
            ResultSet rs=pstm.executeQuery();
            groupId=new ArrayList<>();
            while(rs.next()){
                groupId.add(rs.getInt("id"));
            }
            return groupId;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return groupId;
    }

    public String groupNameFromId(int id){
        String groupName=new String();
        String query="Select title from groups where id= ?";
        PreparedStatement pstm=new DatabaseConnection().getPreparedStatement(query);
        try{
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                groupName=rs.getString("title");
            }
            return groupName;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return groupName;
    }


}
