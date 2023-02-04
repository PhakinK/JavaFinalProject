package com.github.phakink.panel;

import com.github.phakink.Core;
import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagRegister;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ModeSelectionPanel extends JFrame {

	private JPanel contentPane;

	public ModeSelectionPanel() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 520);

		setTitle("Guessing game | Mode selection");

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JButton easy = new JButton("EASY");
		easy.setFont(new Font("Snap ITC", Font.PLAIN, 60));
		easy.setBackground(new Color(255, 255, 255));
		easy.setBounds(30, 42, 300, 100);
		contentPane.add(easy);

		JButton medium = new JButton("MEDIUM");
		medium.setFont(new Font("Snap ITC", Font.PLAIN, 50));
		medium.setBackground(new Color(255, 255, 255));
		medium.setBounds(30, 191, 300, 100);
		contentPane.add(medium);

		JButton hard = new JButton("HARD");
		hard.setFont(new Font("Snap ITC", Font.PLAIN, 60));
		hard.setBackground(new Color(255, 255, 255));
		hard.setBounds(30, 336, 300, 100);
		contentPane.add(hard);

		JPanel top = new JPanel();
		top.setBackground(new Color(0, 0, 0));
		top.setBounds(0, 0, 364, 10);
		contentPane.add(top);

		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(0, 0, 0));
		bottom.setBounds(0, 471, 364, 10);
		contentPane.add(bottom);

		JPanel left = new JPanel();
		left.setBackground(new Color(0, 0, 0));
		left.setBounds(0, 0, 10, 481);
		contentPane.add(left);

		JPanel right = new JPanel();
		right.setBackground(new Color(0, 0, 0));
		right.setBounds(354, 0, 10, 481);
		contentPane.add(right);

		easy.addActionListener(e -> {
			GuessingPanel panel = FlagRegister.getInstance().randomQuiz(Gamemode.EASY);

			panel.setTitle("Country (Easy) | Score: " + Core.getCache().getPoint());
			panel.setLocation(this.getX() , this.getY());
			FlagRegister.getInstance().show(panel);
			this.dispose();
		});

		medium.addActionListener(e -> {
			GuessingPanel panel = FlagRegister.getInstance().randomQuiz(Gamemode.MEDIUM);

			panel.setTitle("Country (Medium) | Score: " + Core.getCache().getPoint());
			panel.setLocation(this.getX() , this.getY());
			FlagRegister.getInstance().show(panel);
			this.dispose();
		});

		hard.addActionListener(e -> {
			GuessingPanel panel = FlagRegister.getInstance().randomQuiz(Gamemode.HARD);

			panel.setTitle("Country (Hard) | Score: " + Core.getCache().getPoint());
			panel.setLocation(this.getX() , this.getY());
			FlagRegister.getInstance().show(panel);
			this.dispose();
		});
	}
}
