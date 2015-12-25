package task9;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 12.10.12
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class DB
{
  private static Connection con;

  public DB()
  {
    try
    {
      Locale.setDefault(Locale.ENGLISH);
      //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test", "1");
      con.setAutoCommit(false);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public Collection getUsers() throws SQLException
  {
    Collection users = new ArrayList();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(
            "SELECT id, fio, dateOfBirth, address FROM users");
    while (rs.next())
    {
      User u = new User(rs);
      users.add(u);
    }
    rs.close();
    stmt.close();
    return users;
  }

  public void insertUser(User u) throws SQLException
  {
    PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO users (id, fio, dateOfBirth, address) " +
                    "VALUES (?, ?, ?, ?)");
    stmt.setInt(1, u.getId());
    stmt.setString(2, u.getFio());
    stmt.setDate(3, /*new Date(u.getDateOfBirth().getTime())*/null);
    stmt.setString(4, u.getAddress());
    stmt.execute();
    stmt.close();
    con.commit();
  }

  public void updateUser(User u) throws SQLException
  {
    PreparedStatement stmt = con.prepareStatement(
            "UPDATE users SET " +
                    "fio = ?, dateOfBirth = ?, address = ? " +
                    "WHERE id = ?");
    stmt.setString(1, u.getFio());
    stmt.setDate(2, /*new Date(u.getDateOfBirth().getTime())*/null);
    stmt.setString(3, u.getAddress());
    stmt.setInt(4, u.getId());
    stmt.execute();
    stmt.close();
    con.commit();
  }

  public void deleteUser(User u) throws SQLException
  {
    PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM users WHERE id = ?");
    stmt.setInt(1, u.getId());
    stmt.execute();
    stmt.close();
    con.commit();
  }
}
