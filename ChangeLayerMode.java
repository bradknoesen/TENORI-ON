public class ChangeLayerMode implements Mode
{

  public ChangeLayerMode(){}
  
  public void changeLayer(Tenori tenori,int layerNum)
  {
    tenori.setCurrentLayer(layerNum);
  }
  
}
