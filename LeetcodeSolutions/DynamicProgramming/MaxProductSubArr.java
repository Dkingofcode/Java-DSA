package LeetcodeSolutions.DynamicProgramming;

public class MaxProductSubArr {
    
    public int maxProduct(int[] A){
        assert A.length > 0;
        int max = A[0], min = A[0], maxAns = A[0];
        for(int i = 1; i < A.length; i++){
            int maximum = max, minimum = min;
            maximum = Math.max(Math.max(A[i], maximum * A[i]), minimum * A[i]);
            minimum = Math.min(Math.min(A[i], maximum * A[i]), minimum * A[i]);
            maxAns = Math.max(maximum, maxAns);
        }
        return maxAns;
    }
}
