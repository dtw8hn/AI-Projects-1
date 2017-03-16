package sti;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


@SuppressWarnings("serial")
public class Game extends JFrame {
	JPanel one = new JPanel();
	static Random gen = new Random(11);
	static String lev;
	String mod;
	JFrame scoreFrame= new JFrame();
	JPanel scorePanel = new JPanel();
	static JLabel scorekeep=new JLabel();
	boolean start=false;
	static boolean done=false;
	static int count;
	double keep= System.currentTimeMillis();
	AudioStream audi;
	boolean marathon=false;
	int hardScale=1;
	int hold=30000;
	
	static GameButtons buttons[] = new GameButtons[18];

	/**
	 * @param args
	 * @return
	 * @throws InterruptedException 
	 */
	public void start() throws InterruptedException {
		// TODO Auto-generated method stub
		if(lev.equals("Marathon")){
			marathon=true;
			lev="easy";
			try {
				InputStream in = new FileInputStream("C:/Users/DeVante/Downloads/Kirby_39_s_Dream_Land-_King_Dedede_39_s_Theme.wav");
				audi = new AudioStream(in);
				AudioPlayer.player.start(audi);

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else{
			try {
			InputStream in = new FileInputStream("C:/Users/DeVante/Downloads/King_Dedede_39_s_Theme_-_Super_Smash_Bros.wav");
			audi = new AudioStream(in);
			AudioPlayer.player.start(audi);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
		setVisible(true);
		//StopWatch time = new StopWatch();
		for(int i = 0;i<buttons.length;i++){
			buttons[i].addActionListener(new Action());
		}
		setStage();
	}
	
	public void end(){
		try {
			AudioPlayer.player.stop(audi);
			InputStream in = new FileInputStream("C:/Users/DeVante/Downloads/Mario_Party_-_Finish.wav");
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	class Action implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		if(marathon==false){
		if(System.currentTimeMillis()-keep>30000){
			end();
			done=true;
			endGame();
			//endGame();
		}
		
		
		}
		else{
			if(lev.equals("easy")&& (System.currentTimeMillis()-keep>30000)){
				if(count<185){
					end();
					endGame();
				}
				else{
					lev="medium";
					keep=System.currentTimeMillis();
					try {
						InputStream in = new FileInputStream("C:/Users/DeVante/Downloads/sonic_adventure_2-chao_jingle_level_up.wav");
						AudioStream audio = new AudioStream(in);
						AudioPlayer.player.start(audio);
					//	AudioPlayer.player.stop(audi);
						//InputStream in1 = new FileInputStream("C:/Users/DeVante/Downloads/King_Dedede_39_s_Theme_-_Kirby_39_s_Return_to_Drea.wav");
						//audi = new AudioStream(in1);//get Longer version of the song
						//AudioPlayer.player.start(audi);	
						


					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			if(lev.equals("medium")&& (System.currentTimeMillis()-keep>30000)){
				if(count<(185+180)){
					end();
					endGame();
				}
				else{
					lev="hard";
					keep=System.currentTimeMillis();
					AudioPlayer.player.stop(audi);
					try {
						InputStream in = new FileInputStream("C:/Users/DeVante/Downloads/sonic_adventure_2-chao_jingle_level_up.wav");
						AudioStream audio = new AudioStream(in);
						AudioPlayer.player.start(audio);
						InputStream in1 = new FileInputStream("C:/Users/DeVante/Downloads/King_Dedede_39_s_Theme_-_Super_Smash_Bros.wav");
						audi = new AudioStream(in1);//get Longer version of the song
						AudioPlayer.player.start(audi);	
						
						


					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			if(lev.equals("hard")&& (System.currentTimeMillis()-keep>hold)){
				if(count<(185+180+(hardScale*180))){
					AudioPlayer.player.stop(audi);	
					end();
					endGame();

				}
				else{
					hardScale++;
					hold *=.8;
					keep=System.currentTimeMillis();
					try {
						InputStream in = new FileInputStream("C:/Users/DeVante/Downloads/sonic_adventure_2-chao_jingle_level_up.wav");
						AudioStream audio = new AudioStream(in);
						AudioPlayer.player.start(audio);
						
						


					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
	}
	}
	public Game(String level) throws FileNotFoundException {
		super("Buzz Buzz");
		Game.count=0;
		lev=level;
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		one.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new GameButtons();
			one.add(buttons[i]);
		}
		add(one);
		scorekeep.setFont(new Font("LiHei Pro", Font.BOLD, 88));
		scorekeep.setText("Score: "+0);
		scorekeep.setSize(400,400);
		scorePanel.add(scorekeep);
		scorePanel.setVisible(true);
		scoreFrame.setLocation(800, 1);
		scoreFrame.add(scorePanel);
		scoreFrame.setSize(500, 200);
		scoreFrame.setVisible(true);
		scoreFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocation(100, 1);
		if (level == "easy") {
			
		}

	}
	public static void setStage(){

		int randMax=0;
		int threshold=0;
		if(lev.equals("easy")){
			randMax=10;
			threshold=5;
		}
		if(lev.equals("medium")){
			randMax=5;
			threshold=3;
		}
		if(lev.equals("hard")){
			randMax=111;
			threshold=109;
		}
		for(int k = 0;k<buttons.length;k++){
			int j=gen.nextInt(randMax);
			if(j>threshold){
				buttons[k].green();
				
			}
			if(j<=threshold){
				buttons[k].red();
			}	
		}	
		boolean lit=false;
		for(int a=0;a<buttons.length;a++){
			if(buttons[a].getState()&& buttons[a].isEnabled()){
				lit=true;
			}
		}if(lit==false){
			setStage();
		}
	}
	
	public static boolean timekeep(){
		boolean done=true;
		for(int k = 0;k<buttons.length;k++){
			if(buttons[k].getState()==true){
				done=false;
			}
		}
	return done;
	}
	public void endGame(){
		dispose();
	}
public static void UpdateScore(boolean j){
if(j){
	count += 5;
	scorekeep.setText("Score: "+count);
}
else{
	count -= 2;
	if(count<0){
		count=0;
	}
	scorekeep.setText("Score: "+count);
}
}
	public boolean isfinished() {

		if(done==true){
			return true;
		}
		else{
		return false;
	}
	
	}

}
