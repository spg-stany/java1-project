package task3;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 02.10.12
 * Time: 18:19
 * To change this template use File | Settings | File Templates.
 */
class Node_
{
  public Object element;
  public Node_ next;
  public Node_ prev;

/*
  public task3.Node(Object e)
  {
    this.element = e;
  }
*/
  public Node_(Object element, Node_ prev, Node_ next)
  {
    this.element = element;
    this.prev = prev;
    this.next = next;
  }
}


public class MyList
{
  private Node_ node = new Node_(null, null, null);
  private int size = 0;

  public MyList()
  {
    node.next = node.prev = node;
  }

  //
  public int getCount()
  {
    return size;
  }

  //
  private Node_ addNode(Object e, Node_ n)
  {
    Node_ nn = new Node_(e, n, n.next);
    nn.prev.next = nn;
    nn.next.prev = nn;
    size++;

    return  nn;
  }

  //
  private Object delNode(Node_ n)
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
  private Node_ getNode(int index)
  {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index +
              ", Size: " + size);

    Node_ n = node;
    for (int i = 0; i <= index; i++)
      n = n.next;

    return n;
  }

  //
  public void add(Object e)
  {
    addNode(e, node.prev);
  }

  //
  public void addFirst(Object e)
  {
    addNode(e, node);
  }

  //
  public void addLast(Object e)
  {
    addNode(e, node.prev);
  }

  //
  public Object get(int index)
  {
    return ((Node_)getNode(index)).element;
  }

  //
  public Object remove(int index)
  {
    return delNode(getNode(index));
  }

}
