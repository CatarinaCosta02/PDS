package EX2;

// null version of the Employee class

public class NullEmployee extends Employee{
    boolean isNull = true;
    @Override
    public String getName(){
        return "Nothing to see here";
    }
}
