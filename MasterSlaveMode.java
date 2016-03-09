import java.net.*;

public class MasterSlaveMode implements Mode
{

  public MasterSlaveMode(){}
  
 
  
  public void connect(String hostName, int portNumber)
  {
  
  try{
    Socket sock = new Socket(hostName, portNumber);
    //add more...
    }
    catch(Exception e){
      System.out.println("Erro " + e);
      }
  }
}
