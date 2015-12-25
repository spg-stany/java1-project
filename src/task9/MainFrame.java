package task9;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 12.10.12
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class MainFrame extends JFrame implements ActionListener
{
  private static final String INSERT_ST = "insert";
  private static final String UPDATE_ST = "update";
  private static final String DELETE_ST = "delete";

  private JTable table;

  DB db = new DB();


  public MainFrame()
  {
    getContentPane().setLayout(new BorderLayout());

    JPanel top = new JPanel();
    top.setLayout(new FlowLayout(FlowLayout.LEFT));
    JPanel bot = new JPanel();
    bot.setLayout(new BorderLayout());
    JPanel right = new JPanel();
    right.setLayout(new BorderLayout());
    right.setBorder(new BevelBorder(BevelBorder.LOWERED));

    table = new JTable(1, 4);
    right.add(new JScrollPane(table), BorderLayout.CENTER);

    JButton btnAddSt = new JButton("Добавить");
    btnAddSt.setName(INSERT_ST);
    btnAddSt.addActionListener(this);
    JButton btnUpdSt = new JButton("Исправить");
    btnUpdSt.setName(UPDATE_ST);
    btnUpdSt.addActionListener(this);
    JButton btnDelSt = new JButton("Удалить");
    btnDelSt.setName(DELETE_ST);
    btnDelSt.addActionListener(this);

    JPanel pnlBtnSt = new JPanel();
    pnlBtnSt.setLayout(new GridLayout(1, 3));
    pnlBtnSt.add(btnAddSt);
    pnlBtnSt.add(btnUpdSt);
    pnlBtnSt.add(btnDelSt);
    right.add(pnlBtnSt, BorderLayout.SOUTH);
    bot.add(right, BorderLayout.CENTER);
    getContentPane().add(top, BorderLayout.NORTH);
    getContentPane().add(bot, BorderLayout.CENTER);

    setBounds(100, 100, 700, 500);

    reloadUsers();
  }


  public void reloadUsers()
  {
    try
    {
      if (table != null)
        table.setModel(new UserTableModel(new Vector(db.getUsers())));
    }
    catch (Exception ex)
    {
      //JOptionPane.showMessageDialog(MainFrame.this, e.getMessage());
      ex.printStackTrace();
    }
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() instanceof Component)
    {
      Component c = (Component) e.getSource();
      if (c.getName().equals(INSERT_ST))
      {
        insertUser();
      }
      if (c.getName().equals(UPDATE_ST))
      {
        updateUser();
      }
      if (c.getName().equals(DELETE_ST))
      {
        deleteUser();
      }
    }
  }

  private void insertUser()
  {
    UserDialog sd = new UserDialog(MainFrame.this);
    sd.setModal(true);
    sd.setVisible(true);
    if (sd.getResult())
    {
      try
      {
        db.insertUser(sd.getUser());
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
      reloadUsers();
    }
  }

  private void updateUser()
  {
    if (table != null)
    {
      UserTableModel stm = (UserTableModel) table.getModel();

      if (table.getSelectedRow() >= 0)
      {
        try
        {
          UserDialog sd = new UserDialog(MainFrame.this);
          sd.setUser(stm.getUser(table.getSelectedRow()));
          sd.setModal(true);
          sd.setVisible(true);
          if (sd.getResult())
          {
            db.updateUser(sd.getUser());
            reloadUsers();
          }
        }
        catch (Exception ex)
        {
          //JOptionPane.showMessageDialog(MainFrame.this, e.getMessage());
          ex.printStackTrace();
        }
      }
      else
        JOptionPane.showMessageDialog(MainFrame.this,
                "Необходимо выделить элемент в списке");
    }
  }

  private void deleteUser()
  {
    if (table != null)
    {
      UserTableModel stm = (UserTableModel) table.getModel();
      if (table.getSelectedRow() >= 0)
      {
        if (JOptionPane.showConfirmDialog(MainFrame.this,
                "Вы хотите удалить запись?", "Удаление записи",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
          try
          {
            db.deleteUser(stm.getUser(table.getSelectedRow()));
            reloadUsers();
          }
          catch (Exception ex)
          {
            //JOptionPane.showMessageDialog(MainFrame.this, e.getMessage());
            ex.printStackTrace();
          }
        }
      }
      else
        JOptionPane.showMessageDialog(MainFrame.this,
                "Необходимо выделить элемент в списке");
    }

  }


  public static void main(String args[])
  {
    MainFrame f = new MainFrame();
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    f.setVisible(true);
  }
}
