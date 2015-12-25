package task3;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: amisatyuk
 * Date: 03.10.12
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */


class LinkedTreeMap<E>
{
  private Entry<E> header = new Entry<E>(null, null, null, null);
  private int size = 0;
  protected int modCount = 0;

  /**
   * Constructs an empty list.
   */
  public LinkedTreeMap()
  {
    header.next = header.previous = header;
  }

  private static class Entry<E>
  {
    E element;
    Entry<E> next;
    Entry<E> previous;
    String key;

    Entry(E element, Entry<E> next, Entry<E> previous, String key)
    {
      this.element = element;
      this.next = next;
      this.previous = previous;
      this.key = key;
    }

    @Override
    public String toString()
    {
      System.out.println("ToString: " + this.getClass().getName());
      return "[" + key + "," + element + "]";
    }

    @Override
    public boolean equals(Object o)
    {
      if (this == o) return true;
      if (this.element.equals(o)) return true;
      return false;
    }
  }

  private Entry<E> entry(int index)
  {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index +
              ", Size: " + size);
    Entry<E> e = header;
    if (index < (size >> 1))
    {
      for (int i = 0; i <= index; i++)
        e = e.next;
    }
    else
    {
      for (int i = size; i > index; i--)
        e = e.previous;
    }
    return e;
  }

  private Entry<E> addBefore(String key, E e, Entry<E> entry)
  {
    Entry<E> newEntry = new Entry<E>(e, entry, entry.previous, key);
    newEntry.previous.next = newEntry;
    newEntry.next.previous = newEntry;
    size++;
    modCount++;
    return newEntry;
  }

  private E remove(Entry<E> e)
  {
    if (e == header)
      throw new NoSuchElementException();

    E result = e.element;
    e.previous.next = e.next;
    e.next.previous = e.previous;
    e.next = e.previous = null;
    e.element = null;
    size--;
    modCount++;
    return result;
  }

  public boolean add(String key, E e)
  {
    System.out.println("add: " + "[" + key + "," + e.toString() + "]");
    addBefore(key, e, header);
    return true;
  }


  /**
   * Replaces the element at the specified position in this list with the
   * specified element.
   *
   * @param key        index of the element to replace
   * @param excludeKey element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws IndexOutOfBoundsException {@inheritDoc}
   */
  public boolean isKeyUniqueCheck(String key, String excludeKey)
  {
    for (Entry<E> e = header.next; e != header; e = e.next)
    {
      if (key.equals(e.key) && !e.key.equals(excludeKey))
      {
        return false;
      }
    }
    return false;
  }

  /**
   * Replaces the element at the specified position in this list with the
   * specified element.
   *
   * @param index   index of the element to replace
   * @param element element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws IndexOutOfBoundsException {@inheritDoc}
   */
  public E set(int index, String key, E element) throws Exception
  {
    Entry<E> e = entry(index);
    if (isKeyUniqueCheck(key, e.key))
    {
      E oldVal = e.element;
      e.element = element;
      return oldVal;
    }
    else throw new Exception("Key value not unique!");

  }

  /**
   * Inserts the specified element at the specified position in this list.
   * Shifts the element currently at that position (if any) and any
   * subsequent elements to the right (adds one to their indices).
   *
   * @param index   index at which the specified element is to be inserted
   * @param key     key at which the specified element is to be inserted*
   * @param element element to be inserted
   * @throws IndexOutOfBoundsException {@inheritDoc}
   */
  public void add(int index, String key, E element)
  {
    System.out.println("add by index: " + index + " [" + key + "," + element.toString() + "]");
    if (isKeyUniqueCheck(key, null))
    {
      try
      {
        set(index, key, element);
      }
      catch (Exception e)
      {
        e.getLocalizedMessage();
      }
      return;
    }
    addBefore(key, element, (index == size ? header : entry(index)));
  }

  public E get(int index)
  {
    System.out.println("get by index: " + index);
    return entry(index).element;
  }

  public E get(String key)
  {
    System.out.println("get by key: " + key);
    for (Entry<E> e = header.next; e != header; e = e.next)
    {
      if (key.equals(e.key))
      {
        return e.element;
      }
    }
    return null;
  }

  public void addFirst(String key, E e)
  {
    System.out.println("add: " + "[" + key + "," + e.toString() + "]");
    addBefore(key, e, header.next);
  }

  public void addLast(String key, E e)
  {
    System.out.println("addLast: " + "[" + key + "," + e.toString() + "]");
    addBefore(key, e, header);
  }

  public boolean remove(Object o)
  {
    System.out.println("remove by value: " + o.toString());
    if (o == null)
    {
      for (Entry<E> e = header.next; e != header; e = e.next)
      {
        if (e.element == null)
        {
          remove(e);
          return true;
        }
      }
    }
    else
    {
      for (Entry<E> e = header.next; e != header; e = e.next)
      {
        if (o.equals(e.element))
        {
          remove(e);
          return true;
        }
      }
    }
    return false;
  }

  public boolean removeByKey(String key)
  {
    System.out.println("remove by value: " + key);
    if (key == null)
    {
      for (Entry<E> e = header.next; e != header; e = e.next)
      {
        if (e.element == null)
        {
          remove(e);
          return true;
        }
      }
    }
    else
    {
      for (Entry<E> e = header.next; e != header; e = e.next)
      {
        if (key.equals(e.key))
        {
          remove(e);
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Removes the element at the specified position in this list.  Shifts any
   * subsequent elements to the left (subtracts one from their indices).
   * Returns the element that was removed from the list.
   *
   * @param index the index of the element to be removed
   * @return the element previously at the specified position
   * @throws IndexOutOfBoundsException {@inheritDoc}
   */
  public E remove(int index)
  {
    System.out.println("remove by index: " + index);
    return remove(entry(index));
  }

  /**
   * Search element by value and delete duplicates
   *
   * @return the element previously at the specified position
   * @throws IndexOutOfBoundsException {@inheritDoc}
   */
  public boolean searchAndDeleteDuplicateByValue()
  {
    boolean flag = false;
    System.out.println("searchAndDeleteDuplicateByValue: ");
    for (int i = 0; i < size; i++)
    {
      for (int j = 0; j < size; j++)
        if (i != j)
        {
          if (get(i).equals(get(j)))
          {
            remove(j);
            flag = true;
          }
        }
    }
    return flag;
  }

  /**
   * Search element by value and delete duplicates
   *
   * @return the element previously at the specified position
   * @throws IndexOutOfBoundsException {@inheritDoc}
   */
  public boolean searchAndDeleteDuplicateByPointer()
  {
    boolean flag = false;
    System.out.println("searchAndDeleteDuplicateByPointer: ");
    for (int i = 0; i < size; i++)
    {
      for (int j = 0; j < size; j++)
        if (i != j)
        {
          if (get(i) == get(j))
          {
            remove(j);
            flag = true;
          }
        }
    }
    return flag;
  }

  @Override
  public String toString()
  {
    System.out.println("ToString: " + this.getClass().getName());
    String tmpString = "";
    for (int i = 0; i < size; i++)
    {
      if (i == size - 1)
      {
        tmpString += "[" + entry(i).key + "," + entry(i).element + "]";
      }
      else
      {
        tmpString += "[" + entry(i).key + "," + entry(i).element + "], ";
      }
    }
    return tmpString;
  }
}

//public
class LinkedTreeMapTest
{
  public static void main(String[] args)
  {
    String a1 = "1";
    String a2 = "1";
    System.out.println(a1 == a2);
    a1 = a1 + 1;
    a2 = a2 + 1;
    System.out.println(a1 == a2);

    LinkedTreeMap<Object> linkedTreeMap = new LinkedTreeMap<Object>();
    /* а так получаются одинаковые ссылки
    linkedTreeMap.add("keyTwo", "1"+1);
    linkedTreeMap.add("keyOne", "1"+1);
    */
    linkedTreeMap.add("keyTwo", a1);
    linkedTreeMap.addFirst("keyOne", a2);
    linkedTreeMap.addLast("keyThree", "abs");
    linkedTreeMap.addLast("keyThree", "abs");
    System.out.println(linkedTreeMap.toString());

    linkedTreeMap.searchAndDeleteDuplicateByPointer();
    System.out.println(linkedTreeMap.toString());

    linkedTreeMap.searchAndDeleteDuplicateByValue();
    System.out.println(linkedTreeMap.toString());

    linkedTreeMap.remove("1");
    System.out.println(linkedTreeMap.toString());

    linkedTreeMap.remove(0);
    System.out.println(linkedTreeMap.toString());

    System.out.println(linkedTreeMap.get(0));
    System.out.println(linkedTreeMap.get("keyThree"));
  }
}
