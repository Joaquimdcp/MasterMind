package persistencia;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Ranking {
    private String filename = "ranking.txt";
    private Map<String, Integer> rankingMap;
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
    private void updateMin() {
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
    
    /* Sorts the map */
    private LinkedHashMap<String, Integer> sortHashMapByValues(Map<String, Integer> passedMap) {
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
    private void sortRanking() {
        this.rankingMap = sortHashMapByValues(this.rankingMap);
    }

    /* Updates the ranking with the new entry, if the score is good enough */
    public void updateRanking(String username, Integer score) {
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
            }
        }
        this.updateMin();
        this.sortRanking();
    }

    public void readRanking() {
        try (Stream<String> stream = Files.lines(Paths.get(this.filename))) {
            for (String line : stream.toArray(String[]::new)) {
                StringTokenizer rankingLine = new StringTokenizer(line, "#");
                String username = rankingLine.nextToken();
                Integer score = Integer.parseInt(rankingLine.nextToken());
                updateRanking(username, score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveRanking() {
        try {
            PrintWriter clear = new PrintWriter(this.filename);
            clear.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> entry : this.rankingMap.entrySet()) {
            String user = entry.getKey();
            Integer score = entry.getValue();
            String newScore = user + "#" + score.toString();
            try (FileWriter fw = new FileWriter(this.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                out.println(newScore);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}