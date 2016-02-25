import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class SoundButton extends JToggleButton
{
	private static final long serialVersionUID = 1L;

    private final int x;
    private final int y;
    private final Tenori te;
    
    private boolean clicked = false;
    
    private static ArrayList<SoundButton> buttonsSelected = new ArrayList<SoundButton>();

    public SoundButton(int x, int y, Tenori te)
    {
    	this.x = x;
    	this.y = y;
    	this.te = te;
    	this.setContentAreaFilled(false);
    	this.setBorderPainted(false);
    	this.setFocusPainted(false);
    	this.setEnabled(false);
    	this.setIcon(new ImageIcon("img/white.png"));
    	this.setSelectedIcon(new ImageIcon("img/orange.png"));
    	
    	addMouseListener(new MouseAdapter()
    	{
    	    		
            public void mouseClicked(MouseEvent e) 
            {
                SoundButton buttonClicked = (SoundButton)e.getSource();
                Device.getInstance().getMode().soundButtonOperation(buttonClicked);
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
        return this.y;
    }
    
    public Tenori getTenori()
    {
    	return this.te;
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
}

