package sti;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import sun.audio.*;

import java.io.InputStream;
import java.util.Random;


public class GameButtons extends JButton implements ActionListener{

	ImageIcon X, O;
	byte value = 0;
	boolean onn;
	int total;
	String gotIt="C:/Users/DeVante/Downloads/Super_Mario_Bros.wav";
	String nope="C:/Users/DeVante/Downloads/nope1.wav";

	
	public GameButtons() throws FileNotFoundException{
		X=new ImageIcon(this.getClass().getResource("../images.png"));
		O=new ImageIcon(this.getClass().getResource("../Red_Circle.png"));
		this.addActionListener(this);

	}
	public void right(){
		try {
			InputStream in = new FileInputStream(gotIt);
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
	public void green(){
		setIcon(X);
		onn=true;
	}
	public void red(){
		setIcon(O);
		onn=false;
	}
	public void wrong(){
		try {
			InputStream in = new FileInputStream(nope);
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
	
	public void actionPerformed(ActionEvent e){
		if(onn==true){
		//	right();
			for(GameButtons j: Game.buttons){
				j.setEnabled(true);
			}
			setEnabled(false);
		}
		if(onn==false){
			for(GameButtons j: Game.buttons){
				j.setEnabled(true);
			}
			wrong();
		}
		Game.UpdateScore(onn);
		Game.setStage();

	}
	
	public void nul(){
		setIcon(null);
		onn=false;
	}
	public boolean getState(){
		return onn;
		
	}
}
