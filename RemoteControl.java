interface Switchable{
    void on();
    void off();

    default void toggle(){
        on();
    }
}

class Fan implements Switchable{
    public void on(){
        System.out.println("Fan is ON.");
    }
    public void off(){
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable{

    public void on(){
        System.out.println("Light is ON");
    }
    public void off(){
        System.out.println("Light is OFF");
    }
}

interface ScheduleChecker{
    boolean switchON(Switchable device , int hour);
}

public class RemoteControl{
    public static void main(String[] args) {
        Switchable[] devices ={
            new Fan(),
            new Light()
        };

        for(Switchable dvc : devices){
            dvc.toggle();
        }

        int currentHour = 14;

        ScheduleChecker anonymousChecker = new ScheduleChecker(){
            public boolean switchON(Switchable device , int hour){
                return (hour >=6 && hour <=22); 
            }
        };

        ScheduleChecker lamdaChecker = (device , hour) -> hour >=6 && hour <=22;

        for(Switchable dvc : devices){
            if(lamdaChecker.switchON(dvc, currentHour)){
                System.out.println("Allowed to switch on at hour " + currentHour);
                dvc.on();
            }
            else{
                System.out.println("Not allowed to switch on at hour " + currentHour);
                dvc.off();
            }
        }
    }
}
