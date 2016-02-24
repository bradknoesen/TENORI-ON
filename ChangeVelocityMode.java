

public class ChangeVelocityMode implements Mode{
    
    
    public ChangeVelocityMode(){}
    
    public chageVelocity(soundButton,veloc){
      int y = soundButton.y;
      for (int x=0;x<16;x++){
        matrix[y][x].veloc = veloc;
      }
}
