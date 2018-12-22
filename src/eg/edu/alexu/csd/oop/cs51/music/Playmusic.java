package eg.edu.alexu.csd.oop.cs51.music;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Playmusic implements Runnable{
	private Thread music;
	private final AtomicBoolean running=new AtomicBoolean(false);
	private static Clip clip ;
	public void start() {
		music =new Thread(this);
		music.start();
		
	}
	public void stop() {
		running.set(false);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		running.set(true);
		while(running.get()) {
		      try {
		        clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("v.wav"));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		      try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		         while(clip.isRunning())
		         {
		        	 if(!running.get()) {
		        		 break;
		        	 }
		           try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         }
			
			
		}
		clip.stop();
		
		
	}

}
