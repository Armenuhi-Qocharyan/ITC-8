import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ChessBoard extends JFrame {
	public static final int squareCount = 64;
	JButton clickedButton;
	String[] figures = new String[8];
	Color blackColor = Color.BLUE;
	Color whiteColor = Color.WHITE;
	
	public ChessBoard(String title) {
		figures[0] = "./images/rook.png";
        figures[1] = "./images/horse.png";
        figures[2] = "./images/bishop.png";
        figures[3] = "./images/king.png";
        figures[4] = "./images/queen.png";
        figures[5] = "./images/bishop.png";  
        figures[6] = "./images/horse.png";
        figures[7] = "./images/rook.png";
		
		JButton[][] chessButtons = new JButton[8][8];
		init(chessButtons);
		initMain(chessButtons,figures,0);
		initPowns(chessButtons,"./images/pown.png",1);
		initPowns(chessButtons,"./images/pown.png",6);
		initMain(chessButtons,figures,7);
		
		this.setTitle(title); 
		this.setLayout(new GridLayout(8, 8)); // GridLayout will arrange elements in Grid Manager 8 X 8
		this.setSize(800, 800); // Size of the chess board
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    public void move(JButton first, JButton second) {

	}

	private void initMain(JButton[][] chessButtons, String[] figures, int lineNumber) {
		try {
			String[] names = {"rook","horse","bishop","king","queen","bishop","horse","rook"};
			for (int i = 0; i < 8; i++) {

				Image image = ImageIO.read(this.getClass().getResource(figures[i]));

				image = image.getScaledInstance(40 , 40, java.awt.Image.SCALE_SMOOTH);
				chessButtons[lineNumber][i].setIcon(new ImageIcon(image));
				chessButtons[lineNumber][i].setName(names[i]);
				
			}
		} catch (IOException ex) {

		}
	}

	private void initPowns(JButton[][] chessButtons, String imagePath, int lineNumber) {
		try {
			for (int i = 0; i < 8; i++) {

				Image image = ImageIO.read(this.getClass().getResource(imagePath));

				image = image.getScaledInstance(40 , 40, java.awt.Image.SCALE_SMOOTH);
				chessButtons[lineNumber][i].setIcon(new ImageIcon(image));
				chessButtons[lineNumber][i].setName("pown");
			}
		} catch (IOException ex) {

		}
	}

	private void init(JButton[][] chessButtons) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
		
				chessButtons[i][j] = new JButton();
				if ( (i + j) % 2 == 0) { 
					chessButtons[i][j].setBackground(blackColor);
				} else {
					chessButtons[i][j].setBackground(whiteColor);
				}
				add(chessButtons[i][j]); 
				chessButtons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (clickedButton == null) {
							clickedButton = (JButton)e.getSource();
							System.out.println(clickedButton.getName());
							if (clickedButton.getIcon() == null) {
								clickedButton = null;
							}
						} else {
							int x = ((JButton)e.getSource()).getX();
							int y = ((JButton)e.getSource()).getY();
							try {
								Image img = ImageIO.read(getClass().getResource("images/pown.png"));
								img = img.getScaledInstance(40 , 40, java.awt.Image.SCALE_SMOOTH);
								chessButtons[y / 100][x / 100].setIcon(clickedButton.getIcon());
							} catch (Exception ex) {
								System.out.println(ex);
							}
							clickedButton.setIcon(null);
							clickedButton = null;
						}
					}
				});
			}
		}
		 
	}

	public static void main(String[] args) {
		String title = "My Chess Board";
		ChessBoard chessBoard = new ChessBoard(title); // Creating the instance of chess board
	}
}
