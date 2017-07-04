ls -R | grep "^ani" | grep ".txt$" >result.txt
files=`head -n 3 result.txt`
files="$files `tail -n 3 result.txt`"
rm result.txt
echo $files

for filename in $files
do
    fpath=$(find . -name $filename)
    echo $fpath
    temp=`sort -u $fpath`
    echo "$temp" > "$fpath"
done

