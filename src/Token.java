public class Token {
    /**This class is used to represent a token. Tokens are composed of colour and position**/
    private String colour;
    private int position;

    public Token(){
        /**
         * Constructor: Public constructor method for token with default params
         */
        this.colour = "red";
        this.position = 0;
    }
    public Token(String colour, int position){
        /**
         * Constructor: Public constructor method for token with custom params
         */
        this.colour = colour;
        this.position = position;
    }
    //Getters
    public String getColour(){return colour}
    public int getPosition(){return position}

}
