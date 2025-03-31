#include <stdio.h>

void correctAnswer()
{
    double a = +10 ^ 20, b = +17, c = -10, d = 130, e = -10 ^ 20;
    printf("a + b + c + d + e = %g\n", a + b + c + d + e);
    printf("a + b + e + c + d = %g\n", a + b + e + c + d);
    printf("a + e + b + c + d = %g\n", a + e + b + c + d);
    printf("a + b + d + e + c = %g\n", a + b + d + e + c);
}

void wrongAnswer()
{
    double a = +10 ^ 30, b = +17, c = -10, d = 130, e = -10 ^ 30;
    printf("a + b + c + d + e = %g\n", a + b + c + d + e);
    printf("a + b + e + c + d = %g\n", a + b + e + c + d);
    printf("a + e + b + c + d = %g\n", a + e + b + c + d);
    printf("a + b + d + e + c = %g\n", a + b + d + e + c);
}

int main()
{
    printf("Correct answers:\n");
    correctAnswer();
    printf("Wrong answers:\n");
    wrongAnswer();
    return 0;
}