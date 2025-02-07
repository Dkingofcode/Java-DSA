// Two Iterations

package LeetcodeSolutions.Strings;

/**
 * longestSubWithoutRepeatChar
 */
public class longestSubWithoutRepeatChar {    

    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
    int i = 0, maxLen = 0;
for(int j = 0; j < s.length(); j++){
    while(exist[s.charAt(j)]){
        exist[s.charAt(i)] = false;
    i++; 
}
exist[s.charAt(j)] = true;
maxLen = Math.max(j - i + 1, maxLen);
}
return maxLen;
}




// One Iteration
public int lengthoflongestSubstringK (String s){
    int [] count = new int[256];
int i = 0, numDistinct = 0, maxLen = 0;
for(int j = 0; j < s.length(); j++){
    if(count[s.charAt(j)] == 0) numDistinct++;
count[s.charAt(j)]++;
        while(numDistinct > 2){
            count[s.charAt(i)]--;
        if(count[s.charAt(i)] == 0) numDistinct--;
    i++;
}
maxLen = Math.max(j - i + 1, maxLen);
}
return maxLen;
}

}