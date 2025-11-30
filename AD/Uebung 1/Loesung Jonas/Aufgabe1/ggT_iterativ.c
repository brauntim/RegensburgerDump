int main () {
  int a = 32;
  int b = 16;
  int r;

  do {
    r = a%b;
    a = b;
    b = r;
  } while (r != 0);

  return 0;
}
