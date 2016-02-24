

public class ChangeVoiceMode implements Mode{
    
    public ChangeVoiceMode(){
    }
    
    public void changeVoice(soundButton,sound) {
	int y = soundButton.y;

	for (int x=0;x<16;x++){
	    matrix[y][x].sound = sound;
	}
    }
	
}
