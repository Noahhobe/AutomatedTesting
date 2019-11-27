import java.util.*;

public class Generator
{
    private HashMap<String, List<String>> grammar = new HashMap<String, List<String>>();
    public Generator(file grammar)
    {
        Scanner scan = new Scanner(grammar);
        
        while(scan.hasNextLine)
        {
            String[] line = scan.nextLine.split("->");

            if(!grammar.containsKey(line[0]))
            {
                grammar.put(line[0], new List<String>());
            }

            grammar.get(line[0]).add(line[1]);
        }
    }
    /**
    public static void main(String args[])
    {

    } */

    public String generate(String production)
    {
        String result = "";
        
        if(!grammar.containsKey(production))
        {
            throw new IllegalArgumentException("No rule found for string " + production);
        }

        Random Rand = new Random(grammar.get(production).length);
        String[] rule = grammar.get(production).get(rand.next()).split(" ");

        for(int i = 0; i < rule.size; i++)
        {
            Random r = new Random(10);
            if(rule[i].equals("num"))
            {
                result += r.nextInt();
            }
            else if(rule[i].equals("char"))
            {
                result += "a";
            }
            else
            {
                result += generate(rule[i]);
            }
        }
    }
}
