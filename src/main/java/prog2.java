/***************************************************************************
 * prog2.java
 * This is the program2 that reads a set of a paragraph of 6 sentences
 * from a file into memory. It prints the sentences on the console printer.
 * It then asks the user for a word. It searches the paragraph to see if it
 * contains the word. If so, it prints out the word, the sentence number,
 * and the word number in the sentence.
 **************************************************************************/

import java.util.HashMap;

public class prog2 {
    public static final HashMap<String, String> pgm1 = new HashMap<>();
    // preparation for program2
    static {
        pgm1.put("31", "0000000000000000"); // length of the sentence 0
        pgm1.put("30", "0000000000000000"); // length of the word 0
        pgm1.put("29", "0000000000000001"); // current sentence 1
        pgm1.put("28", "0000000000000001"); // current word of sentence 1
        pgm1.put("27", "0000000000100000"); // ascii of space 32
        pgm1.put("26", "0000000000000000"); // ascii of 0 0
        pgm1.put("25", "0000000000101110"); // ascii of period 46
        pgm1.put("24", "0000000000000000"); // r1 0
        pgm1.put("22", "1111111111111111"); // i -1
        pgm1.put("21", "0000000000000000"); // j 0
        pgm1.put("20", "0000000001100011"); // m(100) start of sentences 99
        pgm1.put("19", "0000000001001111"); // m(80) start of word or 80 79
        pgm1.put("18", "0000010101111001"); // start of (0) in pgm1 1401
        pgm1.put("17", "0000010111011101"); // start of (0) in pgm3 1501
        pgm1.put("16", "0000000001010000"); // clear location to 80 80
        pgm1.put("15", "0000001110001000"); // the first JMA 904
        pgm1.put("14", "0000001111011101"); // END of the program 989
        pgm1.put("13", "0000001110110111"); // the second JMA 951
        pgm1.put("12", "0000001111000001"); // the third JMA 961
        pgm1.put("11", "0000001110101001"); // the forth JMA 937
        pgm1.put("10", "0000001111001001"); // the fifth JMA 969
        pgm1.put("9", "0000001111010011"); // the sixth JMA 979
        pgm1.put("8", "0000001110000110"); // the third JMA to for 902
        pgm1.put("7", "0000000001010000"); //80
    }

    public static final HashMap<String, String> pgm2 = new HashMap<>();
    // read the paragraph
    static {
        pgm2.put("1400", "0000111100110100"); // Load r3 with content of m(20)
        // (0)
        pgm2.put("1401", "1111010100000010"); // IN r1, 2
        pgm2.put("1402", "0000111000110010"); // Load r2 with content of m(18)
        pgm2.put("1403", "0001101000010100"); // AIR r2, 20
        pgm2.put("1404", "0000101000010010"); // Store r2 into m(18)
        pgm2.put("1405", "0010100100110010"); // JZ r1, content of m(18), means jump to
        // (1) if r1 != 0
        pgm2.put("1406", "1111100100000001"); // OUT r1, 1
        pgm2.put("1407", "0000110000111111"); // Load r0 with content of m(31)
        pgm2.put("1408", "0001100000000001"); // AIR r0, 1
        pgm2.put("1409", "0000100000011111"); // Store r0 into m(31)
        pgm2.put("1410", "0000110000110100"); // Load r0 with content of m(20)
        pgm2.put("1411", "0001100000000001"); // AIR r0, 1
        pgm2.put("1412", "0000100000010100"); // Store r0 into m(20)
        pgm2.put("1413", "0000100100110100"); // Store r1 into content of m(20)
        pgm2.put("1414", "0000111000110010"); // Load r2 with content of m(18)
        pgm2.put("1415", "0001111000010100"); // SIR r2, 20
        pgm2.put("1416", "0000101000010010"); // Store r2 into m(18)
        pgm2.put("1417", "0011010000110010"); // JMA content of m(18), means jump to (0)

        // (1) if r1 == 0
        pgm2.put("1421", "0111110110001111"); // SRC reset r1 to 0
        pgm2.put("1422", "0001100100001010"); // AIR r1, 10
        pgm2.put("1423", "1111100100000000"); // OUT r1, 1
        pgm2.put("1424", "0000101100010100"); // Store r3 into m(20)

    }

