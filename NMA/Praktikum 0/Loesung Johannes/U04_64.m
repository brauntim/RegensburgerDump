clc();

% Aufgabe a)
A = [ 3  2 -6
      1 -1  2
      4 -1 -3 ];

b = [ 1
      8
      3 ];

disp("Aufgabe a)");
disp("A = ");
disp(A);
disp("b = ");
disp(b);
disp("x = ");
disp(A \ b);

% Aufgabe b)
A = [ 3  2  1
      1 -3  2
      3  1 -3 ];

b = [ 1
      2
      3 ];

disp("Aufgabe b)");
disp("A = ");
disp(A);
disp("b = ");
disp(b);
disp("x = ");
disp(A \ b);

% Aufgabe c)
A = [ 3  2  1
      1 -3  2
      2  1  3 ];

b = [ 9
     15
    -12 ];

disp("Aufgabe c)");
disp("A = ");
disp(A);
disp("b = ");
disp(b);
disp("x = ");
disp(A \ b);
