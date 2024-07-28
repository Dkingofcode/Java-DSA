package LeetcodeSolutions.Strings;

public class LongestPalindromSub {
    
    // Brute force - O(n^3)  O(1) space
    public String longestPalindrome (String s){
       for(int i = 0; i < s.length(); i++){
         for(int j = i + 1; j < s.length() - 1; j++){
            if(s.charAt(i) + s.charAt(j) == s.charAt(j) + s.charAt(i)){
                j++;
            }else{
                i++;
                j++;
            }
         }
       }   
       return "";
    }

   // Dynamic Programming - O(n^2) O(n) space
   public String longestPalindromeDP (String s){
    int i = 0;
    int j =s.length();
    String result = "";
    if(i == s.length()){
        return "";
    }

   if( isPalindrome(i, i)){
        return ;
    }

    if(isPalindrome(i, i + 1)){
        return
    }

   }


   // Using the center - O(n^2) runtime, O(1) space
   public String longestPalindromeSimple(String s){
      int start = 0, end  =0;
      for(int i = 0; i < s.length(); i++){
        int len1 = expandAroundCenter(s, i , i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if(len > end - start){
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }  
      }
      return s.substring(start, end+ 1);
   }

   private int expandAroundCenter(String s, int left, int right){
      int L = left, R =  right;
      while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
          L--;
          R++;
      }
      return R - L - 1;
   }
}
