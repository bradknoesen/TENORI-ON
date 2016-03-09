public class Layer 
{
	private int sound;	//store sound in layer class
	private int loopSpeed;
	private int loopPoint;
	
	public void setSound(int sound)
	{
		if (sound > -1 && sound < 129)
		{
			this.sound = sound;
		}
		else
		{
			System.out.println("Sound out of range exception");	//add exception
		}
	}
	
	public void setLoopSpeed(int loopSpeed)
	{
		this.loopSpeed = loopSpeed;
	}
	
	public void setLoopPoint(int loopPoint)
	{
		if (loopPoint < 0 || loopPoint > 128)
		{
			System.out.println("Loop Point out of range exception!");	//add exception
		}
		else
		{
			this.loopPoint = loopPoint;	
		}
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
