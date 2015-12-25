package task7;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 09.10.12
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */
public class SAXStudentMain
{
  public static void main(String[] args)
  {
    try
    {
      XMLReader reader = XMLReaderFactory.createXMLReader();
      StundentHandler sh = new StundentHandler();
      reader.setContentHandler(sh);


      ArrayList<Student> list;
      if (sh != null)
      {
        reader.parse("students.xml");
        System.out.println(sh.getStudents());
      }
    }
    catch (SAXException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
