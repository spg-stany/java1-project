package task7;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 09.10.12
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class Analyzer
{
  public static ArrayList<Student> listBuilder(Element root)
          throws SAXException, IOException
  {
    ArrayList<Student> students = new ArrayList<Student>();

    NodeList studentsNodes = root.getElementsByTagName("student");
    Student student = null;
    for (int i = 0; i < studentsNodes.getLength(); i++)
    {
      student = new Student();
      Element studentElement = (Element) studentsNodes.item(i);
      student.setFaculty(studentElement.getAttribute("faculty"));
      student.setName(getChildValue(studentElement, "name"));
      student.setLogin(studentElement.getAttribute("login"));
      student.setTelephone(studentElement.getAttribute("phone"));
      Student.Address address = student.getAddress();
      Element addressElement = getChild(studentElement, "address");
      address.setCountry(getChildValue(addressElement, "country"));
      address.setCity(getChildValue(addressElement, "city"));
      address.setStreet(getChildValue(addressElement, "street"));
      students.add(student);
    }
    return students;
  }

  private static Element getChild(Element parent,
                                  String childName)
  {
    NodeList nlist = parent.getElementsByTagName(childName);
    Element child = (Element) nlist.item(0);
    return child;
  }

  private static String getChildValue(Element parent,
                                      String childName)
  {
    Element child = getChild(parent, childName);
    Node node = child.getFirstChild();
    String value = node.getNodeValue();
    return value;
  }
}
