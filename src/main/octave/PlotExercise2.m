hold off;
close;

%a)2log⁡(n)
%b)22log⁡(n)
%c)n5/2
%d)2n2
%e)n2log⁡(n)




N = 1000;
X = 1:N;
size(X)

hold on;
axis([1 50 1 50 ]);
xlabel ("x");

z =2 .^ log(X);
plot (X, z, 'b', 'LineWidth', 2);
text (X(25), z(25) + 1, "a");

z = 2 .^ (2 .^ log(X));
plot (X, z, 'g', 'LineWidth', 2);
text (X(25), z(25) + 1, "b");

z = X .^ (5/2);
plot (X, z, 'm', 'LineWidth', 2);
text (X(10), z(10), "c");

z = 2 .^ (X .^ 2);
plot (X, z, 'r', 'LineWidth', 2);
text (X(5), z(5), "d");

z = (X .^ 2) .* log(X);
plot (X,  z, 'c', 'LineWidth', 2);
text (X(40), z(40), "e");

legend("a", "b", "c", "d", "e");

hold off;
print("Comare2.png");
refresh;

