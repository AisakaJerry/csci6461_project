import java.util.HashMap;

public class prog1 {
	// This class stores the instructions of program 1
	public static HashMap<String, String> pgm1 = new HashMap<>();
	static {
		pgm1.put("6", "0000000000101100"); // ascii of ','
		// 7 ~ 26 store the 20 numbers
		// 27 store the 1 number
		pgm1.put("28", "0000000001100110"); // start of block (0)
		pgm1.put("29", "0000000000000111"); // 7 = the first address of the numbers
		pgm1.put("30", "0000000000010101"); // 21 numbers to read
		pgm1.put("31", "0000000111111001");

		pgm1.put("100", "0111110010001111"); // SRC Reset r0 = 0
		pgm1.put("101", "0000111100111110"); // LDA r3 with content of memory address 30
		// (0)
		pgm1.put("102", "0000111000100110"); // LDA r2 with content of memory address 6
		pgm1.put("103", "1111010100000000"); // IN r1
		pgm1.put("104", "0101100110000000"); // TRR r1, r2
		pgm1.put("105", "0000111000111100"); // LDA r2 with c(memory 28)
		pgm1.put("106", "0001101000010100"); // AIR r2, 20
		pgm1.put("107", "0000101000011100"); // Store r2 into location memory 28
		pgm1.put("108", "0011001100111100");// JCC cc=3 to c(memory 28) means jump to (1)
		pgm1.put("109", "0000111000111100");// Load r2 with c(memory 28)
		pgm1.put("110", "0001101000010100");// AIR r2, 20
		pgm1.put("111", "0000101000011100");// Store r2 into location memory 28
		pgm1.put("112", "0011010000111100");// JMA to c(memory 28) means jump to (2)
		// (1) it is a ','
		pgm1.put("122", "0000100000111101");// Store r0 into memory with a location of c(memory 29)
		pgm1.put("123", "‭0111110010001111");// reset r0
		pgm1.put("124", "0001100000001010");// AIR r0, 10
		pgm1.put("125", "1111100000000001");// print r0 to console
		pgm1.put("126", "0000110100111101");// Load r1 with content of memory address 29
		pgm1.put("127", "0001100100000001");// AIR r1 with 1
		pgm1.put("128", "0000100100011101");// Store r1 into memory address 29
		pgm1.put("129", "‭0111110010001111");// Reset r0
		pgm1.put("130", "0000111000111100");// Load r2 with c(memory 28)
		pgm1.put("131", "0001101000010100");// AIR r2, 20
		pgm1.put("132", "0001101000010100");// AIR r2, 20
		pgm1.put("133", "0000101000011100");// Store r2 into location memory 28
		pgm1.put("134", "0011010000111100");// JMA to c(memory 28) means jump to (3)
		// (2) it is a digit
		pgm1.put("142", "0000100000111101");// STR r0 into memory with a location of c(mem 29)
		pgm1.put("143", "0001000000111101");// AMR r0, c(memory 29) for 9 times => r0 *= 10
		pgm1.put("144", "0001000000111101");
		pgm1.put("145", "0001000000111101");
		pgm1.put("146", "0001000000111101");
		pgm1.put("147", "0001000000111101");
		pgm1.put("148", "0001000000111101");
		pgm1.put("149", "0001000000111101");
		pgm1.put("150", "0001000000111101");
		pgm1.put("151", "0001000000111101");
		pgm1.put("152", "1111100100000001");// print r1 to console
		pgm1.put("153", "0001110100011000");// r1 should subtract 48 to get a digit
		pgm1.put("154", "0001110100011000");
		pgm1.put("155", "0000100100111101");// Store r1 into memory with a location of c(memory 29)
		pgm1.put("156", "0001000000111101");// AMR r0, c(memory 29)
		pgm1.put("157", "0000111000111100");// LDA r2 with c(memory 28)
		pgm1.put("158", "0001111000010100");// SIR r2, 20
		pgm1.put("159", "0001111000010100");// SIR r2, 20
		pgm1.put("160", "0000101000011100");// Store r2 into location memory 28
		pgm1.put("161", "0011010000111100");// JMA to c(memory 28) means jump to (3)
		// (3)
		pgm1.put("162", "0000111000111100");// Load r2 with c(memory 28)s
		pgm1.put("163", "0001111000010100");// SIR r2, 20
		pgm1.put("164", "0001111000010100");// SIR r2, 20
		pgm1.put("165", "0001111000010100");// SIR r2, 20
		pgm1.put("166", "0000101000011100");// Store r2 into location memory 28
		pgm1.put("167", "0100001100111100");// SOB r3, c(memory 28)
		pgm1.put("168", "‭0111110010001111");// reset r0
		pgm1.put("169", "0001100000000001");// AIR r0, 1
		pgm1.put("170", "0000100000011110");// store r0 to m(30)
	}

	public static HashMap<String, String> pgm2 = new HashMap<>();
	static {
		pgm2.put("300", "AIR r0 7");
		//pgm2.put("301", "");
	}


}
