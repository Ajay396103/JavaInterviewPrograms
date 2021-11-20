import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/*
  Problem: Print the maximum value from the collection where N repeats N times in the collection.
 */
public class NTimesN {
    public static void main(String[] args)
    {
        // Input
        Integer[] A={2,3,3,4,3};
        // To collect the maximum matching
        int result=0;
        //Conversion to List for usage of default methods.
        ArrayList<Integer> total = (ArrayList<Integer>) Arrays.asList(A).stream().map(i-> (new Integer(i))).collect(Collectors.toList());
        for (int i=0;i<A.length;i++)
        {
            // Skipping if A[i] element is less than result as we need to check if any of the value greater than result is repeating it's times
            if(result < A[i] )
            {
                ArrayList<Integer> total1=new ArrayList<Integer>();
                total1.addAll(total);
                total1.removeAll(Collections.singleton(A[i]));
                if(A[i]==(total.size()-total1.size()))
                {
                    result = result > A[i] ? result:A[i];
                }
            }
        }
        System.out.println(result);
    }
}
