package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public void showRanking(ActionEvent event) throws IOException {
        Parent rankingParent = FXMLLoader.load(getClass().getResource("RankingFX.fxml"));
        Scene rankingScene = new Scene(rankingParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }

    public void showDifficulty(ActionEvent event) throws IOException {
        Parent rankingParent = FXMLLoader.load(getClass().getResource("DifficultyFX.fxml"));
        Scene rankingScene = new Scene(rankingParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }

    public void showHowToPlay(ActionEvent event) throws IOException {
        Parent rankingParent = FXMLLoader.load(getClass().getResource("HowToPlayFX.fxml"));
        Scene rankingScene = new Scene(rankingParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }
}
