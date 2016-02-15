/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenori;

/**
 *
 * @author sup3rmuff1n
 */

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Midi {
    
    private final static int FUDGE_FACTOR = 10;

//PIANO
    public final static int ACOUSTIC_GRAND_PIANO = 1;
    public final static int BRIGHT_ACOUSTIC_PIANO = 2;
    public final static int ELECTRIC_GRAND_PIANO = 3;
    public final static int HONKY_TONK_PIANO = 4;
    public final static int ELECTRIC_PIANO1 = 5;
    public final static int ELECTRIC_PIANO2 = 6;
    public final static int HARSICORD = 7;
    public final static int CLAVINET = 8;
    
    //CHROMATIC PERCUSSION
    public final static int CELESTA = 9;
    public final static int GLOCKENSPIEL = 10;
    public final static int MUSIC_BOX = 11;
    public final static int VIBRAPHONE = 12;
    public final static int MARIMBA = 13;
    public final static int XYLOPHONE = 14;
    public final static int TUBULAR_BELLS = 15;
    public final static int DULCIMER = 16;
    
    //ORGAN
    public final static int DRAWBAR_ORGAN = 17;
    public final static int PERCUSSION_ORGAN = 18;
    public final static int ROCK_ORGAN = 19;
    public final static int CHURCH_ORGAN = 20;
    public final static int REED_ORGAN = 21;
    public final static int ACCORDIAN = 22;
    public final static int HARMONICA = 23;
    public final static int TANGO_ACCORDIAN = 24;
    
    //GUITAR
    public final static int ACOUSTIC_GUITAR_NYLON = 25;
    public final static int ACOUSTIC_GUITAR_STEEL = 26;
    public final static int ELECTRIC_GUITAR_JAZZ = 27;
    public final static int ELECTRIC_GUITAR_CLEAN = 28;
    public final static int ELECTRIC_GUITAR_MUTED = 29;
    public final static int OVERDRIVEN_GUITAR = 30;
    public final static int DISTORTION_GUITAR = 31;
    public final static int GUITAR_HARMONICS = 32;
    
    //BASS
    public final static int ACOUSTIC_BASS = 33;
    public final static int ELECTRIC_BASS_FING = 34;
    public final static int ELECTRIC_BASS_PICK = 35;
    public final static int FRETLESS_BASS = 36;
    public final static int SLAP_BASS1 = 37;
    public final static int SLAP_BASS2 = 38;
    public final static int SYNTH_BASS1 = 39;
    public final static int SYNTH_BASS2 = 40;
    
    //STRINGS
    public final static int VIOLIN = 41;
    public final static int VIOLA = 42;
    public final static int CELLO = 43;
    public final static int CONTRABASS = 44;
    public final static int TREMOLO_STRINGS = 45;
    public final static int PIZZICATO_STRINGS = 46;
    public final static int ORCHESTRAL_HARP = 47;
    public final static int TIMPANI = 48;
    
    //ENSEMBLE
    public final static int STRING_ENS1 = 49;
    public final static int STRING_ENS2 = 50;
    public final static int SYNTH_STRING1 = 51;
    public final static int SYNTH_STRINGS2 = 52;
    public final static int CHOIR_AAHS = 53;
    public final static int VOICE_OOHS = 54;
    public final static int SYTNH_CHOIR = 55;
    public final static int ORCHESTRA_HIT = 56;
    
    //BRASS
    public final static int TRUMPET = 57;
    public final static int TROMBONE = 58;
    public final static int TUBA = 59;
    public final static int MUTED_TRUMPET = 60;
    public final static int FRENCH_HORN = 61;
    public final static int BRASS_SECTION = 62;
    public final static int SYNTH_BRASS1 = 63;
    public final static int SYNTH_BRASS2 = 64;
    
    //REED
    public final static int SOPRANO_SAX = 65;
    public final static int ALTO_SAX = 66;
    public final static int TENOR_SAX = 67;
    public final static int BARITON_SAX = 68;
    public final static int OBOE = 69;
    public final static int ENGLISH_HORN = 70;
    public final static int BASSOON = 71;
    public final static int CLARINET = 72;
    
    //PIPE
    public final static int PICCOLO = 73;
    public final static int FLUTE = 74;
    public final static int RECORDER = 75;
    public final static int PAN_FLUTE = 76;
    public final static int BLOWN_BOTTLE = 77;
    public final static int SHAKAHACHI = 78;
    public final static int WHISTLE = 79;
    public final static int OCARINA = 80;
    
    //SYNTH LEAD
    public final static int LEAD1 = 81;
    public final static int LEAD2 = 82;
    public final static int LEAD3 = 83;
    public final static int LEAD4 = 84;
    public final static int LEAD5 = 85;
    public final static int LEAD6 = 86;
    public final static int LEAD7 = 87;
    public final static int LED8 = 88;
    
    //SYNTH PAD
    public final static int PAD1 = 89;
    public final static int PAD2 = 90;
    public final static int PAD3 = 91;
    public final static int PAD4 = 92;
    public final static int PAD5 = 93;
    public final static int PAD6 = 94;
    public final static int PAD7 = 95;
    public final static int PAD8 = 96;
    
    //SYNTH EFFECTS
    public final static int FX1 = 97;
    public final static int FX2 = 98;
    public final static int FX3 = 99;
    public final static int FX4 = 100;
    public final static int FX5 = 101;
    public final static int FX6 = 102;
    public final static int FX7 = 103;
    public final static int FX8 = 104;
    
    //ETHINC
    public final static int SITAR = 105;
    public final static int BANJO = 106;
    public final static int SHAMISEN = 107;
    public final static int KOTO = 108;
    public final static int KALIMBA = 109;
    public final static int BAGPIPE = 110;
    public final static int FIDDLE = 111;
    public final static int SHANAI = 112;
    
    //PERCUSSIVE
    public final static int TINKER_BELL = 113;
    public final static int AGOGO = 114;
    public final static int STEEL_DRUMS = 115;
    public final static int WOODBLOCK = 116;
    public final static int TAIKO_DRUM = 117;
    public final static int MELODIC_TOM = 118;
    public final static int SYNTH_DRUM = 119;
    public final static int REVERSE_CYMBAL = 120;
    
    //SOUND EFFECTS
    public final static int GUITAR_FRET = 121;
    public final static int BREATH = 122;
    public final static int SEASHORE = 123;
    public final static int BIRD_TWEET = 124;
    public final static int TELEPHONE = 125;
    public final static int HELICOPTER = 126;
    public final static int APPLAUSE = 127;
    public final static int GUNSHOT = 128;
    
    
    public void delay( int ms ){
	try{
	    Thread.sleep( ms );
	} catch(Exception e){
	    System.out.println(e); System.exit( 1 );
        }
    }

    public Synthesizer getSynthesizer(){
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
    
    
    
    
           

} 
