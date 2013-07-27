# Based on http://www.statsvn.org/
# Versions of the project are 5,6,7

# seq would generate 5,6,7
for i in $(seq 5 7); do

   rm -rf report-Version-$i
   mkdir report-Version-$i
   
   cd Version-$i
   svn update
   svn log -v --xml > ../report-Version-$i/logfile.log

   cd ../report-Version-$i
   java -jar ../statsvn.jar logfile.log ../Version-$i

   cd ..

done
