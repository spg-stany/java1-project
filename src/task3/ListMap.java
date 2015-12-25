package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 05.10.12
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
public class ListMap <E>
{
  private ArrayList list = new ArrayList();
  private HashMap<String, E> map = new HashMap<String, E>();

  //
  public int getCount()
  {
    return list.size();
  }

  /**
   * description gfd thhgfd gfgf
   *
   * @param key param1 dsgxsg
   * @param e fdgdfgdfgf
   */
  public void add(String key, E e) throws Exception
  {
    if (map.containsKey(key))
      throw new Exception("containsKey");

    map.put(key, e);
    list.add(e);
  }

  //
  public void add(String key, E e, int index) throws Exception
  {
    if (map.containsKey(key))
      throw new Exception("containsKey");

    map.put(key, e);
    list.add(index, e);
  }

  //
  public E get(int index)
  {
    return ((E)list.get(index));
  }

  //
  public E get(String key)
  {
    return map.get(key);
  }

  //
  public void del(int index)
  {
    Object value = list.remove(index);
    for (Map.Entry<String, E> entry : map.entrySet())
      if (entry.getValue() == value)
      {
        map.remove(entry.getKey());
        break;
      }
  }

  public void clear()
  {
    list.clear();
    map.clear();
  }

  //
  public void del(String key)
  {
    list.remove(map.remove(key));
  }

  //
  public void delDupByValue()
  {
    for (int i = 0; i < list.size(); i++)
      for (int j = 0; j < list.size(); j++)
        if (i != j && get(i).equals(get(j)))
          del(j);
  }

  //
  public void delDupByPointer()
  {
    for (int i = 0; i < list.size(); i++)
      for (int j = 0; j < list.size(); j++)
        if (i != j && get(i) == get(j))
            del(j);
  }

  @Override
  public String toString()
  {
    return "ListMap{" +
            "list=" + list +
            ", map=" + map +
            '}';
  }


}
