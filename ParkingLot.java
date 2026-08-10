public class ParkingLot {
    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap = 100;
    private final int fourCap = 100;

    private static long revenue = 0;

    public void park(String type) {
        type = type.toLowerCase();

        if (type.equals("two")){
            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Two-wheeler parked");
            } else {
                System.out.println("Full");
            }
        } 
        else if (type.equals("four")) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Four-wheeler parked");
            } else {
                System.out.println("Full");
            }
        } 
        else {
            System.out.println("Invalid vehicle type");
        }
    }

    public void leave(String type) {
        type = type.toLowerCase();

        if (type.equals("two")) {
            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two-wheeler left");
            }
        } 
        else if (type.equals("four")) {
            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four-wheeler left");
            }
        } 
        else {
            System.out.println("Invalid vehicle type");
        }
    }

    public void display() {
        System.out.println("Two-wheelers: " + twoWheelers);
        System.out.println("Four-wheelers: " + fourWheelers);
        System.out.println("Revenue: " + revenue);
    }

    public static void main(String[] args) {
        ParkingLot parking = new ParkingLot();

        parking.park("two");
        parking.park("four");
        parking.park("two");

        parking.leave("two");

        parking.park("four");
        parking.leave("four");

        parking.display();
    }
}