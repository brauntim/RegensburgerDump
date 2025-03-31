clc();

x = linspace(-10, 10, 1000);
y1 = sin(x);
y2 = cos(x);

figure;
plot(x, y1, 'r');
hold on;
plot(x, y2, 'b');
hold off;
xline(0);
yline(0);
legend('sin(x)', 'cos(x)');