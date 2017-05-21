#!/bin/bash
read -p " enter month " month
case $month in
    1)
        echo january
        ;;
    2)
        echo february
        ;;
    3)
        echo march
        ;;
    4)
        echo april
        ;;
    5)
        echo may
        ;;
    6)
        echo june
        ;;
    7)
        echo july
        ;;
    8)
        echo august
        ;;
    9)
        echo september
        ;;
    10)
        echo october
        ;;
    11)
        echo november
        ;;
    12)
        echo december
        ;;
    *)
        echo wrong month
        ;;
esac
