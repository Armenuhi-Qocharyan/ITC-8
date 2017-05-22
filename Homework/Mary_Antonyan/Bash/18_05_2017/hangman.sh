#!/bin/bash

function draw1 {
    echo "________"
}

function draw2 {
    echo "     |"
    echo "     |"
    echo "     |"
    echo "     |"
    echo "_____|__"
}

function draw3 {
    echo "   __ "
    echo "  |  |"
    echo "     |"
    echo "     |"
    echo "     |"
    echo "_____|__"
}

function draw4 {
    echo "   __ "
    echo "  |  |"
    echo " |_| |"
    echo "     |"
    echo "     |"
    echo "_____|__"
}

function draw5 {
    echo "   __ "
    echo "  |  |"
    echo " |_| |"
    echo "  |  |"
    echo " / \ |"
    echo "_____|__"
}

word=0
life=0
while [[ 5 -gt $life && 7 -gt $word ]] 
do
    question=$(( ( RANDOM % 7 )  + 1 ))
    echo "question: $question"
    list=$(sed "${question}q;d" tests.txt)
    echo "list: $list"
    answer=$(sed "${question}q;d" answers.txt)
    echo "answer:  $answer"
    sed "${qusetion}q;d" questions.txt
    
    select l in $list
    do
        echo "l in list: $l"
        case $l in
            "$answer") 
                head -n$word word.txt | paste -sd "" -
                ((word++))
                break
                ;;
            *) 
                case $life in
                    1)
                        draw1
                        ;;
                    2)
                        draw2
                        ;;
                    3)
                        draw3
                        ;;
                    4)
                        draw4
                        ;;
                    5)
                        draw5
                        echo "You Lose!"
                        break
                        ;;
                esac
                ((life++))
        esac
        break
    done
    echo 
    echo
    echo
done
