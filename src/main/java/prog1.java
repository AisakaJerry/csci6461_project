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
		pgm1.put("123", "0111110010001111");// reset r0
		pgm1.put("124", "0001100000001010");// AIR r0, 10
		pgm1.put("125", "1111100000000001");// print r0 = \n to console
		pgm1.put("126", "0000110100111101");// Load r1 with content of memory address 29
		pgm1.put("127", "0001100100000001");// AIR r1 with 1
		pgm1.put("128", "0000100100011101");// Store r1 into memory address 29 // store to next memory slot
		pgm1.put("129", "0111110010001111");// Reset r0
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
		pgm1.put("161", "0011010000111100");// JMA to c(memory 28) means jump to (0)
		// (3)
		pgm1.put("162", "0000111000111100");// Load r2 with c(memory 28)s
		pgm1.put("163", "0001111000010100");// SIR r2, 20
		pgm1.put("164", "0001111000010100");// SIR r2, 20
		pgm1.put("165", "0001111000010100");// SIR r2, 20
		pgm1.put("166", "0000101000011100");// Store r2 into location memory 28
		pgm1.put("167", "0100001100111100");// SOB r3, c(memory 28)
		pgm1.put("168", "0111110010001111");// reset r0
		pgm1.put("169", "0001100000000001");// AIR r0, 1
		pgm1.put("170", "0000100000011110");// store r0 to m(30)
	}

	public static HashMap<String, String> pgm2 = new HashMap<>();
	static {
		pgm2.put("28", "0000000100101101"); // 301 into m28: head of program
		pgm2.put("29", "0111111111111111"); // max number = 32767 to m(299)
		pgm2.put("31", "0000000100110010"); // 306 into m31
		pgm2.put("298", "0111110010001111"); // reset r0
		pgm2.put("299", "0001100000000111");  // AIR r0 7
		pgm2.put("300", "0000100000011110");  // STR r0 m30
		// (0)
		pgm2.put("301", "0000011000111110");    // LDR r2 m(m30)
		pgm2.put("302", "0001011000011011");    // SMR r2, m27
		pgm2.put("303", "0100011000111111");  // JGE r2 m31 if r2>=0: continue to 306

		pgm2.put("304", "0110011000000000");      // else:
		pgm2.put("305", "0001101000000001");    // r2 = -r2

		pgm2.put("306", "0001011000011101"); // SMR r2, m29  // r2 = r2 - min
		pgm2.put("307", "0000011100011111"); // load r3 with m31
		pgm2.put("308", "0001101100001010"); // AIR r3 10 -> r3 = 316
		pgm2.put("309", "0000101100011111"); // store r3=316 to m31
		pgm2.put("310", "0100011000111111"); // JGE r2, m31 // if r2 >=0: jump to 316
		// if r2 < 0:
		pgm2.put("311", "0111110110001111");  // reset r1
		pgm2.put("312", "0001001000011101");  // AMR r2 m29
		pgm2.put("313", "0000101000011101");  // STR r2 m29
		pgm2.put("314", "0000010100111110");  // LDR r1 m(m30)
		pgm2.put("315", "0000100100000110"); // store the r1 (result) in m(6)
		// (1)
		pgm2.put("316", "0001100000000001");  // AIR r0 1
		pgm2.put("317", "0000100000011110");  // STR r0 m(30)
		pgm2.put("318", "0000010100011110");  // LDR r1 m(30)
		pgm2.put("319", "0001110100011011");  // SIR r1 27
		pgm2.put("320", "0001101100010100"); // AIR r3 20 -> r3 = 336
		pgm2.put("321", "0000101100011111"); // store r3=336 to m31
		pgm2.put("322", "0100010100111111");  // JGE r1, m31
		pgm2.put("323", "0001111100011110");  // SIR r3 30 -> r3 = 306
		pgm2.put("324", "0000101100011111");  // store r3=306 to m31
		pgm2.put("325", "0011010000111100");  // JMA m28
		// (2)
		pgm2.put("336", "0111111110001111");  // reset r3
		pgm2.put("337", "0001101100001010");  // AIR r3 10
		pgm2.put("338", "1111101100000001");  // OUT r3
		pgm2.put("339", "0111111110001111");  // reset r3
		pgm2.put("340", "0000011100000110");  // LDR r3 m6
		pgm2.put("341", "0000101100011110");  // STR r3 30
	}
	
	public static HashMap<String, String> pgm3 = new HashMap<>();
	static {
		pgm3.put("31",   "0000000111111101"); // start of the block (0)
		// m(30) store the number that you want to print
		pgm3.put("6",    "0000000000110010"); // store every digit of the numbers starting from m(50)
		// program begins
		pgm3.put("500", "0111110110001111"); // reset r1
		pgm3.put("501", "0001100100001010"); // AIR r1, 10
		pgm3.put("502", "0000100100100110"); // store r1 into location of content of m(6)
		pgm3.put("503", "0000111100100110"); // load r3 with content of m(6)
		pgm3.put("504", "0001101100000001"); // AIR r3, 1
		pgm3.put("505", "0000101100000110"); // store r3 into m(6)   // m6 += 1
		pgm3.put("506", "0111111010001111"); // reset r2
		pgm3.put("507", "0001101000001010"); // AIR r2, 10
		pgm3.put("508", "0000110000111110"); // load r0 with content of m(30)
		// (0)
		pgm3.put("509", "0101010010000000"); // DVD r0, r2
		pgm3.put("510", "0000111100111111");// load r3 with content of m(31)
		pgm3.put("511", "0001101100010100");// AIR r3, 20
		pgm3.put("512", "0000101100011111");// store r3 into m(31)
		pgm3.put("513", "0010100000111111");// JZ r0, content of m(31), means if r0 == 0 jump to (1)
		pgm3.put("514", "0001100100011000");// r1 + 48, convert to ascii
		pgm3.put("515", "0001100100011000");
		pgm3.put("516", "0000100100100110");// store r1 into location of content of m(6)
		pgm3.put("517", "0000111100100110");// load r3 with content of m(6)
		pgm3.put("518", "0001101100000001");// AIR r3, 1
		pgm3.put("519", "0000101100000110");// store r3 into m(6)
		pgm3.put("520", "0000111100111111");// load r3 with content of m(31)
		pgm3.put("521", "0001111100010100");// SIR r3, 20
		pgm3.put("522", "0000101100011111");// store r3 into m(31)
		pgm3.put("523", "0011010000111111");// JMA, content of m(31), means jump to (0)

		// (1) r0 == 0, means has reach the highest digit of the number
		pgm3.put("529", "0001100100011000");// r1 + 48, convert to ascii
		pgm3.put("530", "0001100100011000");
		pgm3.put("531", "0000100100100110");// store r1 into location of content of m(6)
		pgm3.put("532", "0000111100111111");// load r3 with content of m(31)
		pgm3.put("533", "0001101100010100");// AIR r3, 20
		pgm3.put("534", "0000101100011111");// store r3 into m(31)
		pgm3.put("535", "0111111010001111");// reset r2
		pgm3.put("536", "0001101000001010");// AIR r2, 10 (new line sign, use to compare)
		pgm3.put("537", "0011010000111111");// JMA, content of m(31), means jump to (2)

		// (2) print the digit one by one
		pgm3.put("549", "0000010100100110");// load r1 with address of content of m(6)
		pgm3.put("550", "1111100100000001");// print r1 to console
		pgm3.put("551", "0000111100111111");// load r3 with content of m(31)
		pgm3.put("552", "0001101100010100");// AIR r3, 20
		pgm3.put("553", "0000101100011111");// store r3 into m(31)
		pgm3.put("554", "0101100110000000");// TRR r1, r2
		pgm3.put("555", "0011001100111111");// JCC cc(3), content of m(31), mean jump to (3)
		pgm3.put("556", "0000111100100110");// load r3 with content of m(6)
		pgm3.put("557", "0001111100000001");// SIR r3, 1
		pgm3.put("558", "0000101100000110");// store r3 into m(6)
		pgm3.put("559", "0000111100111111");// load r3 with content of m(31)
		pgm3.put("560", "0001111100010100");// SIR r3, 20
		pgm3.put("561", "0000101100011111");// store r3 into m(31)
		pgm3.put("562", "0011010000111111");// JMA, content of m(31), means jump to (2)

		// (3) finish printing the numbers
		pgm3.put("569", "0000000000000000"); // HLT
	}
}
