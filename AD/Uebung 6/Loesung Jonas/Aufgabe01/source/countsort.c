void countSort (int list [], const int SIZE_OF_LIST, const int GREATEST_ELEMENT) {
  const int SIZE_OF_COUNT = GREATEST_ELEMENT + 1;
  int count [SIZE_OF_COUNT];
  int n, k, target;

  for (k = 0; k < SIZE_OF_COUNT; k++) {
    count[k] = 0;
  }

  for (n = 0; n < SIZE_OF_LIST; n++) {
    count[list[n]] += 1;
  }

  for (k = 0, n = 0; n < SIZE_OF_LIST; k++) {
    for (target = count[k]+n; target != n; n++) {
      list[n] = k;
    }
  }
}
