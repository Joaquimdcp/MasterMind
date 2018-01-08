package GUI.presentacio;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToPlayFXController {

    private ControllerPresentacio controller;

    public void setController(ControllerPresentacio controller) {
        this.controller = controller;
    }

    public void showMenu (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent rankingParent = loader.load();
        Scene rankingScene = new Scene(rankingParent);

        MenuController menuController = loader.getController();
        menuController.setController(this.controller);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }
}
