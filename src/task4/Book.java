package task4;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 05.10.12
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class Book extends Item
{
  String authors;


  protected int f(int a)
  {
    System.out.println("class Book f");
    return 1;
  }

  public Book(String name, String authors)
  {
//    super(name);
//    this.name = name;
    this.authors = authors;
  }

  public void print()
  {
    System.out.println("Авторы:");
    System.out.println(authors);

    super.print();
  }

  //
  static void stat_f (int x)
  {
    System.out.println("x = " + x);
  }

  protected void printA()
  {
    System.out.println("a = " + a);
  }

}


