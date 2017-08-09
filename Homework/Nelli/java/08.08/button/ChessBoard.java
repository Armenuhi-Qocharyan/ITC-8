import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ChessBoard extends JFrame {
	public static final int squareCount = 64;
	public ChessBoard(String title) {
		Color blackColor = Color.BLUE;
		Color whiteColor = Color.WHITE;
		JButton[][] chessButtons = new JButton[8][8];
		try {
			Image image = ImageIO.read(this.getClass().getResource("images/horse.png"));

			image = image.getScaledInstance(40 , 40, java.awt.Image.SCALE_SMOOTH);
			for (int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; ++j) {
					chessButtons[i][j] = new JButton("Horse", new ImageIcon(image));
					if ( (i + j) % 2 == 0) { 
						chessButtons[i][j].setBackground(blackColor);
					} else {
						chessButtons[i][j].setBackground(whiteColor);
					}
					add(chessButtons[i][j]); 
					chessButtons[i][j].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							JOptionPane optionPane = new JOptionPane();
							JDialog dialog = optionPane.createDialog("About");
							JLabel aboutText = new JLabel("Text goes here", JLabel.CENTER);
							dialog.add(aboutText, BorderLayout.NORTH);
							dialog.setVisible(true);
							int tempX = ((JButton)e.getSource()).getX();
							int tempY = ((JButton)e.getSource()).getY();
							}
							});
				}
			}
		} catch (IOException ex) {
		}
		this.setTitle(title); 
		this.setLayout(new GridLayout(8, 8)); // GridLayout will arrange elements in Grid Manager 8 X 8
		this.setSize(800, 800); // Size of the chess board
		this.setVisible(true);
	}

	public static void main(String[] args) {
		String title = "My Chess Board";
		ChessBoard chessBoard = new ChessBoard(title); // Creating the instance of chess board
	}
}
