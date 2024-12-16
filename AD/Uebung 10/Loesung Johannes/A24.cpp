#include <iostream>
#include <string>

using namespace std;


bool CompareWithOffset(string text, string pattern, int offset) {
    cout << string(offset, ' ');
    bool match = true;

    for (int i = 0; i < pattern.size(); i++) {
        if (text[offset + i] == pattern[i]) {
            cout << (char)toupper(pattern[i]);
        } else {
            cout << pattern[i];
            match = false;
        }
    }

    cout << "\n";
    return match;
}

bool NaiveSearch(string text, string pattern) {
    cout << text << "\n";
    for (int i = 0; i <= text.size() - pattern.size(); i++) {
        if (CompareWithOffset(text, pattern, i))
            return true;
    }
    return false;
}

// Assumption: Each char in pattern is unique
bool NaiveSearch2(string text, string pattern) {
    cout << text << "\n";

    int p = 0;
    for (int i = 0; i < text.size(); i++) {
        if (text[i] == pattern[p]) {
            cout << (char)toupper(pattern[p]);
            p++;
            if (p == pattern.size()) {
                cout << "\n";
                return true;
            }
        } else {
            cout << pattern[p];
            p = 0;
        }
    }

    cout << "\n";
    return false;
}

bool BoyerMooreSearch(string text, string pattern) {
    cout << text << "\n";

    int lastOccurence[256]; // ASCII table size
    for (int i = 0; i < 256; i++) 
        lastOccurence[i] = pattern.size();
    for (int i = 0; i < pattern.size(); i++)
        lastOccurence[pattern[i]] = pattern.size() - i - 1;

    int i = 0;
    while (i <= text.size() - pattern.size()) {
        CompareWithOffset(text, pattern, i); // Only for display, no functionality in algo

        bool match = true;
        for (int j = pattern.size() - 1; j >= 0; j--) {
            if (text[i + j] != pattern[j]) {
                match = false;
                i += lastOccurence[text[i + j]];
                break;
            }
        }
        if (match)
            return true;
    }

    return false;
}


int main() {
    string text = "algorithmen und datenstrukturen";
    string pattern = "daten";

    cout << "Naive Search:\n" << NaiveSearch(text, pattern) << "\n\n";

    cout << "Naive Search 2:\n" << NaiveSearch2(text, pattern) << "\n\n";

    cout << "Boyer-Moore Search:\n" << BoyerMooreSearch(text, pattern) << "\n";
    return 0;
}