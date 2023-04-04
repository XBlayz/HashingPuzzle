package xblayz;

import java.time.Duration;
import java.time.Instant;

public class Timer {
    public Instant start;
    public Instant end;

    public Timer(){
        this.start = Instant.now();
    }

    public void endTimer() {
        this.end = Instant.now();
        System.out.println(Duration.between(start, end));
    }
}
