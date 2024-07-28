package LeetcodeSolutions.Strings;

public class ImplstrStr {
    public int strStr(String hayStack, String needle) {
       for(int i = 0; i < hayStack.length(); i++){
        for(int j = 0; j < needle.length(); j++){
            if(j == needle.length()) return i;
            if(i + j == hayStack.length()) return -1;
            if(needle.charAt(j) != hayStack.charAt(i + j)) break;
        }
       }

       return -1;
    }
}
