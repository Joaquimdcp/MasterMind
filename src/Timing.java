public class Timing {
    long startTime;
    long savedTime;


    public Timing(int startTime, int savedTime){
        this.savedTime = savedTime;
        this.startTime = startTime;
    }

    public Timing(){

    }


    //GETTERS
    public long get_start_time(){
        return startTime;
    }

    public long get_saved_time(){
        return savedTime;
    }

    //SETTERS
    public long set_start_time(){
        this.startTime = System.currentTimeMillis() / 1000L;
        return startTime;
    }

    public long set_save_time(){
        this.startTime = System.currentTimeMillis() / 1000L;
        return startTime;
    }

}
