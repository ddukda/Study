package com.study.headfirst.gui;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Sound {

	public static void main(String[] args){
		
		Sound sound = new Sound();
		
		sound.play();
	}
	
	
	public void play(){
		
		try{
			
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track t = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 44, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			t.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			t.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
			
		}catch(MidiUnavailableException mae){
			mae.printStackTrace();
		} catch (InvalidMidiDataException imde) {
			imde.printStackTrace();
		}
		
		
		
		
		
	}
}
