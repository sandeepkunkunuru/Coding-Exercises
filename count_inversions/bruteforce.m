function num_inversions = bruteforce(X)
	len = size(X, 2);
	num_inversions=0; 
	for i=1:len
		for j=i:len
			if (X(1, i) > X(1, j))
				%X(1, i) > X(1, j)
				num_inversions = num_inversions + 1;
			end
		end
	end

	num_inversions;
endfunction
