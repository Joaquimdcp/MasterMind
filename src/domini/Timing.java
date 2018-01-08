package domini;

public class Timing {
    /**
     *  Manage the timming of the game
     */
    long startTime;
    long savedTime;

    // Constructor
    public Timing() {
        this.savedTime = 0;
        this.startTime = System.currentTimeMillis() / 1000L;
    }


    //GETTERS
    public long time() {
        return System.currentTimeMillis()-this.startTime+savedTime;
    }

    public void set_saved_time(long savedTime) {
        this.savedTime = savedTime;
    }

}
