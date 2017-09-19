import java.util.List;

public class Artur extends User {
	public Artur (Chat chat) {
		this.chat = chat;
		this.chat.addUser(this);
	}

	@Override
	public void update() {	
		String message = this.chat.getMessages();
		System.out.println(message);
	}

	public void sendMessage(String message) {
		this.chat.sendMessage("Artur: "+ message);
	}
}	
