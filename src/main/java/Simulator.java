import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
    public static String[] cc = new String[4]; //Condition Code
    public static String immed; // immediate value
    public static String outBuffer = "";

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
    public static int AOrL;
    public static int LOrR;
    public static int count;

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
                address = bToD(memory[addr]);
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
	    immed = inst.substring(11, 16);
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
			case InstType.AIR:
			    AIR(gprNumber, inst);
			    break;
			case InstType.AMR:
			    AMR(gprNumber, inst);
			    break;
            case InstType.AND:
                AND(bToD(inst.substring(6, 8)), bToD(inst.substring(8, 10)), inst);
                break;
            case InstType.DVD:
                DVD(bToD(inst.substring(6, 8)), bToD(inst.substring(8, 10)), inst);
                break;
            case InstType.JCC:
                JCC(gprNumber, inst);
                break;
            case InstType.JGE:
                JGE(gprNumber, inst);
                break;
            case InstType.JMA:
                JMA(inst);
                break;
            case InstType.JNE:
                JNE(gprNumber, inst);
                break;
            case InstType.JSR:
                JSR(inst);
                break;
            case InstType.JZ:
                JZ(gprNumber, inst);
                break;
            case InstType.MLT:
                MLT(bToD(inst.substring(6, 8)), bToD(inst.substring(8, 10)), inst);
                break;
            case InstType.NOT:
                NOT(bToD(inst.substring(6, 8)), bToD(inst.substring(8, 10)), inst);
                break;
            case InstType.ORR:
                ORR(bToD(inst.substring(6, 8)), bToD(inst.substring(8, 10)), inst);
                break;
            case InstType.RFS:
                RFS(inst);
                break;
            case InstType.RRC:
                RRC(gprNumber, inst);
                break;
            case InstType.SIR:
                SIR(gprNumber, inst);
                break;
            case InstType.SMR:
                SMR(gprNumber, inst);
                break;
            case InstType.SOB:
                SOB(gprNumber, inst);
                break;
            case InstType.SRC:
                SRC(gprNumber, inst);
                break;
            case InstType.TRR:
                TRR(bToD(inst.substring(6, 8)), bToD(inst.substring(8, 10)), inst);
                break;
            case InstType.IN:
                IN(gprNumber, inst);
                break;
            case InstType.OUT:
                OUT(gprNumber, inst);
                break;
            case InstType.CHK:
                CHK(gprNumber, inst);
                break;
            case InstType.HLT:
                HLT(inst);
                break;
	    }
	    if (!((opcode >= 10)&&(opcode <= 17))) {
	        if (!pc.equals("")) {
                int temp = bToD(pc);
                temp++;
                pc = ext212(dToB(temp));
            }
        }
	    gui.jTextFieldR0.setText(gpr[0]);
        gui.jTextFieldR1.setText(gpr[1]);
        gui.jTextFieldR2.setText(gpr[2]);
        gui.jTextFieldR3.setText(gpr[3]);
        gui.jTextFieldX1.setText(indexRegister[0]);
        gui.jTextFieldX2.setText(indexRegister[1]);
        gui.jTextFieldX3.setText(indexRegister[2]);
        gui.jTextFieldMAR.setText(mar);
        gui.jTextFieldMBR.setText(mbr);
    }

    /*initialize value in some memory address for IPL program*/
    public static void initMem() {
        for (int i = 0; i < 2048; i++) {
            memory[i] = "0000000000000000";
        }
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
            //gpr[gprNum] = memory[Integer.parseInt(memory[address])];
            gpr[gprNum] = memoryVal;
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

    /*JZ instruction: Jump If Zero*/
    public static void JZ(int gprNum, String ins)
    {
        int address;
        int temp = 0;
        address = FindEA(ins);
        if(signB2D(gpr[gprNum]) == 0) {
            pc = ext212(dToB(address));
        }
        else{
            temp = bToD(pc);
            temp++;
            pc = ext212(dToB(temp));
        }
    }

    /*JNE instruction: Jump If Not Equal*/
    public static void JNE(int gprNum, String ins)
    {
        int address;
        int temp = 0;
        address = FindEA(ins);
        if(signB2D(gpr[gprNum]) != 0) {
            pc = ext212(dToB(address));
        }
        else {
            temp = bToD(pc);
            temp++;
            pc = ext212(dToB(temp));
        }
    }

    /*JCC instruction: Jump If Condition Code*/
    public static void JCC(int gprNum, String ins)
    {
        int address;
        int temp = 0;
        address = FindEA(ins);
        if(cc[gprNum] == "0001") {
            pc = ext212(dToB(address));
        }
        else {
            temp = bToD(pc);
            temp++;
            pc = ext212(dToB(temp));
        }
    }

    /*JMA instruction: Unconditional Jump To Address(r is ignored)*/
    public static void JMA(String ins)
    {
        int address;
        address = FindEA(ins);
        pc = ext212(dToB(address));
    }

    /*JSR instruction: Jump and Save Return Address*/
    public static void JSR(String ins)
    {
        int address, temp;
        address = FindEA(ins);
        temp = bToD(pc);
        temp++;
        pc = ext212(dToB(temp));
        gpr[3] = pc;
        pc = ext212(dToB(address));
    }

    /*RFS instruction: Return From Subroutine w/ return code as Immed
     portion (optional) stored in the instruction’s address field*/
    public static void RFS(String ins)
    {
        gpr[0] = immed;
        pc = gpr[3].substring(4);  // 16bit to 12bit
    }

    /*SOB instruction: Subtract One and Branch*/
    public static  void SOB(int gprNum, String ins)
    {
        int address;
        int temp = 0;
        address = FindEA(ins);
        gpr[gprNum] = ext216(signD2B(signB2D(gpr[gprNum]) - 1));
        if(bToD(gpr[gprNum]) > 0) {
            pc = ext212(dToB(address));
        }
        else {
            temp = bToD(pc);
            temp++;
            pc = ext212(dToB(temp));
        }
    }

    /*JGE instruction: Jump Greater Than or Equal To*/
    public static void JGE(int gprNum, String ins)
    {
        int address;
        int temp = 0;
        address = FindEA(ins);
        if(signB2D(gpr[gprNum]) >= 0) {
            pc = ext212(dToB(address));
        }
        else {
            temp = bToD(pc);
            temp++;
            pc = ext212(dToB(temp));
        }
    }

    /*AMR instruction: Add Memory To Register*/
    public static void AMR(int gprNum, String ins)
    {
        int address;
        address = FindEA(ins);
        gpr[gprNum] = ext216(signD2B(signB2D(gpr[gprNum]) + signB2D(memory[address])));
    }

    /*SMR instruction: Subtract Memory From Register*/
    public static void SMR(int gprNum, String ins)
    {
        int address;
        address = FindEA(ins);
        gpr[gprNum] = ext216(signD2B(signB2D(gpr[gprNum]) - signB2D(memory[address])));
    }

    /*AIR instruction: Add Immediate to Register*/
    public static void AIR(int gprNum, String ins)
    {
        if(immed == null) {
            ;
        }
        else {
            gpr[gprNum] = ext216(signD2B(signB2D(gpr[gprNum]) + signB2D(immed)));
        }
    }

    /*SIR instruction: Subtract  Immediate  from Register*/
    public static void SIR(int gprNum, String ins)
    {
        int address;
        address = FindEA(ins);
        if(immed == null) {
            ;
        }
        else {
            gpr[gprNum] = ext216(signD2B(signB2D(gpr[gprNum]) - signB2D(immed)));
        }
    }

    /*MLT instruction: Multiply Register by Register*/
    public static void MLT(int rx, int ry, String ins)
    {
        if(rx == 0 && ry == 2) {
            int result;
            result = signB2D(gpr[rx]) * signB2D(gpr[ry]);
            if (result < 2147483647)
            {
                String s = signD2B(result);
                if (s.substring(0, 1).equals("0")) {
                    while (s.length() < 32)
                        s = "0" + s;
                }
                else {
                    while (s.length() < 32)
                        s = "1" + s;
                }
                gpr[rx] = s.substring(0, 16);
                gpr[rx+1] = s.substring(16, 32);
            }
            else
                cc[0] = "0001";
        }
        if(ry == 0 && rx == 2)
        {
            int result;
            result = signB2D(gpr[rx]) * signB2D(gpr[ry]);
            if (result < 2147483647)
            {
                String s = signD2B(result);
                if (s.substring(0, 1).equals("0")) {
                    while (s.length() < 32)
                        s = "0" + s;
                }
                else {
                    while (s.length() < 32)
                        s = "1" + s;
                }
                gpr[rx] = s.substring(0, 16);
                gpr[rx+1] = s.substring(16, 32);
            }
            else
                cc[0] = "0001";
        }
    }

    /*DVD instruction: Divide Register by Register*/
    public static void DVD(int rx, int ry, String ins) {
        if ((rx == 0 || rx == 2) && (ry == 0 || ry == 2)) {
            if (signB2D(gpr[ry]) == 0) {
                cc[2] = "0001";
                //throw new ArithmeticException("Condition code 3 Divide by zero");
            } else {
                int quotient = (signB2D(gpr[rx]) / signB2D(gpr[ry]));
                int remain = (signB2D(gpr[rx]) % signB2D(gpr[ry]));
                gpr[rx] = ext216(signD2B(quotient));
                gpr[rx + 1] = ext216(signD2B(remain));
            }
        }
    }

    /*TRR instruction: Test the Equality of Register and Register*/
    public static void TRR(int rxNum, int ryNum, String ins)
    {
        if(bToD(gpr[rxNum]) == bToD(gpr[ryNum])) {
            cc[3] = "0001";
        }
        else {
            cc[3] = "0000";
        }
    }

    /*AND instruction: Logical And of Register and Register*/
    public static void AND(int rxNum, int ryNum, String ins)
    {
        gpr[rxNum] = ext216(dToB(bToD(gpr[rxNum]) & bToD(gpr[ryNum])));
    }

    /*ORR instruction: Logical Or of Register and Register*/
    public static void ORR(int rxNum, int ryNum, String ins)
    {
        gpr[rxNum] = ext216(dToB(bToD(gpr[rxNum]) | bToD(gpr[ryNum])));
    }

    /*NOT instruction: Logical Not of Register To Register*/
    public static void NOT(int rxNum, int ryNum, String ins)
    {
        gpr[rxNum] = ext216(signD2B(~(signB2D(gpr[rxNum]))));
    }


    /*SRC instruction: Shift Register by Count*/
    public static void SRC(int gprNum, String ins)
    {
        count = bToD(ins.substring(12, 16));
        AOrL = bToD(ins.substring(8, 9));
        LOrR = bToD(ins.substring(9, 10));
        String temp;
        temp = gpr[gprNum];
        int x = bToD(temp);
        if(count == 0)
            ;
        else
        {
            if (AOrL == 0) //arithmetical shift
            {
                if(LOrR == 0) //shift right
                {
                    x = x >> count;
                    gpr[gprNum] = ext216(dToB(x));
                }
                if(LOrR == 1)//shift left
                {
                    x = x << count;
                    gpr[gprNum] = ext216(dToB(x));
                }
            }
            if (AOrL == 1) //logic shift
            {
                if(LOrR == 0)//shift right
                {
                    x = x >>> count;
                    gpr[gprNum] = ext216(dToB(x));
                }
                if(LOrR == 1)//shift left
                {
                    x = x << count;
                    gpr[gprNum] = ext216(dToB(x));
                }

            }
        }
    }

    /*Rotate Register by Count*/
    public static void RRC(int gprNum, String ins)
    {
        count = bToD(ins.substring(12, 16));
        AOrL = bToD(ins.substring(8, 9));
        LOrR = bToD(ins.substring(9, 10));
        String temp;
        temp = gpr[gprNum];
        int x = bToD(temp);
        if(count == 0)
            ;
        else
        {
            if(AOrL == 1)
            {
                if(LOrR == 0)//rotate right
                {
                    x = (x >> count | x >> (16 - count));
                    gpr[gprNum] = ext216(dToB(x));
                }
                if(LOrR == 1)//rotate left
                {
                    x = (x << count | x << (16 - count));
                    gpr[gprNum] = ext216(dToB(x));
                }
            }
        }
    }

    public static void IN(int gprNum, String ins) {
        String val = gui.consoleKeyboard.getText();
        char chr = val.charAt(0);
        gpr[gprNum] = ext216(dToB((int)chr));
        String newVal = val.substring(1);
        gui.consoleKeyboard.setText(newVal);
    }

    public static void OUT(int gprNum, String ins) {
        char chr = (char) bToD(gpr[gprNum]);
        String res = String.valueOf(chr);
        gui.displayPanel.append(res);
    }

    public static void CHK(int gprNum, String ins) {
    }

    public static void HLT(String ins) {
        // Do nothing
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

    public static int signB2D(String bi) {
        if (bi.length() < 16) {
            return (bToD(bi));
        }
        else {
            if (bi.substring(0, 1).equals("0")){
                return (bToD(bi));
            }
            else {
                return (-1 * ((int) Math.pow(2, 16) - bToD(bi)));
            }
        }
    }

    public static String signD2B(int n) {
        if (n >= 0) {
            return (ext216(dToB(n)));
        }
        else {
            return dToB((int)Math.pow(2, 16) + n);
        }
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

    /* extend strings to 12 bits with 0 */
    public static String ext212(String s) {
        int len = s.length();
        if (len < 12) {
            for (int i = 0; i < 12 - len; i++) {
                s = "0" + s;
            }
        }
        return s;
    }

    public static void loadProgram(HashMap<String, String> program) {
        if (program != null) {
            for (Map.Entry<String, String> entry : program.entrySet()) {
                int addr = Integer.parseInt(entry.getKey());
                String value = entry.getValue();
                memory[addr] = value;
            }
        }
    }

    public static void main(String[] args)  // don't need to implement this
    {    }

}

/*class for different instruction types*/
class InstType {
    public static final int HLT = 0; // Halt the program
    public static final int LDR = 1; //Load Register From Memory
    public static final int STR = 2; //Store Register To Memory
    public static final int LDA = 3; //Load Register with Address
    public static final int LDX = 41; //Load Index Register from Memory
    public static final int STX = 42; //Store Index Register to Memory

    public static final int JZ   = 10; //Jump if Zero
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
    public static final int DVD = 21; //Divide Register by Register
    public static final int TRR = 22; //Test the Equality of Register and Register
    public static final int AND = 23; //Logical And of Register and Register
    public static final int ORR = 24; //Logical Or of Register and Register
    public static final int NOT = 25; //Logical Not of Register To Register
    public static final int SRC = 31; //Shift Register by Count
    public static final int RRC = 32; //Rotate Register by Count
    public static final int IN = 61; //Input Character To Register from Device
    public static final int OUT = 62; //Output Character to Device from Register
    public static final int CHK = 63; //Check Device Status to Register
}