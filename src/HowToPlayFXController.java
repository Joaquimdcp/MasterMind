package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToPlayFXController {
    public void showMenu (ActionEvent event) throws IOException {
        Parent rankingParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene rankingScene = new Scene(rankingParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }
}
