import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ajay Kumar
 * Get the maximum substring of unrepeated characters from a string
 */
public class MaxUniqSubString {
    public static void main (String[] args)
    {
        String s="XXYDZEFDDSSYY";
        String result=new String();
        for (int i=0; i<s.length()-1 ;i++)
        {
            for(int j=s.length()-1; j>i; j--)
            {
                if(result.length()<(j-i))
                {
                     result= isDistinct(s.substring(i,j))?s.substring(i,j):result;
                }
            }
        }
        System.out.println(result);
    }
    public static Boolean isDistinct(String ss)
    {
        Set<Character> charsSet = ss.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());
        if(charsSet.size()==ss.length())
            {
                return true;
            }
        return false;
    }
}
