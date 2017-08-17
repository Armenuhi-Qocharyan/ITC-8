#!/bin/bash

javac Main.java
java Main $1 $2
cmp="$(diff $2 goutput.txt)" 
echo $cmp;

if [[ -z $cmp ]] 
then
    echo "OK"
else
    echo "files are different"
fi
