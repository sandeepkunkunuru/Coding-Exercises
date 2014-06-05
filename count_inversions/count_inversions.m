%Count inversions 

X = load('IntegerArray.txt');
X = X';
%len = size(X, 2)

rand_indices = randperm(100);

test = 0;

format long

for i=1:100
	Y = X(1, 1:rand_indices(i));
	%size(Y)

	num1 = bruteforce(Y);

	[Y, num_inversions] = mergesort_count_inversions(Y);

	num_inversions;

	test = num1 - num_inversions;

	if test 
		"Test failed"
		i = 1000;
	end
end

if test == 0
	[Y, num_inversions] = mergesort_count_inversions(X);

	num_inversions
	Y(1, 99998)
end
