package xblayz.hashapp;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.ArrayUtils;

public class HashFinder implements Runnable {
    private final int n;        // Number of characters
    private final byte cMin;    // Byte representation of the first character
    private final int d;        // Number of 0 that the string must have
    private final String zeros;
    private final byte[] s;     // Byte array of the S string

    private final long end;     // Ending index of the search space

    private long index;         // Index of the last tested K string
    private int lastKLen = 0;   // Length of the last K string
    private long strOffset;     // Number of string with length less then the length of the current K string

    public HashFinder(int n, byte cMin, int d, String s, long start, long end) {
        this.n = n;
        this.cMin = cMin;
        this.d = d;
        this.zeros = new String(new char[this.d]).replace('\0', '0');
        this.s = s.getBytes();

        this.end = end;
        this.index = start;
    }

    @Override
    public void run() {
        while (this.index <= end) {
            byte[] str = ArrayUtils.addAll(this.s, this.getNextK());    // Concatenation of the S and K string

            String t = new DigestUtils(MessageDigestAlgorithms.SHA3_256).digestAsHex(str);  // Hashing of S+K

            if(t.substring(0, this.d).equals(this.zeros)){   // Check of the problem condition
                System.out.println(t);
                break;
            }
        }
    }

    private byte[] getNextK() {
        int len = this.kLen();          // Calcolate the length of the index-th string K
        byte[] b = new byte[len];       // Initializing byte array

        if(this.lastKLen != len){                               // Check if the new string to generate is longer of the previous
            this.strOffset = geometricSeries(this.n, len-1);    // Set the offset to the number of string with length from 1 to len-1
            this.lastKLen = len;                                // Set the new previous string length
        }

        long a = index - 1 - this.strOffset;    // Number of the string with length len to calculate
        for(int i=0; i<len; i++){
            if(a <= 0)
                b[i] = this.cMin;                       // Fill the empty space with the cMin character

            // Calculate the character of the position i using the formula for changing base to a number
            b[i] = (byte)((a % this.n) + this.cMin);
            a /= this.n;
        }
        this.index++;   // Increment the index

        return b;
    }

    private int kLen() {
        int p = 1;
        long minIndex = 1;                              // Index of the first string of length 1
        long maxIndex = geometricSeries(this.n, p);     // Index of the last string of length 1

        while (true) {
            if(this.index >= minIndex && this.index <= maxIndex) break;     // Check if index is of the string of length p 

            p++;                                    // Try next p
            // Set new bound
            minIndex = maxIndex;
            maxIndex = geometricSeries(this.n, p);
        }
        return p;
    }

    public static long geometricSeries(int n, int p) {
        return (long)((n - Math.pow(n, p+1)) / (1-n));  // Geometric series formula
    }
}
