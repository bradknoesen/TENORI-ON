import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;

public class SoundButton extends JToggleButton {

	private static final long serialVersionUID = -3562101876274080396L;
	//The X and Y co-ord of the button
	private final int x;
	private final int y;

	private int sound;	//stores the midi sound number
	private int note	//stores the note
	
	private Tenori tenori;
	
	private static ArrayList<SoundButton> buttonsSelected = new ArrayList<SoundButton>();
	//could also use arraylist like
	
	public SoundButton(int x, int y, Tenori tenori){
		this.x = x;
		this.y = y;
		this.tenori = tenori;
		
		
		//this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		
		addMouseListener (new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				//produce sound
			}
		});		
	}
	
	public static ArrayList<SoundButton> getButtonsSelected(){
		return buttonsSelected;
	}
	
	public static void addButtonsSelected(SoundButton e){
		buttonsSelected.add(e);
	}
	
	public static void removeButtonsSelected(SoundButton e){
		buttonsSelected.remove(e);
	}
	
	public static void clearButtonsSelected(SoundButton e){
		buttonsSelected.clear();
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Tenori getTenori(){
		return this.tenori;
	}
	
	public int getSound(){
		return this.sound;
	}
	
	public void setSound(int sound){
		this.sound = sound;
	}
	
	public void setNote(int note){
		this.note = note;
	}
}
