package test;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySoundEffects implements Runnable{
	private Thread music;
	private static String effect="";
	private boolean playEffects=true;
	public boolean isPlayEffects() {
		return playEffects;
	}

	public void setPlayEffects(boolean playEffects) {
		this.playEffects = playEffects;
	}

	private static Clip clip ;
	public void playEffect(String effect) {
		this.effect=effect;
		if(playEffects) {
		music =new Thread(this);
		music.start();
		}
		
	}
	
	@Override
	public void run() {
		
		AudioInputStream audioInputStream = null;
		try {
			if(effect.equals("collected")) {
				 audioInputStream = AudioSystem.getAudioInputStream(new File("coins.wav"));
			}else if(effect.equals("bomb")) {
				audioInputStream = AudioSystem.getAudioInputStream(new File("Explosion+7.wav"));
			}else if(effect.equals("revive")) {
				audioInputStream = AudioSystem.getAudioInputStream(new File("revive.wav"));
			}else if(effect.equals("taskcompleted")) {
				audioInputStream = AudioSystem.getAudioInputStream(new File("taskcompleted.wav"));
			}
             clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
		      try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		   
	}
}
