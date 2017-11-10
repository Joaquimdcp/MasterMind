import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    private ArrayList<ArrayList<Integer>> population = new ArrayList<ArrayList<Integer>>();


    public static ArrayList<ArrayList<Integer>> permutations() {
        int[] colors = {0,0,0,0};
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        inmersion(colors, 0, result);
        return result;
    }

    static void inmersion(int[] num, int ini, ArrayList<ArrayList<Integer>> result) {
        if (ini >= num.length)  result.add(convertArrayToList(num));
        else {
            for (int i = 0; i < 6; i++) {
                num[ini] = i;
                inmersion(num, ini + 1, result);
            }
        }
    }

    private static ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++)  combination.add(num[h]);
        return combination;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to MasterMind!");
    }
}
