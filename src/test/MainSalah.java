package test;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.factory.CompanyFactory;
import eg.edu.alexu.csd.oop.cs51.music.Playmusic;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.skills.FaceBookSkill;
import eg.edu.alexu.csd.oop.cs51.objects.skills.SkillLoader;
import eg.edu.alexu.csd.oop.cs51.strategy.Level1Strategy;
import eg.edu.alexu.csd.oop.cs51.strategy.Strategy;
import eg.edu.alexu.csd.oop.cs51.world.Interview;
import eg.edu.alexu.csd.oop.game.GameEngine;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class MainSalah {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
    	 Playmusic playmusic=new Playmusic();
    	 playmusic.start();
    	 Thread.sleep(10000);
    	playmusic.stop();
    	Thread.sleep(10000);
    	 playmusic.start();
    	
    	
    	
    	
    	/////////////////////////////////////////////
    	
    	//second tagroba sh8al
    	
    	
    	      /*  Clip clip = AudioSystem.getClip();
    	        // getAudioInputStream() also accepts a File or InputStream
    	        AudioInputStream ais = AudioSystem.
    	            getAudioInputStream(new File("v.wav") );
    	        clip.open(ais);
    	        clip.loop(Clip.LOOP_CONTINUOUSLY);
    	        SwingUtilities.invokeLater(new Runnable() {
    	            public void run() {
    	                // A GUI element to prevent the Clip's daemon Thread
    	                // from terminating at the end of the main()
    	            	GameInfo.getInstance();
    	        		SkillLoader skillLoader = new SkillLoader("jars");
    	        		skillLoader.load();
    	        		CompanyFactory companyFactory = new CompanyFactory(skillLoader.getSkills());
    	        		GameInfo.getInstance().setCompanyFactory(companyFactory);
    	        		// MAIN MENU
    	        		// HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    	        		Strategy strategy = new Level1Strategy();
    	        		Interview world = new Interview(strategy, 1360, 768);
    	        		GameEngine game = new GameEngine();
    	        		game.start("Interview Game", world);
    	            }
    	        });*/
    	        
    	        
    	        ////////////////////////////////////////////////////////////
//    	Scanner scanner=new Scanner(System.in);
//    	String input;
//    	while(true) {
//    		
//    		input=scanner.next();
//    		if(input.equals("start")) {
//    			Music.songs(input);
//    		}else if(input.equals("stop")) {
//    			Music.songs(input);
//    			
//    		}
//    	}
    	
        
    }
    public static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
    	 AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("v.wav"));
         Clip clip = AudioSystem.getClip();
         clip.open(inputStream);
         clip.loop(Clip.LOOP_CONTINUOUSLY);
         Thread.sleep(100);
         while(clip.isRunning())
         {
           Thread.sleep(1000000);
         }
    }

}
