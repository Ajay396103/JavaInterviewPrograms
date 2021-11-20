import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * @author Ajay Kumar
 * Fibonacci using Int Stream
 */
public class Fibonacci {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the length of the values of fibonacci sequence to be generated in 0 to Max integer Value: ");
        try
        {
            int length=sc.nextInt();
            ArrayList<Integer> fibonacci=new ArrayList<Integer>();
            fibonacci.add(0);
            if(length>1)
            {
                fibonacci.add(1);
            }
            if(length>2)
            {
                IntStream.range(2,length).forEach(i->{
                    fibonacci.add(fibonacci.get(i-2)+ fibonacci.get(i-1));
                });
            }
            StringJoiner joiner = new StringJoiner("  ");
            for (Integer integer : fibonacci) {
                joiner.add(String.valueOf(integer));
            }
            System.out.println(joiner.toString());

        }
        catch(InputMismatchException ief)
        {
            System.out.println(ief.getCause().toString());
        }

    }
}