    public static final HashMap<String, String> pgm3 = new HashMap<>();
    // read the word
    static {
        pgm3.put("1500", "0000111100110011"); // Load r3 with content of m(19)
        // (0)
        pgm3.put("1501", "1111010100000000"); // IN r1, 0
        pgm3.put("1502", "0000111000110001"); // Load r2 with content of m(17)
        pgm3.put("1503", "0001101000010100"); // AIR r2, 20
        pgm3.put("1504", "0000101000010001"); // Store r2 into m(17)
        pgm3.put("1505", "0010100100110001"); // JZ r1, content of m(17), means jump to
        // (1) if r1 != 0
        pgm3.put("1506", "1111100100000001"); // OUT r1, 1
        pgm3.put("1507", "0000110000111110"); // Load r0 with content of m(30)
        pgm3.put("1508", "0001100000000001"); // AIR r0, 1
        pgm3.put("1509", "0000100000011110"); // Store r0 into m(30)
        pgm3.put("1510", "0000110000110011"); // Load r0 with content of m(19)
        pgm3.put("1511", "0001100000000001"); // AIR r0, 1
        pgm3.put("1512", "0000100000010011"); // Store r0 into m(19)
        pgm3.put("1513", "0000100100110011"); // Store r1 into content of m(19)
        pgm3.put("1514", "0000111000110001"); // Load r2 with content of m(17)
        pgm3.put("1515", "0001111000010100"); // SIR r2, 20
        pgm3.put("1516", "0000101000010001"); // Store r2 into m(17)
        pgm3.put("1517", "0011010000110001"); // JMA content of m(17), means jump to (0)

        // (1) if r1 == 0
        pgm3.put("1521", "0111110110001111"); // SRC reset r1 to 0
        pgm3.put("1522", "0001100100001010"); // AIR r1, 10
        pgm3.put("1523", "1111100100000001"); // OUT r1, 1
        pgm3.put("1524", "0000101100010011"); // Store r3 into m(19)



    }
    public static final HashMap<String, String> pgm4 = new HashMap<>();
    // find the word
    static {
        pgm4.put("900", "0000011000011111");// LDR r3 from M(31)
        pgm4.put("901", "0001101000000001");// AIR r3+1
        pgm4.put("902", "0100001000101111"); // SOB r3 *
        pgm4.put("903", "0011010000101110"); // JMA to the final STOP   14
        pgm4.put("904", "0000010000010110"); // LDR r0 from M(22) !
        pgm4.put("905", "0001100000000001");// AIR r0+1
        pgm4.put("906", "0000100000010110"); // STR r0 to M (22)
        pgm4.put("907", "0000010000010100"); // LDR M (20) =99
        pgm4.put("908", "0001100000000001"); // AIR r0+1
        pgm4.put("909", "0000100000010100"); // STR r0 to M(20)
        pgm4.put("910", "0000010100110100"); // LDR r1 form M(100) indirect
        pgm4.put("911", "0000010000011001"); // LDR r0 from M(25)= 46
        pgm4.put("912", "0101100001000000"); // TRR r1 and r0
        pgm4.put("913", "0011001100101101"); // JCC cc3 if 1 if not 0 continue   13
        pgm4.put("914", "0000010000011011"); // LDR r0 from M(27)= 32
        pgm4.put("915", "0101100001000000"); // TRR r1 and r0
        pgm4.put("916", "0011001100101100"); // JCC cc3 if 1 if not 0 continue   12
        pgm4.put("917", "0000011000100111"); // LDR r2 from M(7)=80 first capital from wor
        pgm4.put("918", "0101100110000000"); // TRR r1 and r2
        pgm4.put("919", "0011001100101011"); // JCC cc3 if 1 if not 0 continue   11
        pgm4.put("920", "0000010000010110"); // LDR r0 from M(22)
        pgm4.put("921", "0001010000010101"); // SMR r0 –M(21)
        pgm4.put("922", "0000100000010110"); // STR r0 to M(22)
        pgm4.put("923", "0000010000010100"); // LDR r0 from M(20)
        pgm4.put("924", "0001010000010101"); // SMR r0 –M(21)
        pgm4.put("925", "0000100000010100"); // STR r0 to M(20) i= i-j
        pgm4.put("926", "0000010000011001"); // LDR r0 from M(25)
        pgm4.put("927", "0101100001000000"); // TRR r1 and r0
        pgm4.put("928", "0011001100101010"); // JCC cc3 if 1 if not 0 continue  10
        pgm4.put("929", "0000010000011011"); // LDR r0 from M(27)
        pgm4.put("930", "0101100001000000"); // TRR r1 and r0
        pgm4.put("931", "0011001100101001"); // JCC cc3 if 1 if not 0 continue  9
        pgm4.put("932", "0000010000011010"); // LDR r0 from M(26)=0
        pgm4.put("933", "0000100000010101"); // STR r0 to M (21)
        pgm4.put("934", "0000010000010000"); // LDR r0 from M(16)=81
        pgm4.put("935", "0000100000000111"); // STR r0 to M (7)
        pgm4.put("936", "0011010000101000"); // JMA EA8 =* 902
        pgm4.put("937", "0000010000010101"); // LDR r0 from M(21) j %
        pgm4.put("938", "0000100100011000"); // STR r1 to M(24) r1
        pgm4.put("939", "0000010100011110"); // LDR r1 from M(31)
        pgm4.put("940", "0001110100000001"); // SIR r1-1
        pgm4.put("941", "0101100001000000"); // TRR r1 and r0
        pgm4.put("942", "0000010100011000"); // LDR r1 from M(24)
        pgm4.put("943", "0011001100101110"); // JCC cc3 if 1 if not 0 continue  14
        pgm4.put("944", "0000010000010101"); // LDR r0 from M(21) j
        pgm4.put("945", "0001100000000001"); // AIR r0+1
        pgm4.put("946", "0000100000010101"); // STR r0 to M(21)
        pgm4.put("947", "0000010000000111"); // LDR r0 from M(7)
        pgm4.put("948", "0001100000000001"); // AIR r0+1
        pgm4.put("949", "0000100000000111"); // STR r0 to M(7) c
        pgm4.put("950", "0011010000101000"); // // JMA to for    8
        pgm4.put("951", "0000010000011101"); // LDR r0 from M(29) cs #
        pgm4.put("952", "0001100000000001"); // AIR r0+1
        pgm4.put("953", "0000100000011101"); // STR r0 to M(29)
        pgm4.put("954", "0000010000011010"); // LDR r0 from M(26)=0
        pgm4.put("955", "0000100000011100"); // STR r0 to M(28)
        pgm4.put("956", "0000010000001101"); // LDR r0 from M(13) 951
        pgm4.put("957", "0001110000011111"); // SIR 951-31=920
        pgm4.put("958", "0001110000000110"); // SIR 920-6=914
        pgm4.put("959", "0000100000000110"); // STR r0 to M(6)
        pgm4.put("960", "0011010000100110"); // JMA to 14
        pgm4.put("961", "0000010000011100"); // LDR r0 from M(28) cw $
        pgm4.put("962", "0001100000000001"); // AIR r0+1
        pgm4.put("963", "0000100000011100"); // STR r0 to M(28)
        pgm4.put("964", "0000010000001101"); // LDR r0 from M(12) 961
        pgm4.put("965", "0001110000011111"); // SIR 961-31=930
        pgm4.put("966", "0001110000001101"); // SIR 930-13=917
        pgm4.put("967", "0000100000000110"); // STR r0 to M(6)
        pgm4.put("968", "0011010000100110"); // JMA to 17
        pgm4.put("969", "0000010000001010"); // LDR r0 from M(10) 969 ^
        pgm4.put("970", "0001110000011111"); // SIR 969-31=938
        pgm4.put("971", "0001110000001001"); // SIR 938-9=929
        pgm4.put("972", "0000100000000110"); // STR r0 to M(6)
        pgm4.put("973", "0000010000010101"); // LDR r0 from M(21)
        pgm4.put("974", "0010100000100110"); // JZ j if 0
        pgm4.put("975", "0000010000011101"); // LDR r0 from M(29) cs
        pgm4.put("976", "0001110000000001"); // SIR -1 cs-1
        pgm4.put("977", "0000100000011101"); // STR r0 to M(29)
        pgm4.put("978", "0011010000100110"); // JMA to 29
        pgm4.put("979", "0000010000001001"); // LDR r0 from M(9) 979 ^
        pgm4.put("980", "0001110000011111"); // SIR 979-31=948
        pgm4.put("981", "0001110000010000"); // SIR 948-16=932
        pgm4.put("982", "0000100000000110"); // STR r0 to M(6)
        pgm4.put("983", "0000010000010101"); // LDR r0 from M(21) j
        pgm4.put("984", "0010100000100110"); // JZ j if 0
        pgm4.put("985", "0000010000011100"); // LDR r0 from M(28) cws
        pgm4.put("986", "0001110000000001"); // SIR -1 cs-1
        pgm4.put("987", "0000100000011100"); // STR r0 to M(28)
        pgm4.put("988", "0011010000100110"); // JMA to 32     6
        pgm4.put("989", "0000010000011101"); // out LDR r0 from M(29)
    }

