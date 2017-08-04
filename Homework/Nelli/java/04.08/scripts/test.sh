#!/bin/bash
javac ../Main.java;
cd ../;
java Main $1 $2;

value1=`cat $2`
value2=`cat $3`

if [ $value1 == $value2 ]
then
    echo "yes test run successfuly"
else
    echo "error"
fi
