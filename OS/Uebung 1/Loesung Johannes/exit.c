#include <signal.h>

// Different ways to end a program in C
int main() {
    // End program normally
    exit(0);

    // End program with error
    exit(1);

    // End program abnormally with core dump
    abort();

    // Kill program with signal
    raise(SIGTERM);
}