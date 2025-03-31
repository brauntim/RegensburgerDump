clc();

%%
a = [2 4 6 8 10];

disp("a = ");
disp(a);
disp("diff(a) = ");
disp(diff(a));

%%
b = [3 5 7 9 11];
disp("b = ");
disp(b);
disp("diff(b) = ");
disp(diff(b));

%%
c = [2 6 12 20 30];
disp("c = ");
disp(c);
disp("diff(c) = ");
disp(diff(c));
disp("diff(diff(c)) = ");
disp(diff(diff(c)));
disp("diff(diff(diff(c))) = ");
disp(diff(diff(diff(c))));

%% Aufgabe f)

% a(n) = a(n - 1) + a(n - 2); a(0) = 2; a(1) = 3;

% b(n) = 2^n

% c(n) = 2^(n + 1) - 1;