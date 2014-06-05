% pivot_loc_indicator == 0 if pivot is 1
% pivot_loc_indicator == 1 if pivot is last element in the sub array
function Y = quick_sort(pivot_loc_indicator, start_index, end_index)
	global X;
	Y = 0;
	if start_index >= end_index	  
	  return;
	end
	
	len = end_index - start_index + 1;

	if pivot_loc_indicator == 1 % if last element in the subarray is to be considered as the pivot
	 temp = X(1, start_index);
	 X(1, start_index) = X(1, end_index);
	 X(1, end_index) = temp;
	end

	Y = len - 1;
        pivot_location = start_index;	
	pivot = X(1, pivot_location);
	index1 = pivot_location;

	for i=(start_index + 1):end_index
	  if X(1, i) < pivot
	    temp = X(1, index1);
	    X(1, pivot_location) = X(1, i);
	    X(1, i) = pivot;

	    pivot_location = i;
	    pivot = X(1, pivot_location);
	  end
	end

	Y = Y + quick_sort(pivot_loc_indicator, start_index, pivot_location - 1);
	Y = Y + quick_sort(pivot_loc_indicator, pivot_location + 1, end_index);
endfunction
