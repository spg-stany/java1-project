package task5;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 05.10.12
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public class Comp implements Comparable {

  public int compareTo(Object o)
  {
    System.out.println("compareTo");
    return 1;
  }

}
