#!/bin/bash

sudo find /home -name "Ani*.txt" > list.txt

declare list
list=$(head -n3 list.txt)
list+=" "
list+=$(tail -n3 list.txt)

for file in ${list[@]}
do
    sort -u $file --output=$file
done
