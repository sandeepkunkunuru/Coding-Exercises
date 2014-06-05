function largest_2_nums = mergesort_largest_2(X)
	len = size(X, 2); % number of columns
	temp = floor(len/2); % median
	
	largest_2_nums =zeros(2); 

	
        if temp >= 2
		X1 = X(1, 1:temp);
		X2 = X(1, (temp + 1):end);

	        largest_2_nums1 = mergesort_largest_2(X1);
		largest_2_nums2 = mergesort_largest_2(X2);
		
		largest_2_nums = zeros(1, 2);

		if largest_2_nums1(1,1) > largest_2_nums2(1,1)
			largest_2_nums(1,1) = largest_2_nums1(1,1);
			largest_2_nums(1,2) = largest_2_nums2(1,1);
		else 
			largest_2_nums(1,1) = largest_2_nums2(1,1);
			largest_2_nums(1,2) = largest_2_nums1(1,1);

		end
	else
		 if X(1,1) > X(1,2)
			largest_2_nums(1,1) = X(1,1);
			largest_2_nums(1,2) = X(1,2);
		  else 
			largest_2_nums(1,1) = X(1,2);
			largest_2_nums(1,2) = X(1,1);
		  end	
	end	
endfunction
