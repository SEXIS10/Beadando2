import com.projekt.beadando.Classes.MemberShip;
import com.projekt.beadando.Classes.User;
import com.projekt.beadando.DataBase.Database;
import com.projekt.beadando.DataBase.DeleteFromDataBase;
import com.projekt.beadando.DataBase.GetDataFromDatabase;
import com.projekt.beadando.DataBase.InsertToDatabase;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class dbTest
{
    public Database database = new Database();
    public InsertToDatabase insert = new InsertToDatabase();

    @Test
    public void CreationTest()
    {
        database.createDatabase();
    }
    @Test
    public void UsersTest() throws SQLException {
        database.createUsersTable();
        GetDataFromDatabase.getDataFromUserTable();
        insert.insertIntoUserTable(new User("Korb András Péter", "Korb", "123", "korbVagyokTeso@korbmail.com", Date.valueOf("2001-01-01"), "Berettyóújfalu", "Man", true, "Hungarian"));
        assertEquals(1,GetDataFromDatabase.getDataFromUserTable().size());
        DeleteFromDataBase.deleteUser(1);
    }
    @Test
    public void MembershipTest() throws SQLException {
        database.createMemberShipTable();
        GetDataFromDatabase.getDataFromMemberShipTable();
        insert.insertIntoMemberShipTable(new MemberShip(12211212,2,Date.valueOf("2023-01-01")));
        //DeleteFromDataBase.deleteMemberShip(1);
    }
}
