import java.util.*;
import java.io.*;
/**
 * @author Brandan Kalsow, Noah Hoberg, Matt Rotter
 * @verson December 11, 2019
 * 
 * This class runs the automated tester for our CS340 Project
 */
public class TesterV2 {
  
  
  // how does static work? who knows, who cares. it does
  static String[] type = new String[10];
  
  
  public TesterV2() {
    
  }
  
  public static void main(String[] args) 
  {
    
    /**
     * Reads in the grammar file name, name of program to test, and number of times to test 
     * now generates multiple parameters with the newGen method
     */
    
    Scanner scan = new Scanner(System.in);  
    String program = args[0];
    String grammar = args[1];
    int numTests = Integer.valueOf(args[2]);
    int l = Integer.valueOf(args[3]);
    
    try
    {
      Generator gen = new Generator(new File(grammar));
     
      for(int j=0; j<l; j++)
      {
        System.out.println("Enter the type of input the program takes: ");
        type[j] = scan.next();
      }
      
      for(int i = 0; i < numTests; i++)
      {
        runProcess("pwd");
        System.out.println("*******");
        String tValue = nextGen(gen, l);
        System.out.println("Testing with value: " + tValue);
        System.out.println("*******");
        runProcess("java " + program + " " + tValue);
        System.out.println("End of test " + (i + 1));
        System.out.println("*******************************");
      }
      
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Unable to find grammar file");
    } catch (Exception e) 
    {
      e.printStackTrace();
    }
    scan.close();
  }
  
  /**
   * allows for multiple parameter generation
   */
  public static String nextGen(Generator gen, int l)
  {
    String termninalInputs = "";
    for(int j=0; j < l; j++)
    {
      if(type[j].equals("string"))
      {
        termninalInputs += gen.generate();
      }
      else if(type[j].equals("double"))
      {
        termninalInputs += gen.generateDouble();;
      }
      else if(type[j].equals("int"))
      {
        termninalInputs += gen.generateInt();
      }
      if(j!= l-1)
      {
        termninalInputs += " ";
      }
    }
    return termninalInputs;
  }
  
  /**
   * This method runs the provided command in the terminal
   * @param command the command to run in the terminal
   * @throws Exception any errors the tested program may throw
   */
  public static void runProcess(String command) throws Exception
  {
    Process pro = Runtime.getRuntime().exec(command);
    pro.waitFor();
    System.out.println(command + " exitValue() " + pro.exitValue());
    //System.out.println("Result of test: " + pro.getOutputStream());
  }
  
}
