public class Device
{
	
    private static Device instance = null;
    
    private Mode mode = new OffMode();
    private Layer[] layers;
    private Tenori tenori;
    
    public Device()
    {
    	mode = new OffMode();
    	layers = new Layer[16];
    	tenori = Tenori.makeGUI();
    }
    
    public static Device getInstance()
    {
        if(instance == null){
            instance = new Device();
        }
        return instance;
    }
    
    public void setMode(Mode mode)
    {
        this.mode = mode;
    }
    
    public Mode getMode()
    {
        return mode;
    }

    public Tenori getTenori()
    {
        return tenori;
    }
}
