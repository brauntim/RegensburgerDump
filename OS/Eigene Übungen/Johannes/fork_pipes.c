#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    char buffer1[21], buffer2[21];

    int fromChild[2], toChild[2]; // [0]: read, [1]: write
    pipe(fromChild);
    pipe(toChild);

    pid_t childPID = fork();
    if (childPID == 0) {
        close(toChild[1]); // close needed for pipes to work 
        close(fromChild[0]);
        read(toChild[0], buffer1, 20);
        printf("Parent sais: %s\n", buffer1);
        write(fromChild[1], "I'm the child!", 20);
    }
    else {
        close(toChild[0]); // close needed for pipes to work
        close(fromChild[1]);
        write(toChild[1], "I'm the parent!", 20);
        read(fromChild[0], buffer2, 20);
        printf("Child sais: %s\n", buffer2);
    }
}