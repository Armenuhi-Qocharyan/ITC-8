import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JavaTestSwing {
    
    public static void main(String[] args){
        Runnable doSwingLater = new Runnable(){
            
            @Override
            public void run() {
                jFrameWindow = new JFrameWin();
                jFrameWindow.setVisible(true);
            }
        };
        
        SwingUtilities.invokeLater(doSwingLater);
        
    }

    static JFrameWin jFrameWindow;
    
    public static class MyComponent extends JComponent{

        @Override
        protected void paintComponent(Graphics g) {
                
                String[] figures = new String[8];
		figures[0] = "./images/rook.png";
                figures[1] = "./images/horse.png";
                figures[2] = "./images/bishop.png";
                figures[3] = "./images/king.png";
                figures[4] = "./images/queen.png";
                figures[5] = "./images/bishop.png";  
                figures[6] = "./images/horse.png";
                figures[7] = "./images/rook.png";
		
                showMainFigures(figures, g, 0);
                showPowns( "./images/pown.png", g, 1);

		showMainFigures(figures, g, 7);
                showPowns( "./images/pown.png", g, 6);

        }
        private void showMainFigures(String[] figures, Graphics g, int lineNumber) {
   		try {
			for (int i = 0; i < 800; i += 100) {  
		             
		        	Image image = ImageIO.read(this.getClass().getResource(figures[i / 100]));
		        	int scale = 1;
		 	 	int w = image.getWidth(null);
		        	int h = image.getHeight(null);
			    	g.drawImage(image, i, lineNumber * 100, 90, 90, null);
			}
		} catch (IOException ex) {
                	Logger.getLogger(JavaTestSwing.class.getName()).log(Level.SEVERE, null, ex);
            	}
        }

	private void showPowns(String imagePath, Graphics g, int lineNumber) {
   		try {
			for (int i = 0; i < 800; i += 100) {  
		             
		        	Image image = ImageIO.read(this.getClass().getResource(imagePath));
		        	int scale = 1;
		 	 	int w = image.getWidth(null);
		        	int h = image.getHeight(null);
			    	g.drawImage(image, i, lineNumber * 100, 90, 90, null);
			}
		} catch (IOException ex) {
                	Logger.getLogger(JavaTestSwing.class.getName()).log(Level.SEVERE, null, ex);
            	}
        }

    }
    
    public static class JFrameWin extends JFrame{
        public JFrameWin(){
            this.setTitle("Chess game ITC");
            this.setSize(800, 800);
            /*try {
                this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("board.jpg"))))); 
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    MyComponent myComponent = new MyComponent();
            this.add(myComponent);
        }
    }
}

