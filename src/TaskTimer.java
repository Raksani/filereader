public class TaskTimer {
    public static void run(Runnable runnable){
        Stopwatch sw = new Stopwatch();
        sw.start();
        runnable.run();
        sw.stop();
        System.out.printf(runnable.toString() + "\nTime using: %.4f sec.\n",sw.getElapsed());

    }
}
