#!/bin/bash
if  [ -z "$1" ] || [ -z "$2" ]
then
    echo "No arguments supplied"
else
    output=$(basename "$2" .input)
    java $1 $2 $output.output
    cmp --silent $output.golden $output.output && echo '### SUCCESS: Good reults! ###' || echo '### WARNING: results are different! ###'
fi
