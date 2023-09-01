package e1;

import java.util.Date;

public class Employee implements EmpInterface{

    private Date startW,endW;
    private String name;
    

    public Employee(String name){
         this.name=name;
    }


    @Override
    public void start(Date d) {
         this.startW=d;
         
    }


    @Override
    public void terminate(Date d) {
         this.endW=d;
         
    }


    @Override
    public void work() {
         System.out.println("Worker: "+ name+" is working!");
         
    }


}