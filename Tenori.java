import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.Synthesizer;

/*
 * Simulation of a simplified version of the Yamaha Tenori-ON.
 * @authors Bradley Knoesen, Presley Kode, Kate Mawbey, Eneida Morina, David Olagunju.
 * @Date 25/02/2016.
*/
public class Tenori 
{
    private JPanel GUI = new JPanel();
    private JPanel sButtonGrid = new JPanel();
    private ClockHand clockHand;

    //Instantiate midi and synth at start to play sounds. 
    Midi midi = new Midi();
    Synthesizer synthesizer = midi.getSynthesizer();

    //Instantiate the text field and the mode buttons.
    final JTextField LCD 	= 	new JTextField();

    final ModeButton L1 	= 	new ModeButton	("");
    final ModeButton L2 	= 	new ModeButton	("");
    final ModeButton L3 	= 	new ModeButton	("");
    final ModeButton L4 	= 	new ModeButton	("");

    final ModeButton R1  	= 	new ModeButton	("");
    final ModeButton R2 	= 	new ModeButton	("");
    final ModeButton R3 	= 	new ModeButton	("");
    final ModeButton R4 	= 	new ModeButton	("");

    final OKButton OK 		= 	new OKButton	(""); 
    final ONButton ON 		= 	new ONButton	("");

    final DirectButton UP 	= 	new DirectButton(""); 
    final DirectButton DOWN = 	new DirectButton("");

    //Matrix which stores all the sound buttons. 
    SoundButton[][] matrix = new SoundButton[16][16];
    
    /*
     * ON Button class defines the visuals of the ON button to turn the 
     * Tenori-ON machine on/off.
     * @Eneida Morina
     * @Kate Mawbey
     */
    final class DirectButton extends JButton {
		 DirectButton (String s){
			 super( s );
			 setContentAreaFilled(false);
			 setBorderPainted(false);
			 setFocusPainted(false);
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
	 
    /*
     * OK Button class defines the visuals of the OK button to turn the 
     * Tenori-ON machine on/off.
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
		 }
	 }
    
    /*
     * Mode Button class defines a button to be used for the eight mode buttons. 
     * @David Olagunju
     * @Eneida Morina
     */
    final class ModeButton extends JButton {
    	ModeButton (String s){
    		super(s);
    		setContentAreaFilled(false);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setEnabled(false);
    	}
    }

    /*
     * Constructor to create a new Tenori with all the buttons added to it and their
     * functionalities.      
     * @authors Bradley Knoesen, Presley Kode, Kate Mawbey, Eneida Morina and David Olagunju.
     */   
    private Tenori() 
    {					//changed to private for singleton
    	
    	
    	GUI.setLayout(null);
        sButtonGrid.setLayout(new GridLayout(16, 16));
        sButtonGrid.setBounds(65, 65, 440, 440);
 
        ON.setBounds(250, 5, 70, 50);
		ON.setEnabled(true);
		ON.setIcon(new ImageIcon("img/ON.png"));
		ON.setPressedIcon(new ImageIcon("img/ON_clicked.png"));
        
        L1.setBounds(0, 90, 70, 50);
        L1.setIcon(new ImageIcon("img/L1.png"));
        L1.setPressedIcon(new ImageIcon("img/L1_clicked.png"));
        L1.setToolTipText("Change voice Mode");
        
        L2.setBounds(0, 165, 70, 50);
		L2.setIcon(new ImageIcon("img/L2.png"));
		L2.setPressedIcon(new ImageIcon("img/L2_clicked.png"));
		L2.setToolTipText("Change Velocity");
		
		L3.setBounds(0, 240, 70, 50);
		L3.setIcon(new ImageIcon("img/L3.png"));
		L3.setPressedIcon(new ImageIcon("img/L3_clicked.png"));
		L3.setToolTipText("Change Loop Speed");
		
		L4.setBounds(0, 315, 70, 50);		
		L4.setIcon(new ImageIcon("img/L4.png"));
		L4.setPressedIcon(new ImageIcon("img/L4_clicked.png"));
		L4.setToolTipText("Change Loop Point");
		
		R1.setBounds(500, 90, 70, 50);
		R1.setIcon(new ImageIcon("img/R1.png"));
		R1.setPressedIcon(new ImageIcon("img/R1_clicked.png"));
		R1.setToolTipText("Change Layer Number");
		
		R2.setBounds(500, 165, 70, 50);
		R2.setIcon(new ImageIcon("img/R2.png"));
		R2.setPressedIcon(new ImageIcon("img/R2_clicked.png"));
		R2.setToolTipText("Load");
		
		R3.setBounds(500, 240, 70, 50);
		R3.setIcon(new ImageIcon("img/R3.png"));
		R3.setPressedIcon(new ImageIcon("img/R3_clicked.png"));
		R3.setToolTipText("Save");
		
		R4.setBounds(500, 315, 70, 50);
		R4.setIcon(new ImageIcon("img/R4.png"));
		R4.setPressedIcon(new ImageIcon("img/R4_clicked.png"));
		R4.setToolTipText("Online");

        OK.setBounds(400, 505, 70, 50);
		OK.setIcon(new ImageIcon("img/OK.png"));
		OK.setPressedIcon(new ImageIcon("img/OK_clicked.png"));

        LCD.setBounds(130, 510, 200, 40);
        LCD.setEditable(false);

        UP.setBounds(70, 500,25, 25);
		UP.setIcon(new ImageIcon("img/UP.png"));

        DOWN.setBounds(70, 525, 25, 25);
		DOWN.setIcon(new ImageIcon("img/DOWN.png"));
        
        for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				 matrix[i][j] = new SoundButton(i, j, this);
				 sButtonGrid.add(matrix[i][j]);
			 }
        }


