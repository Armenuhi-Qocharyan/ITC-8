process=$(ps ax | awk '{print $1}' | grep "^5")
for curentProc in $process
do
        echo "$curentProc $( ps -p $curentProc -o comm= )"
done
