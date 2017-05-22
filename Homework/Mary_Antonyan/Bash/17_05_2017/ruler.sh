#!/bin/bash

#execute like this:
#  bash ruler.sh $COLUMNS

#Function draws line, recieves length of the line, 
#symbols in the line,
#the first and the last symbols in the line
function drawLine {
    printf "$3"
    i=0
    while [ $i -lt $1 ]
    do
        printf "$2"
        ((i++))
    done
    echo "$3"
}

#Functions draws scale of ruler
function drawScale {
    printf "|"
    j=0
    i=0
    while [ $i -lt $1 ]
    do
        if (( $i % 10 == 0 ))
        then 
            printf $j
            ((j++))
        else 
            printf "."
        fi
        ((i++))
    done
    echo "|"
}

#Main function draws ruler using the other functions
function main {
    drawLine $1 "-" "+"
    drawLine $1 " " "|"
    drawScale $1
    drawLine $1 "-" "+"
}

#execute main function with the necessary length
let length=$(( $1 - 2 ))
main $length
