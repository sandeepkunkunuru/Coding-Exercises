hold off;
close;

N = 1000;
X = 1:N;
size(X)

hold on;
axis([1 50 1 50 ]);
xlabel ("x");

z = log(X);
plot (X, z, 'b', 'LineWidth', 2);
text (X(25), z(25) + 1, "log(x)");

z = X;
plot (X, X, 'g', 'LineWidth', 2);
text (X(25), z(25) + 1, "x");

z = X .* log(X);
plot (X, z, 'm', 'LineWidth', 2);
text (X(10), z(10), "x*log(x)");

z = X.^2;
plot (X, z, 'r', 'LineWidth', 2);
text (X(5), z(5), "x^2");

z = 2 .^ log(X);
plot (X,  z, 'c', 'LineWidth', 2);
text (X(40), z(40), "2 power log(x)");

z = 2 .^ X;
plot (X,  z, 'k', 'LineWidth', 2);
text (X(4), z(5) , "2^x");

legend("log(x)", "x", "x*log(x)", "x^2", "2 power log(x)", "2^x");

hold off;
print("BigOComparisons.png");
refresh;

