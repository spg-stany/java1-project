package task9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 12.10.12
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
public class UserDialog extends JDialog implements ActionListener
{
  private static final int D_HEIGHT = 200;
  private final static int D_WIDTH = 450;

  private final static int L_X = 10;
  private final static int L_W = 100;
  private final static int C_W = 150;

  private MainFrame owner;

  private boolean result = false;

  private int id = 0;
  private JTextField fio = new JTextField();
  private JTextField address = new JTextField();
  private JSpinner dateOfBirth = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));

  public UserDialog(MainFrame owner)
  {
    this.owner = owner;
    setTitle("Редактирование данных");
    getContentPane().setLayout(new FlowLayout());
    getContentPane().setLayout(null);

    JLabel l = new JLabel("Фамилия:", JLabel.RIGHT);
    l.setBounds(L_X, 10, L_W, 20);
    getContentPane().add(l);
    fio.setBounds(L_X + L_W + 10, 10, C_W, 20);
    getContentPane().add(fio);

    l = new JLabel("Адрес:", JLabel.RIGHT);
    l.setBounds(L_X, 30, L_W, 20);
    getContentPane().add(l);
    address.setBounds(L_X + L_W + 10, 30, C_W, 20);
    getContentPane().add(address);

    // Дата рождения
    l = new JLabel("Дата рождения:", JLabel.RIGHT);
    l.setBounds(L_X, 90, L_W, 20);
    getContentPane().add(l);
    dateOfBirth.setBounds(L_X + L_W + 10, 90, C_W, 20);
    getContentPane().add(dateOfBirth);

    JButton btnOk = new JButton("OK");
    btnOk.setName("OK");
    btnOk.addActionListener(this);
    btnOk.setBounds(L_X + L_W + C_W + 10 + 50, 10, 100, 25);
    getContentPane().add(btnOk);

    JButton btnCancel = new JButton("Cancel");
    btnCancel.setName("Cancel");
    btnCancel.addActionListener(this);
    btnCancel.setBounds(L_X + L_W + C_W + 10 + 50, 40, 100, 25);
    getContentPane().add(btnCancel);


    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(((int) d.getWidth() - UserDialog.D_WIDTH) / 2, ((int) d.getHeight() - UserDialog.D_HEIGHT) / 2,
            UserDialog.D_WIDTH, UserDialog.D_HEIGHT);
  }

  public void setUser(User st)
  {
    id = st.getId();
    fio.setText(st.getFio());
    address.setText(st.getAddress());
    //dateOfBirth.getModel().setValue(st.getDateOfBirth());
  }

  public User getUser()
  {
    User st = new User();
    st.setId(id);
    st.setFio(fio.getText());
    st.setAddress(address.getText());
    //Date d = ((SpinnerDateModel) dateOfBirth.getModel()).getDate();
    //st.setDateOfBirth(d);
    return st;
  }

  public boolean getResult()
  {
    return result;
  }

  public void actionPerformed(ActionEvent e)
  {
    JButton src = (JButton) e.getSource();

    if (src.getName().equals("OK"))
      result = true;
    if (src.getName().equals("Cancel"))
      result = false;
    setVisible(false);
  }
}
