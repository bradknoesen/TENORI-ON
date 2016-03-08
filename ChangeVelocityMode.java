/*
 * @authors Bradley Knoesen, Presley Kode
 */

public class ChangeVelocityMode implements Mode{
    
    
    public ChangeVelocityMode(){}
    
    public chageVelocity(SoundButton soundButton,int veloc){
        int y = soundButton.y;
        for (int x=0;x<16;x++){
            matrix[y][x].veloc = veloc;
        }
        int x = soundButton.x;
        for (int y=0;y<16;y++){
            matrix[y][x].veloc = veloc;
        }
    }
}
