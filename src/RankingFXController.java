package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;

public class RankingFXController {
    @FXML
    private Label user1, user2, user3, user4, user5, user6, user7, user8, user9, user10;
    @FXML
    private Label score1, score2, score3, score4, score5, score6, score7, score8, score9, score10;

    private LinkedHashMap<String, Integer> ranking;

    private List<Label> userLabels = new ArrayList<>();
    private List<Label> scoreLabels = new ArrayList<>();

    private List<String> users = new ArrayList<>();
    private List<String> scores = new ArrayList<>();

    private void fillLabelLists() {
        userLabels.add(user1);
        userLabels.add(user2);
        userLabels.add(user3);
        userLabels.add(user4);
        userLabels.add(user5);
        userLabels.add(user6);
        userLabels.add(user7);
        userLabels.add(user8);
        userLabels.add(user9);
        userLabels.add(user10);

        scoreLabels.add(score1);
        scoreLabels.add(score2);
        scoreLabels.add(score3);
        scoreLabels.add(score4);
        scoreLabels.add(score5);
        scoreLabels.add(score6);
        scoreLabels.add(score7);
        scoreLabels.add(score8);
        scoreLabels.add(score9);
        scoreLabels.add(score10);
    }
    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 10; i++) {
            userLabels.get(i).setText(users.get(i));
            scoreLabels.get(i).setText(scores.get(i));
        }
    }*/

    public void showMenu (ActionEvent event) throws IOException {
        Parent rankingParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene rankingScene = new Scene(rankingParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }
}
