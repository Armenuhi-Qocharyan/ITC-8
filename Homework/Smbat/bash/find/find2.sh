ls -R | grep "^ani" | grep ".txt$" >result.txt
head -n 3 result.txt >resultt.txt
tail -n 3 result.txt >>resultt.txt
files=$(cat <resultt.txt)

for filename in $files
do
    fpath=$(find . -name $filename)
    echo $fpath
    sort -u $fpath >temp.txt
    cat <temp.txt >$fpath
    cat <$fpath
done
rm result.txt
rm resultt.txt
rm temp.txt
