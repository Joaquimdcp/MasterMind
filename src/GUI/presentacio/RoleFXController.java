package GUI.presentacio;

import domini.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RoleFXController {
    private ControllerPresentacio controller;

    public void setController(ControllerPresentacio controller) {
        this.controller = controller;
    }

    public void showDifficultyBreaker (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DifficultyFX.fxml"));
        Parent rankingParent = loader.load();
        Scene rankingScene = new Scene(rankingParent);

        DifficultyFXController difficultyFXController = loader.getController();
        difficultyFXController.setController(this.controller);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }

    public void showDifficultyMaker (ActionEvent event) throws IOException {
        this.controller.setIA(true);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DifficultyFX.fxml"));
        Parent rankingParent = loader.load();
        Scene rankingScene = new Scene(rankingParent);

        DifficultyFXController difficultyFXController = loader.getController();
        difficultyFXController.setController(this.controller);



        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
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
