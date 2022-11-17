package com.projekt.beadando.DataBase;

import com.projekt.beadando.Classes.MemberShip;
import com.projekt.beadando.Classes.User;
import com.projekt.beadando.Enums.*;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;

public class GetDataFromDatabase {

    public static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    public static String dbAddress = "jdbc:mysql://localhost:3306/";
    public static String userPass  = "?user=root&password=";
    public static String dbName = "projekt";
    public static String userName = "root";
    public static String password = "";

    private Statement statement;
    private Connection con;
    @NotNull
    public static ArrayList<User> getDataFromUserTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<User> users = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM Users ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String uname = rs.getString("uname");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                Date birthDate = rs.getDate("birthDate");
                String birthPlace = rs.getString("birthPlace");
                Sex sex = Sex.valueOf(rs.getString("sex"));
                String girlName = rs.getString("girlName");
                Nationality nationality = Nationality.valueOf(rs.getString("nationality"));
                //System.out.println(id+", "+uname+", "+userName+", "+password+", "+email+", "+birthDate.toString()+", "+birthPlace+", "+sex+", "+isActive+", "+isMom+", "+girlName+", "+nationality);
                boolean aktiv = false;
                boolean Mom = false;
                users.add(new User(id,uname,userName,password,email,birthDate,birthPlace,sex,aktiv, nationality));
            }
            con.close();
            return users;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
    @NotNull
    public static ArrayList<MemberShip> getDataFromMemberShipTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<MemberShip> memberShips = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM MemberShips ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                int mnumber = rs.getInt("mnumber");
                int userID = rs.getInt("userID");
                Date expiry = rs.getDate("expiry");
                memberShips.add(new MemberShip(id,mnumber,userID,expiry));
            }
            con.close();
            return memberShips;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
