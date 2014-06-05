function [X, num_inversions] = mergesort_count_inversions(X)
	len = size(X, 2); % number of columns
	temp = floor(len/2); % median
	num_inversions=0; % initialize number of inversions

        if temp >= 1
		X1 = X(1, 1:temp);
		X2 = X(1, (temp + 1):end);

	        [X1, num_inversions1] = mergesort_count_inversions(X1);
		[X2, num_inversions2] = mergesort_count_inversions(X2);
		
		len1 = size(X1, 2); 
		len2 = size(X2, 2);
                X1_X2 = zeros(1, len); % len = len1 + len2
		
		i = 1;
		j = 1;
		num_inversions3 = 0;                

		for k = 1:len
		    if i > len1
			X1_X2(1, k) = X2(1,j);
			j++;
		    elseif j > len2
			X1_X2(1, k) = X1(1,i);			
			i++;
		    elseif X1(1,i) < X2(1,j)
			X1_X2(1, k) = X1(1,i);
			i++;			
		    else
			X1_X2(1, k) = X2(1,j);
			num_inversions3 = num_inversions3 + len1 - i + 1;
			j++; 
		    end

		    %if num_inversions3 > 600000000 % resetting since big integers arent supported in octave
		%	num_inversions3
		%	num_inversions3 = 0;			
		 %   end
		end
		
		X = X1_X2;

		%if num_inversions1 > 600000000 % resetting since big integers arent supported in octave
		%	num_inversions1
		%	num_inversions1 = 0;			
		%end

		%if num_inversions2 > 600000000 % resetting since big integers arent supported in octave
		%	num_inversions2
		%	num_inversions2 = 0;			
		%end


		num_inversions = num_inversions1 + num_inversions2 + num_inversions3;
	end	
endfunction
