/*
 * @authors Bradley Knoesen, Presley Kode
 */

public class ChangeVelocityMode implements Mode{
    
    
    public ChangeVelocityMode()
    {
        //Change Velocity Mode
        // Methods to display correct message when the L2 button is clicked on.
	    // Only displays message if button is enabled, else displays an error message. 
    	// @Kate Mawbey, Eneida Morina. 
    	Device de;
    	de.getTenori();
    	
        de.L2.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("L2 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			Device.getInstance().setMode(new ChangeVelocityMode());
        			L2.setSelected(true);
        			clear();
        		}
        		
        	}
        });
    }
    
    public chageVelocity(SoundButton soundButton,int veloc){
        int y = soundButton.y;
        for (int x=0;x<16;x++){
            matrix[y][x].veloc = veloc;
        }
        int x = soundButton.x;
        for (int y=0;y<16;y++){
            matrix[y][x].veloc = veloc;
        }
    }
}
