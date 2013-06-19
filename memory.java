package game;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class memory {

  private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="98,10"
	private JButton jButton = null;
	private JPanel jpanel = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JButton jButton7 = null;
	private JButton jButton8 = null;
	private JButton jButton9 = null;
	private JButton jButton10 = null;
	private JButton jButton11 = null;
	private JButton jButton12 = null;
	private JLabel jLabel = null;
	private JTextArea jTextArea = null;
	private JButton rstrtbtn = null;
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(320, 280));
			jFrame.setContentPane(getJpanel());
		}
		return jFrame;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */

	

	/**
	 * This method initializes jpanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpanel() {
		if (jpanel == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(234, 27, 57, 22));
			jLabel.setText("moves");
			jpanel = new JPanel();
			jpanel.setLayout(null);
			jpanel.add(getJButton1(), null);
			jpanel.add(getJButton2(), null);
			jpanel.add(getJButton3(), null);
			jpanel.add(getJButton4(), null);
			jpanel.add(getJButton5(), null);
			jpanel.add(getJButton6(), null);
			jpanel.add(getJButton7(), null);
			jpanel.add(getJButton8(), null);
			jpanel.add(getJButton9(), null);
			jpanel.add(getJButton10(), null);
			jpanel.add(getJButton11(), null);
			jpanel.add(getJButton12(), null);
			jpanel.add(jLabel, null);
			jpanel.add(getJTextArea(), null);
			jpanel.add(getRstrtbtn(), null);
		}
		return jpanel;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(11, 10, 51,59));
			jButton1.setText("??");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(65, 10, 51,59));
			jButton2.setText("??");
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(118, 10, 51,59));
			jButton3.setText("??");
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(166, 10,51,59 ));
			jButton4.setText("??");
		}
		return jButton4;
	}

	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(11, 80, 51,59));
			
			jButton5.setText("?");
		}
		return jButton5;
	}

	/**
	 * This method initializes jButton6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setBounds(new Rectangle(65, 80,51,59));
			jButton6.setText("??");
		}
		return jButton6;
	}

	/**
	 * This method initializes jButton7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setBounds(new Rectangle(118, 80, 51,59));
			jButton7.setText("??");
		}
		return jButton7;
	}

	/**
	 * This method initializes jButton8	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setBounds(new Rectangle(166, 80, 51,59));
			jButton8.setText("??");
		}
		return jButton8;
	}

	/**
	 * This method initializes jButton9	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton9() {
		if (jButton9 == null) {
			jButton9 = new JButton();
			jButton9.setBounds(new Rectangle(11, 147, 51,59));
			jButton9.setText("??");
		}
		return jButton9;
	}

	/**
	 * This method initializes jButton10	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton10() {
		if (jButton10 == null) {
			jButton10 = new JButton();
			jButton10.setBounds(new Rectangle(65, 147, 51,59));
			jButton10.setText("??");
		}
		return jButton10;
	}

	/**
	 * This method initializes jButton11	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setBounds(new Rectangle(118, 147, 51,59));
			jButton11.setText("??");
		}
		return jButton11;
	}

	/**
	 * This method initializes jButton12	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setBounds(new Rectangle(165, 147, 51, 59));
			jButton12.setText("??");
		}
		return jButton12;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(new Rectangle(234, 55, 27, 27));
		}
		return jTextArea;
	}

	/**
	 * This method initializes rstrtbtn	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRstrtbtn() {
		if (rstrtbtn == null) {
			rstrtbtn = new JButton();
			rstrtbtn.setBounds(new Rectangle(233, 95, 78, 33));
			rstrtbtn.setText("Restart");
		}
		return rstrtbtn;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
