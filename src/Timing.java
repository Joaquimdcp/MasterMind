public class Timing {
    /**
     *  Manage the timming of the game
     */
    long startTime;
    long savedTime;

    // Constructor
    public Timing() {
        this.savedTime = -1;
        this.startTime = System.currentTimeMillis() / 1000L;
    }


    //GETTERS
    public long time() {
        return System.currentTimeMillis()-this.startTime+savedTime;
    }

    public long set_saved_time() {
        this.savedTime = System.currentTimeMillis()-this.startTime+savedTime;
        this.startTime = 0;
        return this.savedTime;
    }

}
