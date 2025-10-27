#pragma once
#include <vector>

using byte = unsigned char;

enum opCode : unsigned char {
    ADD = 1,
    SUB,
    MUL,
    DIV,
    LDA,
    LDK,
    STA,
    INP,
    OUT,
    HLT,
    JMP,
    JEZ,
    JNE,
    JLZ,
    JLE,
    JGZ,
    JGE
};

struct instruction {
    opCode operation;
    int value;
    instruction(opCode, int);
};

class Processor {
    int* memory;
    byte pc = 0;
    int accumulator = 0;
    byte endOfProgram;
    
public:
    Processor(const std::vector<instruction>&);
    ~Processor();

    int execute();
};
