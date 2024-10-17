class Registerreader {
    private int pc = 0;
    private int registers = [];
    private string[] lines;
    private filename = "U2_1.reg";

    public static void Main() {
        lines = File.ReadAllLines(filename);

        int n = 7;
        registers[0] = n;

        while (pc < lines.Length) {
            if (lines[pc].StartsWith("//") || (lines[pc].Trim() == "")) {
                pc++;
                continue;
            }

            string[] split = lines[pc].Split(" ");
            string command = split[0];

            switch (op) {
                case "STORE":
                    int regnum = int.Parse(split[1]);
                    registers[regnum] = registers[0];
                    break;
                
                case "CLOAD":
                    registers[0] = int.Parse(split[1]);
                    break;

                case "Load":
                    int regnum = int.Parse(split[1]);
                    registers[0] = registers[regnum];
                    break;

                case "ADD":
                    int regnum = int.Parse(split[1]);
                    registers[0] += registers[regnum];
                    break;

                case "CSUB":
                    int regnum = int.Parse(split[1]);
                    registers[0] -= registers[regnum];
                    break;

                case "IF":
                    string typeofcmp = split[1];
                    int cmpvalue = split[2];
                    int aftermath = int.Parse(split[4]);
                    bool res;
                    switch(cmp) {
                        case "=":
                            res = registers[0] == val;
                            break;
                        case "<":
                            res = registers[0] < val;
                            break;
                        case ">":
                            res = registers[0] > val;
                            break;
                        case "<=":
                            res = registers[0] <= val;
                            break;
                        default:
                            printf("Unvalid Comparison in line: " + pc);
                            break;
                    }
                    if (res) {
                        pc = aftermath - 2;
                    }
                    break;

                case "GOTO":
                    pc = int.Parse(split[1]) - 1;
                    break;

                default:
                    printf("Invalid Command in line " + pc);
            }
            pc++:
        }

        printf("Result in Register 0 = " + registers[0]);
    }    
}