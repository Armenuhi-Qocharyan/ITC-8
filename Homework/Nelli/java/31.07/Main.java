import Shape.*;
public class Main {
	public static void main(String[] args) {
		Point point = new Point();
		byte[] content = point.shape('*', 1);
		String fileName = "print.txt";
		point.drawOnFile(content, fileName);
	}
}
