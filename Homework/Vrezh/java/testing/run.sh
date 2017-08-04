#!/bin/bash/

javac Main.java 

java Main $1 $2

output=$(< ${2})
golOutput=$(< ${3})

printf "Output is : \n"
echo "${output}"

printf "\nGolden Output is : \n"
echo "${golOutput}"

if [ "$output" == "${golOutput}" ]; then 
    printf "\n----Testing successful-----\n"
else 
    printf "\n----Testing failure----\n"
fi


