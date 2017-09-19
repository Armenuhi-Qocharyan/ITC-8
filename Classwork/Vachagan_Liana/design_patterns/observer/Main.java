public class Main {
	public static void main(String[] args) {
		Chat chat = new Chat();

		Artur artur = new Artur(chat);
		Poxos poxos = new Poxos(chat);
		artur.sendMessage("Hello!!");
		poxos.sendMessage("Hi!!");
	}
}
