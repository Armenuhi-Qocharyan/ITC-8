import java.util.List;
import java.util.ArrayList;

public class Chat {
	private List<User> users = new ArrayList<>();	
	private List<String> messages = new ArrayList<>();
	private String data;

	public String getMessages() {
		return data;
	}


	public void sendMessage(String message) {
		//messages.add(message);
		this.data = message;
		newMessage();
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void delUser(User user) {
		users.remove(user);
	}

	public void newMessage() {
		for(User user : users) {
			user.update();
		}
	}
}
