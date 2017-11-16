import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StubGuessToken extends StubToken{

    private static List<String> nameColours = Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Orange");

    public StubGuessToken(){


    }

    public StubGuessToken(int n){
        super(n);
    }

    public String getColour(){
        return nameColours.get(super.colour);
    }
}