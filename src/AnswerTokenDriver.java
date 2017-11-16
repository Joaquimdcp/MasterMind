public class AnswerTokenDriver {
    public static void main(String[] args) {
        AnswerToken aToken = new AnswerToken();
        if(aToken.getNumColour()==0)
            System.out.println("Constructor with default parameters and getter of number work fine");
        else
            System.out.println("ERROR in constructor with default parameters and getter of number");

        if(aToken.getColour().equals("White"))
            System.out.println("Constructor with default parameters and getter of name work fine");
        else
            System.out.println("ERROR in constructor with default parameters and getter of name");

        aToken = new AnswerToken(1);
        if(aToken.getNumColour()==1)
            System.out.println("Constructor with custom parameters and getter of number work fine");
        else
            System.out.println("ERROR in constructor with custom parameters and getter of number");

        if(aToken.getColour().equals("Black"))
            System.out.println("Constructor with custom parameters and getter of name work fine");
        else
            System.out.println("ERROR in constructor with custom parameters and getter of name");
    }
}
