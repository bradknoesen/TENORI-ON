/*
 * @authors Bradley Knoesen, Presley Kode
 */

public class ChangeVoiceMode implements Mode{
    
    public ChangeVoiceMode()
    {
    	private Device dev;
    	dev.getTenori();
    	
    	//Change Voice Mode
	//
	// Methods to display correct message when the L1 button is clicked on.
       	// Only displays message if button is enabled, else displays an error message. 
	// @Kate Mawbey, Eneida Morina. 
    	dev.L1.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("L1 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
				//Future implementation - moving from methods to classes. 
        			Device.getInstance().setMode(new ChangeVoiceMode());
        			//L1.setSelected(true);
        			clear();
        		}
        		
        	}
        });
    }
    
    public void changeVoice(Layer layer, int sound) {
	layer.setSound(sound);
    }
    
    
    
    
    
}
