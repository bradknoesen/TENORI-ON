import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tenori {
	
	private JPanel GUI = new JPanel();
	private JPanel panelCenter = new JPanel();
	private ClockHand clockHand;
	
	final TextField LCD_disp 	= 	new TextField(18); //font size 18
	
	final ModeButton L1 	= 	new ModeButton	("");
	final ModeButton L2 	= 	new ModeButton	("");
	final ModeButton L3 	= 	new ModeButton	("");
	final ModeButton L4 	= 	new ModeButton	("");
	 
	final ModeButton R1 	= 	new ModeButton	("");
	final ModeButton R2 	= 	new ModeButton	("");
	final ModeButton R3 	= 	new ModeButton	("");
	final ModeButton R4 	= 	new ModeButton	("");
	
	final OKButton OK 		= 	new OKButton	(""); 
	final ONButton ON 		= 	new ONButton	("");
	
	SoundButton[][] matrix = new SoundButton[16][16];
	
	public SoundButton getButton(int x, int y){
		return matrix[x][y];
	}
	
	public void clockHandHighlight(int c) {//highlightColumn
		for (int i=0; i < 16; i+=5){
			getButton(c, i).setSelected(true); //select method should make things orange (turnOn)
		}	
	}
	
	 final class ModeButton extends JButton {
		 ModeButton (String s){
			 super( s );								   
		     setContentAreaFilled(false);						// Sets colour of default button to invisible. 		   
		     setBorderPainted(false);							// No border around the default button.		   
		     setFocusPainted(false);							// Disables the button to begin with, will reactivate when ON button is clicked. 		   
		     setEnabled(false);			
		 }
	 }
	 
	 final class ONButton extends JButton {
		 ONButton (String s){
			 super( s );
			 setContentAreaFilled(false);
			 setBorderPainted(false);
			 setFocusPainted(false);
		 }
	 }
	 
	 final class OKButton extends JButton {
		 OKButton (String s) {
			 super( s );
			 setContentAreaFilled(false);
			 setBorderPainted(false);
			 setFocusPainted(false);
			 setEnabled(false); //this is why they're grey
		 }
	 }
	
	
	public JPanel getGUI(){
		return this.GUI;
	}
	
	public void clear() {
		for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				matrix[j][i].setSelected(false);
			 }
		}
	}
	
	public Tenori() {
		GUI.setLayout(null);
		panelCenter.setLayout(new GridLayout(16,16,0,0));
		panelCenter.setBounds(85, 65, 430, 430);
		
		LCD_disp.setPreferredSize(new Dimension(250,30));
		
		L1.setBounds(10, 90, 70, 50);
		L1.setIcon(new ImageIcon("L1.png"));
		L1.setPressedIcon(new ImageIcon("L1_clicked.png"));
		L1.setToolTipText("Change Voice Mode");
		
		L2.setBounds(10, 165, 70, 50);
		L2.setIcon(new ImageIcon("L2.png"));
		L2.setPressedIcon(new ImageIcon("L2_clicked.png"));
		L2.setToolTipText("Change Velocity");
		
		L3.setBounds(10, 240, 70, 50);
		L3.setIcon(new ImageIcon("L3.png"));
		L3.setPressedIcon(new ImageIcon("L3_clicked.png"));
		L3.setToolTipText("Change Loop Speed");
		
		L4.setBounds(10, 315, 70, 50);		
		L4.setIcon(new ImageIcon("L4.png"));
		L4.setPressedIcon(new ImageIcon("L4_clicked.png"));
		L4.setToolTipText("Change Loop Point");
		
		ON.setBounds(260, 10, 70, 50);
		ON.setEnabled(true);
		ON.setIcon(new ImageIcon("ON.png"));
		ON.setPressedIcon(new ImageIcon("ON_clicked.png"));
		
		R1.setBounds(510, 90, 70, 50);
		R1.setIcon(new ImageIcon("R1.png"));
		R1.setPressedIcon(new ImageIcon("R1_clicked.png"));
		R1.setToolTipText("Change Layer Number");
		
		R2.setBounds(510, 165, 70, 50);
		R2.setIcon(new ImageIcon("R2.png"));
		R2.setPressedIcon(new ImageIcon("R2_clicked.png"));
		R2.setToolTipText("Load");
		
		R3.setBounds(510, 240, 70, 50);
		R3.setIcon(new ImageIcon("R3.png"));
		R3.setPressedIcon(new ImageIcon("R3_clicked.png"));
		R3.setToolTipText("Save");
		
		R4.setBounds(510, 315, 70, 50);
		R4.setIcon(new ImageIcon("R4.png"));
		R4.setPressedIcon(new ImageIcon("R4_clicked.png"));
		R4.setToolTipText("Online");
		
		OK.setBounds(400, 495, 70, 50);
		OK.setIcon(new ImageIcon("OK.png"));
		OK.setPressedIcon(new ImageIcon("OK_clicked.png"));
		
		LCD_disp.setBounds(130, 500, 200,40);
		
		LCD_disp.setEditable(false);
		
		
		
		//creating and adding sound buttons
		for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				SoundButton button = new SoundButton(i, j, this);
				button.setIcon(new ImageIcon("white.png"));
				button.setSelectedIcon(new ImageIcon("orange.png"));
				matrix[j][i] = button;
				panelCenter.add(matrix[j][i]);
				 
			 }
		}
		
		GUI.add(L1);
		GUI.add(L2);
		GUI.add(L3);
		GUI.add(L4);
		GUI.add(ON);
		GUI.add(R1);
		GUI.add(R2);
		GUI.add(R3);
		GUI.add(R4);
		GUI.add(OK);
		GUI.add(LCD_disp);
		
		GUI.add(panelCenter); //add grid to 
		
		
		ON.addMouseListener (new MouseAdapter() {
			boolean power = false;	//Checks if tenori device is switched on. 
			public void mouseClicked (MouseEvent me) {
				if (power == false) { 
					L1.setEnabled(true);
					L2.setEnabled(true);
					L3.setEnabled(true);
					L4.setEnabled(true);
					R1.setEnabled(true);
					R2.setEnabled(true);
					R3.setEnabled(true);
					R4.setEnabled(true);
					OK.setEnabled(true);
					for (int i = 0; i < 16; i++){ 		
						for (int j = 0; j < 16; j++ ) { 
							matrix[j][i].setEnabled(true);		//Enables the matrix Illuminated Buttons		
						}
					}
					
					power = true;
				}
				
				else {
					clear();
					L1.setEnabled(false);
					L2.setEnabled(false);
					L3.setEnabled(false);
					L4.setEnabled(false);
					R1.setEnabled(false);
					R2.setEnabled(false);
					R3.setEnabled(false);
					R4.setEnabled(false);
					OK.setEnabled(false);
					for (int i = 0; i < 16; i++){ 
						for (int j = 0; j < 16; j++ ) { 
							matrix[i][j].setEnabled(false);				
						}
					}
					power = false;
				}
				
				}
				
		});	

		// L1.addActionLister(new ActionListener() {
			// public void actionPerformed(ActionEvent ae) {
				// clockHand = new ClockHand(this);
				// (new Thread(clockHand)).start();
			// }
		// });

	
	}
	
	public static Tenori makeTenori(){
		final Tenori t = new Tenori();
		
		Runnable runnable = new Runnable() {
			
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("Tenori-ON");
				frame.setSize(600, 580);				
				frame.add(t.getGUI());
				frame.setVisible( true );
			    frame.setLocationRelativeTo( null );
			    frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		};
		SwingUtilities.invokeLater(runnable);
		return t;
	}
	
	public static void main( String[] argv ) {
		makeTenori();
	}
}
