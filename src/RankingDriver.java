import java.util.Scanner;

public class RankingDriver {
    private static void testConstructor(int size) {
        System.out.println("Creating default instance");
        Ranking defaultRanking = new Ranking();
        System.out.println("Default instance created");
        System.out.println("Creating basic instance");
        Ranking ranking = new Ranking(size);
        System.out.println("Basic instance created");
    }

    private static void testUpdateRanking() {
        Ranking testRanking = new Ranking();
        Scanner r = new Scanner(System.in);
        String choice;
        String username;
        int score;
        boolean exit = false;
        while(!exit) {
            System.out.println("'N' to add a new entry, any other key to exit this test");
            choice = r.nextLine();
            if (choice.equals("N")) {
                System.out.println("[+] Please enter the username");
                username = r.nextLine();
                System.out.println("[-] Please enter the score");
                score = r.nextInt();
                System.out.println("Number of entries before updating the ranking: " + testRanking.getCurrentSize());
                System.out.println("Current lowest score: " + testRanking.getMin());
                testRanking.updateRanking(username, score);
                System.out.println("New number of entries: " + testRanking.getCurrentSize());
                System.out.println("New lowest score: " + testRanking.getMin());
            } else {
                exit = true;
            }
        }
        r.close();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String choice;
        boolean quit = false;
        String exitChoice = "";
        System.out.println("Welcome to the Ranking class");
        while(!quit) {
            System.out.println("C: Constructor method");
            System.out.println("U: Update ranking (maximum of 10 entries) and test the getMin and getCurrentSize methods");
            System.out.println("Press any other key to exit");
            choice = s.nextLine();
            switch (choice) {
                case "C":
                    int size = s.nextInt();
                    testConstructor(size);
                    break;
                case "U":
                    testUpdateRanking();
                    break;
                default:
                    quit = true;
                    break;
            }
            System.out.println("'X' to exit, press any other key to continue testing");
            exitChoice = s.nextLine();
            if (exitChoice.equals("X")) {
                quit = true;
            }
        }
        s.close();
    }
}