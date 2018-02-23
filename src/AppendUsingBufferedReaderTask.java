import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppendUsingBufferedReaderTask implements Runnable {
    private long size;

    public static String readFileByBufferedReader(String filename) {
        String result = "";
        try {
            //open the file.
            //announce the reader as a BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            //read line by line except empty line of flie.
            String readline = reader.readLine();
            while (readline != null) {
                result = result + readline + '\n';
                readline = reader.readLine();
            }
            //in case of getting wrong directory it will print caution text out
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void run() {
        String data = readFileByBufferedReader("src/Alice-in-Wonderland.txt");
        size = data.length();
    }

    @Override
    public String toString() {
        return String.format("Read file 1-char at a time to String : read %d chars", size);
    }
}
