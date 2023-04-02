package xblayz;

import xblayz.hashapp.HashFinder;

/**
 * Hashing puzzle (Stefano Scarcelli)
 */
public class App {
    public static void main(String[] args) {
        int nThread = 16;
        long maxS = HashFinder.geometricSeries(36, 6);

        Thread[] threads = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(new HashFinder(36, (byte)58, 7, "SisOp-Course A-Hashing-Puzzle-", (i)*(maxS/nThread)+1, (i+1)*(maxS/nThread)));
            threads[i].start();
        }
    }
}