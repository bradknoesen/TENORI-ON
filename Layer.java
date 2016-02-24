public class Layer 
{
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