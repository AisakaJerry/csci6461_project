import java.io.*;

public class Simulator {
    /*Data structures for memory and registers*/
    public static String[] memory = new String[2048]; //Memory of 2048 words
    public static String[] indexRegister = new String[3]; //3 Index Registers
    public static String[] gpr = new String[4]; //4 General Purpose Registers
    public static String[] IPL = new String[5]; // Instructions preloaded
    public static String mar = "0000000000000000";
    public static String mbr = "0000000000000000";
    public static String[] mfr = new String[4]; //Machine Fault Register
    public static String pc = ""; //Program Counter
    public static String cc = ""; //Condition Code

    public static String[] instList = new String[100];  // instruction list waiting for execute
	public static int instIndicator = 0;   //a pointer to indicate current location of instructionList
	public static int execPos = 0;          // a pointer to indicate current execution position of instructionList

    /*basic instruction format*/
    public static int opcode;
    public static int indexNumber;
    public static int gprNumber;
    public static int indirect;
    public static int address;
    public static String IR;

    /*Find effective address*/
    public static int FindEA(String ins)
    {
        int addr, indexNum, indirect, address = 0;
        addr = findAddr(ins); //find address from inputed instruction
        indexNum = findIndexNumber(ins); // find index register number from inputed instruction
        indirect = findIndirect(ins); // find indrect numebr from inputed instruction

        if(indirect == 0)
        {
            if (indexNum == 0) {
                address = addr;
            }
            else {
                address = bToD(indexRegister[indexNum - 1]) + addr;
            }
        }
        if(indirect == 1)
        {
            if (indexNum == 0) {
                address = Integer.parseInt(memory[addr]);
            }
            else {
                address = bToD(memory[bToD(indexRegister[indexNum - 1]) + addr]);
            }
        }
        return address;
    }

    /*find address from inputed instruction*/
    public static int findAddr(String ins)
    {
        int addr = bToD(ins.substring(11,16));
        return addr;
    }

    /*find opcode from inputed instruction*/
    public int findOpcode(String ins)
    {
        int op = bToD(ins.substring(0,6));
        return op;
    }

    /*find GPR number from inputed instruction*/
    public int findGprNumber(String ins)
    {
        int gprN = bToD(ins.substring(8,10));
        return gprN;
    }

    /*find index register number from inputed instruction*/
    public static int findIndexNumber(String ins)
    {
        int indexN = bToD(ins.substring(8,10));
        return indexN;
    }

    /*find indirect number from inputed instruction*/
    public static int findIndirect(String ins)
    {
        int indirectN = bToD(ins.substring(10,11));
        return indirectN;
    }

    /*Initialize IPL Instruction set*/
    public static void setIPL() {
    	execPos = 0;    // set the execute position to head
        IPL[0] = "0000011100011111";  // LDR 3, 0, 31
        IPL[1] = "0000101101100110";  // STR 3, 1, 6 with indirect
        IPL[2] = "0000111000011000";  // LDA 2, 24
        IPL[3] = "1010010001011110";  // LDX 1, 30
        IPL[4] = "1010100001010000";  // STX 1, 16

	    for (int i = 0; i < 100; i++) {  // empty the instList
	    	instList[i] = "";
	    }
	    for (int i = 0; i < 5; i++) {  // push the IPL into the instList
	    	instList[i] = IPL[i];
	    }
	    instIndicator = 5;  // set the instIndicator to tail
	    initRegs();
	    initMem();

    }

    /*initialize the registers*/
    public static void initRegs() {
    	mar = "0000000000000000";
    	mbr = "0000000000000000";
    	gpr[0] = gpr[1] = gpr[2] = gpr[3] = "0000000000000000";
    	indexRegister[0] = indexRegister[1] = indexRegister[2] = "0000000000000000";
    }

    /*push the inputed instructions to instList*/
    public static void pushInstList(String inst) {
    	if (instIndicator <= 100) {
		    instList[instIndicator] = inst;
		    instIndicator++;
	    }
    }

