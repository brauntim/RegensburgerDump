clc();

A = [-2 -3 -4 -5
     5 6 7 8];

B = [1 2 3 4
     0 1 0 1];

C = [2 0 0 0
     0 -3 0 0
     0 0 4 0
     0 0 0 5];

e1 = [1 0];
e2 = [0 1];
v = [0 0 1 0];
w = v';

% OK
disp("A + B = ");
disp(A + B);

% OK
disp("A' * B = ");
disp(A' * B);

% OK
disp("e1 * A = ");
disp(e1 * A);

% OK
disp("e2 * A = ");
disp(e2 * A);

% OK
disp("A * w = ");
disp(A * w);

% Size mismatch
disp("w * A = ");
disp("Size mismatch");
% disp(w * A);

% Size mismatch
disp("A * v = ");
disp("Size mismatch");
% disp(A * v);

% Size mismatch
disp("w' * B = ");
disp("Size mismatch");
% disp(w' * B);

% OK
disp("B * C = ");
disp(B * C);

% OK
disp("C * C = ");
disp(C * C);

% OK
disp("C^2 = ");
disp(C^2);

% OK
disp("C^3 = ");
disp(C^3);

% OK
disp("C^0 = ");
disp(C^0);
