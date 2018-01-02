package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomFXController implements Initializable{
    @FXML
    private ChoiceBox colors, rounds;

    private ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colors.setItems(list);
        colors.setValue(6);
        rounds.setItems(list);
        rounds.setValue(10);
    }

    public void showDifficulty(ActionEvent event) throws IOException {
        Parent rankingParent = FXMLLoader.load(getClass().getResource("DifficultyFX.fxml"));
        Scene rankingScene = new Scene(rankingParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }
}
