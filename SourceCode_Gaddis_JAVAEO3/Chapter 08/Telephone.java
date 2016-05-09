/**
 * The Telephone class's format method accepts a string
 * containing an unformatted telephone number, such as:
 *
 * 9195551212
 *
 * The method returns a copy of the string with parentheses
 * inserted around the area code and a hyphen inserted
 * after the prefix. For example:
 *
 * (919)555-1212
 */

public class Telephone
{
   public static String format(String number)
   {
      // Create a StringBuilder object initialized with
      // the number parameter.
      StringBuilder str = new StringBuilder(number);

      // Insert parentheses around the area code.
      str.insert(0, '(');
      str.insert(4, ')');

      // Insert a hyphen after the prefix.
      str.insert(8, '-');

      // Return the formatted number as a string.
      return str.toString();
   }
}
