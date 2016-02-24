public class OffMode implements Mode 
{
    public OffMode() 
    {
    	
    }

    @Override
    public void processMatrixButton(SoundButton button) 
    {
        System.out.println("Matrix button cannot be processed in OffMode");
        System.out.println("Please turn on Tenori");
    }

}
