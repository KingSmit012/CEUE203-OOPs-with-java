public class Thermostat {

    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

    Thermostat(String location, int startTemp) {
        this.location = location;

        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }

        activeCount++;
    }

    Thermostat(String location) {
        this(location, 22);
    }

    public void raise() {
        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (30)\n");
        }
    }
    
    public void lower() {
        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (16)\n");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public static int getActiveCount() {
        return activeCount;
    }

    public static void main(String[] args) {

        Thermostat T1 = new Thermostat("Chonga", 20);
        Thermostat T2 = new Thermostat("Anand", 29);

        for (int i = 0; i < 10; i++) {
            T1.raise();
            System.out.println("Temperature: " + T1.getTemperature());
        }
        for (int i = 0; i < 20; i++) {
            T2.lower();
            System.out.println("Temperature: " + T2.getTemperature());
        }
        System.out.println("\nActive thermostats: " + Thermostat.getActiveCount());
    }
}
