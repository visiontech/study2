package ua.viasat.www;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Player {
	public static float SAMPLE_RATE = 8000f;

	public static void tone(int hz, int msecs, double vol)
			throws LineUnavailableException {

		byte[] buf = new byte[1];
		AudioFormat af = new AudioFormat(SAMPLE_RATE, // sampleRate
				8, // sampleSizeInBits
				1, // channels
				true, // signed
				false); // bigEndian
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();
		for (int i = 0; i < msecs * 8; i++) {
			double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
			buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
			sdl.write(buf, 0, 1);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}

	private MidiChannel[] channels = null;
	private Synthesizer synth = null;

	public Player() {
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			channels = synth.getChannels();
			channels[0].programChange(41);
		} catch (MidiUnavailableException ex) {
			Logger.getLogger(Player.class.getName())
					.log(Level.SEVERE, null, ex);
		}
	}

	public void close() {
		synth.close();
	}

	public void playSound(int channel, int duration, int volume, int... notes) {
		for (int note : notes) {
			channels[channel].noteOn(note, volume);
		}
		try {
			Thread.sleep(duration);
		} catch (InterruptedException ex) {
			Logger.getLogger(Player.class.getName())
					.log(Level.SEVERE, null, ex);
		}
		for (int note : notes) {
			channels[channel].noteOff(note);
		}
	}
	
	

	public static void playmelody() {

		Player player = new Player();
		// player.playSound(0, 500, 80, 69, 78, 81);
		int n = 2;
		player.playSound(0, 1000, 80, 67, 71, 74);
		player.playSound(0, 1500, 80, 67+n, 71+n, 74+n);

		player.close();
	}
	
	public static void playmelody1() {

		Player player = new Player();
		// player.playSound(0, 500, 80, 69, 78, 81);
		int n = -5;
		player.playSound(0, 200, 80, 80, 80, 80);
		player.playSound(0, 500, 80+n, 80+n, 80+n, 80+n);

		player.close();
	}
}
