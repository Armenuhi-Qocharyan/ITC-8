#!/bin/bash
clear
printf '%s\n' 

# 1-st line
printf '%s' ' '
printf '%*s\n' 51 | tr " " "-"

# 2-nd line
printf '%s' '|' 
printf '%*s' 51
printf '%s\n' '|' 

# 3-th line
printf '%s' '|'  
for santi in {0..4} 
do
    printf '%s' "$santi         "
done
printf '%s\n' '5|' 

# 4-th line
printf '%s' '||'  
for santi in {0..4} 
do
    printf '%s' "         |"
done
printf '%s\n' '|' 

# 5-th line
printf '%*s\n' 53 | tr " " "|"

# 6-th line
printf '%s' ' '
printf '%*s\n\n' 51 | tr " " "-"
