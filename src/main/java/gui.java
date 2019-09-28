import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pranaypatodi
 */
public class gui extends javax.swing.JFrame {

	/**
	 * Creates new form gui
	 */
	private void jTextFieldInputAdressActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	/*Button for load memory value in inputed memory address*/
	private void buttonLoadActionPerformed(ActionEvent e) {
		int memAddress = Integer.parseInt(memoryAddressTextField.getText());
		memoryValueTextField.setText(Simulator.memory[memAddress]);
	}

	/*button for store inputed memory value in inputed memory address*/
	private void buttonStoreActionPerformed(ActionEvent e) {
		String memValue = memoryValueTextField.getText();
		int memAddress = Integer.parseInt(memoryAddressTextField.getText());
		Simulator.memory[memAddress] = memValue;
	}

	public gui() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	// Generated using JFormDesigner Evaluation license - unknown
	private void initComponents() {
		LabelMAR = new JLabel();
		LabelMBR = new JLabel();
		jTextFieldR1 = new JTextField();
		jTextFieldMBR = new JTextField();
		jLabel3 = new JLabel();
		jButtonR0 = new JButton();
		jButtonR1 = new JButton();
		jButtonR2 = new JButton();
		jButtonR3 = new JButton();
		jButtonX2 = new JButton();
		jButtonX3 = new JButton();
		jButtonX1 = new JButton();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jButtonInputWrite = new JButton();
		jScrollPane1 = new JScrollPane();
		jTextPaneInstructions = new JTextPane();
		jSeparator1 = new JSeparator();
		jSeparator2 = new JSeparator();
		jTextFieldMAR = new JTextField();
		jTextFieldR0 = new JTextField();
		jTextFieldR3 = new JTextField();
		jTextFieldR2 = new JTextField();
		jTextFieldX3 = new JTextField();
		jTextFieldX2 = new JTextField();
		jTextFieldX1 = new JTextField();
		jButtonMBR = new JButton();
		jButtonMAR = new JButton();
		jLabelR3 = new JLabel();
		jTextFieldPC = new JTextField();
		LabelPC = new JLabel();
		LabelR0 = new JLabel();
		LabelR1 = new JLabel();
		jLabelR2 = new JLabel();
		jLabelX3 = new JLabel();
		jLabelX1 = new JLabel();
		jLabelX2 = new JLabel();
		jLabel14 = new JLabel();
		jSeparator3 = new JSeparator();
		jTextFieldInputValue = new JTextField();
		jSeparator4 = new JSeparator();
		jButtonSingleRun = new JButton();
		jButtonIPL = new JButton();
		jSeparator5 = new JSeparator();
		jLabel15 = new JLabel();
		jSeparator6 = new JSeparator();
		jTextFieldMFR = new JTextField();
		jTextFieldCC = new JTextField();
		jTextFieldIR = new JTextField();
		jLabelMFR = new JLabel();
		jLabelIR = new JLabel();
		jLabelCC = new JLabel();
		jTextFieldMSR = new JTextField();
		jLabelMSR = new JLabel();
		memoryValueTextField = new JTextField();
		buttonLoad = new JButton();
		memoryAddressTextField = new JTextField();
		label1 = new JLabel();
		label2 = new JLabel();
		buttonStore = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		var contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- LabelMAR ----
		LabelMAR.setText("MAR");
		contentPane.add(LabelMAR);
		LabelMAR.setBounds(20, 30, 230, 30);

		//---- LabelMBR ----
		LabelMBR.setText("MBR");
		contentPane.add(LabelMBR);
		LabelMBR.setBounds(20, 60, 220, 30);

		//---- jTextFieldR1 ----
		jTextFieldR1.addActionListener(e -> jTextFieldR1ActionPerformed(e));
		contentPane.add(jTextFieldR1);
		jTextFieldR1.setBounds(60, 200, 320, jTextFieldR1.getPreferredSize().height);
		contentPane.add(jTextFieldMBR);
		jTextFieldMBR.setBounds(60, 60, 320, jTextFieldMBR.getPreferredSize().height);

		//---- jLabel3 ----
		jLabel3.setText("History Instructions");
		contentPane.add(jLabel3);
		jLabel3.setBounds(new Rectangle(new Point(690, 10), jLabel3.getPreferredSize()));

		//---- jButtonR0 ----
		jButtonR0.setText("Write");
		jButtonR0.addActionListener(e -> jButtonR0ActionPerformed(e));
		contentPane.add(jButtonR0);
		jButtonR0.setBounds(new Rectangle(new Point(380, 160), jButtonR0.getPreferredSize()));

		//---- jButtonR1 ----
		jButtonR1.setText("Write");
		jButtonR1.addActionListener(e -> jButtonR1ActionPerformed(e));
		contentPane.add(jButtonR1);
		jButtonR1.setBounds(new Rectangle(new Point(380, 200), jButtonR1.getPreferredSize()));

		//---- jButtonR2 ----
		jButtonR2.setText("Write");
		jButtonR2.addActionListener(e -> jButtonR2ActionPerformed(e));
		contentPane.add(jButtonR2);
		jButtonR2.setBounds(new Rectangle(new Point(380, 240), jButtonR2.getPreferredSize()));

		//---- jButtonR3 ----
		jButtonR3.setText("Write");
		jButtonR3.addActionListener(e -> jButtonR3ActionPerformed(e));
		contentPane.add(jButtonR3);
		jButtonR3.setBounds(new Rectangle(new Point(380, 280), jButtonR3.getPreferredSize()));

		//---- jButtonX2 ----
		jButtonX2.setText("Write");
		jButtonX2.addActionListener(e -> jButtonX2ActionPerformed(e));
		contentPane.add(jButtonX2);
		jButtonX2.setBounds(new Rectangle(new Point(380, 390), jButtonX2.getPreferredSize()));

		//---- jButtonX3 ----
		jButtonX3.setText("Write");
		jButtonX3.addActionListener(e -> jButtonX3ActionPerformed(e));
		contentPane.add(jButtonX3);
		jButtonX3.setBounds(new Rectangle(new Point(380, 430), jButtonX3.getPreferredSize()));

		//---- jButtonX1 ----
		jButtonX1.setText("Write");
		jButtonX1.addActionListener(e -> jButtonX1ActionPerformed(e));
		contentPane.add(jButtonX1);
		jButtonX1.setBounds(new Rectangle(new Point(380, 350), jButtonX1.getPreferredSize()));

		//---- jLabel4 ----
		jLabel4.setText("General Purpose Registers");
		contentPane.add(jLabel4);
		jLabel4.setBounds(new Rectangle(new Point(20, 130), jLabel4.getPreferredSize()));

		//---- jLabel5 ----
		jLabel5.setText("Instruction Registers");
		contentPane.add(jLabel5);
		jLabel5.setBounds(new Rectangle(new Point(20, 320), jLabel5.getPreferredSize()));

		//---- jButtonInputWrite ----
		jButtonInputWrite.setText("Add to Instruction Queue");
		contentPane.add(jButtonInputWrite);
		jButtonInputWrite.setBounds(new Rectangle(new Point(465, 670), jButtonInputWrite.getPreferredSize()));
		jButtonInputWrite.addActionListener(e -> jButtonInputWriteActionPerformed(e));


		//======== jScrollPane1 ========
		{
			jScrollPane1.setViewportView(jTextPaneInstructions);
		}
		contentPane.add(jScrollPane1);
		jScrollPane1.setBounds(480, 30, 480, 480);
		contentPane.add(jSeparator1);
		jSeparator1.setBounds(new Rectangle(new Point(360, 130), jSeparator1.getPreferredSize()));
		contentPane.add(jSeparator2);
		jSeparator2.setBounds(10, 120, 440, 10);

		//---- jTextFieldMAR ----
		jTextFieldMAR.addActionListener(e -> jTextFieldMARActionPerformed(e));
		contentPane.add(jTextFieldMAR);
		jTextFieldMAR.setBounds(60, 30, 320, jTextFieldMAR.getPreferredSize().height);

		//---- jTextFieldR0 ----
		jTextFieldR0.addActionListener(e -> jTextFieldR0ActionPerformed(e));
		contentPane.add(jTextFieldR0);
		jTextFieldR0.setBounds(60, 160, 320, jTextFieldR0.getPreferredSize().height);

		//---- jTextFieldR3 ----
		jTextFieldR3.addActionListener(e -> jTextFieldR3ActionPerformed(e));
		contentPane.add(jTextFieldR3);
		jTextFieldR3.setBounds(60, 280, 320, jTextFieldR3.getPreferredSize().height);

		//---- jTextFieldR2 ----
		jTextFieldR2.addActionListener(e -> jTextFieldR2ActionPerformed(e));
		contentPane.add(jTextFieldR2);
		jTextFieldR2.setBounds(60, 240, 320, jTextFieldR2.getPreferredSize().height);

		//---- jTextFieldX3 ----
		jTextFieldX3.addActionListener(e -> jTextFieldX3ActionPerformed(e));
		contentPane.add(jTextFieldX3);
		jTextFieldX3.setBounds(60, 430, 320, jTextFieldX3.getPreferredSize().height);

		//---- jTextFieldX2 ----
		jTextFieldX2.addActionListener(e -> jTextFieldX2ActionPerformed(e));
		contentPane.add(jTextFieldX2);
		jTextFieldX2.setBounds(60, 390, 320, jTextFieldX2.getPreferredSize().height);

		//---- jTextFieldX1 ----
		jTextFieldX1.addActionListener(e -> jTextFieldX1ActionPerformed(e));
		contentPane.add(jTextFieldX1);
		jTextFieldX1.setBounds(60, 350, 320, jTextFieldX1.getPreferredSize().height);

		//---- jButtonMBR ----
		jButtonMBR.setText("Write");
		jButtonMBR.addActionListener(e -> jButtonMBRActionPerformed(e));
		contentPane.add(jButtonMBR);
		jButtonMBR.setBounds(new Rectangle(new Point(380, 60), jButtonMBR.getPreferredSize()));
		jButtonMBR.addActionListener(e -> jButtonMBRActionPerformed(e));


		//---- jButtonMAR ----
		jButtonMAR.setText("Write");
		jButtonMAR.addActionListener(e -> jButtonMARActionPerformed(e));
		contentPane.add(jButtonMAR);
		jButtonMAR.setBounds(new Rectangle(new Point(380, 30), jButtonMAR.getPreferredSize()));
		jButtonMAR.addActionListener(e -> jButtonMARActionPerformed(e));


		//---- jLabelR3 ----
		jLabelR3.setText("R3");
		contentPane.add(jLabelR3);
		jLabelR3.setBounds(20, 280, 220, 30);
		contentPane.add(jTextFieldPC);
		jTextFieldPC.setBounds(60, 90, 320, jTextFieldPC.getPreferredSize().height);

		//---- LabelPC ----
		LabelPC.setText("PC");
		contentPane.add(LabelPC);
		LabelPC.setBounds(20, 90, 220, 30);

		//---- LabelR0 ----
		LabelR0.setText("R0");
		contentPane.add(LabelR0);
		LabelR0.setBounds(20, 160, 220, 30);

		//---- LabelR1 ----
		LabelR1.setText("R1");
		contentPane.add(LabelR1);
		LabelR1.setBounds(20, 200, 220, 30);

		//---- jLabelR2 ----
		jLabelR2.setText("R2");
		contentPane.add(jLabelR2);
		jLabelR2.setBounds(20, 240, 220, 30);

		//---- jLabelX3 ----
		jLabelX3.setText("X3");
		contentPane.add(jLabelX3);
		jLabelX3.setBounds(20, 430, 220, 30);

		//---- jLabelX1 ----
		jLabelX1.setText("X1");
		contentPane.add(jLabelX1);
		jLabelX1.setBounds(20, 350, 220, 30);

		//---- jLabelX2 ----
		jLabelX2.setText("X2");
		contentPane.add(jLabelX2);
		jLabelX2.setBounds(20, 390, 220, 30);

		//---- jLabel14 ----
		jLabel14.setText("Manually Instruction");
		contentPane.add(jLabel14);
		jLabel14.setBounds(new Rectangle(new Point(20, 650), jLabel14.getPreferredSize()));
		contentPane.add(jSeparator3);
		jSeparator3.setBounds(20, 700, 960, 10);

		//---- jTextFieldInputValue ----
		jTextFieldInputValue.addActionListener(e -> jTextFieldInputValueActionPerformed(e));
		contentPane.add(jTextFieldInputValue);
		jTextFieldInputValue.setBounds(20, 670, 420, jTextFieldInputValue.getPreferredSize().height);
		contentPane.add(jSeparator4);
		jSeparator4.setBounds(10, 630, 970, 10);

		//---- jButtonSingleRun ----
		jButtonSingleRun.setText("Single Run");
		contentPane.add(jButtonSingleRun);
		jButtonSingleRun.setBounds(new Rectangle(new Point(475, 710), jButtonSingleRun.getPreferredSize()));
		jButtonSingleRun.addActionListener(e -> jButtonSingleRunPerformed(e));


		//---- jButtonIPL ----
		jButtonIPL.setText("IPL/RESET");
		contentPane.add(jButtonIPL);
		jButtonIPL.setBounds(new Rectangle(new Point(360, 710), jButtonIPL.getPreferredSize()));
		contentPane.add(jSeparator5);
		jSeparator5.setBounds(10, 460, 440, 10);
		jButtonIPL.addActionListener(e -> jButtonIPLPerformed(e));


		//---- jLabel15 ----
		jLabel15.setText("16 bit");
		contentPane.add(jLabel15);
		jLabel15.setBounds(new Rectangle(new Point(200, 10), jLabel15.getPreferredSize()));
		contentPane.add(jSeparator6);
		jSeparator6.setBounds(20, 310, 440, 10);

		//---- jTextFieldMFR ----
		jTextFieldMFR.addActionListener(e -> jTextFieldMFRActionPerformed(e));
		contentPane.add(jTextFieldMFR);
		jTextFieldMFR.setBounds(60, 550, 390, jTextFieldMFR.getPreferredSize().height);

		//---- jTextFieldCC ----
		jTextFieldCC.addActionListener(e -> jTextFieldCCActionPerformed(e));
		contentPane.add(jTextFieldCC);
		jTextFieldCC.setBounds(60, 510, 390, jTextFieldCC.getPreferredSize().height);

		//---- jTextFieldIR ----
		jTextFieldIR.addActionListener(e -> jTextFieldIRActionPerformed(e));
		contentPane.add(jTextFieldIR);
		jTextFieldIR.setBounds(60, 470, 390, jTextFieldIR.getPreferredSize().height);

		//---- jLabelMFR ----
		jLabelMFR.setText("MFR");
		contentPane.add(jLabelMFR);
		jLabelMFR.setBounds(20, 550, 290, 30);

		//---- jLabelIR ----
		jLabelIR.setText("IR");
		contentPane.add(jLabelIR);
		jLabelIR.setBounds(20, 470, 290, 30);

		//---- jLabelCC ----
		jLabelCC.setText("CC");
		contentPane.add(jLabelCC);
		jLabelCC.setBounds(20, 510, 290, 30);

		//---- jTextFieldMSR ----
		jTextFieldMSR.addActionListener(e -> jTextFieldMSRActionPerformed(e));
		contentPane.add(jTextFieldMSR);
		jTextFieldMSR.setBounds(60, 590, 390, jTextFieldMSR.getPreferredSize().height);

		//---- jLabelMSR ----
		jLabelMSR.setText("MSR");
		contentPane.add(jLabelMSR);
		jLabelMSR.setBounds(20, 590, 290, 30);
		contentPane.add(memoryValueTextField);
		memoryValueTextField.setBounds(515, 555, 160, memoryValueTextField.getPreferredSize().height);

		//---- buttonLoad ----
		buttonLoad.setText("Load");
		buttonLoad.addActionListener(e -> buttonLoadActionPerformed(e));
		contentPane.add(buttonLoad);
		buttonLoad.setBounds(new Rectangle(new Point(560, 595), buttonLoad.getPreferredSize()));
		contentPane.add(memoryAddressTextField);
		memoryAddressTextField.setBounds(720, 555, 95, memoryAddressTextField.getPreferredSize().height);

		//---- label1 ----
		label1.setText("Memory Value");
		contentPane.add(label1);
		label1.setBounds(555, 530, 90, 21);

		//---- label2 ----
		label2.setText("Memory Address");
		contentPane.add(label2);
		label2.setBounds(720, 525, 105, 26);

		//---- buttonStore ----
		buttonStore.setText("Store");
		buttonStore.addActionListener(e -> buttonStoreActionPerformed(e));
		contentPane.add(buttonStore);
		buttonStore.setBounds(new Rectangle(new Point(735, 595), buttonStore.getPreferredSize()));

		{
			// compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
	}// </editor-fold>//GEN-END:initComponents

	private void jTextFieldR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldR1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldR1ActionPerformed

	private void jButtonMARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMARActionPerformed
		Simulator.mar = jTextFieldMAR.getText();
		//jTextFieldCC.setText(Simulator.mar);
	}//GEN-LAST:event_jButtonMARActionPerformed

