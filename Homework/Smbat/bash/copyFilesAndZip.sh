if [ "$1" != "zip" ] && [ "$1" != "tar" ]
then
    echo "Please Write In parametr <zip> or <tar>"
    exit
fi

find ~/ -size +100M >temp.txt
paths=$(cat <temp.txt)

mkdir ~/scriptworkspace
mkdir ~/scriptworkspace/filesforzip

for path in $paths
do
    echo $path
    cp $path ~/scriptworkspace/filesforzip/
done

if [ "$1" = "zip" ]
then
    zip  ~/scriptworkspace/result.zip ~/scriptworkspace/filesforzip/*
    rm -rf ~/scriptworkspace/filesforzip
else
    tar czf ~/scriptworkspace/result.tar.gz ~/scriptworkspace/filesforzip/*
    rm -rf ~/scriptworkspace/filesforzip
fi
