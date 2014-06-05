%[Posted July 1st] You are a given a unimodal array of n distinct elements, meaning that its entries are in increasing order up until its maximum element, after which its elements are in decreasing order. Give
% an algorithm to compute the maximum element that runs in O(log n) time.

Y = [1 2 3 5 6 7 8 12 13 20 19 18 17 16 15; 1:15; 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1; 3 5 8 45 33 23 22 21 17 12 9 4 2 1 -1]
n = size(Y)

flag = 1;

for i=1:size(Y,1)
	X = Y(i, :);
	index1 = 2;
	index2 = size(Y,2) - 1;
	
	while index1 < index2
		index3 = floor((index1 + index2)/2);

		if X(index1 -1) > X(index1)
			index2 = index1 - 1;
			index1 = index2;
		elseif X(index2) < X(index2 + 1)
			index2 = index2 + 1;
			index1 = index2;
		elseif X(index3) > X(index3-1) && X(index3) > X(index3 + 1)
			index1 = index3;
			index2 = index3;
		elseif X(index3) > X(index3-1) && X(index3) < X(index3 + 1)
			index1 = index3;
		else
			index2 = index3;
		end
	end

	X(index1)
end
