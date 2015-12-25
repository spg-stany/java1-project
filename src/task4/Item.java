package task4;
/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 05.10.12
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class Item
{
  final protected String name;
  final int a;

  public Item()
  {
    name = "asd";
    a = 7;
  }

  public Item(String name, int a)
  {
    this.name = name;
    this.a = a;
  }

  protected int f(int a)
  {
    System.out.println("class Item f int");
    return 1;
  }

  protected int f(String a)
  {
    System.out.println("class Item f String");
    return 1;
  }


  public void print()
  {
    System.out.println("Наименование:");
    System.out.println(name);
  }

  protected void printA()
  {
    System.out.println("a: " + a);
  }
}
