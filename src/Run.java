/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 02.10.12
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */

public class Run
{

  //
  public static void calc(int i)
  {
    System.out.println((Math.PI / i) * Math.random());
  }


  //
  public static void main(String args[])
  {
    /*
    int a = 4235435;
    //
    for (int i = 0; i < args.length; i++)
      System.out.println("args[" + i + "]=" + args[i]);
    */

    //
    /*
    Scanner sc = new Scanner(System.in);
    System.out.print("Введите целое число: ");
    if (sc.hasNextInt())
    {
      a = sc.nextInt();
      System.out.println(a);
    }
    */

    /*
    try
    {
      System.out.print("input number: ");

      byte buff[] = new byte[100];
      int n_read = System.in.read(buff);
      String param = new String(buff);
      System.out.println("input val " + param);

    }
    catch (IOException ex)
    {
      System.out.print(ex.toString());
    }

    //
    calc(a);

    //
    try
    {
      a = a / 0;
      a = a / 0;
    }
    catch (Exception ex)
    {
      System.out.println(ex.toString());
    }

    //
    TestClass tc = new TestClass("test", 0);
    System.out.println("toString " + tc);
    TestClass tc1 = new TestClass("test", 1);
    TestClass tc2 = tc1;//new TestClass("test2");
    System.out.println(" == " + (tc == tc1));
    System.out.println("equals " + tc.equals(tc1));
    System.out.println("HashCode " + tc.hashCode());

    System.out.println("tc.hashCode(): " + tc.hashCode());
    System.out.println("tc1.hashCode(): " + tc1.hashCode());
    HashMap<TestClass, Object> hs = new HashMap<TestClass, Object>();
    hs.put(tc, tc);
    hs.put(tc1, tc1);
    System.out.println("size: " + hs.size());

    System.out.println("tc: " + hs.get(tc));
    System.out.println("tc1 " + hs.get(tc1));
    */

/*
    MyList list = new MyList();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    for( int i = 0; i < list.getCount(); i++ )
      //list3.get(i);
      System.out.println(list.get(i));

    list.remove(3);
    for( int i = 0; i < list.getCount(); i++ )
      System.out.println(list.get(i));
*/

/*
    task3.MyListMap listmap = new task3.MyListMap();
    listmap.add("0", "a");
    listmap.add("1", "b");
    listmap.add("2", "c");
    listmap.add("3", "d");
    listmap.add("4", "a");

    for( int i = 0; i < listmap.getCount(); i++ )
      System.out.println("get by index: [" + i + "]" + listmap.get(i));

    System.out.println("get by key: {3}" + listmap.get("3"));

    System.out.println("listmap.del(3)");
    listmap.del(3);
    for( int i = 0; i < listmap.getCount(); i++ )
      System.out.println("get by index: [" + i + "]" + listmap.get(i));

    System.out.println("listmap.del(\"2\")");
    listmap.del("2");
    for( int i = 0; i < listmap.getCount(); i++ )
      System.out.println("get by index: [" + i + "]" + listmap.get(i));

    System.out.println("DeleteDuplicatesByValue");
    listmap.DeleteDuplicatesByValue();
    for( int i = 0; i < listmap.getCount(); i++ )
      System.out.println("get by index: [" + i + "]" + listmap.get(i));
*/

/*
    try
    {
      ListMap list = new ListMap();
//    list.add("0", "a");
      list.add("k0", "a", 0);
      list.add("k1", "b");
      list.add("k3", "d");
      list.add("k2", "c", 2);
      list.add("k4", "a");
      for (int i = 0; i < list.getCount(); i++)
        System.out.println("get by index: [" + i + "]" + list.get(i));

      list.delDupByValue();
      System.out.println(list);

//      list.clear();
      System.out.println("--------------");
      String str = "asd";
      list.add("kk0", "a");
      list.add("kk1", str);
      list.add("kk2", "b");
      list.add("kk3", str);
      System.out.println(list);

      list.delDupByPointer();
      System.out.println(list);
    }
    catch (Exception e)
    {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

*/

    /*
    Item a1 = new Book("name1", "author1");
    a1.printA();
    System.out.println(a1.a);

    Item i = new Item();
    i.f(1);
    i.f("test");
    i.print();


    Book b = new Book("test", "test");
    b.f(1);

    Item it = b;
    it.f(1);

    //Item[] catalog = new Item[] {
    //        new Book("book name", "author")
    //};
    //catalog[0].print();
    //Book.stat_f(99999);
    */

    /*
    Comp cp = new Comp();
    cp.compareTo(1);

    MyIfaceClass c = new MyIfaceClass();
    c.add(1, 2);
    c.del(3, 4);
    */
  }

}
