import java.util.concurrent.atomic.AtomicBoolean;

public class ClockHand implements Runnable {

    private Tenori te;
    private int loopPoint = 16; //change this vairable for set Loop poiny 
    public AtomicBoolean running = new AtomicBoolean();

    public ClockHand (Tenori te){
        this.te = te;
    }
    
    public void run() {
        System.out.println("Clockhand thread started");
        running.set(true);

        while(running.get()) {

            for (int i=0; i<loopPoint; i++){
                te. clockHandHighLight(i);

                for(int j=0; j<SoundButton.getButtonsSelected().size(); j++)
                {
                    SoundButton button = SoundButton.getButtonsSelected().get(j);

                    if (button.getXCoord() == i)
                    {
                    	

                    }
                }

                if (!running.get())
                {
                	for (int j = 0; j < 16; j++){ //column
           			 for (int k = 0; k < 16; k++ ) { //row
                        te.matrix[j][k].Off();
           			 }
                    }
                    break;
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
