import java.io.*;

public class Simulator {
    public static String[] memory = new String[2048];
    public static String[] indexRegister = new String[3];
    public static String[] gpr = new String[4];
    public static String[] IPL = new String[10]; // Instructions preloaded
    public static String mar;
    public static String mbr;
    public static String pc;
    public static String cc;

    public static int opcode;
    public static int indexNumber;
    public static int gprNumber;
    public static int indirect;
    public static int address;
    public static String instruction = "0000011100011111";

    public static int FindEA(String ins) //Find effective address
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
               address = Integer.parseInt(indexRegister[indexNum]) + addr;
         }
      }
      if(indirect == 1)
      {
         if (indexNum == 0) {
             address = Integer.parseInt(memory[addr]);
         }
         else {
               address = Integer.parseInt(memory[Integer.parseInt(memory[Integer.parseInt(indexRegister[indexNum])]) + addr]);
         }
      }
      return address;
   }

   public static int findAddr(String ins)//find address from inputed instruction
   {
      int addr = bToD(ins.substring(11,16));
      return addr;
   }

   public int findOpcode(String ins)// find opcode from inputed instruction
   {
      int op = bToD(ins.substring(0,6));
      return op;
   }

   public int findGprNumber(String ins)// find GPR number from inputed instruction
   {
      int gprN = bToD(ins.substring(8,10));
      return gprN;
   }

   public static int findIndexNumber(String ins)// find index register number from inputed instruction
   {
      int indexN = bToD(ins.substring(8,10));
      return indexN;
   }

   public static int findIndirect(String ins)// find indirect number from inputed instruction
   {
      int indirectN = bToD(ins.substring(10,11));
      return indirectN;
   }

   public static void LDR(int gprNum, String ins) //LDR instruction
   {
      int address;
      String memoryVal;
      address = FindEA(ins);
      mar = Integer.toString(address);
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

   public static void STR(int gprNum, String ins) // STR instruction
   {
      int address;
      address = FindEA(ins);
      memory[address] = gpr[gprNum];
      mbr = memory[address];
   }

   public static void LDA(int gprNum, String ins) //LDA instruction
   {
      int address;
      address = FindEA(ins);
       gpr[gprNum] = ext216(dToB(address));
   }

   public static void LDX(int indexNum, String ins) //LDX instruction
   {
      int address;
      address = FindEA(ins);
      mar = Integer.toString(address);
      indexRegister[indexNum] = memory[address];
      mbr = memory[address];
   }

   public static void STX(int indexNum, String ins)// STX instruction
   {
      int address;
      address = FindEA(ins);
      memory[address] = indexRegister[indexNum];
      mbr = memory[address];
   }

   public static int bToD(String bi) //binary to decimal
   {
       return Integer.parseInt(bi,2);
   }

   public static String dToB(int n) { // decimal to binary
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

    public static String ext216(String s) {  // extend strings to 16 bits with 0
        int len = s.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                s = "0" + s;
            }
        }
        return s;
    }

   public static void main(String[] args) //test function
   {

      //memory = new memory[100];
      //indexRegister = new indexRegister[4];
      //gdr = new gdr[3];
      opcode = bToD(instruction.substring(0, 6));
      gprNumber = bToD(instruction.substring(6, 8));
      indexNumber = bToD(instruction.substring(8, 10));
      indirect = bToD(instruction.substring(10, 11));
      address = bToD(instruction.substring(11, 16));

      switch(opcode) {
         case InstType.LDR:
            LDR(gprNumber, instruction);
         case InstType.STR:
            STR(gprNumber, instruction);
         case InstType.LDA:
            LDA(gprNumber, instruction);
         case InstType.LDX:
            LDA(indexNumber, instruction);
         case InstType.STX:
            STX(indexNumber, instruction);
      }
   }

}

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