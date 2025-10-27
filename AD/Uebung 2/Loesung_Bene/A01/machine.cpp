#include "machine.hpp"
#include <iostream>
#include <limits>
#include <stdexcept>

using std::cin, std::cout;

instruction::instruction(opCode op, int val) : operation(op), value(val){}

Processor::Processor(const std::vector<instruction>& program) {
    //two informations per instructions=> program cannot be bigger than 128 = 256/2
    if (program.size() > 128) 
        throw std::runtime_error("programm is to big for memory");
    memory = new int[256];

    int i = 0;
    for (; i < program.size(); i++) {
        memory[2 * i    ] = program[i].operation;
        memory[2 * i + 1] = program[i].value;
    }
    endOfProgram = 2 * (i-1) + 1;
}

Processor::~Processor() {
    delete[] memory;
}

int Processor::execute() {
    while (true) {
        opCode operatorCode = (opCode) memory[pc];
        int operand = memory[++pc];
        switch(operatorCode) {
            //inplace math ops
            case opCode::ADD: 
                accumulator += memory[operand];
            break;
            case opCode::SUB: 
                accumulator -= memory[operand];
            break;
            case opCode::MUL: 
                accumulator *= memory[operand];
            break;
            case opCode::DIV: 
                accumulator /= memory[operand];
            break;

            //Load and Stash operation
            case opCode::LDA:
                accumulator = memory[operand];
            break;
            case opCode::LDK: 
                accumulator = operand;
            break;
            case opCode::STA:
                memory[operand] = accumulator;
            break;

            //IO and stop
            case opCode::INP: 
                cout << "Enter integer: ";
                while(true) {
                    cin >> memory[operand];
                    if (!cin.fail()) 
                        break;
                    cin.clear(); 
                    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
                }
            break;
            case opCode::OUT: 
                cout << memory[operand];
            break;

            //Jump operations
            case opCode::JMP:
                pc = operand*2; 
            continue;
            case opCode::JEZ:
                if (accumulator == 0) {
                    pc = operand*2;
                    continue;
                }
            break;
            case opCode::JNE:
                if (accumulator != 0) {
                    pc = operand*2;
                    continue;
                }
            break;
            case opCode::JLZ:
                if (accumulator < 0) {
                    pc = operand*2;
                    continue;
                }
            break;
            case opCode::JLE:
                if (accumulator <= 0) {
                    pc = operand*2;
                    continue;
                }
            break;
            case opCode::JGZ:
                if (accumulator > 0) {
                    pc = operand*2;
                    continue;
                }
            break;
            case opCode::JGE:
                if (accumulator >= 0) {
                    pc = operand*2;
                    continue;
                }
            break;

            //HLT case
            default: 
                return operand;

        }
        pc++;
    }
    return 0;
}
