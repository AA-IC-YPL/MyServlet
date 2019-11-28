import java.io.Serializable;

public class Patient implements Serializable {
    private static int nextId=1; // A class-variable
    protected int id;
    protected String name;
    protected String phoneNumber;
    public Patient(String name){
        this.name=name;
        id=nextId++;
    }
    public void addNumber(String number){
        this.phoneNumber=number;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public String getPhoneNumber(){return phoneNumber;}
}
