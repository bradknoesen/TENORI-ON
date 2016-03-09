public class ChangeLoopSpeedMode implements Mode {

  public ChangeLoopSpeedMode(){}
  
  public void setLoopSpeed(Layer layer, int loopSpeed){
    layer.loopSpeed = loopSpeed;
  }
}
