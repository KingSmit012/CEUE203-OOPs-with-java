abstract class Employee{

    private String name;
    private int id;

    Employee(String name ,int id){
        this.name = name;
        this.id = id;
    }

    abstract int monthlySalary();

    public String getName(){
        return name;
    }
    
    public int getID(){
        return id;
    }
}

class FullTime extends Employee{
    private int FixedSalary;

    public FullTime(String name , int id, int FixedSalary){
        super(name, id);
        this.FixedSalary = FixedSalary;
    }

    @Override
    int monthlySalary() {
        return FixedSalary;
    }
}

class PartTime extends Employee{
    private int HourRate;
    private int WorkHour;
    
    public PartTime(String name , int id , int HourRate , int WorkHour){
        super(name, id);
        this.HourRate = HourRate;
        this.WorkHour = WorkHour;
    }

    int monthlySalary(){
        return HourRate * WorkHour;
    }
}

class Intern extends Employee{
    private int Stipend;

    public Intern(String name , int id , int Stipend){
        super(name, id);
        this.Stipend = Stipend;
    }

    int monthlySalary(){
        return Stipend;
    }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        Employee [] EMP ={
            new FullTime("Alice", 101, 50000),
            new PartTime("Bob", 102, 300, 80),
            new Intern("Charlie", 103, 30000)
        };

        for(Employee E : EMP){
            System.out.println("The Salary for " + E.getName() + " (ID : " + E.getID() + ") " +" : " +E.monthlySalary());
        }
    }
}