        GUI.add(L1);
        GUI.add(L2);
        GUI.add(L3);
        GUI.add(L4);
        GUI.add(R1);
        GUI.add(R2);
        GUI.add(R3);
        GUI.add(R4);
        GUI.add(ON);
        GUI.add(OK);
        GUI.add(LCD);
        GUI.add(UP);
        GUI.add(DOWN);


        GUI.add(sButtonGrid);
        
	//Method defines the operations of the On button.
	//When ON button hasn't been clicked, only the ON button is enabled
	// and all others are disabled. 
	//Once ON button is clicked on, the tenori device continues in Performance
	// mode meaning all buttons are turned on. 
	//@authors Bradley Knoesen, Eneida Morina and David Olagunju. 
        ON.addMouseListener (new MouseAdapter() 
        {
        	public void mouseClicked (MouseEvent me) {
                if (Device.getInstance().getMode() instanceof OffMode) 
                {
                	Device.getInstance().setMode(new PerformanceMode());
                	L1.setEnabled(true);
					L2.setEnabled(true);
					L3.setEnabled(true);
					L4.setEnabled(true);
					R1.setEnabled(true);
					R2.setEnabled(true);
					R3.setEnabled(true);
					R4.setEnabled(true);
					OK.setEnabled(true);
                    ON.setSelected(true);
                    UP.setSelected(true);
                    DOWN.setSelected(true);
                    System.out.println("ON/OFF button clicked: ON");
                    for (int i = 0; i < 16; i++){ 		
						for (int j = 0; j < 16; j++ ) { 
							matrix[i][j].setEnabled(true);
						}
                    }
                    LCD.setText("LCD");
		    //Clock hand implementation. Works however is slow and needs improvements. 
		    //@authors David Olagunju.
                    clockHand = new ClockHand(Device.getInstance().getTenori());
                    (new Thread(clockHand)).start();
                }
                else 
                {
                	clear();
                	Device.getInstance().setMode(new OffMode());
                	L1.setEnabled(false);
					L2.setEnabled(false);
					L3.setEnabled(false);
					L4.setEnabled(false);
					R1.setEnabled(false);
					R2.setEnabled(false); 
					R3.setEnabled(false);
					R4.setEnabled(false);
					OK.setEnabled(false);
                    System.out.println("ON/OFF button clicked: OFF");
                    for (int i = 0; i < 16; i++){ 		
                    	for (int j = 0; j < 16; j++ ) { 
                    		matrix[i][j].setEnabled(false);
                    	}
                    }
		   // while(clockHand.running != false){
		    	clockHand.running.set(false);
		    //}                
		}
            }
        });
        

