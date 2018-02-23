import java.io.*;
import java.util.Scanner;

/**
 * Tasks read the file by using different readers and using ...Exception in case of it cannot access the file.
 *
 * @author Raksanin Khunamas.
 */

public class Tasks {
    /**
     * readFileToString reads the file by using InputStreamReader and using IOException in case of it cannot access the file.
     *
     * @param filename
     * @return data, an empty String.
     */
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

    /**
     * reading the file by using InputStreamReader and using IOException in case of it cannot access the file.
     * and using the String builder instead of String.
     * @param filename as name of the file.
     * @return result, an empty String.
     */
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
                result.append((char)c);
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

    /**
     * reading the file by using BufferedReader and using IOException in case of it cannot access the file.
     *
     * @param filename as name of the file.
     * @return result, an empty String.
     */
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

    /**
     * Start the application.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        //create stopwatch.
        Stopwatch sw = new Stopwatch();
        //start the stopwatch.
        sw.start();
        String alice = readFileToString("src/Alice-in-Wonderland.txt");
        //stop the stopwatch.
        sw.stop();
        //print the result.
        System.out.println("Reading Alice-in-Wonderland.txt using FileReader, append to String.");
        System.out.printf("Read %d chars in %.6f sec.\n", alice.length(), sw.getElapsed());
        sw.resetTime();
        //start the stopwatch.
        sw.start();
        String alice2 = readFileToStringBuilder("src/Alice-in-Wonderland.txt");
        //stop the stopwatch.
        sw.stop();
        //print the result.
        System.out.println("Reading Alice-in-Wonderland.txt using FileReader, append to StringBuilder.");
        System.out.printf("Read %d chars in %.6f sec.\n", alice2.length(), sw.getElapsed());
        sw.resetTime();
        //start the stopwatch.
        sw.start();
        String alice3 = readFileByBufferedReader("src/Alice-in-Wonderland.txt");
        //stop the stopwatch.
        sw.stop();
        //print the result.
        System.out.println("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String.");
        System.out.printf("Read %d chars in %.6f sec.\n", alice3.length(), sw.getElapsed());

    }
}
