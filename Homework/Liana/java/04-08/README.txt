==Run and test java program using bash script==

There are two scripts. One of them runs java program and checks results only for that program.
Second script finds files with extension .golden in current directory and checks corresponding .output file to have same content.
Main java program reads number from .input file and after increment write it in .output file

--Usage--

To give the script execute permission run the following command:

    chmod +x test.sh
    chmod +x java.sh

Run: 
test.sh:
   ./test.sh
java.sh:
    ./java.sh Main Main.input
