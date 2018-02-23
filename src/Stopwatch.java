public class Stopwatch {
    /**
     * @author Raksani Khunamas.
     */
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    public Stopwatch() {


    }

    public void start() {

        this.startTime = System.nanoTime();
        this.running = true;
    }

    public void stop() {
        this.stopTime = System.nanoTime();
        this.running = false;

    }

    public boolean isRunning() {

        return this.running;
    }

    public double getElapsed() {


        if (running) return (System.nanoTime() - startTime) * (1.0E-9);
        else return (stopTime - startTime) * (1.0E-9);
    }

    public void resetTime() {
        this.startTime = 0;
        this.stopTime = 0;
        this.running = false;
    }
}
