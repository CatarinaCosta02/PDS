package e1;

import java.util.Date;

public class TeamMember extends Decorator {
    public TeamMember(EmpInterface interf) {
         super(interf);


    
    }
    
    @Override
   public void start(Date d) {
       super.start(d);
   }

   @Override
   public void terminate(Date d) {
       super.terminate(d);
   }

   @Override
   public void work() {
       super.work();
       colaborate();
   }
   
   public void colaborate() {
       System.out.println("I colaborate in things around here!");
   }
    

    
}