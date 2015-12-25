package task8;

import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 10.10.12
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
class TestFrame extends Frame
{
  private TextField tf = new TextField();
  private String msg = null;

  TestFrame(String title)
  {
    super(title);
    init();
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
        System.out.println(evt);
      }

      /*
      public void componentHidden(ComponentEvent evt)
      {
        msg = "Window hide event";
        repaint();
      }
      */
    });

    addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent ev)
      {
        System.exit(0);
      }

      public void windowIconified(WindowEvent ev)
      {
        msg = "Window hide event";
        System.out.println(ev);
      }
    });

  }

  public void init()
  {
    add(tf, BorderLayout.NORTH);
    tf.setEnabled(false);
  }

  public void paint(Graphics g)
  {
    tf.setText(msg);
  }

  public static void main(String[] args)
  {
    Frame f = new TestFrame("Test AWT Frame");
  }
}
