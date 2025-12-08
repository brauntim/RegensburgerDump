def load_program(filename):
    program = []
    with open(filename, "r") as f:
        for line in f:
            line = line.strip()
            if not line or line.startswith("#"):
                continue
            parts = line.split()
            # Entferne evtl. Zeilennummern
            if parts[0].isdigit():
                parts = parts[1:]
            program.append(parts)
    return program


def run_program(program):
    acc = 0  # Akku
    mem = [0] * 100  # Speicher (a0..a99)
    pc = 0  # Program Counter

    while pc < len(program):
        instr = program[pc]
        cmd = instr[0].upper()
        arg = int(instr[1]) if len(instr) > 1 and instr[1].lstrip("-").isdigit() else None

        if cmd == "LDK":  # Konstante in Akku laden
            acc = arg
        elif cmd == "LDA":  # Wert aus Speicher in Akku laden
            acc = mem[arg]
        elif cmd == "STA":  # Akku in Speicher schreiben
            mem[arg] = acc
        elif cmd == "ADD":  # Addiere Speicherwert
            acc += mem[arg]
        elif cmd == "SUB":  # Subtrahiere Speicherwert
            acc -= mem[arg]
        elif cmd == "INP":  # Eingabe
            mem[arg] = int(input(f"Eingabe für a{arg}: "))
        elif cmd == "OUT":  # Ausgabe
            print(f"Ausgabe (a{arg}) = {mem[arg]}")
        elif cmd == "JMP":  # Sprung zu Adresse (1-basiert)
            pc = arg - 1
            continue
        elif cmd == "JEZ":  # Sprung, wenn Akku == 0
            if acc == 0:
                pc = arg - 1
                continue
        elif cmd == "HLT":  # Halt
            print("Programmende.")
            break
        else:
            print(f"Unbekannter Befehl: {' '.join(instr)}")
            break
        pc += 1


if __name__ == "__main__":
    filename = "program.txt"
    prog = load_program(filename)
    run_program(prog)
