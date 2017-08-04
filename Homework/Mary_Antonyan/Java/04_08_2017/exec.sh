#!/bin/bash

# Compile java code
javac Java/Main.java 

input="Files/$1";
output="Files/$2";
goutput="Files/$3";

# Check compilation exit code
if [ $? -eq 0 ]
then
    java Java/Main $input $output $goutput
    diff $output $goutput > Files/diff.txt

    if [ -s Files/diff.txt ]
    then
        echo "Testing failed. See diff file for more information." 
        cat Files/diff.txt
    else 
        echo "Testing passed successfully!"
    fi

    rm Java/*.class
fi
