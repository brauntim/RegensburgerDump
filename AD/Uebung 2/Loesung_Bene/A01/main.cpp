#include "machine.hpp"
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

void readInFile(char* path, std::vector<instruction>& instructions);

int main(int argc, char** argv) {
    if (argc < 2) 
        return -1;

    std::vector<instruction> instructions; 
    try {
        readInFile(argv[1], instructions);
    } catch (const std::runtime_error& e) {
        std::cout << e.what();
    }

    Processor prog(instructions);
    try {
        prog.execute();
    } catch (const std::runtime_error& e) {
        std::cout << e.what() << std::endl;
        return -1;
    } catch (...) {
        return -1;
    }

    return 0;
}

void readInFile(char* path, std::vector<instruction>& instructions) {
    std::ifstream infile(path);
    if (!infile.is_open()) 
        std::runtime_error("there is no file like this");
    
    std::string line;
    while (getline(infile, line)) {
        std::istringstream inputstream(line);
        std::string operation;
        int operand = 0;

        inputstream >> operation;
        inputstream >> operand;

        if (operation == "ADD")
            instructions.push_back(instruction(opCode::ADD, operand));
        else if (operation == "SUB")
            instructions.push_back(instruction(opCode::SUB, operand));
        else if (operation == "MUL")
            instructions.push_back(instruction(opCode::MUL, operand));
        else if (operation == "DIV")
            instructions.push_back(instruction(opCode::DIV, operand));
        else if (operation == "LDA")
            instructions.push_back(instruction(opCode::LDA, operand));
        else if (operation == "LDK")
            instructions.push_back(instruction(opCode::LDK, operand));
        else if (operation == "STA")
            instructions.push_back(instruction(opCode::STA, operand));
        else if (operation == "INP")
            instructions.push_back(instruction(opCode::INP, operand));
        else if (operation == "OUT")
            instructions.push_back(instruction(opCode::OUT, operand));
        else if (operation == "HLT")
            instructions.push_back(instruction(opCode::HLT, operand));
        else if (operation == "JMP")
            instructions.push_back(instruction(opCode::JMP, operand));
        else if (operation == "JEZ")
            instructions.push_back(instruction(opCode::JEZ, operand));
        else if (operation == "JNE")
            instructions.push_back(instruction(opCode::JNE, operand));
        else if (operation == "JLZ")
            instructions.push_back(instruction(opCode::JLZ, operand));
        else if (operation == "JLE")
            instructions.push_back(instruction(opCode::JLE, operand));
        else if (operation == "JGZ")
            instructions.push_back(instruction(opCode::JGZ, operand));
        else if (operation == "JGE")
            instructions.push_back(instruction(opCode::JGE, operand));
        else
            std::cout << "line: " << line << "is not valid" << std::endl;
    }
}
