package task8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 10.10.12
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class Form1 extends JFrame
{
  private JTextField txtField1 = new JTextField();
  private String msg = null;

  Form1(String title)
  {
    super(title);

    add(txtField1, BorderLayout.NORTH);
    txtField1.setEnabled(false);

    setSize(300, 200);
    setVisible(true);

    addMouseListener(new MouseAdapter()
    {
      public void mousePressed(MouseEvent e)
      {
        msg = "mousePressed";
        //e.getX();
        //e.getY();
        repaint();
      }
    });

    addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent e)
      {
        msg = Character.toString(e.getKeyChar());
        repaint();
      }
    });

    addComponentListener(new ComponentAdapter()
    {
      public void componentResized(ComponentEvent evt)
      {
        msg = "Window resize event";
        repaint();
      }
    });

    addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent ev)
      {
        System.exit(0);
      }
    });
  }

  public void paint(Graphics g)
  {
    txtField1.setText(msg);
  }

  public static void main(String[] args)
  {
    Form1 f = new Form1("Test SWING Frame");
  }


}
