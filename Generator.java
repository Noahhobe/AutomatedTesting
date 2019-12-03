import java.util.*;
import java.io.*;

public class Generator
{
  /**/
  private HashMap<String, List<String>> map =  new HashMap<String, List<String>>();
  
  /**
   * The constructor that essentialy fills a hashmap with production keys and their
   * corresponding production values
   */
  public Generator(File grammar)
  {
    
    Scanner sc = new Scanner(grammar);
    
    while(sc.hasNextLine())
    {
      
      String[] line = sc.nextLine().split("->");
      
      if(!map.containsKey(line[0]))
      {
        
        map.put(line[0], new List<String>());
        
      }
      
      map.get(line[0]).add(line[1]);
      
    }
  }
  
  /**
   * 
   */
  public static void main(String args[])
  {
  }
  
  /**
   * Generates a random input string from the start state
   */
  public String generate()
  {
    
    Random rand = new Random(map.get("String").length);
    String result = "";
    String[] rule = map.get("Start").get(rand.nextInt()).split(" ");
    
    for (int i  = 0; i < rule.size; i++)
    {
      if(!map.containsKey(rule[i]))
      {
        if(rule[i].equals("num"))
        {
          Random r = new Random(10);
          result += r.nextInt() + " ";
        } 
        else if(rule[i].equals("char"))
        {
          Random r = new Random();
          String s = (String)(r.nextInt(26) + "a");
        }
        else if(rule[i].equals("boolean"))
        {
          Random r = new Random(2);
          if(r.nextInt() == 1)
          {
            String s = "true";
          }
          else
          {
            String s = "false";
          }
        }
        else
        {
          result += generate(rule[i]);
        }
      }
    }
  }
  
    /**
   * 
   */
  public String generate(String production)
  {
    
    Random rand = new Random(map.get(production).length);
    String result = "";
    String[] rule = map.get(production).get(rand.nextInt()).split(" ");
    
    for (int i  = 0; i < rule.size; i++)
    {
      if(!map.containsKey(rule[i]))
      {
        if(rule[i].equals("num"))
        {
          Random r = new Random(10);
          result += r.nextInt() + " ";
        } 
        else if(rule[i].equals("char"))
        {
          Random r = new Random();
          String s = (String)(r.nextInt(26) + "a");
        }
        else if(rule[i].equals("boolean"))
        {
          Random r = new Random(2);
          if(r.nextInt() == 1)
          {
            String s = "true";
          }
          else
          {
            String s = "false";
          }
        }
        else
        {
          result += generate(rule[i]);
        }
      }
    }
  }
}
