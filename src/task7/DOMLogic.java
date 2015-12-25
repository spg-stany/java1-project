package task7;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 09.10.12
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class DOMLogic
{
  public static void main(String[] args)
  {
    try
    {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document document = db.parse("students.xml");

      Element root = document.getDocumentElement();
      ArrayList<Student> students = Analyzer.listBuilder(root);

      for (int i = 0; i < students.size(); i++)
      {
        System.out.println(students.get(i));
      }
    }
    catch (SAXException e)
    {
      e.printStackTrace();
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
