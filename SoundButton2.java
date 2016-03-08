import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class SoundButton extends JToggleButton
{
	private static final long serialVersionUID = 1L;

    private final int x;
    private final int ycoord;
    private final Tenori tenori;
	public String value; //ADDED
    private int sound;
    private int note = 40;
    private int veloc = 200;
    
    private boolean clicked = false;
    
    private static ArrayList<SoundButton> buttonsSelected = new ArrayList<SoundButton>();

    public SoundButton(int x, int y, Tenori te, String val)//ADDED
    {
    	this.x = x;
    	this.ycoord = y;
    	this.tenori = te;
    	this.setContentAreaFilled(false);
    	this.setBorderPainted(false);
    	this.setFocusPainted(false);
    	this.setEnabled(false);
    	this.setIcon(new ImageIcon("img/white.png"));
    	this.setSelectedIcon(new ImageIcon("img/orange.png"));
		this.value = val;//ADDED
    	
    	addMouseListener(new MouseAdapter()
    	{
    	    		
            public void mouseClicked(MouseEvent e) 
            {
                SoundButton buttonClicked = (SoundButton)e.getSource();
                Device.getInstance().getMode().soundButtonOperation(buttonClicked);
		try {
			tenori.midi.playInstrument(tenori.synthesizer,ycoord,sound,note, veloc);
		} 
		catch(Exception err){System.out.println("Error"+err);}
						
            }
    	}
    	);
    }
   
    public static ArrayList<SoundButton> getButtonsSelected()
    {
        return buttonsSelected;
    }
    
   
    public static void addButtonsSelected(SoundButton b){
        buttonsSelected.add(b);
    }

   
    public static void removeButtonsSelected(SoundButton b){
        buttonsSelected.remove(b);
    }

   
    public static void clearButtonsSelected(){
        buttonsSelected.clear();
    }

   
    public int getXCoord()
    {
        return this.x;
    }
    
    
    public int getYCoord()
    {
        return this.ycoord;
    }
    
    public Tenori getTenori()
    {
    	return this.tenori;
    }
//ADDED
    public String getVal()
    {
    	return this.value;
    }
    
    public boolean getState()
    {
    	return this.clicked;
    }
    
    
    public void On()
    {
    	if(!clicked)
    	{
    		this.setSelected(true);
    		clicked = true;
    	}
    }
    
    public void Off()
    {
    	if(clicked)
    	{
    		this.setSelected(false);
    		clicked = false;
    	}
    } 
    public void setSound(int sound){
	this.sound=sound;
    }

    public void setVelocity(int velocity){
	this.veloc = velocity;
    }
	   
}
