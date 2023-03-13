package com.github.phakink.panel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

/**
 * Main panel GUI
 */
public class MainPanel extends JFrame {

	public MainPanel() {

		setTitle("Guessing Game");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 520);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel image = new JLabel();

		ImageIcon img = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/Images/Game_Icon_For_Main_Menu.png")));
		image.setIcon(img);
		image.setBounds(67, 55, 227, 197);

		contentPane.add(image);

		JLabel topText = new JLabel("Guessing Game");
		topText.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		topText.setBounds(95, 21, 160, 23);
		contentPane.add(topText);

		JButton startButton = new JButton("Start");
		startButton.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		startButton.setBounds(67, 270, 227, 69);
		startButton.setBackground(new Color(255, 255, 255, 255));
		contentPane.add(startButton);

		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		exitButton.setBounds(67, 352, 227, 69);
		exitButton.setBackground(new Color(255, 255, 255));
		contentPane.add(exitButton);

		JPanel leftBar = new JPanel();
		leftBar.setBackground(new Color(0, 0, 0));
		leftBar.setBounds(0, 0, 10, 481);
		contentPane.add(leftBar);

		JPanel rightBar = new JPanel();
		rightBar.setBackground(Color.BLACK);
		rightBar.setBounds(354, 0, 10, 481);
		contentPane.add(rightBar);

		JPanel topBar = new JPanel();
		topBar.setBackground(Color.BLACK);
		topBar.setBounds(0, 0, 364, 10);
		contentPane.add(topBar);

		JPanel belowBar = new JPanel();
		belowBar.setBackground(Color.BLACK);
		belowBar.setBounds(0, 471, 364, 10);
		contentPane.add(belowBar);

		JButton infoButton = new JButton("?");
		infoButton.setForeground(new Color(0, 128, 255));
		infoButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		infoButton.setBounds(304, 420, 40, 40);
		infoButton.setBackground(new Color(255, 255, 255));
		contentPane.add(infoButton);

		JLabel developedDayText = new JLabel("Guessing game has been developing since 2022");
		developedDayText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		developedDayText.setBounds(20, 447, 235, 23);
		contentPane.add(developedDayText);

		startButton.addActionListener(e -> {

			JFrame frame = new ModeSelectionPanel();
			frame.setLocation(this.getLocation());
			frame.setVisible(true);

			this.setVisible(false);
			this.dispose(); // Prevent memory leak by release unused GUI memory.
		});

		exitButton.addActionListener(e -> {

			int confirm = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION)
				System.exit(0);

		});

		infoButton.addActionListener(e -> {

			JOptionPane.showMessageDialog(null , "This program will test you knowledge about country flag.\n All you have to do is choose the correct answer to get your best score.", "Information", JOptionPane.INFORMATION_MESSAGE);

		});
	}
}
