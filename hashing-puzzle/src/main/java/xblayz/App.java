package xblayz;

import xblayz.hashapp.HashFinder;

/**
 * Hashing puzzle (Stefano Scarcelli)
 */
public class App {
    public static void main(String[] args) {
        int nThread = 16;
        long maxS = (36 - (long)Math.pow(36, 8))/(1-36);

        Thread[] threads = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(new HashFinder(36, (byte)58, 4, "SisOp-Course A-Hashing-Puzzle-", (i)*(maxS/nThread)+1, (i+1)*(maxS/nThread)));
            threads[i].start();
        }
    }
}
