#!/bin/bash

echo "Welcome, Mary!"
echo "Last login: "
last -n1 | awk '{print $4, $5, $6, $7}' | head -n1 