    /*execute the instructions*/
    public static void execInst(String inst) {
	    opcode = bToD(inst.substring(0, 6));
	    gprNumber = bToD(inst.substring(6, 8));
	    indexNumber = bToD(inst.substring(8, 10));
	    indirect = bToD(inst.substring(10, 11));
	    address = bToD(inst.substring(11, 16));
	    System.out.println(inst);
	    switch(opcode) {
		    case InstType.LDR:
			    LDR(gprNumber, inst);
			    break;
		    case InstType.STR:
			    STR(gprNumber, inst);
			    break;
		    case InstType.LDA:
			    LDA(gprNumber, inst);
			    break;
		    case InstType.LDX:
			    LDA(indexNumber, inst);
			    break;
		    case InstType.STX:
			    STX(indexNumber, inst);
			    break;
	    }
    }

    /*initialize value in some memory address for IPL program*/
    public static void initMem() {
        memory[30] = "0000000000001110";
        memory[31] = "1010101010101010";
        indexRegister[0] = "0000000000001010";
        memory[16] = "0000000000001111";
    }

    /*LDR instruction: Load Register From Memory*/
    public static void LDR(int gprNum, String ins)
    {
        int address;
        String memoryVal;
        address = FindEA(ins);
        mar = ext216(dToB(address));
        memoryVal = memory[address];
        if (indirect == 0){
            gpr[gprNum] = memoryVal;
            mbr = memoryVal;  // update the value in MBR
        }
        else {
            gpr[gprNum] = memory[Integer.parseInt(memory[address])];
            mbr = memoryVal;
        }
    }

    /*STR instruction: Store Register To Memory*/
    public static void STR(int gprNum, String ins)
    {
        int address;
        address = FindEA(ins);
        memory[address] = gpr[gprNum];
        mbr = memory[address];
    }

    /*LDA instruction: Load Register with Address*/
    public static void LDA(int gprNum, String ins)
    {
        int address;
        address = FindEA(ins);
        gpr[gprNum] = ext216(dToB(address));
    }

    /*LDX instruction: Load Index Register from Memory*/
    public static void LDX(int indexNum, String ins)
    {
        int address;
        address = FindEA(ins);
        mar = ext216(dToB(address));
        indexRegister[indexNum - 1] = memory[address];
        mbr = memory[address];
    }

    /*STX instruction: Store Index Register to Memory*/
    public static void STX(int indexNum, String ins)
    {
        int address;
        address = FindEA(ins);
        memory[address] = indexRegister[indexNum - 1];
        mbr = memory[address];
    }

    /*binary to decimal*/
    public static int bToD(String bi)
    {
        return Integer.parseInt(bi,2);
    }

    /*decimal to binary*/
    public static String dToB(int n) {
        if (n == 0) {
            return "0";
        }
        String binary = "";
        while (n > 0) {
            int rem = n % 2;
            binary = rem + binary;
            n = n / 2;
        }
        return binary;
    }

    /*extend strings to 16 bits with 0*/
    public static String ext216(String s) {
        int len = s.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                s = "0" + s;
            }
        }
        return s;
    }

    public static void main(String[] args)
    {

    }

}

/*class for different instruction types*/
class InstType {
    public static final int LDR = 1; //Load Register From Memory
    public static final int STR = 2; //Store Register To Memory
    public static final int LDA = 3; //Load Register with Address
    public static final int LDX = 41; //Load Index Register from Memory
    public static final int STX = 42; //Store Index Register to Memory

   /*public static final int JZ   = 10; //Jump if Zero
   public static final int JNE   = 11; //Jump if not Equal
   public static final int JCC   = 12; // Jump if condition code cc replace r for this instruction
   public static final int JMA   = 13; // Unconditional Jump To Address
   public static final int JSR   = 14; //Jump and Save Return Address
   public static final int RFS   = 15; //Return From Subroutine w/ return code as Immed portion 
                                       //(optional) stored in the instruction’s address field. 
   public static final int SOB  = 16; //Subtract One and Branch
   public static final int JGE   = 17; //Jump Greater Than or Equal To
   public static final int AMR = 4; //Add Memory To Register
   public static final int SMR = 5; //Subtract Memory From Register
   public static final int AIR = 6; //Add  Immediate to Register
   public static final int SIR = 7; //Subtract  Immediate  from Register
   public static final int MLT = 20; //Multiply Register by Register
   public static final int DVD = 21; //Divide Register by Register*/
}