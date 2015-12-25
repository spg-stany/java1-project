package task8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 10.10.12
 * Time: 11:54
 * To change this template use File | Settings | File Templates.
 */
public class DrawForm extends Canvas
{
  private int lastX, lastY;
  private int ex, ey;
  private boolean clear = false;

  public DrawForm(final Frame f)
  {
    super();

    addMouseListener(new MouseAdapter()
    {
      public void mousePressed(MouseEvent e)
      {
        lastX = e.getX();
        lastY = e.getY();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter()
    {
      public void mouseDragged(MouseEvent e)
      {
        ex = e.getX();
        ey = e.getY();
        repaint();
      }
    });

    addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent e)
      {
        if (e.getKeyChar() == ' ')
        {
          clear = true;
          repaint();
        }
      }
    });

    addComponentListener(new ComponentAdapter()
    {
      public void componentResized(ComponentEvent evt)
      {
        JOptionPane.showMessageDialog(f, "Window resize event");
      }
    });
  }

  public void update(Graphics g)
  {
    if (clear)
    {
      g.clearRect(0, 0, getWidth(), getHeight());
      clear = false;
    }
    else
    {
      g.drawLine(lastX, lastY, ex, ey);
      lastX = ex;
      lastY = ey;
    }
  }

  public static void main(String s[])
  {
    final Frame f = new Frame("Draw");
    f.addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {
        f.dispose();
      }
    });
    f.setSize(400, 300);

    final Canvas c = new DrawForm(f);
    f.add(c);

    f.setVisible(true);
  }
}


