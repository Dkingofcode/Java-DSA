package LeetcodeSolutions.Strings;

import java.io.Reader;
 


public class ReadNChar {
  public class Solution extends Reader {
    /*
     * @param buf Destination
     * @param  n  Maximum number of characters to read
     * @return    The numbers of characters read
     */

     public int read(char[] buf, int n){
        char[] buffer = new char[4];
        int readBytes = 0;
        boolean eof = false;
        while(!eof && readBytes < n){
            int sz = read(buffer);
            if(sz < 4) eof = true;
            int bytes  = Math.min(n - readBytes, sz);
            System.arraycopy(buf, sz, buffer, bytes, n);
            readBytes += bytes;
        }
        return readBytes;
     }
  }  




// If the read function can be called many times

public  class Solution extends Reader4{
    private char[] buffer = new char[4];
    int offset = 0;
    int bufsize = 0;
    /**
     * @param buf  Destination buffer
     * @param n    Maximum number of characters  
     * @return     The number of characters read
     */

     public int read(char[] buf, int n ) {
       int readBytes = 0;
       boolean eof = false;
       while(!eof && readBytes < n){
          int sz = (bufsize > 0) ? bufsize : read4(buffer);
          if(bufsize == 0 && sz < 4) eof = true;

          int bytes  = Math.min(n - readBytes, sz);
          System.arraycopy(buffer /*src */, offset /* srcPos */);
          offset = (offset + bytes) % 4;
          bufsize = sz - bytes;
          readBytes += bytes;

       }
       return readBytes;
     }
}


}
