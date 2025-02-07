package LeetcodeSolutions.Math;

public class ReverseInt {
    public int reverse(int x){
        int ret = 0;
        while(x != 0){
            // handle overflow/underflow
            if(Math.abs(ret) > 214748364){
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}
