import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppendStringTask implements Runnable {
    private long size;


    public static String readFileToString(String filename) {
        //create a String for the data to read.
        String data = new String();
        InputStream in = null;
        try {
            //open the file.
            in = new FileInputStream(filename);
            //read as characters.
            InputStreamReader reader = new InputStreamReader(in);
            //read the file.
            int c;
            while ((c = reader.read()) >= 0) {
                data = data + (char) c;
            }
            //in case of getting wrong directory it will print caution text out.
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //return String.format("Could not access file %s", filename);
        }
        if (in != null) try {
            //close the file
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    @Override
    public void run() {
        String data = readFileToString("src/Alice-in-Wonderland.txt");
        size = data.length();
    }

    @Override
    public String toString() {
        return String.format("Read file 1-char at a time to String : read %d chars", size);
    }
}
