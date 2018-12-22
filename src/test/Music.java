package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music {
	 private static AudioStream as;
	 private static  Clip clip;
	 public static void songs(String word) {
	        String temp = word;
	       /* InputStream blah = null ;
			if (temp.equals("start")) {

	            try {

	                try {
	                 blah=  new FileInputStream("v.wav");

	                } catch (Throwable e) {
	                    e.printStackTrace();
	                }
	                 as = new AudioStream(blah);

	                AudioPlayer.player.start(as);
	                System.out.println("going");
	              

	            } catch (IOException e) {
	                System.err.println(e);
	            }
	        }

	        if (temp.equals("stop")) {

	            try {
				    blah = new FileInputStream("v.wav");

				} catch (Throwable e) {
				    e.printStackTrace();
				}
				if (as != null)
				{
				    AudioPlayer.player.stop(as);
				}else {
					
				}
//	                 as = new AudioStream(blah);
//
//	                AudioPlayer.player.stop(as);
//	                System.out.println("stopping");
	        }
	        */
	        try {

	            File file = new File("v.wav");
	            

	            if(temp.equals("stop")){
	            // this loads correctly, but wont stop music
	            clip.stop();
	           System.out.println("clip stoped");
	            }
	            else if(temp.equals("start")){
	            	 clip = AudioSystem.getClip();
	 	            clip.open(AudioSystem.getAudioInputStream(file));
	            clip.start();
	            System.out.println("clip started");

	            }
	        } catch (Exception e) {
	            System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
	        }
	    }
	 
}
