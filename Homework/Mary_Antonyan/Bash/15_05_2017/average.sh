#!/bin/bash

sum=0
count=0
read -p "a = " a

while [ $a -lt 1000 ]
do
    ((sum+=$a))
    ((count++))
    ((a+=10))
done

let avg=$sum/$count
echo "avg = $avg"
echo 'avg = ' $avg 

