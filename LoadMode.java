public class LoadMode implements Mode{
    
    public LoadMode(){
    }
    
    public void soundButtonOperation(SoundButton button) 
    {
    	System.out.println(button.getVal());
		button.getTenori().modeButtonHighLight(button.getXCoord(), button.getYCoord());
		button.getTenori().modeLCD(button.getVal());
		System.out.println("sound process");
    }


}
