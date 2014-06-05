%count comparisons

Z = load('QuickSort.txt');
global X = (Z(1:100))'
len = size(X, 2)

Y = quick_sort(0, 1, len);

X

Y

%X = Z';
%Y = quick_sort(1, 1, len);
%X;
%Y
