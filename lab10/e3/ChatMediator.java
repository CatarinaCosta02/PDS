package e3;

public interface ChatMediator {
	public void sendMessage(String msg, User user);
	void addUser(User user);
}