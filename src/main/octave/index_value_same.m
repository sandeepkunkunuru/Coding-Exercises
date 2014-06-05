% You are given a sorted (from smallest to largest) array A of n distinct integers which can be positive, negative, or zero. 
% You want to decide whether or not there is an index i such that A[i] = i. Design the fastest algorithm that you can for solving this problem. 

Y = [1:15; -5:8 15; 26:40; -5:9 ]
n = size(Y)

flag = 1;

for i=1:size(Y,1)
	X = Y(i, :);
	index1 = 1;
	index2 = size(Y,2);
	
	while index1 < index2
		index3 = floor((index1 + index2)/2);

		if X(index1) == index1
			index2 = index1;
		elseif X(index2) == index2
			index1 = index2;
		elseif X(index3) == index3
			index1 = index3;
			index2 = index3;
		elseif X(index3) < index3
			if index1 < index3 
				index1 = index3;
			else % because its a floor function in the last test case loop would never end since index1 == index3 eventually creating an infinite loop;
				index1 = -1;
				index2 = -1;
			end
		else
			index2 = index3;
		end
	end


	if index1 == -1
	     "Its not there - case1"
	elseif X(index1) == index1
		X(index1)
	else 
	   "Its not there - case2"
	end
end
