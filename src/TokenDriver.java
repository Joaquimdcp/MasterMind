public class TokenDriver {
    public static void main(String[] args) {
        Token token = new Token();
        if(token.getNumColour()==0)
            System.out.println("Constructor with default parameters and getter work fine");
        else
            System.out.println("ERROR in constructor with default parameters and getter");
        token = new Token(10);
        if(token.getNumColour()==10)
            System.out.println("Constructor with custom parameters and getter work fine");
        else
            System.out.println("ERROR in constructor with custom parameters and getter");
        Token token2 = new Token(5);
        if(!token.equalsToken(token2)){
            token2 = new Token(10);
            if(token.equalsToken(token2))
                System.out.println("Function equalsToken() works fine");
            else
                System.out.println("ERROR in function equalsToken");
        }
        else
            System.out.println("ERROR in function equalsToken()");

    }
}
