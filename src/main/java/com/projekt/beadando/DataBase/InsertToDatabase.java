package com.projekt.beadando.DataBase;

import com.projekt.beadando.Classes.MemberShip;
import com.projekt.beadando.Classes.User;
import com.projekt.beadando.Enums.Nationality;
import com.projekt.beadando.Enums.Sex;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;

public class InsertToDatabase
{
    public static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    public static String dbAddress = "jdbc:mysql://localhost:3306/";
    public static String userPass  = "?user=root&password=";
    public static String dbName = "projekt";
    public static String userName = "root";
    public static String password = "";

    private Statement statement;
    private Connection con;
    public void insertIntoUserTable(@NotNull User user) throws SQLException {
        String Uname = user.getName();
        String UserName =user.getUsername();
        String Password = user.getPassword();
        String Email = String.valueOf(user.getEmail());
        Date BirthDate= user.getBirthdate();
        String BirthPlace=user.getBirthplace();
        Sex sex = user.getSex();
        boolean isActive=user.isActive();
        Nationality nationality=user.getNationality();
        Statement st;
        int active= 0;
        if(isActive) active = 1;
        Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
        ArrayList<User> users = GetDataFromDatabase.getDataFromUserTable();
        ArrayList<String> userNamesTaken = new ArrayList<>();
        for (User user0 : users)
        {
            userNamesTaken.add(user0.getUsername());
        }
        if(!userNamesTaken.contains(UserName))
        {
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into Users("
                        + "uname,"
                        + "userName,"
                        + "password,"
                        + "email,"
                        + "birthDate,"
                        + "birthPlace,"
                        + "sex,"
                        + "isActive,"
                        + "nationality)"
                        + " values('"
                        +Uname+"','"
                        +UserName+"','"
                        +Password+"','"
                        +Email+"','"
                        +BirthDate+"','"
                        +BirthPlace+"','"
                        +sex+"','"
                        +active+"','"
                        +nationality+"') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else {
            System.out.println("UserName is Taken!");
        }
    }
    public void insertIntoMemberShipTable(@NotNull MemberShip memberShip) throws SQLException {
        int Mnumber =memberShip.getMnumber();
        int userid = memberShip.getUserid();
        Date expiriy = memberShip.getExpiriy();
        Statement st;
        Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
        ArrayList<MemberShip> memberShips = GetDataFromDatabase.getDataFromMemberShipTable();
        ArrayList<Integer> membershipsTaken = new ArrayList<>();
        for (MemberShip membership : memberShips)
        {
            membershipsTaken.add(membership.getMnumber());
        }
        if(!membershipsTaken.contains(memberShip.getMnumber()))
        {
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into MemberShips("
                        + "mnumber,"
                        + "userID,"
                        + "expiry)"
                        + " values('"
                        +Mnumber+"','"
                        +userid+"','"
                        +expiriy+"')";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else {
            System.out.println("Membership Number is Taken!");
        }
    }
}
