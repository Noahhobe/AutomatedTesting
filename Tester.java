import java.util.*;
import java.io.*;
public class Tester {

 public Tester() {

 }

 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter a file path for a grammar: ");
  String grammar = scan.next();
  System.out.println("Enter the file path of a java program ");
  String program = scan.next();
  System.out.println("How many times would you like to test?");
  int numTests = scan.nextInt();
  
  try
  {
  Generator gen = new Generator(new File(grammar));
  
  for(int i = 0; i < numTests; i++)
  {
  
  }
  runProcess("pwd");
  System.out.println("*******");
  String testValue = gen.generate();
  System.out.println(testValue);
  System.out.println("*****");
  runProcess("java -cp " + program + " " + testValue);
  }
  catch(FileNotFoundException e)
  {
   System.err.println("Unable to find grammar file");
  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 public static void runProcess(String command) throws Exception
 {
  Process pro = Runtime.getRuntime().exec(command);
  pro.waitFor();
  System.out.println(command + " exitValue() " + pro.exitValue());
 }
}
