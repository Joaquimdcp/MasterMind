import java.util.Scanner;

public class TimingDriver {
    private static void driver_constructor(){
        System.out.println("Creating instance");
        Timing t = new Timing();
        System.out.println("Instance created");
    }

    private static void driver_time(){
        System.out.println("Creating instance");
        Timing t = new Timing();
        System.out.println("The result of the time is (unix format): " + t.time());
    }

    private static void driver_set_saved_time(){
        System.out.println("Creating instance");
        Timing t = new Timing();
        System.out.println("The new saved time is (unix format): " + t.set_saved_time());
    }
    public static void main(String[] args){
        System.out.println("Timing Driver");
        System.out.println("Timing Driver");
        System.out.println("1: Constructor");
        System.out.println("2: time()");
        System.out.println("3: set_saved_time()");
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()){
            case 1:
                driver_constructor();
            case 2:
                driver_time();
            case 3:
                driver_set_saved_time();
        }

    }
}
