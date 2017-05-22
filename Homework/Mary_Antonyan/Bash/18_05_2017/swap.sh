#!/bin/bash

num=$(wc -l file1.txt | awk '{print$1}')

i=1
while [ "$num" -gt "$i" ]
do
    let j=$i+1
    sed "${i}q;d" file1.txt >> tmp1.txt
    sed "${j}q;d" file2.txt >> tmp1.txt
    sed "${i}q;d" file2.txt >> tmp2.txt
    sed "${j}q;d" file1.txt >> tmp2.txt
    ((i+=2))
done

mv tmp2.txt file2.txt
mv tmp1.txt file1.txt
