#!/bin/bash

function drawSpaces {
    i=0
    while [ $i -le $1 ]
    do
        printf " "
        (( i++ ))
    done
}

function drawCar {
    echo 
    echo
    echo
    echo
    echo
    echo
    echo
    drawSpaces $1
    echo "     +------------------+"
    drawSpaces $1
    echo "     |It's time to break|"
    drawSpaces $1
    echo "     +------------------+"
    drawSpaces $1
    echo "     |"
    drawSpaces $1
    echo "     |________"
    drawSpaces $1
    echo "    /|   |   |\ "
    drawSpaces $1
    echo " __/ |___|___| \__"
    drawSpaces $1
    echo "|                 |"
    drawSpaces $1
    echo "|    _       _    |"
    drawSpaces $1
    echo "+---/ \-----/ \---+"
    drawSpaces $1
    echo "    \_/     \_/"
}

let length=$1-30
i=0
while [ $i -le $length ]
do
    clear
    drawCar $i
    (( i++ ))
    sleep 0.07
done
