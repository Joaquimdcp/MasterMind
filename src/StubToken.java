public class StubToken {
    protected int colour;

    public StubToken() {
        /**
         * Constructor: Public constructor method for token with default params
         */
        this.colour = 0;
    }

    public StubToken(int colour) {
        /**
         * Constructor: Public constructor method for token with custom params
         */
        this.colour = colour;
    }

    public boolean equalsToken(Token a) {
        return true;
    }

    //Getters
    public int getNumColour() {
        return colour;
    }
}
