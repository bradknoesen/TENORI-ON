import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


/*
 * Simulation of a simplified version of the Yamaha Tenori-ON. 
 * @authors Eneida Morina, David Olagunju, Kate Mawbey, Bradley Knoesen, Presley Kode. 
 * @Date 10/02/2016
 */
public class Tenori extends JFrame {
	 private static String sample = "LCD";	
	 private static String disp;
	 private JPanel panelCenter = new JPanel();	 

	 final TextField LCD_disp 	= 	new TextField();
	 
	 final ModeButton btn_L1 	= 	new ModeButton	("");
	 final ModeButton btn_L2 	= 	new ModeButton	("");
	 final ModeButton btn_L3 	= 	new ModeButton	("");
	 final ModeButton btn_L4 	= 	new ModeButton	("");
	 
	 final ModeButton btn_R1 	= 	new ModeButton	("");
	 final ModeButton btn_R2 	= 	new ModeButton	("");
	 final ModeButton btn_R3 	= 	new ModeButton	("");
	 final ModeButton btn_R4 	= 	new ModeButton	("");
	 
	 final OKButton btn_OK 		= 	new OKButton	(""); 
	 final ONButton btn_ON 		= 	new ONButton	("");
	 
	 final SoundButton[][] matrix = new SoundButton[16][16];
	 
 	 /*
	  * Mode Button class defines a button to be used for the eight mode buttons. 
	  * @David Olagunju
	  * @Eneida Morina
	  */
	 final class ModeButton extends JButton {
		 ModeButton (String s){
			 super( s );								   
		     setContentAreaFilled(false);						// Sets colour of default button to invisible. 		   
		     setBorderPainted(false);							// No border around the default button.		   
		     setFocusPainted(false);							// Disables the button to begin with, will reactivate when ON button is clicked. 		   
		     setEnabled(false);			
			 addMouseListener (new MouseAdapter() {
				 public void mouseClicked (MouseEvent me ) {
					 LCD_disp.setText(sample);
					 disp = sample;
				 } 
			 });
		 }

	 }
	 
	 
	 /*
	  * ONButton class defines the visuals of the ON button to be used to turn the 
	  * Tenori-ON machine on/off. 
	  * @Eneida Morina
	  * @Kate Mawbey
	  */
	 final class ONButton extends JButton {
		 ONButton (String s){
			 super( s );
			 setContentAreaFilled(false);
			 setBorderPainted(false);
			 setFocusPainted(false);
			 setEnabled(false);
			 addMouseListener (new MouseAdapter() {
				 public void mouseClicked (MouseEvent me ) {
					LCD_disp.setText(sample);
					 
				 } 
			 });
		 }
	 }
	 
