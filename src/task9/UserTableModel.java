package task9;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 12.10.12
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
public class UserTableModel extends AbstractTableModel
{
  private Vector users;

  public UserTableModel(Vector users)
  {
    this.users = users;
  }

  public int getRowCount()
  {
    if (users != null)
      return users.size();
    return 0;
  }

  public int getColumnCount()
  {
    return 3;
  }

  public String getColumnName(int column)
  {
    String[] colNames = {"Фамилия", "Дата", "Адрес"};
    return colNames[column];
  }

  public Object getValueAt(int rowIndex, int columnIndex)
  {
    if (users != null)
    {
      User u = (User) users.get(rowIndex);
      switch (columnIndex)
      {
        case 0:
          return u.getFio();
        case 1:
          return null;//DateFormat.getDateInstance(DateFormat.SHORT).format(u.getDateOfBirth());
        case 2:
          return u.getAddress();
      }
    }
    return null;
  }

  public User getUser(int rowIndex)
  {
    if (users != null)
      if (rowIndex < users.size() && rowIndex >= 0)
        return (User) users.get(rowIndex);

    return null;
  }

}
