package com.projekt.beadando.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteFromDataBase
{
    public static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    public static String dbAddress = "jdbc:mysql://localhost:3306/";
    public String userPass  = "?user=root&password=";
    public static String dbName = "projekt";
    public static String userName = "root";
    public static String password = "";
    public static void deleteUser(int userid)
    {

        try
        {
            // create the mysql database connection
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(dbAddress+dbName, userName, password);

            // create the mysql delete statement.
            // i'm deleting the row where the id is "3", which corresponds to my
            // "Barney Rubble" record.
            String query = "Delete from Users where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, userid);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }
    public static void deleteMemberShip(int membershipid)
    {

        try
        {
            // create the mysql database connection
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(dbAddress+dbName, userName, password);

            // create the mysql delete statement.
            // i'm deleting the row where the id is "3", which corresponds to my
            // "Barney Rubble" record.
            String query = "Delete from MemberShips where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, membershipid);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }
}
