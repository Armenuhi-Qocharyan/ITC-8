#!/bin/bash
drowCar() {
    tab=$1
    printf '%*s' $tab
    echo "|$mesage|"
    
    tab=$1
    printf '%*s' $tab
    echo "______"
    
    let tab=$1-2
    printf '%*s' $tab
    echo  '_/      \__'
 
    let tab=$1-3
    printf '%*s' $tab
    echo  '|___________|'


    let tab=$1-3
    printf '%*s' $tab
    echo  '  |_|   |_| '
}

mkdir ./bla
printf '%s' 'Enter Mesage '
read mesage
for tab in {4..50}
do
    clear
    drowCar $tab
    sleep 0.1
done
