package LeetcodeSolutions.Array;

public class TwoSumII {
    // public int[] TwoSumII(int[] numbers, int target){
    //     // Assume input is already sorted
    //     for(int i = 0; i < numbers.length; i++){
    //       int j =  bSearch(numbers, target - numbers[i], i + 1);
    //        if(j != -1){
    //            return new int[] {i + 1, j + 1};
    //        }  
    //     }
    //    throw new IllegalArgumentException("No new solution");

    // }



    // private int bSearch(int[] numbers, int key, int start){
    //      int L = start, R = numbers.length - 1;

    //      while(L < R){
    //         int M = (L + R) / 2;

    //         if(numbers[M] > key){
    //              R = M;
    //         }else if(numbers[M] < key){
    //             L = M + 1;
    //          }
    //         }

    //         return (L == R && numbers[L] == key) ? L : -1; 
    //       }


          public int[] twoSumPointer(int[] numbers, int target) {
             // Assume input is already sorted
             int i = 0, j = numbers.length - 1;

             while(i < j) {
               int sum = numbers[i] + numbers[j];
               if (sum < target){
                 i++;
               }else if(sum < target){
                j--;
               }else{
                  return new int[] {i + 1, j + 1};
               }
             }
             throw new IllegalArgumentException("No two sum solution");
          }

          public static void main(String[] args) {
            int[] numbers = {2, 7, 11, 15};
            int target = 22;
        
            // Create an instance of the TwoSum class
            TwoSumII solution = new TwoSumII();
            
            // Call the non-static method using the instance
            int[] result =  solution.twoSumPointer(numbers, target);
        
            System.out.println("Indices:" + result[0] + ", " + result[1]);
        }
        
    }

