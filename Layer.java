public class Layer 
{
	private int sound;	//store sound in layer class
	private int loopSpeed;
	
	public void setSound(int sound)
	{
		this.sound = sound;
	}
	
	public void setLoopSpeed(int loopSpeed)
	{
		this.loopSpeed = loopSpeed;
	}
	
	private boolean[] buttonArray = new boolean[16 * 16];
	
	public boolean[] getLayer()
	{
		return buttonArray;
	}
	
	public void setLayer(boolean[] array)
	{
		if(array.length != 16 * 16)
			throw new IllegalArgumentException("Array is not the appropriate size.");
		buttonArray = array;
	}

}
