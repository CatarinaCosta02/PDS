package e3;

public class Main {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImplementation();
        User user1 = new UserImplementation(mediator, "U1");
        User user2 = new UserImplementation(mediator, "U2");
        User user3 = new UserImplementation(mediator, "U3");
        User user4 = new UserImplementation(mediator, "U4");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        user1.send("Example message");
        user2.send("Example message 2");
        user3.send("Example message 3");
        user4.send("Example message 4");
    }
    
}
