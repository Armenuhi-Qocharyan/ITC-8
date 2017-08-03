
countLineOfFile=$(wc -l < "first.txt")
#echo $countLineOfFile
for ((i=1; i<=$countLineOfFile; i+=2))
do
    ((ii= $i+1))
    temp1=$(sed -n "${i}{p}" first.txt)
    temp2=$(sed -n "${ii}{p}" second.txt)
    sed -i "$i s/.*/$temp2/" first.txt
    sed -i "$ii s/.*/$temp1/" second.txt
done

