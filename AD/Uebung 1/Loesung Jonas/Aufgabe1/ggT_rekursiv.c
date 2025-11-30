int get_ggT(int a, int b);

int main () {
  int ggT = get_ggT(32, 15);

  return 0;
}

int get_ggT(int a, int b) {
  int r = a%b;

  if (r == 0) {
    return b;
  }
  else {
    return get_ggT(b, r);
  }
}
