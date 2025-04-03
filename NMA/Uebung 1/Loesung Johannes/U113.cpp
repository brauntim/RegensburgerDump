#include <iostream>

#define LITTLE_ENDIAN __BYTE_ORDER__ == __ORDER_LITTLE_ENDIAN__

template <typename T>
struct BitWriter {
    const T& value;
    const bool reverse;
};

template <typename T>
BitWriter<T> bits(const T& value, bool reverse = LITTLE_ENDIAN) {
    return BitWriter<T>{value, reverse};
}

template <typename T>
std::ostream& operator<<(std::ostream& os, const BitWriter<T>& bw) {
    const unsigned char* bytePtr = reinterpret_cast<const unsigned char*>(&bw.value);
    for (size_t i = 0; i < sizeof(T); ++i) {
        size_t byteIndex = bw.reverse ? sizeof(T) - 1 - i : i;
        for (int j = 7; j >= 0; --j) {
            os << ((bytePtr[byteIndex] >> j) & 1);
        }
    }
    return os;
}

int main() {
    std::cout << "0.f:\n10: " << 0.f  << "\n2:  " << bits(0.f) << "\n";
    std::cout << "-0.f:\n10: " << -0.f << "\n2:  " << bits(-0.f) << "\n";

    std::cout << "0.f == -0.f:\n  " << (0.f == -0.f) << "\n\n";

    std::cout << "1.f / 0.f:\n10: " << 1.f / 0.f << "\n2:  " << bits(1.f / 0.f) << "\n";
    std::cout << "-1.f / 0.f:\n10: " << -1.f / 0.f << "\n2:  " << bits(-1.f / 0.f) << "\n";
    std::cout << "0.f / 0.f:\n10: " << 0.f / 0.f << "\n2:  " << bits(0.f / 0.f) << "\n";
}