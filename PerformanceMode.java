import javax.sound.midi.Synthesizer;
import java.awt.Color;

public class PerformanceMode implements Mode {

    public PerformanceMode() {
        SoundButton.clearButtonsSelected();
    }
    

    @Override
    public void soundButtonOperation(SoundButton button) 
    {

        System.out.println("Performance Mode");
       
        if(!button.getState())
        {
        	button.On();
            SoundButton.addButtonsSelected(button);
        }
        else
        {
        	button.Off();
            SoundButton.removeButtonsSelected(button);        
        }
    
        
    
    }

}
