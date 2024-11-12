#include <stdio.h>

void print_all_primnrs() {
    char array[100] = {1, 1};
    for (int i = 0; i < 100; i++) {
        if (array[i] == 1) {
            continue;
        } else {
            printf("%d\n", i);
            for (int j = 2*i; j < 100; j += i) {
                array[j] = 1;
            }
        }
    }

}
int main() {
    print_all_primnrs();
    return 0;
}


