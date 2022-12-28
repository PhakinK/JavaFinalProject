package com.github.phakink.models;

import com.github.phakink.Core;
import com.github.phakink.registry.FlagEasyRegister;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.Objects;

public abstract class GuessingPanel extends JFrame {

	protected static final JFrame END_OF_GAME = null;

	private JPanel contentPane;
	private final JButton choice1;
	private final JButton choice2;
	private final JButton choice3;
	private final JButton choice4;

	public GuessingPanel(String c1 , String c2 , String c3 , String c4) {

		ButtonPropertities propertities = new ButtonPropertities(182,127);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		choice1 = new JButton(c1);
		choice1.setBounds(0, 229, propertities.getWidth(), propertities.getHeight());
		contentPane.add(choice1);

		choice2 = new JButton(c2);
		choice2.setBounds(182, 229, propertities.getWidth(), propertities.getHeight());
		contentPane.add(choice2);

		choice3 = new JButton(c3);
		choice3.setBounds(0, 354, propertities.getWidth(), propertities.getHeight());
		contentPane.add(choice3);

		choice4 = new JButton(c4);
		choice4.setBounds(182, 354, propertities.getWidth(), propertities.getHeight());
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

	public void correctAnswer() {
		this.setVisible(false);

		try {

			FlagEasyRegister.getInstance().setState(this , true);
			JFrame nextPage = this.nextChoice();
			nextPage.setVisible(true);

			nextPage.setLocation(this.getX() , this.getY());
			Core.getCache().increasePoint(this.increment());
			nextPage.setTitle("Country (Easy) | Score: " + Core.getCache().getPoint());

		} catch (NullPointerException ex) {

			System.err.println("You didn't setup the nextChoice() method.");
		}


	}

	public abstract int increment();

	public abstract JFrame nextChoice();

	private static final class EndOfGameFrame extends JFrame {

		private EndOfGameFrame() {

			FlagEasyRegister.getInstance().clearState();
			this.setVisible(false);

		}
	}
}
