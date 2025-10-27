INP 100 //input value
LDK 0   
STA 101 //for addition/subtraction with zero
STA 103 //result cell
LDK 1
STA 102 //for addition/subtraction with 1
LDA 100 //laod for checking place in iteration
JEZ 14  //end if 100 zero
ADD 103 //else add current result value
STA 103 //stash in result
LDA 100 //load position
SUB 102 //subtract one
STA 100 //stash in 100
JMP 6   //loop jumpt back to begin
OUT 103 //return result
HLT 99
