import java.net.*;

public class MasterSlaveMode implements Mode
{

  public MasterSlaveMode()
  {
      Device de;
      de.getTenori();
      
      de.R4.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me){
        	  System.out.println("R4 button clicked");
        	  
        	  if (Device.getInstance().getMode() instanceof OffMode){
        			JOptionPane.showMessageDialog(null, "Please turn on the Tenori!");
        			return;
        		}
        		else {
        			Device.getInstance().setMode(new MasterSlaveMode());
        			de.R4.setSelected(true);
        			clear();
        			
        			
        		//Save configuration and Load onto Slave Device
        		
        			
        			
        		}
        		
        	}
        });
  }
  
 
  
  public void connect(String hostName, int portNumber)
  {
  
  try{
    //Create socket using args
    Socket sock = new Socket(hostName, portNumber);
    //Create streams
    InputStream  in   =  s.getInputStream();
    OutputStream out  =  s.getOutputStream();

    BufferedReader reader = new BufferedReader( new InputStreamReader( in ) );
    PrintWriter writer = new PrintWriter( out );
    //add more...
    }
    catch(Exception e){
      System.out.println("Erro " + e);
      }
  }
}
