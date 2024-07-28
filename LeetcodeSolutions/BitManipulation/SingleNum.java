package LeetcodeSolutions.BitManipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNum {
    
    // Using HashMap
    public int SingleNum(int[] A){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : A){
            int count = map.containsKey(i) ? map.get(i): 0;
            map.put(i, count + 1);
        }
        for(int i : A){
            if(map.get(i) == 1){
                return i;
            }
        }
        throw new IllegalArgumentException("No single number");
    }

    
    // Using Set
    public int singleNumber(int[] A){
        Set<Integer> set = new HashSet<>();
        for(int i : A){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        return set.iterator().next();
    }


     // Using Bit Manipulation(XOR)
     public int SingleNumber(int[] A){
        int num = 0;
        for(int i : A){
            num ^= i;
        }
        return num;
     }


}
