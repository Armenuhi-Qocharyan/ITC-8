clear
printf '%s\n' 

# 1-st line
printf '%s' ' '
for column in {0..50}
do
    printf '%s' -
done
printf '%s\n'

# 2-nd line
printf '%s' '|' 
for column in {0..50} 
do
    printf '%s' ' ' 
done
printf '%s\n' '|' 

# 3-th line
printf '%s' '|'  
for column in {0..50} 
do
    if ((column % 10 == 0))
    then
        printf '%s' $((column / 10)) 
    else
        printf '%s' ' '
    fi
done
printf '%s\n' '|' 

# 4-th line
printf '%s' '|'  
for column in {0..50} 
do
    if ((column % 10 == 0))
    then
        printf '%s' '|'
    else
        printf '%s' ' '
    fi
done
printf '%s\n' '|' 

# 5-th line
printf '%s' '|'  
for column in {0..100} 
do
    if ((column % 2 == 0))
    then
        printf '%s' '|'
    #else
       # printf '%s' '.'
    fi
done
printf '%s\n' '|'


# 6-th line
printf '%s' ' '
for column in {0..50}
do
    printf '%s' -
done
printf '%s\n\n'
