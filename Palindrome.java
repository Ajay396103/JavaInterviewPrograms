import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindrome {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the length of the palindrome string needed");
        int length=sc.nextInt();
        System.out.println("Please enter the length of the distinct characters needed");
        int distinct=sc.nextInt();
        //Check for the length of the palindrome possible with the distinct characters
       if(length>0 && distinct > 0 && length!=distinct)
       {
           int palindromeLength=(length%2==0 ? length/2 : ((length/2)+1));
           System.out.println(palindromeLength);
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
           System.out.println("A palindrome string of length: "+ length + " with " + distinct + " distinct characters cannot be formed"  );
       }


    }
    private static String nPalindrome(int length,int distinct, int palindromeLength)
    {
        Character[] resultList= new Character[length];

        ArrayList<Character> aList=palindromeString(distinctArray(distinct),palindromeLength);
            for (int i = 0 ; i < aList.size() ; i++ )
            {
                if(i<(length-i-1))
                {
                    resultList[i]= aList.get(i);
                    resultList[length-i-1]=aList.get(i);
                }
                else if(i==(length-i-1))
                {
                    resultList[i]= aList.get(i);
                }
            }
        return Arrays.asList(resultList).stream().map(i-> String.valueOf(i)).collect(Collectors.joining());
    }

    private static ArrayList palindromeString(ArrayList<Character> A,int palindromeLength)
    {

        ArrayList<Character> aChar=new ArrayList<Character>();
        if (A.size()==palindromeLength)
        {
            aChar.addAll(A);
        }
        else
        {
            while(aChar.size()<palindromeLength)
            {
                aChar.addAll(A);
            }
            System.out.println(aChar.toString());
            IntStream.range(palindromeLength,aChar.size()).forEach(i->
            {
                aChar.remove(aChar.size()-1);
            });
        }
        System.out.println(aChar.toString());
        return aChar;
    }

    private static ArrayList distinctArray(int distinct)
    {
        ArrayList<Character> array=new ArrayList<Character>();
        IntStream.range(0,distinct).forEach(i->
        {
            array.add(returnChar(array));
        });
        return  array;
    }

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
