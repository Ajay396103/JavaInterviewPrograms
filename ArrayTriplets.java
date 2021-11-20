import java.util.*;

/**
 * @author Ajay Kumar
 * Find all distinct triplets from the given array to form a given sum
 * complexity O(n^3)
 */
public class ArrayTriplets {
    public static void main (String[] args)
    {
        Integer[] arraySum= {1,0,-1,-2,2,1};
        int sum=0;
        Set<ArrayList<Integer>> results= new HashSet<ArrayList<Integer>>();
        for (int i =0;i< arraySum.length-2;i++)
        {
            for (int j =i+1;j< arraySum.length-1;j++)
            {
                for (int k=j+1;k<arraySum.length;k++)
                {
                    if(sum==(arraySum[i]+arraySum[j]+arraySum[k]))
                    {
                        ArrayList<Integer> Sumres=new ArrayList<Integer>(Arrays.asList(new Integer[]{arraySum[i], arraySum[j], arraySum[k]}));
                        Collections.sort(Sumres);
                        results.add(Sumres);
                    }
                }
            }
        }
        System.out.println(results.toString());
    }
}
