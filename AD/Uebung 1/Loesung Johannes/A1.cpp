#include <iostream>
#include <cstdint>

// schnell, speichereffizient
uint64_t ggT_it(uint64_t a, uint64_t b) {
    while (b != 0) {
        uint64_t h = a % b;
        a = b;
        b = h;
    }
    return a;
}
// langsamer, weniger speichereffizient, übersichtlicher
// wird oft vom Compiler zu ggT_it optimiert
uint64_t ggT_rek(uint64_t a, uint64_t b) {
    if (b == 0) {
        return a;
    }
    return ggT_rek(b, a % b);
}


uint64_t kgV_naiv(uint64_t a, uint64_t b) {
    for (uint64_t i = 1; i <= a * b; i++) {
        if (i % a == 0 && i % b == 0) {
            return i;
        }
    }
    // sollte nie erreicht werden
    return -1;
}

uint64_t kgV(uint64_t a, uint64_t b) {
    return a * b / ggT_it(a, b);
}
