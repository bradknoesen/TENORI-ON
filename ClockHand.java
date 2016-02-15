import java.util.concurrent.atomic.*;

public class ClockHand {
	private Tenori Tenori;
	private int loop = 16;
	public AtomicBoolean running = new AtomicBoolean();
	
	public ClockHand (Tenori Tenori){
		this.Tenori = Tenori;
	}
	
	public void run(){
		System.out.println("Clockhand thread is running");
		running.set(true);
		
		while(running.get()){
			//clock hand pattern loop
			for (int i=0; i < getLoop(); i++){
				Tenori.clockHandHighlight(i);
			}
			
			
		}
	}
	
	public void setLoop(int loop){
		this.loop = loop;
	}
	
	public int getLoop(){
		return this.loop;
	}
}
