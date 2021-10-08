/**
* @author Ajay Kumar
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Print a palindrome string of length 'N' where N is a positive integer value range 1<=N<=2^32-1
 * With K distinct values 1<=K<=26
 */

public class Palindrome {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the length of the palindrome string needed");
        int length=sc.nextInt();
        System.out.println("Please enter the length of the distinct characters needed");
        int distinct=sc.nextInt();
        
        /*Check for the length of the palindrome possible with the distinct characters
         * A palindrome is a string with same characters at position i and length n-i
         * A maximum of N/2 characters if N is odd and (N/2 +1) if N is even distinct chars can be used to form a palindrome string
         */

       if(length>0 && distinct > 0 && length!=distinct && distinct<=26)
       {
           int palindromeLength=(length%2==0 ? length/2 : ((length/2)+1));
           String result=new String();
           if(distinct<=palindromeLength)
           {
               result=nPalindrome(length,distinct,palindromeLength);
               System.out.println("A palindrome string of length: "+ length + " with " + distinct + " distinct characters formed is : " + result  );
           }
           else
           {
               System.out.println("A palindrome string of length: "+ length + " with " + distinct + " distinct characters cannot be formed"  );
           }
       }
       else
       {
           System.out.println("A palindrome string of length: "+ length + " with " + distinct + " distinct characters cannot be formed as both are equal"  );
       }
    }

    // Fill the "N" length string with Character list of size N/2 (where N is even) or N/2 +1 (N is odd)
    private static String nPalindrome(int length,int distinct, int palindromeLength)
    {
        Character[] resultList= new Character[length];

        ArrayList<Character> aList=palindromeString(distinctArray(distinct),palindromeLength);
            for (int i = 0 ; i < aList.size() ; i++ )
            {
                if(i<=(length-i-1))
                {
                    resultList[i]= aList.get(i);
                    resultList[length-i-1]=aList.get(i);
                }
            }
        return Arrays.asList(resultList).stream().map(i-> String.valueOf(i)).collect(Collectors.joining());
    }

    // Generate  N/2 length arraylist if N is even else (N/2)+1 with distinct characters
    private static ArrayList palindromeString(ArrayList<Character> A,int palindromeLength)
    {
        List<Character> aChar=new ArrayList<Character>();
        aChar=  Collections.nCopies(
                            ((palindromeLength%A.size())==0 ? (palindromeLength/A.size()) :(palindromeLength/A.size())+1),A)
                            .stream()
                            .flatMap(x -> x.stream())
                            .limit(palindromeLength)
                            .collect(Collectors.toList());
        return  new ArrayList<Character> (aChar);
    }
    
    // Get an arrayList of K length with distinct characters
    private static ArrayList distinctArray(int distinct)
    {        ArrayList<Character> array=new ArrayList<Character>();
        IntStream.range(0,distinct).forEach(i->
        {
            array.add(returnChar(array));
        });
        return  array;
    }

    // Generate and return a random non existing alphabet in ArrayList
    private static char returnChar(ArrayList<Character> A)
    {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a');
        while (A.indexOf(randomChar)!=-1)
        {
            randomChar=(char) (random.nextInt(26) + 'a');
        }
        return randomChar;
    }
}
