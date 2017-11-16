import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Ranking {
    Map<String, Integer> rankingMap;
    int mininumScore;

    public Ranking() {
        this.rankingMap = new HashMap<String, Integer>(10);
        this.mininumScore = 0;
    }

    private void setMin() {
        this.mininumScore = Collections.min(rankingMap.values());
    }

    public void updateRanking(String username, int score) {
        if (rankingMap.size() < 20) {
            rankingMap.put(username, score);            
        } else {
            this.setMin();
            if (this.mininumScore < score) {
                rankingMap.put(username, score);
            }
        }
    }

    public Map<String, Integer> getRanking() {
        return this.rankingMap;
    }
}