package persistencia;

import domini.Game;
import domini.GuessToken;
import domini.Round;

import java.io.*;
import java.util.ArrayList;

public class GameSaver {

    public void saveGame(Game game) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(game.getCurrentUser()+".txt", "UTF-8");
        writer.println(game.getGameName());
        if(game.getRole()) writer.println("1");
        else writer.println("0");
        writer.println(Integer.toString(game.getDifficultyC().getN_colors()));
        writer.println(Integer.toString(game.getDifficultyC().getN_positions()));
        writer.println(Integer.toString(game.getDifficultyC().getN_rounds()));
        writer.println(Integer.toString(game.getnHints()));
        writer.println(Integer.toString(game.getHintsUsed()));
        writer.println(Long.toString(game.getTime()));
        writer.println(Integer.toString(game.getCurrentRoundNumber()));
        int nRounds = game.getCurrentRoundNumber();
        int nPosi =  game.getDifficultyC().getN_positions();
        String auxG = "";
        for (int i =0; i<nPosi; ++i){
            auxG += game.getSolution().get(i).getColour()+" ";
        }
        writer.println(auxG);
        for(int i=0; i<nRounds; ++i){
            auxG="";
            for (int j=0; j<nPosi;++j){
                auxG += game.getRound(i).getTokensGuess().get(i).getColour()+" ";
            }
            writer.println(auxG);
        }
        writer.close();
    }

    public boolean doesSavedExist(String user){
        File f = new File(user+".txt");
        if(f.exists() && !f.isDirectory()) {
            return true;
        }
        return false;
    }
    public Game loadGame(String user){
        Game game;
        try(BufferedReader br = new BufferedReader(new FileReader(user+".txt"))){
            String name = br.readLine();
            if(br.readLine()=="1") {
                game = new Game(true, user);
            } else game = new Game(false, user);
            game.setGameName(name);
            int nColors = Integer.parseInt(br.readLine());
            int nPositions = Integer.parseInt(br.readLine());
            int nRounds = Integer.parseInt(br.readLine());
            int nHints = Integer.parseInt(br.readLine());
            game.initGame(nColors, nPositions, nRounds, nHints);
            int hintsUsed = Integer.parseInt(br.readLine());
            long time = Long.parseLong(br.readLine());
            int currentR = Integer.parseInt(br.readLine());
            game.setterOfLoad(hintsUsed,time, currentR);
            String[] solu = br.readLine().split(" ");
            ArrayList<GuessToken> solution = new ArrayList<GuessToken>();
            for (int i=0; i<solu.length; ++i){
                solution.add(new GuessToken(solu[i]));
            }
            game.setSolution(solution);
            ArrayList<GuessToken> guess = new ArrayList<GuessToken>();
            ArrayList<Round> rounds = new ArrayList<Round>();
            for(int i=0; i<nRounds; ++i){
                String[] gS=br.readLine().split(" ");
                for (int j=0; j< gS.length;++j){
                    guess.add(new GuessToken(gS[j]));
                }
                Round aux = new Round();
                aux.setGuess(guess, nColors, nPositions);
                aux.setAnswer(solution);
                rounds.add(aux);
            }

            File f = new File(user+".txt");
            f.delete();
            return game;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Game();
    }
}
