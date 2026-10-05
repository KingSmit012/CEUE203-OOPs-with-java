class Seats{
    int seatsLeft = 5;

    void book(){
        if(seatsLeft > 0){
            seatsLeft --;
            System.out.println("Seat is Booked...!");
        }
    }
}

public class SeatBooking{
    public static void main(String[] args) throws InterruptedException{
        Seats seats = new Seats();

        Thread[] threads = new Thread[10];

        for(int i = 0 ; i< 10 ; i++){
            threads[i] = new Thread(new Runnable() {
                public void run(){
                    seats.book();
                }
            });

            threads[i].start();
        }

        for(int i = 0 ; i < 10 ; i++){
            threads[i].join();
        }

        System.out.println("Seats left: " + seats.seatsLeft);
    }
}