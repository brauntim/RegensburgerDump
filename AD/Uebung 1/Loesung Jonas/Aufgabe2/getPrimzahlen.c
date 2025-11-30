int get_primzahlen(int obereGrenze);

int main () {
  int result = get_primzahlen(100);
  return 0;
}

int get_primzahlen (int obereGrenze) {
  int primzahlen[obereGrenze+1];

  for (int iterator = 0; iterator <= obereGrenze; iterator += 1) {
    primzahlen[iterator] = iterator;
  }

  for (int iterator = 2; iterator <= obereGrenze; iterator += 1) {
    if (primzahlen[iterator] != 0) {
      for (int iterator2 = iterator + 1; iterator2 <= obereGrenze; iterator2 += 1) {
        if (primzahlen[iterator2] % primzahlen[iterator] == 0) {
          primzahlen[iterator2] = 0;
        }
      }
    }
  }

  return 0;
}
