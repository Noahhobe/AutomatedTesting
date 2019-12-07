//authors Noah Hoberg - Recorder
//        Levi Neuenschwander - Developer
/**
 *  This class provides represents a string that can be translated to Pig Latin.
 *
 *  The rules are:
 *    1. if a word has no vowels, it stays the same
 *    2. if a word starts with a vowel, add "way" to the end
 *    3. if a word's first vowel is at position i, move all letters up to, but
 *       not including the letter at position i, to the end of the string and
 *       append "ay".
 *
 *  @author  Jim Schnepf, modified by J. Andrew Whitford Holey
 *  @version October 31, 2013
 */
import java.lang.String;

public class PigLatinString
{
  /** The underlying string object. */
  private final String string;

  /**
   * Constructor method to create a new PigLatinString object from an existing
   * String object
   */
  public PigLatinString(String string)
  {
    this.string = string;
  }


  /**
   * Returns true if c is an English vowel.
   *
   * @param c character to determine if it is a vowel
   *
   * @return true if c is a vowel, false otherwise
   */
  private boolean isVowel(char c)
  {
    // convert to lower-case to make comparisons easier
    c = Character.toLowerCase(c);
    
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }


  /**
   * Returns the index of the first vowel in a word, or -1 if there are no
   * vowels.
   *
   * @param s the string from which to find the index of the first vowel
   *
   * @return the index of the first vowel, -1 if s contains no vowels
   */
  private int indexOfFirstVowel(String s)
  {
    for (int i=0; i<s.length(); i++)
    {
      if (this.isVowel(s.charAt(i)))
      {
        return i;
      }
    }

    return -1;
  }


  /**
   * Translates a word in English a Pig Latin.
   *
   * @param word the String containing the word to be translated
   *
   * @return word translated to Pig Latin
   */
  private String translateWord(String word)
  {
    if (indexOfFirstVowel(word) == -1)
    {}
    else if (indexOfFirstVowel(word) == 0)
    {  
      word += "way";
    }
    else
    {
      String frontToBack = word.substring(0,(indexOfFirstVowel(word))) + "ay";
      String newFront = word.substring(indexOfFirstVowel(word)+ 1);
      String firstLetter = word.substring(indexOfFirstVowel(word), indexOfFirstVowel(word)+ 1);
      
      word = newFront + frontToBack;
      word = word.toLowerCase();
      firstLetter = firstLetter.toUpperCase();
      word = firstLetter + word;
      
    }
    return word;
  }
  

  /**
   * Translate a sequence of words from English to Pig Latin.
   *
   * @return a sequence of words in Pig Latin, each translated from the
   *         corresponding word in the English string
   */
  public String translate()
  {
    String result = "";

    for (String word : this.string.split(" "))
    {
      result += this.translateWord(word) + " ";
    }

    return result.trim();
  }
}
