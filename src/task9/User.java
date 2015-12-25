package task9;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 12.10.12
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
public class User
{
  private int id;
  private String fio;
  private Date dateOfBirth;
  private String address;

  public User(ResultSet rs) throws SQLException
  {
    setId(rs.getInt("id"));
    setFio(rs.getString("fio"));
    setDateOfBirth(rs.getDate("dateOfBirth"));
    setAddress(rs.getString("address"));
  }

  public User()
  {
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setFio(String fio)
  {
    this.fio = fio;
  }

  public void setDateOfBirth(Date dateOfBirth)
  {
    this.dateOfBirth = dateOfBirth;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }


  public int getId()
  {
    return id;
  }

  public String getFio()
  {
    return fio;
  }

  public Date getDateOfBirth()
  {
    return dateOfBirth;
  }

  public String getAddress()
  {
    return address;
  }

}
