# Input-Output Tasks
by Raksani Khunamas.

I ran the tasks on a macOS Sierra version 10.12.6 with 2 GHz Intel Core i5,
and got these results:

Reading Alice-in-Wonderland.txt using...
|__________Reader__________|__________Append to__________|__________Time(sec)__________|
|        FileReader        |          String             |          2.588581           |
|        FileReader        |       StringBuilder         |          0.009380           |
|     BuffereReader        |          String             |          0.046017           |


*Console Dialog*
Reading Alice-in-Wonderland.txt using FileReader, append to String.
Read 52539 chars in 2.588581 sec.
Reading Alice-in-Wonderland.txt using FileReader, append to StringBuilder.
Read 52539 chars in 0.009380 sec.
Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String.
Read 52539 chars in 0.046017 sec.


From reading by using different reader (FileReader and BufferedReader),
Filereader is read slower than BufferedReader according to elapsed time.
Why the time is different?
A FileReader class is a general tool to read in characters from a File. The BufferedReader class can wrap around Readers, read line by line. So, Buffered reader will read faster than FileReader.

From reading by using different type of parameter (String and String builder) in the same reader,
Using String builder is read faster than String according to elapsed time.
Why the time is different?

