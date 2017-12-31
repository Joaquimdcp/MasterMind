import java.util.*;


public class Ranking {
    private LinkedHashMap<String, Integer> rankingMap;
    private int minimumScore;
    private int rankingSize;

    /* Creates a new ranking with 10 entries */
    public Ranking() {
        this.rankingSize = 10;
        this.rankingMap = new LinkedHashMap<String, Integer>();
        this.minimumScore = 0;
    }

    /* Creates a new ranking with number of entries equal to size */
    public Ranking(int size) {
        this.rankingSize = size;
        this.rankingMap = new LinkedHashMap<String, Integer>();
        this.minimumScore = 0;
    }

    /* Sets the minimum score by searching for it in the values of the map */
    private void setMin() {
        this.minimumScore = Collections.min(rankingMap.values());
    }

    /* Returns the lowest score or 0 if the ranking has empty entries */
    public int getMin() {
        return this.minimumScore;
    }

    /* Returns the current amount of entries in the ranking */
    public int getCurrentSize() {
        return this.rankingMap.size();
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

    /* Sets the ranking with a sorted copy by score in descending order of itself */
    private LinkedHashMap<String, Integer> sortRanking() {
        this.rankingMap = sortHashMapByValues(this.rankingMap);
        return this.rankingMap;
    }

    /* Updates the ranking with the new entry, if it belongs in */
    public void updateRanking(String username, int score) {
        if (rankingMap.size() < this.rankingSize) {
            rankingMap.put(username, score);            
        } else {
            /* If the score is greater than the current minimum score, update the ranking */
            if (this.minimumScore < score) {
                /* Search for the user with the minimum score and remove it */
                for (String user : rankingMap.keySet()) {
                    /* It will only remove the user if the value is minimumScore,
                        then the loop will end */
                    if (rankingMap.remove(user, this.minimumScore)) {
                        break;
                    }
                }
                /* Add the new user to the map */
                rankingMap.put(username, score);
                /* It's necessary to set the minimum score again in case
                    the new score is the lowest */
            }
        }
        this.setMin();
    }

    /* Returns the ranking sorted by score in descending order */
    public LinkedHashMap<String, Integer> getRanking() {
        return this.sortRanking();
    }
}