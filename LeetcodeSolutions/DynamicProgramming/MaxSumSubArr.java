package LeetcodeSolutions.DynamicProgramming;

public class MaxSumSubArr {

    public int maxSubArray(int[] A){
     return maxSubArrayHelper(A, 0, A.length - 1);   
    }
   
    private int maxSubArrayHelper(int[] A, int L, int R){
         if(L > R) return Integer.MIN_VALUE;
         int M = (L + R)/ 2;
         int leftAns = maxSubArrayHelper(A, L, M - 1);
         int rightAns = maxSubArrayHelper(A, M + 1, R);
         int LmaxSum = 0;
         int sum = 0;
         for(int i = M - 1; i >= L; i--){
           sum += A[i];
           LmaxSum = Math.max(sum, LmaxSum);  
         }

         int rMaxSum = 0;
         sum = 0;
         for(int i = M + 1; i <= R; i++){
            sum += A[i];
            rMaxSum = Math.max(sum, rMaxSum);
         }

         return Math.max(LmaxSum + A[M] + rMaxSum, Math.max(leftAns, rightAns));
        } 



        // Dynamic Programming
        public int maxSUbArray(int[] A){
            int maxEndingHere = A[0], maxSoFar = A[0];
            for(int i = 1; i < A.length; i++){
                maxEndingHere = Math.max(maxEndingHere + A[i], A[0]);
                maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }
            return maxSoFar;
        }
}
