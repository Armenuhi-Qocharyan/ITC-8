#!/bin/bash


#Function for creating archives
function archive { 
    for file in $files
    do
        name=$(basename $file)
        sudo $1 $2 "$name.$1" $file
    done
}


#Find all files greater then 20mB
sudo find /home -size +20M -exec ls -S1 {} + > list.txt

#Get all files into list
declare -a files=$(cat list.txt)

#Prepare result.txt for being human-readable
echo "All files which sizes are greater then 20MB" | tee result.txt 
echo "File Name     :   Lines   :   Words" | tee -a result.txt

#Send file name, line and word counts to result.txt
for file in $files
do
    lines=$(wc -l < $file)
    words=$(wc -w < $file)
    echo "$file     :   $lines      :   $words" | tee -a result.txt
done

#Copy files to another directory
path=~/Desktop/Archives
mkdir $path
for file in $files
do
    sudo cp $file $path
    echo "Copying $file to $path"
done

#Archive all files
echo "Enter archive extension (zip / tar.gz): "
read format

case $format in
    "zip")
        cd $path
        archive "zip" 
        ;;
    "tar.gz")
        cd $path
        archive "tar" "-zcvf"
        ;;
    *)
        echo "Unknown archive extension"
        ;;
esac