	//Method to display correct message when the OK button is clicked on. 
	//Only displays message if button is enabled, else displays an error message. 
	//@authors Kate Mawbey, Eneida Morina. 
        OK.addMouseListener (new MouseAdapter() {
            public void mouseClicked (MouseEvent me) {
                System.out.println("OK");
                if (!(Device.getInstance().getMode() instanceof PerformanceMode)) {                 
                //records the number from the l1 buttons
                //holds the name value in display
                
                //goes to performance mode
                clear();
            	Device.getInstance().setMode(new PerformanceMode());
                }
            }
        });

	
       // Methods to display correct message when the L1 button is clicked on.
       // Only displays message if button is enabled, else displays an error message. 
       // @Kate Mawbey, Eneida Morina. 	
        L1.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("L1 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
				//Future implementation - moving from methods to classes. 
        			//Device.getInstance().setMode(new ChangeVoiceMode());
        			//L1.setSelected(true);
        			clear();
        		}
        		
        	}
        });

         // Methods to display correct message when the L2 button is clicked on.
	 // Only displays message if button is enabled, else displays an error message. 
	 // @Kate Mawbey, Eneida Morina. 
        L2.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("L2 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			L2.setSelected(true);
        			clear();
        		}
        		
        	}
        });


        // Methods to display correct message when the L3 button is clicked on.
	// Only displays message if button is enabled, else displays an error message. 
        // @Kate Mawbey, Eneida Morina.       
        L3.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("L3 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			L3.setSelected(true);
        			clear();
        		}
        		
        	}
        });
        
        // Methods to display correct message when the L4 button is clicked on.
	//Only displays message if button is enabled, else displays an error message. 
	// @Kate Mawbey, Eneida Morina. 
        L4.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("L4 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			L4.setSelected(true);
        			clear();
        		}
        		
        	}
        });
        
	// Methods to display correct message when the R1 button is clicked on.
	//Only displays message if button is enabled, else displays an error message. 
	// @Kate Mawbey, Eneida Morina. 
        R1.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("R1 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			//Device.getInstance().setMode(new ChangeVoiceMode());
        			//R1.setSelected(true);
        			clear();
        		}
        		
        	}
        });
        
        // Methods to display correct message when the R2 button is clicked on.
        // Only displays message if button is enabled, else displays an error message. 
        // @Kate Mawbey, Eneida Morina. 	
        R2.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("R2 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			//Device.getInstance().setMode(new ChangeVoiceMode());
        			//R2.setSelected(true);
        			clear();
					clockHand.running.set(false);
        		}
        		
        	}
        });

        // Methods to display correct message when the R3 button is clicked on.
        // Only displays message if button is enabled, else displays an error message. 
	// @Kate Mawbey, Eneida Morina. 
        R3.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("R3 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			//Device.getInstance().setMode(new ChangeVoiceMode());
        			//R3.setSelected(true);
        			clear();
					clockHand.running.set(false);
        		}
        		
        	}
        });
        
        // Methods to display correct message when the R4 button is clicked on.
	// Only displays message if button is enabled, else displays an error message. 
	// @Kate Mawbey, Eneida Morina. 
        R4.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("R4 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			//Device.getInstance().setMode(new ChangeVoiceMode());
        			//R4.setSelected(true);
        			clear();
        		}
        		
        	}
        });
        addDefSounds();
    }

      
        //Method to add the default sounds to the matrix. 
	//@authors Bradley Knoesen and Presley Kode. 
    	public void addDefSounds() {
		int snd = 1;
		for (int x = 0; x <16; x++){
			for (int j = 0; j<16; j++){
				matrix[x][j].setSound(snd);
				}
			snd+=8;
		}
	}


    public JPanel getTenori() 
    {
        return this.GUI;
    }
    
    public SoundButton getButton(int x, int y) 
    {
        return matrix[x][y];
    }
    

    // Method to display the clock hand on the screen by selecting the buttons. 
    // @author David Olagunju. 
    public void clockHandHighLight(int x)
    {
    	for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				 if (!(SoundButton.getButtonsSelected().contains(matrix[i][j])))
				 matrix[i][j].Off();
				 
			 }
    	}
    	
    	for (int k = 0; k < 16; k+=5 ){
    		getButton(k, x).On();
    		
    	}
    }
    
    // Method to highlight the whole row and column when a button is clicked. 
    // @authors David Olagunju, Presley Kode. 
    public void modeButtonHighLight(int x, int y) 
    {
    	for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				 matrix[i][j].Off();
			 }
    	}
    	
    	for (int k = 0; k < 16; k++ ){
    		getButton(x, k).On();
    		getButton(k, y).On();
    	}
    }


	// Method to clear all the buttons that have been selected. 
	// Is called by the mode buttons. 
	// @authors Eneida Morina, Bradley Knoesen.     
	public void clear() {
		for (int i = 0; i < 16; i++){ //column
			 for (int j = 0; j < 16; j++ ) { //row
				matrix[i][j].setSelected(false);
			 }
		}
	}


	// Method to return the synthesizer. 
	// @authors Bradley Knoesen. 
	public Synthesizer getSynth(){
		return this.synthesizer;
	}

	
    // Method to create a new GUI. 
    // @authors Bradley Knoesen, Presley Kode, Kate Mawbey, Eneida Morina, David Olagunju. 
    public static Tenori makeGUI()
    {
        //Singleton
        private static Tenori g = new Tenori();
        if (g == null){
       		final Tenori g = new Tenori();
       }
        
        //final Tenori g = new Tenori();

        Runnable runnable = new Runnable() {

            public void run() {
                JFrame frame = new JFrame("Tenori-ON");
                frame.setLocation(400, 100);
                frame.setPreferredSize(new Dimension(565, 565));
                frame.setResizable(false);

                Toolkit screen = Toolkit.getDefaultToolkit();
                Dimension screenSize = screen.getScreenSize();
                int screenWidth = screenSize.width;
                int screenHeight = screenSize.height;
                frame.setLocation(screenWidth / 4, screenHeight / 8);
                frame.add(g.getTenori());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(runnable);
        return g;

    }

    public static void main(String[] argv){
    	makeGUI();
    }
}
