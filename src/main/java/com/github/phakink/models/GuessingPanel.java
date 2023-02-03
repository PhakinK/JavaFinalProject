package com.github.phakink.models;

import com.github.phakink.Core;
import com.github.phakink.panel.ModeSelectionPanel;
import com.github.phakink.registry.FlagEasyRegister;
import com.github.phakink.registry.FlagHardRegister;
import com.github.phakink.registry.FlagMediumRegister;
import com.github.phakink.utils.Common;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public abstract class GuessingPanel extends JFrame {

	private final Gamemode gamemode;
	private final JButton choice1;
	private final JButton choice2;
	private final JButton choice3;
	private final JButton choice4;

	public GuessingPanel(Gamemode gamemode , String c1 , String c2 , String c3 , String c4) {

		this.gamemode = gamemode;

		ButtonPropertities propertities = new ButtonPropertities(182,127);

		this.setTitle("Country (Easy) | Score: " + Core.getCache().getPoint());

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 520);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		choice1 = new JButton(c1);
		choice1.setBounds(0, 229, propertities.getWidth(), propertities.getHeight());
		choice1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		choice1.setBackground(new Color(255, 255, 255));
		contentPane.add(choice1);

		choice2 = new JButton(c2);
		choice2.setBounds(182, 229, propertities.getWidth(), propertities.getHeight());
		choice2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		choice2.setBackground(new Color(255, 255, 255));

		contentPane.add(choice2);

		choice3 = new JButton(c3);
		choice3.setBounds(0, 354, propertities.getWidth(), propertities.getHeight());
		choice3.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		choice3.setBackground(new Color(255, 255, 255));
		contentPane.add(choice3);

		choice4 = new JButton(c4);
		choice4.setBounds(182, 354, propertities.getWidth(), propertities.getHeight());
		choice4.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		choice4.setBackground(new Color(255, 255, 255));
		contentPane.add(choice4);

		JLabel image = new JLabel();

		ImageIcon img = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(this.imagePath()), "Please set-up the flag picture."));
		image.setIcon(img);
		image.setBounds(0, 0, 364, 230);
		contentPane.add(image);

	}

	public final void choiceOneEvent(ActionListener event) {
		choice1.addActionListener(event);
	}

	public final void choiceTwoEvent(ActionListener event) {
		choice2.addActionListener(event);
	}

	public final void choiceThreeEvent(ActionListener event) {
		choice3.addActionListener(event);
	}

	public final void choiceFourEvent(ActionListener event) {
		choice4.addActionListener(event);
	}

	protected abstract String imagePath();

	public void onClick(boolean isCorrect) {
		this.setVisible(false);

		try {
			Common.setState(this.gamemode , this,true);
			JFrame nextPage = this.nextChoice();
			nextPage.setVisible(true);

			nextPage.setLocation(this.getX() , this.getY());

			if (isCorrect)
				Core.getCache().increasePoint(this.increment());
			else
				Core.getCache().decreasePoint(this.decreasement());

			nextPage.setTitle("Country ({mode}) | Score: ".replace("{mode}", this.gamemode.getAbbreviation()) + Core.getCache().getPoint());

		} catch (NullPointerException ex) {

			System.err.println("You didn't setup the nextChoice() method.");
		}

	}

	public abstract int increment();

	public abstract int decreasement();

	public abstract JFrame nextChoice();

	public static final class EndOfGameFrame extends JFrame {

		public EndOfGameFrame() {

			Common.clearAllModeState();

			setTitle("Result!");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 300, 300);
			JPanel contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);

			JPanel upperBar = new JPanel();
			upperBar.setBackground(Color.BLACK);
			upperBar.setBounds(0, 0, 284, 10);
			contentPane.add(upperBar);

			JPanel lowerBar = new JPanel();
			lowerBar.setBackground(Color.BLACK);
			lowerBar.setBounds(0, 251, 284, 10);
			contentPane.add(lowerBar);

			JPanel rightBar = new JPanel();
			rightBar.setBackground(Color.BLACK);
			rightBar.setBounds(0, 0, 10, 261);
			contentPane.add(rightBar);

			JPanel leftBar = new JPanel();
			leftBar.setBackground(Color.BLACK);
			leftBar.setBounds(274, 0, 10, 261);
			contentPane.add(leftBar);

			JLabel endingLabel = new JLabel("Ending!");
			endingLabel.setFont(new Font("Snap ITC", Font.PLAIN, 45));
			endingLabel.setBounds(40, 11, 219, 119);
			contentPane.add(endingLabel);

			JButton finishButton = new JButton("Finish!");
			finishButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			finishButton.setBounds(76, 193, 122, 38);
			contentPane.add(finishButton);

			JLabel resultLabel = new JLabel("You got: \t" + Core.getCache().getPoint() + " points");
			resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			resultLabel.setBounds(50, 130, 180, 20);
			contentPane.add(resultLabel);

			finishButton.addActionListener(e -> {
				Core.getCache().setPoint(0);
				ModeSelectionPanel modePanel = new ModeSelectionPanel();
				modePanel.setVisible(true);
				modePanel.setLocation(this.getX(), this.getY());
				this.dispose();
			});

		}
	}
}
