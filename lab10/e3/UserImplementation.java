package e3;

public class UserImplementation extends User {
	public UserImplementation(ChatMediator med, String name) {
		super(med, name);
	}
	@Override
	public void send(String msg){
		System.out.println(this.name + ": Sending message = " + msg);
		mediator.sendMessage(msg, this);
	}
	@Override
	public void receive(String msg) {
		System.out.println(this.name + ": Message received = " + msg);
	}
}
