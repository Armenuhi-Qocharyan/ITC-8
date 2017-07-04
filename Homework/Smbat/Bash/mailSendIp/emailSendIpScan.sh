#!\bin\bash
if hash sendemail 2>/dev/null 
then
    echo
else
    echo please install sendMail
    sudo apt-get install sendemail
fi

if hash nmap 2>/dev/null 
then
    echo
else
    echo please install nmap
    sudo apt-get install nmap
fi


nmap 172.21.30.* >ips.txt

FROM=smbat.dallakyan@gmail.com
TO=smbat.dallakyan@gmail.com
SERVER=smtp.gmail.com:587
USER=smbat.dallakyan@gmail.com
PASS=ghsg7891
MESAGEFILE=./ips.txt
SUBJECT="Subject Text"

sendemail -l email.log -f $FROM -u $SUBJECT -t $TO -s $SERVER  -o tls=yes  -xu $USER  -xp $PASS -o message-file=$MESAGEFILE
