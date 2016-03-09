public class ChangeLoopSpeedMode implements Mode {

  public ChangeLoopSpeedMode()
  {
    //Change Loop Speed Mode
    // Methods to display correct message when the L3 button is clicked on.
  	// Only displays message if button is enabled, else displays an error message. 
    // @Kate Mawbey, Eneida Morina.       
    Device de;
    de.getTenori();
    
        de.L3.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("L3 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			Device.getInstance().setMode(new ChangeLoopSpeedMode());
        			de.L3.setSelected(true);
        			clear();
        		}
        		
        	}
        });
  }
  
  public void setLoopSpeed(Layer layer, int loopSpeed){
    layer.loopSpeed = loopSpeed;
  }
}
