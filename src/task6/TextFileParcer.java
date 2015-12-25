package task6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 08.10.12
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
class FileInfo
{
  String fName;
  String fPath;
  long size;
  String wordX;
  int wordXCnt;
  HashMap<String, Integer> map;

  public FileInfo(String fName,
                  String fPath,
                  long size,
                  String wordX,
                  int wordXCnt,
                  HashMap<String, Integer> map
  )
  {
    this.fName = fName;
    this.fPath = fPath;
    this.size = size;
    this.wordX = wordX;
    this.wordXCnt = wordXCnt;
    this.map = map;
  }
}


public class TextFileParcer
{
  public ArrayList<FileInfo> list = new ArrayList<FileInfo>();

  public void TextFileParcer()
  {

  }

  //
  void readFile(String fname)
  {
    try
    {
      BufferedReader br = new BufferedReader(new FileReader(fname));
      HashMap<String, Integer> fmap = new HashMap<String, Integer>();
      //ListMap fmap = new ListMap();
      String line = null;

      while ((line = br.readLine()) != null)
      {
        String arr[] = line.split(" ");
        for (int i = 0; i < arr.length; i++)
          fmap.put(arr[i], fmap.containsKey(arr[i]) ? fmap.get(arr[i]) + 1 : 1);
        //System.out.println(fmap);
      }
      br.close();

      File fl = new File(fname);
      FileInfo f = new FileInfo(fl.getName(), fl.getAbsolutePath(), fl.length(), null, 0, fmap);

      list.add(f);
    }
    catch (Exception ex)
    {
      System.out.print(ex.toString());
    }
  }

  //
  public static void main(String args[])
  {
    String dir = null;
    try
    {
      //File currentDir = new File(".");
      //System.out.println(currentDir.getCanonicalPath());
      Properties props = new Properties();
      FileInputStream in = new FileInputStream(".properties");
      props.load(in);
      in.close();
      dir = props.getProperty("dir");
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }


    TextFileParcer txt = new TextFileParcer();

    String mask = ".txt";
    File fl = new File(dir);
    String flist[] = fl.list();
    for (int i = 0; i < flist.length; i++)
      if (flist[i].contains(mask))
        txt.readFile(dir + flist[i]);


    HashMap<String, Integer> tmap = new HashMap<String, Integer>();
    for (int i = 0; i < txt.list.size(); i++)
      for (Map.Entry<String, Integer> entry : ((FileInfo) txt.list.get(i)).map.entrySet())
        tmap.put(entry.getKey(), tmap.containsKey(entry.getKey()) ? tmap.get(entry.getKey()) + 1 : 1);


    String wordX = null;
    /*
    for (Map.Entry<String, Integer> entry : tmap.entrySet())
    {
      if (entry.getValue() < txt.list.size())
      //  System.out.println(entry.getValue());
        tmap.remove(entry.getKey());
    }
    */
    for (Iterator<Map.Entry<String, Integer>> it = tmap.entrySet().iterator(); it.hasNext(); )
    {
      Map.Entry<String, Integer> entry = it.next();
      if (entry.getValue() < txt.list.size())
        it.remove();
    }
    //System.out.println(tmap);

    int max = 0;
    for (Map.Entry<String, Integer> entry : tmap.entrySet())
    {
      for (int i = 0; i < txt.list.size(); i++)
        entry.setValue((entry.getValue() + ((FileInfo) txt.list.get(i)).map.get(entry.getKey())));

      entry.setValue(entry.getValue() - txt.list.size());

      /*
      if (entry.getValue() > max)
      {
        max = entry.getValue();
        wordX = entry.getKey();
      }
      */
      if (entry.getValue() == Collections.max(tmap.values()))
        wordX = entry.getKey();
    }


    System.out.println("--------------------------------");
    System.out.println("----------total-----------------");
    System.out.println(tmap);
    System.out.println(wordX);

    for (int i = 0; i < txt.list.size(); i++)
    {
      ((FileInfo) txt.list.get(i)).wordX = wordX;
      ((FileInfo) txt.list.get(i)).wordXCnt = ((FileInfo) txt.list.get(i)).map.get(wordX);
    }

    for (int i = 0; i < txt.list.size(); i++)
    {
      System.out.println("--------------------------------");
      System.out.println(((FileInfo) txt.list.get(i)).fName);
      System.out.println(((FileInfo) txt.list.get(i)).fPath);
      System.out.println(((FileInfo) txt.list.get(i)).size);
      System.out.println(((FileInfo) txt.list.get(i)).wordX);
      System.out.println(((FileInfo) txt.list.get(i)).wordXCnt);
      System.out.println(((FileInfo) txt.list.get(i)).map);
    }
  }
}
