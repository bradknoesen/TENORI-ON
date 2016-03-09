
/**
 *
 * @author Bradley Knoesen
 */

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import java.util.HashMap;

public class Midi
{
  //Store instument names in array index corresponds to midi number
  private final static int FUDGE_FACTOR = 10;

	static private String instruments[] = {"ACOUSTIC GRAND PIANO","BRIGHT ACOUSTIC PIANO","ELECTRIC GRAND PIANO",
"HONKY TONK PIANO","ELECTRIC PIANO1","ELECTRIC PIANO2","HARSICORD",
"CLAVINET","CELESTA","GLOCKENSPIEL","MUSIC BOX","VIBRAPHONE","MARIMBA",
"XYLOPHONE","TUBULAR_BELLS","DULCIMER","DRAWBAR ORGAN","PERCUSSION ORGAN","ROCK ORGAN","CHURCH ORGAN","REED ORGAN","ACCORDIAN","HARMONICA",
"TANGO ACCORDIAN","ACOUSTIC GUITAR NYLON","ACOUSTIC GUITAR STEEL",
"ELECTRIC GUITAR JAZZ","ELECTRIC GUITAR CLEAN","ELECTRIC GUITAR MUTED",
"OVERDRIVEN GUITAR","DISTORTION GUITAR","GUITAR HARMONICS","ACOUSTIC BASS","ELECTRIC BASS FING","ELECTRIC BASS PICK","FRETLESS BASS","SLAP BASS1","SLAP BASS2","SYNTH BASS1","SYNTH BASS2","VIOLIN","VIOLA","CELLO","CONTRABASS","TREMOLO STRINGS","PIZZICATO STRINGS","ORCHESTRAL HARP",
"TIMPANI","STRING ENS1","STRING ENS2","SYNTH STRING1","SYNTH STRINGS2",
"CHOIR AAHS","VOICE OOHS","SYTNH CHOIR","ORCHESTRA HIT","TRUMPET",
"TROMBONE","TUBA","MUTED TRUMPET","FRENCH HORN","BRASS SECTION",
"SYNTH BRASS1","SYNTH BRASS2","SOPRANO SAX","ALTO SAX","TENOR SAX",
"BARITON SAX","OBOE","ENGLISH HORN","BASSOON","CLARINET","PICCOLO",
"FLUTE","RECORDER","PAN FLUTE","BLOWN BOTTLE","SHAKAHACHI","WHISTLE",
"OCARINA","LEAD1","LEAD2","LEDA3","LEAD4","LEDA5","LEAD6","LEAD7","LEAD8",
"PAD1","PAD2","PAD3","PAD4","PAD5","PAD6","PAD7","PAD8","FX1","FX2","FX3",
"FX4","FX5","FX6","FX7","FX8","SITAR","BANJO","SHAMISEN","KOTO","KALIMBA",
"BAGPIPE","FIDDLE","SHANAI","TINKER_BELL","AGOGO","STEEL DRUMS","WOODBLOCK","TAIKO DRUM","MELODIC TOM","SYNTH DRUM","REVERSE CYMBAL","GUITAR FRET","BREATH","SEASHORE","BIRDTWEET","TELEPHONE","HELICOPTER","APPLAUSE",
"GUNSHOT"};


  public void delay( int ms )
  {
	  try{
	    Thread.sleep( ms );
	} catch(Exception e){
	    System.out.println(e); System.exit( 1 );
        }
    }

  public Synthesizer getSynthesizer()
  {
	Synthesizer synthesizer = null;
	try{
	    synthesizer = MidiSystem.getSynthesizer();
	    synthesizer.open();
	} catch( Exception e ){
	    System.out.println( e ); System.exit( 1 );
	}
	return synthesizer;
  }
    
    public void playInstrument( Synthesizer synthesizer 
				, int channel
				, int program
				, int note
				, int velocity ){

	MidiChannel[] midiChannels = synthesizer.getChannels();
	MidiChannel midiChannel = midiChannels[ channel ];
	Instrument[] instruments =
	    synthesizer.getDefaultSoundbank().getInstruments();
	
	synthesizer.loadInstrument( instruments[ program ] );
	midiChannel.programChange( program );
	midiChannel.noteOn ( note, velocity );
	delay( FUDGE_FACTOR * velocity );
	midiChannel.noteOff( note, velocity );
    }


	static public String getInstrument(int x){
		return instruments[x];
	}
/*
	public static void main(String[] args){
		Midi midi = new Midi();
		Synthesizer synth = midi.getSynthesizer();

		for (int x=0;x<129;x++){
			midi.playInstrument(synth, 10, x, 10, 60);
			getInstrument(x);
		}
	}
*/

} 
