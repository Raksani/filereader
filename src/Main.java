public class Main {
    public static void main(String[] args){

        TaskTimer taskTimer = new TaskTimer();
        taskTimer.run(new AppendStringTask());
        taskTimer.run(new AppendStringBuilderTask());
        taskTimer.run(new AppendUsingBufferedReaderTask());
    }
}