    public static final HashMap<String, String> pgm5 = new HashMap<>();
    // print the result in m(30)
    static {
        // presets of this single program
        pgm5.put("31", "0000010001010101"); // start of the block (0)
        // m(30) store the number that you want to print
        pgm5.put("6", "0000000000110010"); // store every digit of the numbers starting from
        // m(50), example: for number 31 we store like this,
        // m(50)=10 (new line sign), m(51)=49 (ascii of '1'), m(52)=51 (ascii of
        // '3')

        pgm5.put("1100", "0111110110001111"); // reset r1
        pgm5.put("1101", "0001100100001010"); // AIR r1, 10
        pgm5.put("1102", "0000100100100110"); // store r1 into location of content of m(6)
        pgm5.put("1103", "0000111100100110"); // load r3 with content of m(6)
        pgm5.put("1104", "0001101100000001"); // AIR r3, 1
        pgm5.put("1105", "0000101100000110"); // store r3 into m(6)
        pgm5.put("1106", "0111111010001111"); // reset r2
        pgm5.put("1107", "0001101000001010"); // AIR r2, 10
        pgm5.put("1108", "0000110000111101"); // load r0 with content of m(29)

        // (0)
        pgm5.put("1109", "0101010010000000"); // DVD r0, r2
        pgm5.put("1110", "0000111100111111");// load r3 with content of m(31)
        pgm5.put("1111", "0001101100010100");// AIR r3, 20
        pgm5.put("1112", "0000101100011111");// store r3 into m(31)
        pgm5.put("1113", "0010100000111111");// JZ r0, content of m(31), means if r0 == 0
        // jump to (1)
        pgm5.put("1114", "0001100100011000");// r1 + 48, convert to ascii
        pgm5.put("1115", "0001100100011000");
        pgm5.put("1116", "0000100100100110");// store r1 into location of content of m(6)
        pgm5.put("1117", "0000111100100110");// load r3 with content of m(6)
        pgm5.put("1118", "0001101100000001");// AIR r3, 1
        pgm5.put("1119", "0000101100000110");// store r3 into m(6)
        pgm5.put("1120", "0000111100111111");// load r3 with content of m(31)
        pgm5.put("1121", "0001111100010100");// SIR r3, 20
        pgm5.put("1122", "0000101100011111");// store r3 into m(31)
        pgm5.put("1123", "0011010000111111");// JMA, content of m(31), means jump to (0)
        // (1) r0 == 0, means has reach the highest digit of the number
        pgm5.put("1129", "0001100100011000");// r1 + 48, convert to ascii
        pgm5.put("1130", "0001100100011000");
        pgm5.put("1131", "0000100100100110");// store r1 into location of content of m(6)
        pgm5.put("1132", "0000111100111111");// load r3 with content of m(31)
        pgm5.put("1133", "0001101100010100");// AIR r3, 20
        pgm5.put("1134", "0000101100011111");// store r3 into m(31)
        pgm5.put("1135", "0111111010001111");// reset r2
        pgm5.put("1136", "0001101000001010");// AIR r2, 10 (new line sign, use to compare)
        pgm5.put("1137", "0011010000111111");// JMA, content of m(31), means jump to (2)
        // (2) print the digit one by one
        pgm5.put("1149", "0000010100100110");// load r1 with address of content of m(6)
        pgm5.put("1150", "1111100100000001");// print r1 to console
        pgm5.put("1151", "0000111100111111");// load r3 with content of m(31)
        pgm5.put("1152", "0001101100010100");// AIR r3, 20
        pgm5.put("1153", "0000101100011111");// store r3 into m(31)
        pgm5.put("1154", "0101100110000000");// TRR r1, r2
        pgm5.put("1155", "0011001100111111");// JCC cc(3), content of m(31), mean jump to
        // (3)
        pgm5.put("1156", "0000111100100110");// load r3 with content of m(6)
        pgm5.put("1157", "0001111100000001");// SIR r3, 1
        pgm5.put("1158", "0000101100000110");// store r3 into m(6)
        pgm5.put("1159", "0000111100111111");// load r3 with content of m(31)
        pgm5.put("1160", "0001111100010100");// SIR r3, 20
        pgm5.put("1161", "0000101100011111");// store r3 into m(31)
        pgm5.put("1162", "0011010000111111");// JMA, content of m(31), means jump to (2)

        // (3) finish printing the numbers
        pgm5.put("1169", "0000000000000000");
    }
    public static final HashMap<String, String> pgm6 = new HashMap<>();
    // print the result in m(30)
    static {
        // presets of this single program
        pgm6.put("31", "0000001111110001"); // start of the block (0)
        // m(30) store the number that you want to print
        pgm6.put("6", "0000000000110010"); // store every digit of the numbers starting from
        // m(50), example: for number 31 we store like this,
        // m(50)=10 (new line sign), m(51)=49 (ascii of '1'), m(52)=51 (ascii of
        // '3')

        pgm6.put("1000", "0111110110001111"); // reset r1
        pgm6.put("1001", "0001100100001010"); // AIR r1, 10
        pgm6.put("1002", "0000100100100110"); // store r1 into location of content of m(6)
        pgm6.put("1003", "0000111100100110"); // load r3 with content of m(6)
        pgm6.put("1004", "0001101100000001"); // AIR r3, 1
        pgm6.put("1005", "0000101100000110"); // store r3 into m(6)
        pgm6.put("1006", "0111111010001111"); // reset r2
        pgm6.put("1007", "0001101000001010"); // AIR r2, 10
        pgm6.put("1008", "0000110000111100"); // load r0 with content of m(28)

        // (0)
        pgm6.put("1009", "0101010010000000"); // DVD r0, r2
        pgm6.put("1010", "0000111100111111");// load r3 with content of m(31)
        pgm6.put("1011", "0001101100010100");// AIR r3, 20
        pgm6.put("1012", "0000101100011111");// store r3 into m(31)
        pgm6.put("1013", "0010100000111111");// JZ r0, content of m(31), means if r0 == 0
        // jump to (1)
        pgm6.put("1014", "0001100100011000");// r1 + 48, convert to ascii
        pgm6.put("1015", "0001100100011000");
        pgm6.put("1016", "0000100100100110");// store r1 into location of content of m(6)
        pgm6.put("1017", "0000111100100110");// load r3 with content of m(6)
        pgm6.put("1018", "0001101100000001");// AIR r3, 1
        pgm6.put("1019", "0000101100000110");// store r3 into m(6)
        pgm6.put("1020", "0000111100111111");// load r3 with content of m(31)
        pgm6.put("1021", "0001111100010100");// SIR r3, 20
        pgm6.put("1022", "0000101100011111");// store r3 into m(31)
        pgm6.put("1023", "0011010000111111");// JMA, content of m(31), means jump to (0)

        // (1) r0 == 0, means has reach the highest digit of the number
        pgm6.put("1029", "0001100100011000");// r1 + 48, convert to ascii
        pgm6.put("1030", "0001100100011000");
        pgm6.put("1031", "0000100100100110");// store r1 into location of content of m(6)
        pgm6.put("1032", "0000111100111111");// load r3 with content of m(31)
        pgm6.put("1033", "0001101100010100");// AIR r3, 20
        pgm6.put("1034", "0000101100011111");// store r3 into m(31)
        pgm6.put("1035", "0111111010001111");// reset r2
        pgm6.put("1036", "0001101000001010");// AIR r2, 10 (new line sign, use to compare)
        pgm6.put("1037", "0011010000111111");// JMA, content of m(31), means jump to (2)

        // (2) print the digit one by one
        pgm6.put("1049", "0000010100100110");// load r1 with address of content of m(6)
        pgm6.put("1050", "1111100100000001");// print r1 to console
        pgm6.put("1051", "0000111100111111");// load r3 with content of m(31)
        pgm6.put("1052", "0001101100010100");// AIR r3, 20
        pgm6.put("1053", "0000101100011111");// store r3 into m(31)
        pgm6.put("1054", "0101100110000000");// TRR r1, r2
        pgm6.put("1055", "0011001100111111");// JCC cc(3), content of m(31), mean jump to
        // (3)
        pgm6.put("1056", "0000111100100110");// load r3 with content of m(6)
        pgm6.put("1057", "0001111100000001");// SIR r3, 1
        pgm6.put("1058", "0000101100000110");// store r3 into m(6)
        pgm6.put("1059", "0000111100111111");// load r3 with content of m(31)
        pgm6.put("1060", "0001111100010100");// SIR r3, 20
        pgm6.put("1061", "0000101100011111");// store r3 into m(31)
        pgm6.put("1062", "0011010000111111");// JMA, content of m(31), means jump to (2)

        // (3) finish printing the numbers
        pgm6.put("1069", "0000000000000000");
    }
}
