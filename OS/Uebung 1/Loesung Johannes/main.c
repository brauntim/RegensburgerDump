#include <stdio.h>
#include <signal.h>

void sig_handler(int signo) {
    if (signo == SIGINT) {
        printf("Received SIGINT\n");
        signal(SIGINT, sig_handler);
    }
}

int main() {
    if (signal(SIGINT, sig_handler) == SIG_ERR) {
        printf("Error handling sigint\n");
        return 1;
    }

    while (1) {
        printf("Hello World!\n");
        sleep(1);
    }

    return 0;
}