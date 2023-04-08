package xblayz;

import xblayz.hashapp.HashFinder;

/**
 * Hashing puzzle (Stefano Scarcelli)
 */
public class App {
    public static void main(String[] args) {
        //Args:
        //  [0]: S
        //  [1]: D
        //  [2]: n_thread

        App.solvePuzzle("SisOp-Course A-Hashing-Puzzle-", 7, 6, 36, new String(":").getBytes()[0]);
        // Testing:
        // App.solvePuzzle(args[0], Integer.parseInt(args[1]), 6, 36, new String(":").getBytes()[0], Integer.parseInt(args[2]));
    }

    public static void solvePuzzle(String s, int d, int maxKLen, int nChar, byte firstChar) {
        App.solvePuzzle(s, d, maxKLen, nChar, firstChar, Runtime.getRuntime().availableProcessors()*2);
    }

    public static void solvePuzzle(String s, int d, int maxKLen, int nChar, byte firstChar, int nThread) {
        Timer timer = new Timer();

        long maxStrIndex = HashFinder.geometricSeries(nChar, maxKLen);
        ThreadGroup hashFGroup = new ThreadGroup("HashFinders");

        Thread[] threads = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(
                hashFGroup,
                new HashFinder(nChar, firstChar, d, s, (i)*(maxStrIndex/nThread)+1, (i+1)*(maxStrIndex/nThread), timer)
            );
            threads[i].start();
        }
    }
}