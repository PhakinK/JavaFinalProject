package com.github.phakink.panel;

import com.github.phakink.Core;
import com.github.phakink.models.Logger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PathDefinePanel extends JFrame {

	public PathDefinePanel() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 210);
		setTitle("Specify path");
		setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel upperBar = new JPanel();
		upperBar.setBounds(0, 0, 284, 10);
		upperBar.setBackground(Color.BLACK);
		contentPane.add(upperBar);

		JPanel lowerBar = new JPanel();
		lowerBar.setBounds(0, 161, 284, 10);
		lowerBar.setBackground(Color.BLACK);
		contentPane.add(lowerBar);

		JPanel rightBar = new JPanel();
		rightBar.setBounds(274, 0, 10, 171);
		rightBar.setBackground(Color.BLACK);
		contentPane.add(rightBar);

		JPanel leftBar = new JPanel();
		leftBar.setBounds(0, 0, 10, 171);
		leftBar.setBackground(Color.BLACK);
		contentPane.add(leftBar);

		JLabel endingLabel = new JLabel("Path?");
		endingLabel.setBounds(62, 21, 165, 59);
		endingLabel.setFont(new Font("Snap ITC", Font.PLAIN, 45));
		contentPane.add(endingLabel);

		JButton confirmButton = new JButton("Done!");
		confirmButton.setBounds(90, 119, 97, 31);
		confirmButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(confirmButton);

		JTextField pathTextField = new JTextField();
		pathTextField.setBounds(20, 88, 244, 20);
		contentPane.add(pathTextField);
		pathTextField.setColumns(10);
		pathTextField.setText("Don't end with any extension!");

		confirmButton.addActionListener(e -> {

			if (pathTextField.getText().lastIndexOf(".") != -1) {
				JOptionPane.showMessageDialog(null ,
						"Please don't specific to any file.",
						"Error!",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!new File(pathTextField.getText()).exists()) {
				JOptionPane.showMessageDialog(null ,
						"Specify path doesn't exist!",
						"Error!",
						JOptionPane.ERROR_MESSAGE);

				return;
			}

			try {

				File file = new File(pathTextField.getText() + "\\result.log");

				if (!file.exists())
					file.createNewFile();

				Logger.getInstance().writeData(file.getAbsolutePath());

				Core.getCache().setPoint(0);
				ModeSelectionPanel modePanel = new ModeSelectionPanel();
				modePanel.setVisible(true);
				modePanel.setLocation(this.getX(), this.getY());
				this.dispose();

			} catch (RuntimeException | IOException ex) {
				ex.printStackTrace();
			}

		});
	}
}
