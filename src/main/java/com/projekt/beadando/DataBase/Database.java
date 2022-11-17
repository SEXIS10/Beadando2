package com.projekt.beadando.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    public static String dbAddress = "jdbc:mysql://localhost:3306/";
    public static String userPass  = "?user=root&password=";
    public static String dbName = "projekt";
    public static String userName = "root";
    public static String password = "";

    private Statement statement;
    private Connection con;

    public void createDatabase()
    {
        try
        {
            Connection con;
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + userPass);
            Statement s = con.createStatement();
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void createUsersTable()
    {
        String myTableName = "CREATE TABLE Users ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "uname VARCHAR(236),"
                + "userName VARCHAR(236),"
                + "password VARCHAR(236),"
                + "email VARCHAR(236),"
                + "birthDate DATE,"
                + "birthPlace VARCHAR(36),"
                + "sex VARCHAR(10),"
                + "isActive INT(1),"
                + "isMom INT(1),"
                + "girlName VARCHAR(236),"
                + "nationality VARCHAR(36))";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
    public void createMemberShipTable()
    {
        String myTableName = "CREATE TABLE MemberShips ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "mnumber INT(8),"
                + "userID INT(64),"
                + "FOREIGN KEY (userID) REFERENCES users(id) ,"
                + "expiry DATE)";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
}
