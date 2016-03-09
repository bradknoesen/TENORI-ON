public class ChangeLayerMode implements Mode
{

  public ChangeLayerMode()
  {
    //Change Layer Mode
        //
	// Methods to display correct message when the R1 button is clicked on.
	//Only displays message if button is enabled, else displays an error message. 
	// @Kate Mawbey, Eneida Morina. 
	  Device de;
	  de.geTenori();
	  
        de.R1.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        		System.out.println("R1 button clicked");
        		if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			Device.getInstance().setMode(new ChangeLayerMode());
        			de.R1.setSelected(true);
        			clear();
        		}
        		
        	}
        });
  }
  
  public void changeLayer(Tenori tenori,int layerNum)
  {
    tenori.setCurrentLayer(layerNum);
  }
  
}
