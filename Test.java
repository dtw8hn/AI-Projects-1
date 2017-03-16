package sti;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JTextField;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
//Quentin Sexy Bootyliscious Moore

public class Test {
	public String level;
	private JFrame frame;
	private int timer=600;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblBuzzBuzz = new JLabel("Buzz Buzz");
		lblBuzzBuzz.setFont(new Font("LiHei Pro", Font.BOLD, 20));
		lblBuzzBuzz.setBounds(174, 6, 127, 16);
		frame.getContentPane().add(lblBuzzBuzz);
		
		JButton btnMarathon = new JButton("Marathon");
		btnMarathon.setBounds(258, 147, 151, 68);
		frame.getContentPane().add(btnMarathon);
		btnMarathon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = "Marathon";
				frame.setLocation(800, 350);

				Game test = null;
				try {
					test = new Game(level);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					test.start();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						}
		});
				
		JButton btnMedium = new JButton("Medium");
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level="medium";

				Game test = null;
				frame.setLocation(800, 350);
				try {
					test = new Game(level);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					test.start();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

			}
		});
		btnMedium.setBounds(258, 57, 151, 68);
		frame.getContentPane().add(btnMedium);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(37, 147, 151, 68);
		frame.getContentPane().add(btnHard);
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level="hard";
				frame.setLocation(800, 350);

				Game test = null;
				try {
					test = new Game(level);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					test.start();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(37, 55, 151, 68);
		frame.getContentPane().add(btnEasy);
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level="easy";
				frame.setLocation(800, 350);

				Game test = null;
				try {
					test = new Game(level);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					test.start();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
	}
	
}

