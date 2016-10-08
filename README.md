
# Salesman

A program to find a short path between points (ending at the first point) 
on a flat euclidean plane using nearest insertion.

Written in Java. "salesman.java" is the source code.
"salesman.jar" is a compiled and runnable version of salesman.java.

The way it works is that it starts with any 3 points, then takes a 4th point, 
finds how it can add it in while increasing the travel time by the least, and 
inserts it into the list. Rinse and repeat with 4 points, then 5, etc...

This algorithm works well because the place of insertion of lowest increase in 
a cluster of points will always join the cluster of points together. For instance, 
it successfully joins together the Alaskan cities in the below example.



Exaxmple problem: Short Path Between Major US Cities

Copy-paste the contents of uscities.txt exactly into the program 
and it will find a short path between the cities. NOTE: The uscities.txt 
file uses Unix-style line breaks. Copy-pasting into a Windows CMD or 
PowerShell does not work but copy-pasting into a Linux/Mac Terminal does 
work and also Cygwin on Windows works.

The data comes from https://gist.github.com/ecarter/413343

To find which number corresponds to which city: 
1. Add 3
2. Look at that line number in https://gist.github.com/ecarter/413343

Because the Earth is not a flat plane the total distance is not accurate 
but it should still find at least close to the shortest path possible.



