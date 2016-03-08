/*
 * @authors Bradley Knoesen, Presley Kode
 */

public class ChangeVoiceMode implements Mode{
    
    public ChangeVoiceMode(){}
    
    public void changeVoice(Layer layer, int sound) {
	layer.setSound(sound);
    }
}
