#!/bin/bash

ps -aux | awk '{print $2 }' > list.txt
echo "The result is:" > result.txt

while IFS='' read -r line || [[ -n "$line" ]]; do
    if [[ $line == 2* ]]; then
       ps -p $line -o comm= >> result.txt
    fi
done < "list.txt"
