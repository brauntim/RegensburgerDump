class RegisterMachineSimulator:
    def __init__(self, file_path):
        self.registers = {'R1': 0, 'R2': 0, 'R3': 0}  # Initialisierung der Register
        self.program = self.load_program(file_path)
        self.program_counter = 0

    def load_program(self, file_path):

        with open(file_path, 'r') as file:
            return [line.strip() for line in file.readlines()]

    def execute_program(self):
        # Führt das Registermaschinenprogramm aus
        while self.program_counter < len(self.program):
            instruction = self.program[self.program_counter]
            self.execute_instruction(instruction)
            self.program_counter += 1
        print(f"Ergebnis der Summe in R3: {self.registers['R3']}")

    def execute_instruction(self, instruction):
        # Führt eine einzelne Anweisung basierend auf der Operation aus
        parts = instruction.split()
        operation = parts[0]
        register = parts[1] if len(parts) > 1 else None

        if operation == "LDA":

            self.registers[register] = int(parts[2])
        elif operation == "CMP":

            if self.registers[register] > self.registers[parts[2]]:
                self.program_counter += 1  
        elif operation == "ADD":
            
            self.registers[register] += self.registers[parts[2]]
        elif operation == "INC":
            
            self.registers[register] += 1
        elif operation == "JMP":
            
            self.program_counter = int(parts[1]) - 2  
        elif operation == "JGT":

            if self.registers[register] > self.registers[parts[2]]:
                self.program_counter = int(parts[3]) - 1
        elif operation == "END":
            # Beendet das Programm
            self.program_counter = len(self.program)
        else:
            print(f"Unbekannte Anweisung: {operation}")

if __name__ == "__main__":
    simulator = RegisterMachineSimulator("program.txt")
    simulator.execute_program()
