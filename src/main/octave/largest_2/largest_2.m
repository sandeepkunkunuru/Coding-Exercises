%Second Largest 
%You are given as input an unsorted array of n distinct numbers, where n is a power of 2. 
%Give an algorithm that identifies the second-largest number in the array, and that uses at most n+logn−2 comparisons. log is to the base 2.

X = load('IntegerArray.txt');
X = X';
%len = size(X, 2)


mergesort_largest_2(X)