	private void jButtonMBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMBRActionPerformed
		Simulator.mbr = jTextFieldMBR.getText();
	}//GEN-LAST:event_jButtonMBRActionPerformed

	private void jButtonPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPCActionPerformed
		Simulator.pc = jTextFieldPC.getText();
	}//GEN-LAST:event_jButtonPCActionPerformed

	private void jButtonR0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonR0ActionPerformed
		Simulator.gpr[0] = jTextFieldR0.getText();
	}//GEN-LAST:event_jButtonR0ActionPerformed

	private void jButtonR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonR3ActionPerformed
		Simulator.gpr[3] = jTextFieldR3.getText();
	}//GEN-LAST:event_jButtonR3ActionPerformed

	private void jButtonX1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonX1ActionPerformed
		Simulator.indexRegister[0] = jTextFieldX1.getText();
	}//GEN-LAST:event_jButtonX1ActionPerformed

	private void jButtonX2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonX2ActionPerformed
		Simulator.indexRegister[1] = jTextFieldX2.getText();
	}//GEN-LAST:event_jButtonX2ActionPerformed

	private void jButtonX3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonX3ActionPerformed
		Simulator.indexRegister[2] = jTextFieldX3.getText();
	}//GEN-LAST:event_jButtonX3ActionPerformed

	private void jButtonR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonR1ActionPerformed
		Simulator.gpr[1] = jTextFieldR1.getText();
	}//GEN-LAST:event_jButtonR1ActionPerformed

	private void jButtonR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonR2ActionPerformed
		Simulator.gpr[2] = jTextFieldR2.getText();
	}//GEN-LAST:event_jButtonR2ActionPerformed

	private void jButtonInputReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputReadActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jButtonInputReadActionPerformed

	private void jTextFieldMARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMARActionPerformed
	}//GEN-LAST:event_jTextFieldMARActionPerformed

	private void jTextFieldR0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldR0ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldR0ActionPerformed

	private void jTextFieldR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldR3ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldR3ActionPerformed

	private void jTextFieldR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldR2ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldR2ActionPerformed

	private void jTextFieldX3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldX3ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldX3ActionPerformed

	private void jTextFieldX2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldX2ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldX2ActionPerformed

	private void jTextFieldX1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldX1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldX1ActionPerformed

	/*button for run initialize IPL program. When click second times,
	the simulator will reset all values in registers and memory*/
	private void jButtonIPLPerformed(java.awt.event.ActionEvent evt) { //Initialize the memory, registers and test program.
		Simulator.setIPL();
		showCurrentContent();
		jTextPaneInstructions.setText("");
	}

	/*button for run instruction one by one*/
	private void jButtonSingleRunPerformed(java.awt.event.ActionEvent evt) {  // run the instruction in the instruction list which the current indicator pointed
		if (Simulator.execPos < 100) {
			if (!Simulator.instList[Simulator.execPos].equals("")) {
				jTextFieldIR.setText(Simulator.instList[Simulator.execPos]);
				Simulator.execInst(Simulator.instList[Simulator.execPos]);
				Simulator.execPos++;
				System.out.println(Simulator.execPos);
				showCurrentContent();
				showInstructions();
			}
		}
	}

	private void jTextFieldInputAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInputAdressActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldInputAddressActionPerformed

	private void jTextFieldInputValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInputValueActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldInputValueActionPerformed

	private void jTextFieldMFRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMFRActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldMFRActionPerformed

	private void jTextFieldCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCCActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldCCActionPerformed

	private void jTextFieldIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIRActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldIRActionPerformed

	private void jTextFieldMSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMSRActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextFieldMSRActionPerformed

	/*button for put the manually inputed instruction into the instruction queue*/
	private void jButtonInputWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputWriteActionPerformed
		String ins;
		ins = jTextFieldInputValue.getText();
		Simulator.pc = jTextFieldPC.getText();
		if (ins.length() == 16) {
			Simulator.instList[Simulator.instIndicator] = ins;
			Simulator.instIndicator++;
			jTextFieldInputValue.setText("");
		}
		if (Simulator.pc.length() == 12) {
			Simulator.instList[Simulator.instIndicator] = Simulator.memory[Simulator.bToD(Simulator.pc)];
			Simulator.instIndicator++;
			jTextFieldPC.setText("");
			Simulator.pc = "";
		}
	}
	/*show all instructions have executed on the right text area*/
	private void showInstructions(){
		String output = "";
		for (int i = 0; i < Simulator.execPos; i++) {
			output += (Simulator.instList[i] + "\n");
			jTextPaneInstructions.setText(output);
		}
	}

	/*show current value of all registers on the left side text fields*/
	private void showCurrentContent(){
		jTextFieldMAR.setText(Simulator.mar);
		jTextFieldMBR.setText(Simulator.mbr);
		jTextFieldPC.setText(Simulator.pc);
		jTextFieldMAR.setText(Simulator.mar);
		jTextFieldR0.setText(Simulator.gpr[0]);
		jTextFieldR1.setText(Simulator.gpr[1]);
		jTextFieldR2.setText(Simulator.gpr[2]);
		jTextFieldR3.setText(Simulator.gpr[3]);
		jTextFieldX1.setText(Simulator.indexRegister[0]);
		jTextFieldX2.setText(Simulator.indexRegister[1]);
		jTextFieldX3.setText(Simulator.indexRegister[2]);
		//jTextFieldIR.setText(Simulator.instList[]);
		//jTextFieldCC.setText(Simulator.cc);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		Simulator.initRegs();
		Simulator.initMem();

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new gui().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - unknown
	private JLabel LabelMAR;
	private JLabel LabelMBR;
	private JTextField jTextFieldR1;
	private JTextField jTextFieldMBR;
	private JLabel jLabel3;
	private JButton jButtonR0;
	private JButton jButtonR1;
	private JButton jButtonR2;
	private JButton jButtonR3;
	private JButton jButtonX2;
	private JButton jButtonX3;
	private JButton jButtonX1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton jButtonInputWrite;
	private JScrollPane jScrollPane1;
	private JTextPane jTextPaneInstructions;
	private JSeparator jSeparator1;
	private JSeparator jSeparator2;
	private JTextField jTextFieldMAR;
	private JTextField jTextFieldR0;
	private JTextField jTextFieldR3;
	private JTextField jTextFieldR2;
	private JTextField jTextFieldX3;
	private JTextField jTextFieldX2;
	private JTextField jTextFieldX1;
	private JButton jButtonMBR;
	private JButton jButtonMAR;
	private JLabel jLabelR3;
	private JTextField jTextFieldPC;
	private JLabel LabelPC;
	private JLabel LabelR0;
	private JLabel LabelR1;
	private JLabel jLabelR2;
	private JLabel jLabelX3;
	private JLabel jLabelX1;
	private JLabel jLabelX2;
	private JLabel jLabel14;
	private JSeparator jSeparator3;
	private JTextField jTextFieldInputValue;
	private JSeparator jSeparator4;
	private JButton jButtonSingleRun;
	private JButton jButtonIPL;
	private JSeparator jSeparator5;
	private JLabel jLabel15;
	private JSeparator jSeparator6;
	private JTextField jTextFieldMFR;
	private JTextField jTextFieldCC;
	private JTextField jTextFieldIR;
	private JLabel jLabelMFR;
	private JLabel jLabelIR;
	private JLabel jLabelCC;
	private JTextField jTextFieldMSR;
	private JLabel jLabelMSR;
	private JTextField memoryValueTextField;
	private JButton buttonLoad;
	private JTextField memoryAddressTextField;
	private JLabel label1;
	private JLabel label2;
	private JButton buttonStore;
	// End of variables declaration//GEN-END:variables
}