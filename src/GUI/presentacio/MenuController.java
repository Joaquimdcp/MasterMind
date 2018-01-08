package GUI.presentacio;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private ControllerPresentacio controller;

    public void setController(ControllerPresentacio controller) {
        this.controller = controller;
    }

    public void newGamePressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RoleFX.fxml"));
        Parent SceneParent = loader.load();
        Scene SceneToCharge = new Scene(SceneParent);

        RoleFXController roleFXController = loader.getController();
        roleFXController.setController(this.controller);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void loadGamePressed(ActionEvent actionEvent) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("RoleFX.fxml"));
        Scene SceneToCharge = new Scene(SceneParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void howToPlayPressed(ActionEvent actionEvent) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("HowToPlayFX.fxml"));
        Scene SceneToCharge = new Scene(SceneParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void rankingPressed(ActionEvent actionEvent) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("RankingFX.fxml"));
        Scene SceneToCharge = new Scene(SceneParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void logOutPressed(ActionEvent actionEvent) throws IOException {
        Parent SceneParent = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene SceneToCharge = new Scene(SceneParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(SceneToCharge);
        window.show();
    }

    public void exitPressed(ActionEvent actionEvent) {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
