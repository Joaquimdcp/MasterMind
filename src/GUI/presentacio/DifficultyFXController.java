package GUI.presentacio;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DifficultyFXController {

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

    public void easyGame (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent rankingParent = loader.load();
        Scene rankingScene = new Scene(rankingParent);

        MenuController menuController = loader.getController();
        menuController.setController(this.controller);

        controller.initGame(false, 4, 4, 10, 6);
        /*
        BoardFXController boardFXController = loader.getController();
        boardFXController.setController(this.controller);*/

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }

    public void mediumGame (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent rankingParent = loader.load(); //BoardFX.fxml
        Scene rankingScene = new Scene(rankingParent);

        MenuController menuController = loader.getController();
        menuController.setController(this.controller);

        controller.initGame(false, 6, 6, 10, 4);
        /*
        BoardFXController boardFXController = loader.getController();
        boardFXController.setController(this.controller);*/

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }

    public void hardGame (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent rankingParent = loader.load(); //BoardFX.fxml
        Scene rankingScene = new Scene(rankingParent);

        MenuController menuController = loader.getController();
        menuController.setController(this.controller);

        controller.initGame(false, 6, 8, 10, 2);
        /*
        BoardControllerFX boardFXController = loader.getController();
        boardFXController.setController(this.controller); */

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }

    public void showCustomDifficultySelection (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomFX.fxml"));
        Parent rankingParent = loader.load(); //BoardFX.fxml
        Scene rankingScene = new Scene(rankingParent);

        CustomFXController customFXController = loader.getController();
        customFXController.setController(this.controller);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }

}
