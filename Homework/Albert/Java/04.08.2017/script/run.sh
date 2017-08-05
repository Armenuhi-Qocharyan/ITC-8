#!/bin/bash

input="inputOutput/$1"
output="inputOutput/$2"
goutput="inputOutput/$3"

cd ../
javac Main.java
java Main $input $output

if cmp -s $output $goutput
then
   echo "Successfully runned"
else
   echo "The files are different"
fi

