package task7;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 09.10.12
 * Time: 14:10
 * To change this template use File | Settings | File Templates.
 */

enum StudentEnum
{
  NAME, PHONE, STREET, CITY, COUNTRY, FACULTY
}

public class StundentHandler implements ContentHandler
{
  ArrayList<Student> students = new ArrayList<Student>();
  Student curr = null;
  StudentEnum currentEnum = null;

  public ArrayList<Student> getStudents()
  {
    return students;
  }

  public void startDocument()
  {
    System.out.println("parsing started");
  }

  public void startElement(String uri, String localName,
                           String qName, Attributes attrs)
  {
    if (qName.equals("student"))
    {
      curr = new Student();
      curr.setLogin(attrs.getValue(0));
      curr.setTelephone(attrs.getValue(1));
      //curr.setFaculty(attrs.getValue(1));
    }
    if (!"address".equals(qName) && !"student".equals(qName) && !qName.equals("students"))
      currentEnum = StudentEnum.valueOf(qName.toUpperCase());
  }

  public void endElement(String uri, String localName,
                         String qName)
  {
    if (qName.equals("student"))
      students.add(curr);
    currentEnum = null;
  }

  public void characters(char[] ch, int start,
                         int length)
  {
    String s = new String(ch, start, length).trim();
    if (currentEnum == null) return;
    switch (currentEnum)
    {
      case NAME:
        curr.setName(s);
        break;
      case FACULTY:
        curr.setFaculty(s);
        break;
      case STREET:
        curr.getAddress().setStreet(s);
        break;
      case CITY:
        curr.getAddress().setCity(s);
        break;
      case COUNTRY:
        curr.getAddress().setCountry(s);
        break;
    }
  }

  public void setDocumentLocator(Locator locator)
  {
  }

  public void endDocument()
  {
  }

  public void skippedEntity(String name)
  {
  }

  public void processingInstruction(String target, String data)
  {
  }

  public void ignorableWhitespace(char ch[], int start, int length)
  {
  }

  public void startPrefixMapping(String prefix, String uri)
  {
  }

  public void endPrefixMapping(String prefix)
  {
  }
}