	 /*
	  * OKButton class defines the visuals of the OK button to be used to 
	  * confirm mode parameters. 
	  * @Eneida Morina
	  * @Kate Mawbey 
	  */
	 final class OKButton extends JButton {
		 OKButton (String s) {
			 super( s );
			 setContentAreaFilled(false);
			 setBorderPainted(false);
			 setFocusPainted(false);
			 setEnabled(false);
			 addMouseListener (new MouseAdapter() {
				 public void mouseClicked (MouseEvent me ) {
					 LCD_disp.setText(disp);
					 //this will be taken from the last thing printed by the LCD_disp.
				 }
			});
		 }
		 
	 }
	 
	 
	 /*
	  * SoundButtton class defines the visuals of the 16x16 matrix of illuminated buttons. 
	  * @David Olagunju
	  * @Presley Kode
	  */
	 final class SoundButton extends JToggleButton {
		 String name; 
		 SoundButton (String s) {
			 this.name = s;
			 setContentAreaFilled(false);
			 setBorderPainted(false);
			 setFocusPainted(false);
			 setEnabled(false);
			 addMouseListener (new MouseAdapter() {
				 public void mouseClicked(MouseEvent me) {
					 //produce sound
					 
					 
				 }
			 });
		 }
	 }	
	 
	 
	 /* 
	  * populate method is used to populate the 16x16 matrix of illuminated buttons.  
	  * @ David Olagunju
	  */
	public void populate(){
		for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				 SoundButton button = new SoundButton("btn_" + j + "_" + i);
				 button.setIcon(new ImageIcon("white.png"));
				 button.setSelectedIcon(new ImageIcon("orange.png"));
				 button.setEnabled(false);
				 matrix[j][i] = button;	//Adds the button to the matrix. 
			}	
		}
	}
	
	public void addDefSounds() {
		int snd = 1;
		for (int j = 0; j < 16; j++){ //column
			matrix[0][j].sound = snd;
			matrix[0][j].note += 10;
			// for (int i = 0; i < 16; i++ ) { //row
			 //	matrix[i][j].sound += 8;
			 //}
		}
			 	
	}
	
	
	/*
	 * clear method clears the 16x16 matrix of illuminated buttons. 
	 * @ David Olagunju
	 * @ Bradley Knoesen 
	 */
	public void clear() {
		for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				matrix[j][i].setSelected(false);
			 }
		}
	}
	
	
	/*
	 * Tenori method creates a new Tenori display with all buttons and their functionalities.  
	 * @Eneida Morina
	 * @Kate Mawbey 
	 * @David Olagunju
	 * @Bradley Knoesen
	 * @Presley Kode
	 */
	 public Tenori() {
		 setTitle ("Tenori-ON");	
		 setSize(600, 600);
     	 
		 setLayout( new BorderLayout());
		
		 JPanel south = new JPanel(new FlowLayout());					//Layout is was used to split the Tenori display.  
		 JPanel north = new JPanel(new FlowLayout());
		 JPanel west = new JPanel(new GridLayout(5,1,5,15));			//Grid Layout consists of 5 rows in west and east panels
		 JPanel east = new JPanel(new GridLayout(5,1,5,15));

		 LCD_disp.setPreferredSize(new Dimension(250,30));
		 btn_ON.setPreferredSize(new Dimension(70,50));
		
		 btn_OK.setPreferredSize(new Dimension(70,50));
		 
		 btn_L1.setPreferredSize(new Dimension(70,50));
		 btn_R1.setPreferredSize(new Dimension(70,50));

		 //Method defines the operations of the ON button. 
		 //When ON button hasn't been clicked, only the ON button is enabled 
		 //and all others are disabled. 
		 //Once ON button is clicked on, the tenori device continues in Performance
		 //Mode meaning all buttons are turned on. 
		 //@Eneida Morina, Bradley Knoesen and David Olagunju.
		 btn_ON.addMouseListener (new MouseAdapter() {
			boolean power = false;	//Checks if tenori device is switched on. 
			public void mouseClicked (MouseEvent me) {
				if (power == false) { 
					btn_L1.setEnabled(true);
					btn_L2.setEnabled(true);
					btn_L3.setEnabled(true);
					btn_L4.setEnabled(true);
					btn_R1.setEnabled(true);
					btn_R2.setEnabled(true);
					btn_R3.setEnabled(true);
					btn_R4.setEnabled(true);
					btn_OK.setEnabled(true);
					for (int i = 0; i < 16; i++){ 		
						for (int j = 0; j < 16; j++ ) { 
							matrix[i][j].setEnabled(true);		//Enables the matrix Illuminated Buttons		
						}
					}
					power = true;
				}
				
				else {
					clear();
					btn_L1.setEnabled(false);
					btn_L2.setEnabled(false);
					btn_L3.setEnabled(false);
					btn_L4.setEnabled(false);
					btn_R1.setEnabled(false);
					btn_R2.setEnabled(false);
					btn_R3.setEnabled(false);
					btn_R4.setEnabled(false);
					btn_OK.setEnabled(false);
					for (int i = 0; i < 16; i++){ 
						for (int j = 0; j < 16; j++ ) { 
							matrix[i][j].setEnabled(false);				
						}
					}
					power = false;
				}
				
				}
				
		});	 	

		 // Methods to display correct message when the OK button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 
		 btn_OK.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_OK.isEnabled() == true){
					LCD_disp.setEditable(false); 
					LCD_disp.setText("OK"); //add code
				 } 
				 else {
					 JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
				 }
			 }
		});
			 		 
		 // Methods to display correct message when the L1 button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 			 
		 btn_L1.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_L1.isEnabled() == true){
					LCD_disp.setEditable(false); 
					LCD_disp.setText("Instrument");
					disp = sample;
					clear();
				 } 
				 else {
					 JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
				 }
			 }
		});
			 
		 // Methods to display correct message when the L2 button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 	 
		 btn_L2.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_L2.isEnabled() == true){
					LCD_disp.setEditable(false); 			
					LCD_disp.setText("Velocity");
					disp = sample;
					clear();
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
				 }				 
			}				 
		});	
			 
		 // Methods to display correct message when the L3 button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 
		 btn_L3.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_L3.isEnabled() == true){
					LCD_disp.setEditable(false); 
					LCD_disp.setText("Loop Speed");
					disp = sample;
					clear();
				 } 
				 else {
					 JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
				}	
			}	 
		});
			 
		 // Methods to display correct message when the L4 button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 	 
		 btn_L4.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_L4.isEnabled() == true) {
					LCD_disp.setEditable(false); 				
					LCD_disp.setText("Loop Point");
					disp = sample;
					clear();
				 } 
				 else {
					 JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
				 }
			}	
		});	
		
		 // Methods to display correct message when the R1 button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 
         btn_R1.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_R1.isEnabled() == true) {
					LCD_disp.setEditable(false); 				
					LCD_disp.setText("Layer Number");
					disp = sample;
					clear();
				 } 
				else {
					JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
				} 
			}	
		});			

		 // Methods to display correct message when the R2 button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 		
		btn_R2.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_R2.isEnabled() == true) {
					LCD_disp.setEditable(false); 				
					LCD_disp.setText("Filename");
					disp = sample;
					clear();
				 } 
				else {
					JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");	
				}
			}	
		});			
		
		 // Methods to display correct message when the R3 button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 
		 btn_R3.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_R3.isEnabled() == true) {
					LCD_disp.setEditable(false); 
					LCD_disp.setText("Filename");
					disp = sample;
					clear();
				 }
				else {
					JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
				}	
			}				 
		});	

		 // Methods to display correct message when the R4 button is clicked on.
		 //	Only displays message if button is enabled, else displays an error message. 
		 // @Kate Mawbey, Eneida Morina. 
		 btn_R4.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent me ) {
				if (btn_R4.isEnabled() == true){
					LCD_disp.setEditable(false); 				
					LCD_disp.setText("Master/Slave");
					disp = sample;
					clear();
				 } 
				 else {
					 JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
				 }
			}
		});
			 
			 
		 south.add(LCD_disp);								//Adds appropriate buttons 
		 LCD_disp.setEnabled(false);
		 south.add(btn_OK);
		 btn_OK.setEnabled(false);
		 btn_OK.setIcon(new ImageIcon("OK.png"));
		 btn_OK.setPressedIcon(new ImageIcon("OK_clicked.png"));
		 
		 west.add(btn_L1);
		 btn_L1.setIcon(new ImageIcon("L1.png"));
		 btn_L1.setPressedIcon(new ImageIcon("L1_clicked.png"));
		 btn_L1.setToolTipText("Change Voice Mode");
		 west.add(btn_L2);
		 btn_L2.setIcon(new ImageIcon("L2.png"));
		 btn_L2.setPressedIcon(new ImageIcon("L2_clicked.png"));
		 btn_L2.setToolTipText("Change Velocity");
		 
		 west.add(btn_L3);
		 btn_L3.setIcon(new ImageIcon("L3.png"));
		 btn_L3.setPressedIcon(new ImageIcon("L3_clicked.png"));
		 btn_L3.setToolTipText("Change Loop Speed");
		 west.add(btn_L4);
		 btn_L4.setIcon(new ImageIcon("L4.png"));
		 btn_L4.setPressedIcon(new ImageIcon("L4_clicked.png"));
		 btn_L4.setToolTipText("Change Loop Point");

		 east.add(btn_R1);
		 btn_R1.setIcon(new ImageIcon("R1.png"));
		 btn_R1.setPressedIcon(new ImageIcon("R1_clicked.png"));
		 btn_R1.setToolTipText("Change Layer Number");
		 east.add(btn_R2);
		 btn_R2.setIcon(new ImageIcon("R2.png"));
		 btn_R2.setPressedIcon(new ImageIcon("R2_clicked.png"));
		 btn_R2.setToolTipText("Load");
		 east.add(btn_R3);
		 btn_R3.setIcon(new ImageIcon("R3.png"));
		 btn_R3.setPressedIcon(new ImageIcon("R3_clicked.png"));
		 btn_R3.setToolTipText("Save");
		 east.add(btn_R4);
		 btn_R4.setIcon(new ImageIcon("R4.png"));
		 btn_R4.setPressedIcon(new ImageIcon("R4_clicked.png"));
		 btn_R4.setToolTipText("Online");

		 north.add(btn_ON);
		 btn_ON.setEnabled(true);
		 btn_ON.setIcon(new ImageIcon("ON.png"));
		 btn_ON.setPressedIcon(new ImageIcon("ON_clicked.png"));

		 add(north, BorderLayout.NORTH);
		 add(west, BorderLayout.WEST);
		 add(east, BorderLayout.EAST);
		 add(south, BorderLayout.SOUTH);

		 
		 panelCenter.setLayout(new GridLayout(16,16,0,0));

		 populate();

		 for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				 panelCenter.add(matrix[j][i]);
			 }
		 }
		 this.add(panelCenter);
		 
	 }
	 

  public static void main( String[] argv ) {
    JFrame frame = new Tenori();
    frame.setVisible( true );
    frame.setLocationRelativeTo( null );
    frame.setResizable(false);
	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
