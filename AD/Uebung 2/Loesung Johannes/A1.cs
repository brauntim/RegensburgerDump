
// Reference: https://de.wikipedia.org/wiki/Registermaschine#Random_Access_Machine
class RandomAccessMachine {
    private string[] lines;
    private Dictionary<int, int> registers = [];
    private int pc = 0;

    public RandomAccessMachine(string filename) {
        lines = File.ReadAllLines(filename);
    }

    public void Reset() {
        registers.Clear();
        pc = 0;
    }

    public int Run(int input) {
        registers[0] = input;

        while (pc < lines.Length) {
            if (lines[pc].StartsWith("//") || lines[pc].Trim() == "") {
                pc++;
                continue;
            }

            string[] parts = lines[pc].Split(' ');
            string op = parts[0];

            switch (op) {
                default:
                    throw new Exception("Unknown operation: " + op);

                case "END":
                    return registers[0];

                case "LOAD":
                    int reg = int.Parse(parts[1]);
                    registers[0] = registers[reg];
                    break;
                
                case "CLOAD":
                    registers[0] = int.Parse(parts[1]);
                    break;

                case "INDLOAD":
                    int addr = registers[int.Parse(parts[1])];
                    registers[0] = registers[addr];
                    break;

                case "STORE":
                    reg = int.Parse(parts[1]);
                    registers[reg] = registers[0];
                    break;

                case "INDSTORE":
                    addr = registers[int.Parse(parts[1])];
                    registers[addr] = registers[0];
                    break;

                case "ADD":
                    reg = int.Parse(parts[1]);
                    registers[0] += registers[reg];
                    break;

                case "CADD":
                    registers[0] += int.Parse(parts[1]);
                    break;

                case "INDADD":
                    addr = registers[int.Parse(parts[1])];
                    registers[0] += registers[addr];
                    break;

                case "SUB":
                    reg = int.Parse(parts[1]);
                    registers[0] -= registers[reg];
                    break;

                case "CSUB":
                    registers[0] -= int.Parse(parts[1]);
                    break;

                case "INDSUB":
                    addr = registers[int.Parse(parts[1])];
                    registers[0] -= registers[addr];
                    break;

                case "MUL":
                    reg = int.Parse(parts[1]);
                    registers[0] *= registers[reg];
                    break;

                case "CMUL":
                    registers[0] *= int.Parse(parts[1]);
                    break;

                case "INDMUL":
                    addr = registers[int.Parse(parts[1])];
                    registers[0] *= registers[addr];
                    break;

                case "DIV":
                    reg = int.Parse(parts[1]);
                    registers[0] /= registers[reg];
                    break;

                case "CDIV":
                    registers[0] /= int.Parse(parts[1]);
                    break;

                case "INDDIV":
                    addr = registers[int.Parse(parts[1])];
                    registers[0] /= registers[addr];
                    break;

                case "GOTO":
                    pc = int.Parse(parts[1]) - 1;
                    break;

                case "IF":
                    string cmp = parts[1];
                    int val = int.Parse(parts[2]);
                    int target = int.Parse(parts[4]);

                    bool result;
                    switch (cmp) {
                        case "=":
                            result = registers[0] == val;
                            break;
                        case "<":
                            result = registers[0] < val;
                            break;
                        case ">":
                            result = registers[0] > val;
                            break;
                        case "<=":
                            result = registers[0] <= val;
                            break;
                        default:
                            throw new Exception("Unknown comparison: " + cmp);
                    }

                    if (result) {
                        // -1 because pc is incremented at end, -1 because of 1-based indexing in file
                        pc = target - 2;
                    }

                    break;
            }

            pc++;
        }

        return registers[0];
    }
}

class Program {
    static void Main() {
        RandomAccessMachine rm = new(""".\A1.reg""");
        int res = rm.Run(42);
        Console.WriteLine($"Result: {res}");
    }
}