#!/bin/sh
rm -f response.html
wget $1 -o response.html
grep -qs "401 Unauthorized" response.html
OUT=$?
if [ $OUT -eq 0 ];then
   echo "$1 is up"
   exit 0
else
   echo "$1 is down"
   exit 1
fi
