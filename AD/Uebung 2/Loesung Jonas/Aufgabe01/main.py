from enum import Enum

class OneOperation:
    def __init__(self, typeOfOperation, secondFactor):
        self.type = typeOfOperation
        self.secondFactor = secondFactor

class Registermachine:
    def __init__(self):
        self.registers = []
        self.operations = []
        self.noCurrentOperation = 0
        self.isRunning = False
    
    def setRegisters(self, registers):
        self.registers = registers
    
    def setOperations(self, operations):
        self.operations = operations

    def run(self):
        self.isRunning = True

        while (self.isRunning == True):
            self.runCurrentOperation()
    
    def runCurrentOperation(self):
        operation = self.operations[self.noCurrentOperation].type
        factor = self.operations[self.noCurrentOperation].secondFactor
        
        if operation == OPERATION_ADD:
            self.registers[0] += self.registers[factor]
            self.noCurrentOperation += 1

        elif operation == OPERATION_JMP:
            self.noCurrentOperation = factor
        
        elif operation == OPERATION_OUT:
            print(f"Das Ergebnis ist: {self.registers[factor]}")
            self.noCurrentOperation += 1
        
        elif operation == OPERATION_HALT:
            self.isRunning = False
            self.currentOperation = 0
        
        elif operation == OPERATION_INP:
            self.registers[factor] = int(input("Nächsten Wert eingeben: "))
            self.noCurrentOperation += 1
        
        elif operation == OPERATION_JEZ:
            if self.registers[0] == 0:
                self.noCurrentOperation = factor
            else:
                self.noCurrentOperation += 1
        
        elif operation == OPERATION_STA:
            self.registers[factor] = self.registers[0]
            self.noCurrentOperation += 1

OPERATION_ADD = "ADD"
OPERATION_JMP = 'JMP'
OPERATION_OUT = 'OUT'
OPERATION_HALT = 'HALT'
OPERATION_INP = 'INP'
OPERATION_JEZ = 'JEZ'
OPERATION_STA = 'STA'

def main():
    registermaschine = Registermachine()
    operations = getOperationsFromFile("registermaschinenprogramm.txt")
    
    registermaschine.setOperations(operations)
    registermaschine.registers = [0, 0]

    registermaschine.run()

def getOperationsFromFile(fileName) -> [OneOperation]:
    file = open(fileName, 'r')

    result = []

    for line in file:
        if line.strip():
            values = line.strip().split(' ')

            result.append(
                OneOperation(values[0], int(values[1]))
            )

    return result

main()