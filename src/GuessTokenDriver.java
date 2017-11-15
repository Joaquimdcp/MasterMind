public class GuessTokenDriver {
    public static void main(String[] args) {
        GuessToken gToken = new GuessToken();
        if(gToken.getNumColour()==0)
            System.out.println("Constructor with default parameters and getter of number work fine");
        else
            System.out.println("ERROR in constructor with default parameters and getter of number");

        if(gToken.getColour().equals("Red"))
            System.out.println("Constructor with default parameters and getter of name work fine");
        else
            System.out.println("ERROR in constructor with default parameters and getter of name");

        gToken = new GuessToken(3);
        if(gToken.getNumColour()==3)
            System.out.println("Constructor with custom parameters and getter of number work fine");
        else
            System.out.println("ERROR in constructor with custom parameters and getter of number");

        if(gToken.getColour().equals("Yellow"))
            System.out.println("Constructor with custom parameters and getter of name work fine");
        else
            System.out.println("ERROR in constructor with custom parameters and getter of name");
    }
}
