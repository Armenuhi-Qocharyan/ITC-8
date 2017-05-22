#!/bin/bash

sudo ssh -tt student@172.21.30.106 << EOF
cd ~/
./zombie &   
./getZombie.sh
exit
EOF

#./zombie - c++ project which creates zombie process
#./getZombie.sh - script whixh finds and prints zombie process ID
# both this files must be copied on remote host e.g via scp
