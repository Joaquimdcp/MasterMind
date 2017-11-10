import java.util.*;

public class CodeBreaker {
    private ArrayList<ArrayList<Integer>> population = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> combination = new ArrayList<>();


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

    private static ArrayList<Integer> check_play(ArrayList<Integer> code, ArrayList<Integer> breaker){

        ArrayList<Integer> result = new ArrayList<Integer>();
        //First colored guess
        boolean[] ocuped = {false,false,false,false};
        for(int i=0; i<4; i++){
            if(code.get(i) == breaker.get(i)) {
                result.add(-1);
                ocuped[i] = true;
            }
        }

        for(int j=0; j<4; j++){
            for(int k = 0; k<4; k++){
                if(!ocuped[j] && !ocuped[k] && j!=k && code.get(j) == breaker.get(k)) result.add(-2);
            }
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> purgue_population(ArrayList<Integer> play, ArrayList<Integer> resp_ini) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(ArrayList<Integer> p: population){
            if(resp_ini.equals(check_play(play,p))) {
                result.add(p);
            }
        }
        return result;
    }

    private ArrayList<Integer> get_best(){
        ArrayList<Integer> k = new ArrayList<>();
        int score = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(ArrayList<Integer> p: population){
            combination.clear();
            List<Integer> puntuation = new ArrayList<Integer>();
            for(ArrayList<Integer> p2: population){
                k = check_play(p,p2);
                //System.out.println(k);
                if(!combination.contains(k)){
                    combination.add(k);
                    puntuation.add(1);
                }
                else {
                    int ind = combination.indexOf(k);
                    puntuation.set(ind, puntuation.get(ind)+1);
                }
            }

            if(score < Collections.min(puntuation)){
                score = Collections.min(puntuation);
                result = p;
            }
        }
        return result;
    }
    private  void generate_combinations(){
        ArrayList<Integer> i = new ArrayList<Integer>(Arrays.asList(-1));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList());
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1,-1));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-2));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1,-2));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1,-1,-2));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1,-2,-2,-2));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1,-1,-1,-1));
        combination.add(i);
        i = new ArrayList<Integer>(Arrays.asList(-1,-1,-2,-2));
        combination.add(i);
    }

    public CodeBreaker(){
        population = permutations();
        generate_combinations();
        ArrayList<Integer> code = new ArrayList<Integer>(Arrays.asList(3, 3, 3,4));
        ArrayList<Integer> goal = new ArrayList<Integer>();
        goal.add(-1);
        goal.add(-1);
        goal.add(-1);
        goal.add(-1);

        ArrayList<Integer> play = new ArrayList<Integer>(Arrays.asList(2, 2, 1, 1));

        ArrayList<Integer> resp_ini = check_play(code,play);
        System.out.println(goal);
        int i = 0;
        while(!goal.equals(resp_ini)) {
            ++i;
            population = purgue_population(play, resp_ini);
            System.out.println(population.size());
            play = get_best();
            System.out.println(play);
            resp_ini = check_play(code,play);
            System.out.println(resp_ini);
        }
    }


    public CodeBreaker(int ncolors){

    }

}
