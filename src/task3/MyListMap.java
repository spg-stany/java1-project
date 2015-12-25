package task3;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 05.10.12
 * Time: 12:17
 * To change this template use File | Settings | File Templates.
 */
class Node
{
  Object element;
  Node next;
  Node prev;
  String key;

  public Node(Object element, Node prev, Node next, String key)
  {
    this.element = element;
    this.prev = prev;
    this.next = next;
    this.key = key;
  }
}

public class MyListMap
{
  private Node node = new Node(null, null, null, null);
  private int size = 0;

  public MyListMap()
  {
    node.next = node.prev = node;
  }

  //
  public int getCount()
  {
    return size;
  }

  //
  private Node addNode(String key, Object e, Node n)
  {
    Node nn = new Node(e, n, n.next, key);
    nn.prev.next = nn;
    nn.next.prev = nn;
    size++;

    return nn;
  }

  //
  private Object delNode(Node n)
  {
    if (n == node)
      throw new NoSuchElementException();

    Object nn = n.element;
    n.prev.next = n.next;
    n.next.prev = n.prev;
    n.next = n.prev = null;
    n.element = null;
    size--;

    return nn;
  }

  //
  private Node getNode(int index)
  {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index +
              ", Size: " + size);

    Node n = node;
    for (int i = 0; i <= index; i++)
      n = n.next;

    return n;
  }

  //
  private Node getNode(String key)
  {
    for (Node e = node.next; e != node; e = e.next)
      if (key.equals(e.key))
        return e;

    return null;
  }

  //
  public void add(String key, Object e)
  {
    addNode(key, e, node.prev);
  }

  //
  public void addFirst(String key, Object e)
  {
    addNode(key, e, node);
  }

  //
  public void addLast(String key, Object e)
  {
    addNode(key, e, node.prev);
  }

  //
  public Object get(int index)
  {
    return ((Node) getNode(index)).element;
  }

  //
  public Object get(String key)
  {
    return ((Node) getNode(key)).element;
  }

  //
  public Object del(int index)
  {
    return delNode(getNode(index));
  }

  //
  public Object del(String key)
  {
    return delNode(getNode(key));
  }

  //
  public void DeleteDuplicatesByValue()
  {
    for (int i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        if (i != j)
          if (get(i).equals(get(j)))
            del(j);
  }

  //
  public void DeleteDuplicatesByPointer()
  {
    for (int i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        if (i != j)
          if (get(i) == get(j))
            del(j);
  }
}

