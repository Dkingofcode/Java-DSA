package LeetcodeSolutions.Array;
import java.util.*;



 // Brute force solution
public class twoSum {
//     public static int[] twoSum(int[] numbers, int target) {
//         int[] ans = new int[2];
    
//     for(int i = 0; i < numbers.length; i++){
//         for(int j = i + 1; j < numbers.length; j++){
//             if(numbers[j] == target - numbers[i]){
//                 ans[0] = i;
//                 ans[1] = j;
//                 return ans; // Return immediately once the pair is found
//         }
//     }
// }
//    throw new IllegalArgumentException("No two sum solution");
//};


public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < numbers.length; i++){
        int x = numbers[i];
        if(map.containsKey(target - x)){
            return new int[] {map.get(target - x), i};   
        }
        map.put(x, i);
    }
    throw new IllegalArgumentException("No two sum solution");
}



public static void main(String[] args) {
    int[] numbers = {2, 7, 11, 15};
    int target = 22;

    // Create an instance of the TwoSum class
    twoSum solution = new twoSum();
    
    // Call the non-static method using the instance
    int[] result =  solution.twoSum(numbers, target);

    System.out.println("Indices:" + result[0] + ", " + result[1]);
}

} 


