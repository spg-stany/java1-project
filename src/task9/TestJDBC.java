package task9;

import java.sql.*;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 10.10.12
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class TestJDBC
{

  public static void main(String[] args)
  {
    try
    {
      Locale.setDefault(Locale.ENGLISH);
      //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test", "1");
      connection.setAutoCommit(false);

      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("SELECT ID, NAME FROM users");
      while (rs.next())
      {
        System.out.println("ID=" + rs.getInt("ID") + " " + "NAME=" + rs.getString("NAME"));
      }
      rs.close();
      st.close();


      PreparedStatement pst = null;
      pst = connection.prepareStatement("SELECT ID, NAME FROM users where id > ? and id < ?");
      pst.setInt(1, 0);
      pst.setInt(2, 4);
      ResultSet rs2 = pst.executeQuery();
      while (rs2.next())
      {
        System.out.println("ID=" + rs2.getInt("ID") + " " + "NAME=" + rs2.getString("NAME"));
      }
      rs2.close();
      pst.close();


      pst = connection.prepareStatement("INSERT INTO users(id, name) values(?, ?)");
      pst.setInt(1, 4);
      pst.setString(2, "name");
      pst.execute();
      pst.close();
      connection.commit();

      Integer res;
      CallableStatement cst = connection.prepareCall("begin ? := test.f(?); end;");
      cst.registerOutParameter(1, Types.INTEGER);
      cst.setInt(2, 4);
      cst.execute();
      res = cst.getInt(1);
      cst.close();
      System.out.println(res);


      if (connection != null)
        connection.close();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
}
