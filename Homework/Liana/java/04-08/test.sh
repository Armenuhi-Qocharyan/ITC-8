#!/bin/bash
for i in *.golden;
do
    golden=$i
    result=$(basename "$i" .golden)
    cmp --silent $golden $result.output && echo "### SUCCESS: Good reults for $result! ###"  || echo "### WARNING: results for $result are wrong! ###"
done

