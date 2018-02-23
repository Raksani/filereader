import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppendStringBuilderTask implements Runnable{
    private long size;

    public static String readFileToStringBuilder(String filename) {
        //create a String for the data to read.
        StringBuilder result = new StringBuilder();
        InputStream in = null;
        try {
            //open the file.
            in = new FileInputStream(filename);
            //read as characters.
            InputStreamReader reader = new InputStreamReader(in);
            //read the file.
            int c;
            while ((c = reader.read()) >= 0) {
                result.append((char) c);
            }
            //in case of getting wrong directory it will print caution text out.
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //return String.format("Could not access file %s", filename);
        }
        if (in != null) try {
            //close the file.
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public void run() {
        String data = readFileToStringBuilder("src/Alice-in-Wonderland.txt");
        size = data.length();
    }

    @Override
    public String toString() {
        return String.format("Read file 1-char at a time to String : read %d chars", size);
    }
}
