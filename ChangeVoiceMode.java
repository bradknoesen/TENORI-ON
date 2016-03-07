

public class ChangeVoiceMode implements Mode{
    
    public ChangeVoiceMode(){
    }
    
    public void changeVoice(Layer layer, int sound) {
	layer.setSound(sound);
    }


	/*
	for (int x=0;x<16;x++){
	    matrix[y][x].sound = sound;
	}
	*/
}
