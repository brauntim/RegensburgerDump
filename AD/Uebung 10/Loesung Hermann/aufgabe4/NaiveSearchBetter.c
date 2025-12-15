#include <stdio.h>
#include <stdbool.h>

int naiveSearch(char* text, int n, char* muster, int m) {
    if (m > n || text == NULL || muster == NULL) {
        return 0;
    }

    int count = 0;

    for (int i = 0; i < n-m+1;) {
        int shift = 0;
        bool match = true;

        for (int j = 0; j < m; j++) {
            if (text[i+j] != muster[j]) {
                match = false;
                break;
            } else {
                shift++;
            }
        }

        if (match) {
            count++;
        }
        
        i += (shift == 0) ? 1 : shift;
    }
    return count;
}

int main () {
    char text[] = "Datenstrukturen und Datenspaß";
    int n = sizeof(text) - 1;       // ohne '/0'
    char muster[] = "Daten";
    int m = sizeof(muster) - 1;
    
    int result = naiveSearch(text, n, muster, m);
    printf("Im Text: '%s' gibt es %dx das Wort '%s'\n", text, result, muster);
    
    return 0;
}