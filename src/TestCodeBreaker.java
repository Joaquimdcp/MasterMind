import java.util.*;

public class TestCodeBreaker{
    /**
     *
     *  Methods and atributes for Player when he/she is using as Code Breaker
     *  we allow to play with the keyboard or using IA
     *
     */
    private ArrayList<Integer> play;
    private int round = 0;
    private ArrayList<ArrayList<Integer>> population = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> combination = new ArrayList<>();
    ArrayList<Integer> resp_ini;


    /**
     * Create all possible combinations of guess in our game. We use
     * integers instead instances of Guess for made it more easy, and more efficient
     * using immersion technique recursive.
     */
    public static ArrayList<ArrayList<Integer>> permutations() {
        int[] colors = { 0, 0, 0, 0 };
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        inmersion(colors, 0, result);
        return result;
    }

    /**
     * Inmersion function for create all the population
     */
    static void inmersion(int[] num, int ini, ArrayList<ArrayList<Integer>> result) {
        if (ini >= num.length)
            result.add(convertArrayToList(num));
        else {
            for (int i = 0; i < 6; i++) {
                num[ini] = i;
                inmersion(num, ini + 1, result);
            }
        }
    }

    /**
     * Convert a simple array of integers to arraylist
     */
    private static ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++)
            combination.add(num[h]);
        return combination;
    }

    /**
     * Check the guess played by user and return a response with the verdict.
     */
    private static ArrayList<Integer> check_play(ArrayList<Integer> code, ArrayList<Integer> breaker) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        //First colored guess
        boolean[] ocuped = { false, false, false, false };
        for (int i = 0; i < 4; i++) {
            if (code.get(i) == breaker.get(i)) {
                result.add(-1);
                ocuped[i] = true;
            }
        }

        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (!ocuped[j] && !ocuped[k] && j != k && code.get(j) == breaker.get(k))
                    result.add(-2);
            }
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> purgue_population(ArrayList<Integer> play, ArrayList<Integer> resp_ini) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> p : population) {
            if (resp_ini.equals(check_play(play, p))) {
                result.add(p);
            }
        }
        return result;
    }

    private ArrayList<Integer> get_best() {
        ArrayList<Integer> k = new ArrayList<>();
        int score = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> p : population) {
            combination.clear();
            List<Integer> puntuation = new ArrayList<Integer>();
            for (ArrayList<Integer> p2 : population) {
                k = check_play(p, p2);
                //System.out.println(k);
                if (!combination.contains(k)) {
                    combination.add(k);
                    puntuation.add(1);
                } else {
                    int ind = combination.indexOf(k);
                    puntuation.set(ind, puntuation.get(ind) + 1);
                }
            }

            if (score < Collections.min(puntuation)) {
                score = Collections.min(puntuation);
                result = p;
            }
        }
        return result;
    }

    private void generate_combinations() {
        ArrayList<Integer> i = new ArrayList<Integer>(Arrays.asList(-1));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList());
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1, -1));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-2));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1, -2));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1, -1, -2));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1, -2, -2, -2));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1, -1, -2, -2));
        combination.add(i);
    }

    public ArrayList<StubGuessToken> play(ArrayList<StubGuessToken> answer) {
        ArrayList<Integer> int_answer = new ArrayList<Integer>();
        for(StubGuessToken a: answer){
            int_answer.add(a.getNumColour());
        }

        if (round == 0) {
            play = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
            round++;
        } else {
            resp_ini = check_play(int_answer, play);
            population = purgue_population(play, resp_ini);
            play = get_best();
        }
        ArrayList<StubGuessToken> result = new ArrayList<>();
        for(int i: play){
            StubGuessToken t = new StubGuessToken(i);
            result.add(t);
        }
        return result;
    }

    public TestCodeBreaker() {
        population = permutations();
        generate_combinations();
        play = new ArrayList<Integer>(Arrays.asList(2, 2, 1, 1));
    }
}
