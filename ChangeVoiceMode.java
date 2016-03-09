/*
 * @authors Bradley Knoesen, Presley Kode
 */

public class ChangeVoiceMode implements Mode{
    
    public ChangeVoiceMode()
    {
    	private Device dev;
    	dev.getTenori();
    	
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
