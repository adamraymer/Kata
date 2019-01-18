Kata2: BabySitter

---- For Running on Windows ----
Unzip zip file
Double click bbskata.bat. This will bring up a command line box that starts the program

---- For Running on Mac ----
Unzip the zip file
At the Bash terminal, go to the directory where bbskata.jar is located.
In the directory that bbskata.jar is located type the command: java -jar bbskata.jar

----Java setup----
Java should be set up and installed before this can run. If you need to install Java please go to
https://www.oracle.com/technetwork/java/javase/downloads/index.html to download the install.

----Note on unzipping and storing the files ----
If Java paths have not been set up bbskata.jar will need to be installed in the same location as java.exe. 
This is ususally C:\Program Files\Java\<java download version>\bin

Setting up Java paths allows Java programs to be run from any directory.

If you would like to set up a path:

To set up the path for Windows 10 copy and paste this link into your browser: https://javatutorial.net/set-java-home-windows-10

To set up the path for Mac copy and paste this link into your browser: https://dalanzg.github.io/tips-tutorials/mac/2016/03/21/how-to-set-java_home-on-mac-os-x/

----Instrustions and Program Operation----
The first question will ask "What family Is this for?". Enter A, B, or C depending on which family you would like to calculate for.
The next two questions are for start and end time. The format is in HH:MM AM/PM. The correct number of characters is 7. Example input
would be 06:00PM. If the hour is two digits, then 10:00PM. If there are too few or too many characters a message will display and ask
you to try again. After both times are entered a total will display. 

Use X to exit at any time. Input is case insensitive.

----Calculation----
Calculation is base on an hour block (no partial hours). If time is started on a fractional hour it will count as 1 hour until
the next hour time. Example: if start time is 5:15 it will be counted as 1 hour from 5:00PM to 6:00PM. If time went from 5:15PM to 6:30PM
that would be 2 hours because two blocks of hours were crossed.

----Java Version----
This program was compiled using Java 11 and written with IntelliJ. The code structure is simple enough it should run with 
Java versions 5 or earlier (if needed) through to Java 11.

----About the Author----
Hello! Thank you for this opportunity. It was a learning experience for me. When I first looked over the assignements I tried to 
think of the best approach for whatever I chose. Even though I still have a lot to learn about Java I chose Java as the language
to use because I knew it could run on most environments easily (I was nervous about trying C++ for that reason) and I knew I 
could set something up for use on a command line (JavaScript I've mainly created HTML interfaces for). I hadn't used IntelliJ 
much and decided to use that as my IDE due to positive feedback from peers. I did find it fairly easy to naivgate to get the job
done. As for the process itself it helped me practice a TDD methodolgy that I can't always use in my current position. I know I
probably made some mistakes on when to commit but I did find the process beneficial. I just need some practice at it. I tried to keep
the code as clean as possible while trying to minimize redundancy. My hope was to create something where each family's calculation
would be independent of another family's (to make changes easier as well as to add new families) and an interface with basic input
checks independent (just in case someone wanted to create a different interface, possibly in a different style). The structure should
be set up in such a way that the classes needed to change are minimal. I hope you find the code easy to read and understandable.

About me: I have been in IT for about 17 years and as a dedicated programmer for about 15. I have used several languages in 
several environments. Now that this is complete I have completed requested projects (beyond school) in the following languages:
C#, PHP, JavaScript, VBAccess, C++ and now Java. I also have a background in SQL and XML. Currently I am trying to study more
in Android interfaces, AWS cloud technology and Python.