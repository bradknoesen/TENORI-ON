public class ChangeLoopPoint Mode implements Mode {

  public ChangeLoopPointMode()
  {
    //Change Loop Point Mode
        // Methods to display correct message when the L4 button is clicked on.
	//Only displays message if button is enabled, else displays an error message. 
	// @Kate Mawbey, Eneida Morina. 
	  Device de;
	   de.getTenori();
	
        de.L4.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("L4 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			Device.getInstance().setMode(new ChangeLoopPointMode());
        			de.L4.setSelected(true);
        			clear();
        		}
        		
        	}
        });
  }
  
  public void setLoopPoint(Layer layer, int loopPoint){
    layer.loopPoint = loopPoint;
  }
  
}
