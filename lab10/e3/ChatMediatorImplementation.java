package e3;

import java.util.*;

public class ChatMediatorImplementation implements ChatMediator {
	private List<User> users;
	public ChatMediatorImplementation(){
		this.users=new ArrayList<>();
	}
	@Override
	public void addUser(User user){
		this.users.add(user);
	}
	@Override
	public void sendMessage(String msg, User user) {
		for(User u : this.users){
			// A mensagem não deve ser recebida pelo próprio utilizador que a enviou
			if (u != user){
				u.receive(msg);
			}
		}
	}
}
