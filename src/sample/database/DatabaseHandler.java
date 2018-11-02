package sample.database;
import sample.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class DatabaseHandler extends Configs{
Connection dbConnection;

public Connection getDbConnection()
        throws ClassNotFoundException, SQLException{
    String connectionString = "jdbc:mysql://" + dbHost + ":"
            + dbPort + "/" + dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     Class.forName("com.mysql.cj.jdbc.Driver");
     dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
     return dbConnection;

}
    public void signUpUser(User user){
String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
        Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME +
        "," + Const.USER_USERNAME + "," + Const.USER_PASSWORD +
        "," + Const.GENDER + ")" + "VALUES(?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLasttName());
            prSt.setString(3, user.getUasername());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getGender());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
    ResultSet resSet = null;


    String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + " =? AND " + Const.USER_PASSWORD + " =?";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUasername());
            prSt.setString(2, user.getPassword());

            resSet =  prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
