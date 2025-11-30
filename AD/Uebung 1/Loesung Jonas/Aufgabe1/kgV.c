#define and &&
#define or ||

int get_kgV(int input1, int input2);

int main () {
  int result = get_kgV(32, 16);

  return 0;
}

int get_kgV(int input1, int input2) {
  int result = 1;
  
  if (input1 != 1 or input2 != 1) {
    int max = input1 * input2;

    while (result < max) {
      result += 1;

      if (input1%result == 0 and input2%result == 0) {
        break;
      }
    }
  }

  return result;
}
