package game;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainScreen {
  static int tile_loc=70;
	static int ball_x=260;
	static int ball_y=120;
	
	
	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="36,3"
	private JPanel jContentPane = null;
	private JButton jButton2 = null;

	private JButton jButton = null;
	private JRadioButton jRadioButton = null;
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	public JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(521, 251));
			jFrame.setContentPane(getJContentPane());
			jFrame.setVisible(true);
	}
		return jFrame;
	}
	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(521,251);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJRadioButton(ball_x,ball_y), null);
		}
		return jContentPane;
	}
	
	

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(5, tile_loc, 15, 63));
			jButton2.addKeyListener(new java.awt.event.KeyListener() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyChar()=='a')
					{
						tile_loc=tile_loc-4;
						//jButton.setBoundsa(new Rectangle(500, tile_loc, 15, 63));
						jButton.setLocation(500, tile_loc);
						jButton2.setLocation(5, tile_loc);
					}
					if(e.getKeyChar()=='z')
					{
						tile_loc=tile_loc+4;
						//jButton.setBoundsa(new Rectangle(500, tile_loc, 15, 63));
						jButton.setLocation(500, tile_loc);
						jButton2.setLocation(5, tile_loc);
					}
								}
				public void keyTyped(java.awt.event.KeyEvent e) {
					//System.out.println("keyPressed()"+e.getKeyCode());
					if(e.getKeyChar()=='a')
					{
						tile_loc++;
						//jButton.setBounds(new Rectangle(500, tile_loc, 15, 63));
						//repaint();
					}
				}
				public void keyReleased(java.awt.event.KeyEvent e) {
					//System.out.println("keyPressed()"+e.getKeyCode());
					if(e.getKeyChar()=='a')
					{
						tile_loc++;
						//jButton.setBounds(new Rectangle(500, tile_loc, 15, 63));
						//repaint();
					}
				}
			});
		}
		return jButton2;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(500, tile_loc, 15, 63));
			jButton.addKeyListener(new java.awt.event.KeyListener() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyChar()=='a')
					{
						tile_loc=tile_loc+1;
						//jButton.setBoundsa(new Rectangle(500, tile_loc, 15, 63));
						jButton.setLocation(500, tile_loc);
						jButton2.setLocation(5, tile_loc);
					}
					if(e.getKeyChar()=='z')
					{
						tile_loc=tile_loc-1;
						//jButton.setBoundsa(new Rectangle(500, tile_loc, 15, 63));
						jButton.setLocation(500, tile_loc);
						jButton2.setLocation(5, tile_loc);
					}
								}
				public void keyTyped(java.awt.event.KeyEvent e) {
					//System.out.println("keyPressed()"+e.getKeyCode());
					if(e.getKeyChar()=='a')
					{
						tile_loc++;
						//jButton.setBounds(new Rectangle(500, tile_loc, 15, 63));
						//repaint();
					}
				}
				public void keyReleased(java.awt.event.KeyEvent e) {
					//System.out.println("keyPressed()"+e.getKeyCode());
					if(e.getKeyChar()=='a')
					{
						tile_loc++;
						//jButton.setBounds(new Rectangle(500, tile_loc, 15, 63));
						//repaint();
					}
				}
			});
		}
		return jButton;
	}
	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton(int a,int b) {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setBounds(new Rectangle(a, b, 21, 21));
		}
		
		return jRadioButton;
	}
	public static void main(String[] args) {
		MainScreen ms=new MainScreen();
		ms.getJFrame();
		
		int flag=0;
		int flag_y=0;
		int win1=0;
		int win2=0;
		while(true)
		{ 	if(flag==1)
			{ ball_x--;
				if(ball_x==20)
				{	int t=ms.getJButton().getY();
					if((ball_y>=t)&&(ball_y<=(t+63)))
					{
						System.out.println("yes");
						
					}
					else
					{ win2++;
				      System.out.println("missed");
				  
					}
				flag=0;
				}	
			}
			if(flag==0)
			{ball_x++;
				if(ball_x==485)
				{	int t=ms.getJButton().getY();
				if((ball_y>=t)&&(ball_y<=(t+63)))
				{
					System.out.println("yes");
					
				}
				else
					{System.out.println("missed");
					 win1++;
					 
					}
				flag=1;
			}
			}
			if(flag_y==1)
			{ ball_y++;
				if(ball_y==220)
					flag_y=0;
			}
			if(flag_y==0)
			{ ball_y--;
				if(ball_y==10)
					flag_y=1;
			}
			ms.getJRadioButton(ball_x, ball_y).setLocation(ball_x, ball_y);
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(win1==5||win2==5)
			{
				System.out.println("game over");
				break;
			}
		}
	}

	}
