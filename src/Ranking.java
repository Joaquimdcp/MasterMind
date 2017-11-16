import java.util.*;


public class Ranking {
    LinkedHashMap<String, Integer> rankingMap;
    int mininumScore;
    int rankingSize;

    public Ranking() {
        this.rankingSize = 3;
        this.rankingMap = new LinkedHashMap<String, Integer>(this.rankingSize);
        this.mininumScore = 0;
    }

    public Ranking(int size) {
        this.rankingSize = size;
        this.rankingMap = new LinkedHashMap<String, Integer>(this.rankingSize);
        this.mininumScore = 0;
    }

    /* Sets the minimum score by searching for it in the values of the map */
    private void setMin() {
        this.mininumScore = Collections.min(rankingMap.values());
    }
    
    private LinkedHashMap<String, Integer> sortHashMapByValues(LinkedHashMap<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.reverse(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    private LinkedHashMap<String, Integer> sortRanking() {
        this.rankingMap = sortHashMapByValues(this.rankingMap);
        return this.rankingMap;
    }

    /* Updates the ranking with the new score for the user */
    public void updateRanking(String username, int score) {
        if (rankingMap.size() < this.rankingSize) {
            rankingMap.put(username, score);            
        } else {
            this.setMin();
            /* If the score is greater than the current minimum score, update the ranking */
            if (this.mininumScore < score) {
                /* Search for the user with the minimum score and remove it */
                for (String user : rankingMap.keySet()) {
                    /* It will only remove the user if the value is minimumScore,
                        then the loop will end */
                    if (rankingMap.remove(user, this.mininumScore)) {
                        break;
                    }
                }
                /* Add the new user to the map */
                rankingMap.put(username, score);
                /* It's necessary to set the minimum score again in case
                    the new score is the lowest */
                this.setMin();
            }
        }
    }

    public LinkedHashMap<String, Integer> getRanking() {
        return this.sortRanking();
    }

    public void printRanking() {
        for (Map.Entry<String, Integer> entry : this.rankingMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }

    public static void main(String[] args) {
        Ranking r = new Ranking();
        r.updateRanking("Amanda", 25);
        r.updateRanking("Jazz", 300);
        r.updateRanking("Matias", 100);
        r.updateRanking("Quim", 50);
        r.updateRanking("Maria", 200);
        r.sortRanking();
        r.printRanking();
    }
}