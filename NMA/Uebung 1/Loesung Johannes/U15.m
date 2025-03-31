clc();

%%
a = int16(1024);
a = a * int16(1024);

disp(a); % 32767
disp(int16(a)); % 32767

%%
a = 1024;
a = a * 1024;
disp(a); % 1048576
disp(int16(a)); % 32767

