import java.util.*;
import java.io.*;

public class Generator
{
  String alphabet = "abcdefghijklmnopqrstuvwxyz";
  String capsAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  String vowels = "aeiou";
  String sometimeVowels = "aeiouy";
  String numbers = "1234567890";
  /**/
  private HashMap<String, List<String>> map =  new HashMap<String, List<String>>();
  
  /**
   * The constructor that essentially fills a hashmap with production keys and their
   * corresponding production values
   */
  public Generator(File grammar)
  {
    
    Scanner sc;
    try {
      sc = new Scanner(grammar);
      
      
      while(sc.hasNextLine())
      {
        
        String[] line = sc.nextLine().split("->");
        
        if(!map.containsKey(line[0]))
        {
          
          map.put(line[0], new ArrayList<String>());
        }
        map.get(line[0]).add(line[1]);
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  
  /**
   * Generates a random input string from the start state
   */
  public String generate()
  {
    
    Random rand = new Random(map.get("start").size());
    String result = "";
    String[] rule = map.get("start").get(rand.nextInt(map.get("start").size())).split(" ");
    
    for (int i  = 0; i < rule.length; i++)
    {
      if(!map.containsKey(rule[i]))
      {
        if(rule[i].equals("NUM"))
        {
          Random r = new Random(10);
          result += r.nextInt() + " ";
        } 
        else if(rule[i].equals("CHAR"))
        {
          Random r = new Random();
          result += alphabet.charAt(r.nextInt(26));
        }
        else if(rule[i].equals("CAP"))
        {
          Random r = new Random();
          result += capsAlpha.charAt(r.nextInt(26));
        }
        else if(rule[i].equals("WS"))
        {
          result += " ";
        }
        else if(rule[i].equals("BOOL"))
        {
          Random r = new Random(2);
          if(r.nextInt() == 1)
          {
            result += "true";
          }
          else
          {
            result += "false";
          }
        }
        else if(rule[i].equals("EPSILON"))
        {
        }
      }
      else
      {
        result += generate(rule[i]);
      }
    }
    
    return result;
  }
  
  /**
   * recursive call V1 string
   */
  public String generate(String production)
  {
    Random rand = new Random();
    String result = "";
    String[] rule = map.get(production).get(rand.nextInt(map.get(production).size())).split(" ");
    
    for (int i  = 0; i < rule.length; i++)
    {
      if(!map.containsKey(rule[i]))
      {
        if(rule[i].equals("NUM"))
        {
          Random r = new Random();
          result += numbers.charAt(r.nextInt(10));
        } 
        else if(rule[i].equals("NEG"))
        {
          result += "-";
        }
        else if(rule[i].equals("CHAR"))
        {
          Random r = new Random();
          result += alphabet.charAt(r.nextInt(26));
        }
        else if(rule[i].equals("CAP"))
        {
          Random r = new Random();
          result += capsAlpha.charAt(r.nextInt(26));
        }
        else if(rule[i].equals("VOWEL"))
        {
          Random r = new Random();
          result += vowels.charAt(r.nextInt(5));
        }
        else if(rule[i].equals("WS"))
        {
          result += " ";
        }
        else if(rule[i].equals("DOT"))
        {
          result += ".";
        }
        else if(rule[i].equals("BOOL"))
        {
          Random r = new Random(2);
          if(r.nextInt() == 1)
          {
            result += "true";
          }
          else
          {
            result += "false";
          }
        }
        else if(rule[i].equals("EPSILON"))
        {
        }
      }
      else
      {
        result += generate(rule[i]);
      }
    }
    return result;
  }
  
  
  /**
   * targeted generator ints
   */
  public String generateInt()
  {
    Random rand = new Random();
    String result = "";
    String[] rule = map.get("startInt").get(rand.nextInt(map.get("startInt").size())).split(" ");
    
    for (int i  = 0; i < rule.length; i++)
    {
      if(!map.containsKey(rule[i]))
      {
        if(rule[i].equals("NUM"))
        {
          //Random r = new Random();
          //result += numbers.charAt(r.nextInt(10));
          Random r = new Random(10);
          result += r.nextInt() + "";
        } 
        else if(rule[i].equals("NEG"))
        {
          result += "-";
        }
        else if(rule[i].equals("EPSILON"))
        {
        }
      }
      else
      {
        result += generate(rule[i]);
      }
    }
    return result;
  }
  
  
  
  /**
   * targeted generator doubles
   */
  public String generateDouble()
  {
    Random rand = new Random();
    String result = "";
    String[] rule = map.get("startDouble").get(rand.nextInt(map.get("startDouble").size())).split(" ");
    
    for (int i  = 0; i < rule.length; i++)
    {
      if(!map.containsKey(rule[i]))
      {
        if(rule[i].equals("NUM"))
        {
          //Random r = new Random();
          //result += numbers.charAt(r.nextInt(10));
          Random r = new Random(10);
          result += r.nextInt() + "";
        } 
        else if(rule[i].equals("DOT"))
        {
          result += ".";
        }
        else if(rule[i].equals("EPSILON"))
        {
        }
      }
      else
      {
        result += generate(rule[i]);
      }
    }
    return result;
  } 
  
}
