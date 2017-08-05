1) Description.
    This programm simulates testing mechanism for java project.
    You need to run the script and set the input parameters (input.txt, output.txt,goutput.txt.)
    The program will read data from input.txt file and will write result in output.txt file.
    If the contents of output.text and output.text files match mean the test run successfully.
.

2) How to build.

    cd script direction
    run command
        $ bash run.sh input.txt output.txt goutput.txt 


3) Folder structure.
    ├── inputOutput
    │   ├── goutput.txt
    │   ├── input.txt
    │   └── output.txt
    ├── Main.java
    ├── ReadWrite
    │   └── ReadWrite.java
    └── script
        └── runMain.sh
