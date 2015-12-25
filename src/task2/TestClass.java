package task2;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 02.10.12
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */


public class TestClass
{

  int a;

  private String str;

  public TestClass(String str, int a)
  {
    this.str = str;
    this.a = a;
  }

  //private String str1 = new String("Test1");
  //private String str2 = new String("Test2");


  @Override
  public String toString()
  {
    return "TestClass{" +
            "a=" + a +
            ", str='" + str + '\'' +
            '}';
  }

  //
  public boolean equals(Object obj)
  {
    TestClass tc = (TestClass) obj;
    return str.equals(tc.str) && a == tc.a;
    //return str1.equals(tc.str1) && str2.equals(tc.str2);
//    return (this == obj);

  }

  //
  //@Override
  public int hashCode()
  {
    return str.hashCode();
  }

}
